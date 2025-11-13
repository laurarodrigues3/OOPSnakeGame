/**    Classe que representa um triângulo.
 @version 1.1 30/03/2024
 @author Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 @inv O triângulo tem de ter 3 pontos.
 */
public class Triangulo extends Poligono{

    /**
     * @param pontos Array de pontos que define os vértices do triângulo.
     */
    public Triangulo(Ponto[] pontos){
        super(pontos);
        check(pontos);
    }

    /**
     * Verifica se o array de pontos tem exatamente 3 pontos.
     * @param pontos O array de pontos que contém os vértices.
     */
    private void check(Ponto[] pontos){
        if(pontos.length != 3){
            System.out.println("Triangulo:vi");
            System.exit(0);
        }
    }

    /**
     * Forma uma string especificando os vértices do triângulo.
     * @return Uma string a dizer que é um triângulo e diz quais são os seus vértices.
     */
    @Override
    public String toString(){
        Ponto[] p = getPontos();
        String s = "Triangulo: [" + p[0].toString() + ", " + p[1].toString() + ", "
                + p[2].toString() + "]";
        return s;
    }

    @Override
    public Triangulo movimentado(Ponto[] pontos){
        return new Triangulo(pontos);
    }
}
