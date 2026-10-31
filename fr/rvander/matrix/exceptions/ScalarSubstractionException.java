package fr.rvander.matrix.exceptions;


import fr.rvander.matrix.scalars.Scalar;


public class ScalarSubstractionException extends Exception {
    public ScalarSubstractionException(String msg, Scalar sc1, Scalar sc2) {
        if (msg == null) {
            msg = String.format(
                "Unsupported scalar operands for substraction: %s and %s",
                sc1.getClass().getSimpleName(), sc2.getClass().getSimpleName()
            );
        }
        super(msg);
    }
}
