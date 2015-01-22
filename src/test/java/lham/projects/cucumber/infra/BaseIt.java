package lham.projects.cucumber.infra;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.MavenResolverSystem;

import java.io.File;

/**
 * Created by rmpestano on 22/01/15.
 */
public class BaseIt {

    protected static final String WEB_INF= "src/main/webapp/WEB-INF";

    @Deployment
    public static WebArchive getBaseDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class);
        war.addPackages(true, "lham.projects.cucumber").
        addClass(DBUnitUtils.class);

        //LIBS
        MavenResolverSystem resolver = Maven.resolver();
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("org.primefaces:primefaces").withoutTransitivity().asSingleFile());
        war.addAsLibraries(resolver.loadPomFromFile("pom.xml").resolve("org.omnifaces:omnifaces").withoutTransitivity().asSingleFile());

        //WEB-INF

        war.addAsWebInfResource(new File(WEB_INF,"beans.xml"), "beans.xml");
        war.addAsWebInfResource(new File(WEB_INF,"web.xml"), "web.xml");
        war.addAsWebInfResource(new File(WEB_INF,"faces-config.xml"), "faces-config.xml");

        //resources
        war.addAsResource("persistence.xml", "META-INF/persistence.xml");
        war.addAsResource("datasets/continente.yml", "continente.yml");//needed by DBUnitUtils
        return war;
    }
}
