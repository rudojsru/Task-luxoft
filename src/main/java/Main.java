import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    private static Logic logic;
    public static void main(String[] args) throws FileNotFoundException {
        logic=new Logic();
        final String inputFilename = "input.txt";
        final String outputFilename = "output.txt";

        List<String> words = logic.getImportWords(inputFilename);
        List <String> outLogic= logic.allLogic(words);
        logic.saveFile(outputFilename, outLogic);
    }
}
