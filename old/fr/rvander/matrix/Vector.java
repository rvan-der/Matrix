package fr.rvander.matrix;


import java.util.ArrayList;

import fr.rvander.matrix.exceptions.*;
import fr.rvander.matrix.scalars.*;


public class Vector<K extends Scalar> {

    private int size = 0;
    private ArrayList<K> vector = null;

    @SuppressWarnings("unchecked")
    public Vector(int size, ArrayList<K> scalars)
    throws VectorCreationException {
        if (size != scalars.size()) {
            throw new VectorCreationException(
                "The size doesn't match the input"
            );
        }
        this.size = size;
        this.vector = new ArrayList<>();
        for (K sc: scalars) {
            this.vector.add((K)sc.clone());
        }
    }

    public K get(int i) {
        return this.vector.get(i);
    }

    public int size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    public Vector<K> add(Vector<K> vector) throws Exception {
        if (this.size != vector.size()) {
            throw new VectorAdditionException("Vector sizes don't match");
        }
        ArrayList<K> scalars = new ArrayList<>();
        for (int i = 0; i < this.size; i++) {
            scalars.add((K)this.get(i).add(vector.get(i)));
        }
        return new Vector<K>(this.size, scalars);
    }

    @SuppressWarnings("unchecked")
    public Vector<K> sub(Vector<K> vector) throws Exception {
        if (this.size != vector.size()) {
            throw new VectorSubstractionException(
                "Vector sizes don't match"
            );
        }
        ArrayList<K> scalars = new ArrayList<>();
        for (int i = 0; i < this.size; i++) {
            scalars.add((K)this.get(i).sub(vector.get(i)));
        }
        return new Vector<K>(this.size, scalars);
    }

    @SuppressWarnings("unchecked")
    public Vector<K> scl(K scalar) throws Exception {
        ArrayList<K> scalars = new ArrayList<>();
        for (int i = 0; i < this.size; i++) {
            scalars.add((K)this.get(i).mul(scalar));
        }
        return new Vector<K>(this.size, scalars);
    }

    public Matrix<K> toMatrix() throws Exception {
        ArrayList<ArrayList<K>> scalars = new ArrayList<>();
        scalars.add(this.vector);
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