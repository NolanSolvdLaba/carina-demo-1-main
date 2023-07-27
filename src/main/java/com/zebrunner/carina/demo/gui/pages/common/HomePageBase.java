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
package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.demo.gui.components.footer.FooterMenuBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class HomePageBase extends AbstractPage {

    @FindBy(xpath = "//button[text()='Agree and proceed']")
    private ExtendedWebElement acceptCookies;

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract BrandModelsPageBase selectBrand(String brandName);

    public abstract FooterMenuBase getFooterMenu();

    public abstract CompareModelsPageBase openComparePage();

    public abstract AllBrandsPageBase openAllBrandsPage();

    @Override
    public void open() {
        super.open();
        acceptCookies.clickIfPresent(3);
    }

    public ExtendedWebElement getLoginIcon1() {
        return null;
    }



    public ExtendedWebElement getLoginIcon3() {
        return null;
    }

    public ExtendedWebElement getPhoneFinderButton() {
        return null;
    }


    public void openPopup() {
    }

    public ExtendedWebElement getMerchPage() {
        return null;
    }

    public boolean isLoginIconPresent() {
        return false;
    }

    public void openLoginForm() {};

    public void clickOnInstagramIcon() {};

    public void clickMerchPage() {};

    public void clickPhoneFinderButton() {};

    public ExtendedWebElement getUserAccountName(){
        return null;
    }

    public ExtendedWebElement getInstagramIcon() {
        return null;
    }

    public ExtendedWebElement getEmailInput() {
        return null;
    }


    public ExtendedWebElement getEmailPassword() {
        return null;
    }

    public ExtendedWebElement getSubmitPassword() {
        return null;
    }

    public ExtendedWebElement getLoginFail() {
        return null;
    }

    public ExtendedWebElement getLoginFailExplanation() {
        return null;
    }

}
