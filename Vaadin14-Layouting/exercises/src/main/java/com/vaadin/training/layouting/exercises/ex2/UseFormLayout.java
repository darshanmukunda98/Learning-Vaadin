package com.vaadin.training.layouting.exercises.ex2;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.Route;
import com.vaadin.training.layouting.exercises.MainLayout;

import java.awt.*;

@Route(value = UseFormLayout.ROUTE, layout = MainLayout.class)
public class UseFormLayout extends VerticalLayout {
    public static final String ROUTE = "ex2";
    public static final String TITLE = "Exercise 2";

    public UseFormLayout(){
        setSizeFull();
        FormLayout formLayout = new FormLayout();

        TextField firstname = new TextField("First Name");
        firstname.setWidth("100%");
        formLayout.add(firstname);

        TextField lastName = new TextField("Last Name");
        lastName.setWidth("100%");
        formLayout.add(lastName);

        TextField email = new TextField("Email");
        email.setWidth("100%");

        //email.getStyle().set("colspan","2");
        formLayout.add(email);
        formLayout.setColspan(email,2);

        FlexLayout phoneLayout = new FlexLayout();
        phoneLayout.setAlignItems(Alignment.END);
        phoneLayout.setWidthFull();
        TextField phone = new TextField("Phone");

        phoneLayout.add(phone, new Checkbox("Do not Call"));
        phoneLayout.expand(phone);
        formLayout.add(phoneLayout);
        formLayout.setColspan(phoneLayout,2);

        FlexLayout passwordLayout = new FlexLayout();
        passwordLayout.getStyle().set("flex-direction","column");
       // passwordLayout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);

        PasswordField password = new PasswordField("Password");
        password.setWidthFull();
        passwordLayout.add(password);

        PasswordField repeatPassword = new PasswordField("Repeat Password");
        repeatPassword.setWidthFull();
        passwordLayout.add(repeatPassword);
        formLayout.add(passwordLayout);
        add(formLayout);
    }
}
