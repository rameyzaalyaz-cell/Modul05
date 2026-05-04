import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class FormHelper {

    public static JTextField buatTextField(int cols) {
        JTextField tf = new JTextField(cols);
        tf.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tf.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 210, 230)),
                new EmptyBorder(4, 8, 4, 8)));
        tf.setBackground(Color.WHITE);
        return tf;
    }

    public static JTextArea buatTextArea(int cols, int rows) {
        JTextArea ta = new JTextArea(rows, cols);
        ta.setFont(new Font("SansSerif", Font.PLAIN, 13));
        ta.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 210, 230)),
                new EmptyBorder(4, 8, 4, 8)));
        ta.setBackground(Color.WHITE);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        return ta;
    }

    public static JButton buatTombolSubmit() {
        JButton btn = new JButton("  Submit  ");
        btn.setFont(new Font("SansSerif", Font.BOLD, 13));
        btn.setBackground(new Color(41, 128, 185));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(new EmptyBorder(9, 24, 9, 24));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { btn.setBackground(new Color(21, 96, 145)); }
            public void mouseExited(MouseEvent e)  { btn.setBackground(new Color(41, 128, 185)); }
        });
        return btn;
    }
}
