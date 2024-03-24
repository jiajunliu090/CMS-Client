package ui.element;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FocusButton extends JButton {
    public FocusButton(String text) {
        super(text);
        // 添加鼠标监听器以监听悬停事件
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // 当鼠标进入按钮区域时设置为手形样式
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor()); // 当鼠标移出按钮区域时恢复默认样式
            }
        });
    }
    public FocusButton() {
        super();
        // 添加鼠标监听器以监听悬停事件
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // 当鼠标进入按钮区域时设置为手形样式
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor()); // 当鼠标移出按钮区域时恢复默认样式
            }
        });
    }
}


