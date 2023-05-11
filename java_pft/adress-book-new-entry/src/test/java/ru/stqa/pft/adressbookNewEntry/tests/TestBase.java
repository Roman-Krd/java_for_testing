package ru.stqa.pft.adressbookNewEntry.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.stqa.pft.adressbookNewEntry.appmanager.applicationManager;

import static org.openqa.selenium.firefox.FirefoxCommandContext.CHROME;
import static org.openqa.selenium.remote.Browser.EDGE;
import static org.openqa.selenium.remote.Browser.FIREFOX;

public class TestBase {

    protected final applicationManager app = new applicationManager(FIREFOX.browserName());

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

    public applicationManager getApp() {
        return app;
    }
}
