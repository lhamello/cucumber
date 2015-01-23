package lham.projects.cucumber.regiao;

import lham.projects.cucumber.pais.Pais;
import lham.projects.cucumber.pais.PaisFactory;
import lham.projects.cucumber.test.EntityFactory;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class RegiaoFactory extends EntityFactory {

	public Regiao criarRegiao(RegiaoTemplateEnum template) {
		this.createTeamFixture();
		return Fixture.from(Regiao.class).gimme(template.toString());
	}

	private void createTeamFixture() {
		PaisFactory paisFactory = new PaisFactory();
		
		final Pais brasil = paisFactory.criarPais(PaisFactory.Template.BR);		
		final Pais chile = paisFactory.criarPais(PaisFactory.Template.CHL);
		
		Fixture.of(Regiao.class).addTemplate(RegiaoTemplateEnum.BR_SUL.toString(),
				new Rule() {
					{
						add("id", new RegiaoPK("Sul", brasil));
						add("area", 1000L);
						add("dataHoraInclusao", calendar);
						add("ipUsuarioInclusao", random((Object[]) IP));
						add("usuarioInclusao", regex("\\d{10}"));
					}
				});
		Fixture.of(Regiao.class).addTemplate(RegiaoTemplateEnum.BR_NORTE.toString(),
				new Rule() {
					{
						add("id", new RegiaoPK("Norte", brasil));
						add("area", 1000L);
						add("dataHoraInclusao", calendar);
						add("ipUsuarioInclusao", random((Object[]) IP));
						add("usuarioInclusao", regex("\\d{10}"));
					}
				});
		Fixture.of(Regiao.class).addTemplate(RegiaoTemplateEnum.BR_SUDESTE.toString(),
				new Rule() {
					{
						add("id", new RegiaoPK("sudeste", brasil));
						add("area", 1000L);
						add("dataHoraInclusao", calendar);
						add("ipUsuarioInclusao", random((Object[]) IP));
						add("usuarioInclusao", regex("\\d{10}"));
					}
				});
		Fixture.of(Regiao.class).addTemplate(RegiaoTemplateEnum.BR_NORDESTE.toString(),
				new Rule() {
					{
						add("id", new RegiaoPK("Nordeste", brasil));
						add("area", 1000L);
						add("dataHoraInclusao", calendar);
						add("ipUsuarioInclusao", random((Object[]) IP));
						add("usuarioInclusao", regex("\\d{10}"));
					}
				});
		Fixture.of(Regiao.class).addTemplate(RegiaoTemplateEnum.BR_CENTRO_OESTE.toString(),
				new Rule() {
					{
						add("id", new RegiaoPK("centro-oeste", brasil));
						add("area", 1000L);
						add("dataHoraInclusao", calendar);
						add("ipUsuarioInclusao", random((Object[]) IP));
						add("usuarioInclusao", regex("\\d{10}"));
					}
				});
		
		

		
		Fixture.of(Regiao.class).addTemplate(RegiaoTemplateEnum.CHL_SUL.toString(),
				new Rule() {
					{
						add("id", new RegiaoPK("Sul", chile));
						add("area", 1000L);
						add("dataHoraInclusao", calendar);
						add("ipUsuarioInclusao", random((Object[]) IP));
						add("usuarioInclusao", regex("\\d{10}"));
					}
				});
		Fixture.of(Regiao.class).addTemplate(RegiaoTemplateEnum.CHL_NORTE.toString(),
				new Rule() {
					{
						add("id", new RegiaoPK("Norte", chile));
						add("area", 1000L);
						add("dataHoraInclusao", calendar);
						add("ipUsuarioInclusao", random((Object[]) IP));
						add("usuarioInclusao", regex("\\d{10}"));
					}
				});
		Fixture.of(Regiao.class).addTemplate(RegiaoTemplateEnum.CHL_LESTE.toString(),
				new Rule() {
					{
						add("id", new RegiaoPK("Leste", chile));
						add("area", 1000L);
						add("dataHoraInclusao", calendar);
						add("ipUsuarioInclusao", random((Object[]) IP));
						add("usuarioInclusao", regex("\\d{10}"));
					}
				});
		Fixture.of(Regiao.class).addTemplate(RegiaoTemplateEnum.CHL_OESTE.toString(),
				new Rule() {
					{
						add("id", new RegiaoPK("Oeste", chile));
						add("area", 1000L);
						add("dataHoraInclusao", calendar);
						add("ipUsuarioInclusao", random((Object[]) IP));
						add("usuarioInclusao", regex("\\d{10}"));
					}
				});
	}
}
