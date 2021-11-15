package hotelmanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class AddEmployee extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4,t5,t6;
        JComboBox c1;
    AddEmployee(){
        JLabel name = new JLabel("NAME");
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        name.setBounds(60, 30, 150, 27);
        add(name);
        
        t1 = new JTextField();
            t1.setBounds(200, 30, 150, 27);
            add(t1);
			
            JButton Next = new JButton("SAVE");
            Next.setBounds(200, 420, 150, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            Next.addActionListener(this);
            add(Next);
			
            JLabel age = new JLabel("AGE");
            age.setFont(new Font("Tahoma", Font.PLAIN, 17));
            age.setBounds(60, 80, 150, 27);
            add(age);
			
            t2 = new JTextField();
            t2.setBounds(200, 80, 150, 27);
            add(t2);
            
            JLabel gender = new JLabel("GENDER");
            gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
            gender.setBounds(60, 120, 150, 27);
            add(gender);
		
            JRadioButton r1 = new JRadioButton("MALE");
            r1.setBackground(Color.WHITE);
            r1.setBounds(200, 120, 70, 27);
            add(r1);
	
            JRadioButton r2 = new JRadioButton("FEMALE");
            r2.setBackground(Color.WHITE);
            r2.setBounds(280, 120, 70, 27);
            add(r2);
            
            
            JLabel Address = new JLabel("JOB");
            Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Address.setBounds(60, 170, 150, 27);
            add(Address);
			
            String course[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
            c1 = new JComboBox(course);
            c1.setBackground(Color.WHITE);
            c1.setBounds(200,170,150,30);
            add(c1);
            		
            JLabel Nationality = new JLabel("SALARY");
            Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Nationality.setBounds(60, 220, 150, 27);
            add(Nationality);
			
            t3 = new JTextField();
            t3.setBounds(200, 220, 150, 27);
            add(t3);
	
            JLabel phone = new JLabel("PHONE");
            phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
            phone.setBounds(60, 270, 150, 27);
            add(phone);
	
            t4 = new JTextField();
            t4.setBounds(200, 270, 150, 27);
            add(t4);
	
            JLabel cnic = new JLabel("CNIC");
            cnic.setFont(new Font("Tahoma", Font.PLAIN, 17));
            cnic.setBounds(60, 320, 150, 27);
            add(cnic);
			
            t5 = new JTextField();
            t5.setBounds(200, 320, 150, 27);
            add(t5);
	
            
            JLabel email = new JLabel("EMAIL");
            email.setFont(new Font("Tahoma", Font.PLAIN, 17));
            email.setBounds(60, 370, 150, 27);
            add(email);
			
            t6 = new JTextField();
            t6.setBounds(200, 370, 150, 27);
             add(t6);
	
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotelmanagement/icon/tenth.jpg"));
            Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(360,60,440,410);
            add(image);
            
            JLabel Add = new JLabel("ADD EMPLOYEE DETAILS");
            Add.setForeground(Color.BLUE);
            Add.setFont(new Font("Tahoma", Font.PLAIN, 31));
            Add.setBounds(400, 24, 442, 35);
            add(Add);
			
            getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(300,150,820,550);
        setVisible(true);
    }
    @Override
     public void actionPerformed(ActionEvent ae){
         String name = t1.getText();
         String age = t2.getText();
         String salary = t3.getText();
         String phone = t4.getText();
         String cnic = t4.getText();
         String email = t5.getText();
         String gender = null;
                     
        String job = (String)c1.getSelectedItem();

        conn c = new conn();
        String str = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"', '"+phone+"','"+cnic+"', '"+email+"')";
               
         try{
             c.s.executeUpdate(str);
             JOptionPane.showMessageDialog(null,"Employee Added");
             this.setVisible(false);
             }catch(Exception e){
                            
             }
                        
     }
    public static void main(String args[]){
        new AddEmployee().setVisible(true);
    }

}