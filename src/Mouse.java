import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Мышь");
        frame.setLayout(null);
        frame.setBounds(500,200,816,839);
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);
        panel.setBounds(0,0,frame.getWidth(),frame.getHeight());
        panel.setFocusable(true);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel label = new JLabel();
                panel.add(label);
                label.setBounds(e.getX(), e.getY(), 100, 20);
                label.setText("X: " + e.getX() + " Y: " + e.getY());

                if (label.contains(e.getX(),e.getY())) {
                    panel.remove(label);
                }
            }
        });
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
