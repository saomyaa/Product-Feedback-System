package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class L4Frame2 extends JFrame implements ActionListener{
    private JFrame j;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_3;
    private JLabel customer_details;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_1_1;
    private JLabel lblNewLabel_1_2;
    private JLabel lblNewLabel_1_3;
    private JButton btnNewButton;
    private JTextPane textPane;
    private JLabel custid;
    private JTextField custid_text;
    public String user;
    static final String dburl = "jdbc:mysql://localhost:3306/saomya_db1?useSSL=false";
    static final String dbuser = "saomya";
    static final String dbpass = "somu";
    Connection con=null;
    Statement stmt=null;
    public L4Frame2(String userID)
    {
        j =new JFrame("Customer Details");
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setBounds(300, 60, 900, 700);
        j.setVisible(true);
        j.setLayout(null);
        j.getContentPane().setBackground(Color.PINK);

         customer_details = new JLabel("Customer Details");
        customer_details.setFont(new Font("Times New Roman", Font.BOLD, 36));
        customer_details.setLocation(336, 37);
        customer_details.setSize( 383, 67);
        j.add(customer_details);

         lblNewLabel_1 = new JLabel("Name:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNewLabel_1.setBounds(112, 182, 132, 42);
        j.add(lblNewLabel_1);

         lblNewLabel_1_1 = new JLabel("Email: ");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNewLabel_1_1.setBounds(112, 248, 112, 30);
        j.add(lblNewLabel_1_1);

         lblNewLabel_1_2 = new JLabel("Address:");
        lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNewLabel_1_2.setBounds(112, 312, 112, 30);
        j.add(lblNewLabel_1_2);

         lblNewLabel_1_3 = new JLabel("Mobile No:");
        lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNewLabel_1_3.setBounds(112, 476, 132, 30);
        j.add(lblNewLabel_1_3);

        textField = new JTextField();
        textField.setBounds(297, 193, 285, 30);
        j.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(297, 248, 285, 30);
        j.add(textField_1);

        textField_3 = new JTextField();
        textField_3.setColumns(20);
        textField_3.setBounds(297, 476, 285, 30);
        j.add(textField_3);

        btnNewButton = new JButton("Submit");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
        btnNewButton.setBounds(292, 539, 148, 42);
        btnNewButton.addActionListener(this);
        j.add(btnNewButton);

         textPane = new JTextPane();
        textPane.setBounds(297, 312, 347, 125);
        j.add(textPane);

        custid=new JLabel("Customer Id :");
        custid.setFont(new Font("Times New Roman", Font.BOLD, 25));
        custid.setBounds(112, 118, 165, 42);
        j.add(custid);

        custid_text=new JTextField();
        custid_text.setColumns(10);
        custid_text.setBounds(297, 129, 285, 30);
        j.add(custid_text);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnNewButton)
        {
            storeData();
            new L5Frame2();
        }
     }
    public void storeData()

    {
        String user =custid_text.getText();
       String name=textField.getText();
        String email=textField_1.getText();
        String add=textPane.getText();
        String mobile=textField_3.getText();
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con=DriverManager.getConnection(dburl,dbuser,dbpass);
            Statement state=con.createStatement();
            String query="update customer set cust_name='"+name+"',email='"+email+"',address='"+add+"',mobile_no='"+mobile+"'where cust_id='"+user+"'";
            state.executeUpdate(query);
        }
        catch(SQLException e)
        {
            System.out.println("Failed!");
        }
    }


}
