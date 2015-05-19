package by.kanchanin.publications.webapp.page.home;

import java.util.List;

import by.kanchanin.publications.datamodel.Periodical;
import by.kanchanin.publications.services.PeriodicalService;
import by.kanchanin.publications.webapp.app.BasicAuthenticationSession;
import by.kanchanin.publications.webapp.page.BaseLayout;
import by.kanchanin.publications.webapp.page.login.LoginPage;
import by.kanchanin.publications.webapp.periodical.PeriodicalDetailsPanel;
import by.kanchanin.publications.webapp.periodical.PeriodicalEditPage;
import by.kanchanin.publications.webapp.periodical.PeriodicalListPanel;

import javax.inject.Inject;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.resource.PackageResourceReference;

public class HomePage extends BaseLayout {

//	@Inject
//	private PeriodicalService periodicalService;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		Injector.get().inject(this);

		if (!BasicAuthenticationSession.get().isSignedIn()) {
			setResponsePage(LoginPage.class);
			return;
		}

//		final List<Periodical> allPeriodicals = periodicalService.getAllPeriodicals();
//
//		add(new ListView<Periodical>("details-panel", allPeriodicals) {
//			@Override
//			protected void populateItem(ListItem<Periodical> item) {
//				Periodical periodical = item.getModelObject();
//				item.add(new Label("id", periodical.getId()).setVisible(false));
//				boolean isLast = (allPeriodicals.size() - 1) == item.getIndex();
//				item.add((new PeriodicalDetailsPanel("product-panel", periodical, isLast)));
//
//			}
//
//		});
//
//		add(new Link("create-new-product-link") {
//			@Override
//			public void onClick() {
//				setResponsePage(new PeriodicalEditPage(new Periodical()));
//			}
//		});
//		add(new PeriodicalListPanel("products-list"));
	}

	protected IModel<String> getPageTitle() {
		return new ResourceModel("p.home.title");
	}
	
	
}