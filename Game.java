import java.util.*;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        Pokemon[] allPokemon = {
            new Pikachu(), new Charizard(), new Blastoise(), new Venusaur(), new Gengar(),
            new Garchomp(), new Lucario(), new Tyranitar(), new Snorlax(), new Machamp(),
            new Mewtwo(), new Greninja(), new Infernape(), new Gardevoir(), new Gyarados()
        };

        System.out.println("Choose 3 Pokémon:");
        for (int i = 0; i < allPokemon.length; i++) {
            System.out.println((i + 1) + ". " + allPokemon[i].name);
        }

        Pokemon[] playerTeam = new Pokemon[3];
        Set<Integer> chosenIndices = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            while (true) {
                System.out.print("Pick Pokémon " + (i + 1) + ": ");
                int choice = scanner.nextInt() - 1;
                if (choice >= 0 && choice < allPokemon.length && !chosenIndices.contains(choice)) {
                    playerTeam[i] = copyPokemon(allPokemon[choice]);
                    chosenIndices.add(choice);
                    break;
                }
                System.out.println("Invalid or duplicate choice. Try again.");
            }
        }

        Pokemon[] cpuTeam = new Pokemon[3];
        ArrayList<Integer> cpuChosen = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int pick;
            do {
                pick = random.nextInt(allPokemon.length);
            } while (cpuChosen.contains(pick) || chosenIndices.contains(pick));
            cpuChosen.add(pick);
            cpuTeam[i] = copyPokemon(allPokemon[pick]);
        }

        System.out.println("\nBattle Start!");
        battle(playerTeam, cpuTeam);
        System.out.println("Game Over!");
    }

    private static Pokemon copyPokemon(Pokemon p) {
        switch (p.name) {
            case "Pikachu": return new Pikachu();
            case "Charizard": return new Charizard();
            case "Blastoise": return new Blastoise();
            case "Venusaur": return new Venusaur();
            case "Gengar": return new Gengar();
            case "Garchomp": return new Garchomp();
            case "Lucario": return new Lucario();
            case "Tyranitar": return new Tyranitar();
            case "Snorlax": return new Snorlax();
            case "Machamp": return new Machamp();
            case "Mewtwo": return new Mewtwo();
            case "Greninja": return new Greninja();
            case "Infernape": return new Infernape();
            case "Gardevoir": return new Gardevoir();
            case "Gyarados": return new Gyarados();
            default: return null;
        }
    }

    private static void battle(Pokemon[] playerTeam, Pokemon[] cpuTeam) {
        int playerActive = 0;
        int cpuActive = 0;

        while (true) {
            Pokemon playerP = playerTeam[playerActive];
            Pokemon cpuP = cpuTeam[cpuActive];

            if (playerP.isFainted()) {
                System.out.println(playerP.name + " has fainted!");
                playerActive++;
                if (playerActive >= playerTeam.length) {
                    System.out.println("You have no Pokémon left! You lost!");
                    break;
                }
                System.out.println("Go! " + playerTeam[playerActive].name);
                playerP = playerTeam[playerActive];
            }

            if (cpuP.isFainted()) {
                System.out.println("Enemy " + cpuP.name + " fainted!");
                cpuActive++;
                if (cpuActive >= cpuTeam.length) {
                    System.out.println("You defeated all enemy Pokémon! You win!");
                    break;
                }
                System.out.println("Enemy sends out " + cpuTeam[cpuActive].name);
                cpuP = cpuTeam[cpuActive];
            }

            System.out.println("\nYour active Pokémon: " + playerP);
            System.out.println("Enemy active Pokémon: " + cpuP);

            playerP.applyStatusEffects();
            cpuP.applyStatusEffects();

            if (playerP.isFainted() || cpuP.isFainted()) continue;

            System.out.println("\nChoose a move:");
            for (int i = 0; i < playerP.moves.length; i++) {
                System.out.println((i + 1) + ". " + playerP.moves[i]);
            }

            int moveChoice;
            while (true) {
                System.out.print("Your move: ");
                if (scanner.hasNextInt()) {
                    moveChoice = scanner.nextInt() - 1;
                    if (moveChoice >= 0 && moveChoice < playerP.moves.length) break;
                } else {
                    scanner.next(); // clear invalid input
                }
                System.out.println("Invalid move, try again.");
            }

            Move playerMove = playerP.moves[moveChoice];
            Move cpuMove = cpuP.moves[random.nextInt(cpuP.moves.length)];

            System.out.println("\n" + playerP.name + " uses " + playerMove.name + "!");
            System.out.println("Enemy " + cpuP.name + " uses " + cpuMove.name + "!");

            boolean playerFirst = playerP.speed >= cpuP.speed;

            if (playerFirst) {
                if (playerP.canMove()) doMove(playerP, cpuP, playerMove);
                if (!cpuP.isFainted() && cpuP.canMove()) doMove(cpuP, playerP, cpuMove);
            } else {
                if (cpuP.canMove()) doMove(cpuP, playerP, cpuMove);
                if (!playerP.isFainted() && playerP.canMove()) doMove(playerP, cpuP, playerMove);
            }

            // Ask if player wants to switch Pokémon
            if (!playerP.isFainted()) {
                System.out.print("\nDo you want to switch Pokémon? (yes/no): ");
                scanner.nextLine(); // clear newline
                String response = scanner.nextLine().trim().toLowerCase();
                if (response.equals("yes")) {
                    for (int i = 0; i < playerTeam.length; i++) {
                        if (!playerTeam[i].isFainted() && i != playerActive) {
                            System.out.println((i + 1) + ". " + playerTeam[i]);
                        }
                    }
                    while (true) {
                        System.out.print("Pick a number to switch: ");
                        if (scanner.hasNextInt()) {
                            int switchChoice = scanner.nextInt() - 1;
                            if (switchChoice >= 0 && switchChoice < playerTeam.length &&
                                switchChoice != playerActive && !playerTeam[switchChoice].isFainted()) {
                                playerActive = switchChoice;
                                System.out.println("You switched to " + playerTeam[playerActive].name + "!");
                                break;
                            }
                        } else {
                            scanner.next();
                        }
                        System.out.println("Invalid choice.");
                    }
                }
            }
        }
    }

    private static void doMove(Pokemon attacker, Pokemon defender, Move move) {
        // Simulate miss chance (90% hit rate for all moves)
        if (Math.random() > 0.9) {
            System.out.println(attacker.name + " missed the attack!");
            return;
        }

        if (move.power == 0) {
            if (move.effect.equals("heal")) {
                int healAmount = attacker.maxHP / 2;
                attacker.currentHP += healAmount;
                if (attacker.currentHP > attacker.maxHP) attacker.currentHP = attacker.maxHP;
                System.out.println(attacker.name + " healed " + healAmount + " HP!");
            } else {
                System.out.println(attacker.name + "'s " + move.name + " had a special effect: " + move.effect);
            }
            return;
        }

        int damage = (int) (((2 * 50 / 5 + 2) * move.power * (attacker.attack / (double) defender.defense)) / 50 + 2);
        defender.takeDamage(damage);
        System.out.println(defender.name + " took " + damage + " damage! HP left: " + defender.currentHP + "/" + defender.maxHP);

        if (!move.effect.equals("none")) {
            defender.setStatus(move.effect);
        }

        if (defender.isFainted()) {
            System.out.println(defender.name + " fainted!");
        }
    }
}
