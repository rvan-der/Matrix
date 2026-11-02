package fr.rvander.matrix.exceptions;


import fr.rvander.matrix.scalars.Scalar;


public class ScalarMultiplicationException extends Exception {
    public ScalarMultiplicationException(String msg, Scalar sc1, Scalar sc2) {
        if (msg == null) {
            msg = String.format(
                "Unsupported scalar operands for multiplication: %s and %s",
                sc1.getClass().getSimpleName(), sc2.getClass().getSimpleName()
            );
        }
        super(msg);
    }
}
