package org.example.firstLab;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstLab {


    public FirstLab() throws IOException {
        ArrayList<String> words = new ArrayList<>();
        Path filenameAlphabet = Paths.get("C:\\Users\\Creep\\Desktop\\labs\\proj\\src\\firstLab\\Alphabet.txt");
        Path filenameTask = Paths.get("C:\\Users\\Creep\\Desktop\\labs\\proj\\src\\firstLab\\Words.txt");
        try(Scanner Reader = new Scanner(filenameAlphabet)){
            Map<Integer, Alphabet> alphabets = new HashMap<Integer, Alphabet>() ;
            Integer Key=0;
            while(Reader.hasNextLine()){
                String[] string = Reader.nextLine().split(" ");
                Alphabet alphabet = new Alphabet();
                alphabet.setMorzeAlphabet(string[0]);
                alphabet.setRegularAlphabet(string[1]);
                alphabets.put(Key,alphabet);
                Key++;}

            try(Scanner ReaderTask = new Scanner(filenameTask)){
                StringBuilder sentence = new StringBuilder();;
                while (ReaderTask.hasNextLine()){
                    String[] letters = ReaderTask.nextLine().split(" ");
                    StringBuilder word= new StringBuilder();
                    for (String letter: letters) {
                        for (Map.Entry<Integer, Alphabet> item : alphabets.entrySet()){
                            if(item.getValue().getMorzeAlphabet().equals(letter)){
                                word.append(item.getValue().getRegularAlphabet());
                            }

                        }}
                    sentence.append(word).append(" ");
                }
                System.out.println(sentence);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }











    }



}
