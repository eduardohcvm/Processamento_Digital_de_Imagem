package app;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ConverterParaYIQ {
    public static double[][][] rgbParaYiq(BufferedImage imagem){
                double[][][] matriz = new double[imagem.getHeight()][imagem.getWidth()][3];
        for (int h = 0; h < imagem.getHeight(); h++) {
            for (int w = 0; w < imagem.getWidth(); w++) {
                Color cor = new Color(imagem.getRGB(h,w));
                matriz[w][h][0] = (cor.getRed() * 0.299) + (cor.getGreen() * 0.587 + (cor.getBlue() * 0.114)); // VALOR DE Y
                matriz[w][h][1] = (cor.getRed() * 0.596) + (cor.getGreen() * -0.274 + (cor.getBlue() * -0.322)); // VALOR DE I
                matriz[w][h][2] = (cor.getRed() * 0.211) + (cor.getGreen() * -0.523 + (cor.getBlue() * 0.312)); // VALOR DE Q

            }
        }

        return matriz;

    }
    public  static double retornarValorQ(double[][][] matriz, int h, int w){
      return matriz[h][w][2];
    }

    /*
    public static BufferedImage yiqParaRgb(double[][][] matriz){
        BufferedImage imagem = new BufferedImage();
        for (int h = 0; h < matriz; h++) {
            for (int w = 0; w < ; ++) {

            }
        }
    }
    */


}
