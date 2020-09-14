package com.epam.common.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public abstract class BasePage implements Page {
    protected String PAGE_URL = "http://pn.com.ua/";
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        HtmlElementLoader.populate(this, this.driver);
//        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(this.driver)), this);
    }

    public void openPage() {
        driver.get(PAGE_URL);
    }

    public boolean isOnPage() {
        return driver.getCurrentUrl().equals(PAGE_URL);
    }

    public boolean isPageLoaded() {
        return getLoadableElement().isDisplayed();
    }
}
