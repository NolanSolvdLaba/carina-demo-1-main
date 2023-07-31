package com.zebrunner.carina.demo.gui.pages.desktop;

import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(css=".normal-text.res-success")
    private ExtendedWebElement loginSuccessfulResponse;

    @FindBy(xpath="//div[contains(@class, 'res-error')]/p")
    private ExtendedWebElement unsuccessfulLoginExplanation;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageURL("/login.php3");
    }

    public ExtendedWebElement getLoginSuccessfulResponse(){
        return loginSuccessfulResponse;
    }
    public ExtendedWebElement getUnsuccessfulLoginExplanation(){
        return unsuccessfulLoginExplanation;
    }

}
