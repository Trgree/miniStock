package org.ace.stock.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MainKeyListener implements KeyEventPostProcessor {

	private JFrame frame;
	
	public MainKeyListener(JFrame frame){
		this.frame = frame;
	}
	
	@Override
	public boolean postProcessKeyEvent(KeyEvent e) {
		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_ALT){
			
			
		/*	frame.setUndecorated(true);
			com.sun.awt.AWTUtilities.setWindowOpacity(frame, 0.9f);*/
//			if(frame.isUndecorated()) {
//				frame.setUndecorated(false);
//			} else {
//			}
			
			 /*if(frame.isVisible()){
				 frame.setVisible(false);
			 } else {
				 frame.setVisible(true);
			 }*/
		 }
		return true;
	}

}
