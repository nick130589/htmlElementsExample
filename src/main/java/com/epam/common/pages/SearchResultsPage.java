package com.epam.common.pages;

import com.epam.common.fragments.SearchResultItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static ru.yandex.qatools.htmlelements.matchers.common.DoesElementExistMatcher.exists;

public class SearchResultsPage extends BasePage {
    @FindBy(className = "catalog")
    private HtmlElement catalogSection;
    private List<SearchResultItem> searchResultItemList;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        super.PAGE_URL += "search/";
    }

    public List<String> getSearchResultItemsNames() {
        ArrayList<String> names = new ArrayList<>();
        searchResultItemList.forEach(item -> names.add(item.getItemName()));
        return names;
    }

    public WebElement getLoadableElement() {
        assertThat(catalogSection, exists());
        return catalogSection;
    }
}
