package lt.techin.example.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({SimpleScreenshotTest.class, FailedTest.class})
public class ExampleTestSuite {
    // This class remains empty. It's used only as a holder for the above annotations.
}