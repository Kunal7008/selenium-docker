package newtours.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterationPage {
    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(name="firstName")
    private WebElement FirstNameTxt;

    @FindBy(name="lastName")
    private WebElement LastNameTxt;

    @FindBy(id="email")
    private WebElement UserNameTxt;

    @FindBy(name="password")
    private  WebElement PasswordTxt;

    @FindBy(name="confirmPassword")
    private  WebElement confirmPasswordTxt;

    @FindBy(name="register")
    private  WebElement submitBtn;

    public  RegisterationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);

    }

        public void goTo(){
    this.driver.get("http://newtours.demoaut.com/mercuryregister.php");
    this.wait.until(ExpectedConditions.visibilityOf(this.FirstNameTxt));

        }

        public void enterUserDetails(String firstName,String lastName){
             this.FirstNameTxt.sendKeys(firstName);
             this.LastNameTxt.sendKeys(lastName);
        }
         public void userCredentials(String  username, String password){
    this.UserNameTxt.sendKeys(username);
    this.PasswordTxt.sendKeys(password);
    this.confirmPasswordTxt.sendKeys(password);
        }

        public void submit(){
    this.submitBtn.click();
        }

    }

