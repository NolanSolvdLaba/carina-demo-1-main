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
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * This sample shows how create Web test.
 *
 * @author qpsdemo
 */
public class WebSampleTest2 implements IAbstractTest {
    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testLoginWrongEmail() throws AWTException, InterruptedException {
        //Opening the gsmarena homepage
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        //Zooming out to get the login icon on screen
        for (int i = 0; i < 3; i++) {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
        }

        //Waiting to have everything in view
        Thread.sleep(3000);

        //Clicking the login icon
        homePage.getLoginIcon1().click();

        //Waiting for the login form to pop-up
        Thread.sleep(3000);

        //Filling out the form and clicking submit
        homePage.getEmailInput().type("your_dad@dad.org");
        homePage.getEmailPassword().type("changeme");
        homePage.getSubmitPassword().click();

        Thread.sleep(3000);

        String expectedResponse = "Reason: User record not found.";

        Assert.assertEquals(homePage.getLoginFailExplanation().getText(),  expectedResponse, "Unsuccessful login response does not match.");

        homePage.getDriver().close();
    }


    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testSuccessfulLogin() throws AWTException, InterruptedException {
        //Opening the gsmarena homepage
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        //Zooming out to get the login icon on screen
        for (int i = 0; i < 3; i++) {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
        }

        //Waiting to have everything in view
        Thread.sleep(3000);

        //Clicking the login icon
        homePage.getLoginIcon1().click();

        //Waiting for the login form to pop-up
        Thread.sleep(3000);

        //Filling out the form and clicking submit
        homePage.getEmailInput().type("s9rowa@mail.ru");
        homePage.getEmailPassword().type("changeme");
        homePage.getSubmitPassword().click();

        //Verifying that the user is logged
        Assert.assertTrue(homePage.getUserAccountName().isElementPresent(), "User unsuccessfully logged in");

        homePage.getDriver().close();
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P2)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testLoginWrongPassword() throws AWTException, InterruptedException {
        //Opening the gsmarena homepage
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();

        //Zooming out to get the login icon on screen
        for (int i = 0; i < 3; i++) {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
        }


        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        //Waiting to have everything in view
        Thread.sleep(3000);

        //Clicking the login icon
        homePage.getLoginIcon1().click();

        //Waiting for the login form to pop-up
        Thread.sleep(3000);

        //Filling out the form and clicking submit
        homePage.getEmailInput().type("s9rowa@mail.ru");
        homePage.getEmailPassword().type("hoagie-mouth");
        homePage.getSubmitPassword().click();

        Thread.sleep(3000);

        String expectedResponse = "Reason: Wrong password.";

        Assert.assertEquals(homePage.getLoginFailExplanation().getText(),  expectedResponse, "Unsuccessful password response does not match.");

        homePage.getDriver().close();
    }


}
