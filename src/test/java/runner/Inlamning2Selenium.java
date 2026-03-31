package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

    public class Inlamning2Selenium {

        @Test
        public void testCompleteUser()  {

            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");

            WebDriver driver = new ChromeDriver(options);

            driver.get("file:///C:/Users/MS/OneDrive/Utbildningen/Inl%C3%A4mninguppgifter%20dyl%20utbildningen/Kurs%204/Uppgift%202/Register.html");

            driver.findElement(By.id("dp")).sendKeys("08/03/1978");

            driver.findElement(By.id("member_firstname")).sendKeys("Henric");
            driver.findElement(By.id("member_lastname")).sendKeys("Wiktor");

            String email = "phumpeti@gmail.com";

            driver.findElement(By.id("member_emailaddress")).sendKeys(email);
            driver.findElement(By.id("member_confirmemailaddress")).sendKeys(email);

            String password = "hejhopp123";

            driver.findElement(By.id("signupunlicenced_password")).sendKeys(password);
            driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(password);

            for (int i = 16; i <= 24; i++) {
                driver.findElement(By.cssSelector("[for='signup_basketballrole_"+ i +"']")).click();
            }

            for (int i = 25; i <= 28; i++) {
                driver.findElement(By.cssSelector("[for='sign_up_"+ i +"']")).click();  // for=sign_up_16
            }

            driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']")).click();

            driver.findElement(By.cssSelector("[value='CONFIRM AND JOIN']")).click();

            String actual = driver.findElement(By.cssSelector(".bold.gray.text-center.margin-bottom-40")).getText();

            // System.out.println(actual);

            String expected = "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND";

            assertEquals(expected, actual);

            driver.quit();
        }

        @Test
        public void testCompleteUserNoLastName()  {

            WebDriver driver = new ChromeDriver();

            driver.get("file:///C:/Users/MS/OneDrive/Utbildningen/Inl%C3%A4mninguppgifter%20dyl%20utbildningen/Kurs%204/Uppgift%202/Register.html");

            driver.findElement(By.id("dp")).sendKeys("08/03/1978");

            driver.findElement(By.id("member_firstname")).sendKeys("Henric");

            driver.findElement(By.id("member_lastname")).sendKeys("");

            String email = "phumpeti@gmail.com";

            driver.findElement(By.id("member_emailaddress")).sendKeys(email);
            // driver.findElement(By.id("member_confirmemailaddress")).sendKeys(email);

            String password = "hejhopp123";

            driver.findElement(By.id("signupunlicenced_password")).sendKeys(password);
            driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(password);

            driver.findElement(By.cssSelector("[for='signup_basketballrole_24']")).click();

            for (int i = 25; i <= 26; i++) {
                driver.findElement(By.cssSelector("[for='sign_up_"+ i +"']")).click();
            }

            driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']")).click();

            driver.findElement(By.cssSelector("[value='CONFIRM AND JOIN']")).click();

            String actual = driver.findElement(By.cssSelector("span[for='member_lastname']")).getText();

            System.out.println(actual);

            // String expected = "Last name is required";

            driver.quit();
        }

        @Test
        public void testCompleteUserNotMatchingPassword()  {

            WebDriver driver = new ChromeDriver();

            driver.get("file:///C:/Users/MS/OneDrive/Utbildningen/Inl%C3%A4mninguppgifter%20dyl%20utbildningen/Kurs%204/Uppgift%202/Register.html");

            driver.findElement(By.id("dp")).sendKeys("08/03/1978");

            driver.findElement(By.id("member_firstname")).sendKeys("Henric");

            driver.findElement(By.id("member_lastname")).sendKeys("Wiktor");

            String email = "phumpeti@gmail.com";

            driver.findElement(By.id("member_emailaddress")).sendKeys(email);
            driver.findElement(By.id("member_confirmemailaddress")).sendKeys(email);

            String password = "hejhopp123";
            String password_2 = "hejhopp12";

            driver.findElement(By.id("signupunlicenced_password")).sendKeys(password);
            driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(password_2);

            driver.findElement(By.cssSelector("[for='signup_basketballrole_24']")).click();

            for (int i = 25; i <= 26; i++) {
                driver.findElement(By.cssSelector("[for='sign_up_"+ i +"']")).click();
            }

            driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']")).click();

            String actual = driver.findElement(By.cssSelector("span[for='signupunlicenced_confirmpassword']")).getText();

            System.out.println(actual);

            String expected = "Password did not match";

            assertEquals(expected, actual);

            driver.quit();
        }

        @Test
        public void testCompleteUserNoTermsAndConditions()  {

            WebDriver driver = new ChromeDriver();

            driver.get("file:///C:/Users/MS/OneDrive/Utbildningen/Inl%C3%A4mninguppgifter%20dyl%20utbildningen/Kurs%204/Uppgift%202/Register.html");

            driver.findElement(By.id("dp")).sendKeys("08/03/1978");

            driver.findElement(By.id("member_firstname")).sendKeys("Henric");

            driver.findElement(By.id("member_lastname")).sendKeys("Wiktor");

            String email = "phumpeti@gmail.com";

            driver.findElement(By.id("member_emailaddress")).sendKeys(email);
            driver.findElement(By.id("member_confirmemailaddress")).sendKeys(email);

            String password = "hejhopp123";

            driver.findElement(By.id("signupunlicenced_password")).sendKeys(password);
            driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(password);

            for (int i = 25; i <= 26; i++) {
                driver.findElement(By.cssSelector("[for='sign_up_"+ i +"']")).click();
            }

            driver.findElement(By.cssSelector("[value='CONFIRM AND JOIN']")).click();

            String actual = driver.findElement(By.cssSelector("span[for='AgreeToCodeOfEthicsAndConduct']")).getText();

            System.out.println(actual);

            String expected = "You must confirm that you have read, understood and agree to the Code of Ethics and Conduct";

            driver.quit();
        }
    }
