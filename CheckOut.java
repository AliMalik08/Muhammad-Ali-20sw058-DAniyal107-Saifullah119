
package hotelmanagement;

import java.awt.Choice;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class CheckOut extends JFrame implements ActionListener{
    Choice c1;
    JButton b1,b2,b3;
    JTextField t1;
    CheckOut(){
        
        JLabel l1 = new JLabel("Check Out ");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	l1.setBounds(70, 11, 140, 35);
	add(l1);
		
	JLabel l2 = new JLabel(" ID Number :");
        l2.setBounds(20, 85, 80, 14);
	add(l2);
                
           c1 = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                        c1.add(rs.getString("number"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(130, 82, 150, 20);
		add(c1);
                
        JLabel l3 = new JLabel("Room Number:");
	l3.setBounds(20, 132, 86, 20);
	add(l3);
		
         t1 = new JTextField();
         t1.setBounds(130, 132, 150, 20);
         add(t1);
        
         b1 = new JButton("Check Out");
        b1.addActionListener(this);
        b1.setBounds(50, 200, 100, 25);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	add(b1);
		
	 b2 = new JButton("Back");
        b2.setBounds(160, 200, 100, 25);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	add(b2);
         
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Hotelmanagement/icon/tick.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JButton l5 = new JButton(i6);
        l5.setBounds(290,82,20,20);
        add(l5);
               
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Hotelmanagement/icon/sixth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l11 = new JLabel(i2);
        l11.setBounds(300,20,500,225);
        add(l11);
                
         getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(500,200,800,300);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
      if(ae.getSource()==b1){
          String id = c1.getSelectedItem();
          String room = t1.getText();
          String str ="select * from customer where number = '"+id+"'";
          String str2 ="update from set available = 'Avaliable' where room = '"+room+"'";
          conn c = new conn();
          try{
             
            c.s.executeQuery(str);
            c.s.executeQuery(str2);
            JOptionPane.showMessageDialog(null,"CheckOut done");
            new Reception().setVisible(true);
          this.setVisible(false);
        
          }catch(Exception e){
            
        }
    } else if(ae.getSource()== b2){
        new Reception().setVisible(true);
          this.setVisible(false);
    }      
    else if(ae.getSource()== b3){
        conn c = new conn();
        String id = c1.getSelectedItem();
        try{
             
          ResultSet rs=c.s.executeQuery("select * from customer where number = '"+id+"'");
          t1.setText(rs.getString("room"));
        
          }catch(Exception e){
            
        }
      }}
    public static void main(String args[]){
        new CheckOut().setVisible(true);
    }

    
    
}
