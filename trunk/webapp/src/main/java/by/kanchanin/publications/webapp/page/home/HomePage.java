package by.kanchanin.publications.webapp.page.home;

import java.util.List;

import by.kanchanin.publications.datamodel.Periodical;
import by.kanchanin.publications.services.PeriodicalService;
import by.kanchanin.publications.webapp.app.BasicAuthenticationSession;
import by.kanchanin.publications.webapp.page.BaseLayout;
import by.kanchanin.publications.webapp.page.login.LoginPage;


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

	

	protected IModel<String> getPageTitle() {
		return new ResourceModel("p.home.title");
	}
	
	
}