package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactsPage extends TestBase {
    @FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
    WebElement contactsLabel;
    @FindBy(name = "first_name")
    WebElement enterFirstName;
    @FindBy(name = "last_name")
    WebElement enterLastName;
    public static final String sChanelXpath="//div[@name='channel_type']//i[@class='dropdown icon']";
    public static final String facebookXpath="//div[@class='active selected item']//span[text()='Facebook']";
    @FindBy(xpath = "//button[@class='ui linkedin button']")
    WebElement save;


    //Initialization
    public ContactsPage() {
        PageFactory.initElements(driver, this);
    }

    public Boolean verifyContactsLabel() {
        return contactsLabel.isDisplayed();
    }

    public void selectContactsByName(String name) {
        driver.findElement(By.xpath("//td[contains(text(),'" + name + "')]")).click();
    }
    public void enterNewContactInfo(String fName,String lName){
        enterFirstName.sendKeys(fName);
        enterLastName.sendKeys(lName);
        //save.click();

    }
}
