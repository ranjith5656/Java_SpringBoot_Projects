package com.java.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JFrameEx {

	public static void main(String[] args) {
		
		//It constructs a new frame that is initially invisible.
		JFrame f = new JFrame("Button Example");
		
		//Creates a new TextField
		final JTextField tf = new JTextField();
		tf.setBounds(50, 50, 150, 20);
		
		// It creates a button with the specified text.
		JButton b = new JButton("Click Here");
		b.setBounds(50, 100, 95, 30);
		
		// adds an ActionListener to the button Invokes when action occurs
		b.addActionListener(new ActionListener() {
			
			/**
			 * Invokes when action occurs
			 * @param  e To invokes ActionEvent on a button
			 */
			public void actionPerformed(ActionEvent e) {
				tf.setText("Welcome to java swing.");
			}
		});
		f.add(b);
		f.add(tf);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
	}
}
