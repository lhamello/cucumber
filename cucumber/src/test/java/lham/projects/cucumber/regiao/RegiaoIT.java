package lham.projects.cucumber.regiao;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/cucumber/regiao/RegiaoListar.feature" }, snippets = SnippetType.CAMELCASE)
public class RegiaoIT {

}
