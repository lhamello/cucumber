package lham.projects.cucumber.pais;

import lham.projects.cucumber.continente.Continente;
import lham.projects.cucumber.continente.ContinenteFactory;
import lham.projects.cucumber.test.EntityFactory;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class PaisFactory extends EntityFactory {
	
	public static enum Template { 
		BR, CHL, ITA;
	}
	
	public static Pais criarPais(String template) { 
		PaisFactory.createTeamFixture();
		return Fixture.from(Pais.class).gimme(template);
	}
	
	private static void createTeamFixture() {
		final Continente ams = ContinenteFactory.criarContinente(ContinenteFactory.Template.AMS.name());
		final Continente eur = ContinenteFactory.criarContinente(ContinenteFactory.Template.EUR.name());
		
		Fixture.of(Pais.class).addTemplate(Template.BR.name(), new Rule() {
			{
				add("nome", "brasil");
				add("codigo", "BR");
				add("continente", ams);
				add("dataHoraInclusao", calendar);
				add("ipUsuarioInclusao", random((Object[]) IP));
				add("usuarioInclusao", regex("\\d{10}"));
			}
		});
		
		Fixture.of(Pais.class).addTemplate(Template.CHL.name(), new Rule() {
			{
				add("nome", "Chile");
				add("codigo", "CHL");
				add("continente", ams);
				add("dataHoraInclusao", calendar);
				add("ipUsuarioInclusao", random((Object[]) IP));
				add("usuarioInclusao", regex("\\d{10}"));
			}
		});
		
		Fixture.of(Pais.class).addTemplate(Template.ITA.name(), new Rule() {
			{
				add("nome", "Itália");
				add("codigo", "ITA");
				add("continente", eur);
				add("dataHoraInclusao", calendar);
				add("ipUsuarioInclusao", random((Object[]) IP));
				add("usuarioInclusao", regex("\\d{10}"));
			}
		});
		
	}
}
