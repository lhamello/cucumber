package lham.projects.cucumber.infra;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.operation.DatabaseOperation;
import org.jboss.arquillian.persistence.dbunit.dataset.yaml.YamlDataSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.SQLException;

public class DBUnitUtils {

    private static DataSource ds;

    private static DatabaseConnection databaseConnection;

    public static void createDataset(String dataset) {

        if (!dataset.startsWith("/")) {
            dataset = "/" + dataset;
        }
        try {
            initConn();
            DatabaseOperation.CLEAN_INSERT.execute(databaseConnection, new YamlDataSet(DBUnitUtils.class.getResourceAsStream(dataset)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("could not initialize dataset:" + dataset + " \nmessage: " + e.getMessage());
        } finally {
            closeConn();
        }
    }

    public static void deleteDataset(String dataset) {
        if (!dataset.startsWith("/")) {
            dataset = "/" + dataset;
        }
        try {
            initConn();
            DatabaseOperation.DELETE_ALL.execute(databaseConnection, new YamlDataSet(DBUnitUtils.class.getResourceAsStream(dataset)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("could not delete dataset dataset:" + dataset + " \nmessage: " + e.getMessage());
        } finally {
            closeConn();
        }
    }

    private static void closeConn() {
        try {
            if (databaseConnection != null && !databaseConnection.getConnection().isClosed()) {
                databaseConnection.getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("could not close conection \nmessage: " + e.getMessage());
        }

    }

    private static void initConn() throws SQLException, NamingException, DatabaseUnitException {
        if (ds == null) {
            ds = (DataSource) new InitialContext().lookup("java:jboss/datasources/ExampleDS");
        }
        databaseConnection = new DatabaseConnection(ds.getConnection());
    }


}
