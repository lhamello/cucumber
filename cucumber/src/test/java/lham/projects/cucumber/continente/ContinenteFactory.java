package lham.projects.cucumber.continente;

import lham.projects.cucumber.test.EntityFactory;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class ContinenteFactory extends EntityFactory {

	public Continente criarContinente(String template) {
		this.createTeamFixture();
		return Fixture.from(Continente.class).gimme(template);
	}

	private void createTeamFixture() {
		Fixture.of(Continente.class).addTemplate("ams", new Rule() {
			{
				add("nome", "America do Sul");
				add("codigo", "AMS");
				add("dataHoraInclusao", calendar);
				add("ipUsuarioInclusao", random((Object[]) IP));
				add("usuarioInclusao", regex("\\d{10}"));
			}
		});
		Fixture.of(Continente.class).addTemplate("amn", new Rule() {
			{
				add("nome", "america do norte");
				add("codigo", "AMN ");
				add("dataHoraInclusao", calendar);
				add("ipUsuarioInclusao", random((Object[]) IP));
				add("usuarioInclusao", regex("\\d{10}"));
			}
		});
		Fixture.of(Continente.class).addTemplate("afr", new Rule() {
			{
				add("nome", "africa");
				add("codigo", "AFR ");
				add("dataHoraInclusao", calendar);
				add("ipUsuarioInclusao", random((Object[]) IP));
				add("usuarioInclusao", regex("\\d{10}"));
			}
		});
		Fixture.of(Continente.class).addTemplate("asi", new Rule() {
			{
				add("nome", "ASIA");
				add("codigo", "ASI ");
				add("dataHoraInclusao", calendar);
				add("ipUsuarioInclusao", random((Object[]) IP));
				add("usuarioInclusao", regex("\\d{10}"));
			}
		});
		Fixture.of(Continente.class).addTemplate("eur", new Rule() {
			{
				add("nome", "Europa");
				add("codigo", "EUR ");
				add("dataHoraInclusao", calendar);
				add("ipUsuarioInclusao", random((Object[]) IP));
				add("usuarioInclusao", regex("\\d{10}"));
			}
		});
		Fixture.of(Continente.class).addTemplate("oce", new Rule() {
			{
				add("nome", "Oceania");
				add("codigo", "OCE ");
				add("dataHoraInclusao", calendar);
				add("ipUsuarioInclusao", random((Object[]) IP));
				add("usuarioInclusao", regex("\\d{10}"));
			}
		});
	}
}
