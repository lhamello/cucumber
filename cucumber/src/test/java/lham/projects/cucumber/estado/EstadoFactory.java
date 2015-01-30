package lham.projects.cucumber.estado;

import lham.projects.cucumber.regiao.Regiao;
import lham.projects.cucumber.regiao.RegiaoFactory;
import lham.projects.cucumber.test.EntityFactory;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class EstadoFactory extends EntityFactory {
	
	public static enum Template {
		BR_SUL_RS
	}

	public static Estado criarEstado(String template) {
		EstadoFactory.createTeamFixture();
		return Fixture.from(Estado.class).gimme(template);
	}

	private static void createTeamFixture() {
		final Regiao brSul = RegiaoFactory.criar(RegiaoFactory.Template.BR_SUL.name());
		
		Fixture.of(Estado.class).addTemplate(EstadoFactory.Template.BR_SUL_RS.name(), new Rule() {
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
