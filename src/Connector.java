
import java.sql.Connection;
import java.sql.DriverManager;
import configReader.Configreader;

public class Connector {
  private static final String URL = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
  private static final String NAME = "root";
  private static final String PASSWORD = "Under3lily*o";
  private static Connection conn = null;
  static {
    try {
      //+ "password=yourpassword;"
         // + "user=EVANCLARK\\a1527@localhost;"

      Configreader reader = Configreader.reader("config.txt");
      String connectionUrl =
          "jdbc:sqlserver://localhost:1433;"
                  + "database="+ reader.readItem("databasename")+";"
                  + "integratedSecurity=true;"
                  + "loginTimeout=5;";

      conn = DriverManager.getConnection(connectionUrl);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  
  public static Connection getConnection() {
    return conn;
  }
  
  public static void main(String[] args) {
    Connector connector = new Connector(); 
  }
}
