package fr.rvander.matrix.ex00;


import java.util.ArrayList;
import fr.rvander.matrix.*;
import fr.rvander.matrix.scalars.DoubleScalar;


public class Ex00 {
    public void main(String[] args) {
        ArrayList<ArrayList<DoubleScalar>> m1Scalars = new ArrayList<>();
        m1Scalars.add(DoubleScalar.makeList(new double[] {111111, 2, 3}));
        m1Scalars.add(DoubleScalar.makeList(new double[] {1.222222222242, 2.3, 3.4}));
        m1Scalars.add(DoubleScalar.makeList(new double[] {-1, -2, -3}));

        try {
            Matrix<DoubleScalar> m1 = new Matrix<DoubleScalar>(
                3, 3, m1Scalars
            );
            System.err.println("m1 :");
            m1.prettyprint();
            
            System.out.println("\nm2 = m1 * -2 :");
            DoubleScalar dbSc = new DoubleScalar(-2);
            Matrix<DoubleScalar> m2 = m1.scl(dbSc);
            m2.prettyprint();

            System.err.println("\nm3 = m1 + m2");
            Matrix<DoubleScalar> m3 = m1.add(m2);
            m3.prettyprint();

        } catch (Exception e) {
			System.err.println(e);
		}
    }
}