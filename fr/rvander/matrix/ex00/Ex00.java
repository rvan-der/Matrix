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

        Matrix<DoubleScalar> m1=null, m2=null, m3=null, m4=null, m5=null;

        try {
            System.out.println("m1 :");
            m1 = new Matrix<DoubleScalar>(
                3, 3, m1Scalars
            );
            m1.prettyprint();
        } catch (Exception e) {
			System.err.println(e);
		}
            
        try {
            System.out.println("\nm2 = m1 * -2 :");
            DoubleScalar dbSc = new DoubleScalar(-2);
            m2 = m1.scl(dbSc);
            m2.prettyprint();
        } catch (Exception e) {
			System.err.println(e);
		}

        try {
            System.out.println("\nm3 = m1 + m2");
            m3 = m1.add(m2);
            m3.prettyprint();
        } catch (Exception e) {
			System.err.println(e);
		}

        try {
            System.out.println("\nm4 = m1 - m2");
            m4 = m1.sub(m2);
            m4.prettyprint();
        } catch (Exception e) {
			System.err.println(e);
		}

        try {
            System.out.println("\nm5 :");
            m1Scalars.add(DoubleScalar.makeList(new double[] {0, 0.1, 0.2}));
            m5 = new Matrix<DoubleScalar>(3, 4, m1Scalars);
            m5.prettyprint();
            System.out.println("\ntry m5 + m1");
            m5.add(m1);
        } catch (Exception e) {
			System.err.println(e);
		}
    }
}