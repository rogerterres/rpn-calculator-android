package ca.com.grasset.rogerterres.calculatrice.operations;

import ca.com.grasset.rogerterres.calculatrice.Copyright;
import ca.com.grasset.rogerterres.calculatrice.expressions.Expression;

@Copyright(
        instituition = "Institut Grasset",
        professeur = "Rébecca Lapointe",
        eleve = "Roger Terres",
        cours = "Programmation Orientée Objet II (420-GC6-AG)",
        groupe = "00099",
        session = "Été 2018"
)

/**
 * Classe responsable pour l’́elément scalaire (un nombre), qui implémente l'interface Expression
 */
public class Scalaire implements Expression {

    private double scalaire;

    public Scalaire(double scalaire) {
        this.scalaire = scalaire;
    }

    @Override
    public double evaluer() {
        return scalaire;
    }

    @Override
    public String toInfix() {
        return String.valueOf(scalaire);
    }

    @Override
    public String toPolonaise() {
        return String.valueOf(scalaire);
    }
}
