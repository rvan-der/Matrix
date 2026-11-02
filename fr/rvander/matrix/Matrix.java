package fr.rvander.matrix;


import java.util.ArrayList;
import fr.rvander.matrix.exceptions.*;
import fr.rvander.matrix.scalars.*;


class MatrixShape {
    protected  int rows;
    protected  int columns;

    protected MatrixShape(int rows, int columns)
    throws MatrixShapeException {
        if (rows < 1 || columns < 1) {
            throw new MatrixShapeException(
                "Matrix shape can't have values less than 1"
            );
        }
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof MatrixShape)) {
            return false;
        }
        MatrixShape shape = (MatrixShape)obj;
        if (shape.rows == this.rows && shape.columns == this.columns) {
            return true;
        }
        return false;
    }

    public boolean isSquare() {
        return this.rows == this.columns ? true : false;
    }
}


public class Matrix<K extends Scalar> {

    private MatrixShape shape = null;
    private ArrayList<ArrayList<K>> matrix = null;

    public Matrix(int rows, int columns, ArrayList<ArrayList<K>> scalars)
    throws MatrixCreationException, MatrixShapeException {
        this.shape = new MatrixShape(rows, columns);
        if (scalars == null || scalars.size() != columns) {
            throw new MatrixCreationException(
                "Shape doesn't match the input"
            );
        }
        for (ArrayList<K> column: scalars) {
            if (column == null || column.size() != rows) {
                throw new MatrixCreationException(
                    "Shape doesn't match the input"
                );
            }
            for (K scalar: column) {
                if (scalar == null) {
                    throw new MatrixCreationException(
                        "Null value in the input."
                    );
                }
            }
        }
        this.matrix = scalars;
    }

    public K get(int iCol, int iRow) {
        return this.matrix.get(iCol).get(iRow);
    }

    @SuppressWarnings("unchecked")
    public Matrix<K> add(Matrix<K> matrix) throws Exception {
        if (!this.hasSameShape(matrix)) {
            throw new MatrixAdditionException(
                "The Matrices don't have matching shapes"
            );
        }
        ArrayList<ArrayList<K>> scalars = new ArrayList<>();
        for (int iCol = 0; iCol < this.shape.columns; iCol++) {
            ArrayList<K> newCol = new ArrayList<>();
            for (int iRow = 0; iRow < this.shape.rows; iRow++) {
                newCol.add(
                    (K)this.get(iCol, iRow).add(matrix.get(iCol, iRow))
                );
            }
            scalars.add(newCol);
        }
        return new Matrix<K>(this.shape.rows, this.shape.columns, scalars);
    }

    @SuppressWarnings("unchecked")
    public Matrix<K> sub(Matrix<K> matrix) throws Exception {
        if (!this.hasSameShape(matrix)) {
            throw new MatrixSubstractionException(
                "The Matrices don't have matching shapes"
            );
        }
        ArrayList<ArrayList<K>> scalars = new ArrayList<>();
        for (int iCol = 0; iCol < this.shape.columns; iCol++) {
            ArrayList<K> newCol = new ArrayList<>();
            for (int iRow = 0; iRow < this.shape.rows; iRow++) {
                newCol.add(
                    (K)this.get(iCol, iRow).sub(matrix.get(iCol, iRow))
                );
            }
            scalars.add(newCol);
        }
        return new Matrix<K>(this.shape.rows, this.shape.columns, scalars);
    }

    @SuppressWarnings("unchecked")
    public Matrix<K> scl(K scalar) throws Exception {
        ArrayList<ArrayList<K>> scalars = new ArrayList<>();
        for (int iCol = 0; iCol < this.shape.columns; iCol++) {
            ArrayList<K> newCol = new ArrayList<>();
            for (int iRow = 0; iRow < this.shape.rows; iRow++) {
                newCol.add(
                    (K)this.get(iCol, iRow).mul(scalar)
                );
            }
            scalars.add(newCol);
        }
        return new Matrix<K>(this.shape.rows, this.shape.columns, scalars);
    }

    public boolean hasSameShape(Matrix<K> matrix) {
        if (this.shape.equals(matrix.shape())) {
            return true;
        }
        return false;
    }

    public MatrixShape shape() {
        return this.shape;
    }

    public boolean isSquare() {
        return this.shape.isSquare();
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Vector<K>> toVectorList() throws Exception {
        ArrayList<Vector<K>> vectorList = new ArrayList<>();
        for (ArrayList<K> column: this.matrix) {
            ArrayList<K> scalars = new ArrayList<>();
            for (K scalar: column) {
                scalars.add((K)scalar.clone());
            }
            vectorList.add(new Vector<K>(this.shape.rows, scalars));
        }
        return vectorList;
    }

    public String toString() {
        StringBuilder strBd = new StringBuilder("[");
        for (int i = 0; i < this.shape.columns; i++) {
            if (i > 0) {
                strBd.append(" ");
            }
            ArrayList<K> column = this.matrix.get(i);
            strBd.append("[");
            for (int j = 0; j < column.size(); j++) {
                if (j > 0) {
                    strBd.append(", ");
                }
                strBd.append(column.get(j).toString());
            }
            strBd.append("]");
        }
        strBd.append("]");
        return strBd.toString();
    }

    public int rows() {
        return this.shape.rows;
    }

    public int columns() {
        return this.shape.columns;
    }

    public void print() {
        System.out.println(this.toString());
    }

    public void prettyprint() {
        StringBuilder strBd = new StringBuilder();
        int width = 0;
        for (ArrayList<K> column: this.matrix) {
            for (K scalar: column) {
                int l = scalar.toString().length();
                if (l > width)
                    width = l;
            }
        }
        for (int i = 0; i < this.shape.rows; i++) {
            if (i > 0)
                strBd.append("\n");
            strBd.append("[");
            for (int j = 0; j < this.shape.columns; j++) {
                if (j > 0)
                    strBd.append(" ");
                strBd.append(
                    String.format("%-"+width+"s", this.matrix.get(j).get(i))
                );
            }
            strBd.append("]");
        }
        System.out.println(strBd.toString());
    }
}
