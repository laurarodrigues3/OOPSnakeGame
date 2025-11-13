import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PoligonoTest {

    @Test
    public void testeNovoCentroide(){

        Ponto[] pontos2 = {new Ponto(2,3), new Ponto(4,3), new Ponto(4,5), new Ponto(2,5)};
        Quadrado q2 = new Quadrado(pontos2);
        Ponto[] pt2 = {new Ponto(6,8), new Ponto(8,8), new Ponto(8,6), new Ponto(6,6)};
        Quadrado q22 = new Quadrado(pt2);
        Quadrado q222 = (Quadrado) q2.novoCentroide(7, 7);
        assertEquals(true, q22.equals(q222));

        Ponto[] pontos3 = {new Ponto(5,7), new Ponto(7,5), new Ponto(5,3), new Ponto(3,5)};
        Quadrado q3 = new Quadrado(pontos3);
        Ponto[] pt3 = {new Ponto(10,5), new Ponto(8,3), new Ponto(10,1), new Ponto(12,3)};
        Quadrado q33 = new Quadrado(pt3);
        Quadrado q333 = (Quadrado) q3.novoCentroide(10, 3);
        assertEquals(true, q33.equals(q333));
    }

    @Test
    public void testeTranslacao(){

        Ponto[] pontos1 = {new Ponto(4,2), new Ponto(4,0), new Ponto(5,0), new Ponto(5,2)};
        Retangulo r1 = new Retangulo(pontos1);
        Ponto[] pt1 = {new Ponto(5,2), new Ponto(5,0), new Ponto(6,0), new Ponto(6,2)};
        Retangulo r11 = new Retangulo(pt1);
        Retangulo r111 = (Retangulo) r1.translacao(1, 0);
        assertEquals(true, r11.equals(r111));

        Ponto[] pontos2 = {new Ponto(2,4), new Ponto(2,3), new Ponto(3,3), new Ponto(3,4)};
        Quadrado q2 = new Quadrado(pontos2);
        Ponto[] pt2 = {new Ponto(4,6), new Ponto(4,5), new Ponto(5,5), new Ponto(5,6)};
        Quadrado q22 = new Quadrado(pt2);
        Quadrado q222 = (Quadrado) q2.translacao(2, 2);
        assertEquals(true, q22.equals(q222));

        Ponto[] pontos3 = {new Ponto(2,3), new Ponto(2,2), new Ponto(3,2)};
        Triangulo t3 = new Triangulo(pontos3);
        Ponto[] pt3 = {new Ponto(3,2), new Ponto(3,1), new Ponto(4,1)};
        Triangulo t33 = new Triangulo(pt3);
        Triangulo t333 = (Triangulo) t3.translacao(1, -1);
        assertEquals(true, t33.equals(t333));

    }

    @Test
    public void testeCentroide(){

        Ponto[] pontos1 = {new Ponto(4,2), new Ponto(4,0), new Ponto(5,0), new Ponto(5,2)};
        Retangulo r1 = new Retangulo(pontos1);
        Ponto c1 = new Ponto(4.5,1);
        Ponto c11 = r1.centroide();
        assertEquals(true, c1.equals(c11));

        Ponto[] pontos2 = {new Ponto(2,4), new Ponto(2,3), new Ponto(3,3), new Ponto(3,4)};
        Quadrado q2 = new Quadrado(pontos2);
        Ponto c2 = new Ponto(2.5,3.5);
        Ponto c22 = q2.centroide();
        assertEquals(true, c2.equals(c22));
    }

    @Test
    public void testeToString(){

        Ponto[] pontos1 = {new Ponto(0,3), new Ponto(0,4), new Ponto(2,4), new Ponto(2,3)};
        Poligono p1 = new Poligono(pontos1);
        assertEquals("Poligono de 4 vertices: [(0,3), (0,4), (2,4), (2,3)]", p1.toString());

        Ponto[] pontos2 = {new Ponto(3,1), new Ponto(4,1), new Ponto(4,0)};
        Poligono p2 = new Poligono(pontos2);
        assertEquals("Poligono de 3 vertices: [(3,1), (4,1), (4,0)]", p2.toString());

        Ponto[] pontos3 = {new Ponto(3,3), new Ponto(3,4), new Ponto(4,5), new Ponto(5,5), new Ponto(6,4), new Ponto(6,3), new Ponto(5,2), new Ponto(4,2)};
        Poligono p3 = new Poligono(pontos3);
        assertEquals("Poligono de 8 vertices: [(3,3), (3,4), (4,5), (5,5), (6,4), (6,3), (5,2), (4,2)]", p3.toString());
    }

    @Test
    public void testeVerificaIntersecao(){

        /**
         * Teste 1: Os polígonos intersetam-se.
         * Neste teste, os polígonos intersetam-se num único ponto.
         */
        Ponto[] pontos1 = {new Ponto(0,3), new Ponto(0,4), new Ponto(2,4), new Ponto(2,3)};
        Ponto[] pontos2 = {new Ponto(0,3), new Ponto(0,5), new Ponto(1,5), new Ponto(1,3)};
        assertEquals(true, new Poligono(pontos1).verificaIntersecao(new Poligono(pontos2)));

        /**
         * Teste 2: Os polígonos intersetam-se.
         * Neste teste, os polígonos intersetam-se numa única aresta.
         */
        Ponto[] pontos3 = {new Ponto(3,3), new Ponto(3,4), new Ponto(4,5), new Ponto(5,5), new Ponto(6,4), new Ponto(6,3), new Ponto(5,2), new Ponto(4,2)};
        Ponto[] pontos4 = {new Ponto(5,4), new Ponto(6,5), new Ponto(7,4), new Ponto(6,3)};
        assertEquals(true, new Poligono(pontos3).verificaIntersecao(new Poligono(pontos4)));

        /**
         * Teste 3: Os polígonos não se intersetam.
         * Neste teste, os polígonos estão completamente separados, logo não há interseção.
         */
        Ponto[] pontos5 = {new Ponto(0,1), new Ponto(2,3), new Ponto(3,2), new Ponto(1,0), new Ponto(1,1)};
        Ponto[] pontos6 = {new Ponto(3,1), new Ponto(4,1), new Ponto(4,0)};
        assertEquals(false, new Poligono(pontos5).verificaIntersecao(new Poligono(pontos6)));

        /**
         * Teste 4: Os polígonos intersetam-se.
         * Neste teste, os polígonos intersetam-se numa única aresta.
         */
        Ponto[] pontos7 = {new Ponto(0,3), new Ponto(0,4), new Ponto(2,4), new Ponto(2,3)};
        Ponto[] pontos8 = {new Ponto(0,3), new Ponto(0,5), new Ponto(1,5), new Ponto(1,3)};
        assertEquals(true, new Poligono(pontos7).verificaIntersecao(new Poligono(pontos8)));

        /**
         * Teste 5: Os polígonos intersetam-se.
         * Neste teste, os polígonos intersetam-se numa única aresta.
         */
        Ponto[] pontos9 = {new Ponto(3,3), new Ponto(3,4), new Ponto(4,5), new Ponto(5,5), new Ponto(6,4), new Ponto(6,3), new Ponto(5,2), new Ponto(4,2)};
        Ponto[] pontos10 = {new Ponto(5,4), new Ponto(6,5), new Ponto(7,4), new Ponto(6,3)};
        assertEquals(true, new Poligono(pontos9).verificaIntersecao(new Poligono(pontos10)));

        /**
         * Teste 6: Os polígonos não se intersetam.
         * Neste teste, os polígonos estão completamente separados, logo não há interseção.
         */
        Ponto[] pontos11 = {new Ponto(0,1), new Ponto(2,3), new Ponto(3,2), new Ponto(1,0), new Ponto(1,1)};
        Ponto[] pontos12 = {new Ponto(3,1), new Ponto(4,1), new Ponto(4,0)};
        assertEquals(false, new Poligono(pontos11).verificaIntersecao(new Poligono(pontos12)));

        /**
         * Teste 7: Os polígonos não se intersetam.
         * Neste teste, os polígonos estão completamente separados, logo não há interseção.
         */
        Ponto[] pontos13 = {new Ponto(0,1), new Ponto(2,3), new Ponto(3,2), new Ponto(1,0), new Ponto(1,1)};
        Ponto[] pontos14 = {new Ponto(3,1), new Ponto(4,1), new Ponto(4,0)};
        assertEquals(false, new Poligono(pontos13).verificaIntersecao(new Poligono(pontos14)));

        /**
         * Teste 8: Os polígonos intersetam-se.
         * Neste teste, os polígonos intersetam-se numa única aresta.
         */
        Ponto[] pontos15 = {new Ponto(0,3), new Ponto(0,4), new Ponto(2,4), new Ponto(2,3)};
        Ponto[] pontos16 = {new Ponto(0,3), new Ponto(0,5), new Ponto(1,5), new Ponto(1,3)};
        assertEquals(true, new Poligono(pontos15).verificaIntersecao(new Poligono(pontos16)));

        /**
         * Teste 9: Os polígonos intersetam-se.
         * Neste teste, os polígonos intersetam-se numa única aresta.
         */
        Ponto[] pontos17 = {new Ponto(3,3), new Ponto(3,4), new Ponto(4,5), new Ponto(5,5), new Ponto(6,4), new Ponto(6,3), new Ponto(5,2), new Ponto(4,2)};
        Ponto[] pontos18 = {new Ponto(5,4), new Ponto(6,5), new Ponto(7,4), new Ponto(6,3)};
        assertEquals(true, new Poligono(pontos17).verificaIntersecao(new Poligono(pontos18)));

        /**
         * Teste 10: Os polígonos não se intersetam.
         * Neste teste, os polígonos estão completamente separados, logo não há interseção.
         */
        Ponto[] pontos19 = {new Ponto(0,1), new Ponto(2,3), new Ponto(3,2), new Ponto(1,0), new Ponto(1,1)};
        Ponto[] pontos20 = {new Ponto(3,1), new Ponto(4,1), new Ponto(4,0)};
        assertEquals(false, new Poligono(pontos19).verificaIntersecao(new Poligono(pontos20)));

        /**
         * Teste 11: Os polígonos intersetam-se.
         * Neste teste, os polígonos estão sobrepostos, logo há interseção.
         */
        Ponto[] pontos21 = {new Ponto(1, 1), new Ponto(3, 1), new Ponto(3, 3), new Ponto(1, 3)};
        Ponto[] pontos22 = {new Ponto(2, 2), new Ponto(4, 2), new Ponto(4, 4), new Ponto(2, 4)};
        assertEquals(true, new Poligono(pontos21).verificaIntersecao(new Poligono(pontos22)));

        /**
         * Teste 12: Os polígonos intersetam-se.
         * Neste teste, os polígonos estão sobrepostos, logo há interseção.
         */
        Ponto[] pontos23 = {new Ponto(1, 1), new Ponto(3, 1), new Ponto(3, 3), new Ponto(1, 3)};
        Ponto[] pontos24 = {new Ponto(2, 2), new Ponto(4, 2), new Ponto(4, 4), new Ponto(2, 3)};
        assertEquals(true, new Poligono(pontos23).verificaIntersecao(new Poligono(pontos24)));


    }
}