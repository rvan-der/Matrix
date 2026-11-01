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

    protected boolean isSquare() {
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
        for (int i = 0; i < this.shape.rows; i++) {
            if (i > 0) {
                strBd.append("\n\n");
            }
            strBd.append("[");
            for (int j = 0; j < this.shape.columns; j++) {
                if (j > 0) {
                    strBd.append(" ");
                }
                strBd.append(
                    String.format("%-12s", this.matrix.get(j).get(i))
                );
            }
            strBd.append("]");
        }
    }
}
