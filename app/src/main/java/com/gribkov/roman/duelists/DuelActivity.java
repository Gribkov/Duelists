package com.gribkov.roman.duelists;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;


public class DuelActivity extends ActionBarActivity {
    private Button mButton;
    private Button mButtonBang;
    private Duelist mHero;  //Наш персонаж
    private Duelist mRival; //Наш противник
    private TextView mTextViewHeroBlock;
    private TextView mTextViewHeroKick;

    private Random mRandom = new Random(2);
    private ProgressBar mProgressHero;
    private ProgressBar mProgressRival;
    private ImageView mImageViewHero;
    private ImageView mImageViewRival;
    private Integer mHeroBlock = 0, mHeroKick = 0, mRivalBlock = 0, mRivalKick = 0 ;

    //Количество шагов героя
    private int mStepHero=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duel);
        //Создадим дуэлянтов
        mTextViewHeroBlock = (TextView) findViewById(R.id.textViewBlock);
        mTextViewHeroKick = (TextView) findViewById(R.id.textViewKick);
        mProgressHero = (ProgressBar) findViewById(R.id.progressBarHero);
        mProgressRival = (ProgressBar) findViewById(R.id.progressBarRival);
        mButtonBang = (Button)findViewById(R.id.buttonBang);

        mImageViewHero = (ImageView) findViewById(R.id.imageViewHero);
        mImageViewRival = (ImageView) findViewById(R.id.imageViewRival);

        mHero = new Duelist(50,5,1);
        mHero.setNameDuelst("Вы");
        mProgressHero.setMax(mHero.getHealth());
        mProgressHero.setProgress(mHero.getHealth());
        mRival = new Duelist(50,5,1);
        mRival.setNameDuelst("Противник");
        mProgressRival.setMax(mRival.getHealth());
        mProgressRival.setProgress(mRival.getHealth());
        mButtonBang.setEnabled(true);
        mStepHero = 2;

        //Схождение дуэлянтов

        mButtonBang.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Integer RK = 0, RS=0;
                RK = mRandom.nextInt(3)+1;
                RS = mRandom.nextInt(3)+1;
                //Log.i("RK=", RK.toString());
                //Log.i("RS=", RS.toString());
                mHero.getKick(RK,mHeroBlock, mRival.getStrength());
                if(RK==mHeroBlock) mImageViewHero.setImageResource(R.drawable.hero_hrsh);
                else mImageViewHero.setImageResource(R.drawable.hero_bam);
                mProgressHero.setProgress(mHero.getHealth());
                mRival.getKick(mHeroKick,RS, mHero.getStrength());
                if(RS==mHeroKick) mImageViewRival.setImageResource(R.drawable.rival_hrsh);
                else mImageViewRival.setImageResource(R.drawable.rival_bam);
                mProgressRival.setProgress(mRival.getHealth());
                if(mHero.isDuelistLive() != true) {
                    mButtonBang.setEnabled(false);
                    mImageViewHero.setImageResource(R.drawable.hero_lose);
                }
                if(mRival.isDuelistLive() != true) {
                    mButtonBang.setEnabled(false);
                    mImageViewRival.setImageResource(R.drawable.rival_lose);
                }
            }
        });

    }

    public void onRadioBlockClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioBlockHead:
                if (checked) {
                    mHeroBlock = 1;
                    mTextViewHeroBlock.setText("Защищаем голову ");
                }   break;
            case R.id.radioBlockBody:
                if (checked) {
                    mHeroBlock = 2;
                    mTextViewHeroBlock.setText("Защищаем торс ");
                }   break;
            case R.id.radioBlockLegs:
                if (checked) {
                    mHeroBlock = 3;
                    mTextViewHeroBlock.setText("Защищаем ноги ");
                }   break;
        }
    }
    public void onRadioKickClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioKickHead:
                if (checked) {
                    mHeroKick = 1;
                    mTextViewHeroKick.setText("Бьем в голову ");
                }   break;
            case R.id.radioKickBody:
                if (checked) {
                    mHeroKick = 2;
                    mTextViewHeroKick.setText("Бьем в торс ");
                }   break;
            case R.id.radioKickLegs:
                if (checked) {
                    mHeroKick = 3;
                    mTextViewHeroKick.setText("Бьем в ноги ");
                }   break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_duel, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
