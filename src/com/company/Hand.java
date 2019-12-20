package com.company;

import java.util.Arrays;

public class Hand {
    static Card card1;
    static Card card2;

    public Hand() {
    }

    public Hand(Card card1,Card card2) {
        this.card1=card1;
        this.card2=card2;
    }

    public double handValueCalc(Card[] tCards){
        double value = 0;
        //Cards
        float[] ranks = {tCards[0].getRank(),tCards[1].getRank(),tCards[2].getRank(),tCards[3].getRank(),tCards[4].getRank(),card1.getRank(),card2.getRank()};
        //Suits
        float[] suits = {tCards[0].getSuit(),tCards[1].getSuit(),tCards[2].getSuit(),tCards[3].getSuit(),tCards[4].getSuit(),card1.getSuit(),card2.getSuit()};
        Arrays.sort(ranks);
        Arrays.sort(suits);

        if(straight(ranks)&&flush(suits))
            value = 9 + (((ranks[0]+ranks[1]+ranks[2]+ranks[3]+ranks[4]+ranks[5]+ranks[6])/(82))) ;
        else if(fourOfaKind(ranks))
            value = 8 + (((ranks[0]+ranks[1]+ranks[2]+ranks[3]+ranks[4]+ranks[5]+ranks[6])/(82))) ;
        else if(fullHouse(ranks))
            value = 7 + (((ranks[0]+ranks[1]+ranks[2]+ranks[3]+ranks[4]+ranks[5]+ranks[6])/(82))) ;
        else if(flush(suits))
            value = 6 + (((ranks[0]+ranks[1]+ranks[2]+ranks[3]+ranks[4]+ranks[5]+ranks[6])/(82))) ;
        else if(straight(ranks))
            value = 5 + (((ranks[0]+ranks[1]+ranks[2]+ranks[3]+ranks[4]+ranks[5]+ranks[6])/(82))) ;
        else if(threeOfaKind(ranks))
            value = 4 + (((ranks[0]+ranks[1]+ranks[2]+ranks[3]+ranks[4]+ranks[5]+ranks[6])/(82))) ;
        else if(twoPair(ranks))
            value = 3 + (((ranks[0]+ranks[1]+ranks[2]+ranks[3]+ranks[4]+ranks[5]+ranks[6])/(82))) ;
        else if(pair(ranks))
            value = 2 + (((ranks[0]+ranks[1]+ranks[2]+ranks[3]+ranks[4]+ranks[5]+ranks[6])/(82))) ;
        else
            value = 1 + (((ranks[0]+ranks[1]+ranks[2]+ranks[3]+ranks[4]+ranks[5]+ranks[6])/(82))) ;

        return value;
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

    static boolean straight(float[] ranks){
        return ((ranks[0] < ranks[1]) && (ranks[1] < ranks[2]) && (ranks[2] < ranks[3]) && (ranks[3] < ranks[4]))
                ||
                ((ranks[1] < ranks[2]) && (ranks[2] < ranks[3]) && (ranks[3] < ranks[4]) && (ranks[4] < ranks[5]))
                ||
                ((ranks[2] < ranks[3]) && (ranks[3] < ranks[4]) && (ranks[4] < ranks[5]) && (ranks[5] < ranks[6]));
    }
    static boolean flush(float[] suit){
        return ((suit[0] == suit[1]) && (suit[1] == suit[2]) && (suit[2] == suit[3]) && (suit[3] == suit[4]))
                ||
                ((suit[1] == suit[2]) && (suit[2] == suit[3]) && (suit[3] == suit[4]) && (suit[4] == suit[5]))
                ||
                ((suit[2] == suit[3]) && (suit[3] == suit[4]) && (suit[4] == suit[5]) && (suit[5] == suit[6]));
    }
    static boolean fourOfaKind(float[] ranks){
        return ((ranks[0] == ranks[1]) && (ranks[1] == ranks[2]) && (ranks[2] == ranks[3]))
                ||
                ((ranks[1] == ranks[2]) && (ranks[2] == ranks[3]) && (ranks[3] == ranks[4]))
                ||
                ((ranks[2] == ranks[3]) && (ranks[3] == ranks[4]) && (ranks[4] == ranks[5]))
                ||
                ((ranks[3] == ranks[4]) && (ranks[4] == ranks[5]) && (ranks[5] == ranks[6]));
    }
    static boolean fullHouse(float[] ranks){
        return ((ranks[0] == ranks[1]) && (ranks[1] == ranks[2]) && (ranks[3] == ranks[4]))
                ||
                ((ranks[0] == ranks[1]) && (ranks[1] == ranks[2]) && (ranks[4] == ranks[5]))
                ||
                ((ranks[0] == ranks[1]) && (ranks[1] == ranks[2]) && (ranks[5] == ranks[6]))
                || //
                ((ranks[1] == ranks[2]) && (ranks[2] == ranks[3]) && (ranks[4] == ranks[5]))
                ||
                ((ranks[1] == ranks[2]) && (ranks[2] == ranks[3]) && (ranks[5] == ranks[6]))
                || //
                ((ranks[2] == ranks[3]) && (ranks[3] == ranks[4]) && (ranks[0] == ranks[1]))
                ||
                ((ranks[2] == ranks[3]) && (ranks[3] == ranks[4]) && (ranks[5] == ranks[6]))
                ||//
                ((ranks[3] == ranks[4]) && (ranks[4] == ranks[5]) && (ranks[0] == ranks[1]))
                ||
                ((ranks[3] == ranks[4]) && (ranks[4] == ranks[5]) && (ranks[1] == ranks[2]))
                ||//
                ((ranks[4] == ranks[5]) && (ranks[5] == ranks[6]) && (ranks[0] == ranks[1]))
                ||
                ((ranks[4] == ranks[5]) && (ranks[5] == ranks[6]) && (ranks[1] == ranks[2]))
                ||
                ((ranks[4] == ranks[5]) && (ranks[5] == ranks[6]) && (ranks[2] == ranks[3]));
    }
    static boolean threeOfaKind(float[] ranks){
        return ((ranks[0] == ranks[1]) && (ranks[1] == ranks[2]))
                ||
                ((ranks[1] == ranks[2]) && (ranks[3] == ranks[4]))
                ||
                ((ranks[2] == ranks[3]) && (ranks[3] == ranks[4]))
                ||
                ((ranks[4] == ranks[5]) && (ranks[5] == ranks[6]));
    }
    static boolean twoPair(float[] ranks){
         return ((ranks[0] == ranks[1]) && (ranks[2] == ranks[3]))
                ||
                ((ranks[0] == ranks[1]) && (ranks[3] == ranks[4]))
                ||
                ((ranks[0] == ranks[1]) && (ranks[4] == ranks[5]))
                ||
                ((ranks[0] == ranks[1]) && (ranks[5] == ranks[6]))
                ||
                ((ranks[1] == ranks[2]) && (ranks[3] == ranks[4]))
                ||
                ((ranks[1] == ranks[2]) && (ranks[4] == ranks[5]))
                ||
                ((ranks[1] == ranks[2]) && (ranks[5] == ranks[6]))
                ||
                ((ranks[2] == ranks[3]) && (ranks[4] == ranks[5]))
                ||
                ((ranks[2] == ranks[3]) && (ranks[5] == ranks[6]))
                ||
                ((ranks[3] == ranks[4]) && (ranks[5] == ranks[6]));
    }
    static boolean pair(float[] ranks){
        return (ranks[0] == ranks[1])
                ||
                (ranks[1] == ranks[2])
                ||
                (ranks[2] == ranks[3])
                ||
                (ranks[3] == ranks[4])
                ||
                (ranks[4] == ranks[5])
                ||
                (ranks[05] == ranks[6]);
    }

}
