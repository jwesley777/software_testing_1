package test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import part1.Sec;

import java.util.HashMap;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SecTest {

    private double delta = 1e-3;
    private Map<Double,Double> testMap = new HashMap<Double, Double>();

    @BeforeAll
    void setUp() {
        testMap.put(0.,1.);
        testMap.put(Math.PI/3,2.);
        testMap.put(-Math.PI/3,2.);
        testMap.put(Math.PI/4,1.41421356237);
        testMap.put(-Math.PI/4,1.41421356237);
        testMap.put(Math.PI/5,1.2360679775);
        testMap.put(-Math.PI/5,1.2360679775);
        testMap.put(Math.PI/2,Double.NaN);
        testMap.put(-Math.PI/2,Double.NaN);
        testMap.put(Math.PI,Double.NaN);
        testMap.put(-Math.PI,Double.NaN);
//        testMap.put(Math.PI,-1.);
//        testMap.put(-Math.PI,-1.);
//        testMap.put(1.,1.850816);
//        testMap.put(-1.,1.850816);
//        testMap.put(Math.PI/2,Double.NaN);
//        testMap.put(-Math.PI/2,Double.NaN);
//        testMap.put(Math.PI*2,1.);
//        testMap.put(-Math.PI*2,1.);
//        testMap.put(Math.PI+Math.PI/2,Double.NaN);
//        testMap.put(-Math.PI-Math.PI/2,Double.NaN);
//        testMap.put(Math.PI*3,-1.);
//        testMap.put(-Math.PI*3,-1.);
//        testMap.put(1+Math.PI,-1.850816);
//        testMap.put(-1-Math.PI,-1.850816);
//        testMap.put(1+2*Math.PI,1.850816);
//        testMap.put(-1-2*Math.PI,1.850816);
    }
    @AfterAll
    void tearDown() {
        testMap.clear();
    }

    @Test
    void sec() {
        for (Map.Entry<Double,Double> entry: testMap.entrySet()) {
            final Double testData = entry.getKey();
            final Double expected = entry.getValue();
            final Double actual = Sec.sec(testData);
            assertEquals(expected,actual, delta);
        }
    }


}
