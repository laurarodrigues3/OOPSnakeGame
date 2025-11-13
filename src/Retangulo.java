/**    Classe que representa um retângulo.
 @version 1.4 19/05/2024
 @author Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 @inv O retângulo tem de ter 4 pontos.
 @inv Duas arestas consecutivas têm de formar um ângulo de 90º entre si.
 */
public class Retangulo extends Poligono{

    /**
     * @param pontos Array de pontos que define os vértices do retângulo.
     */
    public Retangulo(Ponto[] pontos){
        super(pontos);
        check(pontos);
    }

    /**
     * verifica se existe 4 pontos para formar o retângulo e verifica se arestas consecutivas formam um ângulo de 90º entre si.
     * @param pontos O array de pontos que contém os vértices.
     */
    private void check(Ponto[] pontos){
        if(pontos.length != 4){
            System.out.println("Retangulo:vi");
            System.exit(0);
        }
        for(int i=0; i < getSegmentosReta().length; i++){
            if(!getSegmentosReta()[i].perpendiculares(getSegmentosReta()[(i+1) % getSegmentosReta().length])){
                System.out.println("Retangulo:vi");
                System.exit(0);
            }
        }
    }

    /**
     * Forma uma string especificando os vértices do retângulo.
     * @return Uma string a dizer que é um retângulo e diz quais são os seus vértices.
     */
    @Override
    public String toString(){
        Ponto[] p = getPontos();
        String s = "Retangulo: [" + p[0].toString() + ", " + p[1].toString() + ", "
                + p[2].toString() + ", " + p[3].toString() + "]";
        return s;
    }

    /**
     * Verifica se existe cruzamento entre as arestas de dois retângulos.
     * @param that O retângulo que vai ser utilizado para verificação.
     * @return true caso exista cruzamento, false caso contrário.
     */
    public boolean intersetaRetangulo(Retangulo that){
        for(int i=0; i<this.getSegmentosReta().length; i++){
            for(int j=0; j<that.getSegmentosReta().length; j++){
                if(this.getSegmentosReta()[i].verificaCruzamento(that.getSegmentosReta()[j])){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Verifica se um quadrado está contido em um retângulo.
     * @param quadrado O quadrado que vai ser utilizado para verificação.
     * @return true caso esteja contido, false caso contrário.
     */
    public boolean contida(Quadrado quadrado){
        double menorX = 1000000.0;
        double maiorX = -1.0;
        double menorY = 1000000.0;
        double maiorY = -1.0;

        for(int i = 0; i<this.getPontos().length; i++){

            if(this.getPontos()[i].getX() < menorX) menorX = this.getPontos()[i].getX();
            if(this.getPontos()[i].getX() > maiorX) maiorX = this.getPontos()[i].getX();
            if(this.getPontos()[i].getY() < menorY) menorY = this.getPontos()[i].getY();
            if(this.getPontos()[i].getY() > maiorY) maiorY = this.getPontos()[i].getY();
        }


        double menorComidaX = 1000000.0;
        double maiorComidaX = -1.0;
        double menorComidaY = 1000000.0;
        double maiorComidaY = -1.0;

        for(int i = 0; i<quadrado.getPontos().length; i++){

            if(quadrado.getPontos()[i].getX() < menorComidaX) menorComidaX = quadrado.getPontos()[i].getX();
            if(quadrado.getPontos()[i].getX() > maiorComidaX) maiorComidaX = quadrado.getPontos()[i].getX();
            if(quadrado.getPontos()[i].getY() < menorComidaY) menorComidaY = quadrado.getPontos()[i].getY();
            if(quadrado.getPontos()[i].getY() > maiorComidaY) maiorComidaY = quadrado.getPontos()[i].getY();
        }

        if(menorComidaX >= menorX && maiorComidaX <= maiorX && maiorComidaY <= maiorY && menorComidaY >= menorY){
            return true;
        }
        return false;
    }

    @Override
    public Retangulo movimentado(Ponto[] pontos){
        return new Retangulo(pontos);
    }
}