package com.company;

public class Deck {

    //Creates an order deck using nested for loops
    public static void orderedDeck(Card [] deck){
        int cardsNum = 0; //Counter for index of array

        for(int rank = 12;rank>=0;rank--){
            for(int suit = 3;suit>=0;suit--){
                deck[cardsNum] = new Card(rank,suit);
                cardsNum++;
            }
        }

    }

    //Shuffles cards
    public static void shuffle(Card[] deck) {
        for(int i = 0;i<52;i++){
            int randomIndex = i + (int)(Math.random()*(52-i));

            Card temporary = deck[randomIndex];
            deck[randomIndex]=deck[i];
            deck[i]=temporary;
        }
    }
}
