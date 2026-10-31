package fr.rvander.matrix;


import fr.rvander.matrix.exceptions.*;
import fr.rvander.matrix.scalars.*;


public class Vector<K extends Scalar> {
    private int size = 0;
    private K[] vector = null;

    public Vector(int size, K[] scalars)
    throws VectorCreationException {
        if (size != scalars.length) {
            throw new VectorCreationException(
                "The size doesn't match the input"
            )
        }
    }
    // TO BE CONTINUED
}