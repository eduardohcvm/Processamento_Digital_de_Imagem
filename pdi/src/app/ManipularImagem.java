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
    public static void filtroCinza(BufferedImage imagem, int altura, int largura, String tipo) {

        // calistenia --> clean code
        // early return
        if (tipo != "red" && tipo != "green" && tipo != "blue" && tipo != "media" ){
            throw new RuntimeException("Tipo invalido");
        }

        BufferedImage imagemSaida = new BufferedImage(largura,altura,imagem.getType());

        for (int i = 0; i < largura; i++){
            for (int j = 0; j < altura; j++){

                Color mudarCor = new Color(imagem.getRGB(i,j));
                int vermelho = mudarCor.getRed();
                int azul = mudarCor.getBlue();
                int verde = mudarCor.getGreen();

                Color novaCor = null;
                if (tipo.equalsIgnoreCase("red"))novaCor = new Color(vermelho,vermelho,vermelho);
                else if (tipo.equalsIgnoreCase("green"))novaCor = new Color(verde,verde,verde);
                else if (tipo.equalsIgnoreCase("blue"))novaCor = new Color(azul,azul,azul);
                else {
                    int media = (vermelho + azul + verde) / 3;
                    novaCor = new Color(media,media,media);
                }

                imagemSaida.setRGB(i,j,novaCor.getRGB());

            }
        }
        OperacaoPontual.display(imagemSaida);
    }
    public static void Binarizacao(BufferedImage imagem, int altura, int largura, int limiar) {

        // calistenia --> clean code
        // early return
        if (limiar < 0 || limiar > 255 ){
            throw new RuntimeException("Tipo invalido");
        }

        BufferedImage imagemSaida = new BufferedImage(largura,altura,imagem.getType());

        for (int i = 0; i < largura; i++){
            for (int j = 0; j < altura; j++){

                Color mudarCor = new Color(imagem.getRGB(i,j));
                int vermelho = mudarCor.getRed();
                int azul = mudarCor.getBlue();
                int verde = mudarCor.getGreen();
                int media = (vermelho + azul + verde) / 3;
                Color novaCor = null;
                if (media > limiar){
                    novaCor = new Color(255,255,255);
                } else if (media < limiar) {
                    novaCor = new Color(0,0,0);
                }else{
                    novaCor = new Color(media,media,media);
                }
                imagemSaida.setRGB(i,j,novaCor.getRGB());

            }
        }
        OperacaoPontual.display(imagemSaida);
    }
    public static void Tonalizacao(BufferedImage imagem, int altura, int largura,String tipo, int tonalidade) {

        // calistenia --> clean code
        // early return
        if (tonalidade < -255 || tonalidade > 255 ){
            throw new RuntimeException("Tipo invalido");
        }
        if (tipo != "red" && tipo != "green" && tipo != "blue" && tipo != "media" ){
            throw new RuntimeException("Tipo invalido");
        }

        BufferedImage imagemSaida = new BufferedImage(largura,altura,imagem.getType());

        for (int i = 0; i < largura; i++){
            for (int j = 0; j < altura; j++){

                Color mudarCor = new Color(imagem.getRGB(i,j));
                int vermelho = mudarCor.getRed();
                int azul = mudarCor.getBlue();
                int verde = mudarCor.getGreen();

                Color novaCor = null;
                if (tipo.equalsIgnoreCase("red")){
                    if (vermelho + tonalidade >= 255){
                        novaCor = new Color(255,verde,azul);
                    } else if (vermelho + tonalidade <= 0) {
                        novaCor = new Color(0,verde,azul);
                    }else {
                        novaCor = new Color(vermelho + tonalidade,verde,azul);
                    }
                }else if (tipo.equalsIgnoreCase("green")){
                    if (verde + tonalidade >= 255){
                        novaCor = new Color(vermelho,255,azul);
                    } else if (verde + tonalidade <= 0) {
                        novaCor = new Color(vermelho,0,azul);
                    }else {
                        novaCor = new Color(vermelho,verde + tonalidade,azul);
                    }
                }
                else if (tipo.equalsIgnoreCase("blue")){
                   if (azul + tonalidade >= 255){
                       novaCor = new Color(vermelho,verde, 255);
                   } else if (azul + tonalidade <= 0) {
                       novaCor = new Color(vermelho,verde,0);
                   }else {
                       novaCor = new Color(vermelho,verde,azul + tonalidade);
                   }
                }

                imagemSaida.setRGB(i,j,novaCor.getRGB());

            }
        }
        OperacaoPontual.display(imagemSaida);
    }
    public static void brilhoADD(BufferedImage imagem, int altura, int largura, int tonalidade) {

        // calistenia --> clean code
        // early return
        if (tonalidade < -255 || tonalidade > 255 ){
            throw new RuntimeException("Tipo invalido");
        }

        BufferedImage imagemSaida = new BufferedImage(largura,altura,imagem.getType());

        for (int i = 0; i < largura; i++){
            for (int j = 0; j < altura; j++){

                Color mudarCor = new Color(imagem.getRGB(i,j));
                int vermelho = mudarCor.getRed();
                int azul = mudarCor.getBlue();
                int verde = mudarCor.getGreen();

                Color novaCor = null;
                if (vermelho + tonalidade > 255){
                    vermelho = 255;
                }else if (vermelho + tonalidade < 0){
                    vermelho = 0;
                }else {
                    vermelho += tonalidade;
                }
                if (verde + tonalidade > 255){
                    verde = 255;
                }else if (verde + tonalidade < 0){
                    verde = 0;
                }else {
                    verde += tonalidade;
                }
                if (azul + tonalidade > 255){
                    azul = 255;
                }else if (azul + tonalidade < 0){
                    azul = 0;
                }else {
                    azul += tonalidade;
                }
                novaCor = new Color(vermelho,verde,azul);
                imagemSaida.setRGB(i,j,novaCor.getRGB());

            }
        }
        OperacaoPontual.display(imagemSaida);
    }
    public static void brilhoMulti(BufferedImage imagem, int altura, int largura, float tonalidade) {

        // calistenia --> clean code
        // early return
        if (tonalidade < -255 || tonalidade > 255 ){
            throw new RuntimeException("Tipo invalido");
        }

        BufferedImage imagemSaida = new BufferedImage(largura,altura,imagem.getType());

        for (int i = 0; i < largura; i++){
            for (int j = 0; j < altura; j++){

                Color mudarCor = new Color(imagem.getRGB(i,j));
                int vermelho = mudarCor.getRed();
                int azul = mudarCor.getBlue();
                int verde = mudarCor.getGreen();

                Color novaCor = null;
                if (vermelho * tonalidade > 255){
                    vermelho = 255;
                }else if (vermelho * tonalidade < 0){
                    vermelho = 0;
                }else {
                    vermelho *= tonalidade;
                }
                if (verde  > 255){
                    verde = 255;
                }else if (verde * tonalidade < 0){
                    verde = 0;
                }else {
                    verde *= tonalidade;
                }
                if (azul * tonalidade > 255){
                    azul = 255;
                }else if (azul * tonalidade < 0){
                    azul = 0;
                }else {
                    azul *= tonalidade;
                }
                novaCor = new Color(vermelho,verde,azul);
                imagemSaida.setRGB(i,j,novaCor.getRGB());

            }
        }
        OperacaoPontual.display(imagemSaida);
    }


}
