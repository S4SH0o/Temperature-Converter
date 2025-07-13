import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel inputLabel = new JLabel("Temperature Converter");
        JTextField inputField = new JTextField();
        frame.add(inputLabel);
        frame.add(inputField);

        JLabel fromLabel = new JLabel("From:");
        String[] units = {"Celsius", "Fahrenheit", "Kelvin"};
        JComboBox<String> fromBox = new JComboBox<>(units);
        frame.add(fromLabel);
        frame.add(fromBox);

        JLabel toLabel = new JLabel("To:");
        JComboBox<String> toBox = new JComboBox<>(units);
        frame.add(toLabel);
        frame.add(toBox);

        JButton convertButton = new JButton("Convert");
        JLabel resultLabel = new JLabel("Result");
        frame.add(convertButton);
        frame.add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double inputTemp = Double.parseDouble(inputField.getText());
                    String fromUnit = (String) fromBox.getSelectedItem();
                    String toUnit = (String) toBox.getSelectedItem();

                    double result = convertTemperature(inputTemp, fromUnit, toUnit);
                    resultLabel.setText(String.format("Result: %.2f %s", result, toUnit));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input!");
                }
            }

            public double convertTemperature(double temp, String from, String to) {
                double celsius;
                if (from.equals("Celsius")) {
                    celsius = temp;
                } else if (from.equals("Fahrenheit")) {
                    celsius = (temp - 32) * 5 / 9;
                } else {
                    celsius = temp - 273.15;
                }

                if (to.equals("Celsius")) {
                    return celsius;
                } else if (to.equals("Fahrenheit")) {
                    return (celsius * 9 / 5) + 32;
                } else {
                    return celsius + 273.15;
                }
            }
        });

        frame.setVisible(true);
    }
}
