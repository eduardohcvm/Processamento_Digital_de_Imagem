package app;

import java.awt.*;
import java.awt.image.BufferedImage;



public class ManipularEmYIQ {
    public static void brilhoADDemYIQ(double[][][] matriz, double tonalidade) {
        if (tonalidade < -255 || tonalidade > 255 ){
            throw new RuntimeException("Tipo invalido");
        }

        int width = matriz.length;  // Obtendo a largura da matriz
        int height = matriz[0].length;  // Obtendo a altura da matriz
        BufferedImage imagem = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);


        for (int w = 0; w < width; w++){
            for (int h = 0; h < height; h++){
                matriz[w][h][0] = matriz[w][h][0] + tonalidade;
                matriz[w][h][1] = matriz[w][h][1] + tonalidade;
                matriz[w][h][2] = matriz[w][h][2] + tonalidade;
            }
        }

    }
    public static void brilhoMULTIemYIQ(double[][][] matriz, double tonalidade) {
        if (tonalidade < -255 || tonalidade > 255 ){
            throw new RuntimeException("Tipo invalido");
        }

        int width = matriz.length;  // Obtendo a largura da matriz
        int height = matriz[0].length;  // Obtendo a altura da matriz
        BufferedImage imagem = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);


        for (int w = 0; w < width; w++){
            for (int h = 0; h < height; h++){
                matriz[w][h][0] = matriz[w][h][0] * tonalidade;
                matriz[w][h][1] = matriz[w][h][1] * tonalidade;
                matriz[w][h][2] = matriz[w][h][2] * tonalidade;
            }
        }

    }

}
