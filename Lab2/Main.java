public class Main {
    public static void main(String[] args) {
        // Восходящее преобразование: объекты наследников хранятся в переменных Vehicle.
        Vehicle car = new Car("Toyota", "Corolla", 2020, 4,
                new Vehicle.Engine(122, "Бензиновый"));
        Vehicle motorcycle = new Motorcycle("Yamaha", "MT-07", 2022, false,
                new Vehicle.Engine(73, "Бензиновый"));
        Vehicle truck = new Truck("КамАЗ", "5320", 2015, 8000,
                new Vehicle.Engine(210, "Дизельный"));

        // Анонимный класс с собственной реализацией move().
        Vehicle specialVehicle = new Vehicle("Самодельный", "Вездеход", 2024,
                new Vehicle.Engine(100, "Бензиновый")) {
            @Override
            public void move() {
                System.out.println("Вездеход движется по бездорожью.");
            }
        };

        Vehicle[] vehicles = {car, motorcycle, truck, specialVehicle};

        for (Vehicle vehicle : vehicles) {
            vehicle.printInfo();
            // Полиморфизм: вызывается move() фактического класса объекта.
            vehicle.move();

            // Безопасное нисходящее преобразование после проверки instanceof.
            if (vehicle instanceof Car) {
                Car currentCar = (Car) vehicle;
                currentCar.openTrunk();
            } else if (vehicle instanceof Motorcycle) {
                Motorcycle currentMotorcycle = (Motorcycle) vehicle;
                currentMotorcycle.doWheelie();
            } else if (vehicle instanceof Truck) {
                Truck currentTruck = (Truck) vehicle;
                currentTruck.loadCargo(3000);
            }

            System.out.println();
        }

        // Неправильно: motorcycle хранит объект Motorcycle, а не Car.
        // Car wrongCar = (Car) motorcycle; // При выполнении возникнет ClassCastException.
        // Правильный вариант с проверкой instanceof показан в цикле выше.
    }
}
