package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class L1Frame extends JFrame
        implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel login_type;
    private JRadioButton customer;
    private JRadioButton product_seller;
    private ButtonGroup gengp;
    private JButton sub;

    // constructor, to initialize the components
// with default values.
    public L1Frame()
    {
        setTitle("Product Feedback System");
        setBounds(300, 60, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        title = new JLabel("Login Portal");
        title.setFont(new Font("Times New Roman", Font.BOLD, 36));
        title.setSize(200, 60);
        title.setLocation(350, 30);
        c.add(title);



        login_type = new JLabel("Login Type: ");
        login_type.setFont(new Font("Times New Roman", Font.BOLD, 30));
        login_type.setSize(180, 40);
        login_type.setLocation(100, 195);
        c.add(login_type);

        customer= new JRadioButton("Customer");
        customer.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        customer.setSelected(true);
        customer.setSize(150, 20);
        customer.setLocation(300, 200);
        customer.setBackground(Color.PINK);
        c.add(customer);

        product_seller = new JRadioButton("Admin");
        product_seller.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        product_seller.setSelected(false);
        product_seller.setSize(160, 20);
        product_seller.setLocation(500, 200);
        product_seller.setBackground(Color.PINK);
        c.add(product_seller);

        gengp = new ButtonGroup();
        gengp.add(customer);
        gengp.add(product_seller);

        sub = new JButton("Next");
        sub.setFont(new Font("Times New Roman", Font.BOLD, 20));
        sub.setSize(120, 50);
        sub.setLocation(350, 450);
        sub.addActionListener(this);
        c.add(sub);

        setVisible(true);
    }

    // method actionPerformed()
// to get the action performed
// by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
            if (customer.isSelected()) {
                new L2Frame();
                //login page of customer is opened
                //feedback form
            }
            else if(product_seller.isSelected()) {
                new L3Frame();
                //login page of prod_seller is opened
                //display records
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        L1Frame f=new L1Frame();
    }

}