import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**    Classe que representa a comida do jogo. É uma classe abstrata.
 @version 1.2 19/05/2024
 @author Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 */

public abstract class Comida {

    private final int[] VALORES_X_PEQUENO = {1,3,5,7,9,11,13,15,17,19,21,23,25,27,
            29,31,33,35,37,39,41,43,45,47};
    private final int[] VALORES_Y_PEQUENO = {1,3,5,7,9,11,13,15,17,19,21,23,25,27,
            29,31,33,35,37,39,41,43,45,47};
    private final int[] VALORES_X_MEDIO = {1,3,5,7,9,11,13,15,17,19,21,23,25,27,
            29,31,33,35,37,39,41,43,45,47,49,51,53,55,57,59};
    private final int[] VALORES_Y_MEDIO = {1,3,5,7,9,11,13,15,17,19,21,23,25,27,
            29,31,33,35,37,39,41,43,45,47,49,51,53,55,57,59};
    private final int[] VALORES_X_GRANDE = {1,3,5,7,9,11,13,15,17,19,21,23,25,27,
            29,31,33,35,37,39,41,43,45,47,49,51,53,55,57,59,61,63,65,67,69,71};
    private final int[] VALORES_Y_GRANDE = {1,3,5,7,9,11,13,15,17,19,21,23,25,27,
            29,31,33,35,37,39,41,43,45,47,49,51,53,55,57,59,61,63,65,67,69,71};

    private final Ponto[] P1 ={new Ponto(8,8),new Ponto(22,8),new Ponto(22,18),new Ponto(8,18)};
    private final Retangulo OBSTACULO1 = new Retangulo(P1);

    private final Ponto[] P2 ={new Ponto(42,6),new Ponto(62,6),new Ponto(62,24),new Ponto(42,24)};
    private final Retangulo OBSTACULO2 = new Retangulo(P2);

    private final Ponto[] P3 ={new Ponto(18,24),new Ponto(44,24),new Ponto(44,48),new Ponto(18,48)};
    private final Retangulo OBSTACULO3 = new Retangulo(P3);

    private final Ponto[] P4 ={new Ponto(6,50),new Ponto(24,50),new Ponto(24,66),new Ponto(6,66)};
    private final Retangulo OBSTACULO4 = new Retangulo(P4);

    private final Ponto[] P5 ={new Ponto(46,46),new Ponto(66,46),new Ponto(66,64),new Ponto(46,64)};
    private final Retangulo OBSTACULO5 = new Retangulo(P5);

    private final Retangulo[] OBS = {OBSTACULO1,OBSTACULO2,OBSTACULO3,OBSTACULO4,OBSTACULO5};


    private Color cor;
    private Settings settings;

    /**
     * Construtor para definir a cor e as configurações da comida.
     * @param cor A cor da comida.
     * @param settings As configurações do jogo.
     */
    public Comida(Color cor, Settings settings){
        this.cor = cor;
        this.settings = settings;
    }

    /**
     * Método para gerar comida na arena.
     * @param largura A largura da arena.
     * @param altura A altura da arena.
     * @return A comida gerada.
     */
    public Comida geraComida(int largura, int altura){
        Random random = new Random();

        int r = random.nextInt(2);
        int x=0,y=0;

        switch (settings.getTamanhoArena()){
            case 54:
                x = VALORES_X_PEQUENO[random.nextInt(VALORES_X_PEQUENO.length)];
                y = VALORES_Y_PEQUENO[random.nextInt(VALORES_Y_PEQUENO.length)];
                break;
            case 66:
                x = VALORES_X_MEDIO[random.nextInt(VALORES_X_MEDIO.length)];
                y = VALORES_Y_MEDIO[random.nextInt(VALORES_Y_MEDIO.length)];
                break;
            case 72:
                x = VALORES_X_GRANDE[random.nextInt(VALORES_X_GRANDE.length)];
                y = VALORES_Y_GRANDE[random.nextInt(VALORES_Y_GRANDE.length)];
                break;
            default:
                break;
        }
        if(r == 0){
            Comida comida = new ComidaCirculo(Color.RED, new Circulo(new Ponto(x,y), 1),settings);
            for(int i = 0; i < OBS.length; i++){
                if(OBS[i].contida(comida.getFormaQuadrado())){
                    return geraComida(altura,largura);
                }
            }
            return comida;
        }
        else {

            Ponto[] pontos = {new Ponto(x-1,y+1),new Ponto(x+1,y+1),new Ponto(x+1,y-1),new Ponto(x-1,y-1)};
            Comida comida = new ComidaQuadrado(Color.RED, new Quadrado(pontos),settings);

            for(int i = 0; i < OBS.length; i++){
                if(OBS[i].contida(comida.getFormaQuadrado())){
                    return geraComida(altura,largura);
                }
            }
            return comida;
        }
    }


    public abstract Quadrado getFormaQuadrado();

    public abstract Ponto[] getPontos();

    public Color getCor() {
        return cor;
    }

    public abstract void draw(Graphics2D g);

}