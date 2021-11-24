package Frames;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
//import java.awt.event.*;

import sql.conn;

public class RegFrame extends JFrame{
    public RegFrame(){
        setTitle("Student Portal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);//close java prog on close of window
        setSize(411, 731);
        setLocationRelativeTo(null);//start window in center on monitor
        JLabel titleMain = new JLabel ("A P Shah Institude Of Technology", JLabel.CENTER);
        titleMain.setFont(new Font("serif", Font.BOLD, 20));
        JLabel footerMain = new JLabel ("All Right Reserverd*", JLabel.CENTER);
        footerMain.setFont(new Font("serif", Font.BOLD, 15));
        add (footerMain, BorderLayout.SOUTH);
        add (titleMain, BorderLayout.NORTH);
        setResizable(false);


        //plane
        JPanel pane = new JPanel();
        add(pane, BorderLayout.CENTER);
        pane.setLayout(null);
        pane.setBackground(Color.white);
        pane.setSize(411, 731);

        JLabel emailLable = new JLabel ("EMAIL");
        JTextField email = new JTextField (5);
        JLabel nameLable = new JLabel ("Name");
        JTextField name = new JTextField (5);
        JLabel pwLable = new JLabel ("Password");
        JPasswordField pw = new JPasswordField (5);
        JButton sub = new JButton ("Submit");
        JButton login = new JButton ("Login");
        JLabel title = new JLabel ("Registration Portal", JLabel.CENTER);
        JLabel cpwLable = new JLabel ("Confirm Password");
        JPasswordField cpw = new JPasswordField (5);
       // JButton back = new JButton ("Back");
        JLabel alert_text = new JLabel ("Enter all field Properly!", JLabel.CENTER);

        //styling
        title.setFont(new Font("Courier", Font.BOLD, 25));
        emailLable.setFont(new Font("serif", Font.PLAIN, 15));
        nameLable.setFont(new Font("serif", Font.PLAIN, 15));
        name.setFont(new Font("serif", Font.PLAIN, 15));
        pwLable.setFont(new Font("serif", Font.PLAIN, 15));
        cpwLable.setFont(new Font("serif", Font.PLAIN, 15));
        pw.setFont(new Font("serif", Font.PLAIN, 15));
        cpw.setFont(new Font("serif", Font.PLAIN, 15));
        email.setFont(new Font("serif", Font.PLAIN, 15));

        alert_text.setFont(new Font("Courier", Font.PLAIN, 15));
        alert_text.setForeground(Color.decode("#9D1010"));

        alert_text.setVisible(false); //setfalse
        
        //add components
        pane.add(title);
        pane.add(emailLable);
        pane.add(email);
        pane.add(nameLable);
        pane.add(name);
        pane.add(pwLable);
        pane.add(pw);
        pane.add(cpwLable);
        pane.add(cpw);
        pane.add(alert_text);
        pane.add(sub);
        pane.add(login);
        //set component bounds (only needed by Absolute Positioning)
        //setbounds(pos x, pos y , width, breadth)
        title.setBounds(17, 50, 376 , 57);
        emailLable.setBounds(25, 223, 156 , 33);
        email.setBounds(202, 222, 188 , 34);
        nameLable.setBounds(25, 153, 156 , 33);
        name.setBounds(202, 152, 188 , 34);
        pwLable.setBounds(25, 292, 156 , 33);
        pw.setBounds(202, 291, 188 , 34);
        cpwLable.setBounds(16, 363, 175 , 33);
        cpw.setBounds(202, 360, 188 , 34);
        alert_text.setBounds(20,430,370,33);
        sub.setBounds(21,496,160,49);
        login.setBounds(230,496,160,49);
        //setVisible(true);
        
        sub.addActionListener(e ->
        {
            String myPass=String.valueOf(pw.getPassword());
            String CmyPass=String.valueOf(cpw.getPassword());

            //System.out.println(CmyPass + " = " + myPass);
            if(myPass.equals(CmyPass)){
                SubmitForm(name.getText(), email.getText(), myPass);
                int id = getStudentId(email.getText(), myPass);
                System.out.println(id);
                new StudentPortal(id);
                setVisible(false);
                //rg.setVisible(true);
                 
             }else{
                //JOptionPane.showMessageDialog(null,"password did not match");
                alert_text.setVisible(true);
                }
        });

        login.addActionListener(e ->
        {
            LoginFormS rg = new LoginFormS();
            setVisible(false);
            rg.setVisible(true);
        });
   };
   public void SubmitForm(String name, String email, String pw)
   {
    try{  
        Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","Chiragsp","admin");
        //here student is database name, chiragsp is username and admin is password  
        PreparedStatement Pstatement=con.prepareStatement("insert into studentReg (name,email,password) values(?,?,?)");
        Pstatement.setString(1,name);
        Pstatement.setString(2,email);
        Pstatement.setString(3,pw);
        Pstatement.executeUpdate();
        JOptionPane.showMessageDialog(null,"Data Registered Successfully");
        Pstatement.close();
        con.close();
        }catch(Exception e){ System.out.println(e);}        
   }

   public int getStudentId(String email, String pw)
   {
    try{  
        Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con=DriverManager.getConnection(conn.Conn, conn.Conn_user, conn.Conn_pw);  
        PreparedStatement Pstatement=con.prepareStatement("Select * from studentReg where email=? and password=?");
        Pstatement.setString(1,email);
        Pstatement.setString(2,pw);
        ResultSet rs = Pstatement.executeQuery();
        if (rs.next()) {
           int r = rs.getInt(1);
           dispose();
           Pstatement.close();
           con.close();
           return r;
       } else {
           JOptionPane.showMessageDialog(null, "Wrong Username & Password");
           Pstatement.close();
           con.close();
           return 0;
       }
        }catch(Exception e){ System.out.println(e);return 0;}        
   }


}