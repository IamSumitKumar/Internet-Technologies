/*1: Create Student and Results Database and perform the following using JDBC programs,
a. Find total number of students
b. Print average marks for each subject input by user.
c. Find the name of student getting highest marks.
d. Find no of students getting first, second and third division.
e. Find subject wise toppers
f. Find the average marks
g. Find the student getting second highest marks.
*/
//!!! Resource @tutorials duniya

package jdbc1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBC1{
    public static void main(String[] args){
        ResultSet rs;
        Scanner sc = new Scanner(System.in);
        try{
        int c1=0;
        int c2=0;
        int c3=0;
        int c4=0;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con =DriverManager.getConnection("jdbc:derby://localhost:1527/DB1", "localhost", "123456");
        Statement st= con.createStatement();
        do{ 
            System.out.println("MENU");
            System.out.println("1.Find total students");
            System.out.println("2.Each subject avergae marks");
            System.out.println("3.Student name with highest marks");
            System.out.println("4.No of students getting first second and third doivision");
            System.out.println("5.Subject wise toppers");
            System.out.println("6.Average marks");
            System.out.println("7.Students getting second highest marks");
            System.out.println("\nEnter the choice : ");

            int ch;
            String sub;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //Scanner sc = new Scanner(System.in);
            ch=sc.nextInt();

            switch(ch){
                case 1: rs= st.executeQuery("select count(*) total from STUDENTS");
                        rs.next();
                        int tota =rs.getInt("total");
                        System.out.println(tota);
                        break;

		case 2: //System.out.println("");
                        //sub=sc.next();
                        String sql1="select AVG(S1Marks) as S1Marks from RESULT";
                        String sql2="select AVG(S2Marks) as S2Marks from RESULT";
                        String sql3="select AVG(S3Marks) as S3Marks from RESULT";
                        String sql4="select AVG(S4Marks) as S4Marks from RESULT";
                        rs=st.executeQuery(sql1);
                        rs=st.executeQuery(sql2);
                        rs=st.executeQuery(sql3);
                        rs=st.executeQuery(sql4);
                        rs.next();
                        int s1=rs.getInt("S1Marks");
                        int s2=rs.getInt("S2Marks");
                        int s3=rs.getInt("S3Marks");
                        int s4=rs.getInt("S4Marks");
                        System.out.println("Sub1 "+"Sub2 "+"Sub3 "+"Sub4");
                        System.out.println(s1+" "+s2+" "+s3+" "+s4);
			break;

                case 3: System.out.println(" ");
                        rs = st.executeQuery("select s.SName as name from STUDENTS s RESULT r, where r.RSID=s.SID and (select max(GainedMarks) from RESULT r)");
                        rs.next();
                        String n=rs.getString("name");
                        System.out.println("The student with highest marks is "+" "+n);
			break;

                case 4: rs=st.executeQuery("select SID,(SUM(S1Marks, S2Marks, S3Marks, S4Marks)/400)*100 AS 'DIV' from RESULT GROUP BY RSID");
	                while(rs.next()){
        	                if(rs.getInt("div")>90){
                	            c1++;
                                }
				else if(rs.getInt("div")<90&&rs.getInt("div")>60){
                                    c2++;
				}
				else if(rs.getInt("div")<60&&rs.getInt("div")>33){
                                    c3++;
				}
				else{
                                    c4++;
				}
			}
                        System.out.println(+c1);
                        System.out.println(+c2);
                        System.out.println(+c3);
                        System.out.println(+c4);
			break;

		case 5: rs=st.executeQuery("select s.SName as 'name',r.S1Marks as 'sub', max(r.S1Marks) from student s,RESULT r where r.RSID=s.SID group by S1Marks");
                        rs=st.executeQuery("select s.SName as 'name',r.S2Marks as 'sub', max(r.S2Marks) from student s,RESULT r where r.RSID=s.SID group by S2Marks");
                        rs=st.executeQuery("select s.SName as 'name',r.S3Marks as 'sub', max(r.S3Marks) from student s,RESULT r where r.RSID=s.SID group by S3Marks");
                        rs=st.executeQuery("select s.SName as 'name',r.S4Marks as 'sub', max(r.S4Marks) from student s,RESULT r where r.RSID=s.SID group by S4Marks");
                        while(rs.next()){
                            System.out.println("max marks in "+rs.getString("sub")+"is of "+rs.getString("name"));
                        }
                        break;

		case 6: rs=st.executeQuery("select s.SName as 'name',avg(r.GainedMarks) as 'avg' from STUDENTS s, RESULT r where s.SID=r.RSID group by r.RSID");
                        while(rs.next()){
                            System.out.println("Average marks of "+rs.getString("name")+"are"+rs.getInt("avg"));
			}
			break;

                case 7: rs=st.executeQuery("select s.SName,SUM(r.GainedMarks)) as 'tota' from STUDENTS s RESULT r where r.RSID=s.SID GROUP BY r.RSID ORDER BY TOTA");
                        System.out.println(" second topeer"+rs.getString("name"));
                        break;
			}
	
		System.out.println("Do u want to continue y\n");
            String S = br.readLine();
            if(S.startsWith("n")){
                System.exit(0);
            }
        } while(true);
    }
    /*catch(Exception e)
    {
        System.out.println(e);
        // TODO code application logic here
    }*/
    catch(ClassNotFoundException e){
        System.out.println("Unable to load Driver "+e);
    }
    catch(SQLException e){
        System.out.println("Unable to connect "+e);
    }   catch (IOException ex) {
            Logger.getLogger(JDBC1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
