package app;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ConverterParaYIQ {
    public static double[][][] rgbParaYiq(BufferedImage imagem) {
        double[][][] matriz = new double[imagem.getWidth()][imagem.getHeight()][3];
        for (int w = 0; w < imagem.getWidth(); w++) {
            for (int h = 0; h < imagem.getHeight(); h++) {
                Color cor = new Color(imagem.getRGB(w, h));
                matriz[w][h][0] = (cor.getRed() * 0.299) + (cor.getGreen() * 0.587) + (cor.getBlue() * 0.114); // VALOR DE Y
                matriz[w][h][1] = (cor.getRed() * 0.596) + (cor.getGreen() * -0.274) + (cor.getBlue() * -0.322); // VALOR DE I
                matriz[w][h][2] = (cor.getRed() * 0.211) + (cor.getGreen() * -0.523) + (cor.getBlue() * 0.312); // VALOR DE Q
            }
        }
        return matriz;
    }

    public  static double retornarValorQ(double[][][] matriz, int h, int w){
      return matriz[w][h][2];
    }


    public static BufferedImage yiqParaRgb(double[][][] matriz) {
        int width = matriz.length;  // Obtendo a largura da matriz
        int height = matriz[0].length;  // Obtendo a altura da matriz
        BufferedImage imagem = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int h = 0; h < height; h++) {  // Iterando sobre as linhas (altura)
            for (int w = 0; w < width; w++) {  // Iterando sobre as colunas (largura)
                int red = (int) ((int) (matriz[w][h][0] * 1) + (matriz[w][h][1] * 0.956) + (matriz[w][h][2] * 0.621));
                int green = (int) ((int) (matriz[w][h][0] * 1) + (matriz[w][h][1] * -0.272) + (matriz[w][h][2] * -0.647));
                int blue = (int) ((int) (matriz[w][h][0] * 1) + (matriz[w][h][1] * -1.106) + (matriz[w][h][2] * 1.703));
                red = Math.min(Math.max(red, 0), 255);
                green = Math.min(Math.max(green, 0), 255);
                blue = Math.min(Math.max(blue, 0), 255);
                Color pintar = new Color(red, green, blue);
                imagem.setRGB(w, h, pintar.getRGB());
            }
        }
        return imagem;
    }


}
