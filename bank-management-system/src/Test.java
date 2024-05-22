import java.util.Scanner;

public class Test {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        // login info object to hold customers data
        Bank bank = new Bank();

        @SuppressWarnings("unchecked")
        LoginPage loginPage = new LoginPage(bank.getBank());

    }

}
