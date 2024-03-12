package app;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ManipularImagem {
    public static void mudarRGB(BufferedImage imagem, int altura, int largura) {
        Color cor1 = new Color(0,0,255); // azul
        Color cor2 = new Color(0,255,0);
        Color cor3 = new Color(255,0,0);

        imagem.setRGB(0,0, cor1.getRGB());
        imagem.setRGB(largura /2, altura /2,cor2.getRGB());
        imagem.setRGB(largura -1, altura -1,cor3.getRGB());
        BufferedImage imagemSaida = new BufferedImage(largura,altura,imagem.getType());

        for (int i = 0; i < largura; i++){
            for (int j = 0; j < altura; j++){

                Color mudarCor = new Color(imagem.getRGB(i,j));
                int vermelho = mudarCor.getRed();
                int azul = mudarCor.getBlue();
                int verde = mudarCor.getGreen();
                Color pintar = new Color(0,verde,0);
                imagemSaida.setRGB(i,j,pintar.getRGB());

                System.out.println(imagemSaida.getRGB(i,j));
            }
        }
        OperacaoPontual.display(imagemSaida);
    }
    public static void filtroNegativo(BufferedImage imagem, int altura, int largura) {

        BufferedImage imagemSaida = new BufferedImage(largura,altura,imagem.getType());

        for (int i = 0; i < largura; i++){
            for (int j = 0; j < altura; j++){

                Color mudarCor = new Color(imagem.getRGB(i,j));
                int vermelho = mudarCor.getRed();
                int azul = mudarCor.getBlue();
                int verde = mudarCor.getGreen();
                Color pintar = new Color(255 - vermelho,255 - verde,255 - azul);
                imagemSaida.setRGB(i,j,pintar.getRGB());

                System.out.println(imagemSaida.getRGB(i,j));

            }
        }
        OperacaoPontual.display(imagemSaida);
    }
    public static void filtroCinza(BufferedImage imagem, int altura, int largura) {

        BufferedImage imagemSaida = new BufferedImage(largura,altura,imagem.getType());

        for (int i = 0; i < largura; i++){
            for (int j = 0; j < altura; j++){

                Color mudarCor = new Color(imagem.getRGB(i,j));
                int vermelho = mudarCor.getRed();
                int azul = mudarCor.getBlue();
                int verde = mudarCor.getGreen();
                int media = (vermelho + azul + verde) / 3;
                Color pintar = new Color(media,media,media);
                imagemSaida.setRGB(i,j,pintar.getRGB());

                System.out.println(imagemSaida.getRGB(i,j));

            }
        }
        OperacaoPontual.display(imagemSaida);
    }


}
