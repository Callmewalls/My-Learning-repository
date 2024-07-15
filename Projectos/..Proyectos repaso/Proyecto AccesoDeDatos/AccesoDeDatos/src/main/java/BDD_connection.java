import java.io.IOException;
import java.sql.*;

public class BDD_connection {

    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL_CONEXION = "jdbc:oracle:thin:@localhost:1521:DATABASEFORT";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        final String user = "sys as sysdba";
        final String pass = "Theparedes28!";
        Connection con = null;
        Statement stm = null;


        try
        {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL_CONEXION, user, pass);
            String query = "Select * from Testing where NAME like 'S%'";
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);

            while(rs.next())
            {
                String dni = rs.getString("DNI");
                String name = rs.getString("NAME");
                String lastname = rs.getString("LAST_NAME");
                String city = rs.getString("City");
                String cell = rs.getString("CELL_NUMBER");
                System.out.println("===================================================");
                System.out.println("dni --> " + dni);
                System.out.println("Name --> " + name);
                System.out.println("Last name: --> " + lastname);
                System.out.println("City --> " + city);
                System.out.println("Cellphone number --> " + cell);
                System.out.println("===================================================");
            }
        } finally
        {
            if(stm != null)
            {
                stm.close();
            }
            if(con != null)
            {
                con.close();
            }
        }
    }
}
