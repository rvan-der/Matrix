package fr.rvander.matrix;


import fr.rvander.matrix.exceptions.*;
import fr.rvander.matrix.scalars.*;


public class Matrix<K extends Scalar> {

    private MatrixShape shape = null;
    private K[][] matrix = null;

    @SuppressWarnings({"unchecked"})
    public Matrix(int rows, int columns, K[][] scalars)
    throws MatrixCreationException, MatrixShapeException {

        if (scalars == null || scalars.length != columns) {
            throw new MatrixCreationException(
                "Shape doesn't match the input"
            );
        }

        this.matrix = scalars.clone();

        for (int iCol = 0; iCol < columns; iCol++) {
            K[] column = scalars[iCol];
            if (column == null || column.length != rows) {
                throw new MatrixCreationException(
                    "Shape doesn't match the input"
                );
            }
            this.matrix[iCol] = column.clone();
            for (int iRow = 0; iRow < rows; iRow++) {
                K scalar = column[iRow];
                if (scalar == null) {
                    throw new MatrixCreationException(
                        "Null value in the input."
                    );
                }
                this.matrix[iCol][iRow] = (K)column[iRow].clone();
            }
        }

        this.shape = new MatrixShape(rows, columns);

    }

    public MatrixShape shape() {
        return this.shape;
    }
}
