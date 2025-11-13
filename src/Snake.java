import java.awt.*;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

/**    Classe que representa a snake.
 @version 1.4 21/05/2024
 @author Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 */

public class Snake {

    private final int CIMA = 0;
    private final int BAIXO = 1;
    private final int ESQUERDA = 2;
    private final int DIREITA = 3;
    private Color DARK_GREEN = new Color(1,50,32);


    private Quadrado head;
    private Color cor;
    private LinkedList<Quadrado> tail;
    private int velocidade;
    private int direcao;
    private boolean viva;
    private MovimentoSnake movimentoSnake;
    private int numQuadrados;
    private int dificuldade;

    /**
     * Construtor da classe Snake.
     * @param head A cabeça da snake.
     * @param cor A cor da snake.
     * @param velocidade A velocidade de movimento da snake.
     * @param movimentoSnake O tipo de movimento da snake.
     * @param numQuadrados O número de quadrados que compõem cada lado da snake.
     * @param dificuldade A dificuldade do jogo.
     */
    public Snake(Quadrado head, Color cor, int velocidade, MovimentoSnake movimentoSnake, int numQuadrados, int dificuldade){
        this.head = head;
        this.cor = cor;
        this.velocidade = velocidade;
        this.tail = new LinkedList<>();
        this.direcao = DIREITA;
        this.viva = true;
        this.movimentoSnake=movimentoSnake;
        this.numQuadrados = numQuadrados;
        this.dificuldade = dificuldade;
    }

    public void setDirecao(int direcao){this.direcao=direcao;}

    /**
     * Captura as teclas pressionadas para controlar a direção da snake.
     * @param tecla O evento da tecla pressionada.
     */
    public void teclas(KeyEvent tecla){

        int codigoTecla = tecla.getKeyCode();

        switch (codigoTecla){
            case KeyEvent.VK_UP:
                if(this.direcao != BAIXO) this.direcao = CIMA;
                break;
            case KeyEvent.VK_DOWN:
                if(this.direcao != CIMA) this.direcao = BAIXO;
                break;
            case KeyEvent.VK_LEFT:
                if(this.direcao != DIREITA) this.direcao = ESQUERDA;
                break;
            case KeyEvent.VK_RIGHT:
                if(this.direcao != ESQUERDA) this.direcao = DIREITA;
                break;
            default:
                break;
        }
    }


    /**
     * Movimenta a snake para a direção atual.
     */
    public void move(Arena arena) {
        movimentoSnake.move(this,arena, numQuadrados);
    }

    public int direcaoAutomatica(Arena arena)
    {
        return movimentoSnake.direcaoAutomatica(this,arena);
    }

    /**
     * Adiciona um novo quadrado ao corpo da snake.
     */
    public void addTail() {
        Double[] centroid = head.centroideList();
        int headSize = numQuadrados;
        int x = centroid[0].intValue();
        int y = centroid[1].intValue();

        switch (direcao) {
            case CIMA:
                y -= headSize;
                break;
            case BAIXO:
                y += headSize;
                break;
            case ESQUERDA:
                x -= headSize;
                break;
            case DIREITA:
                x += headSize;
                break;
        }

        Quadrado newHead = head.translateToNewCentroid(x, y);
        tail.addFirst(head);
        head = newHead;
    }

    /**
     * Verifica colisões da snake com seu próprio corpo.
     */
    public void colisaoTail(){
        if(!this.tail.isEmpty()){
            for(Quadrado quadradoTail : this.tail){
                if(quadradoTail.equals(this.head)) this.viva = false;
            }
        }
    }

    /**
     * Obtém a lista de quadrados do corpo da snake.
     * @return A lista de quadrados do corpo da snake.
     */
    public LinkedList<Quadrado> getTail(){
        return this.tail;
    }

    /**
     * Obtém a cabeça da snake.
     * @return A cabeça da snake.
     */
    public Quadrado getHead(){
        return this.head;
    }

    /**
     * Obtém o estado de vida da snake.
     * @return True se a snake está viva, False caso contrário.
     */
    public boolean getViva() {
        return this.viva;
    }

    public int getVelocidade(){
        return this.velocidade;
    }

