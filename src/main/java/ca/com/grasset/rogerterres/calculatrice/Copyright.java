package ca.com.grasset.rogerterres.calculatrice;

import java.lang.annotation.Documented;

@Documented

/**
 * Une Annotation uniquement pour faciliter et standardiser la signature des classes.
 **/
public @interface Copyright {

    String instituition();

    String professeur();

    String eleve();

    String cours();

    String groupe();

    String session();
}
