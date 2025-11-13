import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SegmentoRetaTest {

    @Test
    public void testePerpendiculares(){

        Ponto p1 = new Ponto(2, 3);
        Ponto p2 = new Ponto(4,3);
        Ponto p3 = new Ponto(4, 3);
        Ponto p4 = new Ponto(4, 1);
        SegmentoReta r1 = new SegmentoReta(p1, p2);
        SegmentoReta r2 = new SegmentoReta(p3, p4);
        assertEquals(true, r1.perpendiculares(r2));

        Ponto p5 = new Ponto(3, 5);
        Ponto p6 = new Ponto(5, 5);
        Ponto p7 = new Ponto(5, 5);
        Ponto p8 = new Ponto(7, 3);
        SegmentoReta r3 = new SegmentoReta(p5, p6);
        SegmentoReta r4 = new SegmentoReta(p7, p8);
        assertEquals(false, r3.perpendiculares(r4));

        Ponto p9 = new Ponto(6, 2);
        Ponto p10 = new Ponto(8, 2);
        Ponto p11 = new Ponto(6, 1);
        Ponto p12 = new Ponto(8, 1);
        SegmentoReta r5 = new SegmentoReta(p9, p10);
        SegmentoReta r6 = new SegmentoReta(p11, p12);
        assertEquals(false, r5.perpendiculares(r6));

        Ponto p13 = new Ponto(1, 1);
        Ponto p14 = new Ponto(2, 1);
        Ponto p15 = new Ponto(2, 1);
        Ponto p16 = new Ponto(2, 2);
        SegmentoReta r7 = new SegmentoReta(p13, p14);
        SegmentoReta r8 = new SegmentoReta(p15, p16);
        assertEquals(true, r7.perpendiculares(r8));
    }

    @Test
    public void segmentosContidosTeste(){

        Ponto p1 = new Ponto(6,18);
        Ponto p2 = new Ponto(6,6);
        SegmentoReta r1 = new SegmentoReta(p1, p2);
        Ponto p3 = new Ponto(6,14);
        Ponto p4 = new Ponto(6,12);
        SegmentoReta r2 = new SegmentoReta(p3, p4);
        assertTrue(r1.segmentosContidos(r2));

        Ponto p5 = new Ponto(10,18);
        Ponto p6 = new Ponto(22,18);
        SegmentoReta r3 = new SegmentoReta(p5, p6);
        Ponto p7 = new Ponto(14,18);
        Ponto p8 = new Ponto(18,18);
        SegmentoReta r4 = new SegmentoReta(p7, p8);
        assertTrue(r3.segmentosContidos(r4));

        Ponto p9 = new Ponto(10,4);
        Ponto p10 = new Ponto(22,4);
        SegmentoReta r5 = new SegmentoReta(p9, p10);
        Ponto p11 = new Ponto(14,6);
        Ponto p12 = new Ponto(16,6);
        SegmentoReta r6 = new SegmentoReta(p11, p12);
        assertFalse(r5.segmentosContidos(r6));
    }

}