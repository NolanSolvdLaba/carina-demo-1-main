package com.zebrunner.carina.demo.gui.pages.common.SauceDemo.SauceComponents;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends AbstractUIObject {

    @FindBy(id="user-name")
    private ExtendedWebElement userEmail;

    @FindBy(id="password")
    private ExtendedWebElement userPassword;

    @FindBy(id="login-button")
    private ExtendedWebElement loginButton;

    @FindBy(xpath="//div[contains(@class, 'error-message-container')]//h3")
    private ExtendedWebElement errorExplanation;

    public LoginForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void loginFlow(String email, String password){
        userEmail.type(email);
        userPassword.type(password);
        loginButton.click();
    }

    public ExtendedWebElement getErrorExplanation(){
        return errorExplanation;
    }

}
