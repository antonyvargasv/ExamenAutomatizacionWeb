package com.nttdata.stepsdefinitions;

import com.nttdata.steps.MyStoreSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class MyStoreStepDef {
    private WebDriver driver;
    MyStoreSteps myStoreSteps;
    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/");
        screenShot();
    }
    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String clave) throws InterruptedException {
        myStoreSteps = new MyStoreSteps(driver);
        myStoreSteps.iniciarSesion();
        myStoreSteps.typeUser(usuario);
        myStoreSteps.typePassword(clave);
        myStoreSteps.login();
        screenShot();
    }



    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) throws InterruptedException {
        myStoreSteps.navegaCategoriaYSubcategoria(categoria, subcategoria);

    }


    @Y("agrego {string} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(String cantidad) throws InterruptedException {
        myStoreSteps.agregarUnidades(cantidad);
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        myStoreSteps.confirmacionProducto();
    }
}
