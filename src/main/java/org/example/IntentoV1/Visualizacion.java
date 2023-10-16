package org.example.IntentoV1;

import javax.swing.*;
import java.awt.*;

public class Visualizacion extends JFrame {

    private int[] distribucionDeBolas;
    private int totalDeBolas;

    public Visualizacion() {
        this.distribucionDeBolas = new int[20];
        this.totalDeBolas = 0;

        setTitle("Distribución Normal - Tablero de Galton");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void agregarBola(int posicion) {
        distribucionDeBolas[posicion]++;
        totalDeBolas++;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < distribucionDeBolas.length; i++) {
            int altura = (int) (((float) distribucionDeBolas[i] / totalDeBolas) * 900);
            g.fillRect(i * 50, 500 - altura, 40, altura);
        }
    }
}
