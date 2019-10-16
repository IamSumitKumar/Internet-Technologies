package sk@codeworld;
import java.sql.*;
import java.util.Scanner;

public class JavaConn {

    public static void main(String[] args) {
        Connection con;
        Statement st;
        //PreparedStatement pst;
        Scanner S = new Scanner(System.in);
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/DB1", "localhost", "123456");
            /*System.out.println("Enter customer id's : ");
            int Cid = S.nextInt();
            System.out.println("Enter customer name : ");
            String Cname = S.next();
            System.out.println("Enter customer age : ");
            int Cage = S.nextInt();
            System.out.println("Enter customer salary : ");
            Double Salary = S.nextDouble();
            
            String query = "insert into Customer2 values(?, ?, ?, ?)";
            pst = con.prepareStatement(query);
            pst.setInt(1, Cid);
            pst.setString(2, Cname);
            pst.setInt(3, Cage);
            pst.setDouble(4, Salary);
            
            int a = pst.executeUpdate();
            System.out.println(+a+" row inserted successfully.");
            pst.close();*/
            //st = con.createStatement();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select * from Customer2 where Cage = 20";
            //pst = con.prepareStatement(query);
            //String query = "insert into Customer2 values(115, 'Sankit', 19, 43995.75)";
            /*String query = "create table Customer2(Cid int primary key, Cname varchar(12),"
                    + " Cage int, Salary decimal(10,2))";*/
            //int rs = st.executeUpdate(query); //to execute a query......
            ResultSet rs = st.executeQuery(query); //if a resultset to retrieve......
            //System.out.println("1 tuple inserted.");
            //System.out.println("Table created successfully.");
            System.out.println("------Retrieved ResultSet------\nCID\tCname\tCage\tSalary");
            while(rs.next()){
                int Cid = rs.getInt(1);
                String Cname = rs.getString(2);
                int Cage = rs.getInt(3);
                double Salary = rs.getDouble(4);
                System.out.println(Cid+"\t"+Cname+"\t"+Cage+"\t"+Salary+"\t");
            }
            System.out.println("Tuple just previous of current one exists: "+rs.previous());
            System.out.println("Tuple just before -1 position of current one exists: "+rs.relative(-1));
            System.out.println("Next tuple at +1 position after last tuple exists: "+rs.absolute(1));
            System.out.println("Next tuple at +1 position after last tuple exists: "+rs.absolute(2));
        }
        catch(ClassNotFoundException e){
            System.out.println("Unable to load Driver" + e);
        }
        catch(SQLException e){
            System.out.println("Unable to Connect " + e);
        }
    }
}