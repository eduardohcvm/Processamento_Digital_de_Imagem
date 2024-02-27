import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\eduar\\OneDrive\\Desktop\\pikachu.jpg");

        BufferedImage imagem = null;

        try {imagem = ImageIO.read(file);}
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (imagem != null){


            int largura = imagem.getWidth();
            int altura = imagem.getHeight();
            System.out.println("Largura " + largura);
            System.out.println("Altura: " + altura);
            int pegarRPG = imagem.getRGB(largura/2,altura/2);
            System.out.println("pixel central cor: " + pegarRPG);
            display(imagem);
        }

    }
    public static void display(BufferedImage imagem){
        System.out.println(" imagem no display");
        JFrame frame = new JFrame();
        JLabel label = new JLabel();
        frame.setSize(imagem.getWidth(),imagem.getHeight());
        label.setIcon(new ImageIcon(imagem));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.getDefaultCloseOperation();
        frame.pack();
        frame.setVisible(true);
    }
}