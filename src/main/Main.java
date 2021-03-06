package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static final String filePath = "C:/Users/Huseyn/Desktop/words.txt";

    public static void main(String[] args) {
        Map<String, String> mapFromFile = getHashMapFromTextFile();

        for (Map.Entry<String, String> entry : mapFromFile.entrySet()) {
            Scanner sc = new Scanner(System.in);
            System.out.println(entry.getKey() + " nedir?");
            String myWord = sc.nextLine();

            if (myWord.equals(entry.getValue())) {
                System.out.println("Dogrudur!");
            } else {
                System.out.println("Yalnisdir");

                for (int i = 0; i < 4; i++) {
                    System.out.println("Yeniden daxil edin:");
                    sc = new Scanner(System.in);
                    myWord = sc.nextLine();
                    if (myWord.equals(entry.getValue())) {
                        System.out.println("Dogrudur");
                        break;
                    }

                }
            }
        }
    }

    public static Map<String, String> getHashMapFromTextFile() {
        Map<String, String> mapFileContents = new HashMap<>();
        BufferedReader br = null;

        try {
            //create file object
            File file = new File(filePath);

            //create BufferredReader object from the file
            br = new BufferedReader(new FileReader(file));
            String line = null;

            //read file line by line
            while ((line = br.readLine()) != null) {
                //split the line by
                String[] parts = line.split(",");

                //first part is word, second is translatedWord
                String word = parts[0].trim();
                String translatedWord = parts[1].trim();

                //put word,translatedWord in HashMap if they are not empty
                if (!word.equals("") && !translatedWord.equals("")) {
                    mapFileContents.put(word, translatedWord);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {

                }
            }
            return mapFileContents;
        }
    }


}
