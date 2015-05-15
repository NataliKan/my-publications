package by.kanchanin.publications.webapp.page.login.component;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.http.handler.RedirectRequestHandler;

import by.kanchanin.publications.datamodel.UserAccount;
import by.kanchanin.publications.webapp.app.BasicAuthenticationSession;
import by.kanchanin.publications.webapp.app.WicketWebApplication;
import by.kanchanin.publications.webapp.page.login.LoginPage;

public class LoginLogoutPanel extends Panel {
	
	public LoginLogoutPanel(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new Link("login-btn") {
			@Override
			protected void onConfigure() {
				super.onConfigure();
				boolean isLoginPage = LoginPage.class.equals(getPage().getClass());
				boolean isLogged = BasicAuthenticationSession.get().isSignedIn();

				setVisible(!(isLogged || isLoginPage));
			}

			@Override
			public void onClick() {
				setResponsePage(new LoginPage());
			}
		});

		add(new Link("logout-btn") {
			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(BasicAuthenticationSession.get().isSignedIn());
			}

			@Override
			public void onClick() {
				final HttpServletRequest servletReq = (HttpServletRequest) getRequest().getContainerRequest();
				servletReq.getSession().invalidate();
				getSession().invalidate();
				getRequestCycle().scheduleRequestHandlerAfterCurrent(new RedirectRequestHandler(WicketWebApplication.LOGIN_URL));

			}
		});

		UserAccount user = BasicAuthenticationSession.get().getUser();
		add(new Label("userName", new Model(user != null ? user.getEmail() : null)));

	}

}
