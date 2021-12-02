package Frames;
// IMPORTS 
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.filechooser.*;
import java.sql.*;
import LibExtra.JTextFieldLimit;
import java.io.*;
import java.nio.file.*;
import sql.conn; //conn file in .sql/conn


public class addmissionForm extends JFrame {
    //Global Variables
    static ArrayList<String> List= new ArrayList<String>();
    static int StudentID;
    static String sscCerti;
    static String hscCerti;
    static String mhcetCerti;
    static String jeeCerti;

    //Constructor
    public addmissionForm(int ID) {
        StudentID = ID;

        setTitle("Addmission Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);// close java prog on close of window
        setSize(1280, 720);// window size
        setLayout(null);// layout to null for window
        setLocationRelativeTo(null);// start window in center on monitor
        setResizable(false);// avoid window scaling

        // plane
        JPanel panel = new JPanel();
        panel.setLayout(null);

        add(panel);
        panel.setSize(1280, 720);

        //Component 
        JLabel title = new JLabel("Qualification Details", JLabel.CENTER);//labels
        JLabel subtitle = new JLabel("Academics details", JLabel.CENTER);
        JLabel sscText = new JLabel("SSC Percentage:" );
        JLabel hscText = new JLabel("HSC Percentage:");
        JLabel mhText = new JLabel("MH-Cet Percentile:");
        JLabel jeeText = new JLabel("JEE Percentile:");
        JLabel outof1 = new JLabel(" /100%");
        JLabel outof2 = new JLabel(" /100%");
        JLabel outof3 = new JLabel(" /100%");
        JLabel outof4 = new JLabel(" /100%");
        JLabel alerttext = new JLabel("Alert: Check all values.", JLabel.CENTER);
        JTextField ssc = new JTextField();//textfield
        JTextField hsc = new JTextField();
        JTextField mhcet = new JTextField();
        JTextField jee = new JTextField();
        JButton subssc =  new JButton("No SSC Certificate" );//buttons
        JButton subhsc =  new JButton("No HSC Certificate");
        JButton submh =  new JButton("No MH-Cet Certificate");
        JButton subjee =  new JButton("No JEE Certificate");
        JButton submit =  new JButton("Submit");

        //TextField Input Limit Setter
        ssc.setDocument(new JTextFieldLimit(3));
        hsc.setDocument(new JTextFieldLimit(3));
        mhcet.setDocument(new JTextFieldLimit(3));
        jee.setDocument(new JTextFieldLimit(3));

        //add
        panel.add(title);
        panel.add(subtitle);
        panel.add(sscText);
        panel.add(hscText);
        panel.add(mhText);
        panel.add(jeeText);
        panel.add(outof1);
        panel.add(outof2);
        panel.add(outof3);
        panel.add(outof4);
        panel.add(subssc);
        panel.add(subhsc);
        panel.add(subjee);
        panel.add(submh);
        panel.add(ssc);
        panel.add(hsc);
        panel.add(mhcet);
        panel.add(jee);
        panel.add(alerttext);
        panel.add(submit);

        //setPos
        title.setBounds(0,0,1280,90);
        subtitle.setBounds(251,159,288,46);
        sscText.setBounds(338,236,187,44);
        hscText.setBounds(338,305,187,44);
        mhText.setBounds(338,374,187,44);
        jeeText.setBounds(338,443,187,44);
        outof1.setBounds(709,305,67,44);
        outof2.setBounds(709,236,67,44);
        outof3.setBounds(709,374,67,44);
        outof4.setBounds(709,443,67,44);
        ssc.setBounds(525,236,163,44);
        hsc.setBounds(525,305,163,44);
        mhcet.setBounds(525,374,163,44);
        jee.setBounds(525,443,163,44);
        subssc.setBounds(865,236,163,44);
        subhsc.setBounds(865,305,163,44);
        submh.setBounds(865,374,163,44);
        subjee.setBounds(865,443,163,44);
        alerttext.setBounds(399,575,481,21);
        submit.setBounds(510,605,260,53);

        // STYLing
        title.setFont(new Font("Serif", Font.PLAIN, 30));
        subtitle.setFont(new Font("Serif", Font.PLAIN, 20));
        alerttext.setFont(new Font("Serif", Font.PLAIN, 15));
        alerttext.setForeground(Color.red);
        alerttext.setVisible(false);
        setVisible(true);

        //logic
            //BUTTON PRESS CODES
        submit.addActionListener(e ->
        {
            if ( mhcet.getText().isEmpty() == false && jee.getText().isEmpty() == false && ssc.getText().isEmpty() == false && hsc.getText().isEmpty() == false) {
            List.clear(); //empty lists
            List.add(ssc.getText());
            List.add(hsc.getText());
            List.add(mhcet.getText());
            List.add(jee.getText());
            List.add("/Storage/" + StudentID + "/" + StudentID + "-" +"scc_certificate.png");
            List.add("/Storage/" + StudentID + "/" + StudentID + "-" +"hcc_certificate.png");
            List.add("/Storage/" + StudentID + "/" + StudentID + "-" +"mhcet_certificate.png");
            List.add("/Storage/" + StudentID + "/" + StudentID + "-" +"jee_certificate.png");
            EligibilityChecker();
                int a = storeData(List);//calling Event
                if (a == 1) {//Check For Mysql Exceptions
                    new StudentPortal(ID);
                    setVisible(false); 
                }else{
                    new StudentPortal(ID);
                    setVisible(false); 
                }
            }else {alerttext.setVisible(true); }
        });
        subssc.addActionListener(e -> {
            JFileChooserOpener("ssc");
            subssc.setText("Selected");
        });
        subhsc.addActionListener(e -> {
            JFileChooserOpener("hsc");
            subhsc.setText("Selected");
        });
        submh.addActionListener(e -> {
            JFileChooserOpener("mhcet");
            submh.setText("Selected");
        });
        subjee.addActionListener(e -> {
            JFileChooserOpener("jee");
            subjee.setText("Selected");
        });
        //ARRAY FOR OBJ to Pass to Method
        ArrayList<JTextField> object = new ArrayList<JTextField>();
        object.add(ssc);
        object.add(hsc);
        object.add(mhcet);
        object.add(jee);

        for (JTextField obj: object) {
            obj.addKeyListener(new java.awt.event.KeyAdapter() {

                public void keyReleased(java.awt.event.KeyEvent evt) {
                    try {
                        long number = Long.parseLong(obj.getText());
                        if (number > 100) {
                            JOptionPane.showMessageDialog(rootPane, "Below 100%");
                            obj.setText("");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, "Only Numbers Allowed");
                        obj.setText("");
                    }
                }
            });
        }


    }

    private int storeData(ArrayList<String> arr)//Store Data To Mysql
    {
     try{
        String insertSQL ="insert into RegistrationData (id, SSC, HSC, MHCET, JEE, sscCert, hscCert,mhCert, jeeCert, eligible) values(?,?,?,?,?,?,?,?,?,?)" ;
        Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con=DriverManager.getConnection(conn.Conn, conn.Conn_user, conn.Conn_pw);  
        PreparedStatement Pstatement=con.prepareStatement(insertSQL);
        //code
        Pstatement.setInt(1,StudentID);
        for(int i = 0; i< List.size(); i++){
            int x = i + 2;
            if (x >= List.size()) {
                x = i +2 ;
            }
            Pstatement.setString(x, List.get(i));
        };
        Pstatement.executeUpdate();
        JOptionPane.showMessageDialog(null,"Data Registered Successfully");
        Pstatement.close();
        con.close();
        fileCopy(System.getProperty("user.dir") + List.get(4), sscCerti);
        fileCopy(System.getProperty("user.dir") + List.get(5), hscCerti);
        fileCopy(System.getProperty("user.dir") + List.get(6), mhcetCerti);
        fileCopy(System.getProperty("user.dir") + List.get(7), jeeCerti);
        List.clear();
        return 1;
        }catch(Exception e){ System.out.println(e); return 0;}        
    }

    private void JFileChooserOpener(String caller){//Select File to Copy and Create Dir
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Select an image");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and GIF images", "png", "gif");
        jfc.addChoosableFileFilter(filter);
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            System.out.println(jfc.getSelectedFile().getPath());
        };
        String dir = System.getProperty("user.dir") +  "/Storage/"+ StudentID + "/";
        try {
            Files.createDirectories(Paths.get(dir));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        if(jfc.getSelectedFile() != null){
            if (caller == "ssc") {
                sscCerti = jfc.getSelectedFile().getPath();
            } else if(caller == "hsc") {
                hscCerti = jfc.getSelectedFile().getPath();
            } else if(caller == "mhcet") {
                mhcetCerti = jfc.getSelectedFile().getPath();
            } else if(caller == "jee") {
                jeeCerti = jfc.getSelectedFile().getPath();
            }
        }
    }
    
