package ca.com.grasset.rogerterres.calculatrice.operations;

import org.junit.Test;

import ca.com.grasset.rogerterres.calculatrice.Copyright;
import ca.com.grasset.rogerterres.calculatrice.expressions.Expression;

import static org.junit.Assert.assertEquals;

@Copyright(
        instituition = "Institut Grasset",
        professeur = "Rébecca Lapointe",
        eleve = "Roger Terres",
        cours = "Programmation Orientée Objet II (420-GC6-AG)",
        groupe = "00099",
        session = "Été 2018"
)

/**
 * Teste la classe Soustraction
 */
public class SoustractionTest {

    private Expression operand1, operand2;

    @Test
    public void testA() {
        operand1 = new Scalaire(22.08);
        operand2 = new Scalaire(23.08);

        assertEquals(-1.0, new Soustraction(operand1, operand2).evaluer(), 0);
        assertEquals("( 22.08 - 23.08 )", new Soustraction(operand1, operand2).toInfix());
        assertEquals("22.08 23.08 -", new Soustraction(operand1, operand2).toPolonaise());
    }

    @Test
    public void testB() {
        operand1 = new Scalaire(1234567890);
        operand2 = new Scalaire(1000000000);

        assertEquals(2.3456789E8, new Soustraction(operand1, operand2).evaluer(), 0);
        assertEquals("( 1.23456789E9 - 1.0E9 )", new Soustraction(operand1, operand2).toInfix());
        assertEquals("1.23456789E9 1.0E9 -", new Soustraction(operand1, operand2).toPolonaise());
    }

    @Test
    public void testC() {
        operand1 = new Scalaire(0);
        operand2 = new Scalaire(0);

        assertEquals(0, new Soustraction(operand1, operand2).evaluer(), 0);
        assertEquals("( 0.0 - 0.0 )", new Soustraction(operand1, operand2).toInfix());
        assertEquals("0.0 0.0 -", new Soustraction(operand1, operand2).toPolonaise());
    }

}