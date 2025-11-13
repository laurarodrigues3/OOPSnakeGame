import java.util.Objects;

/**    Classe que representa um ponto.
 @version 1.3 31/03/2024
 @author Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 @inv  O ponto não pode ter coordenadas negativas.
 */
public class Ponto {
    private double x, y;

    /**
     * @param x Abcissa do ponto.
     * @param y Ordenada do ponto.*/
    public Ponto(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * Se pelo menos uma das coordenadas do ponto for negativa, é lançada uma mensagem.
     * @param a Uma das coordenadas do ponto.
     */
    private void check(double a){
        if(a < 0.0){
            System.out.println("Ponto:vi");
            System.exit(0);
        }
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    /**
     * Calcula a distância euclidiana entre dois pontos.
     * @param that O outro ponto para o qual a distância será calculada.
     * @return A distância euclidiana até ao ponto that.
     */
    public double dist(Ponto that){
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    @Override
    public boolean equals(Object objeto){
        Ponto that = (Ponto) objeto;
        if(this.x == that.x && this.y == that.y){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Escreve para um string a maneira correta de guardar as coordenadas de um ponto.
     * @return Uma string com as coordenadas do ponto.
     */
    public String toString(){
        String s = "(" + (int) this.x + "," + (int) this.y + ")";
        return s;
    }

    /**
     * Aplica a rotação a um ponto com base no ângulo de rotação e no ponto sobre o qual se dá a rotação.
     * @param angulo O angulo de rotação.
     * @param that O ponto sobre o qual vai ser feita a rotação.
     * @return Um novo ponto após se efetuar a rotação.
     */
    public Ponto aplicaRotacao(int angulo, Ponto that){
        double ang = Math.toRadians(angulo);

        double xNovo = (this.x - that.x) * Math.cos(ang) - (this.y - that.y) * Math.sin(ang) + that.x;
        double yNovo = (this.x - that.x) * Math.sin(ang) + (this.y - that.y) * Math.cos(ang) + that.y;


        return new Ponto(xNovo, yNovo);
    }

    /**
     * Aplica a translação a um ponto com base no deslocamento dx e dy.
     * @param dx Deslocamento sobre o eixo xx.
     * @param dy Deslocamento sobre o eixo yy.
     * @return Um novo ponto após se efetuar a translação.
     */
    public Ponto aplicaTranslacao(int dx, int dy){
        double xNovo = this.x + dx;
        double yNovo = this.y + dy;

        return new Ponto(xNovo, yNovo);
    }

}
