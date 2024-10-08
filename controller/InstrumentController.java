package controller;

import model.Instrument;
import model.InstrumentDAO;
import view.InstrumentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstrumentController {
    private InstrumentView view;
    private InstrumentDAO model;

    public InstrumentController(InstrumentView view, InstrumentDAO model) {
        this.view = view;
        this.model = model;

        view.addLoadButtonListener(new LoadInstrumentsListener());
        view.addAddButtonListener(new AddInstrumentListener());
    }

    class LoadInstrumentsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.displayInstruments(model.getAllInstruments());
        }
    }

    class AddInstrumentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getInstrumentName();
            double price = view.getInstrumentPrice();
            model.addInstrument(new Instrument(0, name, price)); // ID gerado automaticamente
            view.displayInstruments(model.getAllInstruments()); // Atualiza a lista
        }
    }
}
