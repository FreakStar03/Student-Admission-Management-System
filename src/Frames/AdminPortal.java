package Frames;
import javax.imageio.ImageIO;
//IMPORTS
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Dimension;
import java.sql.*;
import java.awt.event.*;
import sql.conn;
import javax.swing.table.DefaultTableModel;

public class AdminPortal extends JFrame{
   //GLOBAL VARIABLE
    static int Tstart = 0; 
    static int Tend = 20; 
    static String MbranchSort = "ALL";
    static String MEligibleSort = "yes";
    static String SearchData = "%%";

//Constructor
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
        JLabel Branch = new JLabel("Eligible Only:", JLabel.CENTER); 
        JLabel Search = new JLabel("Search:", JLabel.CENTER); 
        JLabel SB = new JLabel("Sort By:", JLabel.CENTER); 
        String conditionYN[] = {"yes", "no"};        
        JComboBox<String> EligibleDropDown = new JComboBox<> (conditionYN); 
        JTextField SearchField = new JTextField();
        String sortBy[] = {"ALL", "CS", "IT", "EXTC", "MECH" };
        JComboBox<String> SBField = new JComboBox<> (sortBy);
        JPanel bg = new JPanel();

        //add
        pane.add(title);
        pane.add(subTitle);
        pane.add(Logout);
        pane.add(Branch);
        pane.add(Search);
        pane.add(SB);
        pane.add(EligibleDropDown);
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
        EligibleDropDown.setBounds(153,111,190,35);
        SearchField.setBounds(540,111,340,35);
        SBField.setBounds(1089,111,148,35);
        bg.setBounds(19,170,1241,520);

        //ARRAY FOR Table
         String[] columnNames = { "PdID", "id", "firstname", "middlename", "lastname", "phoneno1", "phoneno2",
               "address", "email", "dob", "city", "state", "pincode", "photoAddress", "IdAddress","Bid" ,"id" , "Course", "PaymentID", "Branch", "Year" , "Rid", "id", "SSC", "HSC", "MHCET", "JEE", "sscCert", "hscCert", "mhCert", "jeeCert", "eligible"};
         DefaultTableModel tableModel = new DefaultTableModel(my_db_select(), columnNames);


         JPanel tablePanel = new JPanel();
         JTable jt = new JTable(tableModel); // to create a new JTable
         jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         jt.setPreferredScrollableViewportSize(new Dimension(800, 320 ));
         jt.setFillsViewportHeight(true);

         JScrollPane jps = new JScrollPane(jt);
        // System.out.println(Tstart);
         JLabel pageNumber = new JLabel(Integer.toString(Tstart / 20 + 1), JLabel.CENTER);
         JButton prevbtn = new JButton("Prev");
         JButton nextbtn = new JButton("Next");
         tablePanel.setBounds(58,202,1165,457);
         tablePanel.add(jps);

         prevbtn.setBounds(489,590,137,44);
         pageNumber.setBounds(600,590,137,44);
         nextbtn.setBounds(710,590,137,44);
         pane.add(prevbtn);
         pane.add(pageNumber);
         pane.add(nextbtn);
         pane.add(tablePanel);
         pane.add(bg);

         //Button Press
         jt.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jt.rowAtPoint(evt.getPoint());
                int col = jt.columnAtPoint(evt.getPoint());
                if (col == 13 || col == 14 || col == 27 || col == 28 || col == 29 || col == 30 ) {
                   try{
                        String file_path =  (String) jt.getModel().getValueAt(row, col);
                        //System.out.println(file_path);
                        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")  + file_path));
                        JLabel picLabel = new JLabel(new ImageIcon(image));
                        JOptionPane.showMessageDialog(null, picLabel, "About", JOptionPane.PLAIN_MESSAGE, null);
                   }catch(Exception e){

                   }
                }
             }
            });
         SBField.setSelectedItem(MbranchSort);
         SBField.addItemListener(event -> {
            String item = (String) event.getItem();
            if (event.getStateChange() == ItemEvent.SELECTED) {
                MbranchSort = item;
                AdminPortal main = new AdminPortal();
                main.setVisible(true);
                dispose();
            };
        });

         EligibleDropDown.setSelectedItem(MEligibleSort);
         EligibleDropDown.addItemListener(event -> {
           // The item affected by the event.
           String item = (String) event.getItem();
           if (event.getStateChange() == ItemEvent.SELECTED) {
               MEligibleSort = item;
               AdminPortal main = new AdminPortal();
               main.setVisible(true);
               dispose();
           };
         });
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
            dispose();
         });

         SearchField.addKeyListener(new KeyAdapter() {//Search on Enter CODE
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                   
                   if (SearchField.getText().isEmpty() == false) {
                     SearchData = "%" + SearchField.getText() + "%";
                     AdminPortal main = new AdminPortal();
                     main.setVisible(true);
                     dispose();
                  }
                  else {
                     SearchData = "%%";
                     AdminPortal main = new AdminPortal();
                     main.setVisible(true);
                     dispose();
                  }

                }
            }
    
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

    //Table Writer for Db

    public  String[][] my_db_select() {
        
        String[][] data ={ }  ;
        int start = Tstart;
        int end = Tend;
        String branchSort = MbranchSort ;
        try{  
           Class.forName("com.mysql.cj.jdbc.Driver");  
           Connection con=DriverManager.getConnection(conn.Conn, conn.Conn_user, conn.Conn_pw);  
           Statement st=con.createStatement();
           ResultSet rs;
           if (branchSort != "ALL") {
              rs=st.executeQuery("SELECT a.*, b.*, c.* FROM PersonalData as a LEFT JOIN BranchData as b ON a.id=b.id LEFT JOIN RegistrationData as c ON b.id = c.id WHERE c.eligible = '" + MEligibleSort+ "' AND CONCAT_WS('',firstname, lastname, middlename) LIKE '" + SearchData +"' AND b.Branch ='" + branchSort + "' LIMIT " + start + "," + end);
           }
           else {
              rs=st.executeQuery("SELECT a.*, b.*, c.* FROM PersonalData as a LEFT JOIN BranchData as b ON a.id=b.id LEFT JOIN RegistrationData as c ON b.id = c.id Where c.eligible = '" + MEligibleSort+ "' AND CONCAT_WS('',firstname, lastname, middlename) LIKE '" + SearchData +"' LIMIT " + start + "," + end);
           }
           ResultSetMetaData rsmd = rs.getMetaData();
           String[][] dataTemp = new String[20][rsmd.getColumnCount()]; // [rows][columns]
           data = dataTemp;  
        
        // Looping to store result in returning array data // 
           int i=0;
           while(rs.next())  {
           for(int j=0;j<rsmd.getColumnCount();j++) {
           //System.out.print(rs.getString(j+1));
           data[i][j]=rs.getString(j+1);
           }
           //System.out.println();
           i=i+1;
           }
        con.close();  
     }catch(Exception e){ System.out.println(e);} 
     return data;
        }
};



