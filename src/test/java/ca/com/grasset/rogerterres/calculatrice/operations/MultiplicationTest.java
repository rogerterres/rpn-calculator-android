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
 * Teste la classe Multiplication
 */
public class MultiplicationTest {

    private Expression operand1, operand2;

    @Test
    public void testA() {
        operand1 = new Scalaire(22.08);
        operand2 = new Scalaire(23.08);

        assertEquals(509.60639999999995, new Multiplication(operand1, operand2).evaluer(), 0);
        assertEquals("( 22.08 * 23.08 )", new Multiplication(operand1, operand2).toInfix());
        assertEquals("22.08 23.08 *", new Multiplication(operand1, operand2).toPolonaise());
    }

    @Test
    public void testB() {
        operand1 = new Scalaire(123456789);
        operand2 = new Scalaire(3);

        assertEquals(3.70370367E8, new Multiplication(operand1, operand2).evaluer(), 0);
        assertEquals("( 1.23456789E8 * 3.0 )", new Multiplication(operand1, operand2).toInfix());
        assertEquals("1.23456789E8 3.0 *", new Multiplication(operand1, operand2).toPolonaise());
    }

    @Test
    public void testC() {
        operand1 = new Scalaire(0);
        operand2 = new Scalaire(0);

        assertEquals(0, new Multiplication(operand1, operand2).evaluer(), 0);
        assertEquals("( 0.0 * 0.0 )", new Multiplication(operand1, operand2).toInfix());
        assertEquals("0.0 0.0 *", new Multiplication(operand1, operand2).toPolonaise());
    }

}