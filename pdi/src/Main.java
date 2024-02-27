import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\autologon\\Desktop\\defante.jpg");

        try {
            BufferedImage imagem = ImageIO.read(file);
            int largura = imagem.getWidth();
            int altura = imagem.getHeight();
            System.out.println("Altura: " + altura);
            System.out.println("Largura " + largura);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}