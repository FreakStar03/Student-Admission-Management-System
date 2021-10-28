package Backend;
import java.awt.Dimension;
import java.sql.*;
//import java.util.ArrayList;
//import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class test extends JPanel{  
   public test(){  
      try{
         Class.forName("com.mysql.cj.jdbc.Driver");  
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","Chiragsp","admin");  
         PreparedStatement Pstatement=con.prepareStatement("SELECT firstname, middlename, lastname FROM PersonalData WHERE id = ?");
         Pstatement.setInt(1, 8);
         ResultSet rs = Pstatement.executeQuery();
         String[] columnNames = {"Student ID", "Name", "DOB"};
         DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
         
         while (rs.next()) {
             String title = rs.getString("firstname");
             String season = rs.getString("middlename");
             String episode = rs.getString("lastname");
         
             // create a single array of one row's worth of data
             String[] data = { title, season, episode } ;
         
             // and add this row of data into the table model
             tableModel.addRow(data);
         }
         JTable jt = new JTable(tableModel); // to create a new JTable

         jt.setPreferredScrollableViewportSize(new Dimension(450, 63));
         jt.setFillsViewportHeight(true);

         JScrollPane jps = new JScrollPane(jt);
         add(jps);
      }catch(Exception e){ System.out.println(e);System.out.println("excpt");}        
   }
   public static void main(String[] args) {
      JFrame jf = new JFrame();
      test t = new test();
      jf.setTitle("Test");
      jf.setSize(500,500);
      jf.setVisible(true);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jf.add(t);  
}}
// SELECT a.*, b.*
// FROM studentReg as a
// INNER JOIN PersonalData as b ON a.id=b.id
