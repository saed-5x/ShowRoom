import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class table_employees {

    String jdbcURL ="jdbc:postgresql://127.0.0.1:5432/ShowRoom";
    String username ="postgres";
    String password ="1369";
    Scanner scan = new Scanner(System.in);

    public void edit(){

        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Connect ");
            String query = "update Employees   set FName = ? , LName = ?  ,  Phone = ?  ,  Email = ? ,  Salary = ?  where id_em = ? ";
            PreparedStatement _statement = connection.prepareStatement(query);
            String _string1 ,_string2,_string3,_string4;
            BigDecimal _string5;
            int _int1;
            System.out.print("Enter FName (@user)--> ");
            _string1 =scan.next();  _statement.setString(1,_string1);
            System.out.print("Enter LName (@user)--> ");
            _string2 =scan.next();  _statement.setString(2,_string2);
            System.out.print("Enter Phone (@user)--> ");
            _string3 =scan.next();  _statement.setString(3,_string3);
            System.out.print("Enter Email (@user)--> ");
            _string4 =scan.next();  _statement.setString(4,_string4);
            System.out.print("Enter Salary (@user)--> ");
            _string5 =scan.nextBigDecimal(); _statement.setBigDecimal(5,_string5);
            System.out.print("Enter id_em (@user)--> ");
            _int1 =scan.nextInt();  _statement.setInt(6,_int1);
            int rowAffected = _statement.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public void add(){

        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Connect ");
            String query = "INSERT INTO EMPLOYEES (ID_EM,FK_ID_SR,FK_ID_POSITION,FNAME,LNAME,PHONE,EMAIL,SALARY)VALUES(?,?,?,?,?,?,?,?)" ;
            PreparedStatement _statement = connection.prepareStatement(query);
            String _string1 ,_string2,_string3,_string4;
            BigDecimal _string5;
            int _int1;
            System.out.print("Enter id_em (@user)--> ");
            _int1 =scan.nextInt();  _statement.setInt(1,_int1);
            int _int2;
            System.out.print("Enter fk_id_sr (@user)--> ");
            _int2 =scan.nextInt();  _statement.setInt(2,_int2);
            int _int3;
            System.out.print("Enter fk_id_position (@user)--> ");
            _int3 =scan.nextInt();  _statement.setInt(3,_int3);
            System.out.print("Enter FName (@user)--> ");
            _string1 =scan.next();  _statement.setString(4,_string1);
            System.out.print("Enter LName (@user)--> ");
            _string2 =scan.next();  _statement.setString(5,_string2);
            System.out.print("Enter Phone (@user)--> ");
            _string3 =scan.next();  _statement.setString(6,_string3);
            System.out.print("Enter Email (@user)--> ");
            _string4 =scan.next();  _statement.setString(7,_string4);
            System.out.print("Enter Salary (@user)--> ");
            _string5 =scan.nextBigDecimal();  _statement.setBigDecimal(8,_string5);
            int rowAffected = _statement.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public void delete(){
        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Connect ");
            String query = " delete from  EMPLOYEES where id_em = ?" ;
            PreparedStatement _statement = connection.prepareStatement(query);
            int _int1;
            System.out.print("Enter id_em (@user)--> ");
            _int1 =scan.nextInt();  _statement.setInt(1,_int1);
            int rowAffected = _statement.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public void run(){
        int call;
        do{
            try {
                Connection connection = DriverManager.getConnection(jdbcURL,username,password);
                System.out.println("Connect ");
                Statement _statement = connection.createStatement();
                String query = "select  id_em, FName , LName , Phone , Email, Salary from Employees order by id_em ";
                ResultSet rs = _statement.executeQuery(query);
                while(rs.next()){
                    System.out.println("\t|\t"+rs.getString(1)+"\t|\t"+rs.getString(2)+"\t|\t"+rs.getString(3)+"\t|\t"+rs.getString(4)+"\t|\t"+rs.getString(5)+"\t|\t"+rs.getString(6)+"\t|\t");
                }
                String query2 = "EXPLAIN ANALYSE  select  id_em, FName , LName , Phone , Email, Salary from Employees order by id_em ";
                ResultSet rs2 = _statement.executeQuery(query2);
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error");
                e.printStackTrace();
            }

            System.out.print("\n//==========( Menu )============//\n") ;
            System.out.print("//  1)Press to update table Employees\n//" +
                            "  2)Press to add to table Employees \n//" +
                            "  3)Press to remove from table Employees\n//" +
                            "  4)Press to return to menu\n") ;
            System.out.print(  "//==============================//\n(@user)--> ");
            call =scan.nextInt();

            if ( call ==1){
                edit();
            }else if (call == 2){
                add();
            }else if(call == 3){
                delete();
            }
            else{
                System.out.print("(@user)-->\n");
            }

        }while (call !=4);
    }
}
