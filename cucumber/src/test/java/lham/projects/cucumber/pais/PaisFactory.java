package lham.projects.cucumber.pais;

import lham.projects.cucumber.continente.Continente;
import lham.projects.cucumber.continente.ContinenteFactory;
import lham.projects.cucumber.test.EntityFactory;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class PaisFactory extends EntityFactory {
	
	static public enum Template { 
		BR("BR"), CHL("CHL"), ITA("ITA"); 
		
		public String valor; 
		
		public String getValor() {
			return valor;
		}

		public void setValor(String valor) {
			this.valor = valor;
		}

		Template(String valor)	{
			setValor(valor); 
		} 
		
		@Override
		public String toString() {
			return this.getValor();
		}
	}
	
	public Pais criarPais(Template template) { 
		this.createTeamFixture();
		return Fixture.from(Pais.class).gimme(template.getValor());
	}
	
	private void createTeamFixture() {
		ContinenteFactory continenteFactory = new ContinenteFactory();
		final Continente ams = continenteFactory.criarContinente("ams");
		final Continente eur = continenteFactory.criarContinente("eur");
		
		Fixture.of(Pais.class).addTemplate(Template.BR.toString(), new Rule() {
			{
				add("nome", "brasil");
				add("codigo", "BR");
				add("continente", ams);
				add("dataHoraInclusao", calendar);
				add("ipUsuarioInclusao", random((Object[]) IP));
				add("usuarioInclusao", regex("\\d{10}"));
			}
		});
		
		Fixture.of(Pais.class).addTemplate(Template.CHL.toString(), new Rule() {
			{
				add("nome", "Chile");
				add("codigo", "CHL");
				add("continente", ams);
				add("dataHoraInclusao", calendar);
				add("ipUsuarioInclusao", random((Object[]) IP));
				add("usuarioInclusao", regex("\\d{10}"));
			}
		});
		
		Fixture.of(Pais.class).addTemplate(Template.ITA.toString(), new Rule() {
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
