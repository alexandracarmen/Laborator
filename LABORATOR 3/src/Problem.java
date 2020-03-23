import java.util.ArrayList;
import java.util.Arrays;

public class Problem {

    private ArrayList<Item> allItems;
    private Knapsack knapsack;

    public Problem() {
        this.allItems = new ArrayList<Item>();
    }

    public Problem(Knapsack knapsack) {
        this.allItems = new ArrayList<Item>();
        this.knapsack = knapsack;
    }

    public Problem(ArrayList<Item> allItems) {
        this.allItems = allItems;
    }

    public Problem(ArrayList<Item> allItems, Knapsack knapsack) {
        this.allItems = allItems;
        this.knapsack = knapsack;
    }

    public ArrayList<Item> getItems() {
        return this.allItems;
    }

    public Knapsack getKnapsack() {
        return this.knapsack;
    }

    public void addItemsToProblem(Item ... its) {
        allItems.addAll(Arrays.asList(its));
    }

    private String toStringItems() {

        StringBuilder builder = new StringBuilder();
        builder.append("{\n\t");

        int index = 0;
        for (var i : allItems) {
            builder.append(i);
            index = index + 1;
            if (index != allItems.size()) {
                builder.append(",\n\t");
            }
        }

        builder.append("\n}");

        return builder.toString();

    }

    @Override
    public String toString() {
        if (knapsack != null) {
            return "Problem{" +
                    "\nallItems=" + toStringItems() +
                    ",\n\tknapsack=" + knapsack +
                    "\n}";
        } else {
            return "Problem{" +
                    "\nallItems=" + toStringItems() +
                    "\n}";
        }
    }
}
