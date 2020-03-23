public class DynamicProgrammingAlgorithm implements Algorithm {

    private Problem problemToSolve;
    private double maxValue;
    private double solveTime;

    public DynamicProgrammingAlgorithm() {

    }

    public DynamicProgrammingAlgorithm(Problem problem) {
        this.problemToSolve = problem;
    }

    @Override
    public String toString() {
        return "DynamicProgrammingAlgorithm{" +
                "maxValue=" + maxValue +
                ", solveTime=" + solveTime +
                '}';
    }

    private double solveUtility() {

        var knapsack = problemToSolve.getKnapsack();
        var items = problemToSolve.getItems();

        var n = items.size();
        var W = (int)Math.ceil(knapsack.getMaxWeight());

        int[][] knapsackMatrix = new int[n + 1][W+ 1];

        for (int i = 0; i <= items.size(); ++i) {
            for (int j = 0; j <= W; ++j) {

                if (i == 0 || j == 0) {
                    knapsackMatrix[i][j] = 0;
                } else if (items.get(i-1).getWeight() <= j) {
                    var currentItem = items.get(i - 1);
                    knapsackMatrix[i][j] = Math.max((int)currentItem.getValue() + knapsackMatrix[i - 1][j - (int)currentItem.getWeight()],
                            knapsackMatrix[i - 1][j]);
                } else {
                    knapsackMatrix[i][j] = knapsackMatrix[i - 1][j];
                }

            }
        }

        return (double)knapsackMatrix[n][W];

    }

    @Override
    public void solve() {

        long startTime = System.nanoTime();

        maxValue = solveUtility();

        long finishTime = System.nanoTime();
        this.solveTime = finishTime - startTime;
    }

    @Override
    public double getMaxValue() {
        return this.maxValue;
    }

    @Override
    public double getSolveTime() {
        return this.solveTime;
    }

    @Override
    public void setProblem(Problem problem) {
        this.problemToSolve = problem;
    }
}
