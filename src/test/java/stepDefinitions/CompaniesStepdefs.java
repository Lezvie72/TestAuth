package stepDefinitions;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Тогда;
import pages.CompaniesPage;

public class CompaniesStepdefs {

    private final CompaniesPage companiesPage = new CompaniesPage();

    @Дано("пользователь находится на страница Компании")
    public void onPage() {
        companiesPage.onPage();
    }

    @Тогда("отображается страница Компании")
    public void isDisplayed() {
        companiesPage.pageIsDisplayed();
    }
}
