package fr.rvander.matrix.scalars;


import fr.rvander.matrix.exceptions.*;


public class IntScalar extends Scalar {
    private long value;

    public IntScalar(Integer value) {
        this.value = value.longValue();
    }

    public IntScalar(long value) {
        this.value = value;
    }

    public IntScalar(int value) {
        this.value = (long)value;
    }

    public long value() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value.longValue();
    }

    public Scalar sum(Scalar sc) throws Exception {
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
            return new IntScalar(this.value / ((IntScalar)sc).value());
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

}
