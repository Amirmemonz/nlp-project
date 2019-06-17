package com.amirmemon.npl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NLPMenu {
    private JPanel Menu;
    private JButton textRecognizerButton;
    private JButton partsOfSpeechButton;
    private JButton sentimentAnalyserButton;

    public NLPMenu() {
        textRecognizerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Text Recognizer");
                frame.setContentPane(new NER().MainPanel);
                frame.pack();
                frame.setVisible(true);
            }
        });
        partsOfSpeechButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("POS Recognizer");
                frame.setContentPane(new POS().pos);
                frame.pack();
                frame.setVisible(true);
            }
        });
        sentimentAnalyserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Sentiment Analyzer");
                frame.setContentPane(new Sentiment().sentiment);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Stanford NLP");
        frame.setContentPane(new NLPMenu().Menu);
        frame.pack();
        frame.setVisible(true);
    }
}
