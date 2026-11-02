package fr.rvander.matrix.scalars;


import java.util.ArrayList;

import fr.rvander.matrix.exceptions.*;


public class LongScalar extends Scalar {
    private long value;

    public static ArrayList<LongScalar> makeList(long[] lst) {
        ArrayList<LongScalar> res = new ArrayList<>();
        for (long db: lst) {
            res.add(new LongScalar(db));
        }
        return res;
    }

    public LongScalar(Integer value) {
        this.value = value.longValue();
    }

    public LongScalar(int value) {
        this.value = value;
    }

    public LongScalar(Long value) {
        this.value = value.longValue();
    }

    public LongScalar(long value) {
        this.value = value;
    }

    public long value() {
        return this.value;
    }

    public LongScalar setValue(Integer value) {
        this.value = value.longValue();
        return this;
    }

    public LongScalar setValue(int value) {
        this.value = (long)value;
        return this;
    }

    public LongScalar setValue(Long value) {
        this.value = value.longValue();
        return this;
    }

    public LongScalar setValue(long value) {
        this.value = value;
        return this;
    }

    public Scalar add(Scalar sc) throws Exception {
        if (sc instanceof LongScalar) {
            return new LongScalar(this.value + ((LongScalar)sc).value());
        }
        throw new ScalarAdditionException(null, this, sc);
    }

    public Scalar sub(Scalar sc) throws Exception {
        if (sc instanceof IntScalar) {
            return new LongScalar(this.value - ((LongScalar)sc).value());
        }
        throw new ScalarSubstractionException(null, this, sc);
    }

    public Scalar div(Scalar sc) throws Exception {
        if (sc instanceof LongScalar) {
            return new LongScalar(
                (long)(this.value / ((LongScalar)sc).value())
            );
        }
        throw new ScalarDivisionException(null, this, sc);
    }

    public Scalar mul(Scalar sc) throws Exception {
        if (sc instanceof LongScalar) {
            return new LongScalar(this.value * ((LongScalar)sc).value());
        }
        throw new ScalarSubstractionException(null, this, sc);
    }

    public LongScalar clone() {
        return new LongScalar(this.value);
    }

    public String toString() {
        return Long.toString(this.value);
    }
}