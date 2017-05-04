package com.wolf.colorex;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import static android.graphics.Color.parseColor;

public class saved extends AppCompatActivity {
    TextView et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11,et12;
    ImageView img;
    TextToSpeech mspeak;
    String textspeak;
    private final int COlOR_SELECTED = 200;
    RelativeLayout ll;
    public  String str,str2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_saved);
        ll = (RelativeLayout) findViewById(R.id.activity_saved);
        et1=(TextView) findViewById(R.id.et1);
        et2=(TextView) findViewById(R.id.et2);
        et3=(TextView) findViewById(R.id.et3);
        et4=(TextView) findViewById(R.id.et4);
        et5=(TextView) findViewById(R.id.et5);
        et6=(TextView) findViewById(R.id.et6);
        et7=(TextView) findViewById(R.id.et7);
        et8=(TextView) findViewById(R.id.et8);
        et9=(TextView) findViewById(R.id.et9);
        et10=(TextView) findViewById(R.id.et10);
        et11=(TextView) findViewById(R.id.et11);
        et12=(TextView) findViewById(R.id.et12);
        img =(ImageView) findViewById(R.id.imageView);


        mspeak = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if(status !=TextToSpeech.ERROR)
                {
                    mspeak.setLanguage(Locale.ENGLISH);
                    mspeak.setPitch(1);


                }
            }
        });

        SharedPreferences sharedPref = getSharedPreferences("Saved", Context.MODE_PRIVATE);
        String col1 = sharedPref.getString("Color","");
        if(sharedPref.contains("Color")) {
            et1.setText("#" + col1);
            int color1 = parseColor("#" + col1);
            et1.setBackgroundColor(color1);
        }
        if(sharedPref.contains("Color1")) {
            String col2 = sharedPref.getString("Color1", "");
            et2.setText("#" + col2);
            int color2 = parseColor("#" + col2);
            et2.setBackgroundColor(color2);
        }
        if(sharedPref.contains("Color2")) {
            String col3 = sharedPref.getString("Color2", "");
            et3.setText("#" + col3);
            int color3 = parseColor("#" + col3);
            et3.setBackgroundColor(color3);
        }
        if(sharedPref.contains("Color3")) {
            String col4 = sharedPref.getString("Color3", "");
            et4.setText("#" + col4);
            int color4 = parseColor("#" + col4);
            et4.setBackgroundColor(color4);
        }
        if(sharedPref.contains("Color4")) {
            String col5 = sharedPref.getString("Color4", "");
            et5.setText("#" + col5);
            int color5 = parseColor("#" + col5);
            et5.setBackgroundColor(color5);
        }
        if(sharedPref.contains("Color5")) {
            String col6 = sharedPref.getString("Color5", "");
            et6.setText("#" + col6);
            int color6 = parseColor("#" + col6);
            et6.setBackgroundColor(color6);
        }
        if(sharedPref.contains("Color6")) {
            String col7 = sharedPref.getString("Color6", "");
            et7.setText("#" + col7);
            int color7 = parseColor("#" + col7);
            et7.setBackgroundColor(color7);
        }
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        et1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textspeak = et1.getText().toString();
                if(textspeak.isEmpty())
                {
                    mspeak.speak("",TextToSpeech.QUEUE_FLUSH,null);
                }
                else
                {
                    if(et1.getText().toString().equals("#0000ff")) {
                        mspeak.speak(" Blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et1.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et1.getText().toString().equals("#ff0000")) {
                        mspeak.speak(" Red", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected = et1.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED", selected);
                        setResult(RESULT_OK, returnIntent);
                        finish();
                    }
                    if(et1.getText().toString().equals("#00ff00")) {
                        mspeak.speak(" Green", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et1.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();

                    }
                    if(et1.getText().toString().equals("#000077")) {
                        mspeak.speak(" Dark Blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et1.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et1.getText().toString().equals("#000000")) {
                        mspeak.speak(" Black", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et1.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et1.getText().toString().equals("#ffffff")) {
                        mspeak.speak(" White", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et1.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et1.getText().toString().equals("#cff00")) {
                        mspeak.speak(" Fluorescent", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et1.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et1.getText().toString().equals("#00ffff")) {
                        mspeak.speak(" light blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et1.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et1.getText().toString().equals("#faa349")) {
                        mspeak.speak(" Orange", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et1.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    else{
                        Intent returnIntent = new Intent();
                        String selected =et1.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                }
            }
        });
        et2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textspeak = et2.getText().toString();
                if(textspeak.isEmpty())
                {
                    mspeak.speak("",TextToSpeech.QUEUE_FLUSH,null);
                }
                else
                {
                    if(et2.getText().toString().equals("#0000ff")) {
                        mspeak.speak(" Blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et2.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et2.getText().toString().equals("#ff0000")) {
                        mspeak.speak(" Red", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et2.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et2.getText().toString().equals("#00ff00")) {
                        mspeak.speak(" Green", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et2.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et2.getText().toString().equals("#000077")) {
                        mspeak.speak(" Dark Blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et2.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et2.getText().toString().equals("#000000")) {
                        mspeak.speak(" Black", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et2.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et2.getText().toString().equals("#ffffff")) {
                        mspeak.speak(" White", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et2.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et2.getText().toString().equals("#cff00")) {
                        mspeak.speak(" Fluorescent", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et2.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et2.getText().toString().equals("#00ffff")) {
                        mspeak.speak(" light blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et2.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et2.getText().toString().equals("#faa349")) {
                        mspeak.speak(" Orange", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et2.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    else{
                        Intent returnIntent = new Intent();
                        String selected =et2.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                }
            }
        });
        et3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textspeak = et3.getText().toString();
                if(textspeak.isEmpty())
                {
                    mspeak.speak("",TextToSpeech.QUEUE_FLUSH,null);
                }
                else
                {
                    if(et3.getText().toString().equals("#0000ff")) {
                        mspeak.speak(" Blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et3.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et3.getText().toString().equals("#ff0000")){
                        mspeak.speak(" Red",TextToSpeech.QUEUE_FLUSH,null);
                        Intent returnIntent = new Intent();
                        String selected =et3.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et3.getText().toString().equals("#00ff00")) {
                        mspeak.speak(" Green", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et3.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et3.getText().toString().equals("#000077")) {
                        mspeak.speak(" Dark Blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et3.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et3.getText().toString().equals("#000000")) {
                        mspeak.speak(" Black", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et3.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et3.getText().toString().equals("#ffffff")) {
                        mspeak.speak(" White", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et3.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et3.getText().toString().equals("#cff00")) {
                        mspeak.speak(" Fluorescent", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et3.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et3.getText().toString().equals("#00ffff")) {
                        mspeak.speak(" light blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et3.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et3.getText().toString().equals("#faa349")) {
                        mspeak.speak(" Orange", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et3.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    else{
                        Intent returnIntent = new Intent();
                        String selected =et3.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                }
            }
        });
        et4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textspeak = et4.getText().toString();
                if(textspeak.isEmpty())
                {
                    mspeak.speak("",TextToSpeech.QUEUE_FLUSH,null);
                }
                else
                {
                    if(et4.getText().toString().equals("#0000ff")) {
                        mspeak.speak(" Blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et4.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et4.getText().toString().equals("#ff0000")){
                        mspeak.speak(" Red",TextToSpeech.QUEUE_FLUSH,null);
                        Intent returnIntent = new Intent();
                        String selected =et4.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et4.getText().toString().equals("#00ff00")) {
                        mspeak.speak(" Green", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et4.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et4.getText().toString().equals("#000077")) {
                        mspeak.speak(" Dark Blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et4.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et4.getText().toString().equals("#000000")) {
                        mspeak.speak(" Black", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et4.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et4.getText().toString().equals("#ffffff")) {
                        mspeak.speak(" White", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et4.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et4.getText().toString().equals("#cff00")) {
                        mspeak.speak(" Fluorescent", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et4.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();}
                    if(et4.getText().toString().equals("#00ffff")) {
                        mspeak.speak(" light blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et4.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et4.getText().toString().equals("#faa349")) {
                        mspeak.speak(" Orange", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et4.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    else{
                        Intent returnIntent = new Intent();
                        String selected =et4.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                }
            }
        });
        et5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textspeak = et5.getText().toString();
                if(textspeak.isEmpty())
                {
                    mspeak.speak("",TextToSpeech.QUEUE_FLUSH,null);
                }
                else
                {
                    if(et5.getText().toString().equals("#0000ff")) {
                        mspeak.speak(" Blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et5.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et5.getText().toString().equals("#ff0000")){
                        mspeak.speak(" Red",TextToSpeech.QUEUE_FLUSH,null);
                        Intent returnIntent = new Intent();
                        String selected =et5.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et5.getText().toString().equals("#00ff00")) {
                        mspeak.speak(" Green", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et5.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et5.getText().toString().equals("#000077")) {
                        mspeak.speak(" Dark Blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et5.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et5.getText().toString().equals("#000000")) {
                        mspeak.speak(" Black", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et5.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et5.getText().toString().equals("#ffffff")) {
                        mspeak.speak(" White", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et5.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et5.getText().toString().equals("#cff00")) {
                        mspeak.speak(" Fluorescent", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et5.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et5.getText().toString().equals("#00ffff")) {
                        mspeak.speak(" light blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et5.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et5.getText().toString().equals("#faa349")) {
                        mspeak.speak(" Orange", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et5.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    else{
                        Intent returnIntent = new Intent();
                        String selected =et5.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                }
            }
        });
        et6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textspeak = et6.getText().toString();
                if(textspeak.isEmpty())
                {
                    mspeak.speak("",TextToSpeech.QUEUE_FLUSH,null);
                }
                else {
                    if (et6.getText().toString().equals("#0000ff")) {
                        mspeak.speak(" Blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =  et6.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED", selected);
                        setResult(RESULT_OK, returnIntent);
                        finish();
                    }
                    if (et6.getText().toString().equals("#ff0000")){
                        mspeak.speak(" Red", TextToSpeech.QUEUE_FLUSH, null);
                    Intent returnIntent = new Intent();
                    String selected = et6.getText().toString().substring(1);
                    returnIntent.putExtra("SELECTED", selected);
                    setResult(RESULT_OK, returnIntent);
                    finish();
                }
                    if(et6.getText().toString().equals("#00ff00")) {
                        mspeak.speak(" Green", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et6.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et6.getText().toString().equals("#000077")) {
                        mspeak.speak(" Dark Blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et6.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et6.getText().toString().equals("#000000")) {
                        mspeak.speak(" Black", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et6.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et6.getText().toString().equals("#ffffff")) {
                        mspeak.speak(" White", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et6.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et6.getText().toString().equals("#cff00")) {
                        mspeak.speak(" Fluorescent", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et6.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et6.getText().toString().equals("#00ffff")) {
                        mspeak.speak(" light blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et6.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et6.getText().toString().equals("#faa349")) {
                        mspeak.speak(" Orange", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et6.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    else{
                        Intent returnIntent = new Intent();
                        String selected =et7.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                }
            }
        });
        et7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textspeak = et7.getText().toString();
                if(textspeak.isEmpty())
                {
                    mspeak.speak("",TextToSpeech.QUEUE_FLUSH,null);
                }
                else {
                    if (et7.getText().toString().equals("#0000ff")) {
                        mspeak.speak(" Blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected = et7.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED", selected);
                        setResult(RESULT_OK, returnIntent);
                        finish();
                    }
                    if (et7.getText().toString().equals("#ff0000")){
                        mspeak.speak(" Red", TextToSpeech.QUEUE_FLUSH, null);
                    Intent returnIntent = new Intent();
                    String selected = et7.getText().toString().substring(1);
                    returnIntent.putExtra("SELECTED", selected);
                    setResult(RESULT_OK, returnIntent);
                    finish();
                }
                    if(et7.getText().toString().equals("#00ff00")) {
                        mspeak.speak(" Green", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et7.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et7.getText().toString().equals("#000077")) {
                        mspeak.speak(" Dark Blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et7.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et7.getText().toString().equals("#000000")) {
                        mspeak.speak(" Black", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et7.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et7.getText().toString().equals("#ffffff")) {
                        mspeak.speak(" White", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et7.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et7.getText().toString().equals("#cff00")) {
                        mspeak.speak(" Fluorescent", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et7.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et7.getText().toString().equals("#00ffff")) {
                        mspeak.speak(" light blue", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et7.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    if(et7.getText().toString().equals("#faa349")) {
                        mspeak.speak(" Orange", TextToSpeech.QUEUE_FLUSH, null);
                        Intent returnIntent = new Intent();
                        String selected =et7.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                    else{
                        Intent returnIntent = new Intent();
                        String selected =et7.getText().toString().substring(1);
                        returnIntent.putExtra("SELECTED",selected);
                        setResult(RESULT_OK,returnIntent);
                        finish();
                    }
                }
            }
        });

    }


    @Override
    public void onBackPressed(){
        finish();
    }
}
