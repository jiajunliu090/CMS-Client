package ui.user;

import view.element.FocusButton;

import javax.swing.*;
import java.awt.*;

public class WriteCommentJFrame extends JFrame {
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label1;
    private FocusButton button1;
    public WriteCommentJFrame() {
        initComponents();
    }

    private void initComponents() {
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label1 = new JLabel();
        button1 = new FocusButton();

        //======== this ========
        setTitle("\u4f1a\u8bae");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(Color.darkGray);
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
                    . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  " " , javax. swing
                    .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
                    Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
            ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
        public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e. getPropertyName (
        ) ) )throw new RuntimeException( ) ;} } );
            panel1.setLayout(null);

            //======== scrollPane1 ========
            {

                //---- textArea1 ----
                textArea1.setBackground(Color.darkGray);
                textArea1.setForeground(Color.lightGray);
                scrollPane1.setViewportView(textArea1);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(45, 75, 370, 140);

            //---- label1 ----
            label1.setText("\u5bf9\u6b64\u6b21\u4f1a\u8bae\u7684\u8bc4\u4ef7/\u5efa\u8bae/\u8bc4\u8bba\uff1a");
            label1.setForeground(Color.lightGray);
            panel1.add(label1);
            label1.setBounds(45, 10, 185, 40);

            //---- button1 ----
            button1.setText("\u63d0\u4ea4");
            button1.setBackground(Color.black);
            button1.setForeground(Color.lightGray);
            panel1.add(button1);
            button1.setBounds(185, 235, 90, 35);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 465, 285);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
}
