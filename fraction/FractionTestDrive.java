package fraction;

public class FractionTestDrive {
    public static void main(String[] args) {
//        Random random = new Random();
//        int numbers = random.nextInt(21) + 30; // Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50]
//
//        DataSet dataSet = new DataSet();
//        for (int i = 0; i < numbers; i++) {
//            int numerator = random.nextInt(100) + 1; // Tử số ngẫu nhiên từ 1 đến 100
//            int denominator = random.nextInt(100) + 1; // Mẫu số ngẫu nhiên từ 1 đến 100
//            dataSet.append(new Fraction(numerator, denominator));
//        }
//
//        System.out.println("Original Data Set:");
//        System.out.println(dataSet);
//
//        System.out.println("Sorted Increasing:");
//        Fraction[] sortedIncreasing = dataSet.sortIncreasing();
//        DataSet.printFractions(sortedIncreasing);
//
//        System.out.println("Sorted Decreasing:");
//        Fraction[] sortedDecreasing = dataSet.sortDecreasing();
//        DataSet.printFractions(sortedDecreasing);
//
//        DataSet simplifiedDataSet = dataSet.toSimplify();
//
//        System.out.println("Simplified Data Set:");
//        System.out.println(simplifiedDataSet);
//
//        System.out.println("Simplified Sorted Increasing:");
//        Fraction[] simplifiedSortedIncreasing = simplifiedDataSet.sortIncreasing();
//        DataSet.printFractions(simplifiedSortedIncreasing);
//
//        System.out.println("Simplified Sorted Decreasing:");
//        Fraction[] simplifiedSortedDecreasing = simplifiedDataSet.sortDecreasing();
//        DataSet.printFractions(simplifiedSortedDecreasing);
        Fraction[] fractions = {
                new Fraction(2, 4),
                new Fraction(3, 9),
                new Fraction(4, 8),
                new Fraction(10, 20),
                new Fraction(15, 25),
                new Fraction(6, 9),
                new Fraction(8, 12),
                new Fraction(9, 27),
                new Fraction(16, 24),
                new Fraction(18, 27)
        };

        DataSet dataSet = new DataSet(fractions);

        System.out.println("Original Data Set:");
        System.out.println(dataSet);

        System.out.println("Simplified Data Set:");
        DataSet simplifiedDataSet = dataSet.toSimplify();
        System.out.println(simplifiedDataSet);

        System.out.println("Sorted Increasing:");
        Fraction[] sortedIncreasing = dataSet.sortIncreasing();
        DataSet.printFractions(sortedIncreasing);

        System.out.println("Sorted Decreasing:");
        Fraction[] sortedDecreasing = dataSet.sortDecreasing();
        DataSet.printFractions(sortedDecreasing);

        System.out.println("Simplified Sorted Increasing:");
        Fraction[] simplifiedSortedIncreasing = simplifiedDataSet.sortIncreasing();
        DataSet.printFractions(simplifiedSortedIncreasing);

        System.out.println("Simplified Sorted Decreasing:");
        Fraction[] simplifiedSortedDecreasing = simplifiedDataSet.sortDecreasing();
        DataSet.printFractions(simplifiedSortedDecreasing);
    }
}
