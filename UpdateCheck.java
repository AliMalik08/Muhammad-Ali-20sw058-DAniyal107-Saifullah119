
package hotelmanagement;

import com.mysql.cj.protocol.Resultset;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class UpdateCheck extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5;
    JButton b1 ,b2 ,b3;
    Choice c1;
    UpdateCheck(){
        JLabel l1 = new JLabel("Check-In Details");
	l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l1.setForeground(Color.blue);
        l1.setBounds(124, 11, 222, 25);
        add(l1);
        
        JLabel l2 = new JLabel("ID:");
	l2.setBounds(25, 88, 46, 14);
	add(l2);
        
        c1 = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                        c1.add(rs.getString("number"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(248, 85, 140, 20);
		add(c1);
                
        JLabel l3 = new JLabel("Room Number :");
	l3.setBounds(25, 129, 107, 14);
	add(l3);
                
                
        t1 = new JTextField();
        t1.setBounds(248, 126, 140, 20);
        add(t1);
		
	JLabel l4 = new JLabel("Name : ");
	l4.setBounds(25, 174, 97, 14);
	add(l4);
		
	JLabel l5 = new JLabel("Checked-in :");
        l5.setBounds(25, 216, 107, 14);
	add(l5);
		
	JLabel l6 = new JLabel("Amount Paid (Rs) : ");
	l6.setBounds(25, 261, 107, 14);
	add(l6);
		
	JLabel l7 = new JLabel("Pending Amount (Rs) : ");
	l7.setBounds(25, 302, 150, 14);
	add(l7);

		
	t2 = new JTextField();
	t2.setBounds(248, 171, 140, 20);
        add(t2);
	t2.setColumns(10);
		
	t3 = new JTextField();
	t3.setBounds(248, 216, 140, 20);
	add(t3);
	t3.setColumns(10);
		
	t4 = new JTextField();
        t4.setBounds(248, 258, 140, 20);
	add(t4);
        t4.setColumns(10);
		
	t5 = new JTextField();
	t5.setBounds(248, 299, 140, 20);
	add(t5);
	t5.setColumns(10);
        b1 = new JButton("Check");
        b1.setBounds(56, 378, 89, 23);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	add(b1);
        
        b2 = new JButton("Update");
        b2.setBounds(168, 378, 89, 23);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	add(b2);
        
        b3 = new JButton("Back");
        b3.setBounds(281, 378, 89, 23);
        b3.addActionListener(this);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
	add(b3);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Hotelmanagement/icon/nine.jpg"));
        JLabel l11 = new JLabel(i1);
        l11.setBounds(450,70,476,270);
        add(l11);
                
        setLayout(null);
        setBounds(500,200,1000,500);
        setVisible(true);

         
    }
    public static void main(String args[]){
        new UpdateCheck().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
          try{
             conn c = new conn();
             String room=null;    
             String deposit=null; 
             String price=null;    
             int amountpaid;
             String id = c1.getSelectedItem();
             String str ="select * from customer where number = '"+id+"'";
             ResultSet rs =c.s.executeQuery(str);
             while(rs.next()){
                   t1.setText(rs.getString("room"));    
                   t2.setText(rs.getString("name"));    
                   t3.setText(rs.getString("status"));    
                   t4.setText(rs.getString("deposit"));    
                   room=rs.getString("room");
                   deposit=rs.getString("deposit");
             }
            ResultSet rs2 = c.s.executeQuery("select * from room where room_number = "+room);
             while(rs2.next()){
                price = rs2.getString("price");
                amountpaid = Integer.parseInt(price)-Integer.parseInt(deposit);
                t5.setText(Integer.toString(amountpaid));
                                }
          }catch(Exception e){
            
        }
    } else if(ae.getSource()== b2){
    
    }      
    else if(ae.getSource()== b3){
          new Reception().setVisible(true);
          this.setVisible(false);
      }
    }
}
