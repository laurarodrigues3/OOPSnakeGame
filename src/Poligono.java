import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

/**    Classe que representa um poligono.
 @version 1.10 21/04/2024
 @author Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 @inv O poligono tem de ter pelo menos 3 pontos.
 @inv Não pode haver três pontos consecutivos colineares.
 @inv Não pode haver cruzameno indevido entre arestas do poligono.
 */
public class Poligono {
    private final int LADO = 10;
    private Ponto[] pontos;
    private SegmentoReta[] segmentosReta;

    /**
     * @param pontos Array de pontos que define os vértices do polígono.
     */
    public Poligono(Ponto[] pontos){
        checkTres(pontos);
        this.segmentosReta = checkColinearesECriaSegmentos(pontos);
        checkCruzamento();
        this.pontos = pontos;
    }

    /**
     * Desenha o polígono na tela.
     * @param g O contexto gráfico.
     */
    public void draw(Graphics2D g) {
        int[] xPoints = new int[pontos.length];
        int[] yPoints = new int[pontos.length];

        for (int i = 0; i < pontos.length; i++) {
            xPoints[i] = (int) pontos[i].getX()*LADO;
            yPoints[i] = (int) pontos[i].getY()*LADO;
        }

        g.fillPolygon(xPoints, yPoints, pontos.length);

        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, pontos.length);

    }

    /**
     * Verifica se existe pelo menos três pontos no array, caso não haja é lançada uma mensagem.
     * @param pontos O array de pontos que contém os vértices.
     */
    private void checkTres(Ponto[] pontos){
        if(pontos.length <= 2){
            System.out.println("Poligono:vi");
            System.exit(0);
        }
    }

    /**
     * Verifica se existe três pontos consecutivos colineares, caso haja é lançada uma mensagem e cria segmentos de reta.
     * São criadas retas para proceder à verificaçao.
     * @param pontos O array de pontos que contém os vértices.
     * @return Os segmentos de reta criados a partir do array de pontos.
     */
    private SegmentoReta[] checkColinearesECriaSegmentos(Ponto[] pontos){
        SegmentoReta[] segmentos = new SegmentoReta[pontos.length];
        for(int i=0; i<pontos.length; i++){
            Reta reta = new Reta(pontos[i], pontos[(i+1) % pontos.length]);
            if(reta.check(pontos[(i+2) % pontos.length])){
                System.out.println("Poligono:vi");
                System.exit(0);
            }
            segmentos[i] = new SegmentoReta(pontos[i],pontos[(i+1) % pontos.length]);
        }
        return segmentos;
    }


    /**
     * Se houver cruzamento entre os segmentos de reta do poligono é lançada uma mensagem.
     */
    private void checkCruzamento(){
        for(int i=0; i<segmentosReta.length; i++){
            if(segmentosReta[i].verificaCruzamento(segmentosReta[(i + 2) % segmentosReta.length])){
                System.out.println("Poligono:vi");
                System.exit(0);
            }
        }
    }

    public Ponto[] getPontos(){
        return this.pontos;
    }

    public void setPontos(Ponto[] pontos){
        this.pontos = pontos;
    }

    public SegmentoReta[] getSegmentosReta(){
        return this.segmentosReta;
    }

    /**
     * Calcula o perimetro de um poligono.
     * @return O valor do perímetro.
     */
    public double perimetro(){
        double perimetro = 0;
        for(int i=0; i< segmentosReta.length; i++){
            perimetro += segmentosReta[i].getTamanho();
        }
        return perimetro;
    }

    /**
     * Forma uma string especificando os vértices do polígono.
     * @return Uma string a dizer que é um polígono de N vértices e diz quais são os vértices.
     */
    public String toString(){
        int vertices = this.pontos.length;
        String s = "Poligono de " + vertices + " vertices: [";
        for(int i=0; i < this.pontos.length; i++){
            if(i == (this.pontos.length - 1)){
                s += this.pontos[i].toString() + "]";
            }
            else {
                s += this.pontos[i].toString() + ", ";
            }
        }
        return s;
    }

    /**
     * Verifica se existe cruzamento entre as arestas de dois polígonos.
     * caso exista cruzamento imprime true, false caso contrário.
     * @param that O polígono que vai ser utilizado para verificação.
     */
    public boolean verificaIntersecao(Poligono that){
        for(int i=0; i<this.segmentosReta.length; i++){
            for(int j=0; j<that.segmentosReta.length; j++){
                if(this.segmentosReta[i].verificaCruzamento(that.segmentosReta[j])){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object objeto){
        Poligono that = (Poligono) objeto;

        if(this.pontos.length != that.pontos.length){
            return false;
        }

        int contador = 0;
        for(int i=0; i<this.pontos.length; i++){
            for(int j=0; j<that.pontos.length; j++){
                if(this.pontos[i].equals(that.pontos[j])){
                    contador++;
                }
            }
        }

        if(contador == this.pontos.length){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(pontos));
    }

    /**
     * Aplica a rotação aos pontos do polígono com base no ângulo.
     * @param angulo O angulo de rotação.
     * @param ponto O ponto sobre o qual vai ser feita a rotação.
     * @return Uma chamada para a função movimentado que, por sua vez, retorna um novo polígono.
     */
    public Poligono rotacao(int angulo, Ponto ponto){
        Ponto[] p = new Ponto[this.pontos.length];
        for(int i=0; i<this.pontos.length; i++){
            p[i] = this.pontos[i].aplicaRotacao(angulo, ponto);
        }
        return movimentado(p);
    }

    /**
     * Retorna um novo polígono que sofreu rotação ou translação.
     * @param pontos O array de pontos que sofreu rotação.
     * @return Um novo polígono.
     */
    protected Poligono movimentado(Ponto[] pontos){
        return new Poligono(pontos);
    }

    /**
     * Calcula o centroide de um polígono.
     * @return Um ponto que corresponde ao centroide do polígono.
     */
    public Ponto centroide(){
        double xC = 0.0;
        double yC = 0.0;
        for(int i=0; i< this.pontos.length; i++){
            xC += this.pontos[i].getX();
            yC += this.pontos[i].getY();
        }
        xC = xC / this.pontos.length;
        yC = yC / this.pontos.length;

        return new Ponto(xC, yC);
    }

    /**
     * Calcula o centroide do polígono e retorna as coordenadas como um array de doubles.
     * @return Um array de doubles contendo as coordenadas x e y do centroide, respectivamente.
     */
    public Double[] centroideList(){
        double xC = 0.0;
        double yC = 0.0;
        for(int i=0; i< this.pontos.length; i++){
            xC += this.pontos[i].getX();
            yC += this.pontos[i].getY();
        }
        xC = xC / this.pontos.length;
        yC = yC / this.pontos.length;

        Double[] result = new Double[2];
        result[0]=xC;
        result[1]=yC;
        return result;
    }

    /**
     * Calcula a distância entre os dois primeiros pontos do polígono.
     * @return A distância entre os dois primeiros pontos do polígono.
     */
    public int DistPoints()
    {
        Ponto p1 = this.pontos[0];
        Ponto p2 = this.pontos[1];
        int dist = (int) p1.dist(p2);

        return dist;
    }

    /**
     * Translada os pontos do quadrado de forma que o novo centroide seja (xC, yC).
     * @param xC A coordenada x do novo centroide.
     * @param yC A coordenada y do novo centroide.
     * @return Um novo quadrado transladado.
     */
    public Quadrado translateToNewCentroid(int xC, int yC) {
        Ponto centroideAtual = centroide();
        double deltaX = xC - centroideAtual.getX();
        double deltaY = yC - centroideAtual.getY();

        Ponto[] pontosAtualizados = new Ponto[this.pontos.length];
        for (int i = 0; i < this.pontos.length; i++) {
            double novoX = this.pontos[i].getX() + deltaX;
            double novoY = this.pontos[i].getY() + deltaY;
            pontosAtualizados[i] = new Ponto(novoX, novoY);
        }

        return new Quadrado(pontosAtualizados);
    }

    /**
     * Aplica a translação aos pontos do polígono com base no deslocamento dx e dy.
     * @param dx Deslocamento em relação ao eixo xx.
     * @param dy Deslocamento em relação ao eixo yy.
     * @return Uma chamada para a função movimentado que, por sua vez, retorna um novo polígono.
     */
    public Poligono translacao(int dx, int dy){
        Ponto[] p = new Ponto[this.pontos.length];
        for(int i=0; i<this.pontos.length; i++){
            p[i] = this.pontos[i].aplicaTranslacao(dx, dy);
        }
        return movimentado(p);
    }

    /**
     * Aplica a translação aos pontos do polígono de maneira que o seu centroide passe a ser (xC,yC).
     * @param xC Abcissa do novo centroide.
     * @param yC Coordenada do novo centroide.
     * @return Uma chamada para a função translação que, por sua vez, retorna um novo polígono.
     */
    public Poligono novoCentroide(int xC, int yC){
        Ponto centroideAntigo = centroide();
        double vetorX = xC - centroideAntigo.getX();
        double vetorY = yC - centroideAntigo.getY();
        return translacao((int) vetorX, (int) vetorY);
    }
}