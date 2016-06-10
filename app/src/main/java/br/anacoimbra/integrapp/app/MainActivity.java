package br.anacoimbra.integrapp.app;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText txtCinco;
    EditText txtQuatro;
    EditText txtTres;
    EditText txtDois;
    EditText txtUm;
    EditText txtLivre;

    EditText txtMinimo;
    EditText txtMaximo;

    Button btnCalcular;

    TextView txtEquacao;
    TextView txtIndefinido;
    TextView txtDefinido;
    TextView txtNumerico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        txtCinco = (EditText)findViewById(R.id.txtCinco);
        txtQuatro = (EditText)findViewById(R.id.txtQuatro);
        txtTres = (EditText)findViewById(R.id.txtTres);
        txtDois = (EditText)findViewById(R.id.txtDois);
        txtUm = (EditText)findViewById(R.id.txtUm);
        txtLivre = (EditText)findViewById(R.id.txtLivre);

        txtMaximo = (EditText)findViewById(R.id.txtMaximo);
        txtMinimo = (EditText)findViewById(R.id.txtMinimo);

        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        txtEquacao = (TextView)findViewById(R.id.txtEquacao);
        txtIndefinido = (TextView)findViewById(R.id.txtIndefinido);
        txtDefinido = (TextView)findViewById(R.id.txtDefinido);
        txtNumerico = (TextView)findViewById(R.id.txtNumerico);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String equacao = "∫";
                String indefinida = "";
                String resultadoMax = "";
                String resultadoMin = "";
                double resultado_numerico = 0;
                if(txtCinco.getText().toString().length() > 0){
                    //if(Integer.valueOf(txtCinco.getText().toString()) != 1) equacao += txtCinco.getText().toString();
                    equacao += "e^x";
                    //if(Integer.valueOf(txtCinco.getText().toString()) != 1) indefinida += txtCinco.getText().toString();
                    indefinida += "e^x";
                    if(txtMaximo.getText().toString().length() > 0){
                        resultado_numerico +=  Math.pow(Math.E,Integer.valueOf(txtMaximo.getText().toString()));
                        resultadoMax += "e^" + Integer.valueOf(txtMaximo.getText().toString());
                    }
                    if(txtMinimo.getText().toString().length() > 0){
                        resultadoMin += "e^" + Integer.valueOf(txtMinimo.getText().toString());
                        resultado_numerico += -Math.pow(Math.E,Integer.valueOf(txtMinimo.getText().toString()));
                    }
                }
                if(txtQuatro.getText().toString().length() > 0){
                    if(equacao != "∫"){
                        equacao += " + ";
                        indefinida += " + ";
                        resultadoMax += " + ";
                        resultadoMin += " + ";
                    }
                    if(Integer.valueOf(txtQuatro.getText().toString()) != 1) equacao += txtQuatro.getText().toString();
                    equacao += "x⁴";
                    if(Integer.valueOf(txtQuatro.getText().toString()) != 1) indefinida += txtQuatro.getText().toString();
                    indefinida += "x⁵/5";
                    if(txtMaximo.getText().toString().length() > 0){
                        resultadoMax += txtQuatro.getText().toString() + "x" + Math.pow(Integer.valueOf(txtMaximo.getText().toString()), 5) + "/5";
                        resultado_numerico += (Integer.valueOf(txtQuatro.getText().toString()) * Math.pow(Integer.valueOf(txtMaximo.getText().toString()), 5))/5;
                    }
                    if(txtMinimo.getText().toString().length() > 0){
                        resultadoMin += txtQuatro.getText().toString() + "x" + Math.pow(Integer.valueOf(txtMinimo.getText().toString()), 6) + "/6";
                        resultado_numerico += -(Integer.valueOf(txtQuatro.getText().toString()) * Math.pow(Integer.valueOf(txtMinimo.getText().toString()),5))/5;
                    }
                }
                if(txtTres.getText().toString().length() > 0){
                    if(equacao != "∫"){
                        equacao += " + ";
                        indefinida += " + ";
                        resultadoMax += " + ";
                        resultadoMin += " + ";
                    }
                    if(Integer.valueOf(txtTres.getText().toString()) != 1) equacao += txtTres.getText().toString();
                    equacao += "x³";
                    if(Integer.valueOf(txtTres.getText().toString()) != 1) indefinida += txtTres.getText().toString();
                    indefinida += "x⁴/4";
                    if(txtMaximo.getText().toString().length() > 0){
                        resultadoMax += txtTres.getText().toString() + "x" + Math.pow(Integer.valueOf(txtMaximo.getText().toString()), 4) + "/4";
                        resultado_numerico += (Integer.valueOf(txtTres.getText().toString()) * Math.pow(Integer.valueOf(txtMaximo.getText().toString()), 4))/4;
                    }
                    if(txtMinimo.getText().toString().length() > 0){
                        resultadoMin += txtTres.getText().toString() + "x" + Math.pow(Integer.valueOf(txtMinimo.getText().toString()), 4) + "/4";
                        resultado_numerico += -(Integer.valueOf(txtTres.getText().toString()) * Math.pow(Integer.valueOf(txtMinimo.getText().toString()), 4))/4;
                    }
                }
                if(txtDois.getText().toString().length() > 0){
                    if(equacao != "∫"){
                        equacao += " + ";
                        indefinida += " + ";
                        resultadoMax += " + ";
                        resultadoMin += " + ";
                    }
                    if(Integer.valueOf(txtDois.getText().toString()) != 1) equacao += txtDois.getText().toString();
                    equacao += "x²";
                    if(Integer.valueOf(txtDois.getText().toString()) != 1) indefinida += txtDois.getText().toString();
                    indefinida += "x³/3";
                    if(txtMaximo.getText().toString().length() > 0){
                        resultadoMax += txtDois.getText().toString() + "x" + Math.pow(Integer.valueOf(txtMaximo.getText().toString()), 3) + "/3";
                        resultado_numerico += (Integer.valueOf(txtDois.getText().toString()) * Math.pow(Integer.valueOf(txtMaximo.getText().toString()), 3))/3;
                    }
                    if(txtMinimo.getText().toString().length() > 0){
                        resultadoMin += txtDois.getText().toString() + "x" + Math.pow(Integer.valueOf(txtMinimo.getText().toString()), 3) + "/3";
                        resultado_numerico += -(Integer.valueOf(txtDois.getText().toString()) * Math.pow(Integer.valueOf(txtMinimo.getText().toString()), 3))/3;
                    }
                }
                if(txtUm.getText().toString().length() > 0){
                    if(equacao != "∫"){
                        equacao += " + ";
                        indefinida += " + ";
                        resultadoMax += " + ";
                        resultadoMin += " + ";
                    }
                    if(Integer.valueOf(txtUm.getText().toString()) != 1) equacao += txtUm.getText().toString();
                    equacao += "x";
                    if(Integer.valueOf(txtUm.getText().toString()) != 1) indefinida += txtUm.getText().toString();
                    indefinida += "x²/2";
                    if(txtMaximo.getText().toString().length() > 0){
                        resultadoMax += txtUm.getText().toString() + "x" + Math.pow(Integer.valueOf(txtMaximo.getText().toString()), 2) + "/2";
                        resultado_numerico += (Integer.valueOf(txtUm.getText().toString()) * Math.pow(Integer.valueOf(txtMaximo.getText().toString()), 2))/2;
                    }
                    if(txtMinimo.getText().toString().length() > 0){
                        resultadoMin += txtUm.getText().toString() + "x" + Math.pow(Integer.valueOf(txtMinimo.getText().toString()), 2) + "/2";
                        resultado_numerico += -(Integer.valueOf(txtUm.getText().toString()) * Math.pow(Integer.valueOf(txtMinimo.getText().toString()), 2))/2;
                    }
                }
                if(txtLivre.getText().toString().length() > 0){
                    if(equacao != "∫"){
                        equacao += " + ";
                        indefinida += " + ";
                        resultadoMax += " + ";
                        resultadoMin += " + ";
                    }
                    equacao += txtLivre.getText().toString();
                    indefinida += txtLivre.getText().toString() + "x";
                    if(txtMaximo.getText().toString().length() > 0){
                        resultadoMax += txtLivre.getText().toString() + "x" + (Integer.valueOf(txtMaximo.getText().toString()));
                        resultado_numerico += (Integer.valueOf(txtLivre.getText().toString()) * Integer.valueOf(txtMaximo.getText().toString()));
                    }
                    if(txtMinimo.getText().toString().length() > 0){
                        resultadoMin += txtLivre.getText().toString() + "x" + (Integer.valueOf(txtMinimo.getText().toString()));
                        resultado_numerico += -(Integer.valueOf(txtLivre.getText().toString()) * Integer.valueOf(txtMinimo.getText().toString()));
                    }
                }
                indefinida += " + C";
                txtEquacao.setText(equacao +"dx");
                txtIndefinido.setText(indefinida);
                txtDefinido.setText(resultadoMax + " - (" + resultadoMin + ")");
                txtNumerico.setText(String.valueOf(resultado_numerico));
//                txtResultado.setText("Indefinida: " + indefinida + "\nDefinida: " + resultadoMax + " - (" + resultadoMin + ")\nNumérico: " + resultado_numerico);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }
}
