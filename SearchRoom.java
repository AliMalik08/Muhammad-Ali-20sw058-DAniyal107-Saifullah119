
package hotelmanagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;


public class SearchRoom extends JFrame implements ActionListener {
    JComboBox c1;
      JCheckBox c2;
      JButton b1,b2;
      JTable t1;
  SearchRoom(){
      
        JLabel l1 = new JLabel("Search For Room");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
         l1.setBounds(250, 11, 186, 31);
        add(l1);
        
        
		
	JLabel l2 = new JLabel("Room Bed Type:");
	l2.setBounds(50, 73, 96, 14);
	add(l2);
        
        c1 = new JComboBox(new String[]{"Single bed","Double bed"});
	c1.setBounds(153, 70, 120, 20);
        c1.setBackground(Color.WHITE);
        add(c1);
        
         c2 = new JCheckBox("Only display Available");
         c2.setBounds(400, 69, 205, 23);
         c2.setBackground(Color.WHITE);
        add(c2);
		
	JLabel l3 = new JLabel("Room Number");
	l3.setBounds(23, 162, 96, 14);
	add(l3);
		
        
	JLabel l4 = new JLabel("Availability");
        l4.setBounds(175, 162, 120, 14);
        add(l4);
		
	JLabel l5 = new JLabel("Price");
	l5.setBounds(458, 162, 46, 14);
        add(l5);
                
        JLabel l6 = new JLabel("Bed Type");
        l6.setBounds(580, 162, 96, 14);
	add(l6);
        
      t1= new JTable();
      t1.setBounds(0, 200, 1000, 200);
      add(t1);
     
      b1 = new JButton("Search");
      b1.setBounds(200, 400, 120, 30);
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
      setLayout(null);
      setBounds(500,200,700,500);
      setVisible(true);
  }  
  
  public static void main (String args[]){
      new SearchRoom().setVisible(true);
  }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
          
          try{
             
            String str = "select * from Room where bed_type = '"+c1.getSelectedItem()+"'";
            String str2 = "select * from Room where availabile = 'available' AND bed_type = '"+c1.getSelectedItem()+"'";
            conn c = new conn();
            ResultSet rs = c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));
            if(c2.isSelected())
            	{
                    rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
				}
          }catch(Exception ae){
            
        }
    } else if(e.getSource()== b2){
        new Reception().setVisible(true);
          this.setVisible(false);
    }
    }
}
