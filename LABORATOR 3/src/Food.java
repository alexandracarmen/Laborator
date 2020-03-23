public class Food implements Item {

    private String foodName;
    private double foodWeight;

    public Food(String foodName, double foodWeight) {
        this.foodName = foodName;
        this.foodWeight = foodWeight;
    }

    @Override
    public String getName() {
        return foodName;
    }

    @Override
    public double getValue() {
        return foodWeight * 2.0;
    }

    @Override
    public double getWeight() {
        return foodWeight;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodName='" + foodName + '\'' +
                ", value= " + getValue() +
                ", weight=" + foodWeight +
                '}';
    }
}
