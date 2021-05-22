import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class table_auto_v {

    String jdbcURL ="jdbc:postgresql://127.0.0.1:5432/ShowRoom";
    String username ="postgres";
    String password ="1369";
    Scanner scan = new Scanner(System.in);

    public void edit(){
        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Connect ");
            String query = "UPDATE public.auto_v SET  fk_id_sr=?, fk_id_brand=?, fk_id_tv=?, module=?, fk_id_color=?, year=?, count=?, price=? WHERE id_auto = ? ";
            PreparedStatement _statement = connection.prepareStatement(query);
            int _int1 ,_int2,_int3,_int4,_int5,_int6,_int7;
            String year,module;
            BigDecimal _string5;
            Date myDate = null;
            System.out.print("Enter fk_id_sr (@user)--> ");
            _int1 =scan.nextInt();  _statement.setInt(1,_int1);
            System.out.print("Enter fk_id_brand (@user)--> ");
            _int2 =scan.nextInt();  _statement.setInt(2,_int2);
            System.out.print("Enter fk_id_tv (@user)--> ");
            _int3 =scan.nextInt();  _statement.setInt(3,_int3);
            System.out.print("Enter module (@user)--> ");
            module =scan.next();  _statement.setString(4,module);
            System.out.print("Enter fk_id_color (@user)--> ");
            _int5 =scan.nextInt();  _statement.setInt(5,_int5);
            System.out.print("Enter year (@user)--> ");
            year =scan.next();  myDate=java.sql.Date.valueOf(year);
            _statement.setDate(6, myDate);
            System.out.print("Enter count (@user)--> ");
            _int6 =scan.nextInt();  _statement.setInt(7,_int6);
            System.out.print("Enter price (@user)--> ");
            _string5 =scan.nextBigDecimal(); _statement.setBigDecimal(8,_string5);
            System.out.print("Enter id_auto (@user)--> ");
            _int7 =scan.nextInt();  _statement.setInt(9,_int7);
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
            String query = "INSERT INTO public.auto_v(id_auto, fk_id_sr, fk_id_brand, fk_id_tv, module, fk_id_color, year, count, price)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);" ;
            PreparedStatement _statement = connection.prepareStatement(query);
            int _int1 ,_int2,_int3,_int5,_int6,_int7;
            String year,module;
            Date myDate = null;
            BigDecimal _string5;
            System.out.print("Enter id_auto (@user)--> ");
            _int7 =scan.nextInt();  _statement.setInt(1,_int7);
            System.out.print("Enter fk_id_sr (@user)--> ");
            _int1 =scan.nextInt();  _statement.setInt(2,_int1);
            System.out.print("Enter fk_id_brand (@user)--> ");
            _int2 =scan.nextInt();  _statement.setInt(3,_int2);
            System.out.print("Enter fk_id_tv (@user)--> ");
            _int3 =scan.nextInt();  _statement.setInt(4,_int3);
            System.out.print("Enter module (@user)--> ");
            module =scan.next();  _statement.setString(5,module);
            System.out.print("Enter fk_id_color (@user)--> ");
            _int5 =scan.nextInt();  _statement.setInt(6,_int5);
            System.out.print("Enter year (@user)--> ");
            year =scan.next();  myDate=java.sql.Date.valueOf(year);
            _statement.setDate(7, myDate);
            System.out.print("Enter count (@user)--> ");
            _int6 =scan.nextInt();  _statement.setInt(8,_int6);
            System.out.print("Enter price (@user)--> ");
            _string5 =scan.nextBigDecimal(); _statement.setBigDecimal(9,_string5);
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
            String query = " DELETE FROM public.auto_v WHERE id_auto = ?" ;
            PreparedStatement _statement = connection.prepareStatement(query);
            int _int1;
            System.out.print("Enter id_auto (@user)--> ");
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
                String query = "SELECT id_auto, fk_id_sr, fk_id_brand, fk_id_tv, module, fk_id_color, year, count, price FROM public.auto_v ORDER BY id_auto ";
                ResultSet rs = _statement.executeQuery(query);
                while(rs.next()){
                    System.out.println("\t|\t"+rs.getString(1)+"\t|\t"+rs.getString(2)+"\t|\t"+rs.getString(3)+"\t|\t"+rs.getString(4)+"\t|\t"+rs.getString(5)+"\t|\t"+rs.getString(6)+"\t|\t"+rs.getString(7)+"\t|\t"+rs.getString(8)+"\t|\t"+rs.getString(9)+"\t|\t");
                }
                String query2 = "EXPLAIN ANALYSE  SELECT id_auto, fk_id_sr, fk_id_brand, fk_id_tv, module, fk_id_color, year, count, price FROM public.auto_v ORDER BY id_auto";
                ResultSet rs2 = _statement.executeQuery(query2);
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error");
                e.printStackTrace();
            }

            System.out.print("\n//==========( Menu )============//\n") ;
            System.out.print("//  1)Press to update table auto_v\n//" +
                                "  2)Press to add to table auto_v \n//" +
                                "  3)Press to remove from table auto_v\n//" +
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
