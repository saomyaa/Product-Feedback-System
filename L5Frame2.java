package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class L5Frame2 extends JFrame implements ActionListener{
    private JFrame j;
    private JTextField textField;
    private JTextField textField_1;
    private ButtonGroup grp1,grp2,grp3;
     private JButton btnNewButton;
    private JTextField textField_2;         //customer name

     private JRadioButton rdbtnNewRadioButton_1;
    private JRadioButton rdbtnNewRadioButton_1_1;
    private JRadioButton rdbtnNewRadioButton_1_2;
    private JRadioButton rdbtnNewRadioButton_1_3;
    private JRadioButton rdbtnNewRadioButton_1_4;


    private JTextPane textPane;
    static final String dburl = "jdbc:mysql://localhost:3306/saomya_db1?useSSL=false";
    static final String dbuser = "saomya";
    static final String dbpass = "somu";
    Connection con=null;
    Statement stmt=null;
    public L5Frame2()
    {
        j=new JFrame("Feedback Form");
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setBounds(280, 5, 957, 838);
        j.getContentPane().setBackground(Color.PINK);
        j.setVisible(true);
        j.setLayout(null);

        JLabel lblNewLabel = new JLabel("Feedback Form ");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
        lblNewLabel.setBounds(303, 10, 386, 57);
        j.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Product Name:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_1.setBounds(501, 90, 130, 49);
        j.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(657, 100, 241, 33);
        j.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("1. Have you used our product before?");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_2.setBounds(88, 162, 320, 33);
        j.add(lblNewLabel_2);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Yes");
        rdbtnNewRadioButton.setBackground(Color.PINK);
        rdbtnNewRadioButton.setForeground(new Color(0, 0, 0));
        rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        rdbtnNewRadioButton.setBounds(78, 201, 140, 33);
        j.add(rdbtnNewRadioButton);

        JRadioButton rdbtnNo = new JRadioButton("No");
        rdbtnNo.setBackground(Color.PINK);
        rdbtnNo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        rdbtnNo.setBounds(238, 201, 140, 33);
        j.add(rdbtnNo);

        grp1=new ButtonGroup();
        grp1.add(rdbtnNewRadioButton);
        grp1.add(rdbtnNo);

        JLabel lblNewLabel_3 = new JLabel("2.What do you like most about our product?");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_3.setBounds(78, 255, 412, 33);
        j.add(lblNewLabel_3);

        textField_1 = new JTextField();
        textField_1.setBounds(78, 298, 412, 33);
        j.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_3_1 = new JLabel("3. How would you describe the buying experience ?");
        lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_3_1.setBounds(78, 341, 469, 33);
        j.add(lblNewLabel_3_1);

        textPane = new JTextPane();
        textPane.setBounds(78, 394, 451, 57);
        j.add(textPane);

        JLabel lblNewLabel_3_1_1 = new JLabel("4. How would you rate our product ? ");
        lblNewLabel_3_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_3_1_1.setBounds(78, 461, 469, 33);
        j.add(lblNewLabel_3_1_1);

         rdbtnNewRadioButton_1 = new JRadioButton("5");
        rdbtnNewRadioButton_1.setBackground(Color.PINK);
        rdbtnNewRadioButton_1.setSelected(true);
        rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        rdbtnNewRadioButton_1.setBounds(78, 500, 35, 21);
        rdbtnNewRadioButton_1.addActionListener(this);
        j.add(rdbtnNewRadioButton_1);

         rdbtnNewRadioButton_1_1 = new JRadioButton("4");
        rdbtnNewRadioButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        rdbtnNewRadioButton_1_1.setBackground(Color.PINK);
        rdbtnNewRadioButton_1_1.setBounds(78, 523, 35, 21);
        rdbtnNewRadioButton_1_1.addActionListener(this);

        j.add(rdbtnNewRadioButton_1_1);

         rdbtnNewRadioButton_1_2 = new JRadioButton("3");
        rdbtnNewRadioButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        rdbtnNewRadioButton_1_2.setBackground(Color.PINK);
        rdbtnNewRadioButton_1_2.setBounds(78, 546, 35, 21);
        rdbtnNewRadioButton_1_2.addActionListener(this);

        j.add(rdbtnNewRadioButton_1_2);

         rdbtnNewRadioButton_1_3 = new JRadioButton("2");
        rdbtnNewRadioButton_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        rdbtnNewRadioButton_1_3.setBackground(Color.PINK);
        rdbtnNewRadioButton_1_3.setBounds(78, 569, 35, 21);
        rdbtnNewRadioButton_1_3.addActionListener(this);

        j.add(rdbtnNewRadioButton_1_3);

         rdbtnNewRadioButton_1_4 = new JRadioButton("1");
        rdbtnNewRadioButton_1_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
        rdbtnNewRadioButton_1_4.setBackground(Color.PINK);
        rdbtnNewRadioButton_1_4.setBounds(78, 592, 35, 21);
        rdbtnNewRadioButton_1_4.addActionListener(this);

        j.add(rdbtnNewRadioButton_1_4);

        grp2=new ButtonGroup();
        grp2.add(rdbtnNewRadioButton_1_4);
        grp2.add(rdbtnNewRadioButton_1_3);
        grp2.add(rdbtnNewRadioButton_1_2);
        grp2.add(rdbtnNewRadioButton_1_1);
        grp2.add(rdbtnNewRadioButton_1);

        JLabel lblNewLabel_3_1_1_1 = new JLabel("5. Are you planning on using it again?");
        lblNewLabel_3_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_3_1_1_1.setBounds(78, 628, 469, 33);
        j.add(lblNewLabel_3_1_1_1);

        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Yes");
        rdbtnNewRadioButton_2.setForeground(Color.BLACK);
        rdbtnNewRadioButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        rdbtnNewRadioButton_2.setBackground(Color.PINK);
        rdbtnNewRadioButton_2.setBounds(78, 667, 140, 33);
        j.add(rdbtnNewRadioButton_2);

        JRadioButton rdbtnNo_1 = new JRadioButton("No");
        rdbtnNo_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        rdbtnNo_1.setBackground(Color.PINK);
        rdbtnNo_1.setBounds(78, 698, 140, 33);
        j.add(rdbtnNo_1);

        JRadioButton rdbtnMayBe = new JRadioButton("May be");
        rdbtnMayBe.setFont(new Font("Times New Roman", Font.BOLD, 20));
        rdbtnMayBe.setBackground(Color.PINK);
        rdbtnMayBe.setBounds(78, 733, 140, 33);
        j.add(rdbtnMayBe);

        grp3=new ButtonGroup();
        grp3.add(rdbtnNewRadioButton_2);
        grp3.add(rdbtnNo_1);
        grp3.add(rdbtnMayBe);

         btnNewButton = new JButton("Submit");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
        btnNewButton.setBounds(750, 733, 148, 42);
        btnNewButton.addActionListener(this);

        j.add(btnNewButton);

        JLabel lblNewLabel_1_1 = new JLabel("Customer  Name:");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_1_1.setBounds(88, 90, 159, 49);
        j.add(lblNewLabel_1_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(253, 100, 222, 33);
        j.add(textField_2);

    }

    public void actionPerformed(ActionEvent e)
    {
        String prod_name=textField.getText();
        String review=textPane.getText();
        String rating=" ";
        String name=textField_2.getText();
        if(rdbtnNewRadioButton_1.isSelected())
        {
            rating="5";
        }
        if(rdbtnNewRadioButton_1_1.isSelected())
        {
            rating="4";
        }
        if(rdbtnNewRadioButton_1_2.isSelected())
        {
            rating="3";
        }
        if(rdbtnNewRadioButton_1_3.isSelected())
        {
            rating="2";
        }
        if(rdbtnNewRadioButton_1_4.isSelected())
        {
            rating="1";
        }

        if(e.getSource()==btnNewButton)
        {

            try{
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                Connection con=DriverManager.getConnection(dburl,dbuser,dbpass);
                Statement state=con.createStatement();
                String query="insert into feedback values('"+name+"','"+prod_name+"','"+rating+"','"+review+"')";
                state.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Thankyou for your Feedback!");
                System.exit(0);

            }
            catch(SQLException ex)
            {
                System.out.println("FAILED!");
            }

            //insert into feedback table
            //pop-up window thankyou!

        }

    }

}
