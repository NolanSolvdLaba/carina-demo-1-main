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

import com.zebrunner.carina.demo.gui.components.LoginComponent;
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

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().getClass());

    @FindBy(id = "footmenu")
    private FooterMenu footerMenu;

    @FindBy(id="login-popup2")
    private LoginComponent loginComponent;

    @FindBy(xpath=".//a[@class='login-icon']")
    private ExtendedWebElement loginIcon;

    @FindBy(className = "news-column-index")
    private ExtendedWebElement newsColumn;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(newsColumn);
    }

    @Override
    public void clickLoginIcon(){
        loginIcon.click();
    }

    @Override
    public LoginComponent getLoginComponent(){
        return loginComponent;
    }

    @Override
    public boolean isLoginIconPresent(){
        return loginIcon.isPresent();
    }

    @Override
    public BrandModelsPageBase selectBrand(String brandName) {
        return null;
    }

    @Override
    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    @Override
    public CompareModelsPageBase openComparePage() {
        return null;
    }

    @Override
    public AllBrandsPageBase openAllBrandsPage() {
        return null;
    }

    @Override
    public void openLoginForm() {
        loginIcon.click();
    }

}
