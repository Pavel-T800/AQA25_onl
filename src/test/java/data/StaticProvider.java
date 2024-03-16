package data;

import org.testng.annotations.DataProvider;

import java.io.File;

public class StaticProvider {

    @DataProvider (name = "dataForSum")
    public static Object[][] dataForSumTest() {
        Object[][] list = new Object[][] {
                { StaticProvider.class.getClassLoader().getResource("data" + File.separator + "bigsize.doc").getPath(), "ERROR1"},
                { StaticProvider.class.getClassLoader().getResource("data" + File.separator + "download.txt").getPath(), "ERROR2"},
                { StaticProvider.class.getClassLoader().getResource("data" + File.separator + "download.png").getPath(), "ERROR3"}
        };
        return list;
    }
}