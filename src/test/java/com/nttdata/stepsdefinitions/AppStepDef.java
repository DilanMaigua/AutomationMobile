package com.nttdata.stepsdefinitions;

import com.nttdata.steps.AppSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AppStepDef {

    @Steps
    AppSteps app;

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        app.verificarProducto();
    }

    @Given("estoy en la aplicacion de SauceLabs")
    public void estoyEnLaAplicacionDeSauceLabs() {
    }



    @When("agrego {int} del siguiente producto {string}")
    public void agregoUNIDADESDelSiguienteProducto(String arg0,int cantidad) {
        app.seleccionarProductos(arg0,cantidad);
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        app.verificarCarrito();
    }



}
