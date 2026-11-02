package fr.rvander.matrix.scalars;


import java.util.ArrayList;

import fr.rvander.matrix.exceptions.*;


public class DoubleScalar extends Scalar {
    private double value;

    public static ArrayList<DoubleScalar> makeList(double[] lst) {
        ArrayList<DoubleScalar> res = new ArrayList<>();
        for (double db: lst) {
            res.add(new DoubleScalar(db));
        }
        return res;
    }

    public DoubleScalar(Integer value) {
        this.value = value.doubleValue();
    }

    public DoubleScalar(int value) {
        this.value = (double)value;
    }

    public DoubleScalar(Long value) {
        this.value = value.doubleValue();
    }

    public DoubleScalar(long value) {
        this.value = (double)value;
    }

    public DoubleScalar(Float value) {
        this.value = value.doubleValue();
    }

    public DoubleScalar(float value) {
        this.value = (double)value;
    }

    public DoubleScalar(Double value) {
        this.value = value.doubleValue();
    }

    public DoubleScalar(double value) {
        this.value = value;
    }

    public double value() {
        return this.value;
    }

    public DoubleScalar setValue(Integer value) {
        this.value = value.doubleValue();
        return this;
    }

    public DoubleScalar setValue(int value) {
        this.value = (double)value;
        return this;
    }

    public DoubleScalar setValue(Long value) {
        this.value = value.doubleValue();
        return this;
    }

    public DoubleScalar setValue(long value) {
        this.value = (double)value;
        return this;
    }

    public DoubleScalar setValue(Float value) {
        this.value = value.doubleValue();
        return this;
    }

    public DoubleScalar setValue(float value) {
        this.value = (double)value;
        return this;
    }

    public DoubleScalar setValue(Double value) {
        this.value = value.doubleValue();
        return this;
    }

    public DoubleScalar setValue(double value) {
        this.value = value;
        return this;
    }

    public Scalar add(Scalar sc) throws Exception {
        if (sc instanceof DoubleScalar) {
            return new DoubleScalar(this.value + ((DoubleScalar)sc).value());
        }
        throw new ScalarAdditionException(null, this, sc);
    }

    public Scalar sub(Scalar sc) throws Exception {
        if (sc instanceof DoubleScalar) {
            return new DoubleScalar(this.value - ((DoubleScalar)sc).value());
        }
        throw new ScalarSubstractionException(null, this, sc);
    }

    public Scalar div(Scalar sc) throws Exception {
        if (sc instanceof DoubleScalar) {
            return new DoubleScalar(this.value / ((DoubleScalar)sc).value());
        }
        throw new ScalarDivisionException(null, this, sc);
    }

    public Scalar mul(Scalar sc) throws Exception {
        if (sc instanceof DoubleScalar) {
            return new DoubleScalar(this.value * ((DoubleScalar)sc).value());
        }
        throw new ScalarSubstractionException(null, this, sc);
    }

    public DoubleScalar clone() {
        return new DoubleScalar(this.value);
    }

    public String toString() {
        return Double.toString(this.value);
    }
}
