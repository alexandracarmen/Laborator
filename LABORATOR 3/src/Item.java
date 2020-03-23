public interface Item extends Comparable<Item> {

    String getName();
    double getValue();
    double getWeight();

    default double getProfitFactor() {
        return this.getValue() / this.getWeight();
    }

    @Override
    default int compareTo(Item item) {
        return getName().compareTo(item.getName());
    }

}
