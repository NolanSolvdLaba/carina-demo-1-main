package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getLoginResultStatement() {
        return null;
    }

    public ExtendedWebElement getLoginSuccessfulResponse() {
        return null;
    }

    public ExtendedWebElement getLoginResult() {
        return null;
    }

    public ExtendedWebElement getUnsuccessfulLoginExplanation() {
        return null;
    }


}
