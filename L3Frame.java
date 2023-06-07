package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class L3Frame implements ActionListener{
    private JFrame j= new JFrame("Admin Login");
    private JLabel msg,psID,pwd;
    private JTextField PS_ID,Password;
    private JButton next;
    static final String dburl = "jdbc:mysql://localhost:3306/saomya_db1?useSSL=false";
    static final String dbuser = "saomya";
    static final String dbpass = "somu";
    Connection con=null;
    Statement stmt=null;
    public L3Frame()
    {
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
        j.setBounds(300,60, 900,600 );
        j.setLayout(null);
        j.getContentPane().setBackground(Color.PINK);

        psID=new JLabel("Admin ID: ");
        psID.setFont(new Font("Times New Roman",Font.BOLD,26));
        psID.setLocation(100,185);
        psID.setSize(150,60);
        j.add(psID);

        msg=new JLabel("Please Enter your Credentials to see records till now..");
        msg.setFont(new Font("Times New Roman",Font.ITALIC|Font.BOLD,20));
        msg.setSize(600,40);
        msg.setLocation(100,50);
        j.add(msg);

        pwd=new JLabel("Password: ");
        pwd.setFont(new Font("Times New Roman",Font.BOLD,26));
        pwd.setLocation(100,290);
        pwd.setSize(140,60);
        j.add(pwd);

        PS_ID=new JTextField(50);
        PS_ID.setText("Enter your Admin ID");
        PS_ID.selectAll();
        PS_ID.setBounds(250,200,200,30);
        j.add(PS_ID);

        Password=new JTextField(50);
        Password.setText("Enter your Password");
        Password.selectAll();
        Password.setBounds(250,300,200,30);
        j.add(Password);

        next=new JButton("Next");
        next.setFont(new Font("Arial", Font.BOLD, 20));
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
        String userID=PS_ID.getText();
        String pass=Password.getText();

        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con=DriverManager.getConnection(dburl,dbuser,dbpass);
            PreparedStatement ps= (PreparedStatement)con.prepareStatement("select admin_id,pwd from t_admin where admin_id=? and pwd=?");
            ps.setString(1,userID);
            ps.setString(2,pass);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
//                Statement state=con.createStatement();
//                String query="insert into t_customer values('"+userID+"',null,null,null,null)";
//                state.executeUpdate(query);
//                String query2="insert into t_feedback values(null,null,null,'"+userID+"')";
//                state.executeUpdate(query2);
                new SearchResult();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"INVALID CREDENTIALS!");
                new L3Frame();
            }
        }
        catch(SQLException e)
        {
            System.out.println("FAILED!");
        }

    }
}
