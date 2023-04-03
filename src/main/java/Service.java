import java.sql.*;
import java.time.LocalDate;

public class Service {
    private static String db_driver = "com.mysql.cj.jdbc.Driver";
    private static String db_url = "jdbc:mysql://localhost/innout";
    private static String db_user = "Innoutadmin";
    private static String db_pwd = "Innoutadmin";

    private static Connection con = null;
    private static PreparedStatement pstmt = null;

    private static ResultSet rs = null;
    private static Statement stmt = null;

    private static LocalDate date = LocalDate.now();

    public static void Deposit(int cash) {
        try {
            Class.forName(db_driver);
            con = DriverManager.getConnection(db_url, db_user, db_pwd);
            String sql = "INSERT INTO BALANCE VALUES (?,?,?)";
            pstmt = con.prepareStatement(sql);

            pstmt.setDate(1, Date.valueOf(date));
            pstmt.setString(2, "입금");
            pstmt.setInt(3, cash);

            int count = pstmt.executeUpdate();
            if (count == 0) {
                System.out.println("Failed to Insert Data");
            } else {
                System.out.println("Success to Insert Data");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Not Found Driver");
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        } finally {
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
                if (pstmt != null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static void Withdraw(int cash) {
        try {
            Class.forName(db_driver);
            con = DriverManager.getConnection(db_url, db_user, db_pwd);
            String sql = "INSERT INTO BALANCE VALUES (?,?,?)";
            pstmt = con.prepareStatement(sql);

            pstmt.setDate(1, Date.valueOf(date));
            pstmt.setString(2, "출금");
            pstmt.setInt(3, cash);

            int count = pstmt.executeUpdate();
            if (count == 0) {
                System.out.println("Failed to Insert Data");
            } else {
                System.out.println("Success to Insert Data");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Not Found Driver");
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        } finally {
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
                if (pstmt != null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static void Check() {
        try {
            Class.forName(db_driver);
            con = DriverManager.getConnection(db_url, db_user, db_pwd);
            stmt = con.createStatement();
            String sql = "SELECT * FROM BALANCE";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Date localDate = rs.getDate(1);
                String type = rs.getString(2);
                int cash = rs.getInt(3);

                System.out.println("날짜 : " + localDate + ", 타입 : " + type + ", 금액 : " + cash);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Not Found Driver");
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        } finally {
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
                if (stmt != null && !stmt.isClosed()) {
                    stmt.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
