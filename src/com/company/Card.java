package com.company;

public class Card {

    //Arrays for String Version of Cards
    private String[] rankArray = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
    private String[] suitArray = {"Spades","Diamonds","Clubs","Hearts"};
    //Index input for the String Array above and also used for calculations
    private int rank;
    private int suit;
    //The constructed card for DISPLAY ONLY in toString
    private String card;
    //Constructor
    public Card(int rank, int suit){
       this.rank=rank;
       this.suit=suit;
       this.card  = rankArray[this.rank]+" of "+suitArray[this.suit];
    }

    //Getters
    public int getSuit() {
        return this.suit;
    }
    public int getRank() {
        return this.rank;
    }

    //to String
    public String toString(){
       return card;
    }
}