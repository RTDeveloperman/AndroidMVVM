package ir.mvvm.view;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mindorks.editdrawabletext.DrawablePosition;
import com.mindorks.editdrawabletext.EditDrawableText;
import com.mindorks.editdrawabletext.OnDrawableClickListener;

import ir.mvvm.Global.BaseActivity;
import ir.mvvm.Global.SetFont;
import ir.mvvm.R;
import ir.mvvm.databinding.LoginPageBinding;

import static ir.mvvm.Global.Verifications.validatePhoneNumber;

public class LoginPage extends BaseActivity implements View.OnClickListener {
    private EditText edt_phonenumber;
    private TextView tv_timer;
    private EditDrawableText edt_verifycode;
    private int editTextWidth, buttonWidth, edt_phonenumber_Width;
    private ConstraintLayout main_layout;
    private Button btn_enter;
    int DURATION = 600;
    boolean timerisON = false;
    LoginPageBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //setLayoutView(R.layout.login_page);#when use Base Activity
        binding= DataBindingUtil.setContentView(this, R.layout.login_page);
        
        init();
        edt_verifycode.setDrawableClickListener(new OnDrawableClickListener() {
            @Override
            public void onClick(DrawablePosition drawablePosition) {
                switch (drawablePosition) {
                    case RIGHT:
                    case LEFT:
                    case TOP:
                    case BOTTOM:
                        CkeckSMSCode();
                }
            }
        });
        final ViewGroup transitionsContainer = (ViewGroup) findViewById(R.id.transitions_container);
        findViewById(R.id.transitions_container).post(new Runnable() {
            @Override
            public void run() {
                editTextWidth = edt_verifycode.getWidth();
                edt_phonenumber_Width = edt_phonenumber.getWidth();
                // `mItemInputEditText` should be left visible from XML in order to get measured
                // setting to GONE after we have got actual width
                edt_verifycode.setVisibility(View.GONE);
                buttonWidth = btn_enter.getWidth();
            }
        });
        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validatePhoneNumber(edt_phonenumber.getText().toString())) {


                    final int from = btn_enter.getWidth();
                    final int to = (int) (from * 1.2f); // increase by 20%
                    final LinearInterpolator interpolator = new LinearInterpolator();

                    ValueAnimator firstAnimator = ValueAnimator.ofInt(from, to);
                    firstAnimator.setTarget(btn_enter);
                    firstAnimator.setInterpolator(interpolator);
                    firstAnimator.setDuration(DURATION);

                    final ViewGroup.LayoutParams params = btn_enter.getLayoutParams();
                    firstAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            params.width = (Integer) animation.getAnimatedValue();
                            btn_enter.setAlpha(1 - animation.getAnimatedFraction());
                            btn_enter.requestLayout();
                        }
                    });

                    firstAnimator.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            // reset alpha channel
                            btn_enter.setAlpha(1.0f);
                            btn_enter.setVisibility(View.GONE);

                            edt_verifycode.setVisibility(View.VISIBLE);
                            edt_phonenumber.setEnabled(false);
                            tv_timer.setVisibility(View.VISIBLE);
                            Starttimer();
                            ValueAnimator secondAnimator = ValueAnimator.ofInt(to, edt_phonenumber_Width);
                            secondAnimator.setTarget(edt_phonenumber);
                            secondAnimator.setInterpolator(interpolator);
                            secondAnimator.setDuration(DURATION);

                            final ViewGroup.LayoutParams params = edt_verifycode.getLayoutParams();
                            secondAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                @Override
                                public void onAnimationUpdate(ValueAnimator animation) {
                                    params.width = (Integer) animation.getAnimatedValue();
                                    edt_verifycode.requestLayout();
                                }
                            });

                            secondAnimator.start();
                        }
                    });

                    firstAnimator.start();
                } else {
                    Toast.makeText(LoginPage.this,getString(R.string.phone_number_wrong), Toast.LENGTH_SHORT).show();
                }

            }
        });

        edt_verifycode.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!timerisON) {
                    final int from = edt_verifycode.getWidth();
                    final int to = (int) (from * 0.8f);
                    final LinearInterpolator interpolator = new LinearInterpolator();

                    ValueAnimator firstAnimator = ValueAnimator.ofInt(from, to);
                    firstAnimator.setTarget(edt_verifycode);
                    firstAnimator.setInterpolator(interpolator);
                    firstAnimator.setDuration(DURATION);

                    final ViewGroup.LayoutParams params = edt_verifycode.getLayoutParams();
                    firstAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            params.width = (Integer) animation.getAnimatedValue();
                            edt_verifycode.requestLayout();
                        }
                    });

                    firstAnimator.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            edt_verifycode.setVisibility(View.GONE);
                            btn_enter.setVisibility(View.VISIBLE);
                            edt_phonenumber.setEnabled(true);
                            tv_timer.setVisibility(View.GONE);
                            ValueAnimator secondAnimator = ValueAnimator.ofInt(to, buttonWidth);
                            secondAnimator.setTarget(btn_enter);
                            secondAnimator.setInterpolator(interpolator);
                            secondAnimator.setDuration(DURATION);

                            final ViewGroup.LayoutParams params = btn_enter.getLayoutParams();
                            secondAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                @Override
                                public void onAnimationUpdate(ValueAnimator animation) {
                                    params.width = (Integer) animation.getAnimatedValue();
                                    btn_enter.setAlpha(animation.getAnimatedFraction());
                                    btn_enter.requestLayout();
                                }
                            });

                            secondAnimator.addListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationStart(Animator animation) {
                                    btn_enter.setAlpha(0.0f);
                                }
                            });

                            secondAnimator.start();
                        }
                    });

                    firstAnimator.start();
                }
            }
        });


    }


    private void Starttimer() {
        timerisON = true;
        final int time = 120000;
        final long[] MillisecondTime = new long[1];
        long TimeBuff = 0;
        final long[] UpdateTime = {0L};
        final int[] Seconds = new int[1];
        final int[] Minutes = new int[1];
        final int[] MilliSeconds = new int[1];
        new CountDownTimer(time, 1000) {

            public void onTick(long millisUntilFinished) {
                MillisecondTime[0] = millisUntilFinished;

                UpdateTime[0] = TimeBuff + MillisecondTime[0];

                Seconds[0] = (int) (UpdateTime[0] / 1000);

                Minutes[0] = Seconds[0] / 60;

                Seconds[0] = Seconds[0] % 60;

                MilliSeconds[0] = (int) (UpdateTime[0] % 1000);

                tv_timer.setText("0" + Minutes[0] + ":"
                        + String.format("%02d", Seconds[0]));
            }

            public void onFinish() {
                timerisON = false;
                tv_timer.setText("درخواست ارسال مجدد.");
            }

        }.start();
    }

    private void init() {
        tv_timer = (TextView) findViewById(R.id.tv_timer);
        edt_phonenumber = (EditText) findViewById(R.id.et_phonenumber);
        main_layout = (ConstraintLayout) findViewById(R.id.main_layout);
        edt_verifycode = (EditDrawableText) findViewById(R.id.et_verifycode);
        btn_enter = (Button) findViewById(R.id.btn_enter);
        SetFont setFont = new SetFont();
        setFont.overrideFonts(this, main_layout);
    }

    private void CkeckSMSCode() {
        Toast.makeText(LoginPage.this, "Cheking...", Toast.LENGTH_SHORT).show();

    }

    public String checkDigit(int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_enter:
            case R.id.tv_timer:
            case R.id.et_phonenumber:
        }
    }
}