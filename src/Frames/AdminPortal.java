package Frames;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class AdminPortal extends JFrame{
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
        pane.add(bg);
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


        setVisible(true);

        //Logic
        // subbtn.addActionListener(e ->
        // {
        //     StudentPortal rg = new StudentPortal();
        //     setVisible(false);
        //     rg.setVisible(true);
        // });

        Logout.addMouseListener(new MouseAdapter()   {   
            public void mouseClicked(MouseEvent e)   
            { 
                LoginFormS rg = new LoginFormS();
                setVisible(false);
                rg.setVisible(true);   
            }});

        //ALL STYLING
        // Component[] component = pane.getComponents();
        // for(int i=0; i<component.length; i++)
        // {
        //     if (component[i] instanceof JButton)
        //     {
        //         JButton button = (JButton)component[i];
        //         button.setFocusPainted(false);
        //     }
        // };

    }
}



