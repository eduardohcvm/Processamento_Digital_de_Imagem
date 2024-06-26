package app;
import app.ManipularImagem;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class Main {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\eduar\\OneDrive\\Desktop\\bolsa.jpg");
        BufferedImage imagem = null;
         int [] kernelHorizontal = {-1,-2,-1,0,0,0,1,2,1};
        int [] kernelVertical = {-1,0,1,-2,0,2,-1,0,-1};
        int[] kernelLinhasOeste = { 1,1,-1,1,-2,-1,1,1,1};
        int [] Laplaciano = {0,-1,0,-1,4,-1,0,-1,0};
        
        try {imagem = ImageIO.read(file);}
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        app.OperacaoPontual.buscarDados(imagem);

//        ManipularImagem.mudarRGB(imagem, imagem.getHeight(), imagem.getWidth());
//        ManipularImagem.filtroNegativo(imagem, imagem.getHeight(), imagem.getWidth());
//        ManipularImagem.filtroCinza(imagem, imagem.getHeight(), imagem.getWidth(), "green");
//        ManipularImagem.Binarizacao(imagem, imagem.getHeight(), imagem.getWidth(),200);
//        ManipularImagem.Tonalizacao(imagem, imagem.getHeight(), imagem.getWidth(),"blue",200);
//        ManipularImagem.brilhoADD(imagem, imagem.getHeight(), imagem.getWidth(),100);
//        ManipularImagem.brilhoMulti(imagem, imagem.getHeight(), imagem.getWidth(),0.5f);
//
//        conversaoYIQ(imagem);
//        conversaoYIQADD(imagem, 75.89);
//        conversaoYIQMULTI(imagem, 1.5);
          OperacoesLocais.medianaMatriz3x3(imagem);
          OperacoesLocais.mediaMatriz3x3(imagem);
//        OperacoesLocais.convolucao(imagem, kernelHorizontal);
//        OperacoesLocais.convolucao(imagem, kernelVertical);
//        OperacoesLocais.convolucao(imagem, kernelLinhasOeste);
//        OperacoesLocais.convolucao(imagem, Laplaciano);
//        OperacoesLocais.medianaMatriz3x3(imagem);
          OperacoesLocais.mediaMatrizDefinida(imagem, 3);
          OperacoesLocais.medianaMatrizDefinida(imagem, 3);
    }

    private static void conversaoYIQ(BufferedImage imagem) {
        double[][][] matriz = new double[imagem.getHeight()][imagem.getWidth()][3];
        matriz = ConverterParaYIQ.rgbParaYiq(imagem);
        System.out.println(ConverterParaYIQ.retornarValorQ(matriz, 200,200));
        BufferedImage image;
        image = ConverterParaYIQ.yiqParaRgb(matriz);
        OperacaoPontual.buscarDados(image);
    }
    private static void conversaoYIQADD(BufferedImage imagem, double tonalidade) {
        double[][][] matriz = new double[imagem.getHeight()][imagem.getWidth()][3];
        matriz = ConverterParaYIQ.rgbParaYiq(imagem);
        ManipularEmYIQ.brilhoADDemYIQ(matriz,tonalidade);
        System.out.println(ConverterParaYIQ.retornarValorQ(matriz, 200,200));
        BufferedImage image;
        image = ConverterParaYIQ.yiqParaRgb(matriz);
        OperacaoPontual.buscarDados(image);
    }
    private static void conversaoYIQMULTI(BufferedImage imagem, double tonalidade) {
        double[][][] matriz = new double[imagem.getHeight()][imagem.getWidth()][3];
        matriz = ConverterParaYIQ.rgbParaYiq(imagem);
        ManipularEmYIQ.brilhoMULTIemYIQ(matriz,tonalidade);
        System.out.println(ConverterParaYIQ.retornarValorQ(matriz, 200,200));
        BufferedImage image;
        image = ConverterParaYIQ.yiqParaRgb(matriz);
        OperacaoPontual.buscarDados(image);
    }

}
