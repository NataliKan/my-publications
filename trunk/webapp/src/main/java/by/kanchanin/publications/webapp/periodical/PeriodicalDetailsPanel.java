package by.kanchanin.publications.webapp.periodical;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Page;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.PageCreator;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import by.kanchanin.publications.datamodel.Periodical;
import by.kanchanin.publications.services.PeriodicalService;
import by.kanchanin.publications.webapp.page.home.HomePage;

public class PeriodicalDetailsPanel extends Panel {
	
	@Inject
	private PeriodicalService periodicalService;
	private Periodical periodical;
	private boolean isLast;

	public PeriodicalDetailsPanel(String id, Long productId, boolean isLast) {
		super(id);
		periodical = periodicalService.get(productId);
		this.isLast = isLast;
	}

	public PeriodicalDetailsPanel(String id, Periodical periodical, boolean isLast) {
		super(id);
		this.periodical = periodical;
		this.isLast = isLast;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		WebMarkupContainer liContainer = new WebMarkupContainer("wrapper-li");
		if (isLast) {
			liContainer.add(AttributeModifier.append("class", "last"));
		}
		add(liContainer);

		WebMarkupContainer hContaienr = new WebMarkupContainer("wrapper-h");
		liContainer.add(hContaienr);

		hContaienr.add(new Label("name", new Model<String>(periodical.getTitle())));
		liContainer.add(new Label("price", new Model<BigDecimal>(periodical.getPrice())));
		liContainer.add(new Label("priceWithoutModel", periodical.getPrice()));

		liContainer.add(new Link<Void>("linkTodetails") {

			@Override
			public void onClick() {
				setResponsePage(new PeriodicalDetailsPage(periodical, new PageCreator() {

				@Override
					public Page createPage() {
						return new HomePage();
					}
				}));
			}
		});

		liContainer.add(new Link<Void>("linkToEdit") {

			@Override
			public void onClick() {
				setResponsePage(new PeriodicalEditPage(periodical));
			}
		});

	}

}
