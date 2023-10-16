package org.example.IntentoV1;

public class Bola {
    int x;
    int y;
    int posicion;

    Bola(int posicion) {
        this.x = 50 * posicion + 10;
        this.y = 0;
        this.posicion = posicion;
    }

    boolean mover() {
        y += 5;
        return y >= 600;
    }
}
