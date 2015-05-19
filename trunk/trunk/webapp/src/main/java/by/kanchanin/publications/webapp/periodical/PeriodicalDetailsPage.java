package by.kanchanin.publications.webapp.periodical;

import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.PageCreator;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.markup.html.link.Link;

import by.kanchanin.publications.datamodel.Periodical;
import by.kanchanin.publications.webapp.page.BaseLayout;

public class PeriodicalDetailsPage extends BaseLayout {
	
	private Periodical periodical;
	private PageCreator pageCreator;

	public PeriodicalDetailsPage(Periodical periodical, PageCreator pageCreator) {
		super();
		this.periodical = periodical;
		this.pageCreator = pageCreator;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new PeriodicalDetailsPanel("panel-product", periodical, false));

		add(new Link("back-link") {
			@Override
			public void onClick() {
				setResponsePage(pageCreator.createPage());
			}
		});

		if (System.currentTimeMillis() % 2 == 0) {
			Fragment fragment = new Fragment("fragmentId", "green-fragment", PeriodicalDetailsPage.this);
			add(fragment);
		} else {
			add(new Fragment("fragmentId", "red-fragment", PeriodicalDetailsPage.this));
		}

	}


}
