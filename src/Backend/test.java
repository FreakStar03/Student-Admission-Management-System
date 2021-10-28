package Backend;
import java.awt.Dimension;
import java.sql.*;
//import java.util.ArrayList;
//import java.util.Arrays;

import javax.swing.*;
 import javax.swing.table.DefaultTableModel;
// import javax.tools.JavaFileObject;
//import javax.swing.table.TableColumnModel;

// import com.mysql.cj.xdevapi.JsonArray;

public class test extends JFrame{ 
   static int Tstart = 0; 
   static int Tend = 10; 
   public test(){ 
         setTitle("Test");
         setSize(500,500);

         JPanel panel = new JPanel();
         String[] columnNames = { "PdID", "id", "firstname", "middlename", "lastname", "phoneno1", "phoneno2",
               "address", "email", "dob", "city", "state", "pincode", "photoAddress", "IdAddress" };
         DefaultTableModel tableModel = new DefaultTableModel(my_db_select(), columnNames);

         JTable jt = new JTable(tableModel); // to create a new JTable
         jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         jt.setPreferredScrollableViewportSize(new Dimension(450, 300));
         jt.setFillsViewportHeight(true);
         jt.setDefaultEditor(Object.class, null);

         JScrollPane jps = new JScrollPane(jt);
         JButton prevbtn = new JButton("Prev");
         JButton nextbtn = new JButton("Next");

         panel.add(jps);
         panel.add(prevbtn);
         panel.add(nextbtn);

         prevbtn.addActionListener(e -> {

            if (Tstart == 0 && Tend == 10) {
               Tstart = 0;
               Tend = 10;
            } else {
               Tstart -= 10;
               Tend -= 10;
               test main = new test();
               main.setVisible(true);
               // setVisible(false);
               dispose();
            }
         });
         nextbtn.addActionListener(e -> {
            Tstart += 10;
            Tend += 10;
            test main = new test();
            main.setVisible(true);
            // setVisible(false);
            dispose();

         });

         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         add(panel);
         setVisible(true);
      }

   public static void main(String[] args) {
      new test();
}

   public  String[][] my_db_select() {
      ////////////
      String[][] data ={ }  ;
      int start = Tstart;
      int end = Tend;
      try{  
         Class.forName("com.mysql.cj.jdbc.Driver");  
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","Chiragsp","admin");  
         Statement st=con.createStatement();
         ResultSet rs=st.executeQuery("SELECT * FROM PersonalData LIMIT " + start + "," + end);
         ResultSetMetaData rsmd = rs.getMetaData();
         String[][] dataTemp = new String[10][rsmd.getColumnCount()]; // [rows][columns]
         data = dataTemp;  
      
      // Looping to store result in returning array data // 
         int i=0;
         while(rs.next())  {
         for(int j=0;j<rsmd.getColumnCount();j++) {
         System.out.print(rs.getString(j+1));
         data[i][j]=rs.getString(j+1);
         }
         //System.out.println();
         i=i+1;
         }
      con.close();  
   }catch(Exception e){ System.out.println(e);} 

   return data;
      }
   }
// SELECT a.*, b.*
// FROM studentReg as a
// INNER JOIN PersonalData as b ON a.id=b.id