    private void EligibilityChecker(){//check student Eligibilty from marks
        String ssc = List.get(0);
        String hsc = List.get(1);
        String mhcet = List.get(2);
        String jee = List.get(3);
 
        if (Integer.parseInt(ssc) > 60 && Integer.parseInt(hsc) > 60) {
            if (Integer.parseInt(mhcet) > 60 || Integer.parseInt(jee) > 60) {
                List.add(8,"yes");
            }else{
                List.add(8,"no");
            }
        }else {
            List.add(8,"no");
        }        
        
    } 

    private void fileCopy(String currentPath,String targetLocation  ){//Copy FIle to Storage/StudentID
        File currentFile  = new File(currentPath);
        File targetFile  = new File(targetLocation);  
        FileOutputStream fileOutputStream = null; 
        FileInputStream fileInputStream = null;
        try {
         fileOutputStream = new FileOutputStream(currentFile);
         fileInputStream = new FileInputStream(targetFile);
         byte[] buffer = new byte[4096];
         int read;
         while ((read = fileInputStream.read(buffer)) != -1) {
          fileOutputStream.write(buffer, 0, read);
         }
        } catch(IOException e) {
         try {
          e.printStackTrace();
          if (fileInputStream != null) {
           fileInputStream.close();     
          }
          if (fileOutputStream != null) {
           fileOutputStream.flush(); 
           fileOutputStream.close();
          }
         }
         catch (IOException e1) {
          e1.printStackTrace();
         }
        }
    }
}

