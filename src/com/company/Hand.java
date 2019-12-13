package com.company;

public class Hand {
    Card card1;
    Card card2;

    public Hand() {
    }

    public Hand(Card card1,Card card2) {
        this.card1=card1;
        this.card2=card2;
    }

    public void setCard1(Card card1) {
        this.card1 = card1;
    }

    public void setCard2(Card card2) {
        this.card2 = card2;
    }

    public Card getCard1() {
        return card1;
    }

    public Card getCard2() {
        return card2;
    }

    @Override
    public String toString() {
        return card1 +" w/ " + card2;
    }
}
