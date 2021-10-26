package Frames;
// import java.awt.BorderLayout;
// import java.awt.EventQueue;
//import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
// import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
// import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginFormS extends JFrame {
    int value = 0;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textfield;

	public LoginFormS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550, 530);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#EDE3E3"));
		contentPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textUsername = new JLabel("Email :");
		textUsername.setForeground(new Color(0, 0, 0));
		textUsername.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textUsername.setBounds(87, 170, 117, 66);
		contentPane.add(textUsername);
		
		JLabel textPassword = new JLabel("Password :");
        textPassword.setForeground(new Color(0, 0, 0));
		textPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textPassword.setBounds(87, 273, 117, 30);
		contentPane.add(textPassword);
		
		JButton LoginBut = new JButton("Submit");
		LoginBut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		LoginBut.setBounds(103, 347, 89, 23);
		contentPane.add(LoginBut);
		
		JButton RegistrationBut = new JButton("Registor");
		RegistrationBut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RegistrationBut.setBounds(303, 347, 100, 23);
		contentPane.add(RegistrationBut);
		
		JLabel lblNewLabel = new JLabel("Student Form", JLabel.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 93, 550, 40);
		contentPane.add(lblNewLabel);

        JLabel adminChanger = new JLabel("Change To Admin", JLabel.CENTER);
		adminChanger.setFont(new Font("Tahoma", Font.BOLD, 12));
		adminChanger.setForeground(Color.blue);
		adminChanger.setBounds(0, 130, 550, 40);
		contentPane.add(adminChanger);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(284, 273, 168, 30);
		contentPane.add(passwordField);
		
		textfield = new JTextField();
		textfield.setBounds(282, 196, 168, 30);
		contentPane.add(textfield);
		textfield.setColumns(10);
		//setUndecorated(true);
		setLocationRelativeTo(null);

        //LOGIC
        adminChanger.addMouseListener(new MouseAdapter()   {   
            public void mouseClicked(MouseEvent e)   
            { 
                switch(value){    
                    case 0:
                        lblNewLabel.setText("Admin Login");
                        adminChanger.setText("Change To Student Login");
                        adminChanger.setText("Change To Student Login");
                        RegistrationBut.setVisible(false);  
                        value = 1;
                        break;
                    case 1:    
                        lblNewLabel.setText("Student Login");
                        adminChanger.setText("Change To Admin Login");
                        adminChanger.setText("Change To Admin Login");
                        RegistrationBut.setVisible(true); 
                        value = 0; 
                        break;
                    }    
            }   
            });
		LoginBut.addActionListener(e ->
			{
				if (lblNewLabel.getText() == "Admin Login") {
					//backend
					String myPass=String.valueOf(passwordField.getPassword());
					int returnedVal = actionEvent(textfield.getText(), myPass, "admin");
					if (returnedVal != 0) {
						AdminPortal rg = new AdminPortal();
						setVisible(false);
						rg.setVisible(true);
					}
				} else {
					//backend
					String myPass=String.valueOf(passwordField.getPassword());
					int returnedVal = actionEvent(textfield.getText(), myPass, "studentReg");
					if (returnedVal != 0) {
						new StudentPortal(returnedVal);
						setVisible(false);
						//rg.setVisible(true);
					};
				}
			});
		RegistrationBut.addActionListener(e ->
		{
			
			RegFrame rg = new RegFrame();
			setVisible(false);
			rg.setVisible(true);
		});
    
	}
	public int actionEvent(String email, String pw, String table)
	{
	 try{  
		 Class.forName("com.mysql.cj.jdbc.Driver");  
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","Chiragsp","admin");  
		 PreparedStatement Pstatement=con.prepareStatement("Select * from "+ table +" where email=? and password=?");
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
