package com.ait.qa28.demowebshop;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {
    @Test
    public void isHomeComponentPresentTest() {
        app.getHomePage().pause(1000);
        Assert.assertTrue(app.getHomePage().isHomeComponentPresent());
    }
}
