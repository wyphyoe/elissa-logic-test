package piggybank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {

    private static List<Money> moneyList = new ArrayList<>();

    public void deposit(Currency currency, double amount) {

        if (this.checkSecurity()) {
            //Do deposit
            moneyList.add(new Money(amount, currency));
        } else {
            System.out.println("Wrong password");
        }
    }

    public void withdraw(Currency currency, double amount) {

        if (this.checkSecurity()) {
            //Do withdraw
            double temp = 0;

            for (Money money : moneyList) {
                if (money.getCurrency() == currency) {
                    temp += money.getAmount();
                }
            }

            if (amount <= temp) {

                List<Money> tempMoneyList = new ArrayList<>();

                for (Money money : moneyList) {
                    if (money.getCurrency() != currency) {
                        tempMoneyList.add(money);
                    }
                }

                //Re-assign new value by that currency
                tempMoneyList.add(new Money(temp - amount, currency));
                moneyList.clear();
                moneyList = tempMoneyList;

            } else {
                System.out.println("Not enough.");
            }

        } else {
            System.out.println("Wrong password");
        }
    }

    public double getAmount(Currency currency) {

        if (this.checkSecurity()) {

            double amount = 0;

            for (Money money : moneyList) {
                if (money.getCurrency() == currency) {
                    amount += money.getAmount();
                }
            }
            return amount;
        } else {
            System.out.println("Wrong password");
        }
        return 0;
    }

    private boolean checkSecurity() {

        if (Security.isClose()) {

            System.out.println("Enter password...");

            Scanner scanner = new Scanner(System.in);
            String password = scanner.nextLine();

            if (Security.open(password)) {
                return true;
            }
        } else {
            return true;
        }
        return false;
    }
}
