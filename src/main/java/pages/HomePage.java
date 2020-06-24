package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    @FindBy(xpath = "//span[text()='massi sako']")
    @CacheLookup
    WebElement userNameLabel;
    @FindBy(xpath = "//span[text()='Contacts']")
    WebElement contactsLink;
    @FindBy(xpath = "//span[text()='Deals']")
    WebElement dealsLink;
    @FindBy(xpath = "//span[text()='Task']")
    WebElement taskLink;
    @FindBy(xpath = "//a//button[@class='ui linkedin button']")
    WebElement newContactButton;


    //Initializing the page Object
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public Boolean verifyUserCorrectName() {
        return userNameLabel.isDisplayed();
    }

    public ContactsPage clickOnContactsLink() {
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickDealsLink() {
        dealsLink.click();
        return new DealsPage();
    }

    public TaskPage clickTaskLink() {
        taskLink.click();
        return new TaskPage();
    }

    public void clickNewContact() {
        newContactButton.click();
    }

}
