package hotelmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Hotelmanagement extends JFrame implements ActionListener {
        Hotelmanagement(){
        setBounds(300,200,1366,565);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotelmanagement/icon/first.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,1366,565);
        add(l1);
        JLabel l2 = new JLabel("HOTEL MANAGEMENT SYSTEM");
        l2.setBounds(20,430,1000,90);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif",Font.PLAIN,70));
        l1.add(l2);
        JButton b1 = new JButton("NEXT");
        b1.setBackground(Color.GRAY);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        b1.setBounds(1100, 450, 150, 50);
        l1.add(b1);
        
        setLayout(null);
        setVisible(true);
        }
        @Override
        public void actionPerformed(ActionEvent ae){
            new Login().setVisible(true);
            this.setVisible(false);
            
        }
    
    public static void main(String[] args) {
        new Hotelmanagement();
    }
    
}
