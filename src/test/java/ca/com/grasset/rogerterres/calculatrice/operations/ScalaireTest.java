package ca.com.grasset.rogerterres.calculatrice.operations;

import org.junit.Test;

import ca.com.grasset.rogerterres.calculatrice.Copyright;

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
 * Teste la classe Scalaire
 */
public class ScalaireTest {

    private double scalaire;

    @Test
    public void testA() {
        scalaire = 2018;

        assertEquals(2018.0, new Scalaire(scalaire).evaluer(), 0);
        assertEquals("2018.0", new Scalaire(scalaire).toInfix());
        assertEquals("2018.0", new Scalaire(scalaire).toPolonaise());
    }

    @Test
    public void testB() {
        scalaire = -0.0;

        assertEquals(-0.0, new Scalaire(scalaire).evaluer(), 0);
        assertEquals("-0.0", new Scalaire(scalaire).toInfix());
        assertEquals("-0.0", new Scalaire(scalaire).toPolonaise());
    }

    @Test
    public void testC() {
        scalaire = 2147483647;

        assertEquals(2.147483647E9, new Scalaire(scalaire).evaluer(), 0);
        assertEquals("2.147483647E9", new Scalaire(scalaire).toInfix());
        assertEquals("2.147483647E9", new Scalaire(scalaire).toPolonaise());
    }
}