import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class QuadradoTest {

    @Test
    public void testeToString(){
        Ponto[] pontos1 = {new Ponto(2,1), new Ponto(3,1), new Ponto(3,2), new Ponto(2,2)};
        Quadrado q1 = new Quadrado(pontos1);
        assertEquals("Quadrado: [(2,1), (3,1), (3,2), (2,2)]", q1.toString());

        Ponto[] pontos2 = {new Ponto(4,2), new Ponto(4,1), new Ponto(5,1), new Ponto(5,2)};
        Quadrado q2 = new Quadrado(pontos2);
        assertEquals("Quadrado: [(4,2), (4,1), (5,1), (5,2)]", q2.toString());

        Ponto[] pontos3 = {new Ponto(2,4), new Ponto(2,3), new Ponto(3,3), new Ponto(3,4)};
        Quadrado q3 = new Quadrado(pontos3);
        assertEquals("Quadrado: [(2,4), (2,3), (3,3), (3,4)]", q3.toString());
    }
}