package service;

public class ProbabilityService {

    // eventos independientes .
    public double independent(double pA, double pB) {
        return pA * pB;
    }

    // probabilidad condicional
    public double conditional(double pAandB, double pB) {
        return pAandB / pB;
    }

    // teorema de bayes .
    public double bayes(double pBgivenA, double pA, double pB) {
        return (pBgivenA * pA) / pB;
    }

    // factorial
    public long factorial(int n) {

        long result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    // permutaciones
    public long permutations(int n, int r) {
        return factorial(n) / factorial(n - r);
    }

    // combinaciones
    public long combinations(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }
}
