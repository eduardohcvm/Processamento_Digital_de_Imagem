package app;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// ctrl + alt + s -> import e ativar os dois de java

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\autologon\\Desktop\\defante.jpg");

        try {
            BufferedImage imagem = ImageIO.read(file);
            int largura = imagem.getWidth();
            int altura = imagem.getHeight();
            System.out.println("Largura " + largura);
            System.out.println("Altura: " + altura);
            int pegarRPG = imagem.getRGB(largura/2,altura/2);
            System.out.println("pixel central cor: " + pegarRPG);
            int qntPixel = altura * largura;
            System.out.println("Quantidade de pixels: " + qntPixel);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
