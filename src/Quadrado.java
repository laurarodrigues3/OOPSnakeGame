import java.awt.*;

/**    Classe que representa um quadrado.
 @version 1.1 30/03/2024
 @author Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 @inv O quadrado tem de ter 4 pontos.
 @inv Duas arestas consecutivas têm de formar um ângulo de 90º entre si.
 */
public class Quadrado extends Retangulo {

    /**
     * @param pontos Array de pontos que define os vértices do quadrado.
     */
    public Quadrado(Ponto[] pontos){
        super(pontos);
        check(pontos);
    }
    

    /**
     * Verifica as arestas do quadrado têm todas o mesmo tamanho.
     * @param pontos O array de pontos que contém os vértices.
     */
    private void check(Ponto[] pontos){
        Ponto[] p = getPontos();
        if(!(p[0].dist(p[1]) == p[1].dist(p[2]) && p[1].dist(p[2]) == p[2].dist(p[3]) && p[2].dist(p[3]) == p[3].dist(p[0]))){
            System.out.println("Quadrado:vi");
            System.exit(0);
        }
    }

    /**
     * Forma uma string especificando os vértices do quadrado.
     * @return Uma string a dizer que é um quadrado e diz quais são os seus vértices.
     */
    @Override
    public String toString(){
        Ponto[] p = getPontos();
        String s = "Quadrado: [" + p[0].toString() + ", " + p[1].toString() + ", "
                + p[2].toString() + ", " + p[3].toString() + "]";
        return s;
    }

    @Override
    public Quadrado movimentado(Ponto[] pontos){
        return new Quadrado(pontos);
    }

}
