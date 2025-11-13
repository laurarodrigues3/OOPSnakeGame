/**
 * Classe que implementa um dos movimentos automáticos da snake.
 * @version 1.2 19/05/2024
 * @autor Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 */
public class MovimentoAutomatico2 implements MovimentoSnake {

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
        Double[] centroidHead = snake.getHead().centroideList();
        Quadrado foodSquare= food.getFormaQuadrado();
        Ponto[] pontosFood = foodSquare.getPontos();
        double[] caminhos = new double[4];


        for(int i=0;i<4;i++)
        {
            if(i==0){
                int x = centroidHead[0].intValue();
                int y = centroidHead[1].intValue();
                int headSize = snake.getHead().DistPoints();
                y-=headSize+1;
                Quadrado movedHead = snake.getHead().translateToNewCentroid(x, y);
                Ponto[] pontosCabeça = movedHead.getPontos();
                double dist = pontosCabeça[0].dist(pontosFood[0]);
                caminhos[i]=dist;
            }
            if(i==1){
                int x = centroidHead[0].intValue();
                int y = centroidHead[1].intValue();
                int headSize = snake.getHead().DistPoints();
                y+=headSize+1;
                Quadrado movedHead = snake.getHead().translateToNewCentroid(x, y);
                Ponto[] pontosCabeça = movedHead.getPontos();
                double dist = pontosCabeça[0].dist(pontosFood[0]);
                caminhos[i]=dist;
            }
            if(i==2){
                int x = centroidHead[0].intValue();
                int y = centroidHead[1].intValue();
                int headSize = snake.getHead().DistPoints();
                x-=headSize+1;
                Quadrado movedHead = snake.getHead().translateToNewCentroid(x, y);
                Ponto[] pontosCabeça = movedHead.getPontos();
                double dist = pontosCabeça[0].dist(pontosFood[0]);
                caminhos[i]=dist;
            }
            if(i==3){
                int x = centroidHead[0].intValue();
                int y = centroidHead[1].intValue();
                int headSize = snake.getHead().DistPoints();
                x+=headSize+1;
                Quadrado movedHead = snake.getHead().translateToNewCentroid(x, y);
                Ponto[] pontosCabeça = movedHead.getPontos();
                double dist = pontosCabeça[0].dist(pontosFood[0]);
                caminhos[i]=dist;
            }
        }
        int res =3;
        double b=Double.MAX_VALUE;
        for(int i = 0;i<caminhos.length;i++)
        {
            if(caminhos[i]<b&&!direcaoOposta(snake.getDirecao(), i))
            {
                b=caminhos[i];
                res=i;
            }

        }
        return res;
    }

    /**
     * Verifica se a nova direção é oposta à direção atual da snake.
     * @param direcaoAtual A direção atual da snake.
     * @param novaDirecao A nova direção.
     * @return Verdadeiro se a nova direção for oposta à direção atual, falso caso contrário.
     */

    private boolean direcaoOposta(int direcaoAtual, int novaDirecao) {
        return (direcaoAtual == 0 && novaDirecao == 1) ||
                (direcaoAtual == 1 && novaDirecao == 0) ||
                (direcaoAtual == 2 && novaDirecao == 3) ||
                (direcaoAtual == 3 && novaDirecao == 2);
    }




}
