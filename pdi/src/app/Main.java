package app;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class Main {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\autologon\\Desktop\\imagem.jpg");
        BufferedImage imagem = null;

        try {imagem = ImageIO.read(file);}
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        OperacaoPontual.buscarDados(imagem);
        ManipularImagem.mudarRGB(imagem, imagem.getHeight(), imagem.getWidth());
        ManipularImagem.filtroNegativo(imagem, imagem.getHeight(), imagem.getWidth());
        ManipularImagem.filtroCinza(imagem, imagem.getHeight(), imagem.getWidth(), "blue");
        ManipularImagem.Binarizacao(imagem, imagem.getHeight(), imagem.getWidth(),200);
        ManipularImagem.Tonalizacao(imagem, imagem.getHeight(), imagem.getWidth(),"green",100);
        ManipularImagem.brilhoADD(imagem, imagem.getHeight(), imagem.getWidth(),-100);
        ManipularImagem.brilhoMulti(imagem, imagem.getHeight(), imagem.getWidth(),1.7f);
    }

}