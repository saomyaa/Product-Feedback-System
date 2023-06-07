package com.company;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class SearchResult implements ActionListener{
    JFrame frame, frame1;
    JTextField textbox;
    JLabel label;
    JButton button;
    //JPanel panel;
    static JTable table;

    String driverName = "com.mysql.cj.jdbc.Driver";
    static final String dburl = "jdbc:mysql://localhost:3306/saomya_db1?useSSL=false";
    static final String dbuser = "saomya";
    static final String dbpass = "somu";
    String[] columnNames = {"Cust_name", "Prod_name", "Rating", "Review"};

    public SearchResult()
    {
        frame = new JFrame("Feedback Result");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.PINK);
        frame.setBounds(300,60, 900,600 );
        textbox = new JTextField();
        textbox.setBounds(30,90,150,20);
        label = new JLabel("Please enter the customer's name whose feedback record you want: ");
        label.setBounds(30, 50, 500, 20);
        label.setFont(new Font("Times New Roman",Font.ITALIC | Font.BOLD,20));
        button = new JButton("Search");
        button.setBounds(30,200,150,20);
        button.addActionListener(this);

        frame.add(textbox);
        frame.add(label);
        frame.add(button);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        button = (JButton)ae.getSource();
        System.out.println("Showing Table Data.......");
        showTableData();
    }

    public void showTableData()
    {

        frame1 = new JFrame("Feedback Record");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
        frame1.getContentPane().setBackground(Color.PINK);
        frame1.setBounds(300,60,900,600);
//TableModel tm = new TableModel();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());
//table = new JTable(model);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String textvalue = textbox.getText();
        String cust_name= "";
        String prod_name= "";
        String rating = "";
        String review = "";
        try
        {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dburl, dbuser,dbpass);
            String sql = "select * from feedback where cust_name = '"+textvalue+"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i =0;
            while(rs.next())
                {
                    cust_name = rs.getString("cust_name");
                    prod_name = rs.getString("prod_name");
                    rating = rs.getString("rating");
                    review = rs.getString("review");
                    model.addRow(new Object[]{cust_name, prod_name, rating, review});
                    i++;
                }

            if(i <1)
            {
                JOptionPane.showMessageDialog(null, "No Record Found","Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            if(i ==1)
            {
                System.out.println(i+" Record Found");
            }
            else
            {
                System.out.println(i+" Records Found");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        frame1.add(scroll);
        frame1.setVisible(true);


    }

}