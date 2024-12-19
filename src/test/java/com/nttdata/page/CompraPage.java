package com.nttdata.page;

import org.openqa.selenium.By;

public class CompraPage {
    public static By producto = By.xpath("//img[@alt='Hummingbird printed t-shirt']");
    //public static By cantidad = By.id("quantity_wanted");
    public static By cantidad = By.xpath("//i[@class='material-icons touchspin-up']");
    public static By btnAgregar = By.xpath("//button[@class='btn btn-primary add-to-cart']");
    public static By myModalLabel = By.id("myModalLabel");
    public static By precio = By.xpath("//span[@class='current-price-value']");


}
