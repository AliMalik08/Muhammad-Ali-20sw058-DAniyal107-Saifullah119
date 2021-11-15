
package hotelmanagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class Room extends JFrame implements ActionListener{
    JTable t1;
    JLabel l1,l2,lb1,lb2,lb3,lb4,lb5;
    JButton b1,b2;
    Room(){
        t1=new JTable();
        t1.setBounds(0,40,500,400);
        add(t1);
        
         ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Hotelmanagement/icon/eight.jpg"));
         Image i3 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
         ImageIcon i2 = new ImageIcon(i3);
         JLabel l1 = new JLabel(i2);
         l1.setBounds(500,0,600,600);
         add(l1);
     
        lb1 = new JLabel("Room Number");
	lb1.setBounds(12, 15, 90, 14);
        add(lb1);
        
        lb2 = new JLabel("Availability");
	lb2.setBounds(119, 15, 69, 14);
        add(lb2);
        
        lb3 = new JLabel("Status");
	lb3.setBounds(216, 15, 76, 14);
        add(lb3);
        
        lb4 = new JLabel("Price");
	lb4.setBounds(330, 15, 46, 14);
        add(lb4);
        
        lb4 = new JLabel("Bed type ");
	lb4.setBounds(417, 15, 76, 14);
        add(lb4);
                
         b1 = new JButton("Load Data");
        b1.setBounds(100, 460, 120, 30);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        b2 = new JButton("Back");
        b2.setBounds(250, 460, 120, 30);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        setLayout(null);
        setBounds(400,200,1000,600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==b1){
    try{
         conn c = new conn();			
        String str = "select * from room";
	ResultSet rs = c.s.executeQuery(str);
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
    
    public static void main(String args[]){
        new Room().setVisible(true);
    }
}
