import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\eduar\\OneDrive\\Desktop\\pikachu.jpg");

        try {
            BufferedImage imagem = ImageIO.read(file);
            int largura = imagem.getWidth();
            int altura = imagem.getHeight();
            System.out.println("Largura " + largura);
            System.out.println("Altura: " + altura);
            int pegarRPG = imagem.getRGB(largura/2,altura/2);
            System.out.println("pixel central cor: " + pegarRPG);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}