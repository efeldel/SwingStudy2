import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int x = 0;
        int y = 0;
        JFrame frame = new JFrame("Управление стрелками");
        frame.setLayout(null);
        frame.setBounds(500,200,800,800);
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel(null);
        panel.setBounds(0,0,frame.getWidth(),frame.getHeight());
        panel.setFocusable(true);

        BufferedImage image = ImageIO.read(new File("smile.jpg"));
        JLabel label = new JLabel(new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_FAST)));
        label.setBounds(x,y,50,50);
        panel.add(label);
     //  while (true) {
            panel.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_LEFT:  // left
                            label.setBounds(x - 50, y, 50, 50);
                            break;
                        case KeyEvent.VK_UP:  // up
                            label.setBounds(x, y - 50, 50, 50);
                            break;
                        case KeyEvent.VK_RIGHT:
                            label.setBounds(x + 50, y, 50, 50);
                            break;
                        case KeyEvent.VK_DOWN:  // down
                            label.setBounds(x, y + 50, 50, 50);
                            break;
                    }
                }

            });
            frame.getContentPane().add(panel);
            frame.setVisible(true);
   //     }
    }
}
