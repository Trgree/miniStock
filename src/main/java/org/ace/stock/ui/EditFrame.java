package org.ace.stock.ui;

import org.ace.stock.utils.CommonUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class EditFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private MainFrame mainFrame;
	private int index;
	
	private JLabel priceLabel;
	private JLabel countLabel;
	private JLabel tipLabel;
	private JTextField priceField;
	private JTextField countField;
	private JButton commitJBtn;
	private JButton cancelBtn;
	
	
	private static final String PRICE_INIT_STR = "请输入正确的成本价";
	private static final String COUNT_INIT_STR = "请输入正确的数量";
	
	private static  int height = 130;
	private static  int width = 200;
	
	public EditFrame(MainFrame mainFrame, int index) {
		super();
		this.mainFrame = mainFrame;
		this.index = index;
		initialize();
	}
	
	private void initialize() {
		setSize(width,height);
		setResizable(false);
		setLocation();
		setIcon();
		setTitle("修改信息");
		setContentPane(getJContentPane());
		getContentPane().requestFocus();
		
	}
	
	private void close(){
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowCloseAdapter(this)); 
	}
	
	/**
	 * 右下角窗口
	 */
	private void setLocation() {
		setLocation(mainFrame.getLocation());
	}
	
	private void setIcon(){
		URL url = this.getClass().getClassLoader().getResource("edit.png");
		Image image= Toolkit.getDefaultToolkit().createImage(url);
		this.setIconImage(image);
	}
	
	private Container getJContentPane() {
		JPanel jPanel = new JPanel(new FlowLayout());
		if (priceLabel == null) {
			priceLabel = new JLabel("成本价：");
		}
		if (priceField == null) {
			priceField = new JTextField(9);
		}
		
		if (countLabel == null) {
			countLabel = new JLabel("数量：");
		}
		 
		if (countField == null) {
			countField = new JTextField(9);
		}
		
		if (tipLabel == null) {
			tipLabel = new JLabel(" ");
			tipLabel.setForeground(Color.red);
		}
		
		
		if (commitJBtn == null) {
			commitJBtn = new JButton("确定");
		}
		commitJBtn.addActionListener(new CommitActionListener(this));
		
		priceField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				priceField.setText("");
				priceField.setForeground(Color.BLACK);
				
			}
		});
		
		countField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				countField.setText("");
				countField.setForeground(Color.BLACK);
				
			}
		});
		
		jPanel.add(priceLabel);
		jPanel.add(priceField);
		jPanel.add(countLabel);
		jPanel.add(countField);
		jPanel.add(tipLabel);
		jPanel.add(commitJBtn);
		jPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
		return jPanel;
	}
	
	
	class CommitActionListener implements ActionListener {
		
		EditFrame editFrame;
		
		public CommitActionListener(EditFrame editFrame){
			this.editFrame = editFrame;
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			float price = CommonUtil.str2float(priceField.getText(),-1);
			if(price < 0) {
				priceField.setText(PRICE_INIT_STR);
				priceField.setFont(new java.awt.Font(priceField.getFont().getFontName(),priceField.getFont().getStyle(),11));
				priceField.setForeground(Color.RED);
				return;
			}
			int count = CommonUtil.str2int(countField.getText(), -1);
			if(count < 0) {
				countField.setText(COUNT_INIT_STR);
				countField.setFont(new java.awt.Font(priceField.getFont().getFontName(),priceField.getFont().getStyle(),11));
				countField.setForeground(Color.RED);
				return ;
			} 
			mainFrame.editStockMyPrice(index, price, count);
			editFrame.dispose();
		}
	}
	
	
	class WindowCloseAdapter extends WindowAdapter {
		EditFrame editFrame;
		
		public WindowCloseAdapter(EditFrame editFrame){
			this.editFrame = editFrame;
			
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			editFrame.dispose();
		}
	}
}


