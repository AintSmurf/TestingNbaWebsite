package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:src/test/cucumber-reports/cucumber-report.html"},
        features = "src/test/resources/features",
        monochrome = true,
        glue = {"steps"}

)
public class TestRunner {
}
