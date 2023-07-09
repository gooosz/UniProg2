package Uebung9.Zusatz;

public class ProjektEuler {
    public static void main(String[] args) {
        testE();
        //testM();
        /*for (int i=0; i<=4; i++) {
            System.out.println("i: "+ i + "\t(-1)^(i+4): " + (int)Math.pow(-1, i+3));
        }*/
    }

    public static void testE() {
        for (int i=0; i<10; i++) {
            System.out.println("f^" + i + "(0) = " + f0(i));
        }
    }


    public static double f0(int n) {
        if (n % 2 == 1) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int multiplier = (int)Math.pow(-1, n+3) * (n + (n - 2));
        return f0(n-2) * multiplier;
    }

    public static long indexOf1000Fib() {
        long i=1;
        while (fibIter(i) < 10e15) {
            i++;
        }
        return i;
    }

    public static long fib(long n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public static long fibIter(long n) {
        if(n <= 1) {
            return n;
        }
        long fib = 1;
        long prevFib = 1;

        for(long i=2; i<n; i++) {
            long temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return fib;
    }

    public static double ableitung1(int n, double x) {
        // n * 15^(n-1) * e^(15*x) + 15^n * x * e^(15*x)
        return n * Math.pow(15, n-1) * Math.exp(15*x)
                + Math.pow(15, n) * x * Math.exp(15*x);
    }
}
