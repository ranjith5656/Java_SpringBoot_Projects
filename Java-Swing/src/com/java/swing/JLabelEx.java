package com.java.swing;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JLabelEx extends Frame implements ActionListener{  
	
	//Declare the varibles for JTextField, JLabel & JButton
    JTextField tf; 
    JLabel l; 
    JButton b;  
    
    JLabelEx(){  
        tf=new JTextField();  
        tf.setBounds(50,50, 150,20);  
        l=new JLabel();  
        l.setBounds(50,100, 250,20);      
        b=new JButton("Find IP");  
        b.setBounds(50,150,95,30);  
        b.addActionListener(this);    
        add(b);add(tf);add(l);    
        setSize(400,400);  
        setLayout(null);  
        setVisible(true);  
    }  
    /**
     * Action performed to the ActionEvent
     * of find IP address of given host name
     */
    public void actionPerformed(ActionEvent e) {  
        try{  
        String host=tf.getText();  
        String ip=java.net.InetAddress.getByName(host).getHostAddress();  
        l.setText("IP of "+host+" is: "+ip);  
        }catch(Exception ex){
        	System.out.println(ex);
        	}  
    }  
    public static void main(String[] args) {  
        new JLabelEx();  
    } 

}
