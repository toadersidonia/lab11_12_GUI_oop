import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

class CurrencyController {
    private CurrencyModel model;
    private CurrencyView view;

    public CurrencyController(CurrencyModel model, CurrencyView view) {
        this.model = model;
        this.view = view;

        view.getConvertButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fromCurrency = view.getFromCurrency().getSelectedItem().toString();
                    String toCurrency = view.getToCurrency().getSelectedItem().toString();
                    double amount = Double.parseDouble(view.getSumField().getText());
                    double result = model.convert(fromCurrency, toCurrency, amount);
                    view.getResultField().setText(String.format("%.2f", result));
                } catch (NumberFormatException ex) {
                    view.getResultField().setText("Invalid input");
                }
            }
        });
    }
}
