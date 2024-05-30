package testRunner;

import org.testng.annotations.Test;
import pages.SearchFunctionalityPage;

public class SearchFunctionalityTestRunner extends BaseTestRunner {
    SearchFunctionalityPage searchFunctionalityPage = new SearchFunctionalityPage();

    @Test
    public void searchFunctionality(){
        searchFunctionalityPage.searchingAndValidatingItem();
    }
}
