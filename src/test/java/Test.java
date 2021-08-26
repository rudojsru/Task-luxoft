import org.junit.Assert;
import org.junit.BeforeClass;

import java.util.LinkedList;
import java.util.List;


public class Test {

    private static Logic logic;

    private static String inputFilename;
    private static String outputFilename;

    @BeforeClass
    public static void initLogic() {
        logic = new Logic();
        inputFilename = "input.txt";
        outputFilename = "output.txt";
        List<String> outLogic = new LinkedList();
    }


    @org.junit.Test(expected = RuntimeException.class)
    public void fileNotExistTest() throws Exception {
        logic.getImportWords("notExistFile");
    }


    @org.junit.Test
    public void groupingTest() throws Exception {
        List<String> list = new LinkedList<>();
        list.add("({a,e},4)->2.0"+ '\n');
        list.add("({a,o},5)->2.0"+ '\n');
        list.add("({a,o},6)->2.5"+ '\n');
        List<String> words = logic.getImportWords(inputFilename);
        List<String> outLogic = logic.allLogic(words);
        System.out.println(list);
        System.out.println(outLogic);
        Assert.assertEquals( list , outLogic);
    }
}
