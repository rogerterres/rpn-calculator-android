package ca.com.grasset.rogerterres.calculatrice.testesEclipse;

import ca.com.grasset.rogerterres.calculatrice.Copyright;
import ca.com.grasset.rogerterres.calculatrice.expressions.Expression;
import ca.com.grasset.rogerterres.calculatrice.operations.Addition;
import ca.com.grasset.rogerterres.calculatrice.operations.Division;
import ca.com.grasset.rogerterres.calculatrice.operations.Multiplication;
import ca.com.grasset.rogerterres.calculatrice.operations.Scalaire;

@Copyright(
        instituition = "Institut Grasset",
        professeur = "Rébecca Lapointe",
        eleve = "Roger Terres",
        cours = "Programmation Orientée Objet II (420-GC6-AG)",
        groupe = "00099",
        session = "Été 2018"
)

/**
 * (Exemple donné par l'enseignant dans le descripteur pour l'exécution et le test des classes)
 * Voyons un exemple de cŕeation d’une expression arithḿetique.
 * Elle se fait selon la structure de pile.
 */

public class TestFabriqueExpression {

    Expression a = new Scalaire(5.0);
    Expression b = new Scalaire(6.0);
    Expression c = new Addition(a, b);
    Expression d = new Scalaire(4.0);
    Expression e = new Scalaire(1.0);
    Expression f = new Division(d, e);

    Expression exp = new Multiplication(c, f);
    // pop f, pop c, push c * f = exp
    // exp est l’expression totale

    double r = exp.evaluer();
    // r vaut 44.0

    String i = exp.toInfix();
    // i vaut "((5 + 6) * (4 / 1))"

    String p = exp.toPolonaise();
    // p vaut "5 6 + 4 1 / *"
}
