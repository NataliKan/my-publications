package by.kanchanin.publications.webapp.periodical;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.apache.wicket.bean.validation.PropertyValidator;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.markup.html.form.TextField;

import by.kanchanin.publications.datamodel.Periodical;
import by.kanchanin.publications.services.PeriodicalService;
import by.kanchanin.publications.webapp.page.BaseLayout;
import by.kanchanin.publications.webapp.page.home.HomePage;

public class PeriodicalEditPage extends BaseLayout {
	
	@Inject
	private PeriodicalService periodicalService;

	public PeriodicalEditPage(final Periodical periodical) {
		super();
		Form<Periodical> form = new Form<Periodical>("form", new CompoundPropertyModel<Periodical>(periodical));

		final TextField<String> tfName = new TextField<String>("name");
		tfName.add(new PropertyValidator<String>());
		form.add(tfName);

		final TextField<BigDecimal> tfPrice = new TextField<BigDecimal>("basePrice");
		tfPrice.add(new PropertyValidator<BigDecimal>());
		tfPrice.setLabel(new ResourceModel("p.productEdit.price"));


		form.add(tfPrice);

		final CheckBox chBAvailable = new CheckBox("available");
		chBAvailable.add(new PropertyValidator<Boolean>());
		form.add(chBAvailable);

		form.add(new SubmitLink("sumbit-link") {
			@Override
			public void onSubmit() {
				super.onSubmit();
				periodicalService.updatePeriodical(periodical);

				HomePage page = new HomePage();

				page.error("Custom error");
				page.info("Custom info");
				page.warn("Custom warn");

				setResponsePage(page);
			}

			@Override
			public void onError() {

				super.onError();
			}
		});

		add(form);

	}

}
