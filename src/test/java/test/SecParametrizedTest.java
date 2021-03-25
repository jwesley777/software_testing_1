package test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import part1.Sec;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SecParametrizedTest {

    private final double delta = 1e-3;

    @ParameterizedTest()
    @MethodSource("secProvider")
    void testSec(double x, double y) {
        assertEquals(Sec.sec(x),y,delta);
    }

    private static Stream<Arguments> secProvider() {
        double eps = 0.00001;
        return Stream.of(
                Arguments.of(0., 1.),
                Arguments.of(Math.PI/3, 2.),
                Arguments.of(-Math.PI/3, 2.),
                Arguments.of(Math.PI/4, 1.414214),
                Arguments.of(-Math.PI/4, 1.414214),
                Arguments.of(Math.PI/2, Double.NaN),
                Arguments.of(-Math.PI/2, Double.NaN),
                Arguments.of(Math.PI/2+eps,Double.NEGATIVE_INFINITY),
                Arguments.of(Math.PI/2-eps,Double.POSITIVE_INFINITY),
                Arguments.of(-Math.PI/2-eps,Double.NEGATIVE_INFINITY),
                Arguments.of(-Math.PI/2+eps,Double.POSITIVE_INFINITY),
                Arguments.of(Math.PI, -1.),
                Arguments.of(2*Math.PI/3, -2.),
                Arguments.of(4*Math.PI/3,-2.),
                Arguments.of(-Math.PI,-1.),
                Arguments.of(-2*Math.PI/3,-2.),
                Arguments.of(-4*Math.PI/3,-2.),
                Arguments.of(2*Math.PI,1.),
                Arguments.of(7*Math.PI/3,2),
                Arguments.of(5*Math.PI/3,2.),
                Arguments.of(-2*Math.PI,1.),
                Arguments.of(-5*Math.PI/3,2.),
                Arguments.of(-7*Math.PI/3,2.),
                Arguments.of(Double.POSITIVE_INFINITY,Double.NaN),
                Arguments.of(Double.NEGATIVE_INFINITY,Double.NaN)
                );
    }
    

}
