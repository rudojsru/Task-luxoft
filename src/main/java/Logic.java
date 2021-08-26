import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Logic {
   

       void saveFile(String outputFilename, List<String> outLogic) throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream(outputFilename));
        Collections.reverse(outLogic);
        outLogic.stream().forEach(m ->out.print(m));
    }

        List<String> allLogic(List<String> words) throws FileNotFoundException {
        Map<Integer, List<String>> groupingWords = words.stream().collect(Collectors.groupingBy(s -> s.length()));
        Set<Integer> keyWords = groupingWords.keySet();
        List<String > out = new LinkedList();


        final String pattern = "[^aeiouAEIOU ]";
        for (Integer set : keyWords) {
            List<String> wordsFromGroup = groupingWords.get(set);


            int numberVowels = wordsFromGroup.stream().map(c -> c.replaceAll(pattern, ""))
                    .collect(Collectors.joining()).length();
            double numberWords = wordsFromGroup.size();
            String vowels = Arrays.asList(wordsFromGroup.stream().map(c -> c.replaceAll(pattern, ""))
                    .collect(Collectors.joining()).split(""))
                    .stream().distinct().sorted().collect(Collectors.joining(","));

            out.add("({" + vowels + "}," + set + ")->" + numberVowels / numberWords + '\n');
        }
        return out;
    }

        List<String> getImportWords(String inputFilename) {
        List<String> words = new ArrayList<>();
        try {
            words = Files.lines(Paths.get(ClassLoader.getSystemResource(inputFilename).toURI()))
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .map(word -> word.toLowerCase().replaceAll("[^A-Za-z ]", ""))
                    .collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return words;
    }

     
}
