package testCases;

import base.TestBase;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;

public class ContactsPageTest extends TestBase {
    ContactsPage contactsPage;
    LoginPage login;
    HomePage homePage;
    String sheetName="contacts";

    public ContactsPageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        contactsPage = new ContactsPage();
        login =new LoginPage();
        homePage=login.login(prop.getProperty("myemail"),prop.getProperty("mypassword"));
        contactsPage =homePage.clickOnContactsLink();

    }
    @Test(priority = 1)
    public void contactsLabelTest(){
        Assert.assertTrue(contactsPage.verifyContactsLabel());
    }
    @Test(priority = 2)
    public void selectSingleContactTest(){
        //waitUntilSelectable(By.xpath("//td[contains(text(),'massi sako')]"));
        driver.navigate().refresh();
        contactsPage.selectContactsByName("massi sako");
    }
    @Test(priority =3)
    public void selectMultipleContactsTest(){
        driver.navigate().refresh();
        contactsPage.selectContactsByName("someone somthing");
        contactsPage.selectContactsByName("mezian bena");
    }
    @DataProvider
    public Object[][] getCRMTestData() throws InvalidFormatException {
        Object data[][]= TestUtil.getTestData(sheetName);
        return data;
    }
    @Test(priority=4, dataProvider = "getCRMTestData")
    public void createNewContactTest(String fName,String lName){
        homePage.clickNewContact();
        driver.navigate().refresh();
        driver.navigate().refresh();
        contactsPage.enterNewContactInfo(fName,lName);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
