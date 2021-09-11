package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO 
{
    public static Connection connection() 
    {
        Connection connection = null;

        try 
        {
            String user = "root";
            String pass = "";
            String driver = "com.mysql.cj.jdbc.Driver";
            String local = "jdbc:mysql://localhost:3306/projeto_requisitos";

            Class.forName(driver);
            connection = DriverManager.getConnection( local, user, pass );
        }
        
        catch ( ClassNotFoundException ex ) 
        {
            System.out.println( "Erro ao conectar a database " + ex );
        } 
        
        catch ( SQLException ex ) 
        {
            System.out.println( "Erro ao conectar a database " + ex );
        }

        return connection;
    }

    public static void closeConnetion( Connection connection ) 
    {
        try 
        {
            if ( connection != null ) 
            {
                connection.close();
            }
        }
        
        catch ( SQLException ex ) 
        {
            ex.printStackTrace();
        }
    }
}
