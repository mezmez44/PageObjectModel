package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends TestBase {
    @FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
    WebElement loginMain;

    @FindBy(xpath="//input[@name='email']")
    public WebElement myemail;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement mypassword;

    @FindBy(xpath="//div[@class='ui fluid large blue submit button']")
    WebElement loginLast;

    @FindBy(xpath = "//div[@class='rd-navbar-panel']//div//a[@class='brand-name']")
    WebElement logo;


    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
        public String validateLoginPageTitle(){
            return driver.getTitle();
        }
        public boolean validateLogoImage(){
        return logo.isDisplayed();
        }

    public HomePage login(String email,String password){
        loginMain.click();
        myemail.sendKeys(email);
        mypassword.sendKeys(password);
        loginLast.click();
        return new HomePage();
    }
}
