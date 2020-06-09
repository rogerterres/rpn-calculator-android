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
 * Classe responsable pour l'opération de Multiplication, qui implémente l'interface Expression
 */
public class Multiplication implements Expression {

    private Expression operand1, operand2;

    public Multiplication(Expression operand1, Expression operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public double evaluer() {
        return operand1.evaluer() * operand2.evaluer();
    }

    @Override
    public String toInfix() {
        return "( " + operand1.toInfix() + " * " + operand2.toInfix() + " )";
    }

    @Override
    public String toPolonaise() {
        return operand1.toPolonaise() + " " + operand2.toPolonaise() + " *";
    }
}
