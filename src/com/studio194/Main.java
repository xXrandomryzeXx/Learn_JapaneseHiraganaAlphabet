package com.studio194;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Random rand = new Random();
    private static final Scanner input = new Scanner(System.in);

    private static final int HiraganaSymbolCount = 46;

    static String[] JapaneseHiraganaSymbols;
    static String[] JapaneseHiraganaPronouns;
    public static void main(String[] args) {

        JapaneseHiraganaSymbols = new String[]{
                        "あ", "い", "う", "え", "お", "か", "き", "く", "け", "こ",
                        "さ", "し", "す", "せ", "そ", "た", "ち", "つ", "て", "と",
                        "な", "に", "ぬ", "ね", "の", "は", "ひ", "ふ", "へ", "ほ",
                        "ま", "み", "む", "め", "も", "や", "ゆ", "よ", "ら", "り",
                        "る", "れ", "ろ", "わ", "を", "ん"
                };

        JapaneseHiraganaPronouns = new String[]{
                        "[a]", "[i]", "[u]", "[e]", "[o]", "[ka]", "[ki]", "[ku]", "[ke]", "[ko]",
                        "[sa]", "[shi]", "[su]", "[se]", "[so]", "[ta]", "[chi]", "[tsu]", "[te]", "[to]",
                        "[na]", "[ni]", "[nu]", "[ne]", "[no]", "[ha]", "[hi]", "[fu]", "[he]", "[ho]",
                        "[ma]", "[mi]", "[mu]", "[me]", "[mo]", "[ya]", "[yu]", "[yo]", "[ra]", "[ri]",
                        "[ru]", "[re]", "[ro]", "[wa]", "[o]", "[n]"
                };

        while(true){
            int symbolIndex = rand.nextInt(HiraganaSymbolCount);
            int correctAnswer = rand.nextInt(3);
            System.out.println("What does this symbol sound like: " + "\u001B[36m" + JapaneseHiraganaSymbols[symbolIndex] + "\u001B[0m");

            switch(correctAnswer){
                case 0:
                    System.out.println("1. " + JapaneseHiraganaPronouns[symbolIndex]);
                    System.out.println("2. " + getRandomPronoun(correctAnswer));
                    System.out.println("3. " + getRandomPronoun(correctAnswer));
                    break;

                case 1:
                    System.out.println("1. " + getRandomPronoun(correctAnswer));
                    System.out.println("2. " + JapaneseHiraganaPronouns[symbolIndex]);
                    System.out.println("3. " + getRandomPronoun(correctAnswer));
                    break;

                case 2:
                    System.out.println("1. " + getRandomPronoun(correctAnswer));
                    System.out.println("2. " + getRandomPronoun(correctAnswer));
                    System.out.println("3. " + JapaneseHiraganaPronouns[symbolIndex]);
                    break;

            }

            System.out.println();
            System.out.println("Which is the correct answer?");

            int answer = input.nextInt();
            if(answer > 3 || answer < 0){
                System.out.println("Please choose an answer between 1 - 3 next time!");

            }else{
                if(answer == correctAnswer + 1){
                    System.out.println("Correct Answer, let's try the next one.");
                }else{
                    System.out.println("Wrong answer, the correct one is: "+ "\u001B[31m" + JapaneseHiraganaPronouns[symbolIndex] + "\u001B[0m");
                    System.out.println("Good luck next time.");
                }
            }

            for(int k = 0; k < 5; k++){
                System.out.println();
            }
        }
    }

    static String getRandomPronoun(int ignoredIndex){
        Random rand = new Random();
        String symbol;
        int index = rand.nextInt(HiraganaSymbolCount);
        if(index != ignoredIndex){
            symbol = JapaneseHiraganaPronouns[index];
            return symbol;
        }else{
            return getRandomPronoun(ignoredIndex);
        }
    }
}