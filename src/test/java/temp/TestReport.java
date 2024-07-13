package temp;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.MyConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestReport {

    private ExtentReports extent;
    private ExtentTest test;

    @BeforeMethod
    public void setUp() {
        // Raporun kaydedileceği HTML dosyası ve ayarları
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Test
    public void databaseTest() throws SQLException {
        MyConnection connection = new MyConnection("jdbc:mysql://localhost:3306/sakila", "root", "huzunlugurbet2024.");
        ResultSet resultSet = connection.getResultSet("select * from actor;");

        test = extent.createTest("Veritabanı Testi", "Sakila veritabanından aktör bilgilerini getirme testi");

        while (resultSet.next()) {
            String actorInfo = resultSet.getString(1) + "--" + resultSet.getString(2);
            System.out.println(actorInfo);
            test.info(actorInfo); // Rapor için bilgi ekleme
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // Test sonucuna göre raporu güncelleme
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test başarıyla tamamlandı");
        }

        extent.flush(); // Raporu kaydetme
    }
}