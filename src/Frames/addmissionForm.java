package Frames;

import javax.swing.*;
import java.awt.*;

public class addmissionForm extends JFrame {
    public addmissionForm(int ID) {
        setTitle("Addmission Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);// close java prog on close of window
        setSize(1100, 720);// window size
        setLayout(null);// layout to null for window
        setLocationRelativeTo(null);// start window in center on monitor
        setResizable(false);// avoid window scaling

        // plane
        JPanel panel = new JPanel();
        panel.setLayout(null);

        add(panel);
        panel.setSize(1280, 720);

        // setContentPane(panel);

        JLabel title = new JLabel("Qualification Details", JLabel.CENTER);
        JLabel q = new JLabel("Qualification");
        JLabel mo = new JLabel("Marks Obtained");
        JLabel mou = new JLabel("Marks Out Of");
       // JLabel per = new JLabel("Percentage");
        JLabel phy = new JLabel("HSC PHYSICS MKS");
        JLabel mat = new JLabel("HSC MATHS MKS");
        JLabel chm = new JLabel("HSC CHEMISTRY MKS");
        JLabel bio = new JLabel("HSC BIOLOGY MKS");
        JLabel eng = new JLabel("HSC ENGLISH MKS");
        JLabel agg = new JLabel("HSC AGGREGATE MKS");

        JLabel m1 = new JLabel("100");
        JLabel m2 = new JLabel("100");
        JLabel m3 = new JLabel("100");
        JLabel m4 = new JLabel("100");
        JLabel m5 = new JLabel("100");
        JLabel m6 = new JLabel("650");

        JLabel cet = new JLabel("MHT-CET  Percentile Score:-");
        JLabel apn = new JLabel("APPLICATION NUMBER");
        // JLabel mphy = new JLabel("PHYSICS");
        // JLabel mmat = new JLabel("MATHS");
        JLabel mrn = new JLabel("TOTAL Percentile");
        // JLabel mchm = new JLabel("CHEMISTRY");
       // JLabel mt = new JLabel("TOTAL Percentile");

        JLabel jee = new JLabel("JEE Main Percentile Score:-");
        JLabel jap = new JLabel("Appeared for JEE");
        JLabel jrn = new JLabel("ROLL Number");
        // JLabel jp = new JLabel("PHYSICS");
        // JLabel jc = new JLabel("CHEMISTRY");
        // JLabel jm = new JLabel("MATHS");
        //JLabel jtot = new JLabel("TOTAL Percentile");

        // object calling
        // JLabel up=new JLabel("User Profile");

        // object adding
        // panel.add(up);
        // obj setbounds
        // up.setBounds (65, 108, 232, 35);

        JTextField hmm = new JTextField(3);
        //JTextField hmm1 = new JTextField(3);
        JTextField hcm = new JTextField(3);
        //JTextField hcm1 = new JTextField(3);
        JTextField hbm = new JTextField(3);
        //JTextField hbm1 = new JTextField(3);
        JTextField hpm = new JTextField(3);
        //JTextField hpm1 = new JTextField(3);
        JTextField hem = new JTextField(3);
        //JTextField hem1 = new JTextField(3);
        JTextField ham = new JTextField(3);
        //JTextField ham1 = new JTextField(3);
        JTextField apn1 = new JTextField(3);
        JTextField mphy1 = new JTextField(3);
        JTextField mmat1 = new JTextField(3);
        JTextField mrn1 = new JTextField(3);
        JTextField mchm1 = new JTextField(3);
        JTextField mt1 = new JTextField(3);

        JTextField jtot1 = new JTextField(3);
        JTextField jap1 = new JTextField(3);
        JTextField jrn1 = new JTextField(3);
        JTextField jp1 = new JTextField(3);
        JTextField jc1 = new JTextField(3);
        JTextField jm1 = new JTextField(3);
        JButton SUBMIT = new JButton("SUBMIT");

        // add components;
        panel.add(title);
        panel.add(q);
        panel.add(mo);
        panel.add(mou);
        //panel.add(per);
        panel.add(phy);
        panel.add(mat);
        panel.add(chm);
        panel.add(bio);
        panel.add(eng);
        panel.add(agg);
        panel.add(hpm);
        //panel.add(hpm1);
        panel.add(hmm);
        //panel.add(hmm1);
        panel.add(hcm);
        //panel.add(hcm1);
        panel.add(hbm);
        //panel.add(hbm1);
        panel.add(hem);
        //panel.add(hem1);
        panel.add(ham);
        //panel.add(ham1);
        panel.add(m1);
        panel.add(m2);
        panel.add(m3);
        panel.add(m4);
        panel.add(m5);
        panel.add(m6);
        panel.add(cet);
        panel.add(apn);
        panel.add(apn1);
        //panel.add(mphy);
        panel.add(mphy1);
        panel.add(mmat1);
        panel.add(mrn);
        panel.add(mrn1);
   
        panel.add(mchm1);

        panel.add(mt1);

        panel.add(jee);
        panel.add(jap);
        panel.add(jap1);
        panel.add(jrn);
        panel.add(jrn1);

        panel.add(jp1);

        panel.add(jc1);
    
        panel.add(jm1);
        //panel.add(jtot);
        panel.add(jtot1);

        panel.add(SUBMIT);

        // set component bounds (only needed by Absolute Positioning);
        title.setBounds(0, 0, 1100, 91);// 314,0,640,91
        q.setBounds(99, 116, 215, 41);// 170, 100, 100, 25
        mo.setBounds(345, 128, 173, 41);
        mou.setBounds(548, 127, 173, 41);
        //per.setBounds(721, 126, 173, 41);
        phy.setBounds(175, 169, 139, 19);
        mat.setBounds(175, 200, 146, 19);
        chm.setBounds(175, 231, 146, 19);
        bio.setBounds(175, 264, 146, 19);
        eng.setBounds(175, 295, 146, 19);
        agg.setBounds(175, 324, 146, 19);
        hpm.setBounds(345, 169, 158, 19);
        //hpm1.setBounds(704, 167, 158, 19);
        hmm.setBounds(345, 200, 158, 19);
        //hmm1.setBounds(704, 205, 158, 19);
        hcm.setBounds(345, 233, 158, 19);
        //hcm1.setBounds(704, 236, 158, 19);
        hbm.setBounds(345, 264, 158, 19);
        //hbm1.setBounds(704, 266, 158, 19);
        hem.setBounds(345, 291, 158, 19);
        //hem1.setBounds(704, 295, 158, 19);
        ham.setBounds(345, 324, 158, 19);
        //ham1.setBounds(704, 324, 158, 19);
        m1.setBounds(565, 167, 139, 19);
        m2.setBounds(565, 199, 139, 19);
        m3.setBounds(565, 230, 139, 19);
        m4.setBounds(565, 264, 139, 19);
        m5.setBounds(565, 289, 139, 19);
        m6.setBounds(565, 324, 139, 19);
        cet.setBounds(90, 368, 328, 32);
        apn.setBounds(166, 409, 179, 30);
        apn1.setBounds(345, 406, 158, 19);
        mrn.setBounds(565, 406, 179, 30);
        mrn1.setBounds(704, 400, 158, 19);
       // mphy.setBounds(166, 444, 179, 30);
        mphy1.setBounds(345, 444, 158, 19);

        //mchm.setBounds(565, 449, 179, 30);
        mchm1.setBounds(704, 444, 158, 19);
        //mmat.setBounds(166, 486, 179, 30);
        mmat1.setBounds(345, 480, 158, 19);
       // mt.setBounds(565, 486, 179, 30);
        mt1.setBounds(704, 480, 158, 19);

        jee.setBounds(90, 530, 328, 32);
        jap.setBounds(166, 567, 179, 30);
        jap1.setBounds(345, 563, 158, 19);

        jrn.setBounds(566, 567, 179, 30);
        jrn1.setBounds(704, 567, 158, 19);

        //jp.setBounds(166, 599, 179, 30);
        jp1.setBounds(345, 593, 158, 19);

        //jc.setBounds(566, 597, 179, 30);
        jc1.setBounds(704, 600, 158, 19);

        //jm.setBounds(166, 634, 179, 30);
        jm1.setBounds(345, 632, 158, 19);

        //jtot.setBounds(566, 634, 179, 30);
        jtot1.setBounds(704, 631, 158, 19);

        SUBMIT.setBounds(900, 623, 173, 41);

        // STYLing

        // COurier Arial Serif
        title.setFont(new Font("Courier", Font.ITALIC, 40));
        title.setOpaque(true);
        title.setBackground(Color.lightGray);
        title.setForeground(Color.white);
        panel.setBackground(Color.decode("#EDE3E3"));

        setVisible(true);

        //logic
        SUBMIT.addActionListener(e ->
        {
            new StudentPortal(ID);
            setVisible(false);
            //rg.setVisible(true);
        });
    }
}
