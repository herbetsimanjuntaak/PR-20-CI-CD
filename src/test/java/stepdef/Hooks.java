package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;


import static helper.Utility.quitDriver;
import static helper.Utility.startDriver;


public class Hooks {

    @Before
    public void beforeTest() {
        startDriver();

    }

    @After
    public void afterTest() throws InterruptedException {
        Thread.sleep(5000);
        quitDriver();
    }
}
