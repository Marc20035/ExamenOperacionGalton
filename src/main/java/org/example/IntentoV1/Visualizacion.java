package org.example.IntentoV1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArrayList;


public class Visualizacion extends JFrame {

    private int[] distribucionDeBolas;
    private int totalDeBolas;
    private CopyOnWriteArrayList<Bola> bolas = new CopyOnWriteArrayList<>();


    public Visualizacion() {
        this.distribucionDeBolas = new int[10];  // Vuelvo a 10 columnas como en la imagen
        this.totalDeBolas = 0;
        this.bolas = new CopyOnWriteArrayList<>();

        setTitle("Distribución Normal - Tablero de Galton");
        setSize(550, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void agregarBola(int posicion) {
        Bola bola = new Bola(posicion);
        bolas.add(bola);

        // Iniciar animación de la bola
        Timer timer = new Timer(true);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (bola.mover()) {
                    distribucionDeBolas[bola.posicion]++;
                    totalDeBolas++;
                    bolas.remove(bola);
                    cancel();
                }
                repaint();
            }
        };
        timer.schedule(task, 0, 10);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);


        // Dibujar los clavos
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                g.setColor(Color.DARK_GRAY);
                g.fillOval(50 * i + (j % 2) * 25, j * 50 + 50, 10, 10);
            }
        }
        for (Bola bola : bolas) {
            g.setColor(Color.BLUE);
            g.fillOval(bola.x, bola.y, 15, 15);
        }

        // Dibujar la distribución de bolas
        for (int i = 0; i < distribucionDeBolas.length; i++) {
            int altura = (int) (((float) distribucionDeBolas[i] / totalDeBolas) * 600);
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(i * 50 + 10, 700 - altura, 30, altura);
        }
    }

}
