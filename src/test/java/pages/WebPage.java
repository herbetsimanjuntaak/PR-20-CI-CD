package pages;

import helper.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static helper.Utility.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebPage {

    By button_login = By.id("login2");
    By input_username = By.id("loginusername");
    By input_password = By.id("loginpassword");
    By button_login_new = By.xpath("//button[@onclick='logIn()']");
    By productTitle = By.xpath("//*[text() = 'Welcome herbet']");
    By button_logout = By.id("logout2");


    public void isOnLoginPage(){
        driver.get("https://www.demoblaze.com/");
    }

    public void clickButtonLogin(){
        driver.findElement(button_login).click();
    }
    public void inputUserName(String username){
        Utility.driver.findElement(input_username).sendKeys(username);
    }
    public void inputPassword(String password){
        Utility.driver.findElement(input_password).sendKeys(password);
    }
    public void clickButtonLoginNew(){
        Utility.driver.findElement(button_login_new).click();
    }
    public void isOnHomepage(){
        Utility.driver.findElement(productTitle);
        WebElement productElement = Utility.driver.findElement(productTitle);
        assertTrue(productElement.isDisplayed());

        System.out.println("hello");
        System.out.println(productElement.getText());
        assertEquals("Welcome herbet", productElement.getText());
    }

    public void validateErrorAppear(String errorMessage) {
//        assertTrue(driver.getPageSource().contains(errorMessage));
    }

    public void clickButtonLogOut() {
        driver.findElement(button_logout).click();
    }

}
