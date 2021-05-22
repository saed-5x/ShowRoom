import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class table_type_vehicle {

    String jdbcURL ="jdbc:postgresql://127.0.0.1:5432/ShowRoom";
    String username ="postgres";
    String password ="1369";
    Scanner scan = new Scanner(System.in);

    public void edit(){
        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Connect ");
            String query = "UPDATE public.type_vehicle SET type_vehicle=? WHERE  id_tv=? ";
            PreparedStatement _statement = connection.prepareStatement(query);
            int _int1 ;
            String type_vehicle;
            System.out.print("Enter type_vehicle (@user)--> ");
            type_vehicle =scan.next();  _statement.setString(1,type_vehicle);
            System.out.print("Enter id_tv (@user)--> ");
            _int1 =scan.nextInt();  _statement.setInt(2,_int1);
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
            String query = "INSERT INTO public.type_vehicle(id_tv, type_vehicle)VALUES (?, ?)";
            PreparedStatement _statement = connection.prepareStatement(query);
            int _int1 ;
            String type_vehicle;
            System.out.print("Enter id_tv (@user)--> ");
            _int1 =scan.nextInt();  _statement.setInt(1,_int1);
            System.out.print("Enter type_vehicle (@user)--> ");
            type_vehicle =scan.next();  _statement.setString(2,type_vehicle);
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
            String query = " DELETE FROM public.type_vehicle WHERE  id_tv = ?" ;
            PreparedStatement _statement = connection.prepareStatement(query);
            int _int1;
            System.out.print("Enter id_tv (@user)--> ");
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
                String query = "SELECT id_tv, type_vehicle FROM public.type_vehicle ORDER BY id_tv" ;
                ResultSet rs = _statement.executeQuery(query);
                while(rs.next()){
                    System.out.println("\t|\t"+rs.getString(1)+"\t|\t"+rs.getString(2)+"\t|\t");
                }
                String query2 = "EXPLAIN ANALYSE  SELECT id_tv, type_vehicle FROM public.type_vehicle ORDER BY id_tv";
                ResultSet rs2 = _statement.executeQuery(query2);
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error");
                e.printStackTrace();
            }

            System.out.print("\n//==========( Menu )============//\n") ;
            System.out.print("//  1)Press to update table Type_vehicle\n//" +
                            "  2)Press to add to table Type_vehicle \n//" +
                            "  3)Press to remove from table Type_vehicle\n//" +
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
