package com.zebrunner.carina.demo.gui.pages.common.SauceDemo;

import com.azure.core.http.rest.Page;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class SauceDemoHomePageBase extends AbstractPage {

    public SauceDemoHomePageBase(WebDriver driver){
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public void loginFlow(String correctUserName, String correctPassword) {
    }
}
