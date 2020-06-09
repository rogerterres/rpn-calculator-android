package ca.com.grasset.rogerterres.calculatrice.expressions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.util.EmptyStackException;

import ca.com.grasset.rogerterres.calculatrice.Copyright;
import ca.com.grasset.rogerterres.calculatrice.R;

@Copyright(
        instituition = "Institut Grasset",
        professeur = "Rébecca Lapointe",
        eleve = "Roger Terres",
        cours = "Programmation Orientée Objet II (420-GC6-AG)",
        groupe = "00099",
        session = "Été 2018"
)

/**
 * Classe principale qui a une méthode main et connecte le code avec l'interface d'Android Studio
 * La classe MainActivity de votre interface graphique de calculatrice va passer par FabriqueExpression
 * pour ́evaluer l’expression entrée par l’usager. Vous pouvez supposer que l’usager va entrer son expression en notation polonaise.
 */

public class MainActivity extends AppCompatActivity {

    private EditText affichage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.polonaise);

        affichage = (EditText) findViewById(R.id.text);
        Button egal = findViewById(R.id.b_egal);

        // méthode pour l'action du bouton egal
        egal.setOnClickListener((view) -> {
            try {
                DecimalFormat decimalFormat = new DecimalFormat("#0.0#");
                FabriqueExpression fabriqueExpression = new FabriqueExpression();
                Expression expression = fabriqueExpression.batirFromPolonaise(affichage.getText().toString());
                affichage.setText(decimalFormat.format(expression.evaluer()) + "\n");
                affichage.append(expression.toInfix() + "\n");
                affichage.append(expression.toPolonaise());
                // traitement des exceptions
            } catch (EmptyStackException ese) {
                affichage.setText("EXPRESSION INVALIDE");
            } catch (ArithmeticException ae) {
                affichage.setText(ae.getMessage());
            }
        });
    }

    // bouton pour nettoyer l'EditText
    public void button_ac(View view) {
        affichage.setText("");
    }

    // bouton pour effacer un chiffre
    public void button_del(View view) {
        if (!affichage.getText().toString().equals("")) {
            affichage.setText(affichage.getText().subSequence(0, affichage.getText().length() - 1) + "");
        }
    }

    // méthode d'action pour les boutons.
    // Si l'utilisateur clique sur un bouton, le chiffre ou l'opération correspondant sera affiché sur l'écran.
    public void cliquerBouton(View view) {
        Button b = (Button) view;
        if (b.getText().equals("ESPACE")) {
            affichage.append(b.getText());
        } else {
            affichage.append(b.getText());
        }
    }
}
