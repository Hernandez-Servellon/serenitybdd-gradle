package starter;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/// Esto se hizo para probar como se hace commit en repositorio
///

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "starter.stepdefinitions",
        tags = "@Registration"

)
public class Runner {
}

