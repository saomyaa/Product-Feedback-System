package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class L2Frame implements ActionListener {
    private JFrame j= new JFrame("Customer Login");
    private JLabel msg, custId, pwd;
    private JTextField customerID,Password;
    private JButton next;

    static final String dburl = "jdbc:mysql://localhost:3306/saomya_db1?useSSL=false";
    static final String dbuser = "saomya";
    static final String dbpass = "somu";
    Connection con=null;
    Statement stmt=null;

    public L2Frame()
    {
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
        j.setBounds(300,60, 900,600 );
        j.setLayout(null);
        j.getContentPane().setBackground(Color.PINK);

        custId=new JLabel("Customer ID: ");
        custId.setFont(new Font("Times New Roman",Font.BOLD,26));
        custId.setLocation(100,185);
        custId.setSize(180,60);
        j.add(custId);

        msg=new JLabel("Please Enter your Credentials to give Feedback..");
        msg.setFont(new Font("Times New Roman",Font.ITALIC | Font.BOLD,20));
        msg.setSize(600,40);
        msg.setLocation(100,50);
        j.add(msg);

        pwd=new JLabel("Password: ");
        pwd.setFont(new Font("Times New Roman",Font.BOLD,26));
        pwd.setLocation(100,290);
        pwd.setSize(140,60);
        j.add(pwd);

        customerID=new JTextField(50);
        customerID.setText("Enter your Customer ID");
        customerID.selectAll();
        customerID.setBounds(270,200,200,30);
        j.add(customerID);

        Password=new JTextField(50);
        Password.setText("Enter your Password");
        Password.selectAll();
        Password.setBounds(270,300,200,30);
        j.add(Password);

        next=new JButton("Next");
        next.setFont(new Font("Arial", Font.PLAIN, 20));
        next.setSize(120, 50);
        next.setLocation(350, 450);
        next.addActionListener(this);
        j.add(next);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==next)
        {
            searchData();
        }

    };

    public void searchData() {
        String userID=customerID.getText();
        String pass=Password.getText();

        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con=DriverManager.getConnection(dburl,dbuser,dbpass);
            PreparedStatement ps= (PreparedStatement)con.prepareStatement("select cust_id,pwd from cred where cust_id=? and pwd=?");
            ps.setString(1,userID);
            ps.setString(2,pass);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                Statement state=con.createStatement();
                String query="insert into customer values('"+userID+"',null,null,null,null)";
                state.executeUpdate(query);

                new L4Frame2(userID);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"INVALID CREDENTIALS!");
                new L2Frame();
            }
        }
        catch(SQLException e)
        {
            System.out.println("FAILED!");
        }

    }




}
