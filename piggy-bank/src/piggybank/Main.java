package piggybank;

public class Main {

    public static void main(String[] args) {

        Security.setPassword("1234");

        Bank bank = new Bank();

        bank.deposit(Currency.MMK, 10000);
        bank.deposit(Currency.MMK, 10000);
        bank.deposit(Currency.MMK, 10000);
        bank.deposit(Currency.MMK, 10000);
        bank.deposit(Currency.SGD, 20000);
        bank.deposit(Currency.SGD, 10000);
        bank.deposit(Currency.THB, 20000);

        bank.withdraw(Currency.THB, 20000);
        bank.withdraw(Currency.MMK, 10000);

        System.out.println("Amount : " + bank.getAmount(Currency.MMK) + " MMK");
        System.out.println("Amount : " + bank.getAmount(Currency.SGD) + " SGD");
        System.out.println("Amount : " + bank.getAmount(Currency.THB) + " THB");
        System.out.println("Amount : " + bank.getAmount(Currency.USD) + " USD");

        Security.close();
    }
}
