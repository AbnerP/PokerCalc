package com.company;

import java.util.Arrays;

public class GeneratedDeckMain {

    public static void main(String[] args) {
        Card [] deckUsed = new Card[52]; //Creates a Card array that is a Deck

        //Problem 1
        System.out.println("\n\nORDERED DECK");
        Deck.orderedDeck(deckUsed); //takes in Card array and fills its values with the Card Objects
        printCards(deckUsed); //Prints cards

        System.out.println("\n\nSHUFFLED DECk");
        Deck.shuffle(deckUsed); //Shuffles Cards using Ordered Deck as parameter
        printCards(deckUsed); //Prints


        //Problem 2
        Card[] Hand1 = new Card[5]; //Creates an empty Card array with 5 Spaces
        Card[] Hand2 = new Card[5]; //Creates an empty Card array with 5 Spaces

        //Uses first 10 Cards in array for both hands
        //For Hand 1 it uses first 5 and for Hand 2 last 5
        for (int i = 0; i < Hand1.length; i++) {
            Hand1[i] = deckUsed[i];
            Hand2[i] = deckUsed[i + 5];
        }

        double hand1V = handValue(Hand1); //Hand Value takes in Hand Card Array and returns a double for how good the Hand is
        double hand2V = handValue(Hand2); //Hand Value takes in Hand Card Array and returns a double for how good the Hand is

        String hand1C = classification(hand1V);
        String hand2C = classification(hand2V);

        System.out.println("\nFirst Hand\t\t" + hand1C);
        printCards(Hand1);

        System.out.println("\n\nSecond Hand\t\t" + hand2C);
        printCards(Hand2);


        winningHand(hand1V, hand2V);
    }

//Methods

    //Prints all cards in an array, it can be either a hand or all 52 cards
    public static void printCards(Card[] card){
        System.out.println("");
        for (Card value : card) {
            System.out.println(value);
        }
    }

    //Prints remaining 42 Cards
    private static void print42Cards(Card[] card){
        System.out.println("\n\nThe remaining cards are:");
        for(int i = 10;i<card.length;i++){
            System.out.println(card[i]);
        }
    }

    //Returns the value of each hand
    static double handValue(Card[] Hand){
        double value = 0;
        //Ranks
        float[] ranks = {Hand[0].getRank(),Hand[1].getRank(),Hand[2].getRank(),Hand[3].getRank(),Hand[4].getRank()};

        //Suits
        int[] suits = {Hand[0].getSuit(),Hand[1].getSuit(),Hand[2].getSuit(),Hand[3].getSuit(),Hand[4].getSuit()};

        Arrays.sort(ranks);
        Arrays.sort(suits);

        //Uses methods for conditions to make it less crowded
        if((allSameSuit(suits))&&((ranks[0]+ranks[1]+ranks[2]+ranks[3]+ranks[4])==50)) //50 is the sum of all ranks of a royal flush
            value = 10;
        else if ((allSameSuit(suits))&&(straight(ranks)))
            value = 9 + (((ranks[0]+ranks[1]+ranks[2]+ranks[3]+ranks[4])/(60))) ; //60 Sum of highest possible hand
        else if(fourSameRank(ranks))
            value = 8 + (((ranks[0]+ranks[1]+ranks[2]+ranks[3]+ranks[4])/(60))) ;
        else if(fullHouse(ranks))
            value = 7 + (((ranks[0]+ranks[1]+ranks[2]+ranks[3]+ranks[4])/(60))) ;
        else if(allSameSuit(suits))
            value = 6 + (((ranks[0]+ranks[1]+ranks[2]+ranks[3]+ranks[4])/(60))) ;
        else if(straight(ranks))
            value = 5 + (((ranks[0]+ranks[1]+ranks[2]+ranks[3]+ranks[4])/(60))) ;
        else if(threeOfKind(ranks))
            value = 4 + (((ranks[0]+ranks[1]+ranks[2]+ranks[3]+ranks[4])/(60))) ;
        else if(twoPair(ranks))
            value = 3 + (((ranks[0]+ranks[1]+ranks[2]+ranks[3]+ranks[4])/(60))) ;
        else if(pair(ranks))
            value = 2 + (((ranks[0]+ranks[1]+ranks[2]+ranks[3]+ranks[4])/(60))) ;
        else
            value = 1 + (((ranks[0]+ranks[1]+ranks[2]+ranks[3]+ranks[4])/(60))) ;
        return value;
    }

