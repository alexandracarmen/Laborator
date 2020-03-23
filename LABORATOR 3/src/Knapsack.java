import java.util.ArrayList;
import java.util.TreeSet;


public class Knapsack {

    private int maxWeight;
    private TreeSet<Item> items;
    private double totalWeight;
    private double totalValue;

    public Knapsack(int maxWeight) {
        this.totalWeight = 0;
        this.totalValue = 0;
        this.maxWeight = maxWeight;
        this.items = new TreeSet<Item>();
    }

    public boolean addItem(Item it) {
        if (canAddItem(it)) {
            items.add(it);
            totalValue += it.getValue();
            totalWeight += it.getWeight();
            return  true;
        }
        return false;
    }

    public boolean canAddItem(Item it) {
        return totalWeight + it.getWeight() <= maxWeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public String getItemNames() {
        StringBuilder builder = new StringBuilder();

        int index = 0;
        for (var it : items) {
            builder.append(it.getName());
            index = index + 1;
            if (index != items.size()) {
                builder.append(", ");
            }
        }

        return builder.toString();
    }

    @Override
    public String toString() {
        return "Knapsack{" +
                "maxWeight=" + maxWeight +
                ", items=\"" + getItemNames() + '\"' +
                ", totalWeight=" + totalWeight +
                ", totalValue=" + totalValue +
                '}';
    }
}