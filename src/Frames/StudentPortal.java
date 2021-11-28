package Frames;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import sql.conn;

public class StudentPortal extends JFrame{
    public boolean isLogout = false;
    static int StudentID;
    static String StudentName;
    static Boolean Eligible = false;
    static ArrayList<String> enrollList= new ArrayList<String>();
    static boolean Pbtn = false;
    static boolean Rbtn = false;

    //main Frame
    public StudentPortal(){
        setTitle("Student Portal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);//close java prog on close of window
        setSize(1280, 720);
        setLocationRelativeTo(null);//start window in center on monitor
        setResizable(false);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        //setContentPane(panel);
        panel.setBackground(Color.decode("#F8F0E3"));
        add(panel);
        panel.setSize(1280, 720);//mistake

        //obj calling
        JLabel title = new JLabel("A P Shah Institude of Technology", JLabel.CENTER);

        JLabel up = new JLabel("User Profile :");
        JLabel stdName = new JLabel("Student Name :");
        JLabel stdId = new JLabel("Student Id :");
        JLabel stdNameValue = new JLabel(StudentName);
        JLabel stdIdValue = new JLabel(Integer.toString(StudentID));
        
        JButton userDetail = new JButton("Profile Form");
        JButton addmissionForm = new JButton("Academics Qualification Form");
        JButton LogoutBtn = new JButton("Logout");
        JButton BatchForm = new JButton("Admission Form");

        JLabel RegDone = new JLabel("Registered Courses:");

        JPanel bgButton = new JPanel(); 
        JPanel bg2 = new JPanel(); 

        

        //styling
        bgButton.setBackground(Color.decode("#EDE3E3"));
        bg2.setBackground(Color.decode("#EDE3E3"));

        bgButton.setBorder(BorderFactory.createLineBorder(Color.black));
        bg2.setBorder(BorderFactory.createLineBorder(Color.black));

        title.setOpaque(true);
        title.setBackground(Color.lightGray);
        title.setFont(new Font("Courier", Font.PLAIN, 25));
        RegDone.setFont(new Font("Courier", Font.PLAIN, 20));
        up.setFont(new Font("Courier", Font.BOLD, 15));

        LogoutBtn.setBorder(null);
        LogoutBtn.setOpaque(true);

        BatchForm.setEnabled(false);



        LogoutBtn.setBackground(Color.lightGray);
        LogoutBtn.setForeground(Color.blue);
        LogoutBtn.setFocusPainted(false);


                //Badges
        if (enrollList.isEmpty() != true) {
            for(int x = 0,  y = 480; x < enrollList.size(); x++){
                JLabel localLabel = new JLabel("⚫️  " + enrollList.get(x) + ((Eligible) ? " ✅️" : " ❌"));
                String Currentname = enrollList.get(x);
                JButton localBtn = new JButton("Delete");
                y += 40 ;
                localLabel.setBounds(90,y,332,42);
                localBtn.setBounds(332,y,89, 23);
                //localBtn.addActionListener(e ->{ deleteEnrollment(StudentID,  Currentname);});
                localBtn.addActionListener(e ->{
                       int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel your Enrollment! For this Course!", "Confirm Your Choice!",
                          JOptionPane.YES_NO_OPTION,
                          JOptionPane.QUESTION_MESSAGE);
                       if(result == JOptionPane.YES_OPTION){
                         deleteEnrollment(StudentID,  Currentname);
                       }
                    }
                 );
                panel.add(localLabel);
                panel.add(localBtn);
            } 
            enrollList.clear();
        }

        //addmissionForm.setFocusPainted(false);
        //obj adding
        panel.add(title);
        panel.add(up);
        panel.add(stdName);
        panel.add(stdId);
        panel.add(stdNameValue);
        panel.add(stdIdValue);
        panel.add(userDetail);
        panel.add(addmissionForm);
        panel.add(BatchForm);
        panel.add(LogoutBtn);
        panel.add(RegDone);

        panel.add(bgButton);
        panel.add(bg2);
        
        //obj setBounds
        title.setBounds(0,0,1280,70);
        up.setBounds(65,108,232,35);
        stdName.setBounds(93,172,232,42);
        stdId.setBounds(732,172,232,42);
        stdNameValue.setBounds(250,172,232,42);
        stdIdValue.setBounds(850,172,232,42);
        userDetail.setBounds(93,307,306,58);
        addmissionForm.setBounds(496,307,306,58);
        BatchForm.setBounds(886,307,306,58);
        LogoutBtn.setBounds(1089,108,148,44);
        RegDone.setBounds(72,470,332,42);

        bgButton.setBounds(43,246,1194,180);
        bg2.setBounds(43,473,1194,198);

        //function

        if (Pbtn) { //Check IF FormAlreadySub
            userDetail.setEnabled(false);
            //userDetail.setBackground(Color.GRAY);
        }
        if (Rbtn) { //Check IF FormAlreadySub
            addmissionForm.setEnabled(false);
            //addmissionForm.setBackground(Color.GRAY);
        }

        if (Pbtn == true && Rbtn == true ) {
            BatchForm.setEnabled(true);
        }

        LogoutBtn.addActionListener(e ->
        {
            LoginFormS rg = new LoginFormS();
            setVisible(false);
            rg.setVisible(true);
        });

        userDetail.addActionListener(e ->
        {
            PersonalDetailsForm rg = new PersonalDetailsForm(StudentID);
            setVisible(false);
            rg.setVisible(true);
        });

        addmissionForm.addActionListener(e ->
        {
            addmissionForm rg = new addmissionForm(StudentID);
            setVisible(false);
            rg.setVisible(true);
        });

        BatchForm.addActionListener(e ->
        {
            BatchForm rg = new BatchForm(StudentID);
            setVisible(false);
            rg.setVisible(true);
        });

        //ALL STYLING
        Component[] component = panel.getComponents();
        for(int i=0; i<component.length; i++)
        {
            if (component[i] instanceof JButton)
            {
                JButton button = (JButton)component[i];
                button.setFocusPainted(false);
            }
        };

    }
    
