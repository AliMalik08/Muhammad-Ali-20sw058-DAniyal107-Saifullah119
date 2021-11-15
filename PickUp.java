
package hotelmanagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;


public class PickUp extends JFrame implements ActionListener {
        Choice c1;
      JCheckBox c2;
      JButton b1,b2;
      JTable t1;
  PickUp(){
      
        JLabel l1 = new JLabel("PickUp Service");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
         l1.setBounds(250, 11, 186, 31);
        add(l1);
        
        
		
	JLabel l2 = new JLabel("Type of Car");
	l2.setBounds(50, 73, 96, 14);
	add(l2);
        
        c1 = new Choice();
        try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from driver");
                    while(rs.next()){
                        c1.add(rs.getString("brand"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(123, 94, 150, 25);
		add(c1);
        
         
		JLabel lblInfo = new JLabel("Name");
		lblInfo.setBounds(24, 208, 46, 14);
		add(lblInfo);
        
                JLabel lblNewLabel = new JLabel("Age");
		lblNewLabel.setBounds(165, 208, 46, 14);
		add(lblNewLabel);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(264, 208, 46, 14);
		add(lblGender);
		
		JLabel lblTypeOfDriver = new JLabel("Company");
		lblTypeOfDriver.setBounds(366, 208, 80, 14);
		add(lblTypeOfDriver);
		
		JLabel lblDateOfThe = new JLabel("Brand");
		lblDateOfThe.setBounds(486, 208, 105, 14);
		add(lblDateOfThe);
	
		JLabel lblAirport = new JLabel("Available");
		lblAirport.setBounds(600, 208, 86, 14);
		add(lblAirport);
		
		JLabel lblAvailable = new JLabel("Location");
		lblAvailable.setBounds(700, 208, 73, 14);
		add(lblAvailable);
                
                
     
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
       
        t1 = new JTable();
        t1.setBounds(0, 233, 800, 250);
        add(t1);
                
      setLayout(null);
      setBounds(400,200,800,500);
      setVisible(true);
  }  
  
  public static void main (String args[]){
      new PickUp().setVisible(true);
  }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
          
          try{
             
            String str = "select * from driver where brand = '"+c1.getSelectedItem()+"'";
            conn c = new conn();
            ResultSet rs = c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));
           			
          }catch(Exception ae){
            
        }
    } else if(e.getSource()== b2){
        new Reception().setVisible(true);
          this.setVisible(false);
    }
    }
}
