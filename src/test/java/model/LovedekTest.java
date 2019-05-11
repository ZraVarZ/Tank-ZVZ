package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LovedekTest {

    Lovedek lovedek;

    @BeforeEach
    void setUp() {
        lovedek = new Lovedek();
    }

    @AfterEach
    void tearDown() {
        lovedek = null;
    }

    @Test
    void balra() {
        lovedek.setPozicioX(30);
        lovedek.balra(8);
        assertEquals(22, lovedek.getPozicioX());

        lovedek.setPozicioX(30);
        if (lovedek.getPozicioX() > 0){
            lovedek.setPozicioX(lovedek.getPozicioX() - 8);
        }
        assertEquals(22, lovedek.getPozicioX());

        lovedek.setPozicioX(0);
        if (lovedek.getPozicioX() > 0){
            lovedek.setPozicioX(lovedek.getPozicioX() - 8);
        }
        assertEquals(0, lovedek.getPozicioX());
    }

    @Test
    void jobbra() {
        lovedek.setPalyaSzelesseg(832);
        lovedek.setSzelesseg(56);

        lovedek.setPozicioX(30);
        lovedek.jobbra(8);
        assertEquals(38, lovedek.getPozicioX());

        lovedek.setPozicioX(700);
        if (lovedek.getPozicioX() < lovedek.getPalyaSzelesseg() - lovedek.getSzelesseg()){
            lovedek.setPozicioX(lovedek.getPozicioX() + 8);
        }
        assertEquals(708, lovedek.getPozicioX());

        lovedek.setPozicioX(776);
        if (lovedek.getPozicioX() < lovedek.getPalyaSzelesseg() - lovedek.getSzelesseg()){
            lovedek.setPozicioX(lovedek.getPozicioX() + 8);
        }
        assertEquals(776, lovedek.getPozicioX());
    }

    @Test
    void fel() {
        lovedek.setPozicioY(30);
        lovedek.fel(8);
        assertEquals(22, lovedek.getPozicioY());

        lovedek.setPozicioY(30);
        if (lovedek.getPozicioY() > 0){
            lovedek.setPozicioY(lovedek.getPozicioY() - 8);
        }
        assertEquals(22, lovedek.getPozicioY());

        lovedek.setPozicioY(0);
        if (lovedek.getPozicioY() > 0){
            lovedek.setPozicioY(lovedek.getPozicioY() - 8);
        }
        assertEquals(0, lovedek.getPozicioY());
    }

    @Test
    void le() {
        lovedek.setPalyaMagassag(832);
        lovedek.setMagassag(56);

        lovedek.setPozicioY(30);
        lovedek.le(8);
        assertEquals(38, lovedek.getPozicioY());

        lovedek.setPozicioY(700);
        if (lovedek.getPozicioY() < lovedek.getPalyaMagassag() - lovedek.getMagassag()){
            lovedek.setPozicioY(lovedek.getPozicioY() + 8);
        }
        assertEquals(708, lovedek.getPozicioY());

        lovedek.setPozicioY(776);
        if (lovedek.getPozicioY() < lovedek.getPalyaMagassag() - lovedek.getMagassag()){
            lovedek.setPozicioY(lovedek.getPozicioY() + 8);
        }
        assertEquals(776, lovedek.getPozicioY());
    }

    @Test
    void gettersetterTest(){
        lovedek.setPozicioX(30);
        assertEquals(30, lovedek.getPozicioX());
        lovedek.setPozicioY(30);
        assertEquals(30, lovedek.getPozicioY());
        lovedek.setMagassag(56);
        assertEquals(56, lovedek.getMagassag());
        lovedek.setSzelesseg(56);
        assertEquals(56, lovedek.getSzelesseg());
        lovedek.setIrany("le");
        assertEquals("le", lovedek.getIrany());
        lovedek.setPalyaMagassag(300);
        assertEquals(300, lovedek.getPalyaMagassag());
        lovedek.setPalyaSzelesseg(300);
        assertEquals(300, lovedek.getPalyaSzelesseg());
    }
}