
package hotelmanagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class UpdateRoom extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5;
    JComboBox c;
    Choice c1;
    JTextField t1,t2,t3;
    JButton b1 , b2 ,b3;
    
    
    UpdateRoom(){
        l1 = new JLabel("Update Room Status");
        l1.setBounds(85, 11, 206, 34);
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l1);
        
        l2 = new JLabel("Guest ID:");
	l2.setBounds(27, 87, 90, 14);
        add(l2);
        
        c1 = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                     c1.add(rs.getString("number"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(160, 84, 140, 20);
		add(c1);
                
        l3 = new JLabel("Room NO:");
	l3.setBounds(27, 133, 100, 14);
        add(l3);
        
        l4 = new JLabel("Availability:");
	l4.setBounds(27, 187, 90, 14);
        add(l4);
		
        l5 = new JLabel("Clean Status:");
	l5.setBounds(27, 240, 90, 14);
        add(l5);
        
        t1 = new JTextField();
	t1.setBounds(160, 184, 140, 20);
        add(t1);
	t1.setColumns(10);
		
	t2 = new JTextField();
	t2.setBounds(160, 237, 140, 20);
	add(t2);
	t2.setColumns(10);
                
        t3 = new JTextField();
	t3.setBounds(160, 130, 140, 20);
	add(t3);
	t3.setColumns(10);
        
        b1=new JButton("Check"); 
        b1.setBounds(120, 315, 89, 23);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        
        b2=new JButton("Update"); 
        b2.setBounds(60, 355, 89, 23);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        
        b3=new JButton("Back"); 
        b3.setBounds(180, 355, 89, 23);
        b3.addActionListener(this);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        add(b3);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Hotelmanagement/icon/seventh.jpg"));
         Image i3 = i1.getImage().getScaledInstance(550, 250,Image.SCALE_DEFAULT);
         ImageIcon i2 = new ImageIcon(i3);
         JLabel l11 = new JLabel(i2);
         l11.setBounds(400,80,600,250);
         add(l11);
        
       getContentPane().setBackground(Color.WHITE);
                 
        setLayout(null);
        setBounds(260,180,1000,500);
        setVisible(true);
    }
    public static void main(String args[]){
        new UpdateRoom().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== b1){
            
               
          try{
            String s1 = c1.getSelectedItem();
            conn c = new conn();
            ResultSet rs1 = c.s.executeQuery("select * from customer where number = "+s1);
                                
            while(rs1.next()){
                t1.setText(rs1.getString("room"));    
                                }
                 }catch(Exception ee){}
            try{
                conn c  = new conn();
                ResultSet rs2 = c.s.executeQuery("select * from room where room_number = "+t1.getText());
                while(rs2.next()){
                         t2.setText(rs2.getString("availability")); 
                                    t3.setText(rs2.getString("clean_status"));
                                }
                            }catch(Exception ee){}
                        }               
    else if(e.getSource()== b2){
          try{
            conn c = new conn();
            String room=t1.getText();
            String available=t2.getText();
            String status =t3.getText();
            
            String str = "update room set available = '"+available+"', status = "+status +"where room ='"+room+"'";
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null, "Update Sucessful");
            new Reception().setVisible(true);
            setVisible(false);                     
	}catch (Exception ee){
	ee.printStackTrace();
        }
    }   else if(e.getSource()== b3){
          new Reception().setVisible(true);
          this.setVisible(false);
    }
}}
