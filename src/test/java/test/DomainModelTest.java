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
    void emptyContainerTest() {
        assertFalse(hall.contains(pupaCar));
    }
    @Test
    void putThingToEmptyContainerTest() {
        hall.putThing(pupaCar);
        assertTrue(hall.contains(pupaCar));
    }
    @Test
    void putThingTwiceToEmptyContainerTest() {
        hall.putThing(pupaCar);
        hall.putThing(pupaCar);
        assertTrue(hall.contains(pupaCar));
    }
    @Test
    void putThingTwiceToEmptyContainerAndExtractTest() {
        hall.putThing(pupaCar);
        hall.putThing(pupaCar);
        hall.extractThing(pupaCar);
        assertFalse(hall.contains(pupaCar));
    }

    @Test
    void putLargeThingToMediumContainerTest() {
        hall.putThing(lupaCar);
        assertFalse(hall.contains(lupaCar));
    }
    @Test
    void putLargeThingToMediumContainerThenSmallThingTest() {
        hall.putThing(lupaCar);
        hall.putThing(pupaCar);
        assertTrue(hall.contains(pupaCar));
    }
    @Test
    void putLargeThingToMediumContainerThenTwoSmallThingsTest() {
        hall.putThing(lupaCar);
        hall.putThing(pupaCar);
        hall.putThing(dupaCar);
        assertTrue(hall.contains(pupaCar)
                && hall.contains(dupaCar)
                && !hall.contains(lupaCar));
    }
    @Test
    void putLargeThingToMediumContainerThenThreeSmallThingsTest() {
        hall.putThing(lupaCar);
        hall.putThing(pupaCar);
        hall.putThing(dupaCar);
        hall.putThing(car4);
        assertTrue(hall.contains(pupaCar)
                && hall.contains(dupaCar)
                && !hall.contains(lupaCar)
                && !hall.contains(car4));
    }


    @Test
    void putPassengerInCarTest() {
        pupaCar.putPassenger(lupa);
        assertEquals(pupaCar.getPassenger(),lupa);
    }
    @Test
    void putPassengerInCarThenTrySecondPassengerTest() {
        pupaCar.putPassenger(lupa);
        pupaCar.putPassenger(pupa);
        assertEquals(pupaCar.getPassenger(),lupa);
    }
    @Test
    void putPassengerInCarThenTrySecondPassengerThenExtractPassengerAndTryAgainTest() {
        pupaCar.putPassenger(lupa);
        pupaCar.putPassenger(pupa);
        pupaCar.extractPassenger();
        pupaCar.putPassenger(pupa);
        assertEquals(pupaCar.getPassenger(),pupa);
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
