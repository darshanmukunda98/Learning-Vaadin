package com.vaadin.training.forms.exercises.ex1;

import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.training.forms.exercises.MainLayout;

@Route(value = Validation.ROUTE, layout = MainLayout.class)
@RouteAlias(value="", layout = MainLayout.class)
public class Validation extends VerticalLayout implements HasSize{

	private static final long serialVersionUID = 1L;

	public static final String ROUTE = "ex1";
	public static final String TITLE = "Validation";

	public Validation() {
		// TODO Create a bean class to contain the data with fields, getters and
		// setters for each value needed to bind the three TextFields.

		// TODO Create a Binder typed for the bean class you just created

		// TODO Bind field and add validation to check that the input is a
		// proper mail address.
		final EmailField emailField = new EmailField("Email validator");

		// TODO Bind field and add validation which accepts strings between 1
		// and 10 in length
		final TextField stringField = new TextField("String length validator");

		// TODO Bind field and add a custom Validator which only accepts
		// "Vaadin"
		final TextField vaadinField = new TextField("Vaadin validator");

		add(emailField, stringField, vaadinField);

	}

}