package edu.wordSearch;

import java.util.ArrayList;
import java.util.function.Predicate;

public class WordSearch {

    private ArrayList<ArrayList<String>> wordSearchTable;
    private ArrayList<Coordenate> firstWordList;
    private ArrayList<ArrayList<Coordenate>> coordenatesWordsList;
    private String word;


    private Predicate<Coordenate> isCoordenate = coordenate -> {
        for (ArrayList<Coordenate> coordenatesWord : this.coordenatesWordsList) {
            for (Coordenate coordenateChar : coordenatesWord) {
                if (coordenateChar.getX() == coordenate.getX() && coordenateChar.getY() == coordenate.getY()) {
                    return true;
                }
            }
        }
        return false;
    };

    public WordSearch() {
        this.wordSearchTable = WordSearchsTableEnum.WORD_SERCH1.getWordSearch1();
        this.firstWordList = new ArrayList<Coordenate>();
        this.coordenatesWordsList = new ArrayList<ArrayList<Coordenate>>();
        this.word = "";
    }

    public void search(String word) {
        this.reset();
        this.word = word;
        this.firstWord();
        this.coordenateByFirstWord();
    }

    private void firstWord() {
        String firstChar = Character.toString(this.word.charAt(0));

        for (int y_index = 0; y_index < this.wordSearchTable.size(); y_index++) {
            for (int x_index = 0; x_index < this.wordSearchTable.get(0).size(); x_index++) {
                if (firstChar.equalsIgnoreCase(wordSearchTable.get(y_index).get(x_index))) {
                    firstWordList.add(new Coordenate(x_index, y_index));
                }
            }
            System.out.println();
        }
    }

    private void coordenateByFirstWord() {
        this.firstWordList.forEach(this::axleWord);
    }

    private void axleWord(Coordenate coordenate) {
        int wordLength = this.word.length();
        int wordSearchXLength = WordSearchsTableEnum.WORD_SERCH1.getWordSearch1().get(0).size();
        int wordSearchYLength = WordSearchsTableEnum.WORD_SERCH1.getWordSearch1().size();

        boolean WORD_LEFT = 0 <= coordenate.getX() - (wordLength - 1);
        boolean WORD_TOP = 0 <= coordenate.getY() - (wordLength - 1);
        boolean WORD_RIGHT = coordenate.getX() + wordLength <= wordSearchXLength;
        boolean WORD_BOTTOM = coordenate.getY() + wordLength <= wordSearchYLength;

        if (WORD_LEFT)
            extendsWordByCharacter(-1, 0, coordenate);

        if (WORD_LEFT && WORD_TOP)
            extendsWordByCharacter(-1, -1, coordenate);

        if (WORD_TOP)
            extendsWordByCharacter(0, -1, coordenate);

        if (WORD_TOP && WORD_RIGHT)
            extendsWordByCharacter(1, -1, coordenate);

        if (WORD_RIGHT)
            extendsWordByCharacter(1, 0, coordenate);

        if (WORD_RIGHT && WORD_BOTTOM)
            extendsWordByCharacter(1, 1, coordenate);

        if (WORD_BOTTOM)
            extendsWordByCharacter(0, 1, coordenate);

        if (WORD_BOTTOM && WORD_LEFT)
            extendsWordByCharacter(-1, 1, coordenate);
    }

    private void extendsWordByCharacter(int x_pointer, int y_pointer, Coordenate coordenate) {
        ArrayList<Coordenate> testCoordenate = new ArrayList<Coordenate>();
        String testWord = "";
        int x_axle = coordenate.getX();
        int y_axle = coordenate.getY();

        for (int c = 0; c < this.word.length(); c++) {
            testWord += this.wordSearchTable.get(y_axle).get(x_axle);
            testCoordenate.add(new Coordenate(x_axle, y_axle));
            x_axle += x_pointer;
            y_axle += y_pointer;
        }

        if (this.word.equalsIgnoreCase(testWord))
            this.coordenatesWordsList.add(testCoordenate);
    }

    public void displayWordInWordSearchTable() {
        String character;
        Coordenate coordenate;

        for (int y = 0; y < wordSearchTable.size(); y++) {
            for (int x = 0; x < wordSearchTable.get(0).size(); x++) {
                character = wordSearchTable.get(y).get(x);
                coordenate = new Coordenate(x, y);

                if (this.isCoordenate.test(coordenate)) {
                    System.out.printf("\u001B[34m %s \u001B[0m", character);
                } else {
                    System.out.printf(" %s ", character);
                }
            }
            System.out.println();
        }
    }

    private void reset() {
        this.firstWordList.clear();
        this.coordenatesWordsList.clear();
    }
}