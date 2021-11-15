
package hotelmanagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;


public class Department extends JFrame implements ActionListener {
       
     
      JButton b1,b2;
      JTable t1;
      JLabel l3,l4;
  Department(){
      
        
        t1=new JTable();
        t1.setBounds(0, 55, 700, 300);
        add(t1);
     
      b1 = new JButton("Search");
      b1.setBounds(180, 400, 120, 30);
      b1.addActionListener(this);
      b1.setBackground(Color.BLACK);
      b1.setForeground(Color.WHITE);
      add(b1);
      
       b2 = new JButton("Back");
       b2.setBounds(380, 400, 120, 30);
       b2.addActionListener(this);
       b2.setBackground(Color.BLACK);
       b2.setForeground(Color.WHITE);
       add(b2); 
       
       l3 = new JLabel("Department");
       l3.setBounds(145, 11, 105, 14);
        add(l3);
		
        l4 = new JLabel("Budget");
	l4.setBounds(431, 11, 75, 14);
	add(l4);
        
      setLayout(null);
      setBounds(400,200,700,500);
      setVisible(true);
  }  
  
  public static void main (String args[]){
      new Department().setVisible(true);
  }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
          
          try{
             
            String str = "select * from department";
            conn c = new conn();
            ResultSet rs = c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));
           			
          }catch(Exception ae){
            System.out.println(ae);
        }
    } else if(e.getSource()== b2){
        new Reception().setVisible(true);
          this.setVisible(false);
    }
    }
}
