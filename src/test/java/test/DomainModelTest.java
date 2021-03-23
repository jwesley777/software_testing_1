package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import part3.Aerocar;
import part3.Human;
import part3.Room;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DomainModelTest {
    Room hall;
    Human pupa;
    Aerocar pupaCar;
    Human lupa;
    Aerocar lupaCar;
    Aerocar dupaCar;
    Aerocar car4;

    @BeforeEach
    void setUp() {
        hall = new Room(228);
        pupa = new Human("pupa");
        lupa = new Human("lupa");
        pupaCar = new Aerocar(137);
        lupaCar = new Aerocar(1337);
        dupaCar = new Aerocar(80);
        car4 = new Aerocar(90);
    }

    @Test
    void containerTest() {
        assertFalse(hall.contains(pupaCar));
        hall.putThing(pupaCar);
        assertTrue(hall.contains(pupaCar));
        hall.putThing(pupaCar);
        hall.extractThing(pupaCar);
        assertFalse(hall.contains(pupaCar));
    }
    @Test
    void containerSizingTest() {
        assertFalse(hall.putThing(lupaCar));
        assertFalse(hall.contains(lupaCar));
        assertTrue(hall.putThing(pupaCar));
        assertTrue(hall.contains(pupaCar));
        assertTrue(hall.putThing(dupaCar));
        assertTrue(hall.contains(dupaCar));
        assertFalse(hall.putThing(car4));
        assertFalse(hall.contains(car4));
    }
    @Test
    void passengerTest() {
        assertTrue(pupaCar.putPassenger(lupa));
        assertEquals(pupaCar.getPassenger(),lupa);
        assertFalse(pupaCar.putPassenger(pupa));
        assertNotEquals(pupaCar.getPassenger(),pupa);
        assertEquals(pupaCar.getPassenger(),lupa);
        pupaCar.extractPassenger();
        assertTrue(pupaCar.putPassenger(pupa));
        assertEquals(pupaCar.getPassenger(),pupa);
        assertNotEquals(pupaCar.getPassenger(),lupa);

    }

    @AfterEach
    void tearDown() {
        hall = null;
        pupa = null;
        lupa = null;
        pupaCar = null;
        lupaCar = null;
    }
}
