package com.company;

public class Hand {
    Card card1;
    Card card2;

    public Hand(Card card1,Card card2) {
        this.card1=card1;
        this.card2=card2;
    }

    @Override
    public String toString() {
        return card1 +" w/ " + card2;
    }
}
