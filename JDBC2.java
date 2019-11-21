package jdbc2;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC2{
    public static void main(String args[]){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con =DriverManager.getConnection("jdbc:derby://localhost:1527/DB1", "localhost", "123456");
            CallableStatement cstmt= con.prepareCall("{call gettotal(?)}");
            cstmt.registerOutParameter(1,java.sql.Types.NUMERIC);
            cstmt.execute();
            int tot=cstmt.getInt(1);
            System.out.println("Total students number "+" "+tot);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}