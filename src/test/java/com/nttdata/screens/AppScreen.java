package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\" and @text=\"Sauce Labs Backpack\"]")
    private WebElement titulo1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\" and @text=\"Sauce Labs Bolt T-Shirt\"]")
    private WebElement titulo2;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\" and @text=\"Sauce Labs Bike Light\"]")
    private WebElement titulo3;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Increase item quantity\"]")
    private WebElement sumador;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to add product to cart\"]")
    private WebElement btnCarrito;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]")
    private WebElement btnConfirmacionCarrito;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemsTV\"]")
    private WebElement txtConfirmacio;

    private AppScreen() {
    }

    public static AppScreen createAppScreen() {
        return new AppScreen();
    }

    public void verificarProductos() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        wait.until(ExpectedConditions.visibilityOf(titulo1));
        System.out.println("Producto 1 encontrado: " + titulo1.getText());

        wait.until(ExpectedConditions.visibilityOf(titulo2));
        System.out.println("Producto 2 encontrado: " + titulo2.getText());

        wait.until(ExpectedConditions.visibilityOf(titulo3));
        System.out.println("Producto 3 encontrado: " + titulo3.getText());
    }

    public void seleccionarProducto(String producto) {
        String xpathProducto = String.format("//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/titleTV' and @text='%s']", producto);
        WebElement productoElemento = getDriver().findElement(By.xpath(xpathProducto));

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(productoElemento));

        productoElemento.click();
    }

    public void agregarProductoAlCarrito(String producto, int unidades) {
        seleccionarProducto(producto);

        for (int i = 0; i < unidades; i++) {
            WebElement botonAgregar = getDriver().findElement(By.id("com.saucelabs.mydemoapp.android:id/plusIV"));
            botonAgregar.click();
        }
    }


    public void compraProductos(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        wait.until(ExpectedConditions.visibilityOf(btnCarrito));
        btnCarrito.click();
    }

    public void verCarrito(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        wait.until(ExpectedConditions.visibilityOf(btnConfirmacionCarrito));
        btnConfirmacionCarrito.click();
    }

    public void comprobarCarrito() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        wait.until(ExpectedConditions.visibilityOf(txtConfirmacio));
        System.out.println(txtConfirmacio.getText());

    }

}
