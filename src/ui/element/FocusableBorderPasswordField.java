package ui.element;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FocusableBorderPasswordField extends JPasswordField {
    JPasswordField jPasswordField = new JPasswordField();
    Border border = jPasswordField.getBorder();

    private Border defaultBorder = jPasswordField.getBorder();;
    private Border focusBorder;

    public FocusableBorderPasswordField(int columns) {
        super(columns);

        // 初始化默认边框和聚焦时的边框
        focusBorder = createBorder(Color.BLUE);

        // 设置默认边框
        this.setBorder(defaultBorder);

        // 添加焦点监听器
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // 当聚焦时，设置为蓝色边框
                setBorder(focusBorder);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // 当失去焦点时，恢复为默认边框
                setBorder(defaultBorder);
            }
        });
    }

    // 创建带有颜色和内边距的边框
    private Border createBorder(Color color) {
        Border line = BorderFactory.createLineBorder(color, 2);
        Border margin = BorderFactory.createEmptyBorder(5, 10, 5, 10);
        return BorderFactory.createCompoundBorder(line, margin);
    }
}
