package fr.rvander.matrix.scalars;


public abstract class Scalar {
    public abstract Scalar add(Scalar sc) throws Exception;
    public abstract Scalar sub(Scalar sc) throws Exception;
    public abstract Scalar div(Scalar sc) throws Exception;
    public abstract Scalar mul(Scalar sc) throws Exception;
    public abstract Scalar clone();
    public abstract String toString();
}
