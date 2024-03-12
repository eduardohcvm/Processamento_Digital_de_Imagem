package app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OperacaoPontual {
    public static void buscarDados(BufferedImage imagem) {
        if (imagem != null){

            int largura = imagem.getWidth();
            int altura = imagem.getHeight();
            System.out.println("Largura " + largura);
            System.out.println("Altura: " + altura);
            int pegarRPG = imagem.getRGB(largura/2,altura/2);
            System.out.println("pixel central cor: " + pegarRPG);

            salvarImagem(imagem,"jpg","imagem.jpg");

           display(imagem);
        }
    }

    public static void salvarImagem(BufferedImage imagem, String formato, String nomeImagem) {
        try {
            ImageIO.write(imagem, formato, new File(nomeImagem));
        }catch (IOException e){
            System.out.println("Erro ao salvar a imagem");
            throw new RuntimeException(e);
        }

    }
    public static void display(BufferedImage imagem){
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

}
