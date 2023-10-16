package org.example.IntentoV1;

public class EstacionDeTrabajo extends Thread {
    private final BufferCompartido buffer;

    public EstacionDeTrabajo(BufferCompartido buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                buffer.producir();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

