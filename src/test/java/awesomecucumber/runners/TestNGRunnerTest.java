package awesomecucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"awesomecucumber.stepdef",
                "awesomecucumber.hooks",
                "awesomecucumber.customtypes",
                "parameter.type"
        }
)
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void setUp() {
        System.out.println("This is before class annotation");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("This is after class annotation");
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}