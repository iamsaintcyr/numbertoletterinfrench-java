package com.iamsaintcyr.numbertoletterinfrench;

public class Main {
    public static void main(String[] args) {
        NumberToLetterInFrench converter = new NumberToLetterInFrench();

        // Exemples de conversions
        int number1 = 123456;
        int number2 = 987654321;

        // Affichage des résultats
        System.out.println("Conversion de " + number1 + " en lettres : " + converter.convert(number1));
        System.out.println("Conversion de " + number2 + " en lettres : " + converter.convert(number2));
    }
}
