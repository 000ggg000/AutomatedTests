package lt.techin.example.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class FailedTest extends BaseTest{


        @Test
        void failedTest(){
            driver.get("https://techin.lt/priemimas/");
            fail();
        }


}
