package steps;

import org.openqa.selenium.WebDriver;
import page.TrianglePage;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleSteps {

    private WebDriver driver;
    private TrianglePage trianglePage;
    private String initialMessage = "";

    @Given("que ingreso a la web del programa")
    public void openTrianglePage() {
        driver = HookSteps.driver;
        driver.get("https://www.developsense.com/triangle/triangle.html");
        trianglePage = new TrianglePage(driver);
    }

    @When("coloco tres valores positivos en los campos {string}, {string}, {string} y un nombre {string}")
    public void enterTriangleValor(String sideA, String sideB, String sideC, String username) {
        trianglePage.enterName(username);
        trianglePage.enterCampos(sideA, sideB, sideC);
        this.initialMessage = trianglePage.getResultMessage(sideA, sideB, sideC);
        System.out.println("Mensaje final: " + initialMessage);
    }

    @And("doy clic en {string}")
    public void enterCheckButton(String button) {
        trianglePage.clickCheckButton();
    }

    @Then("me indica que es {string}")
    public void obtainFinalMessage(String desiredMessage) {
        assertEquals(desiredMessage, initialMessage);
        System.out.println("Satisfactorio: El resultado es '" + desiredMessage + "'");
    }

}