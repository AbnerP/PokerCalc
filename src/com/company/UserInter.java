package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class UserInter extends JFrame implements ActionListener, ItemListener {
    public static void main(String[] args){
        new UserInter().setVisible(true);
        Card [] deckUsed = new Card[52];
        Deck.orderedDeck(deckUsed);

        Card[] card = new Card[2];
        ArrayList<Hand> hands = new ArrayList<>();
        int index = 0;

        for(int i = 0;i<deckUsed.length;i++){
          for(int j = (i+1);j<deckUsed.length;j++){
              card[0]=deckUsed[i];
              card[1]=deckUsed[j];
              hands.add(index,(new Hand(card[0],card[1])));
              index--;
          }
        }

        //for(Hand h:hands)
         //   System.out.println(h);



    }

    /*public ArrayList<Hand> rC(ArrayList<Integer> exceps){
        ArrayList<Hand> hands;
        boolean cond = true;
        Integer[] r = new Integer[2];
        int ro;
        for(int i =0;i<3;i++){
            cond = true;
            while(cond) {
                ro = (int)(Math.random()*52);
                if(exceps.contains(ro)) {
                    cond = false;
                    r[i]=ro;
                }
            }
        }

    }*/

    JComboBox<Integer> players = new JComboBox<>();
    JComboBox<Integer> nhands = new JComboBox<>();
    JTable stats = new JTable(14, 14);
    JButton sim = new JButton("SIMULATE");

    public UserInter() {
        setTitle("Poker Simulator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new BorderLayout());

        JPanel top = new JPanel(new FlowLayout());
        JLabel nump = new JLabel("Players");
        top.add(nump);
        players.addItemListener(this);
        players.setSize(20,20);
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
        nhands.setSize(20,20);
        nhands.addItem(10);
        nhands.addItem(50);
        nhands.addItem(100);
        nhands.addItem(150);
        nhands.addItem(250);
        nhands.addItem(500);
        nhands.addItem(1000);
        top.add(nhands);
        add(top,BorderLayout.NORTH);

        stats.setGridColor(Color.BLACK);
        stats.setShowGrid(true);
        stats.setShowHorizontalLines(true);
        stats.setShowVerticalLines(true);
        add(stats,BorderLayout.CENTER);

        JLabel suited = new JLabel("Suited");
        add(suited,BorderLayout.WEST);

        add(sim,BorderLayout.SOUTH);
        sim.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        Object ob = e.getSource();

        if(cmd.equals("SIMULATE")){
            sim.setText("SIMULATING");
            sim.setText("DONE");
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object s = e.getItem();
        Object r = e.getSource();
        if(r == players)
            System.out.println( s+" Players");
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
