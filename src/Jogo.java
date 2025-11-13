import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Classe que representa o jogo.
 * @version 1.3 17/05/2024
 * @autor Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 */
public class Jogo {
    private final int LADO = 10;
    private Snake snake;
    private Arena arena;
    private Timer timer;
    private Settings settings;

    /**
     * Construtor para definir a snake e a arena no jogo.
     * @param snake A snake.
     * @param arena A arena do jogo.
     * */
    public Jogo(Snake snake, Arena arena, Settings settings) {
        this.snake = snake;
        this.arena = arena;
        this.settings = settings;
    }

    /**
     * Método para iniciar o jogo.
     */
    public void start() {
        JFrame frame = new JFrame("Arena Visual");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        if(settings.getTamanhoArena() == 72){
            frame.setSize((LADO * arena.getLargura()) + 15 , (LADO * arena.getAltura()) + 71);
        }
        else{
            frame.setSize((LADO * arena.getLargura()) - 5, (LADO * arena.getAltura()) + 50);
        }

        arena.setFrame(frame);

        frame.add(arena, BorderLayout.CENTER);
        frame.setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - arena.getLargura() * LADO) / 2;
        int y = (screenSize.height - arena.getAltura() * LADO) / 2;
        frame.setLocation(x, y - 45);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                snake.teclas(e);
            }
        });

        timer = new Timer(snake.getVelocidade(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arena.update();
            }
        });
        timer.start();

        frame.setVisible(true);
    }
}
