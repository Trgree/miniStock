package org.ace.stock.ui;

import javax.swing.*;
import java.awt.*;

public class ImgButton extends JButton {

private static final long serialVersionUID = 1218571878182523580L;
    
    public ImgButton(String imgResource){
        // 设置按钮的大小与图片大小一致
        Dimension d = new Dimension(1, 1);
        this.setSize(d);
        this.setMaximumSize(d);
        this.setMinimumSize(d);
        
        setIcon(new ImageIcon(this.getClass().getClassLoader().getResource(imgResource)));

        // 设置鼠标放置在按钮上时的背景图像
//        ImageIcon icon2=new ImageIcon(this.getClass().getClassLoader().getResource("delete2.png"));
//        setRolloverIcon(icon2);
        
        // 设置文字相对于按钮图像的位置，水平居中，垂直居中
        this.setHorizontalTextPosition(CENTER);
        this.setVerticalTextPosition(CENTER);

        // 不绘制边框
        setBorderPainted(false);

        // 不绘制焦点
        setFocusPainted(false);

        // 不绘制内容区
        setContentAreaFilled(false);

        // 设置焦点控制
        setFocusable(true);

        // 设置按钮边框与边框内容之间的像素数
        setMargin(new Insets(0, 0, 0, 0));

        // 设置文字
//        setText(buttonText);
        
        // 设置文字字体
        Font font=new Font("Arial", Font.BOLD,18);
        setFont(font); 
        
        // 设置前景色（文字颜色）
        setForeground(Color.white);
    }
    
}
