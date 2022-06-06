import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    static int x = 0;
    static int y = 0;
    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame("Хитрое управление стрелками");
        frame.setLayout(null);
        frame.setBounds(500,200,816,839);
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel(null);
        panel.setBounds(0,0,frame.getWidth(),frame.getHeight());
        panel.setFocusable(true);

        BufferedImage image = ImageIO.read(new File("smile.jpg"));
        JLabel label = new JLabel(new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_FAST)));
        label.setBounds(x,y,50,50);
        panel.add(label);
            panel.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_LEFT:  // left
                            if (x >= 50) x -= 50;
                            else if (x == 0) x = 750;
                            break;
                        case KeyEvent.VK_UP:  // up
                            if (y >= 50) y -= 50;
                            else if (y == 0) y = 750;
                            break;
                        case KeyEvent.VK_RIGHT:
                            if (x <= 700) x += 50;
                            else if (x == 750) x = 0;
                            break;
                        case KeyEvent.VK_DOWN:  // down
                            if (y <= 700) y += 50;
                            else if (y == 750) y = 0;
                            break;
                    }
                    label.setBounds(x,y,50,50);
                }

            });
            frame.getContentPane().add(panel);
            frame.setVisible(true);
    }
}
