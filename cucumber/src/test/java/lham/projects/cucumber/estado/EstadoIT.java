package lham.projects.cucumber.estado;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/cucumber/estado/EstadoListar.feature" }, snippets = SnippetType.CAMELCASE)
public class EstadoIT {

}
