
package hotelmanagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener{
JMenuBar mb;
JMenu m1 , m2;
JMenuItem i1 , i2 , i3 , i4;

Dashboard(){
    mb = new JMenuBar();
    add(mb);
    
    m1 = new JMenu("HOTEL MANANGEMENT");
    mb.add(m1);
    
    m2 = new JMenu("ADMIN");
    mb.add(m2);
    
    i1 = new JMenuItem("RECEPTION");
    i1.addActionListener(this);
    m1.add(i1);
   
    i2 = new JMenuItem("ADD EMPLOYEE");
    i2.addActionListener(this);
    m2.add(i2);
    
    i3 = new JMenuItem("ADD ROOM");
    i3.addActionListener(this);
    m2.add(i3);
    
    i4 = new JMenuItem("ADD DRIVERS");
    i4.addActionListener(this);
    m2.add(i4);
    
    mb.setBounds(0, 0, 1950, 30);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotelmanagement/icon/third.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2); 
    JLabel NewLabel = new JLabel(i3);
    NewLabel.setBounds(0, 0, 1950, 1000); 
    add(NewLabel);
    
    JLabel AirlineManagementSystem = new JLabel("THE MALIK GROUP OF COMPANY WELCOMES YOU");
    AirlineManagementSystem.setForeground(Color.WHITE);
    AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 30));
    AirlineManagementSystem.setBounds(400, 80, 1000, 85);
    NewLabel.add(AirlineManagementSystem);
		
    
    setLayout(null);
    setBounds(0,0,1950,1020);
    setVisible(true);
    
}
public static void main(String args[]){
    new Dashboard().setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getActionCommand().equals("RECEPTION")){
        new Reception().setVisible(true);
    }else if(e.getActionCommand().equals("ADD EMPLOYEE")){
        new AddEmployee().setVisible(true);
    }else if(e.getActionCommand().equals("ADD ROOM")){
        new AddRoom().setVisible(true);
    }else if(e.getActionCommand().equals("ADD DRIVERS")){
        new AddDriver().setVisible(true);
    }     
    }
}

    
    