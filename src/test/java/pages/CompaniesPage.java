package pages;

import PagesUrls.PagesUrls;
import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class CompaniesPage extends Base {

	@FindBy(css="div.card")
	private WebElement card;

	@FindBy(css="div.crumb a")
	private WebElement companiesLink;

	@FindBy(css="ul.companies-list li.add")
	private WebElement addCompanyBtn;

	@FindBy(css="div.user-row a.name")
	private WebElement userLink;

	@FindBy(css="button.exit")
	private WebElement exitBtn;

	// ajax подтверждение выжода "Да"
	@FindBy(css="div.mini-modal.active button:nth-child(1)")
	private WebElement confirmYesExitBtn;

    // ajax подтверждение выжода "Нет"
	@FindBy(css="div.mini-modal.active button:nth-child(2)")
	private WebElement confirmNoExitBtn;


    private final List<WebElement> elements;

    public CompaniesPage(){
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(card, companiesLink, addCompanyBtn, userLink, exitBtn);
    }

    public void onPage() {
        driver.get(PagesUrls.companies());
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(elements);
    }

}
