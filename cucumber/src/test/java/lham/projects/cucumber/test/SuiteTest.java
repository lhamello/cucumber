package lham.projects.cucumber.test;

import lham.projects.cucumber.continente.ContinenteIT;
import lham.projects.cucumber.infra.AppSettingsBeanUT;
import lham.projects.cucumber.pais.PaisIT;
import lham.projects.cucumber.regiao.RegiaoIT;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AppSettingsBeanUT.class, ContinenteIT.class, PaisIT.class, RegiaoIT.class})
public class SuiteTest {

}
