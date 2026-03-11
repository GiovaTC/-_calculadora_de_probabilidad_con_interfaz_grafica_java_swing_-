package ui;

import service.ProbabilityService;

import javax.swing.*;
import java.awt.*;

public class ProbabilityCalculatorGUI extends JFrame {

    private JComboBox<String> operationBox;
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;

    private JLabel resultLabel;

    private ProbabilityService service = new ProbabilityService();

    public ProbabilityCalculatorGUI() {

        setTitle("Calculadora de Probabilidad");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6,2));

        operationBox = new JComboBox<>(new String[]{
                "Eventos Independientes",
                "Probabilidad Condicional",
                "Teorema de Bayes",
                "Permutaciones",
                "Combinaciones"
        });

        field1 = new JTextField();
        field2 = new JTextField();
        field3 = new JTextField();

        JButton calculateButton = new JButton("Calcular");

        resultLabel = new JLabel("Resultado:");

        add(new JLabel("Operacion"));
        add(operationBox);

        add(new JLabel("Parametro 1"));
        add(field1);

        add(new JLabel("Parametro 2"));
        add(field2);

        add(new JLabel("Parametro 3"));
        add(field3);

        add(calculateButton);
        add(resultLabel);

        calculateButton.addActionListener(e -> calculate());
    }

    private void calculate() {

        String operation = (String) operationBox.getSelectedItem();

        try {

            if(operation.equals("Eventos Independientes")) {

                double pA = Double.parseDouble(field1.getText());
                double pB = Double.parseDouble(field2.getText());

                double result = service.independent(pA,pB);

                resultLabel.setText("Resultado: " + result);
            }

            else if(operation.equals("Probabilidad Condicional")) {

                double pAB = Double.parseDouble(field1.getText());
                double pB = Double.parseDouble(field2.getText());

                double result = service.conditional(pAB,pB);

                resultLabel.setText("Resultado: " + result);
            }

            else if(operation.equals("Teorema de Bayes")) {

                double pBgivenA = Double.parseDouble(field1.getText());
                double pA = Double.parseDouble(field2.getText());
                double pB = Double.parseDouble(field3.getText());

                double result = service.bayes(pBgivenA,pA,pB);

                resultLabel.setText("Resultado: " + result);
            }

            else if(operation.equals("Permutaciones")) {

                int n = Integer.parseInt(field1.getText());
                int r = Integer.parseInt(field2.getText());

                long result = service.permutations(n,r);

                resultLabel.setText("Resultado: " + result);
            }

            else if(operation.equals("Combinaciones")) {

                int n = Integer.parseInt(field1.getText());
                int r = Integer.parseInt(field2.getText());

                long result = service.combinations(n,r);

                resultLabel.setText("Resultado: " + result);
            }

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(this,"Error en los datos");
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new ProbabilityCalculatorGUI().setVisible(true);
        });
    }
}   