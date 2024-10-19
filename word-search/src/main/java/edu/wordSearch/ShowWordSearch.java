package edu.wordSearch;

import java.util.ArrayList;
import java.util.Scanner;

public class ShowWordSearch {

    private WordSearch wordSearch;
    private String word;

    public ShowWordSearch() {
        this.wordSearch = new WordSearch();
        this.word = "";
    }

    public void runWordSearch() {
        while (true) {
            this.showTable();
            this.line("/", 27);
            this.word = this.keyboard("\t => ");
            this.wordSearch.search(word);
        }
    }

    private void showTable() {
        line();
        this.wordSearch.displayWordInWordSearchTable();
        line();
        System.out.println();
    }

    private void line() {
        System.out.println("-".repeat(36));
    }

    private void line(String c, int s) {
        System.out.println(c.repeat(s));
    }

    private String keyboard(String text) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(text);
        return keyboard.next();
    }
}