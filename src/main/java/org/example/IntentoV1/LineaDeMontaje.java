package org.example.IntentoV1;



public class LineaDeMontaje extends Thread {
    private final BufferCompartido buffer;

    public LineaDeMontaje(BufferCompartido buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                buffer.consumir();
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

