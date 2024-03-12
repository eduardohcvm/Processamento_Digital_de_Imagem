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
        if (imagem != null){

            int largura = imagem.getWidth();
            int altura = imagem.getHeight();
            System.out.println("Largura " + largura);
            System.out.println("Altura: " + altura);
            int pegarRPG = imagem.getRGB(largura/2,altura/2);
            System.out.println("pixel central cor: " + pegarRPG);

            mudarImagem(imagem, altura, largura);

            salvarImagem(imagem,"jpg","imagem.jpg");

            display(imagem);
        }
    }

    private static void mudarImagem(BufferedImage imagem, int altura, int largura) {
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
        display(imagemSaida);
    }

    private static void salvarImagem(BufferedImage imagem, String formato, String nomeImagem) {
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
