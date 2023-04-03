import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private String db_driver = "com.mysql.cj.jdbc.Driver";
    private String db_url = "jdbc:mysql://localhost/innout";
    private String db_user = "Innoutadmin";
    private String db_pwd = "Innoutadmin";

    public ConnectionDB() {
        Connection con = null;

        try {
            Class.forName(db_driver);
            con = DriverManager.getConnection(db_url, db_user, db_pwd);
            System.out.println("Connect");
        } catch (ClassNotFoundException e) {
            System.out.println("Not found Driver");
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        } finally {
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                    System.out.println("Connection Closed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String getDb_driver() {
        return db_driver;
    }

    public String getDb_ur() {
        return db_url;
    }

    public String getDb_user() {
        return db_user;
    }

    public String getDb_pwd() {
        return db_pwd;
    }
}
