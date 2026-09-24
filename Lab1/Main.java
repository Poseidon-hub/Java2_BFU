import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount[] accounts = {
                new BankAccount("Иван Иванов", "1001", 1000),
                new BankAccount("Анна Петрова", "1002", 2500),
                new BankAccount("Пётр Сидоров", "1003")
        };
        BankAccount selectedAccount = accounts[0];

        System.out.println("Добро пожаловать в банк!");

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println("\nВыбран счёт: " + selectedAccount.getAccountNumber()
                        + " (" + selectedAccount.getOwner() + ")");
                System.out.println("1. Список счетов");
                System.out.println("2. Выбрать другой счёт");
                System.out.println("3. Информация о выбранном счёте");
                System.out.println("4. Пополнить счёт");
                System.out.println("5. Снять деньги");
                System.out.println("6. Количество созданных счетов");
                System.out.println("0. Выход");
                System.out.print("Выберите действие: ");

                if (!scanner.hasNextLine()) {
                    break;
                }
                String choice = scanner.nextLine().trim();

                try {
                    switch (choice) {
                        case "1":
                            printAccounts(accounts);
                            break;
                        case "2":
                            printAccounts(accounts);
                            System.out.print("Введите порядковый номер счёта (1–" + accounts.length + "): ");
                            if (!scanner.hasNextLine()) {
                                running = false;
                                break;
                            }
                            int number = Integer.parseInt(scanner.nextLine().trim());
                            if (number >= 1 && number <= accounts.length) {
                                selectedAccount = accounts[number - 1];
                                System.out.println("Выбран счёт " + selectedAccount.getAccountNumber());
                            } else {
                                System.out.println("Ошибка: счёта с таким порядковым номером нет.");
                            }
                            break;
                        case "3":
                            printAccountInfo(selectedAccount);
                            break;
                        case "4":
                        case "5":
                            System.out.print("Введите сумму: ");
                            if (!scanner.hasNextLine()) {
                                running = false;
                                break;
                            }
                            double amount = Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
                            if (choice.equals("4")) {
                                selectedAccount.deposit(amount);
                                System.out.println("Счёт успешно пополнен.");
                            } else {
                                selectedAccount.withdraw(amount);
                                System.out.println("Деньги успешно сняты.");
                            }
                            System.out.printf("Текущий баланс: %.2f руб.%n", selectedAccount.getBalance());
                            break;
                        case "6":
                            System.out.println("Создано счетов: " + BankAccount.getAccountsCount());
                            break;
                        case "0":
                            running = false;
                            break;
                        default:
                            System.out.println("Ошибка: такого пункта меню нет.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите корректное число.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
        }

        System.out.println("Работа программы завершена.");
    }

    private static void printAccounts(BankAccount[] accounts) {
        System.out.println("\nСписок счетов:");
        for (int i = 0; i < accounts.length; i++) {
            System.out.printf("%d. %s | № %s | %.2f руб.%n", i + 1,
                    accounts[i].getOwner(), accounts[i].getAccountNumber(), accounts[i].getBalance());
        }
    }

    private static void printAccountInfo(BankAccount account) {
        System.out.println("Владелец: " + account.getOwner());
        System.out.println("Номер счёта: " + account.getAccountNumber());
        System.out.printf("Баланс: %.2f руб.%n", account.getBalance());
    }
}
