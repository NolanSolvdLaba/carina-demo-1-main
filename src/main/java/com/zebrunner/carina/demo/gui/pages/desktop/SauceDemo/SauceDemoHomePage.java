package com.zebrunner.carina.demo.gui.pages.desktop.SauceDemo;

import com.zebrunner.carina.demo.gui.pages.common.SauceDemo.SauceComponents.LoginForm;
import com.zebrunner.carina.demo.gui.pages.common.SauceDemo.SauceDemoHomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SauceDemoHomePageBase.class)
public class SauceDemoHomePage extends SauceDemoHomePageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().getClass());

    @FindBy(xpath = ".//div[@class='login-box']")
    private LoginForm loginForm;


    @FindBy(xpath = ".//div[@class='login_credentials_wrap-inner']")
    private ExtendedWebElement loginFooter;

    @FindBy(id="login-button")
    private ExtendedWebElement loginButton;

    public SauceDemoHomePage(WebDriver driver){
        super(driver);
        setUiLoadedMarker(loginFooter);
    }

    @Override
    public void loginFlow(String email, String password){
        loginForm.loginFlow(email, password);
    }
}
