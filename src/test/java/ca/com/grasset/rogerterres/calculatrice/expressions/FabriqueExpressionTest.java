package ca.com.grasset.rogerterres.calculatrice.expressions;

import org.junit.Before;
import org.junit.Test;

import ca.com.grasset.rogerterres.calculatrice.Copyright;
import ca.com.grasset.rogerterres.calculatrice.operations.Addition;
import ca.com.grasset.rogerterres.calculatrice.operations.Division;
import ca.com.grasset.rogerterres.calculatrice.operations.Multiplication;
import ca.com.grasset.rogerterres.calculatrice.operations.Scalaire;
import ca.com.grasset.rogerterres.calculatrice.operations.Soustraction;

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
 * Teste la classe FabriqueExpression
 */
public class FabriqueExpressionTest {

    private FabriqueExpression fabriqueExpression;

    @Before
    public void init() {
        fabriqueExpression = new FabriqueExpression();
    }

    @Test
    public void testA() {
        Expression a = new Scalaire(5);
        assertEquals(a.evaluer(), 5, 0);
    }

    @Test
    public void testB() {
        Expression a = new Scalaire(5);
        Expression b = new Scalaire(6);
        Expression c = new Addition(b, a);
        assertEquals(c.evaluer(), 11, 0);
    }

    @Test
    public void testC() {
        Expression a = new Scalaire(5);
        Expression b = new Scalaire(6);
        Expression c = new Soustraction(b, a);
        assertEquals(c.evaluer(), 1, 0);
    }

    @Test
    public void testD() {
        Expression a = new Scalaire(2);
        Expression b = new Scalaire(6);
        Expression c = new Division(b, a);
        assertEquals(c.evaluer(), 3, 0);
    }

    @Test
    public void testE() {
        Expression a = new Scalaire(1);
        Expression b = new Scalaire(2);
        Expression c = new Addition(b, a);
        Expression d = new Scalaire(4);
        Expression e = new Scalaire(2);
        Expression f = new Division(d, e);
        Expression g = new Multiplication(f, c);
        assertEquals(g.evaluer(), 6, 0);
    }
}