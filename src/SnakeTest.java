import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SnakeTest {

    private Snake snake;
    private Arena arena;
    private Quadrado head;
    private ArrayList<Obstaculo> obstaculos;
    private Comida comida;
    private Jogador jogador;
    private Ranking ranking;
    private MovimentoSnake movimentoSnake;

    @BeforeEach
    void setUp() {
        head = new Quadrado(new Ponto[]{new Ponto(5, 5), new Ponto(5, 6), new Ponto(6, 6), new Ponto(6, 5)});
        movimentoSnake = new MovimentoDinamico(); // Supondo que você tem uma implementação de MovimentoDinamico
        snake = new Snake(head, Color.GREEN, 100, movimentoSnake,1,180);
        obstaculos = new ArrayList<>();
        comida = new ComidaCirculo(Color.RED, new Circulo(new Ponto(10, 10), 1),new Settings());
        jogador = new Jogador("Test");
        arena = new Arena(20, 20, snake, obstaculos, comida, jogador, ranking);
    }

    @Test
    void testSetDirecao() {
        snake.setDirecao(0);
        assertEquals(0, snake.getDirecao());
    }


    @Test
    void testMove() {
        snake.move(arena);
        Ponto newHeadCentroid = snake.getHead().centroide();
        assertNotEquals(new Ponto(5, 5), newHeadCentroid); // Verifica se a cabeça se moveu
    }

    @Test
    void testAddTail() {
        snake.addTail();
        assertEquals(1, snake.getTail().size());
    }

    @Test
    void testColisaoTail() {
        snake.addTail();
        snake.getHead().setPontos(new Ponto[]{new Ponto(5, 5), new Ponto(5, 6), new Ponto(6, 6), new Ponto(6, 5)});
        snake.colisaoTail();
        assertFalse(snake.getViva());
    }

    @Test
    void testColisaoSnakeComida() {
        snake.getHead().setPontos(new Ponto[]{new Ponto(10, 10), new Ponto(10, 11), new Ponto(11, 11), new Ponto(11, 10)});
        assertFalse(snake.colisaoSnakeComida(comida));
    }


    @Test
    void testColisaoSnakeArena() {
        snake.getHead().setPontos(new Ponto[]{new Ponto(21, 21), new Ponto(21, 22), new Ponto(22, 22), new Ponto(22, 21)});
        snake.colisaoSnakeArena(arena);
        assertFalse(snake.getViva());
    }

}
