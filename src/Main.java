import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Текстура");
        frame.setLayout(null);
        frame.setBounds(500,200,800,800);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        BufferedImage image = ImageIO.read(new File("grass.jpg"));
        for (int i = 0; i < frame.getWidth()/50; i++) {
            for (int j = 0; j < frame.getHeight()/50; j++) {
                JLabel label = new JLabel(new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_FAST)));
                frame.add(label);
                label.setBounds(i*50,j*50,50,50);
            }
        }
        frame.setVisible(true);
    }
}
