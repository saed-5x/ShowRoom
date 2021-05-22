import java.sql.*;
import java.util.Scanner;

public class table_showrooms {

    String jdbcURL ="jdbc:postgresql://127.0.0.1:5432/ShowRoom";
    String username ="postgres";
    String password ="1369";
    Scanner scan = new Scanner(System.in);

    public void edit(){

        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Connect ");
            String query = "UPDATE public.showrooms SET  region=?, city=?, address=? WHERE  id_sr=? ";
            PreparedStatement _statement = connection.prepareStatement(query);
            String _string1 ,_string2,_string3,_string4;
            int _int1;
            System.out.print("Enter region (@user)--> ");
            _string1 =scan.next();  _statement.setString(1,_string1);
            System.out.print("Enter city (@user)--> ");
            _string2 =scan.next();  _statement.setString(2,_string2);
            System.out.print("Enter address (@user)--> ");
            _string3 =scan.next();  _statement.setString(3,_string3);
            System.out.print("Enter id_sr (@user)--> ");
            _int1 =scan.nextInt();  _statement.setInt(4,_int1);
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
            String query = "INSERT INTO public.showrooms(id_sr, region, city, address)VALUES (?, ?, ?, ?)" ;
            PreparedStatement _statement = connection.prepareStatement(query);
            String _string1 ,_string2,_string3; int _int1;
            System.out.print("Enter id_sr (@user)--> ");
            _int1 =scan.nextInt();  _statement.setInt(1,_int1);
            System.out.print("Enter region (@user)--> ");
            _string1 =scan.next();  _statement.setString(2,_string1);
            System.out.print("Enter city (@user)--> ");
            _string2 =scan.next();  _statement.setString(3,_string2);
            System.out.print("Enter address (@user)--> ");
            _string3 =scan.next();  _statement.setString(4,_string3);
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
            String query = " DELETE FROM public.showrooms WHERE  id_sr = ?" ;
            PreparedStatement _statement = connection.prepareStatement(query);
            int _int1;
            System.out.print("Enter id_sr (@user)--> ");
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
                String query = "SELECT id_sr, region, city, address FROM public.showrooms ORDER BY id_sr ";
                ResultSet rs = _statement.executeQuery(query);
                while(rs.next()){
                    System.out.println("\t|\t"+rs.getString(1)+"\t|\t"+rs.getString(2)+"\t|\t"+rs.getString(3)+"\t|\t"+rs.getString(4)+"\t|\t");
                }
                String query2 = "EXPLAIN ANALYSE  SELECT id_sr, region, city, address FROM public.showrooms ORDER BY id_sr";
                ResultSet rs2 = _statement.executeQuery(query2);
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error");
                e.printStackTrace();
            }

            System.out.print("\n//==========( Menu )============//\n") ;
            System.out.print("//  1)Press to update table ShowRooms\n//" +
                            "  2)Press to add to table ShowRooms \n//" +
                            "  3)Press to remove from table ShowRooms\n//" +
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
