package org.example.IntentoV1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        BufferCompartido buffer = new BufferCompartido(100);
        EstacionDeTrabajo ws1 = new EstacionDeTrabajo(buffer);
        EstacionDeTrabajo ws2 = new EstacionDeTrabajo(buffer);
        LineaDeMontaje assembly = new LineaDeMontaje(buffer);

        Visualizacion visualizacion = new Visualizacion();
        visualizacion.setVisible(true);

        // Usando un ExecutorService con un pool de hilos fijo
        ExecutorService executor = Executors.newFixedThreadPool(3);  // 3 porque tienes 2 Workstations + 1 AssemblyLine
        executor.submit(ws1);
        executor.submit(ws2);
        executor.submit(assembly);

        // Lanzar un hilo separado para gestionar la visualización
        Thread visualizationThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(150);
                    visualizacion.agregarBola(dropBall());  // Simulando la caída de una bola
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();  // Es una buena práctica volver a interrumpir el hilo
                }
            }
        });
        visualizationThread.start();
    }
    private static int dropBall() {
        int decisions = 9;  // Ajustado a 9
        int position = 0;
        for (int i = 0; i < decisions; i++) {
            if (Math.random() > 0.5) {
                position++;
            }
        }
        return position;
    }


}
