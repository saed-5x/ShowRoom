import java.util.Scanner;

public class Main {

    public static void main(String [] args){

        table_auto_v table1 = new table_auto_v();
        table_brands table2 = new table_brands();
        table_clients table3 = new table_clients();
        table_colors table4 = new table_colors();
        table_employees table5 = new table_employees();
        table_positions table6 = new table_positions();
        table_sales table7 = new table_sales();
        table_showrooms table8 = new table_showrooms();
        table_type_vehicle table9 = new table_type_vehicle();
        Scanner scan = new Scanner(System.in);
        int call;

        do{
            System.out.print("\n//=================( Menu )================//\n") ;
            System.out.print(   "//  1)Press to get in table auto_v         //\n" +
                                "//  2)Press to get in table brands         //\n" +
                                "//  3)Press to get in table clients        //\n" +
                                "//  4)Press to get in table colors         //\n" +
                                "//  5)Press to get in table Employees      //\n" +
                                "//  6)Press to get in table positions      //\n" +
                                "//  7)Press to get in table sales          //\n" +
                                "//  8)Press to get in table showrooms      //\n" +
                                "//  9)Press to get in table type vehicle   //\n" +
                                "// 10)Press to close                       //\n") ;
            System.out.print(   "//=========================================//\n(@user)--> ");
            call =scan.nextInt();

            if ( call ==1){
                table1.run();
            }else if (call == 2){
                table2.run();
            }else if(call == 3){
                table3.run();
            }else if(call == 4){
                table4.run();
            }else if(call == 5){
                table5.run();
            }else if(call == 6){
                table6.run();
            }else if(call == 7){
                table7.run();
            }else if(call == 8){
                table8.run();
            }else if(call == 9){
                table9.run();
            }
            else if(call == 10){System.exit(1);}
            else{System.out.print("(@user)-->\n"); }

        }while (call != 10);
    }
}
