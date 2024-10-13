package org.example;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComponentTest {

    private static int testCount;

    static {
        testCount = 0;
    }

    @BeforeAll
    static void setClass(){
        Component c1 = new Component("Xiaomi", "smth", 100f);
        Component c2 = new Component("Samsung", "smth", 200f);
        Component c3 = new Component("Intel", "smth", 300f);
        Component c4 = new Component("Xiaomi", "smth", 100f);
    }

    @BeforeEach
    void setUp() {
        testCount++;
    }

    @Test
    void countTotalPrice() {
        Assertions.assertEquals(700f, Component.countTotalPrice());
    }

    @Test
    void countBrandExceptionCheck() {
        Assertions.assertThrows(RuntimeException.class, () -> Component.countBrand("nigg"));
    }

    @Disabled
    @Test
    void countBrandCheck() {
        Assertions.assertEquals(3, Component.countBrand("Xiaomi"));
    }

    @Test
    void discountCheck(){

        Component test = Component.getComponents().getFirst();

        Assertions.assertEquals(10f, test.computeDiscount(10));
    }

    @Test
    void notNullListCheck(){
        Assertions.assertNotNull(Component.getComponents(), "Список не создался");
    }


    @AfterEach
    void showResult() {
        System.out.println(testCount + " test finished");
    }

    @AfterAll
    static void reset() {
        System.out.println("Total tests - " + testCount);
        testCount = 0;
    }
}