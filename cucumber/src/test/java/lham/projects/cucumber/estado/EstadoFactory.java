package lham.projects.cucumber.estado;

import lham.projects.cucumber.regiao.Regiao;
import lham.projects.cucumber.regiao.RegiaoFactory;
import lham.projects.cucumber.regiao.RegiaoTemplateEnum;
import lham.projects.cucumber.test.EntityFactory;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class EstadoFactory extends EntityFactory {

	public Estado criarEstado(String template) {
		this.createTeamFixture();
		return Fixture.from(Estado.class).gimme(template);
	}

	private void createTeamFixture() {
		final Regiao brSul = new RegiaoFactory().criarRegiao(RegiaoTemplateEnum.BR_SUL.toString());
		
		Fixture.of(Estado.class).addTemplate("BR_SUL_RS", new Rule() {
			{
				add("sigla", "RS");
				add("regiao", brSul);
				add("dataHoraInclusao", calendar);
				add("ipUsuarioInclusao", random((Object[]) IP));
				add("usuarioInclusao", regex("\\d{10}"));
			}
		});
	}
}
