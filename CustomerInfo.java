
package hotelmanagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import net.proteanit.sql.*;
public class CustomerInfo extends JFrame implements ActionListener {
    JTable t1;
    JLabel l1,l2;
    JButton b1,b2;
    CustomerInfo(){
        t1=new JTable();
        t1.setBounds(0, 40, 900, 450);
        add(t1);
        b1 = new JButton("Load Data");
        b1.setBounds(300, 510, 120, 30);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        b2 = new JButton("Back");
        b2.setBounds(450, 510, 120, 30);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        
        JLabel l1 = new JLabel("Document Type");
	l1.setBounds(31, 11,46, 14);
        add(l1);
		
	JLabel l2 = new JLabel("Number"); 
        l2.setBounds(150, 11, 46, 14);
	add(l2);
		
	JLabel l3 = new JLabel("Name");
	l3.setBounds(270, 11, 46, 14);
        add(l3);
		
	JLabel l4 = new JLabel("Gender");
        l4.setBounds(360, 11, 86, 14);
	add(l4);
        
                
        JLabel l5 = new JLabel("Country");                
        l5.setBounds(480, 11, 86, 14);
	add(l5);
                
        JLabel l6 = new JLabel("Room No");
        l6.setBounds(600, 11, 86, 14);
	add(l6);
                
        JLabel l7 = new JLabel("Status");
	l7.setBounds(680, 11, 86, 14);
        add(l7);
                
        JLabel l8 = new JLabel("Deposit");
	l8.setBounds(800, 11, 86, 14);
        add(l8);
                
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(300,150,900,600);
        setVisible(true);
    }
    public static void main(String args[]){
        new CustomerInfo().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==b1){
          try{
         conn c = new conn();			
        String displayCustomersql = "select * from customer";
	ResultSet rs = c.s.executeQuery(displayCustomersql);
	t1.setModel(DbUtils.resultSetToTableModel(rs));
          }catch(Exception e1){
              e1.printStackTrace();
				}
			}
          
 else if(e.getSource()== b2){
          new Reception().setVisible(true);
          this.setVisible(false);
      }
    }
}

