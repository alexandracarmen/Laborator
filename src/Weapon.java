public class Weapon implements Item {

    public enum WeaponType {
        AK47, M4A1, Sword
    }

    private WeaponType weaponType;
    private double weaponValue;
    private double weaponWeight;

    public Weapon(WeaponType weaponType, double weaponValue, double weaponWeight) {
        this.weaponType = weaponType;
        this.weaponValue = weaponValue;
        this.weaponWeight = weaponWeight;
    }

    @Override
    public String getName() {
        return weaponType.toString();
    }

    @Override
    public double getValue() {
        return weaponValue;
    }

    @Override
    public double getWeight() {
        return weaponWeight;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "weaponType='" + weaponType + '\'' +
                ", value=" + weaponValue +
                ", weight=" + weaponWeight +
                '}';
    }
}
