package by.kanchanin.publications.webapp.periodical;

import java.util.Iterator;

import javax.inject.Inject;
import javax.persistence.metamodel.SingularAttribute;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByBorder;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import by.kanchanin.publications.datamodel.Periodical;
import by.kanchanin.publications.datamodel.Periodical_;
import by.kanchanin.publications.services.PeriodicalService;
import by.kanchanin.publications.webapp.page.home.HomePage;

public class PeriodicalListPanel extends Panel {
	
	@Inject
	private PeriodicalService periodicalService;

	public PeriodicalListPanel(String id) {
		super(id);
		setOutputMarkupId(true);
		PeriodicalDataProvider productDataProvider = new PeriodicalDataProvider();

		final WebMarkupContainer tableBody = new WebMarkupContainer("wrapper-body") {
			@Override
			protected void onBeforeRender() {
				super.onBeforeRender();
				add(new AttributeModifier("title", new Model(System.currentTimeMillis())));
			}
		};

		tableBody.add(new AttributeModifier("title", new Model(System.currentTimeMillis())));

		tableBody.setOutputMarkupId(true);
		add(tableBody);

		DataView<Periodical> dataView = new DataView<Periodical>("list", productDataProvider, 3) {
			@Override
			protected void populateItem(Item<Periodical> item) {
				final Periodical periodical = item.getModelObject();
				item.add(new Label("name"));
				item.add(new Label("price"));
				item.add(new CheckBox("available").setEnabled(false));

				item.add(new Link<Void>("edit") {
					@Override
					public void onClick() {
						setResponsePage(new PeriodicalEditPage(periodical));
					}
				});

				item.add(new Link<Void>("remove") {
					@Override
					public void onClick() {
						boolean isProtectedPtroduct = Boolean.FALSE;
						if (isProtectedPtroduct) {
							HomePage page = new HomePage();
							page.info("can't not deleted because of...");
							setResponsePage(page);
						} else {
							periodicalService.delete(periodical);
							HomePage page = new HomePage();
							page.info("product deleted!!!!");
							setResponsePage(page);
						}

					}
				});

				item.add(new AjaxLink<Void>("remove-ajax") {
					@Override
					public void onClick(AjaxRequestTarget target) {
						periodicalService.delete(periodical);
						target.add(PeriodicalListPanel.this);
					}

				});

			}
		};

		tableBody.add(dataView);

		add(new MyPagingNavigator("paging", dataView));

		add(new OrderByBorder<SingularAttribute<Periodical, ?>>("sortByName", Periodical_.title, productDataProvider));
		add(new OrderByBorder<SingularAttribute<Periodical, ?>>("sortByPrice", Periodical_.price, productDataProvider));

	}

	private class PeriodicalDataProvider extends SortableDataProvider<Periodical, SingularAttribute<Periodical, ?>> {

		public PeriodicalDataProvider() {
			super();
			setSort(Periodical_.title, SortOrder.ASCENDING);
		}

		@Override
		public Iterator<? extends Periodical> iterator(long first, long count) {

			SingularAttribute<Periodical, ?> sortParam = getSort().getProperty();
			SortOrder propertySortOrder = getSortState().getPropertySortOrder(sortParam);
			boolean ascending = SortOrder.ASCENDING.equals(propertySortOrder);
			return periodicalService.getAllPeriodicals(sortParam, ascending, (int) first, (int) count).iterator();
		}


		@Override
		public IModel<Periodical> model(Periodical periodical) {
			return new CompoundPropertyModel<Periodical>(periodical);
		}

		@Override
		public long size() {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	
	

}
