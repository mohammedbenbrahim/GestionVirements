public class TransferService {
    
    public void transfer(BankAccount source, BankAccount destination, double amount) throws BankingException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Le virement a été rejeté : Le montant doit être strictement positif.");
        }
        if (source == null || destination == null || source == destination) {
            throw new InvalidAccountException("Le virement a été rejeté : Comptes invalides (null ou identiques).");
        }
        if (amount > 10000) {
            throw new TransferLimitExceededException("Le virement a été rejeté : Plafond dépassé.");
        }
        if (amount > source.getBalance()) {
            throw new InsufficientFundsException("Le virement a été rejeté : Fonds insuffisants.");
        }

        source.debit(amount);
        try {
            destination.credit(amount);
        } catch (Exception e) {
            source.credit(amount);
            throw new BankingException("Erreur critique lors du crédit. Le débit a été annulé pour préserver la cohérence.", e);
        }
    }
}