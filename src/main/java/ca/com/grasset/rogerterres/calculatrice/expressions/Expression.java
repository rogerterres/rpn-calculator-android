package ca.com.grasset.rogerterres.calculatrice.expressions;

import ca.com.grasset.rogerterres.calculatrice.Copyright;

@Copyright(
        instituition = "Institut Grasset",
        professeur = "Rébecca Lapointe",
        eleve = "Roger Terres",
        cours = "Programmation Orientée Objet II (420-GC6-AG)",
        groupe = "00099",
        session = "Été 2018"
)

/**
 * Vous devez implémenter les classes qui permettent de bâtir,
 * d’́evaluer et de représenter des expressions arithḿetiques à partir
 * d’une chaîne de caractères comportant une expression dans sa notation polonaise.
 */

public interface Expression {

    // Pour  ́evaluer l’expression entrée par l’usager.
    public double evaluer();

    // Vous êtes à l’aise avec les expressions arithmétiques en notation infix.
    // Elle s’́evalue selon l’ordre de priorité des opérateurs.
    public String toInfix();

    // On peut représenter la même expression avec la notation polonaise inversée.
    // Dans celle-ci, les opérandes sont placées devant l’opérateur et les calculs se font toujours de gauche às droite.
    public String toPolonaise();
}
