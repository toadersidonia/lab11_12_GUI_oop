import javax.swing.*;
import java.awt.*;

class CurrencyView extends JFrame {
    private JComboBox<String> fromCurrency;
    private JComboBox<String> toCurrency;
    private JTextField sumField;
    private JTextField resultField;
    private JLabel resultLabel;
    private JLabel sumLabel;
    private JButton convertButton;

    public CurrencyView() {
        setTitle("Currency Converter");
        setSize(300, 200);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel selectionPanel = new JPanel(new FlowLayout());
        fromCurrency = new JComboBox<>(new String[]{"RON", "EUR", "USD"});
        toCurrency = new JComboBox<>(new String[]{"RON", "EUR", "USD"});
        convertButton = new JButton("Convert");
        selectionPanel.add(new JLabel("From: "));
        selectionPanel.add(fromCurrency);
        selectionPanel.add(new JLabel("To: "));
        selectionPanel.add(toCurrency);
        selectionPanel.add(convertButton);

        JPanel inputOutputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        sumLabel = new JLabel("Sum:");
        sumField = new JTextField(10);
        resultLabel = new JLabel("Result:");
        resultField = new JTextField(10);
        resultField.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputOutputPanel.add(sumLabel, gbc);

        gbc.gridx = 1;
        inputOutputPanel.add(sumField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputOutputPanel.add(resultLabel, gbc);

        gbc.gridx = 1;
        inputOutputPanel.add(resultField, gbc);

        add(selectionPanel, BorderLayout.NORTH);
        add(inputOutputPanel, BorderLayout.CENTER);
    }

    public JComboBox<String> getFromCurrency() {
        return fromCurrency;
    }

    public JComboBox<String> getToCurrency() {
        return toCurrency;
    }

    public JTextField getSumField() {
        return sumField;
    }

    public JTextField getResultField() {
        return resultField;
    }

    public JButton getConvertButton() {
        return convertButton;
    }
}