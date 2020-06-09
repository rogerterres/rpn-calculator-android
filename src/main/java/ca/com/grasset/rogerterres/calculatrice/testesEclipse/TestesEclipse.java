package ca.com.grasset.rogerterres.calculatrice.testesEclipse;

import ca.com.grasset.rogerterres.calculatrice.Copyright;
import ca.com.grasset.rogerterres.calculatrice.expressions.Expression;
import ca.com.grasset.rogerterres.calculatrice.expressions.FabriqueExpression;

@Copyright(
        instituition = "Institut Grasset",
        professeur = "Rébecca Lapointe",
        eleve = "Roger Terres",
        cours = "Programmation Orientée Objet II (420-GC6-AG)",
        groupe = "00099",
        session = "Été 2018"
)

// Petit test effectué pendant la création de la calculatrice, toujours dans l'IDE Eclipse.
// Il n'y a aucun lien direct avec l'application finale, mais c'est intéressant pour la compréhension.
public class TestesEclipse {
    public static void main(String[] args) {

        String expression = "22.08 23.08 +";

        FabriqueExpression fabriqueExpression = new FabriqueExpression();
        Expression resultat = fabriqueExpression.batirFromPolonaise(expression);

//        System.out.println(resultat.toInfix() + " = " + resultat.evaluer());
//        System.out.println(resultat.toPolonaise());

        System.out.println(resultat.evaluer());
        System.out.println(resultat.toInfix());
        System.out.println(resultat.toPolonaise());
    }
}
