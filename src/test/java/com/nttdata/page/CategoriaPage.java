package com.nttdata.page;

import org.openqa.selenium.By;

public class CategoriaPage {
    //public static By optCategoria = By.xpath("//li[@id='category-3']//a[@class='dropdown-item']");

    public static By optCategoria = By.cssSelector("a[href*='"+"clothes"+"']");
}
