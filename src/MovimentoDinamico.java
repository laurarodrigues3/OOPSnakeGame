/**
 * Classe que implementa o movimento dinâmico da snake.
 * @version 1.3 20/05/2024
 * @autor Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 */
public class MovimentoDinamico implements MovimentoSnake{

    /**
     * Move a snake de forma dinâmica na arena com base na direção atual da snake.
     * @param snake A instância da snake a ser movida.
     * @param arena A arena em que a snake está em movimento.
     * @param numQuadrados O número de quadrados por lado da cabeça da snake.
     */
    @Override
    public void move(Snake snake,Arena arena, int numQuadrados)
    {
        Double[] centroid = snake.getHead().centroideList();
        int headSize = numQuadrados;
        int x = centroid[0].intValue();
        int y = centroid[1].intValue();

        switch (snake.getDirecao()) {
        case 0:
            y -= headSize;
            break;
        case 1:
            y += headSize;
            break;
        case 2:
            x -= headSize;
            break;
        case 3:
            x += headSize;
            break;
    }

        Quadrado movedHead = snake.getHead().translateToNewCentroid(x, y);
        snake.getTail().addFirst(snake.getHead());
        if (!snake.getTail().isEmpty()) {
        snake.getTail().removeLast();
    }
        snake.setHead(movedHead);
    }
    @Override
    public int direcaoAutomatica(Snake snake, Arena Arena){return 0;}

}
