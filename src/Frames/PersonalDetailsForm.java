package Frames;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.sql.*;
import org.jdatepicker.impl.*;
import LibExtra.DateLabelFormatter;

public class PersonalDetailsForm extends JFrame {
    static int StudentID;
    static ArrayList<String> List= new ArrayList<String>();
    static String IdPath;
    static String PhotoPath;

    //main frame
    public PersonalDetailsForm(int ID) {
        StudentID = ID;
        setTitle("Personal Details");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 750);
        setLocationRelativeTo(null);
        setResizable(false);

        // date
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl dobField = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        // plane
        JPanel pane = new JPanel();
        add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.white);
        pane.setSize(1280, 720);

        // bgPlane
        JPanel bgPlane = new JPanel();
        bgPlane.setBackground(Color.decode("#EDE3E3"));
        bgPlane.setBounds(36, 95, 1208, 590);

        // Arrays
        String cityStr[] = { "Thane", "Mumbai", "Noida", "Kolkata", "New Delhi" };
        String State[] = { "Maharashtra", "Chennai", "Delhi" };

        // obj
        JLabel titleMain = new JLabel("A P Shah Institude Of Technology", JLabel.CENTER);
        JLabel pdtext = new JLabel("Personal Details");
        JLabel fn = new JLabel("First Name:");
        JLabel mn = new JLabel("Middle Name:");
        JLabel ln = new JLabel("Last Name:");
        JLabel pno1 = new JLabel("Phone No.1:");
        JLabel pno2 = new JLabel("Phone No.2:");
        JLabel adds = new JLabel("Address:");
        JLabel dob = new JLabel("Date Of Birth:");
        JLabel email = new JLabel("Email:");
        JLabel city = new JLabel("City:");
        JLabel state = new JLabel("State:");
        JLabel pincode = new JLabel("Pincode:");
        JLabel photo = new JLabel("Photo:");
        JLabel idProof = new JLabel("Id Proof (Adhar Card):");
        JLabel alertText = new JLabel("Alert! Enter all Field Correctly!", JLabel.CENTER);

        JTextField fnField = new JTextField();
        JTextField lnField = new JTextField();
        JTextField mnField = new JTextField();
        JTextField pno1Field = new JTextField();
        JTextField pno2Field = new JTextField();
        JTextArea addsField = new JTextArea();
        JTextField emailField = new JTextField();
        JComboBox<String> CityField = new JComboBox<>(cityStr);
        JComboBox<String> StateField = new JComboBox<>(State);
        JTextField PincodeField = new JTextField();
        JButton photofnField = new JButton("Select File"); // file upload
        JButton idProofField = new JButton("Select File"); // file upload

        JButton subbtn = new JButton("Submit");

        // add
        pane.add(subbtn);
        pane.add(titleMain);
        pane.add(fn);
        pane.add(fnField);
        pane.add(ln);
        pane.add(lnField);
        pane.add(mn);
        pane.add(mnField);
        pane.add(email);
        pane.add(emailField);
        pane.add(pno1);
        pane.add(pno1Field);
        pane.add(pno2);
        pane.add(pno2Field);
        pane.add(photo);
        pane.add(photofnField);
        pane.add(idProof);
        pane.add(idProofField);
        pane.add(city);
        pane.add(CityField);
        pane.add(state);
        pane.add(StateField);
        pane.add(adds);
        pane.add(addsField);
        pane.add(pincode);
        pane.add(PincodeField);
        pane.add(pdtext);
        pane.add(dob);
        pane.add(dobField);
        pane.add(alertText);
        pane.add(bgPlane);

        // style
        titleMain.setFont(new Font("Serif", Font.PLAIN, 30));
        alertText.setFont(new Font("Serif", Font.PLAIN, 15));
        alertText.setForeground(Color.red);
        titleMain.setOpaque(true);
        titleMain.setBackground(Color.lightGray);

        addsField.setBorder(BorderFactory.createEtchedBorder());
        addsField.setLineWrap(true);
        alertText.setVisible(false);

        // setBounds

        subbtn.setBounds(839, 594, 232, 49);
        titleMain.setBounds(0, 0, 1280, 40);
        fn.setBounds(58, 119, 239, 37);
        fnField.setBounds(297, 117, 249, 39);
        ln.setBounds(58, 190, 239, 37);
        lnField.setBounds(297, 190, 249, 39);
        mn.setBounds(58, 261, 239, 37);
        mnField.setBounds(297, 261, 249, 39);
        email.setBounds(53, 606, 239, 37);
        emailField.setBounds(292, 604, 249, 39);
        pno1.setBounds(58, 332, 239, 37);
        pno1Field.setBounds(297, 332, 249, 39);
        pno2.setBounds(58, 403, 239, 37);
        pno2Field.setBounds(297, 403, 249, 39);
        adds.setBounds(58, 474, 239, 37);
        addsField.setBounds(297, 472, 249, 102);
        dob.setBounds(706, 119, 239, 37);
        dobField.setBounds(942, 119, 249, 39);

        dobField.getComponent(0).setPreferredSize(new Dimension(249, 39));
        dobField.getComponent(1).setPreferredSize(new Dimension(20, 39));
        // dobField.setBorder(border);

        photo.setBounds(705, 403, 239, 37);
        photofnField.setBounds(946, 403, 249, 39);
        idProof.setBounds(702, 474, 239, 37);
        idProofField.setBounds(941, 474, 249, 39);
        city.setBounds(705, 190, 239, 37);
        CityField.setBounds(946, 190, 249, 39);
        state.setBounds(705, 261, 239, 37);
        StateField.setBounds(944, 261, 249, 39);
        pincode.setBounds(705, 332, 239, 37);
        PincodeField.setBounds(946, 332, 249, 39);
        pdtext.setBounds(45, 55, 239, 37);
        alertText.setBounds(702, 538, 488, 46);

        setVisible(true);

        // Logic

        idProofField.addActionListener(e -> {
            JFileChooserOpener("photo");
        });
        photofnField.addActionListener(e -> {
            JFileChooserOpener("ID");
        });

        subbtn.addActionListener(e -> {
            //adding values in ArrayList
            List.clear(); //empty lists
            List.add(fnField.getText());
            List.add(lnField.getText());
            List.add(mnField.getText());
            List.add(pno1Field.getText());
            List.add(pno2Field.getText());
            List.add(addsField.getText());
            List.add(emailField.getText());
            List.add(dobField.getJFormattedTextField().getText());
            List.add(CityField.getSelectedItem().toString());
            List.add(StateField.getSelectedItem().toString());
            List.add(PincodeField.getText());
            List.add("/Storage/" + StudentID + "/" + StudentID + "-" +"ID.png");
            List.add("/Storage/" + StudentID + "/" + StudentID + "-" +"Photo.png");

            int a = storeData(List);//calling Event
            if (a == 1) {//Check For Mysql Exceptions
                new StudentPortal(ID);
                setVisible(false); 
            }else{
                alertText.setVisible(true);
            }
        });

        // ALL STYLING
        Component[] component = pane.getComponents();
        for (int i = 0; i < component.length; i++) {
            if (component[i] instanceof JButton) {
                JButton button = (JButton) component[i];
                button.setFocusPainted(false);
            }
        }; 
    }

    private int storeData(ArrayList<String> arr)//Store Data To Mysql
    {
     try{
        String insertSQL ="insert into PersonalData (id, firstname,middlename, lastname, phoneno1, phoneno2, address, email,dob, city, state,pincode, photoAddress, IdAddress) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
        Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","Chiragsp","admin");  
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
        fileCopy(System.getProperty("user.dir") + List.get(11), PhotoPath);
        fileCopy(System.getProperty("user.dir") + List.get(12), IdPath);
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
            if (caller == "photo") {
                PhotoPath = jfc.getSelectedFile().getPath();
            } else if(caller == "ID") {
                IdPath = jfc.getSelectedFile().getPath();
            }
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
