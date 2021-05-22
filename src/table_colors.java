import java.sql.*;
import java.util.Scanner;

public class table_colors {

    String jdbcURL ="jdbc:postgresql://127.0.0.1:5432/ShowRoom";
    String username ="postgres";
    String password ="1369";
    Scanner scan = new Scanner(System.in);

    public void edit(){
        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Connect ");
            String query = "UPDATE public.colors SET  color=? WHERE id_color=? ";
            PreparedStatement _statement = connection.prepareStatement(query);
            int _int1 ;
            String color;
            System.out.print("Enter color (@user)--> ");
            color =scan.next();  _statement.setString(1,color);
            System.out.print("Enter id_color (@user)--> ");
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
            String query = "INSERT INTO public.colors(id_color, color)VALUES (?, ?)";
            PreparedStatement _statement = connection.prepareStatement(query);
            int _int1 ;
            String color;
            System.out.print("Enter id_color (@user)--> ");
            _int1 =scan.nextInt();  _statement.setInt(1,_int1);
            System.out.print("Enter color (@user)--> ");
            color =scan.next();  _statement.setString(2,color);
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
            String query = " DELETE FROM public.colors WHERE  id_color = ?" ;
            PreparedStatement _statement = connection.prepareStatement(query);
            int _int1;
            System.out.print("Enter id_color (@user)--> ");
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
                String query = "SELECT id_color, color FROM public.colors ORDER BY id_color" ;
                ResultSet rs = _statement.executeQuery(query);
                while(rs.next()){
                    System.out.println("\t|\t"+rs.getString(1)+"\t|\t"+rs.getString(2)+"\t|\t");
                }
                String query2 = "EXPLAIN ANALYSE SELECT id_color, color FROM public.colors ORDER BY id_color";
                ResultSet rs2 = _statement.executeQuery(query2);
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error");
                e.printStackTrace();
            }

            System.out.print("\n//==========( Menu )============//\n") ;
            System.out.print("//  1)Press to update table brands\n//" +
                            "  2)Press to add to table brands \n//" +
                            "  3)Press to remove from table brands\n//" +
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
