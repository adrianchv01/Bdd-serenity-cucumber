package cucumber;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@Test",
        plugin = {"pretty"},
        features = {"src/test/resources/features/posts"},
        glue = {"cucumber.posts.stepDef"}
)
public class CucumberTestSuite {
}
