package com.nttdata.page;

import org.openqa.selenium.By;

public class CompraPage {
    public static By producto = By.xpath("//img[@alt='Hummingbird printed t-shirt']");
    //public static By cantidad = By.id("quantity_wanted");
    public static By cantidad = By.xpath("//i[@class='material-icons touchspin-up']");
    public static By btnAgregar = By.xpath("//button[@class='btn btn-primary add-to-cart']");
    public static By myModalLabel = By.id("myModalLabel");
    public static By precio = By.xpath("//span[@class='current-price-value']");

    public static By totalCompra = By.xpath("//p[@class='product-total']/span[2]");

    public static By btnFinalizarcompra = By.xpath("//div[@class='cart-content-btn']/a");


    public static By tituloCarrito = By.xpath("//h1[contains(text(),'Carrito')]");

    public static By totalCompraCarrito = By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/span[2]");



}
