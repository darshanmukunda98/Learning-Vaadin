package com.vaadin.training.forms.exercises.ex2;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.PropertyId;

public class ProductFormLayout extends FormLayout {
    @PropertyId("name")
    final private TextField nameField = new TextField("Name");
    final private TextField priceField = new TextField("Price");
    final private DatePicker availableField = new DatePicker("Available");

    public TextField getNameField() {
        return nameField;
    }

    public TextField getPriceField() {
        return priceField;
    }

    public DatePicker getAvailableField() {
        return availableField;
    }

    public ProductFormLayout() {
        add(nameField,priceField,availableField);
    }
}
