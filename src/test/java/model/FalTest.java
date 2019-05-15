package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FalTest {

    Fal fal;

    @BeforeEach
    void setUp() {
        fal = new Fal();
    }

    @AfterEach
    void tearDown() {
        fal = null;
    }

    @Test
    void gettersetterTest(){
        fal.setPozicioX(30);
        assertEquals(30, fal.getPozicioX());
        fal.setPozicioY(30);
        assertEquals(30, fal.getPozicioY());
        fal.setMagassag(56);
        assertEquals(56, fal.getMagassag());
        fal.setSzelesseg(56);
        assertEquals(56, fal.getSzelesseg());
    }
}