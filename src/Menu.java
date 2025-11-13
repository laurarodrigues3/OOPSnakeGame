import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe que representa o menu do jogo Snake.
 * @version 1.4 21/05/2024
 * @autor Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 */

public class Menu {

    private ArrayList<Obstaculo> obstaculos;
    private String nomeJogador;
    private Settings settings;
    private Ranking ranking;
    private Ponto[] pontosSnake;
    private boolean isManual;

    /**
     * Construtor da classe Menu que inicializa os atributos.
     * @throws IOException Se ocorrer um erro ao carregar o ranking.
     */
    public Menu() throws IOException {
        this.obstaculos = new ArrayList<>();
        this.nomeJogador = null;
        this.settings = new Settings();
        this.ranking = new Ranking("snake");
        this.pontosSnake = new Ponto[4];
        this.isManual = true;
    }

    /**
     * Exibe o menu principal do jogo.
     */
    public void mostrarMenu() {

        JFrame frame = new JFrame("SNAKE GAME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 400;
        int height = 400;
        frame.setSize(400, 400);
        frame.setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - width) / 2;
        int y = (screenSize.height - height) / 2;
        frame.setLocation(x, y);


        JPanel panel = new JPanel();
        panel.setBackground(new Color(50, 50, 50));
        panel.setLayout(null);
        frame.add(panel);


        JLabel titleLabel = new JLabel("SNAKE GAME");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(120, 40, 300, 30);
        panel.add(titleLabel);


        JButton jogarButton = createButton("JOGAR", 45, 100, 300, 50);
        jogarButton.setForeground(Color.ORANGE);
        jogarButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
        panel.add(jogarButton);
        jogarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarJogo(frame,screenSize);
            }
        });

        JButton placarButton = createButton("RANKING", 45, 175, 300, 50);
        placarButton.setForeground(Color.ORANGE);
        placarButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
        panel.add(placarButton);
        placarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                mostrarRanking(frame);
            }
        });


        JButton sairButton = createButton("SAIR", 45, 250, 300, 50);
        sairButton.setForeground(Color.ORANGE);
        sairButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
        panel.add(sairButton);
        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        frame.setVisible(true);
    }

    /**
     * Cria um botão com as propriedades especificadas.
     * @param text O texto do botão.
     * @param x A posição x do botão.
     * @param y A posição y do botão.
     * @param width A largura do botão.
     * @param height A altura do botão.
     * @return O botão configurado.
     */
    private static JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setFocusPainted(false);
        button.setBackground(new Color(80, 80, 80));
        return button;
    }

    /**
     * Inicia o jogo após as configurações do jogador.
     * @param frame O frame principal do menu.
     * @param screenSize O tamanho da tela.
     */
    private void iniciarJogo(JFrame frame, Dimension screenSize) {

        frame.setVisible(false);


        JFrame gameFrame = new JFrame("SNAKE GAME");
        gameFrame.setSize(600, 600);
        int gameX = (screenSize.width - 600) / 2;
        int gameY = (screenSize.height - 600) / 2;
        gameFrame.setLocation(gameX, gameY);
        gameFrame.setResizable(false);
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(null);
        gamePanel.setBackground(new Color(50, 50, 50));
        gameFrame.add(gamePanel);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nomeJogadorLabel = new JLabel("NOME DO JOGADOR");
        nomeJogadorLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nomeJogadorLabel.setForeground(Color.WHITE);
        nomeJogadorLabel.setBounds(20, 20, 500, 30);
        gamePanel.add(nomeJogadorLabel);

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(240, 20, 200, 30);
        nameTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        gamePanel.add(nameTextField);

        JButton enterButton = createButton("ENTER", 460, 20, 75, 30);
        enterButton.setForeground(Color.ORANGE);
        enterButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));

        gamePanel.add(enterButton);
        enterButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                nomeJogador = nameTextField.getText();
            }
        });

        JLabel dificuldadeLabel = new JLabel("DIFICULDADE");
        dificuldadeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        dificuldadeLabel.setForeground(Color.WHITE);
        dificuldadeLabel.setBounds(220, 75, 500, 30);
        gamePanel.add(dificuldadeLabel);

        JButton facilButton = createButton("FÁCIL", 70, 120, 90, 35);
        facilButton.setForeground(Color.GREEN);
        facilButton.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));

        gamePanel.add(facilButton);
        facilButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settings.setDificuldade(300);
            }
        });

        JButton medioButton = createButton("MÉDIO", 250, 120, 90, 35);
        medioButton.setForeground(Color.YELLOW);
        medioButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));

        gamePanel.add(medioButton);
        medioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settings.setDificuldade(240);
            }
        });

        JButton dificilButton = createButton("DIFÍCIL", 430, 120, 90, 35);
        dificilButton.setForeground(Color.RED);
        dificilButton.setBorder(BorderFactory.createLineBorder(Color.RED, 2));

        gamePanel.add(dificilButton);
        dificilButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settings.setDificuldade(180);
            }
        });

        JLabel snakeLabel = new JLabel("TAMANHO DA SNAKE");
        snakeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        snakeLabel.setForeground(Color.WHITE);
        snakeLabel.setBounds(190, 180, 500, 30);
        gamePanel.add(snakeLabel);


        JButton doisButton = createButton("1x1", 70, 225, 90, 35);
        doisButton.setForeground(Color.ORANGE);
        doisButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
        gamePanel.add(doisButton);
        doisButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settings.setTamanhoSnake(2);
                pontosSnake = new Ponto[]{new Ponto(0, 0), new Ponto(0, 2), new Ponto(2, 2), new Ponto(2, 0)};
            }
        });

        JButton tresButton = createButton("2x2", 250, 225, 90, 35);
        tresButton.setForeground(Color.ORANGE);
        tresButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
        gamePanel.add(tresButton);
        tresButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settings.setTamanhoSnake(4);
                pontosSnake = new Ponto[]{new Ponto(0, 0), new Ponto(0, 4), new Ponto(4, 4), new Ponto(4, 0)};
            }
        });

        JButton quatroButton = createButton("3x3", 430, 225, 90, 35);
        quatroButton.setForeground(Color.ORANGE);
        quatroButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
        gamePanel.add(quatroButton);
        quatroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settings.setTamanhoSnake(6);
                pontosSnake = new Ponto[]{new Ponto(0, 0), new Ponto(0, 6), new Ponto(6, 6), new Ponto(6, 0)};
            }
        });

        JLabel movimentoLabel = new JLabel("MOVIMENTO DA SNAKE");
        movimentoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        movimentoLabel.setForeground(Color.WHITE);
        movimentoLabel.setBounds(190, 285, 500, 30);
        gamePanel.add(movimentoLabel);

        JButton manualButton = createButton("MANUAL", 20, 330, 170, 35);
        manualButton.setForeground(Color.ORANGE);
        manualButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
        gamePanel.add(manualButton);
        manualButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settings.setMovimentoSnake(new MovimentoDinamico());
            }
        });

        JButton automatico1Button = createButton("AUTOMÁTICO 1", 210, 330, 170, 35);
        automatico1Button.setForeground(Color.ORANGE);
        automatico1Button.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
        gamePanel.add(automatico1Button);
        automatico1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settings.setMovimentoSnake(new MovimentoAutomatico());
                isManual = false;
            }
        });

        JButton automatico2Button = createButton("AUTOMÁTICO 2", 400, 330, 170, 35);
        automatico2Button.setForeground(Color.ORANGE);
        automatico2Button.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
        gamePanel.add(automatico2Button);
        automatico2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settings.setMovimentoSnake(new MovimentoAutomatico2());
                isManual = false;
            }
        });

        JLabel arenaLabel = new JLabel("TAMANHO DA ARENA");
        arenaLabel.setFont(new Font("Arial", Font.BOLD, 20));
        arenaLabel.setForeground(Color.WHITE);
        arenaLabel.setBounds(190, 395, 500, 30);
        gamePanel.add(arenaLabel);

        JButton pequenoButton = createButton("50x50", 70, 440, 90, 35);
        pequenoButton.setForeground(Color.ORANGE);
        pequenoButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
        gamePanel.add(pequenoButton);
        pequenoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settings.setTamanhoArena(54);
            }
        });

        JButton meioButton = createButton("60x60", 250, 440, 90, 35);
        meioButton.setForeground(Color.ORANGE);
        meioButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
        gamePanel.add(meioButton);
        meioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settings.setTamanhoArena(66);
            }
        });

        JButton grandeButton = createButton("70x70", 430, 440, 90, 35);
        grandeButton.setForeground(Color.ORANGE);
        grandeButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
        gamePanel.add(grandeButton);
        grandeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settings.setTamanhoArena(72);
            }
        });

        JButton startButton = createButton("START", 217, 500, 160, 50);
        startButton.setBackground(Color.ORANGE);
        startButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
        gamePanel.add(startButton);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(nomeJogador == null){
                    JOptionPane.showMessageDialog(gameFrame, "Por favor pressiona ENTER após adicionar o nome do jogador");
                }
                else if(settings.getDificuldade() == 0){
                    JOptionPane.showMessageDialog(gameFrame, "Por favor escolhe uma dificuldade");
                }
                else if(settings.getTamanhoSnake() == 0){
                    JOptionPane.showMessageDialog(gameFrame, "Por favor escolhe um tamanho para a snake");
                }
                else if(settings.getMovimentoSnake() == null){
                    JOptionPane.showMessageDialog(gameFrame, "Por favor escolhe um movimento");
                }
                else if(settings.getTamanhoArena() == 0){
                    JOptionPane.showMessageDialog(gameFrame, "Por favor escolhe um tamanho para a arena");
                }
                else{
                    gameFrame.setVisible(false);
                    if(isManual){
                        criarObstaculos(settings.getTamanhoArena());
                    }
                    Quadrado head = new Quadrado(pontosSnake);
                    Color corSnake = Color.green;
                    Snake snake = new Snake(head, corSnake, settings.getDificuldade(), settings.getMovimentoSnake(), settings.getTamanhoSnake(), settings.getDificuldade());
                    int xC = 5;
                    int yC = 35;
                    Comida comida = new ComidaCirculo(Color.RED, new Circulo(new Ponto(xC, yC), 1), settings);
                    Arena arena = new Arena(settings.getTamanhoArena(), settings.getTamanhoArena(), snake, obstaculos, comida, new Jogador(nomeJogador), ranking);
                    Jogo jogo = new Jogo(snake, arena, settings);
                    jogo.start();
                }
            }
        });


        gameFrame.setVisible(true);

    }

    /**
     * Mostra o ranking do jogo.
     * @param frame O frame principal do menu.
     */
    private void mostrarRanking(JFrame frame) {
        SwingUtilities.invokeLater(() -> {
            JFrame rankingFrame = new JFrame("Ranking");
            rankingFrame.setSize(500, 650);
            rankingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            rankingFrame.setLocationRelativeTo(null);
            rankingFrame.setResizable(false);

            JPanel rankingPanel = new JPanel();
            rankingPanel.setLayout(null);
            rankingPanel.setBackground(new Color(50, 50, 50));
            rankingFrame.add(rankingPanel);

            JLabel rankingLabel = new JLabel("RANKING");
            rankingLabel.setFont(new Font("Arial", Font.BOLD, 40));
            rankingLabel.setBounds(150, 5, 300, 75);
            rankingLabel.setForeground(Color.WHITE);
            rankingPanel.add(rankingLabel);

            JLabel instrucoesLabel = new JLabel("Número de jogadores do Ranking");
            instrucoesLabel.setFont(new Font("Arial", Font.PLAIN, 22));
            instrucoesLabel.setForeground(Color.WHITE);
            instrucoesLabel.setBounds(75, 65, 400, 70);
            rankingPanel.add(instrucoesLabel);

            JTextField numeroJogadoresField = new JTextField();
            numeroJogadoresField.setBounds(160, 140, 75, 50);
            numeroJogadoresField.setBackground(new Color(80, 80, 80));
            numeroJogadoresField.setFont(new Font("Arial", Font.PLAIN, 25));
            numeroJogadoresField.setForeground(Color.WHITE);
            rankingPanel.add(numeroJogadoresField);

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            textArea.setBackground(new Color(80, 80, 80));
            textArea.setForeground(Color.ORANGE);
            textArea.setFont(new Font("Arial", Font.PLAIN, 16));

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setBounds(48, 225, 400, 300);
            rankingPanel.add(scrollPane);

            JButton pesquisarButton = createButton("ENTER", 245, 140, 80, 50);
            pesquisarButton.setForeground(Color.ORANGE);
            pesquisarButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
            rankingPanel.add(pesquisarButton);

            Ranking finalRanking = ranking;

            pesquisarButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int jogadoresRanking;
                    try{
                        jogadoresRanking = Integer.parseInt(numeroJogadoresField.getText());
                        int numJogadores = Math.min(jogadoresRanking, finalRanking.getMelhoresJogadores().size());

                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < numJogadores; i++) {
                            Jogador jogador = finalRanking.getMelhoresJogadores().get(i);
                            sb.append((i + 1)).append(". ").append(jogador.getNomeJogador()).append(" - Pontuação: ").append(jogador.getPontos()).append("\n");
                        }

                        textArea.setText(sb.toString());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(rankingFrame, "Por favor insere um número válido.");
                    }
                }
            });

            JButton voltarButton = createButton("VOLTAR", 143, 560, 200, 40);
            voltarButton.setForeground(Color.ORANGE);
            voltarButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
            rankingPanel.add(voltarButton);
            voltarButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    rankingFrame.dispose();
                    frame.setVisible(true);
                }
            });
            rankingFrame.setVisible(true);
        });
    }

    /**
     * Cria a lista de obstáculos para o jogo.
     * @param tamanhoArena O tamanho da arena de jogo.
     */
    private void criarObstaculos(int tamanhoArena) {
        obstaculos.clear();
        int width = tamanhoArena;
        int height = tamanhoArena;


        Ponto[] pontosObs1 = {
                new Ponto((int) (width * 0.1) + 5, (int) (height * 0.075) + 4),
                new Ponto((int) (width * 0.175) + 5, (int) (height * 0.075) + 4),
                new Ponto((int) (width * 0.175) + 5, (int) (height * 0.2) + 4),
                new Ponto((int) (width * 0.1) + 5, (int) (height * 0.2) + 4)
        };


        Ponto[] pontosObs2 = {
                new Ponto((int) (width * 0.6), (int) (height * 0.15) + 4),
                new Ponto((int) (width * 0.8), (int) (height * 0.25) + 4),
                new Ponto((int) (width * 0.85), (int) (height * 0.1) + 4),
                new Ponto((int) (width * 0.7), (int) (height * 0.05) + 4)
        };


        Ponto[] pontosObs3 = {
                new Ponto((int) (width * 0.35), (int) (height * 0.6)),
                new Ponto((int) (width * 0.4), (int) (height * 0.65)),
                new Ponto((int) (width * 0.45), (int) (height * 0.65)),
                new Ponto((int) (width * 0.5), (int) (height * 0.6)),
                new Ponto((int) (width * 0.5), (int) (height * 0.5)),
                new Ponto((int) (width * 0.45), (int) (height * 0.4)),
                new Ponto((int) (width * 0.4), (int) (height * 0.4)),
                new Ponto((int) (width * 0.35), (int) (height * 0.5))
        };


        Ponto[] pontosObs4 = {
                new Ponto((int) (width * 0.2) - 3, (int) (height * 0.8) + 7),
                new Ponto((int) (width * 0.15) - 3, (int) (height * 0.625) + 7),
                new Ponto((int) (width * 0.375) - 3, (int) (height * 0.75) + 7)
        };


        Ponto[] pontosObs5 = {
                new Ponto((int) (width * 0.575) + 6, (int) (height * 0.75) + 7),
                new Ponto((int) (width * 0.7) + 6, (int) (height * 0.7) + 7),
                new Ponto((int) (width * 0.7) + 6, (int) (height * 0.8) + 7),
                new Ponto((int) (width * 0.775) + 6, (int) (height * 0.725) + 7),
                new Ponto((int) (width * 0.75) + 6, (int) (height * 0.625) + 7),
                new Ponto((int) (width * 0.65) + 6, (int) (height * 0.65) + 7)
        };

        switch (settings.getDificuldade()){
            case 300:
                obstaculos.add(new Obstaculo(new Poligono(pontosObs3), new Color(174, 53, 232), true, 60));
                break;
            case 240:
                obstaculos.add(new Obstaculo(new Retangulo(pontosObs1), new Color(174, 53, 232), true, 90));
                obstaculos.add(new Obstaculo(new Poligono(pontosObs3), new Color(174, 53, 232), true, 60));
                obstaculos.add(new Obstaculo(new Poligono(pontosObs5), new Color(174, 53, 232), true, 90));
                break;
            case 180:
                obstaculos.add(new Obstaculo(new Retangulo(pontosObs1), new Color(174, 53, 232), true, 90));
                obstaculos.add(new Obstaculo(new Poligono(pontosObs2), new Color(174, 53, 232), false, 0));
                obstaculos.add(new Obstaculo(new Poligono(pontosObs3), new Color(174, 53, 232), true, 60));
                obstaculos.add(new Obstaculo(new Poligono(pontosObs4), new Color(174, 53, 232), false, 0));
                obstaculos.add(new Obstaculo(new Poligono(pontosObs5), new Color(174, 53, 232), true, 90));
                break;
            default:
                break;
        }
    }
}