package com.epam.common.pages;

import com.epam.common.fragments.SearchForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static ru.yandex.qatools.htmlelements.matchers.common.DoesElementExistMatcher.exists;

public class HomePage extends BasePage {
    @Name("Categories")
    @FindBy(className = ".page-cloud-row")
    private HtmlElement categoriesSection;

    private SearchForm searchForm;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        searchForm.inputTextToSearchField(text);
        searchForm.clickSearchButton();
    }

    public WebElement getLoadableElement() {
        return categoriesSection;
    }
}
