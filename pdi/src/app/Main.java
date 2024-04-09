package app;
import app.app.ManipularImagem;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class Main {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\eduar\\OneDrive\\Desktop\\imagem.jpg");
        BufferedImage imagem = null;

        try {imagem = ImageIO.read(file);}
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        app.OperacaoPontual.buscarDados(imagem);
        ManipularImagem.mudarRGB(imagem, imagem.getHeight(), imagem.getWidth());
        //ManipularImagem.filtroNegativo(imagem, imagem.getHeight(), imagem.getWidth());
       // ManipularImagem.filtroCinza(imagem, imagem.getHeight(), imagem.getWidth(), "red");
       // ManipularImagem.Binarizacao(imagem, imagem.getHeight(), imagem.getWidth(),200);
       // ManipularImagem.Tonalizacao(imagem, imagem.getHeight(), imagem.getWidth(),"blue",200);
       // ManipularImagem.brilhoADD(imagem, imagem.getHeight(), imagem.getWidth(),100);
       // ManipularImagem.brilhoMulti(imagem, imagem.getHeight(), imagem.getWidth(),0.5f);
        double matriz[][][] = new double[imagem.getHeight()][imagem.getWidth()][3];
        System.out.println(matriz);
        matriz = ConverterParaYIQ.rgbParaYiq(imagem);
        System.out.println(matriz[1][2][2]);
    }

}
