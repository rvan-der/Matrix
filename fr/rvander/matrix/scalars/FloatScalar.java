package fr.rvander.matrix.scalars;


import fr.rvander.matrix.exceptions.*;


public class FloatScalar extends Scalar {
    private float value;

    public FloatScalar(Integer value) {
        this.value = value.floatValue();
    }

    public FloatScalar(int value) {
        this.value = (float)value;
    }

    public FloatScalar(Float value) {
        this.value = value.floatValue();
    }

    public FloatScalar(float value) {
        this.value = value;
    }

    public float value() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value.floatValue();
    }

    public void setValue(int value) {
        this.value = (float)value;
    }

    public void setValue(Float value) {
        this.value = value.floatValue();
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Scalar add(Scalar sc) throws Exception {
        if (sc instanceof FloatScalar) {
            return new FloatScalar(this.value + ((FloatScalar)sc).value());
        }
        throw new ScalarAdditionException(null, this, sc);
    }

    public Scalar sub(Scalar sc) throws Exception {
        if (sc instanceof FloatScalar) {
            return new FloatScalar(this.value - ((FloatScalar)sc).value());
        }
        throw new ScalarSubstractionException(null, this, sc);
    }

    public Scalar div(Scalar sc) throws Exception {
        if (sc instanceof FloatScalar) {
            return new FloatScalar(this.value / ((FloatScalar)sc).value());
        }
        throw new ScalarDivisionException(null, this, sc);
    }

    public Scalar mul(Scalar sc) throws Exception {
        if (sc instanceof FloatScalar) {
            return new FloatScalar(this.value * ((FloatScalar)sc).value());
        }
        throw new ScalarSubstractionException(null, this, sc);
    }

    public FloatScalar clone() {
        return new FloatScalar(this.value);
    }

    public String toString() {
        return Float.toString(this.value);
    }
}
