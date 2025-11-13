/**    Classe que representa um segmento de reta.
 @version 1.1 29/03/2024
 @author Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 @inv  O segmento de reta tem de ter pelo menos dois pontos distinto.
 */
public class SegmentoReta {
    private Ponto p1, p2;
    private double tamanho;

    /**
     * @param p1 O primeiro ponto do segmento de reta.
     * @param p2 O segundo ponto do segmento de reta.
     */
    public SegmentoReta(Ponto p1, Ponto p2) {
        checkIguais(p1, p2);
        this.p1 = p1;
        this.p2 = p2;
        this.tamanho = p1.dist(p2);
    }

    /**
     * Se os pontos forem iguais, é lançada uma mensagem.
     *
     * @param p1 O primeiro ponto para verificação.
     * @param p2 O segundo ponto para verificação.
     */
    private void checkIguais(Ponto p1, Ponto p2) {
        if (p1.getX() == p2.getX() && p1.getY() == p2.getY()) {
            System.out.println("Segment:vi");
            System.exit(0);
        }
    }

    public double getTamanho() {
        return this.tamanho;
    }

    /**
     * Verifica se existe cruzamento entre dois segmentos de reta.
     *
     * @param that O outro segmento de reta para verificação.
     * @return True caso exista cruzamento entre os dois segmentos de reta, false caso não exista.
     */
    public boolean verificaCruzamento(SegmentoReta that) {
        double inicioInicio = produtoVetorial(this.p2, this.p1, that.p1);
        double inicioFim = produtoVetorial(this.p2, this.p1, that.p2);
        double fimInicio = produtoVetorial(that.p2, that.p1, this.p1);
        double fimFim = produtoVetorial(that.p2, that.p1, this.p2);
        if (inicioInicio * inicioFim < 0 && fimInicio * fimFim < 0) {
            return true;
        }
        return false;
    }

    public Ponto getP1() {
        return p1;
    }

    public Ponto getP2() {
        return p2;
    }

    /**
     * Calcula o produto vetorial entre três pontos.
     *
     * @param p1 O primeiro ponto para verificação.
     * @param p2 O segundo ponto para verificação.
     * @param p3 O terceiro ponto para verificação.
     * @return O cálculo do produto vetorial entre três pontos.
     */
    private double produtoVetorial(Ponto p1, Ponto p2, Ponto p3) {
        return (p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) - (p2.getY() - p1.getY()) * (p3.getX() - p1.getX());
    }

    /**
     * Verifica se dois segmentos de reta são perpendiculares.
     *
     * @param that O segundo segemnto de reta para verificação.
     * @return True caso os segmentos sejam perpendiculares, false caso contrário.
     */
    public boolean perpendiculares(SegmentoReta that) {
        double x1 = this.p2.getX() - this.p1.getX();
        double y1 = this.p2.getY() - this.p1.getY();
        double x2 = that.p2.getX() - that.p1.getX();
        double y2 = that.p2.getY() - that.p1.getY();

        double produtoEscalar = (x1 * x2) + (y1 * y2);

        if (produtoEscalar == 0.0) return true;

        return false;
    }

    public boolean segmentosContidos(SegmentoReta that) {
        return false;
    }

}


