import javax.swing.*;
import java.awt.*;
import java.awt.Color.*;
import java.util.*;
import java.util.List;

/**    Classe que representa uma arena de jogo.
 @version 1.4 20/05/2024
 @author Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 */

public class Arena extends JPanel {
    private final int LADO = 20;

    private Snake snake;
    private Comida comida;
    private ArrayList<Obstaculo> obstaculos;
    private int altura;
    private int largura;
    private Jogador jogador;
    private Ranking ranking;

    private JFrame frame;
    private JLabel labelPontuacao, labelDirecao;
    private JPanel panelInfo;


    /**
     * Construtor da classe Arena.
     * @param altura A altura da arena.
     * @param largura A largura da arena.
     * @param snake A snake do jogo.
     * @param obstaculos Os obstáculos na arena.
     * @param comida A comida presente na arena.
     * @param jogador O jogador do jogo.
     * @param ranking O ranking do jogo.
     */
    public Arena(int altura, int largura, Snake snake, ArrayList<Obstaculo> obstaculos, Comida comida, Jogador jogador, Ranking ranking) {
        this.altura = altura;
        this.largura = largura;
        this.comida = comida;
        this.snake = snake;
        this.obstaculos = obstaculos;
        this.jogador = jogador;
        this.ranking = ranking;

        panelInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        setPreferredSize(new Dimension(largura * LADO, altura * LADO));
        setBackground(Color.BLACK);

    }

    public int getAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }

    public ArrayList<Obstaculo> getObstaculos() {
        return this.obstaculos;
    }

    public Comida getComida() {
        return this.comida;
    }


    /**
     * Atualiza o estado da arena.
     */
    public void update() {
        if (snake != null) {
            if (snake.colisaoSnakeComida(this.comida)) {
                this.comida = comida.geraComida(altura, largura);
                snake.addTail();
                jogador.atualizaPontos();
            } else {
                snake.move(this);
            }
            snake.colisaoTail();
            snake.colisaoSnakeObstaculo(this);
            snake.colisaoSnakeArena(this);
            snake.colisaoTail();
            gameOver();
        }

        atualizarObstaculos();
        desenharDirecao();
        desenharPontuacao();

        frame.getContentPane().add(panelInfo, BorderLayout.SOUTH);

        revalidate();
        repaint();
    }

    /**
     * Desenha a arena, incluindo a grid, a comida, os obstáculos e a snake.
     * @param g O contexto gráfico.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.darkGray);
        for (int i = 0; i < getWidth(); i += LADO) {
            for (int j = 0; j < getHeight(); j += LADO) {
                g.drawRect(i, j, LADO, LADO);
            }
        }

        if (comida != null) {
            comida.draw(g2d);
        }

        for (Obstaculo obstaculo : obstaculos) {
            obstaculo.draw(g2d);
        }

        if (snake != null) {
            snake.draw(g2d);
        }
    }

    /**
     * Atualiza o estado dos obstáculos na arena.
     */
    private void atualizarObstaculos() {
        for (Obstaculo obstaculo : obstaculos) {
            obstaculo.atualiza();
        }
    }

    /**
     * Verifica se o jogo terminou e encerra-o.
     */
    public void gameOver() {
        if (!snake.getViva()) {
            snake = null;
            ranking.addPontuacao(jogador);

            frame.getContentPane().removeAll();

            frame.getContentPane().setLayout(new BorderLayout());

            JPanel gameOverPanel = new JPanel();
            gameOverPanel.setBackground(new Color(237, 235, 229));
            gameOverPanel.setLayout(new BorderLayout());

            JLabel label = new JLabel("GAME OVER", SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 82));
            gameOverPanel.add(label, BorderLayout.CENTER);

            frame.getContentPane().add(gameOverPanel, BorderLayout.CENTER);

            frame.revalidate();
            frame.repaint();

            ranking.saveRanking();
            ranking.loadRanking();
        }
    }

    /**
     * Desenha a direção da snake na interface do utilizador.
     */
    public void desenharDirecao() {
        String direcao = "";
        if (snake != null) {
            switch (snake.getDirecao()) {
                case 0:
                    direcao = "Direção: CIMA";
                    break;
                case 1:
                    direcao = "Direção: BAIXO";
                    break;
                case 2:
                    direcao = "Direção: ESQUERDA";
                    break;
                case 3:
                    direcao = "Direção: DIREITA";
                    break;
            }

            if (labelDirecao == null) {
                labelDirecao = new JLabel(direcao);
                labelDirecao.setFont(new Font("Arial", Font.BOLD, 20));
                panelInfo.add(labelDirecao);
            } else {
                labelDirecao.setText(direcao);
            }
        }
    }

    /**
     * Desenha a pontuação do jogador na interface do utilizador.
     */
    public void desenharPontuacao() {
        String pontuacao = "Pontuação: " + jogador.getPontos();

        if (labelPontuacao == null) {
            labelPontuacao = new JLabel(pontuacao);
            labelPontuacao.setFont(new Font("Arial", Font.BOLD, 20));
            panelInfo.add(Box.createHorizontalGlue());
            panelInfo.add(labelPontuacao);
        } else {
            labelPontuacao.setText(pontuacao);
        }
    }

    public void setFrame(JFrame frame){
        this.frame = frame;
    }

}