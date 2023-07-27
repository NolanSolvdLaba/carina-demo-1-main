/*******************************************************************************
 * Copyright 2020-2023 Zebrunner Inc (https://www.zebrunner.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zebrunner.carina.demo.gui.pages.desktop;

import com.zebrunner.carina.demo.gui.components.footer.FooterMenu;
import com.zebrunner.carina.demo.gui.pages.common.AllBrandsPageBase;
import com.zebrunner.carina.demo.gui.pages.common.BrandModelsPageBase;
import com.zebrunner.carina.demo.gui.pages.common.CompareModelsPageBase;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id="email")
    private ExtendedWebElement emailInput;

    @FindBy(id="upass")
    private ExtendedWebElement emailPassword;

    @FindBy(id="nick-submit")
    private ExtendedWebElement submitPassword;

    @FindBy(id = "login-popup2")
    public ExtendedWebElement loginForm;

    @FindBy(xpath = ".//a[@class='login-icon']")
    private ExtendedWebElement loginIcon1;

    @FindBy(xpath="//*[@id=\"body\"]/div/div[1]/div/div/div[2]/div/h1")
    private ExtendedWebElement userAccountName;

    @FindBy(xpath="//*[@id=\"body\"]/div/div[2]/h3")
    private ExtendedWebElement loginFail;

    @FindBy(xpath="//*[@id=\"body\"]/div/div[2]/p")
    private ExtendedWebElement loginFailExplanation;

    @FindBy(id = "footmenu")
    private FooterMenu footerMenu;

    @FindBy(xpath="/html/body/header/div/div/div[3]/a[6]/i")
    private ExtendedWebElement merchPage;

    @FindBy(xpath= "//*[@id=\"social-connect\"]/a[3]")
    private ExtendedWebElement instagramIcon;

    @FindBy(xpath = "//div[contains(@class, 'brandmenu-v2')]//a")
    private List<ExtendedWebElement> brandLinks;

    @FindBy(xpath="//*[@id=\"body\"]/aside/div[1]/p[1]/a")
    private ExtendedWebElement phoneFinderButton;

    @FindBy(className = "news-column-index")
    private ExtendedWebElement newsColumn;

    @FindBy(xpath = "//span[text()='All brands']//parent::a")
    private ExtendedWebElement allBrandsButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(newsColumn);
    }

    @Override
    public ExtendedWebElement getUserAccountName(){
        return userAccountName;
    }

    @Override
    public ExtendedWebElement getLoginIcon1() {
        return loginIcon1;
    }

    public boolean isLoginIconPresent() {
        LOGGER.info("Checking if login icon is present");
        return loginIcon1.isElementPresent();
    }

    public void openLoginForm() {
        LOGGER.info("opening login form");
        loginIcon1.click();
    }

    @Override
    public ExtendedWebElement getEmailInput() {
        return emailInput;
    }

    @Override
    public ExtendedWebElement getEmailPassword() {
        return emailPassword;
    }

    @Override
    public ExtendedWebElement getSubmitPassword() {
        return submitPassword;
    }

    @Override
    public ExtendedWebElement getLoginFail() {
        return loginFail;
    }

    @Override
    public ExtendedWebElement getLoginFailExplanation() {
        return loginFailExplanation;
    }

    @Override
    public FooterMenu getFooterMenu() {
        return footerMenu;
    }
    @Override
    public CompareModelsPageBase openComparePage() {
        return getFooterMenu().openComparePage();
    }

    @Override
    public BrandModelsPageBase selectBrand(String brand) {
        LOGGER.info("selecting '" + brand + "' brand...");
        for (ExtendedWebElement brandLink : brandLinks) {
            String currentBrand = brandLink.getText();
            LOGGER.info("currentBrand: " + currentBrand);
            if (brand.equalsIgnoreCase(currentBrand)) {
                brandLink.click();
                return initPage(driver, BrandModelsPageBase.class);
            }
        }
        throw new RuntimeException("Unable to open brand: " + brand);
    }

    public ExtendedWebElement getPhoneFinderButton() {
        return phoneFinderButton;
    }

    public AllBrandsPageBase openAllBrandsPage(){
        allBrandsButton.click();
        return initPage(driver, AllBrandsPageBase.class);
    }

    @Override
    public ExtendedWebElement getMerchPage() {
        return merchPage;
    }

    public void clickMerchPage() {
        LOGGER.info("opening login form");
        merchPage.click();
    }

    public void clickPhoneFinderButton() {
        LOGGER.info("click Phone Finder Button");
        phoneFinderButton.clickIfPresent(30);
    }

    @Override
    public ExtendedWebElement getInstagramIcon(){
        return instagramIcon;
    }
    public void clickOnInstagramIcon() {
        LOGGER.info("Clicking on Instagram icon");
        instagramIcon.click();
    }
}
