package fr.rvander.matrix;


import fr.rvander.matrix.exceptions.MatrixShapeException;


public class MatrixShape {
    private int rows;
    private int columns;

    public MatrixShape(int rows, int columns)
    throws MatrixShapeException {
        if (rows < 1 || columns < 1) {
            throw new MatrixShapeException(
                "Matrix shape can't have values less than 1"
            );
        }
        this.rows = rows;
        this.columns = columns;
    }

    public int rows() {
        return this.rows;
    }

    public int columns() {
        return this.columns;
    }

    public void invert() {
        int swap = this.columns;
        this.columns = this.rows;
        this.rows = swap;
    }
}
