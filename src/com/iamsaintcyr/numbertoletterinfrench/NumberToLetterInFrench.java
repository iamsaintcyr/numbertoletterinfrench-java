package com.iamsaintcyr.numbertoletterinfrench;

import java.util.HashMap;
import java.util.Map;

public class NumberToLetterInFrench {
    private final Map<Integer, String> frenchNumberWords;

    public NumberToLetterInFrench() {
        frenchNumberWords = new HashMap<>();
        frenchNumberWords.put(0, "zéro");
        frenchNumberWords.put(1, "un");
        frenchNumberWords.put(2, "deux");
        frenchNumberWords.put(3, "trois");
        frenchNumberWords.put(4, "quatre");
        frenchNumberWords.put(5, "cinq");
        frenchNumberWords.put(6, "six");
        frenchNumberWords.put(7, "sept");
        frenchNumberWords.put(8, "huit");
        frenchNumberWords.put(9, "neuf");
        frenchNumberWords.put(10, "dix");
        frenchNumberWords.put(11, "onze");
        frenchNumberWords.put(12, "douze");
        frenchNumberWords.put(13, "treize");
        frenchNumberWords.put(14, "quatorze");
        frenchNumberWords.put(15, "quinze");
        frenchNumberWords.put(16, "seize");
        frenchNumberWords.put(17, "dix-sept");
        frenchNumberWords.put(18, "dix-huit");
        frenchNumberWords.put(19, "dix-neuf");
        frenchNumberWords.put(20, "vingt");
        frenchNumberWords.put(30, "trente");
        frenchNumberWords.put(40, "quarante");
        frenchNumberWords.put(50, "cinquante");
        frenchNumberWords.put(60, "soixante");
        frenchNumberWords.put(70, "soixante-dix");
        frenchNumberWords.put(80, "quatre-vingt");
        frenchNumberWords.put(90, "quatre-vingt-dix");
        frenchNumberWords.put(100, "cent");
        frenchNumberWords.put(1000, "mille");
        frenchNumberWords.put(1000000, "million");
        frenchNumberWords.put(1000000000, "milliard");
    }

    public String convert(int nb) {
        if (nb < 0) {
            throw new IllegalArgumentException("Please, provide a non-negative number.");
        }

        if (nb <= 20) {
            return numberToLetterUnderTwenty(nb);
        } else if (nb < 100) {
            return numberToLetterBetweenTwentyAndHundred(nb);
        } else if (nb < 1000) {
            return numberToLetterBetweenHundredAndThousand(nb);
        } else if (nb < 1000000) {
            return numberToLetterBetweenThousandAndMillion(nb);
        } else if (nb < 1000000000) {
            return numberToLetterBetweenMillionAndBillion(nb);
        } else {
            return numberToLetterAboveBillion(nb);
        }
    }

    private String numberToLetterUnderTwenty(int nb) {
        return frenchNumberWords.get(nb);
    }

    private String numberToLetterBetweenTwentyAndHundred(int nb) {
        int base = 10 * (nb / 10);
        int remainder = nb % 10;
        if (remainder == 0) {
            return frenchNumberWords.get(base);
        }
        return frenchNumberWords.get(base) + "-" + convert(remainder);
    }

    private String numberToLetterBetweenHundredAndThousand(int nb) {
        int hundreds = nb / 100;
        int remainder = nb % 100;
        String hundredText = (hundreds == 1) ? "cent" : frenchNumberWords.get(hundreds) + " " + frenchNumberWords.get(100);
        if (remainder == 0) {
            return hundredText;
        }
        return hundredText + " " + convert(remainder);
    }

    private String numberToLetterBetweenThousandAndMillion(int nb) {
        int thousands = nb / 1000;
        int remainder = nb % 1000;
        String thousandText = (thousands == 1 ? "" : convert(thousands)) + " " + frenchNumberWords.get(1000);
        if (remainder == 0) {
            return thousandText;
        }
        return thousandText + " " + convert(remainder);
    }

    private String numberToLetterBetweenMillionAndBillion(int nb) {
        int millions = nb / 1000000;
        int remainder = nb % 1000000;
        String millionText = convert(millions) + " " + frenchNumberWords.get(1000000);
        if (remainder == 0) {
            return millionText;
        }
        return millionText + " " + convert(remainder);
    }

    private String numberToLetterAboveBillion(int nb) {
        int billions = nb / 1000000000;
        int remainder = nb % 1000000000;
        String billionText = convert(billions) + " " + frenchNumberWords.get(1000000000);
        if (remainder == 0) {
            return billionText;
        }
        return billionText + " " + convert(remainder);
    }
}

