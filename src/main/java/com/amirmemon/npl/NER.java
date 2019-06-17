package com.amirmemon.npl;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NER extends JFrame {
    private JTextField textField1;
    private JButton button1;
    public JPanel MainPanel;
    private JButton personButton;
    private JButton dateButton;
    private JButton countryButton;
    private JButton emailButton;
    private JButton stateOrProvinceButton;



    public NER(){
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Input s = new Input(textField1.getText());
                ObjectOutputStream outputStream = null;
                try {
                    ArrayList<Input> StudentList = readAllData();
                    StudentList.add(s);
                    outputStream = new ObjectOutputStream(new FileOutputStream("new.txt"));

                    for (int i = 0; i < StudentList.size(); i++) {
                        outputStream.writeObject(StudentList.get(i));
                    }
                } catch (IOException e1) {
                    System.out.println("IO Exception while opening file");
                } finally {
                    try {
                        if (outputStream != null) {
                            outputStream.close();
                        }
                    } catch (IOException e2) {
                        System.out.println("IO Exception while closing file");
                    }
                }
                StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
                String text = textField1.getText();
                CoreDocument coreDocument = new CoreDocument(text);
                stanfordCoreNLP.annotate(coreDocument);
                List<CoreLabel> coreLabelList = coreDocument.tokens();

                for (CoreLabel coreLabel : coreLabelList) {
                    String x = "CITY";
                    String ner = coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                    System.out.println(coreLabel.originalText()+" "+ner);
                    if(ner.equals(x)){
                        JOptionPane.showMessageDialog(null,coreLabel.originalText()+" Is "+ner);
                    }
                }
            }
        });
        personButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
                String text = textField1.getText();
                CoreDocument coreDocument = new CoreDocument(text);
                stanfordCoreNLP.annotate(coreDocument);
                List<CoreLabel> coreLabelList = coreDocument.tokens();

                for (CoreLabel coreLabel : coreLabelList) {
                    String x = "PERSON";
                    String ner = coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                    System.out.println(coreLabel.originalText()+" "+ner);
                    if(ner.equals(x)){
                        JOptionPane.showMessageDialog(null,coreLabel.originalText()+" Is "+ner);
                    }
                }
            }
        });
        dateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
                String text = textField1.getText();
                CoreDocument coreDocument = new CoreDocument(text);
                stanfordCoreNLP.annotate(coreDocument);
                List<CoreLabel> coreLabelList = coreDocument.tokens();

                for (CoreLabel coreLabel : coreLabelList) {
                    String x = "DATE";
                    String ner = coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                    System.out.println(coreLabel.originalText()+" "+ner);
                    if(ner.equals(x)){
                        JOptionPane.showMessageDialog(null,coreLabel.originalText()+" Is "+ner);
                    }
                }
            }
        });
        countryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
                String text = textField1.getText();
                CoreDocument coreDocument = new CoreDocument(text);
                stanfordCoreNLP.annotate(coreDocument);
                List<CoreLabel> coreLabelList = coreDocument.tokens();

                for (CoreLabel coreLabel : coreLabelList) {
                    String x = "COUNTRY";
                    String ner = coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                    System.out.println(coreLabel.originalText()+" "+ner);
                    if(ner.equals(x)){
                        JOptionPane.showMessageDialog(null,coreLabel.originalText()+" Is "+ner);
                    }
                }
            }
        });
        emailButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
                String text = textField1.getText();
                CoreDocument coreDocument = new CoreDocument(text);
                stanfordCoreNLP.annotate(coreDocument);
                List<CoreLabel> coreLabelList = coreDocument.tokens();

                for (CoreLabel coreLabel : coreLabelList) {
                    String x = "EMAIL";
                    String ner = coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                    System.out.println(coreLabel.originalText()+" "+ner);
                    if(ner.equals(x)){
                        JOptionPane.showMessageDialog(null,coreLabel.originalText()+" Is "+ner);
                    }
                }
            }
        });
        stateOrProvinceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
                String text = textField1.getText();
                CoreDocument coreDocument = new CoreDocument(text);
                stanfordCoreNLP.annotate(coreDocument);
                List<CoreLabel> coreLabelList = coreDocument.tokens();

                for (CoreLabel coreLabel : coreLabelList) {
                    String x = "STATE_OR_PROVINCE";
                    String ner = coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                    System.out.println(coreLabel.originalText()+" "+ner);
                    if(ner.equals(x)){
                        JOptionPane.showMessageDialog(null,coreLabel.originalText()+" Is "+ner);
                    }
                }
            }
        });
    }

    public ArrayList<Input> readAllData() {
        ArrayList<Input> StudentList = new ArrayList<Input>(0);
        ObjectInputStream inputStream = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("new.txt"));
            boolean EOF = false;
            while (!EOF) {
                try {
                    Input myObj = (Input) ois.readObject();
                    StudentList.add(myObj);
                } catch (ClassNotFoundException e) {
                    System.out.println("Class Not Found");
                } catch (EOFException end) {
                    EOF = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cant Find File");
        } catch (IOException e) {
            System.out.println("IO Exception While Opening File");

        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();

            } catch (IOException e) {
                System.out.println("IO Closing file");
            }
        }
        return StudentList;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Recognizer");
        frame.setContentPane(new NER().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
