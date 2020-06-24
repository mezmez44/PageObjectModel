package testCases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends TestBase {


    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;

    //WebDriver driver;
    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("myemail"), prop.getProperty("mypassword"));

    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest() {
        // waitUntilVisible(By.xpath("//span[text()='massi sako"));
        String homePageTitle = homePage.verifyHomePageTitle();
        //waitUntilVisible(By.xpath("//span[text()='massi sako"));
        Assert.assertEquals(homePageTitle, "Cogmento CRM", "the title is not correct");
    }

    @Test(priority = 2)
    public void verifyUserNameTest() {
        Assert.assertTrue(homePage.verifyUserCorrectName());

    }

    @Test(priority = 3)
    public void VerifyContactsLinkTest() {
       contactsPage= homePage.clickOnContactsLink();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
