package lham.projects.cucumber.infra;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Bean que define configurações da aplicação.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
@Named(value = "appSettingsBean")
@RequestScoped
public class AppSettingsBean {

    private static final String APP_LAYOUT = "/WEB-INF/templates/layout-app.xhtml";

    /**
     * Construtor vazio padrão.
     */
    public AppSettingsBean() {
        super();
    }

    /**
     * Retorna o template usado pelo <i>layout</i> das páginas da aplicação.
     * 
     * @return <i>layout</i> usado pela aplicação.
     */
    public String getLayout() {
        return APP_LAYOUT;
    }
}
