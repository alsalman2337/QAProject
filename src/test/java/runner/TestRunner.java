package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",   // path to your .feature files
        glue = "tests",                  // package containing your step definitions
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // reporting
        //monochrome = true,                         // readable console output
        //dryRun = false,                            // true = checks missing steps, false = runs tests
        tags = "@test3"                            // optional: run only scenarios with this tag
)
public class TestRunner {

}
