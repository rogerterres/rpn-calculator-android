package ca.com.grasset.rogerterres.calculatrice.expressions;

import java.util.Stack;

import ca.com.grasset.rogerterres.calculatrice.Copyright;
import ca.com.grasset.rogerterres.calculatrice.operations.Addition;
import ca.com.grasset.rogerterres.calculatrice.operations.Division;
import ca.com.grasset.rogerterres.calculatrice.operations.Multiplication;
import ca.com.grasset.rogerterres.calculatrice.operations.Scalaire;
import ca.com.grasset.rogerterres.calculatrice.operations.Soustraction;

@Copyright(
        instituition = "Institut Grasset",
        professeur = "Rébecca Lapointe",
        eleve = "Roger Terres",
        cours = "Programmation Orientée Objet II (420-GC6-AG)",
        groupe = "00099",
        session = "Été 2018"
)

/**
 * Le but de ce TP est de mettre en pratique le principe de polymorphisme,
 * de s’initier aux patrons de conception, de mettre en pratique ses connaissances en matière de structures de données,
 * d’employer la récursivit́e structurelle et de manipuler les exceptions dans le langage Java.
 *
 * On peut représenter la même expression avec la notation polonaise inversée.
 * Dans celle-ci, les opérandes sont placées devant l’opérateur et les calculs se font toujours de gauche à droite.
 *
 * La règle générale est de lire les  ́eléments de l’expression de gauche à droite et d’effectuer les actions suivantes :
 * • Si l’élément est un scalaire (un nombre) : on le “push” dans une pile.
 * • Si l’́elément est un opérateur (+, -, * ou /) :
 * 1. On “pop” la tête de la pile (on obtient x).
 * 2. On “pop” la tête de la pile (on obtient y).
 * 3. On effectue le calcul avec y comme première opérande et x comme deuxième opérande.
 * 4. On “push” le résultat du calcul dans la pile.
 * On termine quand l’expression a ́et́e lue au complet. Le résultat est le scalaire qui reste dans la pile.
 */

public class FabriqueExpression {

    public Expression batirFromPolonaise(String input) {

        Stack<Expression> pile = new Stack<>();
        String[] indice = input.split(" ");

        String operation;
        Expression a, b, resultat = null;

        for (int i = 0; i < indice.length; i++) {
            operation = indice[i];
            if (operation.matches("\\d+") || operation.matches("\\d+.\\d+")) {
                pile.push(new Scalaire(Double.parseDouble(operation)));
            } else {

                a = pile.pop();
                b = pile.pop();

                switch (operation) {
                    case "+":
                        resultat = new Addition(b, a);
                        break;
                    case "-":
                        resultat = new Soustraction(b, a);
                        break;
                    case "*":
                        resultat = new Multiplication(b, a);
                        break;
                    case "/":
                        resultat = new Division(b, a);
                    default:
                        break;

                }
                pile.push(resultat);
            }
        }
        return resultat;
    }
}