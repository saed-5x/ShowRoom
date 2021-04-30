import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class GUI {


    private JFrame frame;



    private JFrame frame2;



    private JTable table1;
    private JPanel panel1;
    private JPanel panel2;
    private JButton button1;
    private JButton button2;
    private JButton button3;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI window = new GUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



    public GUI(){

        initialize();

    }


    private void initialize(){


        String jdbcURL ="jdbc:postgresql://127.0.0.1:5432/ShowRoom";
        String username ="postgres";
        String password ="1369";


        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(panel1);

        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 0, 900, 800);
        frame.getContentPane().add(panel1);
        panel1.setLayout(null);

        JButton button1 = new JButton("Edit");
        button1.setBounds(50, 10, 89, 23);
        panel1.add(button1);

        JButton button2 = new JButton("Add");
        button2.setBounds(300, 10, 89, 23);
        panel1.add(button2);

        JButton button3 = new JButton("Remove");
        button3.setBounds(600, 10, 89, 23);
        panel1.add(button3);
        DefaultTableModel model = new DefaultTableModel();

        table1 = new JTable();
        panel1.add(table1);

        table1.setSurrendersFocusOnKeystroke(true);
        table1.setBorder(new LineBorder(new Color(255, 255, 255), 2));
        table1.setForeground(new Color(0, 0, 0));
        table1.setBackground(new Color(255, 255, 255));
        table1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table1.setBounds(10, 50, 880, 600);
        table1.setRowHeight(25);
        table1.setRowMargin(5);

        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table1.setFillsViewportHeight(true);
        table1.setModel(model);

        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            System.out.print("Connect ");

            Statement _statement = connection.createStatement();
            String query = "select  id_em, FName , LName , Phone , Email, Salary from Employees ";
            model.addColumn("Id");
            model.addColumn("FName");
            model.addColumn("LName");
            model.addColumn("Phone");
            model.addColumn("Email");
            model.addColumn("Salary");

            ResultSet rs = _statement.executeQuery(query);


            while(rs.next()){
                model.addRow(new Object[]{rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }


        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(e.getSource() == button1){



                }




            }
        });





    }






}
