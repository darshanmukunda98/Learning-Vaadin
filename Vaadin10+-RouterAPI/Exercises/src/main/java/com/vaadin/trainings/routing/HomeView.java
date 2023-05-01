package com.vaadin.trainings.routing;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;

public class HomeView extends Composite<Div> implements HasComponents {

	public HomeView() {
		add(new H2("Welcome to lottery!"));
	}
}
