package lham.projects.cucumber.regiao;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = { 
			"src/test/resources/cucumber/regiao/RegiaoListar.feature",
			"src/test/resources/cucumber/regiao/RegiaoPesquisar.feature",
			"src/test/resources/cucumber/regiao/RegiaoInserir.feature",
			"src/test/resources/cucumber/regiao/RegiaoAlterar.feature",
			"src/test/resources/cucumber/regiao/RegiaoExcluir.feature"
			}, 
	snippets = SnippetType.CAMELCASE
	)
public class RegiaoIT {

}
