import java.sql.Array;
import java.util.*;

public class ProblemGenerator {

    Random randGenerator;

    private static final int NUM_MAX_PROBLEMS = 1000;
    private static final double MAX_KNAPSACK_MASS = 1000.0;
    private static final int MAX_ITEM_NAME = 7;

    private static final List<Weapon.WeaponType> weaponTypes = Collections.unmodifiableList(Arrays.asList(Weapon.WeaponType.values()));
    private static final int weaponTypesSize = weaponTypes.size();



    public ProblemGenerator() {
        randGenerator = new Random();
    }

    private String generateRandomString(int length) {
        final int leftLimit = 48;
        final int rightLimit = 122;
        final int smallLetterA = (int)'a';
        final int smallLetterZ = (int)'z';
        return randGenerator.ints(leftLimit, rightLimit)
                .filter( i -> (i<=smallLetterA || i >= smallLetterZ))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

    }

    public Problem generateProblem(int numObjects) {

        Knapsack knapsack = new Knapsack(randGenerator.nextInt(5000));
        Problem resultProblem = new Problem(knapsack);

        for (int i = 0; i < numObjects; ++i) {
            int option = randGenerator.nextInt() % 3;
            String name = generateRandomString(randGenerator.nextInt(MAX_ITEM_NAME));
            Item it;
            if (option == 0) { // food
                it = new Food(name, Math.abs(randGenerator.nextDouble()));
            } else if (option == 1) { // book
                it = new Book(name, Math.abs(randGenerator.nextInt()), Math.abs(randGenerator.nextDouble()));
            } else { // weapon

                it = new Weapon(weaponTypes.get(randGenerator.nextInt(weaponTypesSize)),
                        Math.abs(randGenerator.nextDouble()), Math.abs(randGenerator.nextDouble()));
            }

            resultProblem.addItemsToProblem(it);
        }

        return resultProblem;
    }

    public ArrayList<Problem> generateProblems(int n) {

        ArrayList<Problem> problems = new ArrayList<Problem>();

        for (int i = 0; i < n; ++i) {
            problems.add(generateProblem(randGenerator.nextInt(NUM_MAX_PROBLEMS)));
        }

        return problems;
    }

}
