package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import com.nttdata.page.CompraPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyStoreSteps {
    private WebDriver driver;
    private double total;
    public MyStoreSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void iniciarSesion() {
        this.driver.findElement(LoginPage.iniciarSesion).click();
    }

    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(LoginPage.userInput);
        userInputElement.sendKeys(user);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));

    }
    public void typePassword(String password){
        this.driver.findElement(LoginPage.passInput).sendKeys(password);
    }

    public void login() throws InterruptedException {
        this.driver.findElement(LoginPage.loginButton).click();
        Thread.sleep(2000L);
        String mensajeErrorAutenticacion = this.driver.findElement(LoginPage.errorAutenticacion).getText();
        Assert.assertEquals("Error de autenticación.",mensajeErrorAutenticacion);
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

    public void agregarUnidades(String cantidad) throws InterruptedException {
        this.driver.findElement(CompraPage.producto).click();
        Thread.sleep(2000L);
        this.driver.findElement(CompraPage.cantidad).click();
        this.driver.findElement(CompraPage.btnAgregar).click();
        Thread.sleep(2000L);
        int cantidadConfirmacion = Integer.parseInt(cantidad);
        String precio = this.driver.findElement(CompraPage.precio).getText();
        String precioSinSimbolo = precio.replace("S/ ", "").trim();
       System.out.println("el precio es : "+ precioSinSimbolo);
       Double total = Double.parseDouble(precioSinSimbolo)*2;
        System.out.println("el total es : "+ total);
        this.total =total;
    }

    public void confirmacionProducto() {
        String modal = this.driver.findElement(CompraPage.myModalLabel).getText();
        System.out.println("el texto modal es: "+ modal);
        Assert.assertEquals("\uE876Producto añadido correctamente a su carrito de compra",modal);
        System.out.println("el total desde confirmacionProducto : "+ total);
        String compraTotal= this.driver.findElement(CompraPage.totalCompra).getText();
        Assert.assertEquals("S/ "+total,compraTotal);
    }

    public void finalizoCompra() {
        this.driver.findElement(CompraPage.btnFinalizarcompra).click();
    }

    public void validarTituloCarrito() {
        String tituloCarrito = this.driver.findElement(CompraPage.tituloCarrito).getText();
        System.out.println("el titulo carrito es: "+ tituloCarrito);
        Assert.assertEquals("CARRITO",tituloCarrito);
    }

    public void validarTotalEnCarrito() {
        String compraTotalCarrito= this.driver.findElement(CompraPage.totalCompraCarrito).getText();
        Assert.assertEquals("S/ "+total,compraTotalCarrito);
    }
}



