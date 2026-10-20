
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("FR123", 2000.0);
        BankAccount account2 = new BankAccount("FR456", 500.0);
        TransferService service = new TransferService();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Veuillez saisir le montant à virer : ");
            double amount = scanner.nextDouble();
            
            service.transfer(account1, account2, amount);
            System.out.println("Virement réussi. Nouveau solde source : " + account1.getBalance() + " €");
            
        } catch (InputMismatchException e) {
            System.err.println("Erreur : Vous devez saisir un montant numérique valide.");
        } catch (InsufficientFundsException e) {
            System.err.println("Erreur de transaction : " + e.getMessage());
        } catch (TransferLimitExceededException e) {
            System.err.println("Erreur de plafond : " + e.getMessage());
        } catch (InvalidAccountException e) {
            System.err.println("Erreur de compte : " + e.getMessage());
        } catch (BankingException e) {
            System.err.println("Erreur bancaire générale : " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur de saisie : " + e.getMessage());
        } finally {
            System.out.println("Traitement de la transaction terminé.");
            scanner.close();
        }
    }
}