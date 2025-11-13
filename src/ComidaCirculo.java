import java.awt.*;

/**    Classe que representa a comida em forma de círculo.
 @version 1.3 20/05/2024
 @author Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 */

public class ComidaCirculo extends Comida{

    private Circulo forma;

    /**
     * Construtor para definir a cor e a forma da comida num círculo.
     * @param cor A cor da comida.
     * @param forma A forma circular da comida.
     * @param settings As configurações do jogo.
     */
    public ComidaCirculo(Color cor, Circulo forma, Settings settings){
        super(cor, settings);
        this.forma = forma;
    }

    @Override
    public Ponto[] getPontos(){
        Ponto[] ponto = new Ponto[2];
        ponto[0] = this.forma.getCentro();
        return ponto;
    }

    /**
     * Desenha a comida em forma de círculo na tela.
     * @param g O contexto gráfico.
     */
    @Override
    public void draw(Graphics2D g) {
        g.setColor(getCor());
        forma.draw(g);
    }

    @Override
    public Quadrado getFormaQuadrado(){
        return this.forma.getQuadradoDoCirculo();
    }
}