    //Caller
    public StudentPortal(int ID){
        CheckUser(ID);
        CheckForms(ID);
        checkEnrollement(ID);
        checkEligibility(ID);
        StudentPortal st = new StudentPortal();
        st.setVisible(true);
    } 

    //Checkers
    private void CheckUser(int a){ // Check if given studnet Id is Registrated in StudentReg
    try{  
        Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","Chiragsp","admin");  
        PreparedStatement Pstatement=con.prepareStatement("Select * from studentReg where id=?");
        Pstatement.setInt(1, a);
        ResultSet rs = Pstatement.executeQuery();
        if (rs.next()) {
            StudentID = rs.getInt(1);
            StudentName = rs.getString(2);
            dispose();
            Pstatement.close();
            con.close();
        } else {
            Pstatement.close();
            con.close();
        }
        }catch(Exception e){ System.out.println(e);}        
    }

    private void CheckForms(int a){// Check if studnet has filled Registration and Personal Form
        try{  
            ArrayList<String> list = new ArrayList<>(Arrays.asList("PersonalData", "RegistrationData"));
            for(int counter = 0; counter < list.size(); counter++){
                Class.forName("com.mysql.cj.jdbc.Driver");  
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","Chiragsp","admin");  
                PreparedStatement Pstatement=con.prepareStatement("SELECT * FROM "+ list.get(counter) + " WHERE id = ?");
                Pstatement.setInt(1, a);
                ResultSet rs = Pstatement.executeQuery();
                if (rs.next()) {
                    if(list.get(counter) == "PersonalData") Pbtn = true ;
                    if(list.get(counter) == "RegistrationData") Rbtn = true ;
                    System.out.println(" Reg Exist");
                    Pstatement.close();
                    con.close();
                } else {
                    if(list.get(counter) == "PersonalData") Pbtn = false ;
                    if(list.get(counter) == "RegistrationData") Rbtn = false ;
                    System.out.println("no Reg");
                    Pstatement.close();
                    con.close();
                }
        };
            }catch(Exception e){ System.out.println(e); }        
        }
    
    private void checkEnrollement(int a){ //Check if student has data in BranchData Table
        try{  
                Class.forName("com.mysql.cj.jdbc.Driver");  
                Connection con=DriverManager.getConnection(conn.Conn, conn.Conn_user, conn.Conn_pw);  
                PreparedStatement Pstatement=con.prepareStatement("SELECT Branch FROM BranchData WHERE id = ?");
                Pstatement.setInt(1, a);
                ResultSet rs = Pstatement.executeQuery();
                ResultSetMetaData rsmd = rs.getMetaData();
                while (rs.next()) {
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        enrollList.add(rs.getString(i));
                    }
                };
                Pstatement.close();
                con.close();                                     

            }catch(Exception e){ System.out.println(e); }        
        }

    private void checkEligibility(int a){ //Check if student has data in BranchData Table
    try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(conn.Conn, conn.Conn_user, conn.Conn_pw);  
            PreparedStatement Pstatement=con.prepareStatement("SELECT eligible FROM RegistrationData WHERE id = ?");
            Pstatement.setInt(1, a);
            ResultSet rs = Pstatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
                    if (rs.getString(1).equals("yes")) {
                        Eligible = true;
                        System.out.println("true");
                    } else {
                        Eligible = false;
                    }
            };
            Pstatement.close();
            con.close();                                     

        }catch(Exception e){ System.out.println(e); }        
    }

    private void deleteEnrollment(int a, String Branch){ //Check if student has data in BranchData Table
        try{  
                Class.forName("com.mysql.cj.jdbc.Driver");  
                Connection con=DriverManager.getConnection(conn.Conn, conn.Conn_user, conn.Conn_pw);  
                PreparedStatement Pstatement=con.prepareStatement("DELETE FROM BranchData WHERE Branch= '" + Branch + "' AND " + "id = ?" );
                Pstatement.setInt(1, a);
                Pstatement.executeUpdate();
                Pstatement.close();
                con.close();     
                new StudentPortal(StudentID);
                dispose();
            }catch(Exception e){ System.out.println(e); }        
        }

}
