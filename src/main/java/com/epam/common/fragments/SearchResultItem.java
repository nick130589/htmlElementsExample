package com.epam.common.fragments;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

@FindBy(className = "item")
public class SearchResultItem extends HtmlElement {
    @FindBy(className = "catalog-block-head")
    @Name("Catalog block head")
    private TextBlock itemName;

    public String getItemName() {
        return itemName.getText();
    }
}
