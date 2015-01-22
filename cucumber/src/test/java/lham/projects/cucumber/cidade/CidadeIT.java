package lham.projects.cucumber.cidade;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/cucumber/cidade/CidadeListar.feature" }, snippets = SnippetType.CAMELCASE)
public class CidadeIT {

}
