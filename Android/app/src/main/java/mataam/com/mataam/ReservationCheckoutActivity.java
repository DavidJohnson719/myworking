package mataam.com.mataam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ReservationCheckoutActivity extends Activity implements View.OnClickListener{

    LinearLayout lvTop1, lvTop2, lvTop3,  lvBottom1, lvBottom2, lvBottom3;
    ImageView    imgTop1, imgTop2, imgTop3, imgBottom1, imgBottom2, imgBottom3;
    LinearLayout lvPlaceOrder;
    LinearLayout lvBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_checkout);

        lvTop1 = (LinearLayout) findViewById( R.id.reservation_top_ch1);  lvTop1.setOnClickListener( this );
        lvTop2 = (LinearLayout) findViewById( R.id.reservation_top_ch2 ); lvTop2.setOnClickListener( this );
        lvTop3 = (LinearLayout) findViewById( R.id.reservation_top_ch3 ); lvTop3.setOnClickListener( this );

        lvBottom1 = (LinearLayout) findViewById( R.id.reservation_bottom_ch1 ); lvBottom1.setOnClickListener( this );
        lvBottom2 = (LinearLayout) findViewById( R.id.reservation_bottom_ch2 ); lvBottom2.setOnClickListener( this );
        lvBottom3 = (LinearLayout) findViewById( R.id.reservation_bottom_ch3 ); lvBottom3.setOnClickListener( this );

        imgTop1 = (ImageView) findViewById( R.id.reservation_top_img1 );
        imgTop2 = (ImageView) findViewById( R.id.reservation_top_img2 );
        imgTop3 = (ImageView) findViewById( R.id.reservation_top_img3 );


        imgBottom1 = (ImageView) findViewById( R.id.reservation_bottom_img1 );
        imgBottom2 = (ImageView) findViewById( R.id.reservation_bottom_img2 );
        imgBottom3 = (ImageView) findViewById( R.id.reservation_bottom_img3 );


        imgTop1.setImageResource( R.drawable.check_green );
        imgTop2.setImageResource( R.drawable.check_no );
        imgTop3.setImageResource( R.drawable.check_no );



        imgBottom1.setImageResource( R.drawable.check_green );
        imgBottom2.setImageResource( R.drawable.check_no );
        imgBottom3.setImageResource( R.drawable.check_no);


        lvPlaceOrder = (LinearLayout) findViewById( R.id.reservation_checkout_place_order );
        lvPlaceOrder.setOnClickListener( this );

        lvBack = (LinearLayout) findViewById( R.id.checkout_back );
        lvBack.setOnClickListener( this );

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reservation_top_ch1:
            {
                imgTop1.setImageResource( R.drawable.check_green );
                imgTop2.setImageResource( R.drawable.check_no );
                imgTop3.setImageResource( R.drawable.check_no );
                break;
            }
            case R.id.reservation_top_ch2:
            {
                imgTop1.setImageResource( R.drawable.check_no );
                imgTop2.setImageResource( R.drawable.check_green );
                imgTop3.setImageResource( R.drawable.check_no );
                break;
            }
            case R.id.reservation_top_ch3:
            {
                imgTop1.setImageResource( R.drawable.check_no );
                imgTop2.setImageResource( R.drawable.check_no );
                imgTop3.setImageResource( R.drawable.check_green );
                break;
            }


            case R.id.reservation_bottom_ch1:{
                imgBottom1.setImageResource( R.drawable.check_green );
                imgBottom2.setImageResource( R.drawable.check_no );
                imgBottom3.setImageResource( R.drawable.check_no );
                break;
            }
            case R.id.reservation_bottom_ch2:{
                imgBottom2.setImageResource( R.drawable.check_green);
                imgBottom1.setImageResource( R.drawable.check_no );
                imgBottom3.setImageResource( R.drawable.check_no );
                break;
            }
            case R.id.reservation_bottom_ch3:{
                imgBottom3.setImageResource( R.drawable.check_green );
                imgBottom1.setImageResource( R.drawable.check_no );
                imgBottom2.setImageResource( R.drawable.check_no);
                break;
            }

            case R.id.reservation_checkout_place_order: {

                break;
            }
            case R.id.checkout_back:{
                finish();
                break;
            }
            default:
                break;
        }
    }
}
