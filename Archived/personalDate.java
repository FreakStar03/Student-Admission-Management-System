
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
//import java.io.File;
import java.util.*;
import java.sql.*;

import org.jdatepicker.impl.*;
import LibExtra.DateLabelFormatter;

public class PersonalDetailsForm extends JFrame {
    static int StudentID;
    static ArrayList<String> List= new ArrayList<String>();
    static String IdPath;
    static String PhotoPath;

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
        JLabel ln = new JLabel("Last Name:");
        JLabel mn = new JLabel("Middle Name:");
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
        ;

        setVisible(true);

        // Logic

        idProofField.addActionListener(e -> {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            jfc.setDialogTitle("Select an image");
            jfc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and GIF images", "png", "gif");
            jfc.addChoosableFileFilter(filter);
            //int returnValue = jfc.showOpenDialog(null);
            // if (returnValue == JFileChooser.APPROVE_OPTION) {
            //     System.out.println(jfc.getSelectedFile().getPath());
            // };
            String dir = "/home/chirag/Documents/Codes/JAVA/SwingTest/StudentRegistration/Storage/"+ StudentID + "/";
            try {
                Files.createDirectories(Paths.get(dir));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            IdPath = jfc.getSelectedFile().getPath();
            //fileCopy(dir + StudentID + "-" + "ID.png", jfc.getSelectedFile().getPath());

        });
        photofnField.addActionListener(e -> {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            jfc.setDialogTitle("Select an image");
            jfc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and GIF images", "png", "gif");
            jfc.addChoosableFileFilter(filter);
            //int returnValue = jfc.showOpenDialog(null);
            // if (returnValue == JFileChooser.APPROVE_OPTION) {
            //     System.out.println(jfc.getSelectedFile().getPath());
            // };
            String dir = "/home/chirag/Documents/Codes/JAVA/SwingTest/StudentRegistration/Storage/"+ StudentID + "/";
            try {
                Files.createDirectories(Paths.get(dir));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            PhotoPath = jfc.getSelectedFile().getPath();
            //fileCopy(dir + StudentID + "-" + "ID.png", jfc.getSelectedFile().getPath());

        });

        subbtn.addActionListener(e -> {
            //List.add( Integer.toString(StudentID));
            List.clear();;
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

            if (subbtn.getText() == "Submit") {
                int a = actionEvent(List, true);
                if (a == 0) {
                    alertText.setVisible(true);
                } else{
                    new StudentPortal(ID);
                    //dispose();
                    setVisible(false);
                }
            } else {
                // int a = actionEvent(List, false);
                // if (a == 0) {
                //     alertText.setVisible(true);
                // } else{
                //     new StudentPortal(ID);
                //     //dispose();
                //     setVisible(false);
                //}
            };
            //rg.setVisible(true);
        });

        // ALL STYLING
        Component[] component = pane.getComponents();
        for (int i = 0; i < component.length; i++) {
            if (component[i] instanceof JButton) {
                JButton button = (JButton) component[i];
                button.setFocusPainted(false);
            }
        };
        // if (RetriveData() != 0) {
        //            if(List.isEmpty() != true){
        //     fnField.setText(List.get(2));
        //     lnField.setText(List.get(3));
        //     mnField.setText(List.get(4));
        //     pno1Field.setText(List.get(5));
        //     pno2Field.setText(List.get(6));
        //     addsField.setText(List.get(7));
        //     emailField.setText(List.get(8));
        //     CityField.setSelectedItem(List.get(10));
        //     StateField.setSelectedItem(List.get(11));
        //     PincodeField.setText(List.get(12));

        //     subbtn.setText("Edit");
        //     List.clear();
        // }
        // }


     
    }

    // public int RetriveData() {
    //     try {
    //         Class.forName("com.mysql.cj.jdbc.Driver");
    //         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "Chiragsp", "admin");
    //         PreparedStatement Pstatement = con.prepareStatement("Select * from PersonalData where id = ?");
    //         Pstatement.setInt(1, StudentID);
    //         ResultSet rs = Pstatement.executeQuery();
    //         ResultSetMetaData rsmd = rs.getMetaData();
    //         int columnCount = rsmd.getColumnCount();
    //         ArrayList<String> TempList = new ArrayList<>(columnCount);

    //         if (rs.next()) {
    //             int i = 1;
    //             while (i <= columnCount) {
    //                 TempList.add(rs.getString(i++));
    //             };
    //             List = TempList;
    //             dispose();
    //             Pstatement.close();
    //             con.close();
    //         } else {
    //             Pstatement.close();
    //             con.close();
    //         }
    //         return 1;
    //     } catch (Exception e) {
    //         System.out.println(e); return 0;
    //     }
    // }

    public int actionEvent(ArrayList<String> arr, boolean Edit)
    {
     try{
        String updateSQL = "UPDATE PersonalData SET firstname =? ,middlename=?, lastname=?, phoneno1=?, phoneno2=?, address=?, email=?,dob=?, city=?, state=?,pincode=?, photoAddress=?, IdAddress=? WHERE id = "+  StudentID;
        String insertSQL ="insert into PersonalData (id, firstname,middlename, lastname, phoneno1, phoneno2, address, email,dob, city, state,pincode, photoAddress, IdAddress) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
        Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","Chiragsp","admin");  
        //here student is database name, root is username and password
        PreparedStatement Pstatement;
        if (Edit) {
            Pstatement=con.prepareStatement(insertSQL);
            //code
            Pstatement.setInt(1,StudentID);
            for(int i = 0; i< List.size(); i++){
                int x = i + 2;
                if (x >= List.size()) {
                    x = i +2 ;
                }
                Pstatement.setString(x, List.get(i));
            };
        } else {
            Pstatement=con.prepareStatement(updateSQL);
            //code
            for(int i = 0; i< List.size(); i++){
                int x = i + 1;
                Pstatement.setString(x, List.get(i));
            };
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

    public void fileCopy(String currentPath,String targetLocation  ){
        File currentFile  = new File(currentPath);
        File targetFile  = new File(targetLocation);  

        // Creating FileOutputStream and FileInputStream variables 
        FileOutputStream fileOutputStream = null;
      
        FileInputStream fileInputStream = null;
        try {
      
         // Wrapping the File objects created above within 
         // FileOutputStream and FileInputStream objects
         fileOutputStream = new FileOutputStream(currentFile);
         fileInputStream = new FileInputStream(targetFile);
      
         // Creating a buffer of byte for storing contents of file
         byte[] buffer = new byte[4096];
         int read;
      
         // looping the file contents on the current location till
         // it becomes empty
         while ((read = fileInputStream.read(buffer)) != -1) {
      
          // As each loops terminates the target file gets the 
          // contents of current file in the chunks of buffer 
          fileOutputStream.write(buffer, 0, read);
         }
      
         // catch blocks for closing of the streams and catching 
         // IOException
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
