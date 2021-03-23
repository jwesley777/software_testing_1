package part1;

public class Sec {
    public static double sin(double x) {
        double result = 0.0;

        for (int n = 0; n < 10; n++) {
            result += Math.pow(-1.0, n) * Math.pow(x, 2 * n + 1) / getFactorial(2 * n + 1);
        }
        return result;
    }
    public static double sec(double x) {
//        if (Math.abs(x % Math.PI - Math.PI / 2) < 1e-6) return Double.NaN;
//
//        try {
//            return 1/Math.cos(x);
//        }
//        catch (ArithmeticException e) {
//            return Double.NaN;
//        }

        //return 1. + 1./2.*x*x + 1./24.*x*x*x*x - 1./720.*x*x*x*x*x*x;// + 277./8064.*x*x*x*x*x*x*x*x -50521./ 3628800.*x*x*x*x*x*x*x*x*x*x;

        if (Math.abs(x) >= Math.PI / 2) {
            return Double.NaN;
        }
        long[] eulers = {1,5,61,1385,50521,2702765,199360981,19391512145l,2404879675441l};
        double result = 1;
        for (int i = 0; i < 9; i++) {
            result += (double)eulers[i] / getFactorial(2*(i+1)) * Math.pow(x,2*(i+1));
        }
        return result;
    }
    private static long getFactorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(sec(Math.PI/4));
    }
}
