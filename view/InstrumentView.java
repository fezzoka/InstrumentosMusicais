package view;

import model.Instrument;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class InstrumentView {
    private JFrame frame;
    private JTextArea textArea;
    private JTextField nameField;
    private JTextField priceField;
    private JButton loadButton;
    private JButton addButton;

    public InstrumentView() {
        frame = new JFrame("Instrument Store");
        textArea = new JTextArea(20, 50);
        nameField = new JTextField(20);
        priceField = new JTextField(10);
        loadButton = new JButton("Load Instruments");
        addButton = new JButton("Add Instrument");

        frame.setLayout(new FlowLayout());
        frame.add(new JLabel("Name:"));
        frame.add(nameField);
        frame.add(new JLabel("Price:"));
        frame.add(priceField);
        frame.add(addButton);
        frame.add(loadButton);
        frame.add(new JScrollPane(textArea));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void displayInstruments(List<Instrument> instruments) {
        textArea.setText("");
        for (Instrument instrument : instruments) {
            textArea.append(instrument.getName() + " - $" + instrument.getPrice() + "\n");
        }
    }

    public String getInstrumentName() {
        return nameField.getText();
    }

    public double getInstrumentPrice() {
        return Double.parseDouble(priceField.getText());
    }

    public void addLoadButtonListener(ActionListener listener) {
        loadButton.addActionListener(listener);
    }

    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }
}
