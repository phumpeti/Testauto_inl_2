package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStepdefs {

    private WebDriver driver;

    private void waitforText(By locator, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.textToBe(locator, text));
    }

    @Before
    public void setUp() {
        Logger.getLogger("org.openqa.selenium.devtools.CdpVersionFinder")
                .setLevel(Level.OFF);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("I am using the {string} browser")
    public void iAmUsingTheBrowserBrowser(String text) {
        if (text.equals("Chrome")) {
            driver = new ChromeDriver();
        }
        else if  (text.equals("Edge")) {
            driver = new EdgeDriver();
        }
        else if  (text.equals("Firefox")) {
            driver = new FirefoxDriver();
        }

    }
    @Given("I have navigated to application form")
    public void iHaveNavigatedToApplicationForm() {
        driver.get("file:///C:/Users/MS/OneDrive/Utbildningen/Inl%C3%A4mninguppgifter%20dyl%20utbildningen/Kurs%204/Uppgift%202/Register.html");

    }

    @When("I fill in the form with")
    public void iFillInTheFormWith(DataTable table) throws InterruptedException {

        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        Map<String, String> row = rows.getFirst();


        driver.findElement(By.id("dp")).sendKeys(row.get("Birth Date"));

        driver.findElement(By.id("member_firstname")).sendKeys(row.get("First Name"));

        if (row.get("Last Name") != null) {
            driver.findElement(By.id("member_lastname")).sendKeys(row.get("Last Name"));
        }

        driver.findElement(By.id("member_emailaddress")).sendKeys(row.get("Email Address"));

        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(row.get("Confirm Email"));

        driver.findElement(By.id("signupunlicenced_password")).sendKeys(row.get("Password"));

        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(row.get("Confirm Password"));

        if(row.get("Terms and Conditions").equalsIgnoreCase("yes")) {
            driver.findElement(By.cssSelector("[for='sign_up_25'")).click();
        }

        if(row.get("Over 18").equalsIgnoreCase("yes")) {
            driver.findElement(By.cssSelector("[for='sign_up_26'")).click();
        }

        if(row.get("Code of Ethics").equalsIgnoreCase("yes")) {
            driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']")).click();
        }

        if(row.get("Confirm and Join").equalsIgnoreCase("yes")) {
            driver.findElement(By.cssSelector("[value='CONFIRM AND JOIN']")).click();
        }

    }

    @Then("I have registered a supporter account.")

    public void iHaveRegisteredASupporterAccount() {

        waitforText(By.cssSelector(".bold.gray.text-center.margin-bottom-40"), "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND");

        String actual = driver.findElement(By.cssSelector(".bold.gray.text-center.margin-bottom-40")).getText();



        String expected = "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND";

        assertEquals(expected, actual);

    }

    @Then("I should see error message {string}")
    public void iShouldSeeErrorMessageString(String expectedError) {

        if (expectedError.contains("Last Name")) {
            String actualLastName = driver.findElement(By.cssSelector("span[data-valmsg-for='Surname']")).getText();

            String expected = "Last Name is required";

            assertEquals(expected, actualLastName);
        }

        if (expectedError.contains("Confirm Password")) {
            String actualPassword = driver.findElement(By.cssSelector("span[data-valmsg-for='ConfirmPassword']")).getText();

            String expected = "Password did not match";

            assertEquals(expected, actualPassword);
        }

        if (expectedError.contains("Terms and Conditions")) {
            String actualMissingTick = driver.findElement(By.cssSelector("span[data-valmsg-for='TermsAccept']")).getText();

            String expected = "You must confirm that you have read and accepted our Terms and Conditions";

            assertEquals(expected, actualMissingTick);
        }

    }



}
