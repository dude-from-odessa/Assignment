package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty","rerun:target/failed.txt"},
        features = "src/test/resources/features",
        monochrome = true,
        tags = "@positive or @negative",
        glue = "APIsteps"
)
public class APIRunner {



}
