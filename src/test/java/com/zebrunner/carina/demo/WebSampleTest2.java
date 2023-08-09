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
package com.zebrunner.carina.demo;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.demo.gui.components.LoginComponent;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.gui.pages.common.AccountPageBase;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

/**
 * This sample shows how create Web test.
 *
 * @author qpsdemo
 */
public class WebSampleTest2 implements IAbstractTest {
    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testCorrectLoginCredentials() {
        //Opening the gsmarena homepage
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        // Pausing test for 5 seconds
        pause(5);

        // Verifying presence of login icon
        Assert.assertTrue(homePage.isLoginIconPresent(), "Login Icon is not present!");

        // Opening login form and verifying that the email input field is present
        homePage.openLoginForm();
        LoginComponent loginComponent = homePage.getLoginComponent();
        Assert.assertTrue(loginComponent.isEmailInputPresent(), "Email input is not present!");

        // Completing the loginflow
        loginComponent.loginFlow("s9rowa@mail.ru", "changeme");

        // Waiting for redirect
        pause(5);

        // Clicking login icon in order to access the user account page
        homePage.clickLoginIcon();
        AccountPageBase accountPage = initPage(getDriver(), AccountPageBase.class);
        Assert.assertTrue(accountPage.isPageOpened(), "User not logged in");
    }


    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P2)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testLoginWrongEmail() {
        //Opening the gsmarena homepage
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        // Pausing test for 5 seconds
        pause(5);

        // Verifying presence of login icon
        Assert.assertTrue(homePage.isLoginIconPresent(), "Login Icon is not present!");

        // Opening login form and verifying that the email input field is present
        homePage.openLoginForm();
        LoginComponent loginComponent = homePage.getLoginComponent();
        Assert.assertTrue(loginComponent.isEmailInputPresent(), "Email input is not present!");

        String wrongEmail = R.TESTDATA.get("user1.email");
        String correctLogin = R.TESTDATA.get("user1.password");

        // Completing the loginflow
        loginComponent.loginFlow(wrongEmail, correctLogin);
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);

        // Verifying that the login page is opened and explanation is present
        Assert.assertTrue(loginPage.isPageOpened(), "Login page not opened");
        Assert.assertEquals(loginPage.getUnsuccessfulLoginExplanation().getText(), "Reason: User record not found.", "Login explanation not present");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testLoginWrongPassword() throws AWTException, InterruptedException {
        // Opening the gsmarena homepage
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        // Pausing test for 5 seconds
        pause(5);

        // Verifying presence of login icon
        Assert.assertTrue(homePage.isLoginIconPresent(), "Login Icon is not present!");

        // Opening login form and verifying that the email input field is present
        homePage.openLoginForm();
        LoginComponent loginComponent = homePage.getLoginComponent();
        Assert.assertTrue(loginComponent.isEmailInputPresent(), "Email input is not present!");

        // Completing the loginflow
        loginComponent.loginFlow("s9rowa@mail.ru", "yourdad");
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);

        // Verifying that the login page is opened and explanation is present
        Assert.assertTrue(loginPage.isPageOpened(), "Login page not opened");
        Assert.assertEquals(loginPage.getUnsuccessfulLoginExplanation().getText(), "Reason: Wrong password.", "Login explanation not present");
    }
}
