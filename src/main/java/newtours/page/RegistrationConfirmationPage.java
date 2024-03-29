package newtours.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {
    public WebDriver driver;
    public WebDriverWait wait;

      @FindBy(partialLinkText = "sign-in")
      private WebElement signinlink;

      @FindBy(linkText = "Flights")
      private WebElement fligthsLink;


    public RegistrationConfirmationPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }
    public void goToFlightDetailPage(){
        this.wait.until(ExpectedConditions.visibilityOf(this.signinlink));
        this.fligthsLink.click();
    }
}
