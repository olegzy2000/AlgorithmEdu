package org.example.Math.chess.model;

import java.util.Objects;

public class LinerFunction {
    private float k;
    private float b;

    public LinerFunction() {
    }

    public LinerFunction(float k, float b) {
        this.k = k;
        this.b = b;
    }

    public float getK() {
        return k;
    }

    public void setK(float k) {
        this.k = k;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LinerFunction that = (LinerFunction) object;
        return Float.compare(k, that.k) == 0 && Float.compare(b, that.b) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(k, b);
    }
}
