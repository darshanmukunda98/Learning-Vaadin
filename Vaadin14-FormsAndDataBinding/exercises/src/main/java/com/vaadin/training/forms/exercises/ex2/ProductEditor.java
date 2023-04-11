package com.vaadin.training.forms.exercises.ex2;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;

import java.util.function.Consumer;

public class ProductEditor extends Composite<VerticalLayout> implements HasComponents, HasSize{
    public ProductEditor(Product product, Consumer<Product> productConsumer){
        // TODO Create a new class that extends a layout for editing the product
        final ProductFormLayout productEditLayout = new ProductFormLayout();
        // TODO Create a Binder and bind it together with the input fields
        // on the editor component you created. Note that after the bindings
        // have been defined, you should have the binder read the Product bean
        // given as a parameter.
        final Binder<Product> binder = new Binder<>(Product.class);
        binder.forField(productEditLayout.getPriceField())
                .withConverter(new CurrencyConverter())
                .bind(Product::getPrice,Product::setPrice);
        binder.forField(productEditLayout.getAvailableField())
                .bind(Product::getAvailable,Product::setAvailable);
        binder.bindInstanceFields(productEditLayout);
        binder.readBean(product);


        final HorizontalLayout footer = new HorizontalLayout();

        // TODO Create a Save button which will write the values from the binder
        // to the Product bean. A successful save should also refresh the
        // read-only view
        footer.add(new Button("Save",buttonClickEvent -> {
            try{
                binder.writeBean(product);
            }catch(final ValidationException e){
                e.printStackTrace();
            }
        }));


        // TODO Create a Cancel button which will read the values from the
        // Product bean to the binder
        footer.add(new Button("Cancel",buttonClickEvent -> binder.readBean(product)));
        footer.getThemeList().set("spacing",true);
        add(productEditLayout,footer);
    }
}
