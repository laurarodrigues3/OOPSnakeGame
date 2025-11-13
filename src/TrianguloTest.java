import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrianguloTest {

    @Test
    public void testeToString(){

        Ponto[] pontos1 = {new Ponto(1,0), new Ponto(2,1), new Ponto(3,0)};
        Triangulo t1 = new Triangulo(pontos1);
        assertEquals("Triangulo: [(1,0), (2,1), (3,0)]", t1.toString());

        Ponto[] pontos2 = {new Ponto(0,1), new Ponto(2,3), new Ponto(2,1)};
        Triangulo t2 = new Triangulo(pontos2);
        assertEquals("Triangulo: [(0,1), (2,3), (2,1)]", t2.toString());

        Ponto[] pontos3 = {new Ponto(3,1), new Ponto(3,0), new Ponto(4,0)};
        Triangulo t3 = new Triangulo(pontos3);
        assertEquals("Triangulo: [(3,1), (3,0), (4,0)]", t3.toString());
    }

}