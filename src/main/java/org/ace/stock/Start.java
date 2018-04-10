package org.ace.stock;

import org.ace.stock.common.Constant;
import org.ace.stock.ui.MainFrame;

public class Start {

	public static void main(String[] args) throws InterruptedException {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
		
		while(true) {
			Thread.sleep(Constant.REFALSH_TIME_MS);
			frame.upateData();
		}
	}
}

