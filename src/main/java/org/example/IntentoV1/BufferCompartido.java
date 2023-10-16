package org.example.IntentoV1;

import java.util.LinkedList;

public class BufferCompartido {
    private final LinkedList<String> buffer;
    private final int CAPACIDAD;

    public BufferCompartido(int capacidad) {
        this.buffer = new LinkedList<>();
        this.CAPACIDAD = capacidad;
    }

    public synchronized void producir() throws InterruptedException {
        while (buffer.size() == CAPACIDAD) {
            wait();
        }
        buffer.add("componente");
        notifyAll();
    }

    public synchronized String consumir() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();
        }
        String componente = buffer.removeFirst();
        notifyAll();
        return componente;
    }
}
