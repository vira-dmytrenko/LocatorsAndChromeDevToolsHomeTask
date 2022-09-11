package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected final WebDriver driver;
    @FindBy(css="input[name='login']")
    private WebElement usernameField;
    @FindBy(name="password")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MailPage login(String userName, String password){
        usernameField.sendKeys(userName);
        passwordField.sendKeys(password);
        submitButton.click();
        return new MailPage(driver);
    }

}
