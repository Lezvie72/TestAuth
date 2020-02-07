package runners;

import base.Base;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/tests",
        glue = {"stepDefinitions", "runners", "hooks"},
        tags = {"@test", "~@ignore"},
        strict = true,
        snippets = SnippetType.CAMELCASE,
        monochrome = true,
        format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        plugin = "ru.yandex.qatools.allure.cucumberjvm.AllureReporter"
)
public class TestFirstRunner extends Base {

}
