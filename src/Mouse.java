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
                if (e.getButton() == 1) {
                    panel.add(label);
                    label.setBounds(e.getX(), e.getY(), 100, 20);
                    label.setText("X: " + e.getX() + " Y: " + e.getY());
                }
                label.addMouseListener(new MouseAdapter() {
                    boolean drag = false;
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getButton() == 2) {
                                panel.remove(label);
                                panel.repaint();
                        }
                    }
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (e.getButton() == 3) {
                            label.setCursor(new Cursor(Cursor.MOVE_CURSOR));
                        }
                    }
                });
                label.addMouseMotionListener(new MouseAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        while (e.getButton() == 3) {
                            label.setBounds(e.getX(),e.getY(),100,20);
                            label.repaint();
                            panel.repaint();

                        }
                    }
                });
            }
        });
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
