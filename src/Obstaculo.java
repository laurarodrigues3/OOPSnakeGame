import java.awt.*;

/**    Classe que representa os obstáculos do jogo.
 @version 1.2 19/05/2024
 @author Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 */
public class Obstaculo implements MovimentoObstaculo {
    private Poligono forma;
    private Color cor;
    private boolean dinamico;
    private int anguloRotacao;

    /**
     * Construtor da classe Obstaculo.
     * @param forma A forma geométrica do obstáculo.
     * @param cor A cor do obstáculo.
     * @param dinamico Indica se o obstáculo deve ter rotação.
     * @param anguloRotacao O ângulo de rotação do obstáculo (se for dinâmico).
     */
    public Obstaculo(Poligono forma, Color cor, boolean dinamico, int anguloRotacao) {
        this.forma = forma;
        this.cor = cor;
        this.dinamico = dinamico;
        this.anguloRotacao = anguloRotacao;
    }

    /**
     * Método que aplica a rotação ao obstáculo.
     * @param angulo O ângulo de rotação.
     * @param pontoRotacao O ponto sobre o qual será feita a rotação.
     */
    @Override
    public void rotacao(int angulo, Ponto pontoRotacao) {
        this.forma=forma.rotacao(angulo, pontoRotacao);
    }

    /**
     * Método que atualiza o obstáculo (aplica rotação automática se for dinâmico).
     */

    public void atualiza() {
        if (dinamico) {
            Ponto centroide = forma.centroide();
            rotacao(anguloRotacao, centroide);
        }
    }

    /**
     * Desenha o obstáculo na tela.
     * @param g O contexto gráfico.
     */
    public void draw(Graphics2D g) {
        g.setColor(cor);
        forma.draw(g);
    }

    public Poligono getForma() {
        return forma;
    }

}