    //CONDITIONS FOR HAND VALUE METHODS
    private static boolean allSameSuit(int[] suits){
        return (suits[0] == suits[1]) && (suits[1] == suits[2]) && (suits[2] == suits[3]) && (suits[3] == suits[4]);
    }
    private static boolean straight(float[] ranks){
        return ((ranks[0] + 1) == ranks[1]) && ((ranks[1] + 1) == ranks[2]) && ((ranks[2] + 1) == ranks[3]) && ((ranks[3] + 1) == ranks[4]);
    }
    private static boolean fourSameRank(float[] ranks){
        return ((ranks[0] == ranks[1]) && (ranks[1] == ranks[2]) && (ranks[2] == ranks[3])) || ((ranks[1] == ranks[2]) && (ranks[2] == ranks[3]) && (ranks[3] == ranks[4]));
    }
    private static boolean fullHouse(float[] ranks){
        return ((ranks[0] == ranks[1]) && ((ranks[1] == ranks[2]) && (ranks[2] == ranks[3])))
                ||
                (((ranks[0] == ranks[1]) && (ranks[1] == ranks[2])) && (ranks[3] == ranks[4]));
    }
    private static boolean threeOfKind(float[] ranks){
        return ((ranks[0] == ranks[1]) && (ranks[1] == ranks[2])) ||
                ((ranks[1] == ranks[2]) && (ranks[2] == ranks[3])) ||
                ((ranks[2] == ranks[3]) && (ranks[3] == ranks[4]));
    }
    private static boolean twoPair(float[] ranks){
        return ((ranks[0] == ranks[1]) && (ranks[2] == ranks[3])) ||
                ((ranks[1] == ranks[2]) && (ranks[3] == ranks[4])) ||
                ((ranks[0] == ranks[1]) && (ranks[3] == ranks[4]));
    }
    private static boolean pair(float[] ranks){
        return (ranks[0] == ranks[1]) ||
                (ranks[1] == ranks[2]) ||
                (ranks[2] == ranks[3]) ||
                (ranks[3] == ranks[4]);
    }

    //Takes in already calculated Hand Value and says what verbal classification it is
    static String classification(double handValue){
        String classi = "";
        if(handValue==10)
            classi = "Royal Flush";
        else if((handValue<10)&&(handValue>=9))
            classi = "Straight Flush";
        else if((handValue<9)&&(handValue>=8))
            classi = "Four of a Kind";
        else if((handValue<8)&&(handValue>=7))
            classi = "Full House";
        else if((handValue<7)&&(handValue>=6))
            classi = "Flush";
        else if((handValue<6)&&(handValue>=5))
            classi = "Straight";
        else if((handValue<5)&&(handValue>=4))
            classi = "Three of a Kind";
        else if((handValue<4)&&(handValue>3))
            classi = "Two Pair";
        else if((handValue<3)&&(handValue>=2))
            classi = "Pair";
        else if((handValue<2)&&(handValue>=1))
            classi = "High Card";
        return classi;
    }

    //Chooses winner depending on highest hand value of two
    //Else statement is for the Manual Input Main in case a user inputs two
    //equal hands or two hands are of the same value
    static void winningHand(double hand1V, double hand2V){
        if(hand1V>hand2V)
            System.out.println("\nThe first player wins");

        else if(hand1V<hand2V)
            System.out.println("\nThe second player wins");
        else
            System.out.println("\nBoth hands are of the same value.");
    }

}

