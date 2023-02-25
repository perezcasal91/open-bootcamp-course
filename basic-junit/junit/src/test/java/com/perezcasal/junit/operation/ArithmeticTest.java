package com.perezcasal.junit.operation;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticTest {

    static Arithmetic arithmetic;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Initializing Arithmetic before All Test Cases.");
        arithmetic = new Arithmetic();
        System.out.println();
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Initializing Arithmetic before Each Test Cases.");
        System.out.println();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Killing Arithmetic after All Test Cases.");
        arithmetic = null;
    }

    @AfterEach
    void afterEach() {
        System.out.println("Killing Arithmetic after Each Test Cases.");
        System.out.println();
    }

    @Test
    @DisplayName("Sum: Success Scenario -> 1 + 2 = 3 / Assert Equals")
    void sumTest1() {
        int result = arithmetic.sum(1, 2);
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Sum: Success Scenarios -> 1 + 2 = 3 and 2 + 3 = 5 / Assert All with Assert Equals")
    void sumTest2() {
        int result1 = arithmetic.sum(1, 2);
        int result2 = arithmetic.sum(2, 3);
        assertAll(
                () -> assertEquals(3, result1),
                () -> assertEquals(5, result2)
        );
    }

    @RepeatedTest(value = 3, name = "{displayName} {currentRepetition} / {totalRepetitions}")
    @DisplayName("Sum: Success Scenario -> 1 + 2 = 3 / Assert Equals with Repeat Test")
    void sumTest3() {
        int result = arithmetic.sum(1, 2);
        assertEquals(3, result);
    }

    @RepeatedTest(value = 3, name = "{displayName}")
    @DisplayName("Sum: Success Scenario -> 1 + 2 = 3 / Assert Equals with Repeat Test and Method Parameter")
    void sumTest4(RepetitionInfo repetitionInfo) {
        int result = arithmetic.sum(1, 2);
        System.out.println("Current: " + repetitionInfo.getCurrentRepetition());
        System.out.println("Total: " + repetitionInfo.getTotalRepetitions());
        assertEquals(3, result);
    }

    @ParameterizedTest
    @DisplayName("Sum: Success Scenario -> 1 + 2 = 3 / Assert Equals with Parameters")
    @ValueSource(ints = {3})
    void sumTest4(double a) {
        int result = arithmetic.sum(1, 2);
        assertEquals(a, result);
    }

    @Test
    @DisplayName("Subtract: Success Scenario -> 5 - 2 = 3 / Assert Equals")
    void subtractTest() {
        int result = arithmetic.subtract(5, 2);
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Divide: Success Scenario -> 6 / 2 = 3 / Assert Equals")
    void divideTest1() {
        int result = arithmetic.divide(6, 2);
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Divide: Wrong Scenario -> 6 / 0 = Arithmetic Exception / Assert Throws")
    void divideTest2() {
        Exception exception = assertThrows(ArithmeticException.class,
                () -> arithmetic.divide(6, 0));
        assertEquals("The division by 0 is not allowed.", exception.getMessage());
    }

    @Test
    @DisplayName("Multiply: Success Scenario -> 6 * 2 = 12 / Assert Equals")
    void multiplyTest() {
        int result = arithmetic.multiply(6, 2);
        assertEquals(12, result);
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForOneOperativeSystem() {
        System.out.println("Test for windows only.");
        System.out.println(System.getProperty("os.name"));
    }

    @Test
    @EnabledOnJre(JRE.JAVA_19)
    void testForOneSpecificJRE() {
        System.out.println("Test for specific JRE only.");
    }

    @Test
    @EnabledIfSystemProperty(named = "os.name", matches = "Windows 10")
    void testForOneSpecificSystemProperty() {
        System.out.println("Test for specific System Property only.");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "PROCESSOR_ARCHITECTURE", matches = "AMD64")
    void testForOneSpecificEnvironmentVariable() {
        System.out.println("Test for specific Environment Variable only.");
    }

    @Test
    @Tag("dev")
    void testUsingSuiteEngineAndTags() {
        System.out.println("Testing the Suite Engine and Tags");
    }
}