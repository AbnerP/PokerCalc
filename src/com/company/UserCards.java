package com.company;

import java.util.Scanner;
import java.util.concurrent.TimeUnit; //Used for timer

public class UserCards  {
    public static void main(String[] args)throws InterruptedException{ //Throws timers
        int handCounter=0; //Used so that getHand knows what hand it is
        welcome(); //Method for instructions
        String hand1Str = getHand(handCounter);
        handCounter++;
        String hand2Str = getHand(handCounter);

        //Creates Card array named hand x with the function that stringToCard
        Card[] handOne= stringToCard(hand1Str);
        Card[] handTwo= stringToCard(hand2Str);

        //As in regular main it gives each hand a value
        double handOneValue = GeneratedDeckMain.handValue(handOne);
        double handTwoValue = GeneratedDeckMain.handValue(handTwo);

        //Verbal version of Hand
        String hand1C = GeneratedDeckMain.classification(handOneValue);
        String hand2C = GeneratedDeckMain.classification(handTwoValue);

        //Print Converted Cards
        System.out.println("\nFirst Hand\t\t" + hand1C);
        GeneratedDeckMain.printCards(handOne);
        System.out.println("\n\nSecond Hand\t\t" + hand2C);
        GeneratedDeckMain.printCards(handTwo);

        //Compares both Hands and chooses winning Hand
        GeneratedDeckMain.winningHand(handOneValue, handTwoValue);

    }
    //Stores all Prompts
    private static void welcome()throws InterruptedException { //throws timer function
        System.out.println("Welcome to the Poker Hand Calculator");
        System.out.println("You will give me two hands of 5 cards each\nand I will tell you which hand is the best.");
        TimeUnit.SECONDS.sleep(5); //Timer
        System.out.println("\nThe way to enter cards is by the letter or number \nof rank followed directly by the suit.");
        TimeUnit.SECONDS.sleep(6); //Timer
        System.out.println("\nExample:\n\t2 of Hearts\t= 2H or 2h\n\tAce of Spades = AS or as\n\t10 of Clubs = TC or tc\n\tJack of Diamonds = JD or jd");
        System.out.println("\nA five card hand will look like this:");
        System.out.println("\t\t2HAS3C5D8H = 2 of Hearts, Ace of Spades, 3 of Clubs, 5 of Diamonds and 8 of Hearts");
    }

    //Gets a hand, one hand at a time
    private static String getHand(int handCounter){
        Scanner s = new Scanner(System.in);
        if(handCounter==0)
            System.out.println("\nEnter the first Hand");
        else
            System.out.println("\nEnter the second Hand");

        return s.next();
    }
    private static Card [] stringToCard(String hand){
        Card [] handC = new Card[5]; // IF 2HAS3C5D8H

        char[] ranks = new char [5];
        for(int i = 0;i<ranks.length;i++)//Then Ranks index = 0,2,4,6, = 2A358
            ranks[i]=hand.charAt(i*2);
        char[] suits = new char [5];
        for(int i = 0;i<suits.length;i++)//Then Suits index = 1,3,5,7,9 = HSCDH
            suits[i] = hand.charAt(2*i+1);

        //With both methods creates an array of the cards divided in ranks and suits
        int[] rankArr = stringToRank(ranks);
        int[] suitArr = stringToSuit(suits);

        //Uses integer array to create a new Card with the indexes i so that functions of original main can be used
        for(int i = 0;i<handC.length;i++)
            handC[i]=new Card(rankArr[i],suitArr[i]);
        return handC;
    }

    //Conditional to return array of integers that are equivalent to index in card class
    private static int[] stringToRank(char[] rank){
        int [] rankArr = new int[5];
        for(int i = 0;i<rank.length;i++) {
            if (rank[i] == '2')
                rankArr[i] = 0;
            else if (rank[i] == '3')
                rankArr[i] = 1;
            else if (rank[i] == '4')
                rankArr[i] = 2;
            else if (rank[i] == '5')
                rankArr[i] = 3;
            else if (rank[i] == '6')
                rankArr[i] = 4;
            else if (rank[i] == '7')
                rankArr[i] = 5;
            else if (rank[i] == '8')
                rankArr[i] = 6;
            else if (rank[i] == '9')
                rankArr[i] = 7;
            else if ((rank[i] == 'T') || (rank[i] == 't'))
                rankArr[i] = 8;
            else if ((rank[i] == 'J') || (rank[i] == 'j'))
                rankArr[i] = 9;
            else if ((rank[i] == 'Q') || (rank[i] == 'q'))
                rankArr[i] = 10;
            else if ((rank[i] == 'K') || (rank[i] == 'k'))
                rankArr[i] = 11;
            else if ((rank[i] == 'A') || (rank[i] == 'a'))
                rankArr[i] = 12;
        }return rankArr;
    }
    //Conditional to return suit of integers that are equivalent to index in card class
    private static int[] stringToSuit(char[] suit){
        int [] suitArr = new int[5];
        for(int i = 0;i<suit.length;i++) {
            if ((suit[i] == 'S') || (suit[i] == 's'))
                suitArr[i] = 0;
            else if ((suit[i] == 'D') || (suit[i] == 'd'))
                suitArr[i] = 1;
            else if ((suit[i] == 'C') || (suit[i] == 'c'))
                suitArr[i] = 2;
            else if ((suit[i] == 'H') || (suit[i] == 'h'))
                suitArr[i] = 3;
        }return suitArr;
    }
}
