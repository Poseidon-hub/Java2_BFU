public class Truck extends Vehicle {
    private final double maxLoad;

    public Truck(String brand, String model, int year, double maxLoad, Engine engine) {
        super(brand, model, year, engine);
        this.maxLoad = maxLoad;
    }

    @Override
    public void move() {
        System.out.println("Грузовик едет по дороге. Грузоподъёмность: " + maxLoad + " кг.");
    }

    public void loadCargo(double weight) {
        if (!Double.isFinite(weight) || weight <= 0) {
            System.out.println("Масса груза должна быть положительным конечным числом.");
        } else if (weight > maxLoad) {
            System.out.println("Нельзя загрузить " + weight + " кг: превышена грузоподъёмность.");
        } else {
            System.out.println("В грузовик загружено " + weight + " кг.");
        }
    }
}
