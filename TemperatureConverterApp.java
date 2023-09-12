import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        JLabel label1 = new JLabel("Enter temperature in Celsius:");
        JTextField celsiusField = new JTextField(10);
        JLabel label2 = new JLabel("Enter temperature in Fahrenheit:");
        JTextField fahrenheitField = new JTextField(10);

        JButton celsiusToFahrenheitButton = new JButton("Convert to Fahrenheit");
        JButton fahrenheitToCelsiusButton = new JButton("Convert to Celsius");

        celsiusToFahrenheitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double celsius = Double.parseDouble(celsiusField.getText());
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    fahrenheitField.setText(String.format("%.2f", fahrenheit));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number for Celsius.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        fahrenheitToCelsiusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double fahrenheit = Double.parseDouble(fahrenheitField.getText());
                    double celsius = (fahrenheit - 32) * 5 / 9;
                    celsiusField.setText(String.format("%.2f", celsius));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number for Fahrenheit.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.add(label1);
        frame.add(celsiusField);
        frame.add(celsiusToFahrenheitButton);
        frame.add(label2);
        frame.add(fahrenheitField);
        frame.add(fahrenheitToCelsiusButton);

        frame.pack();
        frame.setVisible(true);
    }
}

