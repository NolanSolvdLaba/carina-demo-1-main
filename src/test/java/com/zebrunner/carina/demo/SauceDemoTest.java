
package com.zebrunner.carina.demo;


import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.demo.gui.pages.common.SauceDemo.SauceDemoHomePageBase;
//import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoTest implements IAbstractTest {

    @Test
    @MethodOwner(owner="qpsdemo")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = { "web", "regression "})
    public void testCorrectLoginCredentials(){
        //Opening the SauceDemo Homepage
        SauceDemoHomePageBase sauceHomePage = initPage(getDriver(), SauceDemoHomePageBase.class);
        sauceHomePage.open();
        Assert.assertTrue(sauceHomePage.isPageOpened(), "Sauce page not opened.");


        // Pausing test for 5 seconds
        pause(5);

        // Username and password
        String correctUserName = R.TESTDATA.get("sauceLabs.userName");
        String correctPassword = R.TESTDATA.get("sauceLabs.correctPassword");

        //Login flow
        sauceHomePage.loginFlow(correctUserName, correctPassword);

        // Pausing test for 5 seconds
        pause(5);

    }
}
