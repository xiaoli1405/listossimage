package com.example.listossimage.testjunit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testjunit {

    @Test
    public void testAdd() {
        String str = "Junit is working fine";
        assertEquals("Junit is working fine", str);
    }
}
