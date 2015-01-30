package lham.projects.cucumber.regiao;

import lham.projects.cucumber.pais.Pais;
import lham.projects.cucumber.pais.PaisFactory;
import lham.projects.cucumber.test.EntityFactory;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class RegiaoFactory extends EntityFactory {
	
	public static enum Template {
		BR_SUL, BR_NORTE, BR_SUDESTE, BR_NORDESTE, BR_CENTRO_OESTE, 
		CHL_SUL, CHL_NORTE, CHL_LESTE, CHL_OESTE;
	}

	public static Regiao criar(String template) {
		RegiaoFactory.createTeamFixture();
		return Fixture.from(Regiao.class).gimme(template);
	}

	private static void createTeamFixture() {
		
		final Pais brasil = PaisFactory.criarPais(PaisFactory.Template.BR.name());		
		final Pais chile = PaisFactory.criarPais(PaisFactory.Template.CHL.name());
		
		Fixture.of(Regiao.class).addTemplate(RegiaoFactory.Template.BR_SUL.name(),
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
		Fixture.of(Regiao.class).addTemplate(RegiaoFactory.Template.BR_NORTE.name(),
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
		Fixture.of(Regiao.class).addTemplate(RegiaoFactory.Template.BR_SUDESTE.name(),
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
		Fixture.of(Regiao.class).addTemplate(RegiaoFactory.Template.BR_NORDESTE.name(),
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
		Fixture.of(Regiao.class).addTemplate(RegiaoFactory.Template.BR_CENTRO_OESTE.name(),
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
		
		

		
		Fixture.of(Regiao.class).addTemplate(RegiaoFactory.Template.CHL_SUL.name(),
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
		Fixture.of(Regiao.class).addTemplate(RegiaoFactory.Template.CHL_NORTE.name(),
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
		Fixture.of(Regiao.class).addTemplate(RegiaoFactory.Template.CHL_LESTE.name(),
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
		Fixture.of(Regiao.class).addTemplate(RegiaoFactory.Template.CHL_OESTE.name(),
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
