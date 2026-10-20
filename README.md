# Gestion des Virements Bancaires - Master 1 Java

**Étudiant :** Mohammed BENBRAHIM
**Projet :** Système sécurisé de virements bancaires (TD2 Exceptions)

## Présentation
Ce projet Java simule des virements entre comptes. L'objectif est de gérer correctement les erreurs (solde insuffisant, plafond dépassé, erreurs de saisie) en créant nos propres exceptions.

## Stratégie de gestion des erreurs
- **Exceptions personnalisées :** Création d'exceptions spécifiques pour chaque règle métier violée.
- **Cohérence des données :** Si un virement plante au milieu de l'opération (lors du crédit du destinataire), le programme annule automatiquement le débit du compte source via un bloc `catch`. Cela garantit qu'aucun argent ne disparaît suite à un bug.

## Comment tester ?
1. Ouvrir le dossier du projet dans VS Code.
2. Exécuter le fichier `Main.java`.
3. Utiliser le terminal pour tester les différents cas (virement normal, solde insuffisant, saisie de lettres au lieu de chiffres, etc.).# GestionVirements
