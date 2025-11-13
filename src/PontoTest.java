import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PontoTest {

    @Test
    public void testeAplicaTranslacao(){

        Ponto p1 = new Ponto(3, 2);
        Ponto p111 = p1.aplicaTranslacao(2, 2);
        assertEquals(true, p111.equals(new Ponto(5, 4)));

        Ponto p2 = new Ponto(4, 1);
        Ponto p222 = p2.aplicaTranslacao(-2, 2);
        assertEquals(true, p222.equals(new Ponto(2, 3)));

        Ponto p3 = new Ponto(4, 4);
        Ponto p333 = p3.aplicaTranslacao(3, 2);
        assertEquals(true, p333.equals(new Ponto(7, 6)));
    }

    @Test
    public void testeAplicaRotacao(){

        Ponto p1 = new Ponto(3, 2);
        Ponto p11 = new Ponto(4, 3);
        Ponto p111 = p1.aplicaRotacao(90, p11);
        assertEquals(true, p111.equals(new Ponto(5, 2)));

        Ponto p2 = new Ponto(4, 1);
        Ponto p22 = new Ponto(5, 3);
        Ponto p222 = p2.aplicaRotacao(-90, p22);
        assertEquals(true, p222.equals(new Ponto(3, 4)));

        Ponto p3 = new Ponto(4, 4);
        Ponto p33 = new Ponto(6, 5);
        Ponto p333 = p3.aplicaRotacao(-180, p33);
        assertEquals(true, p333.equals(new Ponto(8, 6)));
    }

}