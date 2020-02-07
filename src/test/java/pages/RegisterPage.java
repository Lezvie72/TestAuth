package pages;

import PagesUrls.PagesUrls;
import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;


public class RegisterPage extends Base {

    @FindBy(css = "div.form-card")
    private WebElement formCard;

    // форма регистрации
	@FindBy(css="input[name=\"firstName\"]")
	private WebElement firstName;

	@FindBy(css="input[name=\"lastName\"]")
	private WebElement lastName;

	@FindBy(css="input[name=\"phone\"]")
	private WebElement phone;

	@FindBy(css="button#sign-up-1st-step-submit")
	private WebElement firstStepBtn;

	@FindBy(css="div.offset-top a")
	private WebElement enterToShopBtn;

	@FindBy(css="input#confirmationCode")
	private WebElement smsField;

	@FindBy(css="button#sign-up-phone-code-submit")
	private WebElement confirmBtn;

    // форма логина
    @FindBy(css="input[name=\"login\"]")
    private WebElement loginField;

    @FindBy(css="input[name=\"password\"]")
    private WebElement passField;

    @FindBy(css="button#sign-in-login-submit")
    private WebElement loginBtn;


    @FindBy(css="div.notification.error")
    private WebElement notificationError;

    private final List<WebElement> elements;

    public RegisterPage() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(formCard, firstName, lastName, phone, firstStepBtn, enterToShopBtn);
    }

    public void onPage() {
        driver.get(PagesUrls.authSignUp());
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(elements);
    }

    public void inputName(String nameUser) {
        typeIntoField(nameUser, firstName);
    }

    public void inputPhone(String phoneNumber) {
        typeIntoField(phoneNumber, phone);
    }

    public void clickNext() {
        waitForVisibility(firstStepBtn);
        firstStepBtn.click();
    }

    public void checkInputSmsField() {
        waitForAjaxElementIsVisible(smsField);
        waitForAjaxElementIsVisible(confirmBtn);
    }

    public void typeWrongSMScode() {
        typeIntoField("1234", smsField);
    }

    public void clickConfirm() {
        waitForVisibility(confirmBtn);
        confirmBtn.click();
    }

    public void checkErrorMessage(){
        waitForAjaxElementIsVisible(notificationError);
        waitForInvisibility(notificationError);
    }

    public void clickEnterToJShop() {
        waitForVisibility(enterToShopBtn);
        enterToShopBtn.click();
    }
    public void checkShowLogin() {
        waitForAjaxElementIsVisible(loginField);
        waitForAjaxElementIsVisible(passField);
        waitForAjaxElementIsVisible(loginBtn);
    }

    public void typeLogin(String login) {
        typeIntoField(login, loginField);
    }

    public void typePassword(String pass) {
        typeIntoField(pass, passField);
    }

    public void clickLoginBtn(){
        waitForVisibility(loginBtn);
        loginBtn.click();
    }
}
