package com.zebrunner.carina.demo.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractPage {

//    @FindBy(xpath = "//*[@id=\"login-active\"]/span")
//    private ExtendedWebElement loginIcon;

    @FindBy(xpath = "/html/body/header/div/div/div[3]/a[7]/i")
    private ExtendedWebElement loginIcon;

    @FindBy(id = "login-popup2")
    private ExtendedWebElement loginPopup;

    @FindBy(id = "email")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "/html/body/header/div/div/div[3]/span[3]/form/input[3]")
    private ExtendedWebElement passwordInput;

    @FindBy(id = "/html/body/header/div/div/div[3]/span[3]/form/input[4]")
    private ExtendedWebElement loginButton;

    public Header(WebDriver driver) {
        super(driver);
    }

    public void clickLoginIcon() {
        loginIcon.click();
    }

    public boolean isLoginPopupDisplayed() {
        return loginPopup.isElementPresent();
    }

    public void typeEmail(String email) {
        emailInput.type(email);
    }

    public void typePassword(String password) {
        passwordInput.type(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

}
