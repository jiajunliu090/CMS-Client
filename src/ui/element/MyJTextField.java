package ui.element;

import javax.swing.*;
import java.awt.*;
import java.text.AttributedCharacterIterator;
import java.util.Map;

import java.awt.Font;
import java.util.Map;

public class MyJTextField extends JTextField {

    // Source Code Pro 字体名称
    private static final String SOURCE_CODE_PRO_FONT_NAME = "Source Code Pro";

    public MyJTextField() {
        setFont(new Font(SOURCE_CODE_PRO_FONT_NAME, Font.PLAIN, 14)); // 设置字体为 Source Code Pro，普通样式，大小为 12
    }
}