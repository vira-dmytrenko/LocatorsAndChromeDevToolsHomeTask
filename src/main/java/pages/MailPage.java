package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MailPage {
    protected WebDriver driver;

    @FindBy(xpath = "//button[@class='button primary compose']")
    private WebElement primaryComposeButton;
    @FindBy(name = "toFieldInput")
    private WebElement sendToField;
    @FindBy(css = "input[name='subject']")
    private WebElement subjectField;
    @FindBy(id = "tinymce")
    private WebElement emailBody;
    @FindBy(xpath = "//div[@class='sendmsg__bottom-controls']//button[@class='button primary send']")
    private WebElement sendEmailButton;

    public MailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForComposeButtonVisibility() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(primaryComposeButton));
    }

    public void createEmail(String sendToUser, String subject) {
        primaryComposeButton.click();
        sendToField.sendKeys(sendToUser);
        subjectField.sendKeys(subject);
    }

    public void fillEmailBody(String text) {
        //Switch to the frame
        driver.switchTo().frame(1);
        emailBody.sendKeys(text);
        // Return to the top level
        driver.switchTo().defaultContent();
    }

    public void sendEmail() {
        sendEmailButton.click();
    }

}
