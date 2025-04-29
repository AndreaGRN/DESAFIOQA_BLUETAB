package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import util.WebDriverFactory;

public class HookSteps {

    public static WebDriver driver = null;
    private WebDriverFactory factory = null;


    @Before
    public void setup(){
        factory = new WebDriverFactory();
        driver = factory.create();
    }


    @After
    public void tearDown(Scenario scenario){
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "Evidencia Adjuntado");

        factory.finish(driver);
    }

}
