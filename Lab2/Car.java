public class Car extends Vehicle {
    private final int passengerCount;

    public Car(String brand, String model, int year, int passengerCount, Engine engine) {
        super(brand, model, year, engine);
        this.passengerCount = passengerCount;
    }

    @Override
    public void move() {
        System.out.println("Автомобиль едет по дороге. Пассажиров: " + passengerCount);
    }

    public void openTrunk() {
        System.out.println("Багажник автомобиля открыт.");
    }
}
