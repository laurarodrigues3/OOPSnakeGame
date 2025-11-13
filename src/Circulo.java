import java.awt.*;

/**    Classe que representa um circulo.
 @version 1.2 19/05/2024
 @author Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 */

public class Circulo {

    private Ponto centro;
    private double raio;
    private Quadrado quadradoDoCirculo;

    /**
     * Construtor para definir o centro e o raio do círculo.
     * @param centro O ponto central do círculo.
     * @param raio O raio do círculo.
     */
    public Circulo(Ponto centro, double raio) {
        this.centro = centro;
        this.raio = raio;
        this.quadradoDoCirculo = calcularQuadradoDoCirculo(centro, raio);
    }

    /**
     * Calcula o quadrado delimitador do círculo.
     * @param centro O ponto central do círculo.
     * @param raio O raio do círculo.
     * @return O quadrado delimitador do círculo.
     */
    private Quadrado calcularQuadradoDoCirculo(Ponto centro, double raio) {

        Ponto cantoInferiorEsquerdo = new Ponto(centro.getX() - raio, centro.getY() - raio);
        Ponto cantoInferiorDireito = new Ponto(centro.getX() + raio, centro.getY() - raio);
        Ponto cantoSuperiorEsquerdo = new Ponto(centro.getX() - raio, centro.getY() + raio);
        Ponto cantoSuperiorDireito = new Ponto(centro.getX() + raio, centro.getY() + raio);


        Ponto[] pontos = {cantoInferiorEsquerdo, cantoInferiorDireito, cantoSuperiorDireito, cantoSuperiorEsquerdo};
        return new Quadrado(pontos);
    }

    public Ponto getCentro() {
        return centro;
    }

    public Quadrado getQuadradoDoCirculo() {
        return quadradoDoCirculo;
    }

    /**
     * Desenha o círculo com um contorno preto.
     * @param g O contexto gráfico.
     */
    public void draw(Graphics2D g) {
        int diameter = (int) (2 * raio)*10;
        g.fillOval((int) (centro.getX() - raio)*10, (int) (centro.getY() - raio)*10, diameter, diameter);

        g.setColor(Color.BLACK);
        g.drawOval((int) (centro.getX() - raio)*10, (int) (centro.getY() - raio)*10, diameter, diameter);
    }
}