package com.zebrunner.carina.demo.gui.components;

import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginComponent extends AbstractUIObject {

    @FindBy(id="email")
    private ExtendedWebElement userEmail;

    @FindBy(id="upass")
    private ExtendedWebElement userPassword;

    @FindBy(id="nick-submit")
    private ExtendedWebElement submitButton;

    public LoginComponent(WebDriver driver, SearchContext sc) {
        super(driver, sc);
    }

    public boolean isEmailInputPresent(){
        return userEmail.isElementPresent();
    }

    public void loginFlow(String email, String password){
        userEmail.type(email);
        userPassword.type(password);
        submitButton.click();
    }

    private LoginPageBase initPage(WebDriver driver, Class<LoginPageBase> loginPageBaseClass) {
        return null;
    }
}
