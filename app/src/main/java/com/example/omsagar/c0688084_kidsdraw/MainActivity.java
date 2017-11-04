package com.example.omsagar.c0688084_kidsdraw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button save, reset, reload, newline, space, first, second;
    ImageButton up, down, left, right;
    EditText canvas;
    String enteredString;
    Integer cnt;
    private  DataBase dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandler = new DataBase(this);
        up = (ImageButton) findViewById(R.id.imageButton8);
        left = (ImageButton)findViewById(R.id.imageButton7);
        down = (ImageButton) findViewById(R.id.imageButton9);
        right = (ImageButton) findViewById(R.id.imageButton11);

        save = (Button) findViewById(R.id.button6);
        reset = (Button) findViewById(R.id.button9);
        reload = (Button) findViewById(R.id.button12);

        canvas = (EditText) findViewById(R.id.canvas);
        enteredString = "";
        cnt = 0 ;

        newline =(Button) findViewById(R.id.button13);
        //down1 = (Button) findViewById(R.id.button14);

        first = (Button) findViewById(R.id.button15);
        second = (Button) findViewById(R.id.button16);
        space = (Button) findViewById(R.id.button14);

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //enteredString = enteredString + (canvas.getX() - 0.5);
                Float getypos = (canvas.getY() - 10);
                canvas.setY(getypos);
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float getypos = (canvas.getY() + 10);
                canvas.setY(getypos);
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float getxpos = (canvas.getX() + 10);
                canvas.setX(getxpos);
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float getxpos = (canvas.getX() - 10);
                canvas.setX(getxpos);
            }
        });

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cnt >= 1)
                {
                    enteredString = enteredString + " | ";
                }
                else
                {
                    enteredString = enteredString +" | ";
                    cnt = cnt + 1;
                }
                canvas.setText(enteredString);
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredString = enteredString +" _ ";
                cnt = 0;
                canvas.setText(enteredString);
            }
        });

        newline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredString = enteredString +"\n";
                canvas.setText(enteredString);
            }
        });

        space.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredString = enteredString + " ";
                canvas.setText(enteredString);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredString = "";
                canvas.setText(enteredString);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredString = canvas.getText().toString();
                dbHandler.addNewLetter(enteredString);
            }
        });

        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> drawinglist = dbHandler.getDrawing();
                canvas.setText(drawinglist.get(drawinglist.size()-1));
            }
        });
    }
}
