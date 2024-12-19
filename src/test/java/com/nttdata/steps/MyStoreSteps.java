package com.nttdata.steps;

import com.nttdata.page.CategoriaPage;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.screenShot;

public class MyStoreSteps {
    private WebDriver driver;

    public MyStoreSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void iniciarSesion() {
        this.driver.findElement(LoginPage.iniciarSesion).click();
    }

    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(LoginPage.userInput);
        userInputElement.sendKeys(user);
        //Espera explicita:
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));

    }
    public void typePassword(String password){
        this.driver.findElement(LoginPage.passInput).sendKeys(password);
    }

    public void login() throws InterruptedException {
        this.driver.findElement(LoginPage.loginButton).click();
        Thread.sleep(2000L);

    }


    public void navegaCategoriaYSubcategoria(String categoria, String subcategoria) throws InterruptedException {
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.cssSelector("a[href*='"+categoria+"']"))).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement subcat = driver.findElement(By.cssSelector("a[href*='"+subcategoria+"']"));
        wait.until(ExpectedConditions.visibilityOf(subcat));
        a.moveToElement(driver.findElement(By.cssSelector("a[href*='"+subcategoria+"']"))).build().perform();
        driver.findElement(By.cssSelector("a[href*='"+subcategoria+"']")).click();

    }

}


