package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TankTest {

    Tank tank;

    @BeforeEach
    void setUp() {
        tank = new Tank();
    }

    @AfterEach
    void tearDown() {
        tank = null;
    }

    @Test
    void balra() {
        tank.setSzog(270);
        tank.setIrany("bal");
        assertEquals("bal", tank.getIrany());
        assertEquals(270, tank.getSzog());

        tank.setPozicioX(30);
        tank.balra(2);
        assertEquals(28, tank.getPozicioX());

        tank.setPozicioX(30);
        if (tank.getPozicioX() > 0){
            tank.setPozicioX(tank.getPozicioX() - 2);
        }
        assertEquals(28, tank.getPozicioX());

        tank.setPozicioX(0);
        if (tank.getPozicioX() > 0){
            tank.setPozicioX(tank.getPozicioX() - 2);
        }
        assertEquals(0, tank.getPozicioX());
    }

    @Test
    void jobbra() {
        tank.setPalyaSzelesseg(832);
        tank.setSzelesseg(56);

        tank.setSzog(90);
        tank.setIrany("jobb");
        assertEquals("jobb", tank.getIrany());
        assertEquals(90, tank.getSzog());

        tank.setPozicioX(30);
        tank.jobbra(2);
        assertEquals(32, tank.getPozicioX());

        tank.setPozicioX(700);
        if (tank.getPozicioX() < tank.getPalyaSzelesseg() - tank.getSzelesseg()){
            tank.setPozicioX(tank.getPozicioX() + 2);
        }
        assertEquals(702, tank.getPozicioX());

        tank.setPozicioX(776);
        if (tank.getPozicioX() < tank.getPalyaSzelesseg() - tank.getSzelesseg()){
            tank.setPozicioX(tank.getPozicioX() + 2);
        }
        assertEquals(776, tank.getPozicioX());
    }

    @Test
    void fel() {
        tank.setSzog(0);
        tank.setIrany("fel");
        assertEquals("fel", tank.getIrany());
        assertEquals(0, tank.getSzog());

        tank.setPozicioY(30);
        tank.fel(2);
        assertEquals(28, tank.getPozicioY());

        tank.setPozicioY(30);
        if (tank.getPozicioY() > 0){
            tank.setPozicioY(tank.getPozicioY() - 2);
        }
        assertEquals(28, tank.getPozicioY());

        tank.setPozicioY(0);
        if (tank.getPozicioY() > 0){
            tank.setPozicioY(tank.getPozicioY() - 2);
        }
        assertEquals(0, tank.getPozicioY());
    }

    @Test
    void le() {
        tank.setPalyaMagassag(832);
        tank.setMagassag(56);

        tank.setSzog(180);
        tank.setIrany("le");
        assertEquals("le", tank.getIrany());
        assertEquals(180, tank.getSzog());

        tank.setPozicioY(30);
        tank.le(2);
        assertEquals(32, tank.getPozicioY());

        tank.setPozicioY(700);
        if (tank.getPozicioY() < tank.getPalyaMagassag() - tank.getMagassag()){
            tank.setPozicioY(tank.getPozicioY() + 2);
        }
        assertEquals(702, tank.getPozicioY());

        tank.setPozicioY(776);
        if (tank.getPozicioY() < tank.getPalyaMagassag() - tank.getMagassag()){
            tank.setPozicioY(tank.getPozicioY() + 2);
        }
        assertEquals(776, tank.getPozicioY());
    }

    @Test
    public void gettersetterTest(){
        tank.setPozicioX(30);
        assertEquals(30, tank.getPozicioX());
        tank.setPozicioY(30);
        assertEquals(30, tank.getPozicioY());
        tank.setMagassag(56);
        assertEquals(56, tank.getMagassag());
        tank.setSzelesseg(56);
        assertEquals(56, tank.getSzelesseg());
        tank.setIrany("le");
        assertEquals("le", tank.getIrany());
        tank.setPalyaMagassag(300);
        assertEquals(300, tank.getPalyaMagassag());
        tank.setPalyaSzelesseg(300);
        assertEquals(300, tank.getPalyaSzelesseg());
        tank.setSzog(50);
        assertEquals(50, tank.getSzog());
    }
}