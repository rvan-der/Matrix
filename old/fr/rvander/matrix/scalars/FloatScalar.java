package fr.rvander.matrix.scalars;


import java.util.ArrayList;

import fr.rvander.matrix.exceptions.*;


public class FloatScalar extends Scalar {
    private float value;

    public static ArrayList<FloatScalar> makeList(float[] lst) {
        ArrayList<FloatScalar> res = new ArrayList<>();
        for (float db: lst) {
            res.add(new FloatScalar(db));
        }
        return res;
    }

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

    public FloatScalar setValue(Integer value) {
        this.value = value.floatValue();
        return this;
    }

    public FloatScalar setValue(int value) {
        this.value = (float)value;
        return this;
    }

    public FloatScalar setValue(Float value) {
        this.value = value.floatValue();
        return this;
    }

    public FloatScalar setValue(float value) {
        this.value = value;
        return this;
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
