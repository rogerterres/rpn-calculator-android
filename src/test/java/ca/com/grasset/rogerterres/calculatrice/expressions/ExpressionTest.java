package ca.com.grasset.rogerterres.calculatrice.expressions;

/*
    Les réponses aux questions de la section 2.2.
 */

import org.junit.Test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

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
 * Compréhension du problème
 * Pour chacune des expressions arithḿetiques suivantes :
 *
 * (a) 1.01 2 3 4 5 + - * /
 *  > Valide.
 *  > ( 1.01 / ( 2.0 * ( 3.0 - ( 4.0 + 5.0 ) ) ) )
 *  > Résultat : -0.08416666666666667
 *
 * (b) 1 + 2 - 3 * 4 / 5
 *  > Expression Invalide.
 *  > EmptyStackException.
 *
 * (c) 1 2 3 4 5 a ( * x
 *  > Expression Invalide.
 *  > NullPointerException.
 *
 * (d) 1 2 + 30 - 4 * 5 /
 *  > Valide.
 *  > ( ( ( ( 1.0 + 2.0 ) - 30.0 ) * 4.0 ) / 5.0 )
 *  > Résultat : -21.6
 *
 * (e) 11 2 + 3 4 5 - * /
 *  > Valide.
 *  > ( ( 11.0 + 2.0 ) / ( 3.0 * ( 4.0 - 5.0 ) ) )
 *  > Résultat : -4.333333333333333
 *
 * (f) 45 5 * 1 2 + 3 - /
 *  > Valide.
 *  > ( ( 45.0 * 5.0 ) / ( ( 1.0 + 2.0 ) - 3.0 ) )
 *  > Résultat : Infinity
 *
 *
 * D́eterminez si elle est valide. Si elle l’est:
 * • Listez tous les appels aux constructeurs, dans le bon ordre.
 * • Évaluez-la.
 * • Donnez sa représentation infix entièrement parenth́eśee.
 */

public class ExpressionTest {

    DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.CANADA);
    DecimalFormat decimalFormat = new DecimalFormat("#.0#", symbols);
    FabriqueExpression fabriqueExpression = new FabriqueExpression();

    @Test
    public void testA() {
        String input = "1.01 2 3 4 5 + - * /";
        assertEquals(-0.08416666666666667, fabriqueExpression.batirFromPolonaise(input).evaluer(), 0);
        assertEquals("( 1.01 / ( 2.0 * ( 3.0 - ( 4.0 + 5.0 ) ) ) )", fabriqueExpression.batirFromPolonaise(input).toInfix());
        assertEquals("1.01 2.0 3.0 4.0 5.0 + - * /", fabriqueExpression.batirFromPolonaise(input).toPolonaise());
    }

    @Test
    public void testB() {
        String input = "1 + 2 - 3 * 4 / 5";
        assertEquals(0, fabriqueExpression.batirFromPolonaise(input).evaluer(), 0);
        assertEquals("", fabriqueExpression.batirFromPolonaise(input).toInfix());
        assertEquals("1.0 + 2.0 - 3.0 * 4.0 / 5.0", fabriqueExpression.batirFromPolonaise(input).toPolonaise());
    }

    @Test
    public void testC() {
        String input = "1 2 3 4 5 a ( * x";
        assertEquals(4.533333333333333, fabriqueExpression.batirFromPolonaise(input).evaluer(), 0);
        assertEquals("( ( 1.0 + 67.0 ) / ( ( 5.0 - 2.0 ) * 5.0 ) )", fabriqueExpression.batirFromPolonaise(input).toInfix());
        assertEquals("1.0 67.0 + 5.0 2.0 - 5.0 * /", fabriqueExpression.batirFromPolonaise(input).toPolonaise());
    }

    @Test
    public void testD() {
        String input = "1 2 + 30 - 4 * 5 /";
        assertEquals(-21.6, fabriqueExpression.batirFromPolonaise(input).evaluer(), 0);
        assertEquals("( ( ( ( 1.0 + 2.0 ) - 30.0 ) * 4.0 ) / 5.0 )", fabriqueExpression.batirFromPolonaise(input).toInfix());
        assertEquals("1.0 2.0 + 30.0 - 4.0 * 5.0 /", fabriqueExpression.batirFromPolonaise(input).toPolonaise());
    }

    @Test
    public void testE() {
        String input = "11 2 + 3 4 5 - * /";
        assertEquals(-4.333333333333333, fabriqueExpression.batirFromPolonaise(input).evaluer(), 0);
        assertEquals("( ( 11.0 + 2.0 ) / ( 3.0 * ( 4.0 - 5.0 ) ) )", fabriqueExpression.batirFromPolonaise(input).toInfix());
        assertEquals("11.0 2.0 + 3.0 4.0 5.0 - * /", fabriqueExpression.batirFromPolonaise(input).toPolonaise());
    }

    @Test
    public void testF() {
        String input = "45 5 * 1 2 + 3 - /";
        assertEquals(Double.POSITIVE_INFINITY, fabriqueExpression.batirFromPolonaise(input).evaluer(), 0);
        assertEquals("( ( 45.0 * 5.0 ) / ( ( 1.0 + 2.0 ) - 3.0 ) )", fabriqueExpression.batirFromPolonaise(input).toInfix());
        assertEquals("45.0 5.0 * 1.0 2.0 + 3.0 - /", fabriqueExpression.batirFromPolonaise(input).toPolonaise());
    }
}