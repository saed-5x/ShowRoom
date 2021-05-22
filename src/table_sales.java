import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class table_sales {

    String jdbcURL ="jdbc:postgresql://127.0.0.1:5432/ShowRoom";
    String username ="postgres";
    String password ="1369";
    Scanner scan = new Scanner(System.in);

    public void edit(){
        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Connect ");
            String query = "UPDATE public.sales SET  fk_id_em=?, fk_id_client=?, fk_id_auto=?, price=?, count=?, date=? WHERE id_sale=?";
            PreparedStatement _statement = connection.prepareStatement(query);
            int _int1 ,_int2,_int3,_int4,_int5;
            String year ;
            BigDecimal _string5;
            Date myDate = null;
            System.out.print("Enter fk_id_em (@user)--> ");
            _int1 =scan.nextInt();  _statement.setInt(1,_int1);
            System.out.print("Enter fk_id_client (@user)--> ");
            _int2 =scan.nextInt();  _statement.setInt(2,_int2);
            System.out.print("Enter fk_id_auto (@user)--> ");
            _int3 =scan.nextInt();  _statement.setInt(3,_int3);
            System.out.print("Enter price (@user)--> ");
            _string5 =scan.nextBigDecimal(); _statement.setBigDecimal(4,_string5);
            System.out.print("Enter count (@user)--> ");
            _int4 =scan.nextInt();  _statement.setInt(5,_int4);
            System.out.print("Enter year (@user)--> ");
            year =scan.next();  myDate=java.sql.Date.valueOf(year);
            _statement.setDate(6, myDate);
            System.out.print("Enter id_sale (@user)--> ");
            _int5 =scan.nextInt();  _statement.setInt(7,_int5);
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
            String query = "INSERT INTO public.sales(id_sale, fk_id_em, fk_id_client, fk_id_auto, price, count, date)VALUES (?, ?, ?, ?, ?, ?, ?)" ;
            PreparedStatement _statement = connection.prepareStatement(query);
            int _int1 ,_int2,_int3,_int4,_int5;
            String year ;
            BigDecimal _string5;
            Date myDate = null;
            System.out.print("Enter id_sale (@user)--> ");
            _int5 =scan.nextInt();  _statement.setInt(1,_int5);
            System.out.print("Enter fk_id_em (@user)--> ");
            _int1 =scan.nextInt();  _statement.setInt(2,_int1);
            System.out.print("Enter fk_id_client (@user)--> ");
            _int2 =scan.nextInt();  _statement.setInt(3,_int2);
            System.out.print("Enter fk_id_auto (@user)--> ");
            _int3 =scan.nextInt();  _statement.setInt(4,_int3);
            System.out.print("Enter price (@user)--> ");
            _string5 =scan.nextBigDecimal(); _statement.setBigDecimal(5,_string5);
            System.out.print("Enter count (@user)--> ");
            _int4 =scan.nextInt();  _statement.setInt(6,_int4);
            System.out.print("Enter year (@user)--> ");
            year =scan.next();  myDate=java.sql.Date.valueOf(year);
            _statement.setDate(7, myDate);
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
            String query = " DELETE FROM public.sales WHERE id_sale = ?" ;
            PreparedStatement _statement = connection.prepareStatement(query);
            int _int1;
            System.out.print("Enter id_sale (@user)--> ");
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
                String query = "SELECT id_sale, fk_id_em, fk_id_client, fk_id_auto, price, count, date FROM public.sales ORDER BY id_sale";
                ResultSet rs = _statement.executeQuery(query);
                while(rs.next()){
                    System.out.println("\t|\t"+rs.getString(1)+"\t|\t"+rs.getString(2)+"\t|\t"+rs.getString(3)+"\t|\t"+rs.getString(4)+"\t|\t"+rs.getString(5)+"\t|\t"+rs.getString(6)+"\t|\t"+rs.getString(7)+"\t|\t");
                }
                String query2 = "EXPLAIN ANALYSE  SELECT id_sale, fk_id_em, fk_id_client, fk_id_auto, price, count, date FROM public.sales ORDER BY id_sale";
                ResultSet rs2 = _statement.executeQuery(query2);
                connection.close();

            } catch (SQLException e) {
                System.out.println("Error");
                e.printStackTrace();
            }

            System.out.print("\n//==========( Menu )============//\n") ;
            System.out.print("//  1)Press to update table sales\n//" +
                                "  2)Press to add to table sales \n//" +
                                "  3)Press to remove from table sales\n//" +
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
