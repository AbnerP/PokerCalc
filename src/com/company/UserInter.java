package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class UserInter extends JFrame implements ActionListener, ItemListener {
    JComboBox<Integer> players = new JComboBox<>();
    JComboBox<Integer> nhands = new JComboBox<>();
    JTable stats = new JTable(14, 14);
    JPanel table = new JPanel();
    JButton sim = new JButton("SIMULATE");
    public static int nPlayers;
    public static boolean deal=false;
    public static ArrayList<Card> execps = new ArrayList<>();
    public static Card [] deckUsed = new Card[52];

    //Player Labels
    JLabel you = new JLabel("YOU");
    JLabel P2 = new JLabel("P2");
    JLabel P3 = new JLabel("P3");
    JLabel P4 = new JLabel("P4");
    JLabel P5 = new JLabel("P5");
    JLabel P6 = new JLabel("P6");
    JLabel P7 = new JLabel("P7");
    JLabel P8 = new JLabel("P8");
    JLabel P9 = new JLabel("P9");

    //Hands
    public static Hand hOne = new Hand();
    public static Hand hTwo = new Hand();
    public static Hand hThree = new Hand();
    public static Hand hFour = new Hand();
    public static Hand hFive = new Hand();
    public static Hand hSix = new Hand();
    public static Hand hSeven = new Hand();
    public static Hand hEight = new Hand();
    public static Hand hNine = new Hand();

    public static void main(String[] args){
        new UserInter().setVisible(true);
        Deck.orderedDeck(deckUsed);
    }

    public static void pChange(){
        if(nPlayers >= 2) {
            hOne = new Hand(deckUsed[0], deckUsed[1]);
            execps.add(hOne.getCard1());
            execps.add(hOne.getCard2());
            hTwo = rC(execps,deckUsed);
            System.out.println(hOne + "\n\t\tvs\n"+ hTwo);
        }
        if(nPlayers >= 3) {
            hThree = rC(execps,deckUsed);
            System.out.println("\t\tvs\n"+hThree);
        }
        if(nPlayers >= 4) {
            hFour = rC(execps,deckUsed);
            System.out.println("\t\tvs\n"+hFour);
        }
        if(nPlayers >= 5) {
            hFive = rC(execps,deckUsed);
            System.out.println("\t\tvs\n"+hFive);
        }
        if(nPlayers >= 6) {
            hSix = rC(execps,deckUsed);
            System.out.println("\t\tvs\n"+hSix);
        }
        if(nPlayers >= 7) {
            hSeven = rC(execps,deckUsed);
            System.out.println("\t\tvs\n"+hSeven);
        }
        if(nPlayers >= 8) {
            hEight = rC(execps,deckUsed);
            System.out.println("\t\tvs\n"+hEight);
        }
        if(nPlayers >= 9) {
            hNine = rC(execps,deckUsed);
            System.out.println("\t\tvs\n"+hNine);
        }
        //deal=false;
    }
    public UserInter() {
        setTitle("Poker Simulator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new BorderLayout());

        //Dropdown Box
        {
            JPanel top = new JPanel(new FlowLayout());
            JLabel nump = new JLabel("Players");
            top.add(nump);
            players.addItemListener(this);
            players.setSize(20, 20);
            players.addItem(2);
            players.addItem(3);
            players.addItem(4);
            players.addItem(5);
            players.addItem(6);
            players.addItem(7);
            players.addItem(8);
            players.addItem(9);
            top.add(players);
            JLabel numhands = new JLabel("# Simulated Hands");
            top.add(numhands);
            nhands.addItemListener(this);
            nhands.setSize(20, 20);
            nhands.addItem(10);
            nhands.addItem(50);
            nhands.addItem(100);
            nhands.addItem(150);
            nhands.addItem(250);
            nhands.addItem(500);
            nhands.addItem(1000);
            top.add(nhands);
            add(top, BorderLayout.NORTH);
        }

        //Player Card Arrangement
        {
            table.setLayout(new GridLayout(0, 8));
            table.add(new JLabel(""));
            table.add(you);
            JPanel c2 = new JPanel();
            c2.setLayout(new GridLayout(3, 0));
            c2.add(P2);
            c2.add(new JLabel("card"));
            c2.add(P3);
            table.add(c2);
            JPanel c3 = new JPanel();
            c3.setLayout(new GridLayout(3, 0));
            c3.add(P4);
            c3.add(new JLabel("card"));
            c3.add(P5);
            table.add(c3);
            JPanel c4 = new JPanel();
            c4.setLayout(new GridLayout(3, 0));
            c4.add(P6);
            c4.add(new JLabel("card"));
            c4.add(P7);
            table.add(c4);
            JPanel c5 = new JPanel();
            c5.setLayout(new GridLayout(3, 0));
            c5.add(P8);
            c5.add(new JLabel("card"));
            c5.add(P9);
            table.add(c5);
            table.add(new JLabel("card"));
            add(table, BorderLayout.CENTER);
        }

        //Simulate Button
        {
            add(sim,BorderLayout.SOUTH);
            sim.addActionListener(this);
        }

        //Deleted Things
        {
            //stats.setGridColor(Color.BLACK);
            //stats.setShowGrid(true);
            //stats.setShowHorizontalLines(true);
            //stats.setShowVerticalLines(true);
            //add(stats,BorderLayout.CENTER);
            //JLabel suited = new JLabel("Suited");
            //add(suited,BorderLayout.WEST);
        }

    }
    public static Hand rC(ArrayList<Card> exceps,Card [] deck){
        boolean cond = true;
        int tempind;
        Card [] temp = new Card[2];
        for(int i = 0;i<2;i++){
            while(cond) {
                tempind=(int) (Math.random() * 51);
                if (!(exceps.contains(deck[tempind]))) {
                    exceps.add(deck[tempind]);
                    temp[i] = deck[tempind];
                    cond = false;
                }
                else{
                    cond = true;
                }

            }
            cond = true;
        }
        return new Hand(temp[0],temp[1]);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        Object ob = e.getSource();

        if(cmd.equals("SIMULATE")){
            sim.setText("SIMULATING");
            sim.setText("DONE");
        }
        if(ob == sim)
            pChange();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object s = e.getItem();
        Object r = e.getSource();

        if(r == players){
            //System.out.println( s+" Players");
            if(s.equals(2)){
                nPlayers=2;
                you.setVisible(true);
                P2.setVisible(true);
                P3.setVisible(false);
                P4.setVisible(false);
                P5.setVisible(false);
                P6.setVisible(false);
                P7.setVisible(false);
                P8.setVisible(false);
                P9.setVisible(false);
            }
            else if(s.equals(3)){
                nPlayers=3;
                you.setVisible(true);
                P2.setVisible(true);
                P3.setVisible(true);
                P4.setVisible(false);
                P5.setVisible(false);
                P6.setVisible(false);
                P7.setVisible(false);
                P8.setVisible(false);
                P9.setVisible(false);
            }
            else if(s.equals(4)){
                nPlayers=4;
                you.setVisible(true);
                P2.setVisible(true);
                P3.setVisible(true);
                P4.setVisible(true);
                P5.setVisible(false);
                P6.setVisible(false);
                P7.setVisible(false);
                P8.setVisible(false);
                P9.setVisible(false);
            }
            else if(s.equals(5)){
                nPlayers=5;
                you.setVisible(true);
                P2.setVisible(true);
                P3.setVisible(true);
                P4.setVisible(true);
                P5.setVisible(true);
                P6.setVisible(false);
                P7.setVisible(false);
                P8.setVisible(false);
                P9.setVisible(false);
            }
            else if(s.equals(6)){
                nPlayers=6;
                you.setVisible(true);
                P2.setVisible(true);
                P3.setVisible(true);
                P4.setVisible(true);
                P5.setVisible(true);
                P6.setVisible(true);
                P7.setVisible(false);
                P8.setVisible(false);
                P9.setVisible(false);
            }
            else if(s.equals(7)){
                nPlayers=7;
                you.setVisible(true);
                P2.setVisible(true);
                P3.setVisible(true);
                P4.setVisible(true);
                P5.setVisible(true);
                P6.setVisible(true);
                P7.setVisible(true);
                P8.setVisible(false);
                P9.setVisible(false);
            }
            else if(s.equals(8)){
                nPlayers=8;
                you.setVisible(true);
                P2.setVisible(true);
                P3.setVisible(true);
                P4.setVisible(true);
                P5.setVisible(true);
                P6.setVisible(true);
                P7.setVisible(true);
                P8.setVisible(true);
                P9.setVisible(false);
            }
            else if(s.equals(9)){
                nPlayers=9;
                you.setVisible(true);
                P2.setVisible(true);
                P3.setVisible(true);
                P4.setVisible(true);
                P5.setVisible(true);
                P6.setVisible(true);
                P7.setVisible(true);
                P8.setVisible(true);
                P9.setVisible(true);
            }
        }

        if(r == nhands)
            System.out.println("Playing "+s+" hands");

    }
    public static void printCards(Card[] card){
        System.out.println("");
        for (Card value : card) {
            System.out.println(value);
        }
    }
}
//All Possible Hands
        /*
        ArrayList<Hand> hands = new ArrayList<>();
        int index = 0;
        for(int i = 0;i<deckUsed.length;i++){
          for(int j = (i+1);j<deckUsed.length;j++){
              card[0]=deckUsed[i];
              card[1]=deckUsed[j];
              hands.add(index,(new Hand(card[0],card[1])));
              index++;
          }
        }
        for(Hand h:hands)
           System.out.println(h);
        */