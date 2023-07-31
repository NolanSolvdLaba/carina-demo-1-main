package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AccountPageBase extends AbstractPage {
    public AccountPageBase(WebDriver driver) {
        super(driver);

    }

    public ExtendedWebElement getUserAccount() {
        return null;
    }

}
