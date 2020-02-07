package stepDefinitions;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import pages.CompaniesPage;
import pages.RegisterPage;

public class RegisterStepdefs {

    private final RegisterPage registerPage = new RegisterPage();

    @Дано("пользователь находится на Странице регистрации")
    public void onPage() {
        registerPage.onPage();
    }

    @Тогда("отображается стартовая страница")
    public void isDisplayed() {
        registerPage.pageIsDisplayed();
    }

    @И("пользователь вводит Имя \"([^\"]*)\"")
    public void inputName(String nameUser) {
        registerPage.inputName(nameUser);
    }

    @И("пользователь вводит телефон \"([^\"]*)\"")
    public void inputPhone(String phoneNumber) {
        registerPage.inputPhone(phoneNumber);
    }

    @Когда("пользователь кликает Далее")
    public void clickNext() {
        registerPage.clickNext();
    }

    @Тогда("появляется поле ввода кода из СМС")
    public void checkInputSmsField() {
        registerPage.checkInputSmsField();
    }

    @И("пользователь вводит неверный код смс")
    public void typeWrongSMScode() {
        registerPage.typeWrongSMScode();
    }

    @Когда("пользователь кликает Подтвердить")
    public void clickConfirm() {
        registerPage.clickConfirm();
    }

    @Тогда("появляется сообщение об ошибке")
    public void checkErrorMessage() {
        registerPage.checkErrorMessage();
    }

    @Когда("пользователь кликает Вход в JShop")
    public void clickEnterToJShop() {
        registerPage.clickEnterToJShop();
    }

    @Тогда("появляется диалог авторизации")
    public void checkShowLogin() {
        registerPage.checkShowLogin();
    }

    @И("пользователь вводит логин \"([^\"]*)\"")
    public void typeLogin(String login) {
        registerPage.typeLogin(login);
    }

    @И("пользователь вводит пароль \"([^\"]*)\"")
    public void typePassword(String pass) {
        registerPage.typePassword(pass);
    }

    @Когда("пользователь кликает Войти")
    public void clickEnter() {
        registerPage.clickLoginBtn();
    }
}
