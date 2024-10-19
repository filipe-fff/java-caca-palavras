package edu.wordSearch;

import java.util.ArrayList;
import java.util.Arrays;

public enum WordSearchsTableEnum {

        WORD_SERCH1(
                new ArrayList<>(Arrays.asList("C", "A", "Ç", "A", "P", "A", "L", "A", "V", "R", "A", "S")),
                new ArrayList<>(Arrays.asList("B", "E", "I", "F", "O", "R", "M", "O", "S", "A", "R", "E")),
                new ArrayList<>(Arrays.asList("P", "I", "G", "F", "O", "O", "L", "I", "B", "E", "S", "T")),
                new ArrayList<>(Arrays.asList("E", "N", "O", "V", "E", "M", "B", "R", "O", "L", "A", "T")),
                new ArrayList<>(Arrays.asList("Z", "O", "C", "N", "A", "B", "L", "A", "E", "T", "N", "U")),
                new ArrayList<>(Arrays.asList("R", "S", "E", "Q", "U", "E", "N", "C", "I", "A", "N", "T")),
                new ArrayList<>(Arrays.asList("O", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "L")),
                new ArrayList<>(Arrays.asList("P", "L", "A", "N", "E", "T", "A", "Z", "A", "Q", "M", "P")),
                new ArrayList<>(Arrays.asList("S", "A", "D", "E", "F", "E", "R", "O", "N", "I", "P", "S")),
                new ArrayList<>(Arrays.asList("M", "A", "R", "C", "O", "L", "O", "C", "O", "S", "P", "M")),
                new ArrayList<>(Arrays.asList("T", "O", "C", "O", "D", "I", "G", "I", "T", "A", "L", "R"))
        );

        private final ArrayList<ArrayList<String>> wordSearch1;

        @SafeVarargs
        WordSearchsTableEnum(ArrayList<String> ... wordSerchRow) {
            wordSearch1 = new ArrayList<ArrayList<String>>();
            wordSearch1.addAll(Arrays.asList(wordSerchRow));
        }

        public ArrayList<ArrayList<String>> getWordSearch1() {
                return this.wordSearch1;
        }
}