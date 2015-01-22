package lham.projects.cucumber.regiao;

import lham.projects.cucumber.pais.Pais;
import lham.projects.cucumber.pais.PaisFactory;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class RegiaoFactory {

	public Regiao criarRegiao(String template) {
		this.createTeamFixture();
		return Fixture.from(Regiao.class).gimme(template);
	}

	private void createTeamFixture() {
		PaisFactory paisFactory = new PaisFactory();
		
		final Pais brasil = paisFactory.criarPais("br");		
		final Pais chile = paisFactory.criarPais("chl");
		
		Fixture.of(Regiao.class).addTemplate("br-sul",
				new Rule() {
					{
						add("id", new RegiaoPK("Sul", brasil));
						add("area", 1000L);
					}
				});
		Fixture.of(Regiao.class).addTemplate("br-norte",
				new Rule() {
					{
						add("id", new RegiaoPK("Norte", brasil));
						add("area", 1000L);
					}
				});
		Fixture.of(Regiao.class).addTemplate("br-sudeste",
				new Rule() {
					{
						add("id", new RegiaoPK("sudeste", brasil));
						add("area", 1000L);
					}
				});
		Fixture.of(Regiao.class).addTemplate("br-nordeste",
				new Rule() {
					{
						add("id", new RegiaoPK("—ordeste", brasil));
						add("area", 1000L);
					}
				});
		Fixture.of(Regiao.class).addTemplate("br-centrooeste",
				new Rule() {
					{
						add("id", new RegiaoPK("centro-oeste", brasil));
						add("area", 1000L);
					}
				});
		
		

		
		Fixture.of(Regiao.class).addTemplate("chl-sul",
				new Rule() {
					{
						add("id", new RegiaoPK("Sul", chile));
						add("area", 1000L);
					}
				});
		Fixture.of(Regiao.class).addTemplate("chl-norte",
				new Rule() {
					{
						add("id", new RegiaoPK("·Norte", chile));
						add("area", 1000L);
					}
				});
		Fixture.of(Regiao.class).addTemplate("chl-leste",
				new Rule() {
					{
						add("id", new RegiaoPK("Leste", chile));
						add("area", 1000L);
					}
				});
		Fixture.of(Regiao.class).addTemplate("chl-oeste",
				new Rule() {
					{
						add("id", new RegiaoPK("Oeste", chile));
						add("area", 1000L);
					}
				});
	}
}
