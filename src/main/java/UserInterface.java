import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {
        BlackjackEngine bje = new BlackjackEngine();
        Scanner scanner = new Scanner(System.in);

        while (bje.getMode() == 0) {
            System.out.println("Hit or stand?");
            System.out.print(">>> ");
            String option = scanner.nextLine();
            if (option.equals("hit")) {
                bje.hit();
                System.out.println(bje.getPlayerCardsInfo());
            } else if (option.equals("stand")) {
                bje.stand();
                System.out.println(bje.getDealerCardsInfo());
            } else {
                System.out.println("Improper command.");
            }
        }
        if (bje.getMode() == 1) {
            System.out.println("You lose.");
        } else {
            System.out.println("You win!");
        }
    }
}
