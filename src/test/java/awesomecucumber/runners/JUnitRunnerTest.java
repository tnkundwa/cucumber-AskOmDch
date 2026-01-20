package awesomecucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"awesomecucumber.stepdef",
                "awesomecucumber.hooks",
                "awesomecucumber.customtypes",
                "parameter.type"
        },
        plugin = {"pretty"
//                "html:target/cucumber_report/CucumberHTMLReport.html",
//                "summary"
        },
        snippets = CAMELCASE,
        dryRun = false,
        monochrome = false
)

public class JUnitRunnerTest {
}
