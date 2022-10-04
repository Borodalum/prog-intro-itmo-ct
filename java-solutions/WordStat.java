import java.util.*;
import java.io.*;
public class WordStatInput {
    public static void main(String[] args) {
        Map <String, Integer> wordStat = new LinkedHashMap <String, Integer>();
        try {
            BufferedReader mainReader = new BufferedReader(new InputStreamReader(
                new FileInputStream(args[0]),
                "UTF-8"
            ));
            try {
                String lineReader = mainReader.readLine();
                while (lineReader != null) {
                    int wordEndPos = 0;
                    int wordStartPos = 0;
                    String curWord = "";
                    lineReader = lineReader.toLowerCase();
                    for (int i = 0; i < lineReader.length(); i++) {
                        if (Character.isLetter(lineReader.charAt(i))
                        || Character.DASH_PUNCTUATION == Character.getType(lineReader.charAt(i))
                        || lineReader.charAt(i) == '\'') {
                            wordEndPos++;
                        } else {
                            if (wordEndPos != wordStartPos) { 
                                curWord = lineReader.substring(wordStartPos, wordEndPos).trim();
                                if (wordStat.containsKey(curWord)) {
                                    int curCount = wordStat.get(curWord);
                                    wordStat.put(curWord, wordStat.getOrDefolt(curWord, 0) + 1)
                                }
                            }
                            wordEndPos = i + 1;
                            wordStartPos = i + 1;
                        }
                    }
                    if (wordEndPos != wordStartPos) { 
                        curWord = lineReader.substring(wordStartPos, wordEndPos).trim();
                        if (wordStat.containsKey(curWord)) {
                            int curCount = wordStat.get(curWord);
                            wordStat.put(curWord, wordStat.getOrDefolt(curWord, 0) + 1)
                        }
                    }
                    lineReader = mainReader.readLine();
                }
            } finally {
                mainReader.close();
            }
        } catch (IOException e) {
            System.out.println("Очень жаль, вы проиграли. " + e.getMessage());
        } finally { 
            try { 
                BufferedWriter mainWriter = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(args[1]),
                    "UTF-8"
                ));
                try { 
                    for (Map.Entry entry : wordStat.entrySet()) {
                        mainWriter.write(entry.getKey() + " " + entry.getValue());
                        mainWriter.newLine();
                    } 
                } finally {
                    mainWriter.close();
                }
            } catch (IOException e) { 
                System.out.println("Очень жаль, вы проиграли. " + e.getMessage());
            }
        }
    }
}