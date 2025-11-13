/**
 * Classe que implementa um dos movimentos automáticos da snake.
 * @version 1.2 19/05/2024
 * @autor Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 */
public class MovimentoAutomatico implements MovimentoSnake {

        /**
         * Move a snake automaticamente na arena com base na direção calculada.
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
            snake.setDirecao(direcaoAutomatica(snake,arena));

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

        /**
         * Calcula a direção automática que a snake deve seguir para alcançar a comida.
         * @param snake A snake cuja direção será calculada.
         * @param arena A arena em que a snake está em movimento.
         * @return A direção calculada para a snake seguir.
         */
        @Override
        public int direcaoAutomatica(Snake snake,Arena arena){

                Comida food = arena.getComida();
                Quadrado head = snake.getHead();
                Ponto[] pontosHead = head.getPontos();
                Quadrado foodSquare= food.getFormaQuadrado();
                Ponto[] pontosFood = foodSquare.getPontos();

                if(pontosHead[0].getY()>pontosFood[0].getY()) {
                    return 0;
                }
                if(pontosHead[0].getY()<pontosFood[0].getY())
                {
                    return 1;
                }
                if(pontosHead[0].getX()<pontosFood[0].getX())
                {
                    return 3;
                }
                else
                    return 2;
        }
}
