
package hotelmanagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import net.proteanit.sql.*;
public class ManagerInfo extends JFrame implements ActionListener {
    JTable t1;
    JLabel l1,l2;
    JButton b1,b2;
    ManagerInfo(){
        
        b1 = new JButton("Load Data");
        b1.setBounds(350, 500, 120, 30);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        b2 = new JButton("Back");
        b2.setBounds(510, 500, 120, 30);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        
        t1=new JTable();
        t1.setBounds(0,30,960,500);
        add(t1);
        
        JLabel l1 = new JLabel("Name");
	l1.setBounds(41, 11, 46, 14);
        add(l1);
		
	JLabel l2 = new JLabel("Age"); 
        l2.setBounds(159, 11, 46, 14);
	add(l2);
		
	JLabel l3 = new JLabel("Gender");
	l3.setBounds(273, 11, 46, 14);
        add(l3);
		
	JLabel l4 = new JLabel("Job");
        l4.setBounds(416, 11, 86, 14);
	add(l4);
                
        JLabel l5 = new JLabel("Salary");                
        l5.setBounds(536, 11, 86, 14);
	add(l5);
                
        JLabel l6 = new JLabel("Phone");
        l6.setBounds(656, 11, 86, 14);
	add(l6);
                
        JLabel l7 = new JLabel("Cnic");
	l7.setBounds(786, 11, 86, 14);
        add(l7);
                
        JLabel l8 = new JLabel("Gmail");
	l8.setBounds(896, 11, 86, 14);
        add(l8);
                
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(300,150,1000,600);
        setVisible(true);
    }
    public static void main(String args[]){
        new ManagerInfo().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==b1){
          try{
         conn c = new conn();			
        String displayCustomersql = "select * from employee where job='Manager'";
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