    /**
     * Verifica colisões da snake com obstáculos na arena.
     * @param arena A arena onde a snake se move.
     */
    public void colisaoSnakeObstaculo(Arena arena){
        SegmentoReta[] ObArestas = new SegmentoReta[100];

        if(dificuldade == 180 || dificuldade == 240){
            Retangulo retangulo = (Retangulo) arena.getObstaculos().get(0).getForma();
            if(retangulo.contida(head)){
                this.viva = false;
            }
        }
        for(Obstaculo obstaculo : arena.getObstaculos()){
            if(obstaculo.getForma().verificaIntersecao(this.head)){
                this.viva = false; // Se houver interseção, a cobra morre
            }
        }
    }

    /**
     * Verifica a colisão da snake com a comida.
     * @param comida A comida presente na arena.
     * @return True se a cobra colidiu com a comida, False caso contrário.
     */
    public boolean colisaoSnakeComida(Comida comida){
        double menorHeadX = 1000000.0;
        double maiorHeadX = -1.0;
        double menorHeadY = 1000000.0;
        double maiorHeadY = -1.0;

        for(int i = 0; i<head.getPontos().length; i++){

            if(head.getPontos()[i].getX() < menorHeadX) menorHeadX = head.getPontos()[i].getX();
            if(head.getPontos()[i].getX() > maiorHeadX) maiorHeadX = head.getPontos()[i].getX();
            if(head.getPontos()[i].getY() < menorHeadY) menorHeadY = head.getPontos()[i].getY();
            if(head.getPontos()[i].getY() > maiorHeadY) maiorHeadY = head.getPontos()[i].getY();
        }

        Quadrado comidaQuadrado = comida.getFormaQuadrado();

        double menorComidaX = 1000000.0;
        double maiorComidaX = -1.0;
        double menorComidaY = 1000000.0;
        double maiorComidaY = -1.0;

        for(int i = 0; i<comidaQuadrado.getPontos().length; i++){

            if(comidaQuadrado.getPontos()[i].getX() < menorComidaX) menorComidaX = comidaQuadrado.getPontos()[i].getX();
            if(comidaQuadrado.getPontos()[i].getX() > maiorComidaX) maiorComidaX = comidaQuadrado.getPontos()[i].getX();
            if(comidaQuadrado.getPontos()[i].getY() < menorComidaY) menorComidaY = comidaQuadrado.getPontos()[i].getY();
            if(comidaQuadrado.getPontos()[i].getY() > maiorComidaY) maiorComidaY = comidaQuadrado.getPontos()[i].getY();
        }

        if(menorComidaX >= menorHeadX && maiorComidaX <= maiorHeadX && maiorComidaY <= maiorHeadY && menorComidaY >= menorHeadY){
            return true;
        }
        return false;
    }

    /**
     * Verifica a colisão da snake com os limites da arena.
     * @param arena A arena onde a snake se move.
     */
    public void colisaoSnakeArena(Arena arena){

        double menorX = 1000000.0;
        double maiorX = -1.0;
        double menorY = 1000000.0;
        double maiorY= -1.0;

        for(int i = 0; i<head.getPontos().length; i++){

            if(head.getPontos()[i].getX() < menorX) menorX = head.getPontos()[i].getX();
            if(head.getPontos()[i].getX() > maiorX) maiorX = head.getPontos()[i].getX();
            if(head.getPontos()[i].getY() < menorY) menorY = head.getPontos()[i].getY();
            if(head.getPontos()[i].getY() > maiorY) maiorY = head.getPontos()[i].getY();
        }

        if(maiorX > arena.getLargura() || menorY < 0 || menorX < 0 || maiorY > arena.getAltura()){
            this.viva = false;
        }
    }

    public int getDirecao(){
        return this.direcao;
    }

    /**
     * Desenha a snake na tela.
     * @param g O contexto gráfico onde a snake será desenhada.
     */
    public void draw(Graphics2D g)
    {
        g.setColor(Color.GREEN);
        head.draw(g);


        for (Quadrado quad : this.getTail()) {
            g.setColor(Color.GREEN);
            quad.draw(g);
        }

    }

    public void setHead(Quadrado movedHead) {
        this.head=movedHead;
    }
}
