public class GreedyAlgorithm implements Algorithm {

    private Problem problemToSolve;
    double maxValue = 0.0f;
    double solveTime = Double.MAX_VALUE;

    public GreedyAlgorithm() {

    }

    public GreedyAlgorithm(Problem problemToSolve) {
        this.problemToSolve = problemToSolve;
    }

    @Override
    public String toString() {
        return "GreedyAlgorithm{" +
                "maxValue=" + maxValue +
                ", solveTime=" + solveTime +
                '}';
    }

    @Override
    public void solve() {

        long startTime = System.nanoTime();

        boolean[] selectedItems = new boolean[this.problemToSolve.getItems().size()];
        var items = problemToSolve.getItems();
        while (true) {
            int selectedItem = -1;
            double maxProfitFactor = 0.0;
            for (int i = 0; i < problemToSolve.getItems().size(); ++i) {
                if (!selectedItems[i] && problemToSolve.getKnapsack().canAddItem(items.get(i))) {
                    if (items.get(i).getProfitFactor() > maxProfitFactor) {
                        selectedItem = i;
                        maxProfitFactor = items.get(i).getValue();
                    }
                }
            }
            if (selectedItem != -1) {
                problemToSolve.getKnapsack().addItem(items.get(selectedItem));
                selectedItems[selectedItem] = true;
            } else {
                break;
            }
        }

        long finishTime = System.nanoTime();

        this.solveTime = finishTime - startTime;
        this.maxValue = problemToSolve.getKnapsack().getTotalValue();
    }

    @Override
    public double getMaxValue() {
        return maxValue;
    }

    @Override
    public double getSolveTime() {
        return solveTime;
    }

    @Override
    public void setProblem(Problem problem) {
        this.problemToSolve = problem;
    }
}
