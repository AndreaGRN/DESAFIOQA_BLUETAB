package page;

import ui.TriangleUi;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrianglePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public TrianglePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
    }

    public void enterName(String name) {
        WebElement usernameCampo = wait.until(ExpectedConditions.visibilityOfElementLocated(TriangleUi.USERNAME));
        usernameCampo.sendKeys(name);
    }

    public void enterCampos(String sideA, String sideB, String sideC) {
        WebElement primerCampo = wait.until(ExpectedConditions.visibilityOfElementLocated(TriangleUi.SIDEA));
        WebElement segundoCampo = wait.until(ExpectedConditions.visibilityOfElementLocated(TriangleUi.SIDEB));
        WebElement tercerCampo = wait.until(ExpectedConditions.visibilityOfElementLocated(TriangleUi.SIDEC));

        primerCampo.sendKeys(sideA);
        segundoCampo.sendKeys(sideB);
        tercerCampo.sendKeys(sideC);
    }

    public void clickCheckButton() {
        WebElement checkBtn = wait.until(ExpectedConditions.elementToBeClickable(TriangleUi.CHECK_BUTTON));
        checkBtn.click();
    }


    public String getResultMessage(String sideA, String sideB, String sideC) {
        String script = String.format(
                "var t = new Triangle(%s, %s, %s); determine_type(t); return t.desc;",
                sideA, sideB, sideC
        );
        return (String) ((JavascriptExecutor) driver).executeScript(script);
    }
}