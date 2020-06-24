package testCases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest(){
       String title=loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"Free CRM #1 cloud software for any business large or small");
    }
    @Test(priority = 2)
    public void logoImageTest(){
        Boolean logoImg = loginPage.validateLogoImage();
        Assert.assertTrue(logoImg);
    }
    @Test(priority = 3)
    public void loginTest(){
        homePage =loginPage.login(prop.getProperty("myemail"),prop.getProperty("mypassword"));
    }
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
