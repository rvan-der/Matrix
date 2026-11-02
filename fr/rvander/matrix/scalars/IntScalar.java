package fr.rvander.matrix.scalars;


import fr.rvander.matrix.exceptions.*;


public class IntScalar extends Scalar {
    private int value;

    public IntScalar(Integer value) {
        this.value = value.intValue();
    }

    public IntScalar(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value.intValue();
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Scalar add(Scalar sc) throws Exception {
        if (sc instanceof IntScalar) {
            return new IntScalar(this.value + ((IntScalar)sc).value());
        }
        throw new ScalarAdditionException(null, this, sc);
    }

    public Scalar sub(Scalar sc) throws Exception {
        if (sc instanceof IntScalar) {
            return new IntScalar(this.value - ((IntScalar)sc).value());
        }
        throw new ScalarSubstractionException(null, this, sc);
    }

    public Scalar div(Scalar sc) throws Exception {
        if (sc instanceof IntScalar) {
            return new IntScalar((int)(this.value / ((IntScalar)sc).value()));
        }
        throw new ScalarDivisionException(null, this, sc);
    }

    public Scalar mul(Scalar sc) throws Exception {
        if (sc instanceof IntScalar) {
            return new IntScalar(this.value * ((IntScalar)sc).value());
        }
        throw new ScalarSubstractionException(null, this, sc);
    }

    public IntScalar clone() {
        return new IntScalar(this.value);
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}
