package Frames;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.sql.*;
//import java.util.ArrayList;
//import java.util.Arrays;
 import javax.swing.table.DefaultTableModel;
public class AdminPortal extends JFrame{
    static int Tstart = 0; 
    static int Tend = 20; 

    public AdminPortal(){
        setTitle("Admin Portal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 750);
        setLocationRelativeTo(null);
        setResizable(false);


        //plane
        JPanel pane = new JPanel();
        add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.white);
        pane.setSize(1280, 720);
        
        //bgPlane
        JPanel bgPlane = new JPanel();
        bgPlane.setBackground(Color.decode("#EDE3E3"));
        bgPlane.setBounds(36,95,1208,590);

        //obj
        JLabel title = new JLabel("A P Shah Institude Of Technology", JLabel.CENTER); 
        JLabel subTitle = new JLabel("Admin Panel", JLabel.CENTER); 
        JLabel Logout = new JLabel("Logout", JLabel.CENTER); 
        JLabel Branch = new JLabel("Branch:", JLabel.CENTER); 
        JLabel Search = new JLabel("Search:", JLabel.CENTER); 
        JLabel SB = new JLabel("Sort By:", JLabel.CENTER); 
        JTextField BranchField = new JTextField(); 
        JTextField SearchField = new JTextField();
        String sortBy[] = { "Alphabetical", "By ID", "Date" };
        JComboBox<String> SBField = new JComboBox<> (sortBy);

        JPanel bg = new JPanel();

        //add
        pane.add(title);
        pane.add(subTitle);
        pane.add(Logout);
        pane.add(Branch);
        pane.add(Search);
        pane.add(SB);
        pane.add(BranchField);
        pane.add(SearchField);
        pane.add(SBField);

        //style
        title.setFont(new Font("Serif", Font.PLAIN, 30));
        title.setOpaque(true);
        title.setBackground(Color.lightGray);

        subTitle.setFont(new Font("Serif", Font.PLAIN, 20));
        Logout.setForeground(Color.blue);

        //setBounds
        title.setBounds(0,0,1280,40);
        Logout.setBounds(1089,56,148,44);
        subTitle.setBounds(0,56,1280,45);
        Branch.setBounds(0,111,153,40);
        Search.setBounds(400,111,140,40);
        SB.setBounds(955,111,134,40);
        BranchField.setBounds(153,111,190,35);
        SearchField.setBounds(540,111,340,35);
        SBField.setBounds(1089,111,148,35);
        bg.setBounds(19,170,1241,520);

         String[] columnNames = { "PdID", "id", "firstname", "middlename", "lastname", "phoneno1", "phoneno2",
               "address", "email", "dob", "city", "state", "pincode", "photoAddress", "IdAddress" };
         DefaultTableModel tableModel = new DefaultTableModel(my_db_select(), columnNames);


         JPanel tablePanel = new JPanel();
         JTable jt = new JTable(tableModel); // to create a new JTable
         jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         //jt.setBounds(58,202,1165,460);
         jt.setPreferredScrollableViewportSize(new Dimension(800, 320 ));
         jt.setFillsViewportHeight(true);
         //jt.setDefaultEditor(Object.class, null);

         JScrollPane jps = new JScrollPane(jt);
         JButton prevbtn = new JButton("Prev");
         JButton nextbtn = new JButton("Next");
         tablePanel.setBounds(58,202,1165,457);
         tablePanel.add(jps);
        //  tablePanel.add(prevbtn);
        //  tablePanel.add(nextbtn);
         prevbtn.setBounds(489,590,137,44);
         nextbtn.setBounds(710,590,137,44);
         pane.add(prevbtn);
         pane.add(nextbtn);
         pane.add(tablePanel);
         pane.add(bg);
         //setBounds(54,202,1165,460);

         prevbtn.addActionListener(e -> {
            if (Tstart == 0 && Tend == 20) {
               Tstart = 0;
               Tend = 20;
               //prevbtn.setEnabled(false);
            } else {
               Tstart -= 20;
               Tend -= 20;
               AdminPortal main = new AdminPortal();
               main.setVisible(true);
               // setVisible(false);
               dispose();
            }
         });
         nextbtn.addActionListener(e -> {
            Tstart += 20;
            Tend += 20;
            AdminPortal main = new AdminPortal();
            main.setVisible(true);
            // setVisible(false);
            dispose();

         });
        Logout.addMouseListener(new MouseAdapter()   {   
            public void mouseClicked(MouseEvent e)   
            { 
                LoginFormS rg = new LoginFormS();
                setVisible(false);
                rg.setVisible(true);   
            }});

        setVisible(true);
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
           String[][] dataTemp = new String[20][rsmd.getColumnCount()]; // [rows][columns]
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



