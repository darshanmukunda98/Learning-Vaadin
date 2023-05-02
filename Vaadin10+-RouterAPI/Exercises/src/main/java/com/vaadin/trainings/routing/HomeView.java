package com.vaadin.trainings.routing;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route("home")
@RouteAlias("")
public class HomeView extends Composite<VerticalLayout> implements HasComponents {

	public HomeView() {
		add(new H2("Welcome to lottery!"));
	}
}
