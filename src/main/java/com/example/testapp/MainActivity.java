package com.example.testapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.testapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    /**
     * Ces variables representent les differents composants que nous avons placez
     * dans le fichier ...main.xml
     */
    TextView btn1,btn0,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn_equal,btn_comma,btn_plus,btn_moins,btn_prod,btn_div,btn_clear;

    /**
     * input nous permet d'afficher les valeurs entrées a chaque niveau et la valeur finale de l'evaluation
     *
     * intermediate nous permet d'afficher les calculs intermediaires et est par defaut invisible, c'est pourquoi on le rend d'abord visible
     * avant d'y stocké des données
     *
     */
    EditText input,intermediate;

    //Declaration des veroux
    Boolean isComma = false,isNewOp = true,isOperator = true,isNewCalc = true;

    //la valeur que l'on a entrée et qui sera evaluer plus tard
    String result,op="";

    //Le verou de decompte pour connaitre si une expression doit deja etre evaluer ou pas
    int isEitherOneOp = 0;

    //declaration des valeurs binaires d'evaluation
    float resultat = 0,interSol = 0;

    /**
     * La fonction la plus importante du cycle de vie qui nous permet de definir comment on initialise notre apk
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //demarrage de la vue ...main.xml
        setContentView(R.layout.activity_main);

        /**
         * A la creation de l'application on reference chaque champs afin de lui ajouter une action
         */

        //Les numeriques
        btn0 = findViewById(R.id.bu0);
        btn1 = findViewById(R.id.bu1);
        btn2 = findViewById(R.id.bu2);
        btn3 = findViewById(R.id.bu3);
        btn4 = findViewById(R.id.bu4);
        btn5 = findViewById(R.id.bu5);
        btn6 = findViewById(R.id.bu6);
        btn7 = findViewById(R.id.bu7);
        btn8 = findViewById(R.id.bu8);
        btn9 = findViewById(R.id.bu9);

        //Les operateurs et autres
        btn_equal = findViewById(R.id.buEqual);
        btn_comma = findViewById(R.id.buComma);
        btn_plus = findViewById(R.id.buPlus);
        btn_moins = findViewById(R.id.buMoins);
        btn_prod = findViewById(R.id.buProd);
        btn_div = findViewById(R.id.buDiv);
        btn_clear = findViewById(R.id.buClear);

        //La sortie/entrée de la calculatrice
        input = findViewById(R.id.input);
        intermediate = findViewById(R.id.intermediate);


        /**
         * Definition des actions sur les numeriques et la virgule...
         */
        btn0.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (isNewOp)
                     input.setText("");
                 isNewOp = false;
                 isOperator = false;
                 result = input.getText().toString();
                 input.setText(result + "0");
             }
         });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNewOp)
                    input.setText("");
                isNewOp = false;
                isOperator = false;
                result = input.getText().toString();
                input.setText(result + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNewOp)
                    input.setText("");
                isNewOp = false;
                isOperator = false;
                result = input.getText().toString();
                input.setText(result + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNewOp)
                    input.setText("");
                isNewOp = false;
                isOperator = false;
                result = input.getText().toString();
                input.setText(result + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNewOp)
                    input.setText("");
                isNewOp = false;
                isOperator = false;
                result = input.getText().toString();
                input.setText(result + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNewOp)
                    input.setText("");
                isNewOp = false;
                isOperator = false;
                result = input.getText().toString();
                input.setText(result + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNewOp)
                    input.setText("");
                isNewOp = false;
                isOperator = false;
                result = input.getText().toString();
                input.setText(result + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNewOp)
                    input.setText("");
                isNewOp = false;
                isOperator = false;
                result = input.getText().toString();
                input.setText(result + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNewOp)
                    input.setText("");
                isNewOp = false;
                isOperator = false;
                result = input.getText().toString();
                input.setText(result + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNewOp)
                    input.setText("");
                isNewOp = false;
                isOperator = false;
                result = input.getText().toString();
                input.setText(result + "9");
            }
        });
        btn_comma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = input.getText().toString();
                if (!isComma && !isOperator){
                    input.setText(result + ".");
                    isComma = true;
                    isNewOp = false;
                }
            }
        });

        /**
         * Le button C reinitialise la calculatrice
         */
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("0");
                op = "";
                resultat = 0;
                isNewOp = true;
                isComma = false;
                isOperator = false;
                isNewCalc = true;
                intermediate.setText("");
                intermediate.setVisibility(View.INVISIBLE);
                isEitherOneOp = 0;
            }
        });

        /**
         * Les operateurs ...
         *
         * Si la chaine est de la forme 'a' alors on considere cette valeur la en premier parametre
         * Mais si la chaine est deja de la forme 'a op b' (ou op representent un operateur) on evalue
         * cette chaine et on conserve le resultat pour les evaluations futurs
         *
         * Les evaluations se font sans priorité et de gauche a droite
         *
         *
         */

        btn_moins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isOperator){
                    if (isEitherOneOp == 0){
                        resultat = Float.parseFloat(input.getText().toString());
                        isEitherOneOp++;
                    }else{
                        btn_equal.performClick();
                        isEitherOneOp++;
                        resultat = Float.parseFloat(input.getText().toString());
                        intermediate.setVisibility(View.VISIBLE);
                        intermediate.setText(input.getText().toString());
                    }
                    input.setText("");
                    op = "-";
                    isComma = false;
                    isOperator = true;
                }
            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isOperator){
                    if (isEitherOneOp == 0){
                        resultat = Float.parseFloat(input.getText().toString());
                        isEitherOneOp++;
                    }else{
                        btn_equal.performClick();
                        isEitherOneOp++;
                        resultat = Float.parseFloat(input.getText().toString());
                        intermediate.setVisibility(View.VISIBLE);
                        intermediate.setText(input.getText().toString());
                    }
                    op = "+";
                    input.setText("");
                    isComma = false;
                    isOperator = true;
                }
            }
        });
        btn_prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isOperator){
                    if (isEitherOneOp == 0){
                        resultat = Float.parseFloat(input.getText().toString());
                        isEitherOneOp++;
                    }else{
                        btn_equal.performClick();
                        isEitherOneOp++;
                        resultat = Float.parseFloat(input.getText().toString());
                        intermediate.setVisibility(View.VISIBLE);
                        intermediate.setText(input.getText().toString());
                    }
                    op = "x";
                    input.setText("");
                    isComma = false;
                    isOperator = true;
                }
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isOperator){
                    if (isEitherOneOp == 0){
                        resultat = Float.parseFloat(input.getText().toString());
                        isEitherOneOp++;
                    }else{
                        btn_equal.performClick();
                        isEitherOneOp++;
                        resultat = Float.parseFloat(input.getText().toString());
                        intermediate.setVisibility(View.VISIBLE);
                        intermediate.setText(input.getText().toString());
                    }
                    op = "/";
                    input.setText("");
                    isComma = false;
                    isOperator = true;
                }
            }
        });


        /**
         * Evaluation de l'entrée
         *
         * On evalue la derniere chaine entrée et on genere le resultat
         *
         */
        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isOperator){
                    float newInput = Float.parseFloat(input.getText().toString());
                    float result = 0;
                    switch (op){
                        case "+":
                            result = resultat + newInput;
                            break;
                        case "-":
                            result = resultat - newInput ;
                            break;
                        case "x":
                            result = resultat * newInput;
                            break;
                        case "/":
                            result = resultat / newInput ;
                            break;
                        default:
                            result = newInput;
                            break;
                    }
                    input.setText(result+"");
                    interSol = result;
                    isComma = true;
                    intermediate.setText("");
                    intermediate.setVisibility(View.INVISIBLE);
                    isEitherOneOp = 0;
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}