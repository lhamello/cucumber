package lham.projects.cucumber.cidade;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class CidadeFactory {

	public Cidade criarContinente(String template) {
		this.createTeamFixture();
		return Fixture.from(Cidade.class).gimme(template);
	}

	private void createTeamFixture() {
		Fixture.of(Cidade.class).addTemplate("ams", new Rule() {
			{
				add("nome", "América do Sul");
				add("codigo", "AMS");
			}
		});
	}
}
