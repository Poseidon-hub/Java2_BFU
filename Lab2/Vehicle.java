public abstract class Vehicle {
    private final String brand;
    private final String model;
    private final int year;
    private final Engine engine;

    public Vehicle(String brand, String model, int year, Engine engine) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engine = engine;
    }

    // final запрещает наследникам переопределять этот метод.
    public final void printInfo() {
        System.out.println(brand + " " + model + ", год выпуска: " + year);
        engine.printEngineInfo();
    }

    public abstract void move();

    // Статический вложенный класс, описывающий двигатель.
    public static class Engine {
        private final int power;
        private final String type;

        public Engine(int power, String type) {
            this.power = power;
            this.type = type;
        }

        public void printEngineInfo() {
            System.out.println("Двигатель: " + type + ", мощность: " + power + " л. с.");
        }
    }
}
