import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MailPage;

public class SendEmail {
    static final String USER_NAME = "super-test88";
    static final String PASSWORD = "helloworld88*";
    static final String SEND_TO_USER_NAME = "testebay60@gmail.com";
    static final String EMAIL_SUBJECT = "Test";
    static final String EMAIL_BODY_TEXT =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
            " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam," +
            " quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." +
            " Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu" +
            " fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa" +
            " qui officia deserunt mollit anim id est laborum.";


    public static void main(String[] args) {
        WebDriver driver = setupDriver();
        driver.get("https://mail.ukr.net");

        LoginPage loginPage = new LoginPage(driver);

        MailPage mailPage = loginPage.login(USER_NAME, PASSWORD);
        mailPage.waitForComposeButtonVisibility();
        mailPage.createEmail(SEND_TO_USER_NAME, EMAIL_SUBJECT);
        mailPage.fillEmailBody(EMAIL_BODY_TEXT);
        mailPage.sendEmail();

        driver.quit();
    }

    private static WebDriver setupDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
