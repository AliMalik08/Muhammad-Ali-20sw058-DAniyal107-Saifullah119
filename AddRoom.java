package hotelmanagement;

import java.awt.*;
import javax.swing.*;
//import javax.swing.border.*;
import java.awt.event.*;
//import java.sql.*;
//import java.util.*;

public class AddRoom extends JFrame  implements ActionListener  {
    JTextField t1,t2,t3;
    JComboBox c1, c2, c3, c4;
    JButton b1,b2;
    Choice c;
    
    AddRoom(){
        JLabel l1 = new JLabel("Add Rooms");
        l1.setFont(new Font("Tahoma", Font.BOLD, 18));
	l1.setBounds(194, 10, 120, 22);
        add(l1);
        
        JLabel l2 = new JLabel("Room Number");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(64, 70, 102, 22);
	add(l2);
        
         t1 = new JTextField();
	t1.setBounds(174, 70, 156, 20);
	add(t1);
        
        JLabel l3 = new JLabel("Availability");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(64, 110, 102, 22);
	add(l3);
        
        c1 = new JComboBox(new String[] { "Available", "Occupied" });
        c1.setBackground(Color.white);
	c1.setBounds(176, 110, 154, 20);
	add(c1);
        JLabel l4 = new JLabel("Cleaning Status");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(64, 150, 102, 22);
	add(l4);
        
        c2 = new JComboBox(new String[] { "Cleaned", "Dirty" });
        c2.setBackground(Color.white);
	c2.setBounds(176, 150, 154, 20);
	add(c2);
        
        JLabel l5 = new JLabel("Price");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(64, 190, 102, 22);
	add(l5);
        
        t2 = new JTextField();
	t2.setBounds(174, 190, 156, 20);
	add(t2);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Hotelmanagement/icon/twelve.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l6 = new JLabel(i2);
                l6.setBounds(400,30,500,370);
                add(l6);
        
        JLabel type = new JLabel("Bed Type");
	type.setForeground(new Color(25, 25, 112));
	type.setFont(new Font("Tahoma", Font.BOLD, 14));
	type.setBounds(64, 230, 102, 22);
	add(type);
        
        c3 = new JComboBox(new String[] { "Single Bed", "Double Bed"});
        c3.setBackground(Color.white);
	c3.setBounds(176, 230, 154, 20);
	add(c3);
        
        b1 = new JButton("Add");
	b1.setBounds(64, 321, 111, 33);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	add(b1);

	b2 = new JButton("Back");
	b2.setBounds(198, 321, 111, 33);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	add(b2);
        
        getContentPane().setBackground(Color.white);
        setBounds(300,200,1000,500);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
            if(ae.getSource() == b1){
                
                String room = t1.getText();
                String available = (String)c1.getSelectedItem();
                String status = (String)c2.getSelectedItem();
                String price  = t2.getText();
                String type = (String)c3.getSelectedItem();
            
         conn cc = new conn();
          try{
               String str = "INSERT INTO room values( '"+room+"', '"+available+"', '"+status+"','"+price+"', '"+type+"')";
               cc.s.executeUpdate(str);
	JOptionPane.showMessageDialog(null, "Room Successfully Added");
          this.setVisible(false);
          }catch(Exception e){
              
          }
    }else if(ae.getSource() == b2){
                new AddRoom().setVisible(false);
            }
    }

    public static void main (String args[]){
        new AddRoom().setVisible(true);
    }}
