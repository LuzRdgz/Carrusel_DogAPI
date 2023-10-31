import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import static java.lang.Thread.*;


public class carrusel {

    static Thread hilo = null;
    static String[] fileName = new String[18];
    public static JFrame frame = new JFrame();
    public static JPanel contentPane = new JPanel();
    public static JLabel jlbImagen = new JLabel();

    public carrusel() {
        hilo = new Thread(this::run);
        hilo.start();
    }

    public void run(){
        System.out.println("Method run() called");

        while (hilo != null){
            try {
                for (int i = 0; i < 18; i++) {
                    jlbImagen.setIcon(new ImageIcon(fileName[i] + ".jpg"));
                    sleep(15000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {

        fileName[0] = "Japaneseakita";
        fileName[1] = "n02086240_4346";
        fileName[2] = "n02086910_2235";
        fileName[3] = "n02087046_4066";
        fileName[4] = "n02091635_873";
        fileName[5] = "n02091831_1400";
        fileName[6] = "n02093256_4036";
        fileName[7] = "n02093859_827";
        fileName[8] = "n02093991_2698";
        fileName[9] = "n02096177_13306";
        fileName[10] = "n02097047_2470";
        fileName[11] = "n02097298_3780";
        fileName[12] = "n02098105_4174";
        fileName[13] = "n02100877_2832";
        fileName[14] = "n02106166_549";
        fileName[15] = "n02106550_6286";
        fileName[16] = "n02108089_1159";
        fileName[17] = "n02115641_4601";

        frame.setTitle("Carrusel Dogs API");
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setBackground(Color.darkGray);
        contentPane.setLayout(null);
        contentPane.add(jlbImagen);

        jlbImagen.setBounds(90, 0, 700, 700);

        new carrusel();

    }
}
