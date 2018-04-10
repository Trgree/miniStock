package org.ace.stock.pojo;

import javax.swing.*;

public class MyButton extends JButton {
	private int row;
	private int column;
	
	public MyButton() {
		super();
	}
	public MyButton(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
	
}
