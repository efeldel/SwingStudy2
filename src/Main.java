import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static int x = 0;
    static int y = 0;
    public static void main(String[] args) throws IOException {
        FileWriter fw =  new FileWriter("output.txt");

        JFrame frame = new JFrame("Записная книжка");
        frame.setLayout(null);
        frame.setBounds(500,200,816,839);
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel(null);
        panel.setBounds(0,0,frame.getWidth(),frame.getHeight());
        panel.setFocusable(true);

        JLabel label = new JLabel();
        label.setFont(new Font("Calibri", Font.PLAIN, 20));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(x,y,50,50);
        panel.add(label);
            panel.addKeyListener (new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {

                    label.setText(e.getKeyText(e.getKeyCode()));
                    try {
                        fw.append(e.getKeyText(e.getKeyCode()));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        fw.flush();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            frame.getContentPane().add(panel);
            frame.setVisible(true);
    }
}
