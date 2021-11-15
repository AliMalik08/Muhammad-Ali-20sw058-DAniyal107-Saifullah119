
package hotelmanagement;

import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    Choice c2;
    JButton b1,b2;
    AddCustomer(){
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Hotelmanagement/icon/fifth.png"));
        Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
         JLabel l11 = new JLabel(i2);
         l11.setBounds(480,10,300,500);
         add(l11);
        
        JLabel l1 = new JLabel("NEW CUSTOMER FORM");
        l1.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        l1.setBounds(118, 11, 260, 53);
	add(l1);  
        
        JLabel l2 = new JLabel("ID :");
	l2.setBounds(35, 76, 200, 14);
        add(l2);
                
        c1 = new JComboBox(new String[] {"Passport", "Cnic No", "Voter Id", "Driving license"});
        c1.setBounds(271, 73, 150, 20);
        add(c1);
                
         JLabel l3 = new JLabel("Number :");
	l3.setBounds(35, 111, 200, 14);
        add(l3);
                
        t1 = new JTextField();
        t1.setBounds(271, 111, 150, 20);
        add(t1);
	t1.setColumns(10);
		
        JLabel l4 = new JLabel("Name :");
	l4.setBounds(35, 151, 200, 14);
        add(l4);
		
	t2 = new JTextField();
        t2.setBounds(271, 151, 150, 20);
	add(t2);
	t2.setColumns(10);

                
	JLabel l5 = new JLabel("Gender :");
        l5.setBounds(35, 191, 200, 14);
	add(l5);
                
         r1 = new JRadioButton("Male");
         r1.setFont(new Font("Raleway", Font.BOLD, 14));
         r1.setBackground(Color.WHITE);
         r1.setBounds(271, 191, 80, 12);
         add(r1);
                
         
         r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 191, 100, 12);
        add(r2);
               
        JLabel l6 = new JLabel("Country :");
	l6.setBounds(35, 231, 200, 14);
        add(l6);
		
        JLabel l7 = new JLabel("Allocated Room Number :");
	l7.setBounds(35, 274, 200, 14);
        add(l7);
       
        c2 = new Choice();
        try{
              conn c = new conn();
              ResultSet rs = c.s.executeQuery("select * from room");
              while(rs.next()){
               c2.add(rs.getString("room_number"));    
                    }
                }catch(Exception e){ }
        c2.setBounds(271, 274, 150, 20);
        add(c2);
                
        JLabel l8 = new JLabel("Checked-In :");
	l8.setBounds(35, 316, 200, 14);
	add(l8);
		
	JLabel l9 = new JLabel("Deposit :");
        l9.setBounds(35, 359, 200, 14);
	add(l9);
		
	t3 = new JTextField();
	t3.setBounds(271, 231, 150, 20);
        add(t3);
	t3.setColumns(10);
		
		
	t5 = new JTextField();
        t5.setBounds(271, 316, 150, 20);
	add(t5);
        t5.setColumns(10);
		
	t6 = new JTextField();
        t6.setBounds(271, 359, 150, 20);
	add(t6);
        t6.setColumns(10);
        
        b1=new JButton("Add");
        b1.setBounds(100, 430, 120, 30);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(260, 430, 120, 30);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        
                
        setLayout(null);
        setBounds(500,200,900,500);
        setVisible(true);
    }
    public static void main(String args[]){
        new AddCustomer().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
        String id = (String)c1.getSelectedItem();
        String number =  t1.getText();
	String name =  t2.getText();
        String gender = null;
        if(r1.isSelected()){ 
          gender = "Male";
        }
        else if(r2.isSelected()){
            gender = "Female";
        }
        String country =  t3.getText();
	String room =  c2.getSelectedItem();
        String status =  t6.getText();
        String deposit =  t6.getText();
        String nmae;
        
        String str = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
        String str2 = "update room set availability = 'Occupied' where room_number = "+room;
         
        try{
                conn c = new conn();
                 c.s.executeUpdate(str2);
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                new Reception().setVisible(true);
                setVisible(false);
            }catch(Exception ae){
                
            }                    
    }else if(e.getSource()==b2)
        new Reception().setVisible(true);
          this.setVisible(false);
    
}}
