import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RetanguloTest {

    @Test
    public void testeToString(){

        Ponto[] pontos1 = {new Ponto(1,1), new Ponto(3,1), new Ponto(3,2), new Ponto(1,2)};
        Retangulo r1 = new Retangulo(pontos1);
        assertEquals("Retangulo: [(1,1), (3,1), (3,2), (1,2)]", r1.toString());

        Ponto[] pontos2 = {new Ponto(4,2), new Ponto(4,0), new Ponto(5,0), new Ponto(5,2)};
        Retangulo r2 = new Retangulo(pontos2);
        assertEquals("Retangulo: [(4,2), (4,0), (5,0), (5,2)]", r2.toString());

        Ponto[] pontos3 = {new Ponto(2,4), new Ponto(2,3), new Ponto(4,3), new Ponto(4,4)};
        Retangulo r3 = new Retangulo(pontos3);
        assertEquals("Retangulo: [(2,4), (2,3), (4,3), (4,4)]", r3.toString());
    }


    @Test
    public void testeIntersetaRetangulo(){

        /**
         * Teste 1: Os retângulos intersetam-se.
         * Neste teste, os retângulos estão sobrepostos, logo há interseção.
         */
        Ponto[] pontosRetangulo1 = {new Ponto(8,8), new Ponto(8,2), new Ponto(2,8), new Ponto(2,2)};
        Ponto[] pontosRetangulo2 = {new Ponto(12,10), new Ponto(12,6), new Ponto(6,10), new Ponto(6,6)};
        assertEquals(true, new Retangulo(pontosRetangulo1).intersetaRetangulo(new Retangulo(pontosRetangulo2)));

        /**
         * Teste 2: Os retângulos intersetam-se.
         * Neste teste, os retângulos estão sobrepostos, logo há interseção.
         */
        Ponto[] pontosRetangulo3 = {new Ponto(4,3), new Ponto(4,1), new Ponto(1,3), new Ponto(1,1)};
        Ponto[] pontosRetangulo4 = {new Ponto(4,2), new Ponto(4,1), new Ponto(2,2), new Ponto(2,1)};
        assertEquals(true, new Retangulo(pontosRetangulo3).intersetaRetangulo(new Retangulo(pontosRetangulo4)));

        /**
         * Teste 3: Os retângulos não se intersetam.
         * Neste teste, os retângulos estão completamente separados, logo não há interseção.
         */
        Ponto[] pontosRetangulo5 = {new Ponto(3,2), new Ponto(3,1), new Ponto(1,2), new Ponto(1,1)};
        Ponto[] pontosRetangulo6 = {new Ponto(4,3), new Ponto(4,2), new Ponto(2,3), new Ponto(2,2)};
        assertEquals(false, new Retangulo(pontosRetangulo5).intersetaRetangulo(new Retangulo(pontosRetangulo6)));

        /**
         * Teste 4: Os retângulos não se intersetam.
         * Neste teste, os retângulos estão completamente separados, logo não há interseção.
         */
        Ponto[] pontosRetangulo7 = {new Ponto(4,1), new Ponto(4,0), new Ponto(1,1), new Ponto(1,0)};
        Ponto[] pontosRetangulo8 = {new Ponto(3,5), new Ponto(3,3), new Ponto(2,5), new Ponto(2,3)};
        assertEquals(false, new Retangulo(pontosRetangulo7).intersetaRetangulo(new Retangulo(pontosRetangulo8)));

        /**
         * Teste 5: Os retângulos intersetam-se.
         * Neste teste, os retângulos estão sobrepostos, logo há interseção.
         */
        Ponto[] pontosRetangulo9 = {new Ponto(1, 1), new Ponto(1, 3), new Ponto(3, 3), new Ponto(3, 1)};
        Ponto[] pontosRetangulo10 = {new Ponto(2, 2), new Ponto(2, 4), new Ponto(4, 4), new Ponto(4, 2)};
        assertEquals(true, new Retangulo(pontosRetangulo9).intersetaRetangulo(new Retangulo(pontosRetangulo10)));

        /**
         * Teste 6: Os retângulos não se intersetam.
         * Neste teste, os retângulos estão completamente separados, logo não há interseção.
         */
        Ponto[] pontosRetangulo11 = {new Ponto(1, 1), new Ponto(1, 3), new Ponto(3, 3), new Ponto(3, 1)};
        Ponto[] pontosRetangulo12 = {new Ponto(4, 4), new Ponto(4, 6), new Ponto(6, 6), new Ponto(6, 4)};
        assertEquals(false, new Retangulo(pontosRetangulo11).intersetaRetangulo(new Retangulo(pontosRetangulo12)));

        /**
         * Teste 7: Os retângulos não se intersetam.
         * Neste teste, os retângulos estão completamente separados, logo não há interseção.
         */
        Ponto[] pontosRetangulo13 = {new Ponto(1, 1), new Ponto(1, 3), new Ponto(3, 3), new Ponto(3, 1)};
        Ponto[] pontosRetangulo14 = {new Ponto(3, 1), new Ponto(3, 4), new Ponto(5, 4), new Ponto(5, 1)};
        assertEquals(false, new Retangulo(pontosRetangulo13).intersetaRetangulo(new Retangulo(pontosRetangulo14)));

        /**
         * Teste 8: Os retângulos não se intersetam.
         * Neste teste, os retângulos estão completamente separados, logo não há interseção.
         */
        Ponto[] pontosRetangulo15 = {new Ponto(1, 1), new Ponto(1, 3), new Ponto(3, 3), new Ponto(3, 1)};
        Ponto[] pontosRetangulo16 = {new Ponto(3, 1), new Ponto(3, 5), new Ponto(5, 5), new Ponto(5, 1)};
        assertEquals(false, new Retangulo(pontosRetangulo15).intersetaRetangulo(new Retangulo(pontosRetangulo16)));

        /**
         * Teste 9: Os retângulos não se intersetam.
         * Neste teste, os retângulos estão completamente separados, logo não há interseção.
         */
        Ponto[] pontosRetangulo17 = {new Ponto(4,1), new Ponto(4,0), new Ponto(1,1), new Ponto(1,0)};
        Ponto[] pontosRetangulo18 = {new Ponto(3,5), new Ponto(3,3), new Ponto(2,5), new Ponto(2,3)};
        assertEquals(false, new Retangulo(pontosRetangulo17).intersetaRetangulo(new Retangulo(pontosRetangulo18)));

        /**
         * Teste 10: Os retângulos intersetam-se.
         * Neste teste, os retângulos estão sobrepostos, logo há interseção.
         */
        Ponto[] pontosRetangulo19 = {new Ponto(1, 1), new Ponto(1, 3), new Ponto(3, 3), new Ponto(3, 1)};
        Ponto[] pontosRetangulo20 = {new Ponto(2, 2), new Ponto(2, 4), new Ponto(4, 4), new Ponto(4, 2)};
        assertEquals(true, new Retangulo(pontosRetangulo19).intersetaRetangulo(new Retangulo(pontosRetangulo20)));

        /**
         * Teste 11: Os retângulos não se intersetam.
         * Neste teste, os retângulos estão completamente separados, logo não há interseção.
         */
        Ponto[] pontosRetangulo21 = {new Ponto(1, 1), new Ponto(1, 3), new Ponto(3, 3), new Ponto(3, 1)};
        Ponto[] pontosRetangulo22 = {new Ponto(4, 4), new Ponto(4, 6), new Ponto(6, 6), new Ponto(6, 4)};
        assertEquals(false, new Retangulo(pontosRetangulo21).intersetaRetangulo(new Retangulo(pontosRetangulo22)));

        /**
         * Teste 12: Os retângulos não se intersetam.
         * Neste teste, os retângulos estão completamente separados, logo não há interseção.
         */
        Ponto[] pontosRetangulo23 = {new Ponto(1, 1), new Ponto(1, 3), new Ponto(3, 3), new Ponto(3, 1)};
        Ponto[] pontosRetangulo24 = {new Ponto(3, 1), new Ponto(3, 4), new Ponto(5, 4), new Ponto(5, 1)};
        assertEquals(false, new Retangulo(pontosRetangulo23).intersetaRetangulo(new Retangulo(pontosRetangulo24)));

        /**
         * Teste 13: Os retângulos não se intersetam.
         * Neste teste, os retângulos estão completamente separados, logo não há interseção.
         */
        Ponto[] pontosRetangulo25 = {new Ponto(1, 1), new Ponto(1, 3), new Ponto(3, 3), new Ponto(3, 1)};
        Ponto[] pontosRetangulo26 = {new Ponto(3, 1), new Ponto(3, 5), new Ponto(5, 5), new Ponto(5, 1)};
        assertEquals(false, new Retangulo(pontosRetangulo25).intersetaRetangulo(new Retangulo(pontosRetangulo26)));

        /**
         * Teste 14: Os retângulos têm apenas um vértice sobreposto.
         * Neste teste, um dos vértices de um retângulo está sobreposto a um dos vértices do outro retângulo.
         * Apesar dos retângulos se tocarem, considera-se que não houve sobreposição.
         */
        Ponto[] pontosRetangulo27 = {new Ponto(1, 1), new Ponto(1, 3), new Ponto(3, 3), new Ponto(3, 1)};
        Ponto[] pontosRetangulo28 = {new Ponto(3, 3), new Ponto(3, 5), new Ponto(5, 5), new Ponto(5, 3)};
        assertEquals(false, new Retangulo(pontosRetangulo27).intersetaRetangulo(new Retangulo(pontosRetangulo28)));

        /**
         * Teste 15: Os retângulos têm apenas um vértice sobreposto.
         * Neste teste, um dos vértices de um retângulo está sobreposto a um dos vértices do outro retângulo.
         * Apesar dos retângulos se tocarem, considera-se que não houve sobreposição.
         */
        Ponto[] pontosRetangulo29 = {new Ponto(1, 1), new Ponto(1, 3), new Ponto(3, 3), new Ponto(3, 1)};
        Ponto[] pontosRetangulo30 = {new Ponto(3, 1), new Ponto(3, 4), new Ponto(5, 4), new Ponto(5, 1)};
        assertEquals(false, new Retangulo(pontosRetangulo29).intersetaRetangulo(new Retangulo(pontosRetangulo30)));

        /**
         * Teste 16: Os retângulos têm apenas uma aresta sobreposta.
         * Neste teste, um dos vértices de um retângulo está contido num dos lados do outro retângulo.
         * Apesar dos retângulos se tocarem, considera-se que não houve sobreposição.
         */
        Ponto[] pontosRetangulo31 = {new Ponto(0,0), new Ponto(0,2), new Ponto(2,2), new Ponto(2,0)};
        Ponto[] pontosRetangulo32 = {new Ponto(2,0), new Ponto(2,2), new Ponto(4,2), new Ponto(4,0)};
        assertEquals(false, new Retangulo(pontosRetangulo31).intersetaRetangulo(new Retangulo(pontosRetangulo32)));

        /**
         * Teste 17: Os retângulos têm apenas uma aresta sobreposta.
         * Neste teste, um dos vértices de um retângulo está contido num dos lados do outro retângulo.
         * Apesar dos retângulos se tocarem, considera-se que não houve sobreposição.
         */
        Ponto[] pontosRetangulo33 = {new Ponto(1,1), new Ponto(1,3), new Ponto(3,3), new Ponto(3,1)};
        Ponto[] pontosRetangulo34 = {new Ponto(3,1), new Ponto(3,3), new Ponto(5,3), new Ponto(5,1)};
        assertEquals(false, new Retangulo(pontosRetangulo33).intersetaRetangulo(new Retangulo(pontosRetangulo34)));
    }


}