package com.example.first_lecture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.first_lecture.model.IMovieDa;
import com.example.first_lecture.model.Movie;
import com.example.first_lecture.model.MovieFactory;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView t;

    Spinner yearSpinner,genreSpinner;
    Button searchButton;
    EditText titleField;

    CheckBox checkYear,checkTitle,checkGenre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t=findViewById(R.id.txtView);
        yearSpinner=findViewById(R.id.spnYear);
        searchButton=findViewById(R.id.btnSubmit);
        titleField=findViewById(R.id.edtTitle);
        checkTitle=findViewById(R.id.checkTitle);
        checkYear=findViewById(R.id.checkYear);
        checkGenre=findViewById(R.id.checkGenre);
        genreSpinner=findViewById(R.id.spngenre);



        MovieFactory factory=new MovieFactory();
        IMovieDa iMovieDa=factory.getModel();

        String years[]=iMovieDa.getYears();
        ArrayAdapter<String>yearsAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,years);
        yearSpinner.setAdapter(yearsAdapter);

        String []genres=iMovieDa.getGenres();

        ArrayAdapter<String>genresAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,genres);

        genreSpinner.setAdapter(genresAdapter);


        genreSpinner.setEnabled(false);
        yearSpinner.setEnabled(false);
        titleField.setEnabled(false);



    }


    public void btnSearchOnClick(View view) {

        t.setText("");
        MovieFactory factory=new MovieFactory();
        IMovieDa iMovieDa=factory.getModel();
        ArrayList<Movie>movies=iMovieDa.getAllMovies();

        if(checkTitle.isChecked()){
            if(titleField.getText().toString().isEmpty()){
                Toast.makeText(this, "Please fill the title field or Uncheck the box", Toast.LENGTH_SHORT).show();
            }else{

                movies=iMovieDa.getMoviesByTitle(movies,titleField.getText().toString());
            }
        }


        if(checkYear.isChecked()){
            movies=iMovieDa.getMoviesByYear(movies,Integer.parseInt(yearSpinner.getSelectedItem().toString()));

        }

        if(checkGenre.isChecked()){


            movies=iMovieDa.getMoviesByGenre(movies,genreSpinner.getSelectedItem().toString());

        }

        if(movies.isEmpty()){
            t.setText("No movies suit the filters");
            return;
        }


        //printing on screen
        String output="";
        int counter=1;
        for (Movie m :movies){

            output+=counter+"- "+m.getTitle()+"\n";
            counter++;


        }
        t.setText(output);



    }


    public void checkYearOnClick(View view) {
        if(checkYear.isChecked()){
            yearSpinner.setEnabled(true);
        }else{
            yearSpinner.setEnabled(false);
        }

    }

    public void checkTitleOnClick(View view) {
        if(checkTitle.isChecked()){
            titleField.setEnabled(true);

        }else{
            titleField.setEnabled(false);

        }

    }

    public void checkGenreOnClick(View view) {
        if(checkGenre.isChecked()){
            genreSpinner.setEnabled(true);
        }else{
            genreSpinner.setEnabled(false);

        }
    }




}