package lham.projects.cucumber.regiao;

import lham.projects.cucumber.pais.Pais;
import lham.projects.cucumber.pais.PaisFactory;
import lham.projects.cucumber.test.EntityFactory;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class RegiaoFactory extends EntityFactory {

	public Regiao criarRegiao(String template) {
		this.createTeamFixture();
		return Fixture.from(Regiao.class).gimme(template);
	}

	private void createTeamFixture() {
		PaisFactory paisFactory = new PaisFactory();
		
		final Pais brasil = paisFactory.criarPais(PaisFactory.Template.BR);		
		final Pais chile = paisFactory.criarPais(PaisFactory.Template.CHL);
		
		Fixture.of(Regiao.class).addTemplate(RegiaoTemplateEnum.BR_SUL.toString(),
				new Rule() {
					{
						add("nomeRegiao", "Sul");
						add("pais", brasil);
						add("area", 2000L);
						add("dataHoraInclusao", calendar);
						add("ipUsuarioInclusao", random((Object[]) IP));
						add("usuarioInclusao", regex("\\d{10}"));
					}
				});
		Fixture.of(Regiao.class).addTemplate(RegiaoTemplateEnum.BR_NORTE.toString(),
				new Rule() {
					{
						add("nomeRegiao", "Norte");
						add("pais", brasil);
						add("area", 1000L);
						add("dataHoraInclusao", calendar);
						add("ipUsuarioInclusao", random((Object[]) IP));
						add("usuarioInclusao", regex("\\d{10}"));
					}
				});
		Fixture.of(Regiao.class).addTemplate(RegiaoTemplateEnum.BR_SUDESTE.toString(),
				new Rule() {
					{
						add("nomeRegiao", "sudeste");
						add("pais", brasil);
						add("area", 1000L);
						add("dataHoraInclusao", calendar);
						add("ipUsuarioInclusao", random((Object[]) IP));
						add("usuarioInclusao", regex("\\d{10}"));
					}
				});
		Fixture.of(Regiao.class).addTemplate(RegiaoTemplateEnum.BR_NORDESTE.toString(),
				new Rule() {
					{
						add("nomeRegiao", "Nordeste");
						add("pais", brasil);
						add("area", 1000L);
						add("dataHoraInclusao", calendar);
						add("ipUsuarioInclusao", random((Object[]) IP));
						add("usuarioInclusao", regex("\\d{10}"));
					}
				});
		Fixture.of(Regiao.class).addTemplate(RegiaoTemplateEnum.BR_CENTRO_OESTE.toString(),
				new Rule() {
					{
						add("nomeRegiao", "centro-oeste");
						add("pais", brasil);
						add("area", 1000L);
						add("dataHoraInclusao", calendar);
						add("ipUsuarioInclusao", random((Object[]) IP));
						add("usuarioInclusao", regex("\\d{10}"));
					}
				});
		
		

		
		Fixture.of(Regiao.class).addTemplate(RegiaoTemplateEnum.CHL_SUL.toString(),
				new Rule() {
					{
						add("nomeRegiao", "Sul");
						add("pais", chile);
						add("area", 1000L);
						add("dataHoraInclusao", calendar);
						add("ipUsuarioInclusao", random((Object[]) IP));
						add("usuarioInclusao", regex("\\d{10}"));
					}
				});
		Fixture.of(Regiao.class).addTemplate(RegiaoTemplateEnum.CHL_NORTE.toString(),
				new Rule() {
					{
						add("nomeRegiao", "Norte");
						add("pais", chile);
						add("area", 2000L);
						add("dataHoraInclusao", calendar);
						add("ipUsuarioInclusao", random((Object[]) IP));
						add("usuarioInclusao", regex("\\d{10}"));
					}
				});
		Fixture.of(Regiao.class).addTemplate(RegiaoTemplateEnum.CHL_LESTE.toString(),
				new Rule() {
					{
						add("nomeRegiao", "Leste");
						add("pais", chile);
						add("area", 2000L);
						add("dataHoraInclusao", calendar);
						add("ipUsuarioInclusao", random((Object[]) IP));
						add("usuarioInclusao", regex("\\d{10}"));
					}
				});
		Fixture.of(Regiao.class).addTemplate(RegiaoTemplateEnum.CHL_OESTE.toString(),
				new Rule() {
					{
						add("nomeRegiao", "Oeste");
						add("pais", chile);
						add("area", 2000L);
						add("dataHoraInclusao", calendar);
						add("ipUsuarioInclusao", random((Object[]) IP));
						add("usuarioInclusao", regex("\\d{10}"));
					}
				});
	}
}
