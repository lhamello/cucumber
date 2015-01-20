package lham.projects.cucumber.infra;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Bean que define configura��es da aplica��o.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
@Named(value = "appSettingsBean")
@RequestScoped
public class AppSettingsBean {

    private static final String APP_LAYOUT = "/WEB-INF/templates/layout-app.xhtml";

    /**
     * Construtor vazio padr�o.
     */
    public AppSettingsBean() {
        super();
    }

    /**
     * Retorna o template usado pelo <i>layout</i> das p�ginas da aplica��o.
     * 
     * @return <i>layout</i> usado pela aplica��o.
     */
    public String getLayout() {
        return APP_LAYOUT;
    }
}
