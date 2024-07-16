package temp;

import org.testng.annotations.Test;
import utils.MyConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyConnectionTest {

    @Test
    public void test01() throws SQLException {

        MyConnection connection=new MyConnection("jdbc:mysql://localhost:3306/sakila","root","");
        ResultSet resultset=connection.getResultSet("select * from actor;");

        while (resultset.next()){



            System.out.println(resultset.getString(1) + "--" + resultset.getString(2));
        }






    }



}
