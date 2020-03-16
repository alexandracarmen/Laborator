public class Main {

    public static void main(String[] args) {

        Book book1 = new Book("Dragon rising", 300, 5);
        Book book2 = new Book("A Blade in the Dark", 300, 5);

        Food food1 = new Food("Cabbage", 2);
        Food food2 = new Food("Rabbit", 2);

        Weapon weapon = new Weapon(Weapon.WeaponType.Sword, 10, 5);

        Knapsack knapsack = new Knapsack(20);

        Problem problem = new Problem(knapsack);
        problem.addItemsToProblem(book1, book2, food1, food2, weapon);

        Algorithm dynamicProgramming = new DynamicProgrammingAlgorithm();
        dynamicProgramming.setProblem(problem);
        dynamicProgramming.solve();
        System.out.println(1);
//
//         Algorithm dynamicProgramming = new DynamicProgrammingAlgorithm();
//        Algorithm greedy = new GreedyAlgorithm();
//
//        ProblemGenerator generator = new ProblemGenerator();
//        var problems = generator.generateProblems(100);
//
//        double dynamicTime = 0.0;
//        double dynamicValue = 0.0;
//
//        double greedyTime = 0.0;
//        double greedyValue = 0.0;
//
//        for (var problem : problems){
//
//            dynamicProgramming.setProblem(problem);
//            dynamicProgramming.solve();
//            dynamicTime += dynamicProgramming.getSolveTime();
//            dynamicValue += dynamicProgramming.getMaxValue();
//
//            greedy.setProblem(problem);
//            greedy.solve();
//            greedyTime += greedy.getSolveTime();
//            greedyValue += greedy.getMaxValue();
//        }
//
//        System.out.println("Dynamic programming average time: " + dynamicTime / problems.size());
//        System.out.println("Greedy average time: " + dynamicTime / problems.size());
//
//        System.out.println("Dynamic programming average max value: " + dynamicValue / problems.size());
//        System.out.println("Greedy average max value: " + greedyValue / problems.size());

    }
}
