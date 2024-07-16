package runner;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    //buda farkli bir yontem.xmlin icerisinden calistirmak
    public static void main(String[] args) {
        TestNG testng = new TestNG();

        List<String> suites = new ArrayList<>();
        suites.add("C:\\Users\\admin\\IdeaProjects\\myConnection\\testng.xml"); // TestNG XML dosyanızın yolu

        testng.setTestSuites(suites);
        testng.run();
    }
}
