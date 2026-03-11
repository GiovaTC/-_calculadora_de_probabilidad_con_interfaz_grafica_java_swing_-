# -_calculadora_de_probabilidad_con_interfaz_grafica_java_swing_- :.
📊 Calculadora de Probabilidad con Interfaz Gráfica (Java Swing):

<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/d5183c8a-03b7-4542-bbb0-f3bb84d08f15" /> 

<img width="2644" height="1078" alt="image" src="https://github.com/user-attachments/assets/f9bcf713-9f0a-45b5-9627-7390bc36d00a" />  

Proyecto académico desarrollado en Java con interfaz gráfica (Swing) para realizar cálculos de probabilidad y combinatoria.

```

Este tipo de aplicación es común en cursos de probabilidad, estadística y simulación.
La aplicación permite calcular:
- Probabilidad de eventos independientes
- Probabilidad condicional
- Teorema de Bayes
- Permutaciones
- Combinaciones

### 🧰 Tecnologias:
- Java 17 / Java 21
- Swing (Interfaz gráfica)
- IntelliJ IDEA

### 📁 Arquitectura del Proyecto
src
 ├── service
 │     ProbabilityService.java
 │
 └── ui
       ProbabilityCalculatorGUI.java

1️⃣ Servicio de Probabilidad
Archivo:
ProbabilityService.java
Contiene las fórmulas matemáticas utilizadas por la aplicación.

package service;

public class ProbabilityService {

    // Eventos independientes
    public double independent(double pA, double pB) {
        return pA * pB;
    }

    // Probabilidad condicional
    public double conditional(double pAandB, double pB) {
        return pAandB / pB;
    }

    // Teorema de Bayes
    public double bayes(double pBgivenA, double pA, double pB) {
        return (pBgivenA * pA) / pB;
    }

    // Factorial
    public long factorial(int n) {

        long result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    // Permutaciones
    public long permutations(int n, int r) {
        return factorial(n) / factorial(n - r);
    }

    // Combinaciones
    public long combinations(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }
}

2️⃣ Interfaz Gráfica
Archivo:
ProbabilityCalculatorGUI.java
Contiene la interfaz gráfica desarrollada con Swing.

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

### 🖥 Resultado Visual Esperado

La aplicación mostrará una interfaz similar a la siguiente:

+--------------------------------------+
| Calculadora de Probabilidad          |
+--------------------------------------+

Operacion: [Eventos Independientes ▼]

Parametro 1: [        ]
Parametro 2: [        ]
Parametro 3: [        ]

        [ Calcular ]

Resultado: 0.35

### 📚 Ejemplos de Uso
Eventos Independientes
Datos de entrada:

P(A) = 0.5
P(B) = 0.3

Resultado:
P(A ∩ B) = 0.15
Permutaciones

Datos de entrada:
n = 5
r = 2

Resultado:
P(5,2) = 20

Combinaciones

Datos de entrada:
n = 10
r = 3

Resultado:
C(10,3) = 120

### 📈 Posibles Mejoras del Proyecto
El proyecto puede ampliarse con nuevas funcionalidades como:

📊 Gráficos de probabilidad utilizando JFreeChart
📁 Exportar cálculos a Excel
📉 Distribuciones estadísticas (Normal, Binomial, Poisson)
📚 Historial de cálculos
🧠 Simulación Monte Carlo / .
