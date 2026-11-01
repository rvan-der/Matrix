package fr.rvander.matrix;


import java.util.ArrayList;

import fr.rvander.matrix.exceptions.*;
import fr.rvander.matrix.scalars.*;


public class Vector<K extends Scalar> {

    private int size = 0;
    private ArrayList<K> vector = null;

    public Vector(int size, ArrayList<K> scalars)
    throws VectorCreationException {
        if (size != scalars.size()) {
            throw new VectorCreationException(
                "The size doesn't match the input"
            );
        }
        this.vector = scalars;
    }

    public int size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    public Matrix<K> toMatrix() throws Exception {
        ArrayList<K> column = new ArrayList<>();
        for (K scalar: this.vector) {
            column.add((K)scalar.clone());
        }
        ArrayList<ArrayList<K>> scalars = new ArrayList<>();
        scalars.add(column);
        return new Matrix<K>(this.size, 1, scalars);
    }

    public String toString() {
        StringBuilder strBd = new StringBuilder("[");
        for (int i = 0; i < this.size; i++) {
            if (i > 0) {
                strBd.append(", ");
            }
            strBd.append(this.vector.get(i).toString());
        }
        strBd.append("]");
        return strBd.toString();
    }

    public void print() {
        System.out.println(this.toString());
    }
}