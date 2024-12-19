package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {
    public static By iniciarSesion = By.xpath("//span[normalize-space()='Iniciar sesión']");
    //Localizadores de elementos
    public static By userInput = By.id("field-email");
    public static By passInput = By.id("field-password");
    public static By loginButton = By.id("submit-login");

}
