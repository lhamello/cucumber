package lham.projects.cucumber.continente;

import lham.projects.cucumber.test.EntityFactory;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class ContinenteFactory extends EntityFactory {
	
	public static enum Template {
		AMS, AMN, AFR, ASI, EUR, OCE
	}

	public static Continente criarContinente(String template) {
		ContinenteFactory.createTeamFixture();
		return Fixture.from(Continente.class).gimme(template);
	}

	private static void createTeamFixture() {
		Fixture.of(Continente.class).addTemplate(ContinenteFactory.Template.AMS.name(), new Rule() {
			{
				add("nome", "America do Sul");
				add("codigo", "AMS");
				add("dataHoraInclusao", calendar);
				add("ipUsuarioInclusao", random((Object[]) IP));
				add("usuarioInclusao", regex("\\d{10}"));
			}
		});
		Fixture.of(Continente.class).addTemplate(ContinenteFactory.Template.AMN.name(), new Rule() {
			{
				add("nome", "america do norte");
				add("codigo", "AMN");
				add("dataHoraInclusao", calendar);
				add("ipUsuarioInclusao", random((Object[]) IP));
				add("usuarioInclusao", regex("\\d{10}"));
			}
		});
		Fixture.of(Continente.class).addTemplate(ContinenteFactory.Template.AFR.name(), new Rule() {
			{
				add("nome", "africa");
				add("codigo", "AFR");
				add("dataHoraInclusao", calendar);
				add("ipUsuarioInclusao", random((Object[]) IP));
				add("usuarioInclusao", regex("\\d{10}"));
			}
		});
		Fixture.of(Continente.class).addTemplate(ContinenteFactory.Template.ASI.name(), new Rule() {
			{
				add("nome", "ASIA");
				add("codigo", "ASI");
				add("dataHoraInclusao", calendar);
				add("ipUsuarioInclusao", random((Object[]) IP));
				add("usuarioInclusao", regex("\\d{10}"));
			}
		});
		Fixture.of(Continente.class).addTemplate(ContinenteFactory.Template.EUR.name(), new Rule() {
			{
				add("nome", "Europa");
				add("codigo", "EUR");
				add("dataHoraInclusao", calendar);
				add("ipUsuarioInclusao", random((Object[]) IP));
				add("usuarioInclusao", regex("\\d{10}"));
			}
		});
		Fixture.of(Continente.class).addTemplate(ContinenteFactory.Template.OCE.name(), new Rule() {
			{
				add("nome", "Oceania");
				add("codigo", "OCE");
				add("dataHoraInclusao", calendar);
				add("ipUsuarioInclusao", random((Object[]) IP));
				add("usuarioInclusao", regex("\\d{10}"));
			}
		});
	}
}
