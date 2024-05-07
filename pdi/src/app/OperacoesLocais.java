package app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;



public class OperacoesLocais {
    public static BufferedImage mediaMatriz3x3(BufferedImage imagem) {
        BufferedImage imgSaida = new BufferedImage(imagem.getWidth(), imagem.getHeight(), imagem.getType());
        if (imagem != null) {

            for (int h = 0; h < imagem.getHeight(); h++) {
                for (int w = 0; w < imagem.getWidth(); w++) {
                    if (w == 0 || h == 0 || w == imagem.getWidth() - 1 || h == imagem.getHeight() - 1) {
                        int rgb = imagem.getRGB(w, h);
                        imgSaida.setRGB(w, h, rgb);
                        continue;
                    }
                    int[] vizinhanca = new int[9];
                    int count = 0;

                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            Color cor = new Color(imagem.getRGB(w + j, h + i));
                            vizinhanca[count++] = cor.getRed();
                        }
                    }
                    int media = Arrays.stream(vizinhanca).sum() / 9;
                    Color novaCor = new Color(media, media, media);
                    imgSaida.setRGB(w, h, novaCor.getRGB());
                }
            }
        }

        salvarImagem(imgSaida,"jpg","MatrixMediaSaida.png");
        display(imgSaida);
        return imgSaida;
    }

    public static BufferedImage medianaMatriz3x3(BufferedImage imagem) {
        BufferedImage imgSaida = new BufferedImage(imagem.getWidth(), imagem.getHeight(), imagem.getType());
        if (imagem != null) {

            for (int h = 0; h < imagem.getHeight(); h++) {
                for (int w = 0; w < imagem.getWidth(); w++) {
                    if (w == 0 || h == 0 || w == imagem.getWidth() - 1 || h == imagem.getHeight() - 1) {
                        int rgb = imagem.getRGB(w, h);
                        imgSaida.setRGB(w, h, rgb);
                        continue;
                    }
                    int[] vizinhanca = new int[9];
                    int count = 0;
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            Color cor = new Color(imagem.getRGB(w + j, h + i));
                            vizinhanca[count++] = cor.getRed();
                        }
                    }
                    Arrays.sort(vizinhanca);
                    int mediana = vizinhanca[4];
                    Color novaCor = new Color(mediana, mediana, mediana);
                    imgSaida.setRGB(w, h, novaCor.getRGB());
                }

            }
        }
        salvarImagem(imgSaida,"jpg","medianaMatrizSaida.png");
        display(imgSaida);
        return imgSaida;
    }

    /*
    0,0625  0,125   0,0625
    0,125   0,25    0,125
    0,0625  0,125   0,0625

     */
    public static BufferedImage multiplicacaoGaussiana(BufferedImage imagem) {
        BufferedImage imgSaida = new BufferedImage(imagem.getWidth(), imagem.getHeight(), imagem.getType());
        for (int h = 0; h < imagem.getHeight(); h++) {
            for (int w = 0; w < imagem.getWidth(); w++) {
                if (w == 0 || h == 0 || w == imagem.getWidth() - 1 || h == imagem.getHeight() - 1) {
                    int rgb = imagem.getRGB(w, h);
                    imgSaida.setRGB(w, h, rgb);
                    continue;
                }
                int[] vizinhanca = new int[9];
                int count = 0;
                double[][] matrizGau = {
                        {0.0625, 0.125, 0.0625},
                        {0.125, 0.25, 0.125},
                        {0.0625, 0.125, 0.0625}
                };
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        Color cor = new Color(imagem.getRGB(w + j, h + i));
                        vizinhanca[count++] = (int) (cor.getRed() * matrizGau[i + 1][j + 1]);
                    }
                }


                int media = Arrays.stream(vizinhanca).sum();
                Color novaCor = new Color(media, media, media);

                imgSaida.setRGB(w, h, novaCor.getRGB());
            }

        }
        salvarImagem(imgSaida,"jpg","GaussianaSaida.png");
        display(imgSaida);
        return imgSaida;
    }

    public static BufferedImage convolucao(BufferedImage imagem, int[] kernel) {
        BufferedImage imgSaida = new BufferedImage(imagem.getWidth(), imagem.getHeight(), imagem.getType());
        for (int h = 0; h < imagem.getHeight(); h++) {
            for (int w = 0; w < imagem.getWidth(); w++) {
                if (w == 0 || h == 0 || w == imagem.getWidth() - 1 || h == imagem.getHeight() - 1) {
                    int rgb = imagem.getRGB(w, h);
                    imgSaida.setRGB(w, h, rgb);
                    continue;
                }
                int[] vizinhanca = new int[9];
                int count = 0;

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        Color cor = new Color(imagem.getRGB(w + j, h + i));
                        vizinhanca[count++] = (cor.getRed());
                    }
                }
                int resultado = 0;
                for (int a = 0; a < 9; a++) {
                    resultado += vizinhanca[a] * kernel[a];
                }

                if (resultado > 255) resultado = 255;
                else if (resultado < 0) {
                    resultado = 0;
                }

                Color novaCor = new Color(resultado, resultado, resultado);

                imgSaida.setRGB(w, h, novaCor.getRGB());
            }


        }
        salvarImagem(imgSaida,"jpg","convolucaoSaida.png");
        display(imgSaida);
        return imgSaida;
    }

    private static void salvarImagem(BufferedImage imagem, String formato, String nomeImagem) {
        try {
            ImageIO.write(imagem, formato, new File(nomeImagem));
        } catch (IOException e) {
            System.out.println("Erro ao salvar a imagem");
            throw new RuntimeException(e);
        }
    }
    private static void display(BufferedImage imagem){
        System.out.println(" imagem no display");
        JFrame frame = new JFrame();
        JLabel label = new JLabel();
        frame.setTitle("Processamento de Imagens");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(imagem.getWidth(),imagem.getHeight());
        label.setIcon(new ImageIcon(imagem));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static BufferedImage mediaMatrizDefinida(BufferedImage imagem, int tamanhoMatrix) {
        BufferedImage imgSaida = new BufferedImage(imagem.getWidth(), imagem.getHeight(), imagem.getType());
            int aux = tamanhoMatrix / 2;
            for (int h = 0; h < imagem.getHeight(); h++) {
                for (int w = 0; w < imagem.getWidth(); w++) {
                    if (w <= aux || h <= aux || w >= imagem.getWidth() - aux || h >= imagem.getHeight() - aux) {
                        int rgb = imagem.getRGB(w, h);
                        imgSaida.setRGB(w, h, rgb);
                        continue;
                    }
                    int[] vizinhanca = new int[tamanhoMatrix * tamanhoMatrix];
                    int count = 0;

                    for (int i = -aux; i <= aux; i++) {
                        for (int j = -aux; j <= aux; j++) {
                            Color cor = new Color(imagem.getRGB(w + j, h + i));
                            vizinhanca[count++] = cor.getRed();
                        }
                    }
                    int media = Arrays.stream(vizinhanca).sum() / vizinhanca.length;
                    Color novaCor = new Color(media, media, media);
                    imgSaida.setRGB(w, h, novaCor.getRGB());
                }
            }


        salvarImagem(imgSaida,"jpg","mediaMatrizValorDefinidoSaida.png");
        display(imgSaida);
        return imgSaida;
    }
    public static BufferedImage medianaMatrizDefinida(BufferedImage imagem, int tamanhoMatrix) {
        BufferedImage imgSaida = new BufferedImage(imagem.getWidth(), imagem.getHeight(), imagem.getType());
         int aux = tamanhoMatrix / 2;

            for (int h = 0; h < imagem.getHeight(); h++) {
                for (int w = 0; w < imagem.getWidth(); w++) {
                    if (w <= aux || h <= aux || w >= imagem.getWidth() - aux || h >= imagem.getHeight() - aux) {
                        int rgb = imagem.getRGB(w, h);
                        imgSaida.setRGB(w, h, rgb);
                        continue;
                    }
                    int[] vizinhanca = new int[tamanhoMatrix * tamanhoMatrix];
                    int count = 0;
                    for (int i = -aux; i <= aux; i++) {
                        for (int j = -aux; j <= aux; j++) {
                            Color cor = new Color(imagem.getRGB(w + j, h + i));
                            vizinhanca[count++] = cor.getRed();
                        }
                    }
                    Arrays.sort(vizinhanca);
                    int mediana = vizinhanca[tamanhoMatrix * tamanhoMatrix / 2];
                    Color novaCor = new Color(mediana, mediana, mediana);
                    imgSaida.setRGB(w, h, novaCor.getRGB());
                }

            }

        salvarImagem(imgSaida,"jpg","medianaMatrizSaida.png");
        display(imgSaida);
        return imgSaida;
    }

}