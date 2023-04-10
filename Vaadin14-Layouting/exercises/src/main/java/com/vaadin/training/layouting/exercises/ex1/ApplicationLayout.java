package com.vaadin.training.layouting.exercises.ex1;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import com.vaadin.training.layouting.exercises.MainLayout;



@Route(value = ApplicationLayout.ROUTE, layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class ApplicationLayout extends VerticalLayout implements HasUrlParameter<String> {

	private static final long serialVersionUID = 1L;

	public static final String ROUTE = "ex1";
	public static final String TITLE = "Exercise 1";

	private final HorizontalLayout layout;
	private Div navigation;
	private Div content;

	public ApplicationLayout() {
		setSizeFull();
		setPadding(false);
		setSpacing(false);
		setDefaultHorizontalComponentAlignment(Alignment.STRETCH);

		final Div header = new Div();
		header.getStyle().set("flexShrink","0");
		header.setText("This is the header. My height is 150 pixels");
		header.setClassName("header");
		header.setHeight("150px");

		layout = new HorizontalLayout();
		layout.setHeight("100%");
		layout.getStyle().set("flex-grow","1");
		layout.setSpacing(false);
		createTextLayout();

		final Div footer = new Div();
		footer.setText("This is the footer area. My height is 100 pixels");
		footer.setClassName("footer");
		footer.setHeight("100px");
		footer.getStyle().set("flexShrink","0");

		add(header, layout, footer);
		expand(layout);
	}
	private void createTextLayout(){
		navigation = new Div();
		navigation.setClassName("navigation");
		navigation.setWidth("25%");
		navigation.getElement().getStyle().set("flexShrink","0");
		navigation.setText("This is the navigation area. My width is 25% of the ApplicationLayout.");

		content = new Div();
		content.setHeightFull();
		content.getStyle().set("display", "flex");
		content.setClassName("content");
		content.setText("This is the content area");
		content.getStyle().set("alignContent","start");

		layout.add(navigation,content);
		layout.expand(content);
		layout.setDefaultVerticalComponentAlignment(Alignment.STRETCH);

	}

	/**
	 * Ignore this method for now.
	 *
	 * @return
	 */
	private Div createBlock() {
		final Div button = new Div();
		button.setText("Block");
		button.getStyle().set("background", "white");
		button.setHeight("100px");
		button.setWidth("100px");
		button.getStyle().set("margin", "2px");
		return button;
	}

	@Override
	public void setParameter(BeforeEvent beforeEvent,@OptionalParameter String parameter) {
		if("scroll".equals(parameter)){
			updateUIForScroll();
		}
	}
	private void updateUIForScroll(){
		final Button add = new Button("Add",e->{
			content.add(createBlock());
		});
		navigation.setText(null);
		content.setText(null);
		navigation.add(add);
		makeContentScrollable();
	}
	private void makeContentScrollable(){
		content.getStyle().set("flexWrap","wrap");
		content.getStyle().set("overflowY","auto");
	}
}