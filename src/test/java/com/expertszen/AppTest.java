package com.expertszen;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class AppTest {
    @Test
    public void testApp() {
        assertTrue(true);
    }
    @Test
    public void testApp2() {
        System.out.println("This is the second test");
    }
    @Test
    public void testError() {
        System.out.println("This is error code");;
    }
}
