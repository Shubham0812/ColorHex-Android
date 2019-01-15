# ColorHex
## ColorHex - Hex to RGB Color Converter

An android application which can convert the given Hexadecimal color value to RGB color value.

## Motivation
I made this android application to help me out with coding with different languages. This application also helps me keep my favorite colors saved so that I can refer it quickly. I find this app very convenient.

## Screenshots

![Home Screen](https://github.com/Shubham0812/ColorHex/blob/master/assets/screenshots/intro.png)

![Options Menu](https://github.com/Shubham0812/ColorHex/blob/master/assets/screenshots/options.png)

![Rgb values converted](https://github.com/Shubham0812/ColorHex/blob/master/assets/screenshots/blue_conver.png)

![black conversion](https://github.com/Shubham0812/ColorHex/blob/master/assets/screenshots/black_convert.png)

![Saved Colors](https://github.com/Shubham0812/ColorHex/blob/master/assets/screenshots/saved_colors.png)

![Color speech Recognizer](https://github.com/Shubham0812/ColorHex/blob/master/assets/screenshots/color_speaker.png)


## Technology used
 Java and Android Studio.

## Features
- Generates the rgb color based on the entered Hex value.
- The colors generated can be saved for later reference.
- Has a speech recognizer through which user can speak the name of the color. 
- Clean design and simplistic UI.
- Backwards compatability till Android 4.4 (Kitkat)


## Code Example
```
    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException e) {
			Toast.makeText(getApplicationContext(),
			getString(R.string.speech_not_supported),
			Toast.LENGTH_SHORT).show();
        }
    }
```

## How to use ?
1. Download or clone the repository.
2. Import the project through Android Studio.
3. Run the application in mobile or simulator running Android 4.4 and above (Kitkat)

## Credits
**©** Shubham Kumar Singh | 2018