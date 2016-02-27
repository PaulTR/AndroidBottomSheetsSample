package com.ptrprograms.bottomsheets;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View mBottomSheet;
    private BottomSheetBehavior mBottomSheetBehavior;

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e( "night", "Night mode: " + ((getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES ));

        initViews();

        mBottomSheetBehavior = BottomSheetBehavior.from(mBottomSheet);
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                Log.e("Bottom Sheet", "onStateChanged");
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    mBottomSheetBehavior.setPeekHeight(0);
                }
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {
                Log.e("Bottom Sheet", "onSlide");
            }
        });

    }

    private void initViews() {
        mBottomSheet = findViewById( R.id.bottom_sheet );
        mButton1 = (Button) findViewById( R.id.button_1 );
        mButton2 = (Button) findViewById( R.id.button_2 );
        mButton3 = (Button) findViewById( R.id.button_3 );

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch( v.getId() ) {
            case R.id.button_1: {
                showBottomSheetFromLayout( getResources().getColor(android.R.color.holo_green_dark) );
                break;
            }
            case R.id.button_2: {
                showBottomSheetFromLayout( getResources().getColor(android.R.color.holo_blue_dark) );
                break;
            }
            case R.id.button_3: {
                showBottomSheetFromLayout( getResources().getColor(android.R.color.holo_red_dark) );
                break;
            }
                //BottomSheetDialogFragment bottomSheetDialogFragment = new PTRBottomSheetDialogFragment();
                //bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
        }
    }

    private void showBottomSheetFromLayout( int color ) {
        mBottomSheet.setBackgroundColor( color );
        mBottomSheetBehavior.setPeekHeight(300);
        mBottomSheetBehavior.setState( BottomSheetBehavior.STATE_COLLAPSED);
    }
}
