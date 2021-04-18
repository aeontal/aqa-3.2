package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataGenerator;


import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");
    private SelenideElement titleError = $(withText("Ошибка"));


    public VerifiyPage validLogin(String login, String password) {
        loginField.setValue(login);
        passwordField.setValue(password);
        loginButton.click();
        return new VerifiyPage();
    }


    public void invalidLogin(){
        loginField.setValue(DataGenerator.getInvalidLoginUser());
        passwordField.setValue(DataGenerator.getPasswordUser());
        loginButton.click();
        titleError.shouldBe(Condition.visible);
    }

    public void invalidPassword(){
        loginField.setValue(DataGenerator.getLoginUser());
        passwordField.setValue(DataGenerator.getInvalidPasswordUser());
        loginButton.click();
        titleError.shouldBe(Condition.visible);

    }

    public void error(){
        titleError.shouldBe(Condition.visible);
    }





}
