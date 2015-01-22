package lham.projects.cucumber.pais;

import lham.projects.cucumber.continente.Continente;
import lham.projects.cucumber.continente.ContinenteFactory;
import lham.projects.cucumber.test.EntityFactory;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class PaisFactory extends EntityFactory {

	private Continente continente;
	
	static public enum Template { 
		BR("BR"),CHL("CHL"); 
		
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
	
	public Pais criarPais(String template) { 
		this.createTeamFixture();
		return Fixture.from(Pais.class).gimme(template);
	}
	
	public Pais criarPais(Template template, Continente  cont) { 
		setContinente(cont);
		this.createTeamFixture();
		return Fixture.from(Pais.class).gimme(template.toString());
	}
	
	private void createTeamFixture() {
		ContinenteFactory continenteFactory = new ContinenteFactory();
		Fixture.of(Pais.class).addTemplate(Template.BR.toString(), new Rule() {
			{
				add("nome", "ábrasil");
				add("codigo", "BR");
				add("continente", continente);
				add("dataHoraInclusao", calendar);
				add("ipUsuarioInclusao", random((Object[]) IP));
				add("usuarioInclusao", regex("\\d{10}"));
			}
		});
		
		Fixture.of(Pais.class).addTemplate(Template.CHL.toString(), new Rule() {
			{
				add("nome", "ÁChile");
				add("codigo", "CHL");
				add("continente", continente);
				add("dataHoraInclusao", calendar);
				add("ipUsuarioInclusao", random((Object[]) IP));
				add("usuarioInclusao", regex("\\d{10}"));
			}
		});
		
	}

	public Continente getContinente() {
		return continente;
	}

	public void setContinente(Continente continente) {
		this.continente = continente;
	}
}
