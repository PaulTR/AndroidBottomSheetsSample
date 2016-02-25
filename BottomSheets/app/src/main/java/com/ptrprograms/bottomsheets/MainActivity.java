package com.ptrprograms.bottomsheets;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View mBottomSheet;
    private BottomSheetBehavior mBottomSheetBehavior;

    private FloatingActionButton mFloatingActionButton;

    private CardView mCardView1;
    private CardView mCardView2;
    private CardView mCardView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        mBottomSheetBehavior = BottomSheetBehavior.from(mBottomSheet);
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                Log.e("Bottom Sheet", "onStateChanged");
                if( newState == BottomSheetBehavior.STATE_COLLAPSED ) {
                    mBottomSheetBehavior.setPeekHeight(0);
                    mFloatingActionButton.setVisibility( View.VISIBLE );
                } else if( newState == BottomSheetBehavior.STATE_EXPANDED ) {
                    mFloatingActionButton.setVisibility( View.GONE );
                }
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {
                Log.e("Bottom Sheet", "onSlide");
            }
        });

    }

    private void initViews() {
        mFloatingActionButton = (FloatingActionButton) findViewById( R.id.fab );
        mBottomSheet = findViewById( R.id.bottom_sheet );
        mCardView1 = (CardView) findViewById( R.id.card_1 );
        mCardView2 = (CardView) findViewById( R.id.card_2 );
        mCardView3 = (CardView) findViewById( R.id.card_3 );

        mCardView1.setOnClickListener(this);
        mCardView2.setOnClickListener(this);
        mCardView3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch( v.getId() ) {
            case R.id.card_1: {
                mBottomSheet.setBackgroundColor( getColor(android.R.color.holo_green_dark));
                break;
            }
            case R.id.card_2: {
                mBottomSheet.setBackgroundColor( getColor(android.R.color.holo_blue_dark) );
                break;
            }
            case R.id.card_3: {
                mBottomSheet.setBackgroundColor( getColor(android.R.color.holo_red_dark) );
                break;
            }

        }
        mBottomSheetBehavior.setPeekHeight(300);
        mBottomSheetBehavior.setState( BottomSheetBehavior.STATE_COLLAPSED);
    }
}
