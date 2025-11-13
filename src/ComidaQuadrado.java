import java.awt.*;

/**    Classe que representa a comida em forma de quadrado.
 @version 1.3 20/05/2024
 @author Laura Rodrigues, Lucas Galheto, Daniel GonÃ§alves
 */

public class ComidaQuadrado extends Comida{

    private Quadrado forma;

    /**
     * Construtor para definir a cor e a forma da comida num quadrado.
     * @param cor A cor da comida.
     * @param forma A forma quadrada da comida.
     * @param settings As configurações do jogo.
     */
    public ComidaQuadrado(Color cor, Quadrado forma, Settings settings){
        super(cor, settings);
        this.forma = forma;
    }

    @Override
    public Quadrado getFormaQuadrado() {
        return forma;
    }

    /**
     * Desenha a comida em forma de quadrado na tela.
     * @param g O contexto gráfico.
     */
    @Override
    public void draw(Graphics2D g) {
        g.setColor(getCor());
        forma.draw(g);
    }

    @Override
    public Ponto[] getPontos(){
        return this.forma.getPontos();
    }
}