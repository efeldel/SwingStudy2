import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Текстура");
        frame.setBounds(500,200,800,800);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        try {
            BufferedImage image = ImageIO.read(new File("grass.jpg"));
        }
        catch (IOException e) {
            System.out.println("File not found");
        }

    }
}
