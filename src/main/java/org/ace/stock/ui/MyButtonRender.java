package org.ace.stock.ui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MyButtonRender implements TableCellRenderer
{
    private JPanel panel;

    private JButton delBtn;
    
    private JButton editBtn;

    public MyButtonRender()
    {
		this.initButton();

        this.initPanel();

        // 添加按钮。
        this.panel.add(this.delBtn);
        this.panel.add(this.editBtn);
    }

    private void initButton()
    {
        this.delBtn = new ImgButton("delete.png");
        this.editBtn = new ImgButton("edit.png");

        // 设置按钮的大小及位置。
        this.delBtn.setBounds(3, 0, 16, 15);
        this.editBtn.setBounds(20, 0, 16, 15);
        
        // 在渲染器里边添加按钮的事件是不会触发的
        // this.button.addActionListener(new ActionListener()
        // {
        //
        // public void actionPerformed(ActionEvent e)
        // {
        // // TODO Auto-generated method stub
        // }
        // });

    }

    private void initPanel()
    {
        this.panel = new JPanel();

        // panel使用绝对定位，这样button就不会充满整个单元格。
        this.panel.setLayout(null);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
                                                   int column)
    {
        // 只为按钮赋值即可。也可以作其它操作，如绘背景等。
        this.delBtn.setText(value == null ? "" : String.valueOf(value));

        return this.panel;
    }

}
