/**    Classe que representa uma reta.
 @version 1.0 26/02/2024
 @author Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 @inv  A reta tem de ter pelo menos dois pontos distintos.
 */
public class Reta {
    private Ponto p1, p2;
    private double declive, ordenadaOrigem;

    /**
     * @param p1 O primeiro ponto da reta.
     * @param p2 O segundo ponto da reta.
     */
    public Reta(Ponto p1, Ponto p2){
        checkIguais(p1, p2);
        this.p1 = p1;
        this.p2 = p2;
        this.declive = declive(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        this.ordenadaOrigem = ordenada(p1.getX(), p1.getY(), declive);
    }

    /**
     * Se os pontos forem iguais, é lançada uma mensagem.
     * @param p1 O primeiro ponto para verificação.
     * @param p2 O segundo ponto para verificação.
     */
    private void checkIguais(Ponto p1, Ponto p2){
        if(p1.getX() == p2.getX() && p1.getY() == p2.getY()){
            System.out.println("Reta:vi");
            System.exit(0);
        }
    }

    /**
     * Calcula o declive da reta.
     * @param p1X A abcissa do primeiro ponto da reta.
     * @param p1Y A ordenada do primeiro ponto da reta.
     * @param p2X A abcissa do segundo ponto da reta.
     * @param p2Y A ordenada do segundo ponto da reta.
     * @return O declive da reta.
     */
    private double declive(double p1X, double p1Y, double p2X, double p2Y){
        double y = p2Y - p1Y;
        double x = p2X - p1X;
        return y/x;
    }

    /**
     * Calcula a ordenada na origem da reta, utilizando um ponto e o seu declive.
     * @param p1X A abcissa do primeiro ponto da reta.
     * @param p1Y A ordenada do primeiro ponto da reta.
     * @param declive O declive da reta.
     * @return A ordenada na origem da reta.
     */
    private double ordenada(double p1X, double p1Y, double declive){
        return (p1Y - (declive * p1X));
    }

    /**
     * Verifica se o ponto recebido pertence à reta.
     * @param p O ponto a ser verificado.
     * @return True caso o ponto pertença à reta, false caso não pertença.
     */
    public boolean check(Ponto p){
        double y = (declive * p.getX()) + ordenadaOrigem;
        if(y == p.getY()){
            return true;
        }
        return false;
    }
}
