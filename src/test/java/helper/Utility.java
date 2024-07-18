package helper;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class Utility {
    static Faker faker = new Faker();
    public static WebDriver driver;
    public static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/java/helper/JSONSchemaData/" + JSONFile);
    }

    public static String generateName(){
        return faker.name().fullName();
    }

    public static String generateEmails(){
        return faker.name().username()+"@gmail.com";
    }


    public static void startDriver(){

        ChromeOptions options = new ChromeOptions();
        //untuk tidak menampilkan browser
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    public static void quitDriver(){
        driver.quit();
    }
}
