public class LogicSequence {
    public static void main(String[] args) {
        // a) 1, 3, 5, 7, ___
        int nextA = findNextElement(new int[]{1, 3, 5, 7});
        System.out.println("a) 1, 3, 5, 7, " + nextA);

        // b) 2, 4, 8, 16, 32, 64, ____
        int nextB = findNextElement(new int[]{2, 4, 8, 16, 32, 64});
        System.out.println("b) 2, 4, 8, 16, 32, 64, " + nextB);

        // c) 0, 1, 4, 9, 16, 25, 36, ____
        int nextC = findNextElement(new int[]{0, 1, 4, 9, 16, 25, 36});
        System.out.println("c) 0, 1, 4, 9, 16, 25, 36, " + nextC);

        // d) 4, 16, 36, 64, ____
        int nextD = findNextElement(new int[]{4, 16, 36, 64});
        System.out.println("d) 4, 16, 36, 64, " + nextD);

        // e) 1, 1, 2, 3, 5, 8, ____
        int nextE = findNextElement(new int[]{1, 1, 2, 3, 5, 8});
        System.out.println("e) 1, 1, 2, 3, 5, 8, " + nextE);

        // f) 2, 10, 12, 16, 17, 18, 19, ____
        int nextF = findNextElement(new int[]{2, 10, 12, 16, 17, 18, 19});
        System.out.println("f) 2, 10, 12, 16, 17, 18, 19, " + nextF);
    }

    private static int findNextElement(int[] sequence) {
        int length = sequence.length;

        // Verifica se é uma sequência aritmética
        if (isArithmeticSequence(sequence)) {
            int difference = sequence[1] - sequence[0];
            return sequence[length - 1] + difference;
        }

        // Verifica se é uma sequência geométrica
        if (isGeometricSequence(sequence)) {
            int ratio = sequence[1] / sequence[0];
            return sequence[length - 1] * ratio;
        }

        // Verifica se é uma sequência de quadrados perfeitos
        if (isPerfectSquareSequence(sequence)) {
            int nextIndex = (int) Math.sqrt(sequence[length - 1]) + 1;
            return nextIndex * nextIndex;
        }

        // Verifica se é a sequência de Fibonacci
        if (isFibonacciSequence(sequence)) {
            return sequence[length - 1] + sequence[length - 2];
        }

        // Caso não se encaixe em nenhum padrão conhecido
        return 0;
    }

    private static boolean isArithmeticSequence(int[] sequence) {
        int difference = sequence[1] - sequence[0];
        for (int i = 2; i < sequence.length; i++) {
            if (sequence[i] - sequence[i - 1] != difference) {
                return false;
            }
        }
        return true;
    }

    private static boolean isGeometricSequence(int[] sequence) {
        if (sequence[0] == 0) {
            return false;
        }
        int ratio = sequence[1] / sequence[0];
        for (int i = 2; i < sequence.length; i++) {
            if (sequence[i] != sequence[i - 1] * ratio) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPerfectSquareSequence(int[] sequence) {
        for (int num : sequence) {
            if (Math.sqrt(num) % 1 != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFibonacciSequence(int[] sequence) {
        for (int i = 2; i < sequence.length; i++) {
            if (sequence[i - 1] + sequence[i - 2] != sequence[i]) {
                return false;
            }
        }
        return true;
    }
}
