package com.shashank.calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.TypedValue;
//import android.view.View;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnRem;
    EditText etCalc;
    TextView tvCalc;
    Vibrator vibe;
    boolean dot, div, sub, add, mul, pow, fact, equal, per, sqrt; //defining operators as booleans to know which one is in use
    final int Milliseconds = 1, MillisecondsLong = 5; //setting milliseconds for how long vibration can take place

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnRem = findViewById(R.id.btnRem);
        etCalc = findViewById(R.id.etCalc);
        tvCalc = findViewById(R.id.tvCalc);
        vibe = (Vibrator) getSystemService(MainActivity.VIBRATOR_SERVICE);
        //Get rid of ActionBar
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
        btn0.setOnClickListener(v -> {
            vibe.vibrate(Milliseconds);
            etSize();
            // here !equal means that equals buttons is pressed or not if not pressed we can continue to add number
            // and if equal is true so it erases all past text on EditText and print the button that you clicked on
            if (!equal) {
                etCalc.setText(etCalc.getText() + "0");
                setFalse();
            } else {
                etCalc.setText("0");
                equal = false;
                etCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
            }
        });
        btn1.setOnClickListener(v -> {
            vibe.vibrate(Milliseconds);
            etSize();
            if (!equal) {
                etCalc.setText(etCalc.getText() + "1");
                setFalse();
            } else {
                etCalc.setText("1");
                etCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                equal = false;
            }
        });
        btn2.setOnClickListener(v -> {
            vibe.vibrate(Milliseconds);
            etSize();
            if (!equal) {
                etCalc.setText(etCalc.getText() + "2");
                setFalse();
            } else {
                etCalc.setText("2");
                etCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                equal = false;

            }
        });
        btn3.setOnClickListener(v -> {
            vibe.vibrate(Milliseconds);
            etSize();
            if (!equal) {
                etCalc.setText(etCalc.getText() + "3");
                setFalse();
            } else {
                etCalc.setText("3");
                etCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                equal = false;
            }
        });
        btn4.setOnClickListener(v -> {
            vibe.vibrate(Milliseconds);
            etSize();
            if (!equal) {
                etCalc.setText(etCalc.getText() + "4");
                setFalse();
            } else {
                etCalc.setText("4");
                etCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                equal = false;
            }
        });
        btn5.setOnClickListener(v -> {
            vibe.vibrate(Milliseconds);
            etSize();
            if (!equal) {
                etCalc.setText(etCalc.getText() + "5");
                setFalse();
            } else {
                etCalc.setText("5");
                etCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                equal = false;
            }
        });
        btn6.setOnClickListener(v -> {
            vibe.vibrate(Milliseconds);
            etSize();
            if (!equal) {
                etCalc.setText(etCalc.getText() + "6");
                setFalse();
            } else {
                etCalc.setText("6");
                etCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                equal = false;
            }
        });
        btn7.setOnClickListener(v -> {
            vibe.vibrate(Milliseconds);
            etSize();
            if (!equal) {
                etCalc.setText(etCalc.getText() + "7");
                setFalse();
            } else {
                etCalc.setText("7");
                etCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                equal = false;
            }
        });
        btn8.setOnClickListener(v -> {
            vibe.vibrate(Milliseconds);
            etSize();
            if (!equal) {
                etCalc.setText(etCalc.getText() + "8");
                setFalse();
            } else {
                etCalc.setText("8");
                etCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                equal = false;
            }
        });
        btn9.setOnClickListener(v -> {
            vibe.vibrate(Milliseconds);
            etSize();
            if (!equal) {
                etCalc.setText(etCalc.getText() + "9");
                setFalse();
            } else {
                etCalc.setText("9");
                etCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                equal = false;
            }
        });
        //when button remove is long pressed it sets all fields to null and set btnRem text to "←"
        btnRem.setOnLongClickListener(v -> {
            vibe.vibrate(MillisecondsLong);
            etCalc.setText("");
            tvCalc.setText("");
            btnRem.setText("←");
            tvCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 55);
            etCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
            btnRem.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            //setFalse method changes all boolean function value to false so whenever anyone long presses Remove button all
            //button are now enabled to use.
            setFalse();
            equal = false;
            dot = false;
            return true;
        });
        //whenever anyone long click to EditText field it copies the out put to clipboard
        etCalc.setOnLongClickListener(v -> {
            copy();
            return true;
        });
    }

    @SuppressLint("SetTextI18n")
    public void buttonDot(View view) {
        etSize();
        String Calc = etCalc.getText().toString();
        vibe.vibrate(Milliseconds);
        //if any of these conditions are true it simply prints 0. in EditText i.e:3- [button dot clicked] = 3-0.
        // and it sets dot value to true so dot can not be printed again in EditText
        if (etCalc.getText().length() == 0 || Calc.equals("-") || Calc.endsWith("-") || Calc.endsWith("^")
                || Calc.endsWith("×") || Calc.endsWith("÷") || Calc.endsWith("+")) {
            etCalc.setText(etCalc.getText() + "0.");
            dot = true;
        }
        //splitting entered numbers to add dot at the end of the number
        // and any type of splitting is not available it just adds dot at the end
        if (!dot) {
            if (Calc.split("\\+").length == 2) {
                String[] Dot = Calc.split("\\+");
                Dot[1] = Dot[1] + ".";
                etCalc.setText(Dot[0] + "+" + Dot[1]);
            } else if (Calc.split("×").length == 2) {
                String[] Dot = Calc.split("×");
                Dot[1] = Dot[1] + ".";
                etCalc.setText(Dot[0] + "×" + Dot[1]);
            } else if (Calc.split("÷").length == 2) {
                String[] Dot = Calc.split("÷");
                Dot[1] = Dot[1] + ".";
                etCalc.setText(Dot[0] + "÷" + Dot[1]);
            } else if (Calc.split("\\^").length == 2) {
                String[] Dot = Calc.split("\\^");
                Dot[1] = Dot[1] + ".";
                etCalc.setText(Dot[0] + "^" + Dot[1]);
            } else if (Calc.split("-").length > 1) {
                String[] Dot = Calc.split("-");
                if (Dot.length == 2) {
                    Dot[1] = Dot[1] + ".";
                    etCalc.setText(Dot[0] + "-" + Dot[1]);
                } else if (Dot.length == 3) {
                    Dot[2] = Dot[2] + ".";
                    Dot[1] = "-" + Dot[1];
                    etCalc.setText(Dot[1] + "-" + Dot[2]);
                }
            } else {
                etCalc.setText(etCalc.getText() + ".");
            }
        }
        dot = true;
        equal = false;
        //setting equals as false because if you want to continue your calculation after pressing equal button.
        //if equal = true; when you press dot after pressing equal button EditText field resets.
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void buttonRem(View view) {
        vibe.vibrate(Milliseconds);
        if (etCalc.getText().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter Number(s)", Toast.LENGTH_SHORT).show();
        } else {
            if (!equal) {
                /*
                here from String mistake, creating substring of minus one char and setting that text to EditText
                and setting all values to false
                 */
                String mistake = etCalc.getText().toString();
                String newNum = mistake.substring(0, mistake.length() - 1);
                etCalc.setText(newNum);
                setFalse();
                /*
                if String newNum reaches end it sets all to default
                set all values to false
                 */
                if (newNum.equals("")) {
                    tvCalc.setText("");
                    tvCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 55);
                    etCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                    setFalse();
                    equal = false;
                }
                //if mistake string is ending with dot means dot is removed from string so setting dot value to false, making it again usable
                if (mistake.endsWith(".")) {
                    dot = false;
                }
                /*
                if equal is true it sets all value to default on one click
                and it also changes button text to "←"
                 */
            } else {
                etCalc.setText("");
                tvCalc.setText("");
                tvCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 55);
                etCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                btnRem.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                btnRem.setText("←");
                setFalse();
            }
        }
    }

    public void buttonFact(View view) {
        vibe.vibrate(Milliseconds);
        //if fact is false so it again checks whether EditText field is empty or not if not it continues computation
        if (!fact) {
            if (etCalc.getText().length() != 0) {
                FactSolve();
            }
        }
    }

    @SuppressLint("SetTextI18n")
    public void buttonAdd(View view) {
        vibe.vibrate(Milliseconds);
        String Calc = etCalc.getText().toString();
        //checking if string already contains any of the sign, if yes so checking this sign to true so it can not be usable by user
        if ((Calc.contains("÷") && Calc.endsWith("-")) || (Calc.contains("×") && Calc.endsWith("-")) || (Calc.contains("^") && Calc.endsWith("-")) || Calc.equals("-")) {
            add = true;
        } else if (Calc.endsWith("^") || Calc.endsWith("-") || Calc.endsWith("÷") || Calc.endsWith("×")) {
            etCalc.setText(Calc.substring(0, Calc.length() - 1) + "+");
            Equals();
            //if string is ending with any of the sign and user presses this sign button it changes to last button user presses
            //so app will be convenient to use
        } else if (!add) {
            if (etCalc.getText().length() == 0) {
                etCalc.setText("");
            } else {
                Equals();
                etCalc.setText(etCalc.getText() + "+");
            }
            //setting equal to false because if anyone wants to continue their calculation after pressing equal button
            //setting dot = false because if anyone presses any sign after decimal value it stops them to use another sign
            // i.e: 5.3-3 now you cannot print dot after 3.
            add = true;
            dot = false;
            equal = false;
            btnRem.setText("←");
            btnRem.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        }
    }

    @SuppressLint("SetTextI18n")
    public void buttonSub(View view) {
        vibe.vibrate(Milliseconds);
        String Calc = etCalc.getText().toString();
        if ((Calc.contains("÷") && Calc.endsWith("-")) || (Calc.contains("×") && Calc.endsWith("-")) || (Calc.contains("^") && Calc.endsWith("-"))) {
            sub = true;
        } else if (Calc.endsWith("+")) {
            etCalc.setText(Calc.substring(0, Calc.length() - 1) + "-");
        } else if (Calc.length() == 0 || Calc.equals("-")) {
            etCalc.setText("-");
        } else if (!sub) {
            Equals();
            etCalc.setText(etCalc.getText() + "-");
            dot = false;
            btnRem.setText("←");
            btnRem.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        }
        sub = true;
        equal = false;
    }

    @SuppressLint("SetTextI18n")
    public void buttonMul(View view) {
        vibe.vibrate(Milliseconds);
        String Calc = etCalc.getText().toString();
        if ((Calc.contains("÷") && Calc.endsWith("-")) || (Calc.contains("×") && Calc.endsWith("-")) || (Calc.contains("^") && Calc.endsWith("-")) || Calc.equals("-")) {
            mul = true;
        } else if (Calc.endsWith("+") || Calc.endsWith("-") || Calc.endsWith("÷") || Calc.endsWith("^")) {
            etCalc.setText(Calc.substring(0, Calc.length() - 1) + "×");
        } else if (Calc.endsWith("×")) {
            mul = true;
        } else if (!mul) {
            if (etCalc.getText().length() == 0) {
                etCalc.setText("");
            } else {
                Equals();
                etCalc.setText(etCalc.getText() + "×");
            }
            btnRem.setText("←");
            btnRem.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        }
        //setting sub = false because 3×-1 is possible
        mul = true;
        sub = false;
        dot = false;
        equal = false;
    }

    @SuppressLint("SetTextI18n")
    public void buttonDiv(View view) {
        vibe.vibrate(Milliseconds);
        String Calc = etCalc.getText().toString();
        if ((Calc.contains("÷") && Calc.endsWith("-")) || (Calc.contains("×") && Calc.endsWith("-")) || (Calc.contains("^") && Calc.endsWith("-")) || Calc.equals("-")) {
            div = true;
        } else if (Calc.endsWith("+") || Calc.endsWith("-") || Calc.endsWith("^") || Calc.endsWith("×")) {
            etCalc.setText(Calc.substring(0, Calc.length() - 1) + "÷");
        } else if (Calc.endsWith("÷")) {
            div = true;
        } else if (!div) {
            if (etCalc.getText().length() == 0) {
                etCalc.setText("");
            } else {
                Equals();
                etCalc.setText(etCalc.getText() + "÷");
            }
            btnRem.setText("←");
            btnRem.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        }
        div = true;
        sub = false;
        dot = false;
        equal = false;
    }

    @SuppressLint("SetTextI18n")
    public void buttonPow(View view) {
        vibe.vibrate(Milliseconds);
        String Calc = etCalc.getText().toString();
        if ((Calc.contains("÷") && Calc.endsWith("-")) || (Calc.contains("×") && Calc.endsWith("-"))
                || (Calc.contains("^") && Calc.endsWith("-")) || Calc.equals("-")) {
            pow = true;
        } else if (Calc.endsWith("+") || Calc.endsWith("-") || Calc.endsWith("÷") || Calc.endsWith("×")) {
            etCalc.setText(Calc.substring(0, Calc.length() - 1) + "^");
        } else if (Calc.endsWith("^")) {
            pow = true;
        } else if (!pow) {
            if (etCalc.getText().length() == 0) {
                etCalc.setText("");
            } else {
                Equals();
                etCalc.setText(etCalc.getText() + "^");
            }
            btnRem.setText("←");
            btnRem.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        }
        pow = true;
        sub = false;
        dot = false;
        equal = false;
    }

    public void buttonEqual(View view) {
        vibe.vibrate(Milliseconds);
        String calc = etCalc.getText().toString();
        if (!calc.endsWith("-") && !calc.endsWith("+") && !calc.endsWith("×") && !calc.endsWith("÷") && !calc.endsWith("^") && !calc.endsWith(".") && !calc.equals("")) {
            dot = false;
            equal = true;
            Equals();
            btnRem.setText("C");
            btnRem.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
        }
    }

    private void copy() {
        vibe.vibrate(MillisecondsLong);
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("CalcData", etCalc.getText().toString());
        clipboard.setPrimaryClip(clip);
        Toast.makeText(MainActivity.this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("SetTextI18n")
    public void buttonPer(View view) {
        vibe.vibrate(Milliseconds);
        String Calc = etCalc.getText().toString();
        try {
            //if string ends with minus, setting sub value to false so it does not goes to next else if statement and Toast appears.
            if (Calc.endsWith("-")) {
                per = false;
            } else if (Calc.split("\\+").length == 2 || Calc.split("×").length == 2
                    || Calc.split("÷").length == 2 || Calc.split("-").length >= 2
                    || Calc.split("\\^").length == 2) {
                etCalc.setText(etCalc.getText() + "%");
                Equals();
                per = true;
                equal = true;
                btnRem.setText("C");
                btnRem.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                etSize();
            }
            if (!per) {
                if (etCalc.getText().length() != 0 && !etCalc.getText().toString().equals("0")) {
                    etCalc.setText("" + Double.parseDouble(Calc) / 100);
                    tvCalc.setText(Calc + "%");
                    btnRem.setText("C");
                    btnRem.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                    etSize();
                    tvSize();
                    per = true;
                    equal = true;
                }
            }
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Bad expression", Toast.LENGTH_SHORT).show();
            setFalse();
        }
    }

    @SuppressLint("SetTextI18n")
    public void buttonSqrt(View view) {
        vibe.vibrate(Milliseconds);
        String Calc = etCalc.getText().toString();
        try {
            if (Calc.split("\\+").length == 2 || Calc.split("×").length == 2
                    || Calc.split("÷").length == 2 || Calc.split("-").length >= 2
                    || Calc.split("\\^").length == 2) {
                Equals();
                tvCalc.setText("√" + Calc);
                String square = etCalc.getText().toString();
                double root = Double.parseDouble(square);
                etCalc.setText(String.valueOf(Math.sqrt(root)));
                sqrt = true;
                equal = true;
                btnRem.setText("C");
                btnRem.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                etSize();
            }
            if (!sqrt) {
                if (etCalc.getText().length() != 0 && !etCalc.getText().toString().equals("0")) {
                    double root = Double.parseDouble(Calc);
                    etCalc.setText(String.valueOf(Math.sqrt(root)));
                    tvCalc.setText("√" + Calc);
                    btnRem.setText("C");
                    btnRem.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                    etSize();
                    tvSize();
                    sqrt = true;
                    equal = true;
                }
            }
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Bad expression", Toast.LENGTH_SHORT).show();
            setFalse();
        }
        SimpleAnswer();
    }

    @SuppressLint("SetTextI18n")
    public void Equals() {
        String calc = etCalc.getText().toString();
        if (calc.split("\\+").length == 2) {
            String[] calculation = calc.split("\\+");
            if (calculation[1].endsWith("%")) {
                String ans = calculation[1].substring(0, calculation[1].length() - 1);
                calculation[1] = String.valueOf((Double.parseDouble(calculation[0]) * Double.parseDouble(ans)) / 100);
            }
            etCalc.setText(String.valueOf(Double.parseDouble(calculation[0]) + Double.parseDouble(calculation[1])));
            tvCalc.setText(calc);
        } else if (calc.split("×").length == 2) {
            String[] calculation = calc.split("×");
            if (calculation[1].endsWith("%")) {
                String ans = calculation[1].substring(0, calculation[1].length() - 1);
                calculation[1] = String.valueOf(Double.parseDouble(ans) / 100);
            }
            etCalc.setText(String.valueOf(Double.parseDouble(calculation[0]) * Double.parseDouble(calculation[1])));
            tvCalc.setText(calc);
        } else if (calc.split("÷").length == 2) {
            String[] calculation = calc.split("÷");
            if (calculation[1].endsWith("%")) {
                String ans = calculation[1].substring(0, calculation[1].length() - 1);
                calculation[1] = String.valueOf(Double.parseDouble(ans) / 100);
            }
            etCalc.setText(String.valueOf(Double.parseDouble(calculation[0]) / Double.parseDouble(calculation[1])));
            tvCalc.setText(calc);
        } else if (calc.split("\\^").length == 2) {
            String[] calculation = calc.split("\\^");
            if (calculation[1].endsWith("%")) {
                String ans = calculation[1].substring(0, calculation[1].length() - 1);
                calculation[1] = String.valueOf(Double.parseDouble(ans) / 100);
            }
            etCalc.setText(String.valueOf(Math.pow(Double.parseDouble(calculation[0]), Double.parseDouble(calculation[1]))));
            tvCalc.setText(calc);
        } else if (calc.split("-").length > 1) {
            String[] calculation = calc.split("-");
            if (calculation[0].equals("") && calculation.length == 2) {
                calculation[0] = "0";
                if (calculation[1].endsWith("%")) {
                    String ans = calculation[1].substring(0, calculation[1].length() - 1);
                    etCalc.setText("" + (Double.parseDouble(ans) / 100));
                    tvCalc.setText(calc);
                }
            } else if (calculation.length == 2) {
                if (calculation[1].endsWith("%")) {
                    String ans = calculation[1].substring(0, calculation[1].length() - 1);
                    calculation[1] = String.valueOf((Double.parseDouble(calculation[0]) * Double.parseDouble(ans)) / 100);
                }
                etCalc.setText(String.valueOf(Double.parseDouble(calculation[0]) - Double.parseDouble(calculation[1])));
                tvCalc.setText(calc);
            } else if (calculation.length == 3) {
                calculation = calc.split("-");
                if (calculation[2].endsWith("%")) {
                    String ans = calculation[2].substring(0, calculation[2].length() - 1);
                    calculation[2] = String.valueOf((Double.parseDouble(calculation[1]) * Double.parseDouble(ans)) / 100);
                    calculation[1] = "-" + calculation[1];
                }
                etCalc.setText(String.valueOf(-Double.parseDouble(calculation[1]) - Double.parseDouble(calculation[2])));
                tvCalc.setText(calc);
            }
        }
        tvSize();
        etSize();
        SimpleAnswer();
    }

    /*
    here if ans is in decimal and decimal value is 0 so it prints it without 0 i.e: 3.0 prints as 3
    and if decimal value is other than 0 so it sets dot to true so no one can add dot at the end of the answer
     */
    @SuppressLint("SetTextI18n")
    private void SimpleAnswer() {
        String Ans = etCalc.getText().toString();
        String[] Answer = Ans.split("\\.");
        if (Answer.length > 1) {
            if (Answer[1].equals("0")) {
                etCalc.setText(Answer[0]);
            } else {
                dot = true;
            }
            if (Answer[1].length() > 10) {
                if (Answer[1].contains("E")) {
                    etCalc.setText(Answer[0] + "." + Answer[1]);
                    etCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                } else {
                    Answer[1] = Answer[1].substring(0, 10);
                    etCalc.setText(Answer[0] + "." + Answer[1]);
                    etCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    public void FactSolve() {
        long r = 1;
        String calc = etCalc.getText().toString();
        try {
            if (Integer.parseInt(calc) <= 25) {
                for (long i = 1; i <= Double.parseDouble(etCalc.getText().toString()); i++) {
                    r *= i;
                }
                etCalc.setText(r + "");
                tvCalc.setText(calc + "!");
            } else {
                Toast.makeText(MainActivity.this, "Too Big!!", Toast.LENGTH_SHORT).show();
            }
            etSize();
            equal = true;
            btnRem.setText("C");
            btnRem.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Not Possible", Toast.LENGTH_SHORT).show();
            if (calc.length() > 5) {
                btnRem.setText("C");
                btnRem.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                equal = true;
            }
        }
    }

    //it changes size of text as length increases.
    public void etSize() {
        if (etCalc.getText().length() > 18) {
            etCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        } else if (etCalc.getText().length() > 15) {
            etCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        } else if (etCalc.getText().length() > 11) {
            etCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
        } else if (etCalc.getText().length() > 1) {
            etCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
        }
    }

    public void tvSize() {
        if (tvCalc.getText().length() > 19) {
            tvCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        } else if (tvCalc.getText().length() > 14) {
            tvCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        } else if (tvCalc.getText().length() > 12) {
            tvCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
        } else if (tvCalc.getText().length() > 8) {
            tvCalc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
        }
    }

    private void setFalse() {
        add = false;
        div = false;
        sub = false;
        mul = false;
        pow = false;
        per = false;
        fact = false;
        sqrt = false;
    }
}
