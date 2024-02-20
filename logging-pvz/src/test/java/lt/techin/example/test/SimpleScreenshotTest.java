package lt.techin.example.test;

import static java.lang.invoke.MethodHandles.lookup;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import lt.techin.example.test.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;



class SimpleScreenshotTest extends BaseTest{

    private static final Logger log = getLogger(lookup().lookupClass());
   // static final Logger log = getLogger(SimpleScreenshotTest.class);




    @Test
    void testScreenshotPng() throws IOException {

        String URL = "https://techin.lt";
        driver.get(URL);
        log.info("Navigated to {}", URL);

        TakesScreenshot ts = (TakesScreenshot) driver;

        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        log.debug("Screenshot created on {}", screenshot);

        Path destination = Paths.get("screenshot.png");
        Files.move(screenshot.toPath(), destination, REPLACE_EXISTING);
        log.debug("Screenshot moved to {}", destination);

        assertThat(destination).exists();


    }


    @Test
    void testScreenshotWithUtilClass()  {
        driver.get("https://techin.lt");

        TestUtils.takeScreenshot(driver, "testScreenshotWithUtilClass" );



    }

}