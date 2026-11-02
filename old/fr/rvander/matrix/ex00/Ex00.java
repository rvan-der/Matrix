package fr.rvander.matrix.ex00;


import java.util.ArrayList;
import fr.rvander.matrix.*;
import fr.rvander.matrix.scalars.DoubleScalar;
import fr.rvander.matrix.scalars.IntScalar;


public class Ex00 {
    public void main(String[] args) throws Exception {

        double[][] test = new double[][] {
            new double[] {1,2},
            new double[] {3,4}
        };
        
        Matrix<DoubleScalar> md1=null, md2=null, md3=null, md4=null, md5=null;
        DoubleScalar dbSc = new DoubleScalar(0);

        ArrayList<ArrayList<DoubleScalar>> md1Scalars = new ArrayList<>();
        md1Scalars.add(DoubleScalar.makeList(new double[] {111111, 2, 3}));
        md1Scalars.add(DoubleScalar.makeList(new double[] {1.222222224321, 2.3, 3.4}));
        md1Scalars.add(DoubleScalar.makeList(new double[] {-1, -2, -3}));

        System.out.println("md1 :");
        md1 = new Matrix<DoubleScalar>(3, 3, md1Scalars);
        md1.prettyprint();
            
        System.out.println("\nm2 = md1 * -2 :");
        md2 = md1.scl(dbSc.setValue(-2));
        md2.prettyprint();

        System.out.println("\nm3 = md1 + md2");
        md3 = md1.add(md2);
        md3.prettyprint();

        System.out.println("\nm4 = md1 - md2");
        md4 = md1.sub(md2);
        md4.prettyprint();

        System.out.println("\nm5 :");
        md1Scalars.add(DoubleScalar.makeList(new double[] {0, 0.1, 0.2}));
        md5 = new Matrix<DoubleScalar>(3, 4, md1Scalars);
        md5.prettyprint();

        System.out.println("\ntry md5 + md1 :");
        try {
            md5.add(md1);
        } catch (Exception e) {
			System.err.println(e);
		}
        
        Matrix<IntScalar> mi1;

        ArrayList<ArrayList<IntScalar>> mi1Scalars = new ArrayList<>();
        mi1Scalars.add(IntScalar.makeList(new int[] {1, 2, 3}));
        mi1Scalars.add(IntScalar.makeList(new int[] {3, 2, 1}));
        mi1Scalars.add(IntScalar.makeList(new int[] {42, 24, 21}));

        System.out.println("\nmi1 :");
        mi1 = new Matrix<IntScalar>(3, 3, mi1Scalars);
        mi1.prettyprint();

        System.out.println("\nvd1 :");
        Vector<DoubleScalar> vd1 = new Vector<>(
            3, DoubleScalar.makeList(new double[] {1.1, 2.01, 3.001})
        );
        vd1.print();

        System.out.println("\nvd2 = vd1 * 3 :");
        Vector<DoubleScalar> vd2 = vd1.scl(dbSc.setValue(3));
        vd2.print();

        System.out.println("\nvd3 = vd1 + vd2 :");
        Vector<DoubleScalar> vd3 = vd1.add(vd2);
        vd3.print();

        System.out.println("\nvi1 :");
        Vector<IntScalar> vi1 = new Vector<>(
            5, IntScalar.makeList(new int[] {1, 2, 3, 4, 5})
        );
        vi1.print();
    }
}