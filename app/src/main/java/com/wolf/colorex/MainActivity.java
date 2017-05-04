package com.wolf.colorex;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Locale;

import static android.graphics.Color.parseColor;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private ClipboardManager myClipboard;
    private ClipData myClip;
    Button r, b;
    TextToSpeech mspeak;
    EditText eT1,eT2;
    RelativeLayout ll;
    ImageView fB,hex,buck,options,palatte;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    private final int COlOR_SELECTED = 200;
    TextView intro;
    public String axe,baxe,repeated,finale;
    public static int[] getRGB(final String rgb)
    {
        final int[] ret = new int[3];
        for (int i = 0; i < 3; i++)
        {
            ret[i] = Integer.parseInt(rgb.substring(i * 2, i * 2 + 2), 16);
        }
        return ret;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ll = (RelativeLayout) findViewById(R.id.activity_main);
        eT1 =(EditText) findViewById(R.id.editText);
        eT2 =(EditText) findViewById(R.id.editText2);
        fB = (ImageView) findViewById(R.id.imageView);
        hex =(ImageView) findViewById(R.id.imageView2);
        buck=(ImageView) findViewById(R.id.buck);
        intro=(TextView) findViewById(R.id.intro);
        options=(ImageView) findViewById(R.id.options);
        myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        palatte =(ImageView) findViewById(R.id.palatte);

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
        eT1.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            MainActivity.this.updateValue();
        }

        @Override
        public void afterTextChanged(Editable s) {
            int lenCheck= eT2.length();
            if(eT1.length()==0&&eT2.length()>8)
            {
                eT2.setText("");
                eT1.setTextColor(Color.WHITE);
                eT2.setTextColor(Color.WHITE);
                ll.setBackgroundColor(0xFF2979FF);
                buck.setImageResource(R.drawable.fc2);
                hex.setImageResource(R.drawable.htwhite);
                intro.setTextColor(0xeeffffff);
                fB.setImageResource(R.drawable.fb1);
                palatte.setImageResource(R.drawable.pp1);
                options.setImageResource(R.drawable.menu2);
            }
            if(eT1.length()==4&&eT2.length()>8||eT1.length()==2&&eT2.length()>8||eT1.length()==5&&eT2.length()>8) {
                eT2.setText("");
                ll.setBackgroundColor(0xFF2979FF);
                eT1.setTextColor(Color.WHITE);
                eT2.setTextColor(Color.WHITE);
                buck.setImageResource(R.drawable.fc2);
                hex.setImageResource(R.drawable.htwhite);
                intro.setTextColor(0xeeffffff);
                fB.setImageResource(R.drawable.fb1);
                palatte.setImageResource(R.drawable.pp1);
                options.setImageResource(R.drawable.menu2);
            }
        }
    });


        fB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eT1.setText("");
                eT2.setText("");
                promptSpeechInput();

            }
        });

        palatte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  startActivity(new Intent(MainActivity.this, saved.class));
                Intent intent=new Intent(MainActivity.this,saved.class);
                startActivityForResult(intent, COlOR_SELECTED);

            }
        });

    }




    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    if(result.get(0).equals("blue")) {

                        eT1.setText("0000ff");
                    }
                    if(result.get(0).equals("red")) {

                        eT1.setText("ff0000");
                    }
                    if(result.get(0).equals("green")) {

                        eT1.setText("00ff00");
                    }
                    if(result.get(0).equals("white")) {

                        eT1.setText("ffffff");
                    }
                    if(result.get(0).equals("black")) {

                        eT1.setText("000000");
                    }
                    if(result.get(0).equals("orange")) {

                        eT1.setText("faa349");
                    }
                    if(result.get(0).equals("dark blue")) {

                        eT1.setText("000077");
                    }
                    if(result.get(0).equals("yellow")) {

                        eT1.setText("ffeb3b");
                    if(result.get(0).equals("grey")) {

                            eT1.setText("eaeaea");
                        }
                    } if(result.get(0).equals("grey")) {

                        eT1.setText("9e9e9e");
                    } if(result.get(0).equals("brown")) {

                        eT1.setText("795548");
                    } if(result.get(0).equals("light blue")) {

                        eT1.setText("00ffff");
                    } if(result.get(0).equals("pink")) {

                        eT1.setText("e91e63");
                    }
                    if(result.get(0).equals("developer")) {

                        mspeak.speak("I was developed by Shubham0812",TextToSpeech.QUEUE_FLUSH,null);
                    }
                    if(result.get(0).equals("clear")){
                        SharedPreferences preferences = getSharedPreferences("Saved", 0);
                        preferences.edit().remove("Color").apply();
                        preferences.edit().remove("Color1").apply();
                        preferences.edit().remove("Color2").apply();
                        preferences.edit().remove("Color3").apply();
                        preferences.edit().remove("Color4").apply();
                        preferences.edit().remove("Color5").apply();
                        preferences.edit().remove("Color6").apply();
                    }
                }
            }
            break;
            case COlOR_SELECTED: {
                if (resultCode == RESULT_OK && null != data) {

                        String color_selected =data.getStringExtra("SELECTED");
                        eT1.setText("");
                        eT1.setText(color_selected);
                        //mspeak.speak("I was developed by Shubham0812", TextToSpeech.QUEUE_FLUSH, null);

                }
            }
            break;
        }
    }





    private void updateValue(){
        axe = eT1.getText().toString();
        baxe = eT2.getText().toString();


        if(axe.length()==3 && baxe.length()==0) {
            repeated = new String(new char[2]).replace("\0", axe);
            int color = parseColor("#" + repeated);
            int decum[] = getRGB(repeated);
            if ((decum[0] * 0.299 + decum[1] * 0.587 + decum[2] * 0.114) > 186) {
                eT1.setTextColor(Color.BLACK);
                eT2.setTextColor(Color.BLACK);
                buck.setImageResource(R.drawable.fc1);
                hex.setImageResource(R.drawable.ht2);
                intro.setTextColor(0xee000000);
                fB.setImageResource(R.drawable.fb2);
                options.setImageResource(R.drawable.menu1);
                palatte.setImageResource(R.drawable.pp2);
            }
            ll.setBackgroundColor(color);
            Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            eT2.setText("rgb(" + decum[0] + "," + decum[1] + "," + decum[2] + ")");
        }

        if(axe.length()==6 && baxe.length()==0) {
            int color = parseColor("#" + axe);
            int decum[] = getRGB(axe);
            if((decum[0]*0.299+decum[1]*0.587+decum[2]*0.114)> 186)
            {
                eT1.setTextColor(Color.BLACK);
                eT2.setTextColor(Color.BLACK);
                buck.setImageResource(R.drawable.fc1);
                hex.setImageResource(R.drawable.ht2);
                intro.setTextColor(0xee000000);
                fB.setImageResource(R.drawable.fb2);
                options.setImageResource(R.drawable.menu1);
                palatte.setImageResource(R.drawable.pp2);
            }
            ll.setBackgroundColor(color);
            eT2.setText("rgb(" + decum[0] + "," + decum[1] + "," + decum[2] + ")");
        }}

    public void showMenu(View v) {
        PopupMenu popup = new PopupMenu(this, v);

        // This activity implements OnMenuItemClickListener
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.actions);
        popup.show();
    }
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.clear:
                eT1.setText("");
                eT2.setText("");
                return true;
            case R.id.copyhex:
                String text= eT1.toString();
                myClip = ClipData.newPlainText("text", text);
                Toast.makeText(getApplicationContext(), "Text Copied",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.save:
                 axe=eT1.getText().toString();

                if(axe.length()==0)
                {
                    baxe="2979FF";
                    SharedPreferences sharedPref = getSharedPreferences("Saved",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    if(sharedPref.contains("Color"))
                    {
                        if(sharedPref.contains("Color1"))
                        {
                            if(sharedPref.contains("Color2"))
                            {
                                if(sharedPref.contains("Color3"))
                                {
                                    if(sharedPref.contains("Color4"))
                                    {
                                        if(sharedPref.contains("Color5"))
                                        {
                                            editor.putString("Color6",baxe);
                                            editor.apply();
                                            Intent a=new Intent(MainActivity.this,saved.class);
                                            startActivity(a);
                                            return true;
                                        }
                                        editor.putString("Color5",baxe);
                                        editor.apply();
                                        Intent a=new Intent(MainActivity.this,saved.class);
                                        startActivity(a);
                                        return true;
                                    }
                                    editor.putString("Color4",baxe);
                                    editor.apply();
                                    Intent a=new Intent(MainActivity.this,saved.class);
                                    startActivity(a);
                                    return true;
                                }
                                editor.putString("Color3",baxe);
                                editor.apply();
                                Intent a=new Intent(MainActivity.this,saved.class);
                                startActivity(a);
                                return true;
                            }
                            editor.putString("Color2",baxe);
                            editor.apply();
                            Intent a=new Intent(MainActivity.this,saved.class);
                            startActivity(a);
                            return true;
                        }
                     editor.putString("Color1",baxe);
                        editor.apply();
                        Intent a=new Intent(MainActivity.this,saved.class);
                        startActivity(a);
                        return true;
                    }
                    editor.putString("Color",baxe);
                    editor.apply();
                    Intent a=new Intent(MainActivity.this,saved.class);
                    startActivity(a);
                    return  true;
                }
                if(axe.length()==3)
                {
                    baxe = new String(new char[2]).replace("\0", axe);
                    SharedPreferences sharedPref = getSharedPreferences("Saved",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    if(sharedPref.contains("Color"))
                    {
                        if(sharedPref.contains("Color1"))
                        {
                            if(sharedPref.contains("Color2"))
                            {
                                if(sharedPref.contains("Color3"))
                                {
                                    if(sharedPref.contains("Color4"))
                                    {
                                        if(sharedPref.contains("Color5"))
                                        {
                                            editor.putString("Color6",baxe);
                                            editor.apply();
                                            Intent a=new Intent(MainActivity.this,saved.class);
                                            startActivity(a);
                                            return true;
                                        }
                                        editor.putString("Color5",baxe);
                                        editor.apply();
                                        Intent a=new Intent(MainActivity.this,saved.class);
                                        startActivity(a);
                                        return true;
                                    }
                                    editor.putString("Color4",baxe);
                                    editor.apply();
                                    Intent a=new Intent(MainActivity.this,saved.class);
                                    startActivity(a);
                                    return true;
                                }
                                editor.putString("Color3",baxe);
                                editor.apply();
                                Intent a=new Intent(MainActivity.this,saved.class);
                                startActivity(a);
                                return true;
                            }
                            editor.putString("Color2",baxe);
                            editor.apply();
                            Intent a=new Intent(MainActivity.this,saved.class);
                            startActivity(a);
                            return true;
                        }
                        editor.putString("Color1",baxe);
                        editor.apply();
                        Intent a=new Intent(MainActivity.this,saved.class);
                        startActivity(a);
                        return true;
                    }
                    editor.putString("Color",baxe);
                    editor.apply();
                    Intent a=new Intent(MainActivity.this,saved.class);
                    startActivity(a);
                    return  true;
                }
                else {
                    SharedPreferences sharedPref = getSharedPreferences("Saved",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    if(sharedPref.contains("Color"))
                    {
                        if(sharedPref.contains("Color1"))
                        {
                            if(sharedPref.contains("Color2"))
                            {
                                if(sharedPref.contains("Color3"))
                                {
                                    if(sharedPref.contains("Color4"))
                                    {
                                        if(sharedPref.contains("Color5"))
                                        {
                                            editor.putString("Color6",axe);
                                            editor.apply();
                                            Intent a=new Intent(MainActivity.this,saved.class);
                                            startActivity(a);
                                            return true;
                                        }
                                        editor.putString("Color5",axe);
                                        editor.apply();
                                        Intent a=new Intent(MainActivity.this,saved.class);
                                        startActivity(a);
                                        return true;
                                    }
                                    editor.putString("Color4",axe);
                                    editor.apply();
                                    Intent a=new Intent(MainActivity.this,saved.class);
                                    startActivity(a);
                                    return true;
                                }
                                editor.putString("Color3",axe);
                                editor.apply();
                                Intent a=new Intent(MainActivity.this,saved.class);
                                startActivity(a);
                                return true;
                            }
                            editor.putString("Color2",axe);
                            editor.apply();
                            Intent a=new Intent(MainActivity.this,saved.class);
                            startActivity(a);
                            return true;
                        }
                        editor.putString("Color1",axe);
                        editor.apply();
                        Intent a=new Intent(MainActivity.this,saved.class);
                        startActivity(a);
                        return true;
                    }
                    editor.putString("Color",axe);
                    editor.apply();
                    Intent a=new Intent(MainActivity.this,saved.class);
                    startActivity(a);
                    return true;
                }
            case R.id.clearsaved: SharedPreferences preferences = getSharedPreferences("Saved", 0);
                                  preferences.edit().remove("Color").apply();
                                  preferences.edit().remove("Color1").apply();
                                  preferences.edit().remove("Color2").apply();
                                  preferences.edit().remove("Color3").apply();
                                  preferences.edit().remove("Color4").apply();
                                  preferences.edit().remove("Color5").apply();
                                  preferences.edit().remove("Color6").apply();
                                  return true;
            default:
                return false;
        }
    }

}

