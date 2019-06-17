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

public class POS {
    private JTextField textField1;
    private JButton submitButton;
    public JPanel pos;
    private JList list1;

    public POS() {

        submitButton.addActionListener(new ActionListener() {
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
                JOptionPane.showMessageDialog(null,"Loading...");
                String text = textField1.getText();
                CoreDocument coreDocument = new CoreDocument(text);
                stanfordCoreNLP.annotate(coreDocument);
                List<CoreLabel> coreLabelList = coreDocument.tokens();
                for (CoreLabel coreLabel : coreLabelList){
                    String pos = coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                    JOptionPane.showMessageDialog(null,coreLabel.originalText()+" = "+pos);
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
}
