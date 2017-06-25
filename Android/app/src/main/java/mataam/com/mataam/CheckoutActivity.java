package mataam.com.mataam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class CheckoutActivity extends Activity implements View.OnClickListener{

    LinearLayout lvTop1, lvTop2, lvTop3, lvMedium1, lvMedium2, lvBottom1, lvBottom2, lvBottom3;
    ImageView    imgTop1, imgTop2, imgTop3, imgMedium1, imgMedium2, imgBottom1, imgBottom2, imgBottom3;
    RelativeLayout lvPlaceOrder;

    RelativeLayout reTopView;
    ImageView      imgBtmBg;
    int type;
    LinearLayout   lvTempClr;
    LinearLayout    lvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        lvBack = (LinearLayout) findViewById( R.id.checkout_back );
        lvBack.setOnClickListener( this );
        reTopView = (RelativeLayout) findViewById( R.id.checkout_topView );
        imgBtmBg = (ImageView) findViewById( R.id.checkout_bottom_bg );

        lvTempClr = (LinearLayout) findViewById( R.id.bg_temp_clr );
        lvTop1 = (LinearLayout) findViewById( R.id.top_ch1 ); lvTop1.setOnClickListener( this );
        lvTop2 = (LinearLayout) findViewById( R.id.top_ch2 ); lvTop2.setOnClickListener( this );
        lvTop3 = (LinearLayout) findViewById( R.id.top_ch3 ); lvTop3.setOnClickListener( this );

        lvMedium1 = (LinearLayout) findViewById( R.id.medium_ch1 ); lvMedium1.setOnClickListener( this );
        lvMedium2 = (LinearLayout) findViewById( R.id.medium_ch2 ); lvMedium2.setOnClickListener( this );

        lvBottom1 = (LinearLayout) findViewById( R.id.bottom_ch1 ); lvBottom1.setOnClickListener( this );
        lvBottom2 = (LinearLayout) findViewById( R.id.bottom_ch2 ); lvBottom2.setOnClickListener( this );
        lvBottom3 = (LinearLayout) findViewById( R.id.bottom_ch3 ); lvBottom3.setOnClickListener( this );

        imgTop1 = (ImageView) findViewById( R.id.top_img1 );
        imgTop2 = (ImageView) findViewById( R.id.top_img2 );
        imgTop3 = (ImageView) findViewById( R.id.top_img3 );

        imgMedium1 = (ImageView) findViewById( R.id.medium_img1 );
        imgMedium2 = (ImageView) findViewById( R.id.medium_img2 );

        imgBottom1 = (ImageView) findViewById( R.id.bottom_img1 );
        imgBottom2 = (ImageView) findViewById( R.id.bottom_img2 );
        imgBottom3 = (ImageView) findViewById( R.id.bottom_img3 );


        imgTop1.setImageResource( R.drawable.check_green );
        imgTop2.setImageResource( R.drawable.check_no );
        imgTop3.setImageResource( R.drawable.check_no );

        imgMedium1.setImageResource( R.drawable.check_green);
        imgMedium2.setImageResource( R.drawable.check_no );

        imgBottom1.setImageResource( R.drawable.check_green);
        imgBottom2.setImageResource( R.drawable.check_no );
        imgBottom3.setImageResource( R.drawable.check_no);



        lvPlaceOrder = (RelativeLayout) findViewById( R.id.checkout_place_order );
        lvPlaceOrder.setOnClickListener( this );

        setUI();
    }

    private void setUI(){

        type = MainActivity.global.nSelectType;
        if ( type == MainActivity.global.TYPE_DELIVERY ){
            reTopView.setBackgroundColor( getResources().getColor( R.color.colorGreen ));
            imgBtmBg.setImageResource( R.drawable.btn_green );
            imgTop1.setImageResource( R.drawable.check_green );
            imgTop2.setImageResource( R.drawable.check_no );
            imgTop3.setImageResource( R.drawable.check_no );
            imgMedium1.setImageResource( R.drawable.check_green );
            imgMedium2.setImageResource( R.drawable.check_no );
            imgBottom1.setImageResource( R.drawable.check_green );
            imgBottom2.setImageResource( R.drawable.check_no );
            imgBottom3.setImageResource( R.drawable.check_no );
//            lvTempClr.setBackgroundColor( getResources().getColor( R.color.colorGreen ) );
        }
        else if ( type == MainActivity.global.TYPE_RESERVATION ){

        }
        else if ( type == MainActivity.global.TYPE_PICKUP ){
            reTopView.setBackgroundColor( getResources().getColor( R.color.colorBlue ));
            imgBtmBg.setImageResource( R.drawable.btn_blue );
            imgTop1.setImageResource( R.drawable.check_blue );
            imgTop2.setImageResource( R.drawable.check_no );
            imgTop3.setImageResource( R.drawable.check_no );
            imgMedium1.setImageResource( R.drawable.check_blue );
            imgMedium2.setImageResource( R.drawable.check_no );
            imgBottom1.setImageResource( R.drawable.check_blue );
            imgBottom2.setImageResource( R.drawable.check_no );
            imgBottom3.setImageResource( R.drawable.check_no );

//            lvTempClr.setBackgroundColor( getResources().getColor( R.color.colorBlue ) );
        }
        else if ( type == MainActivity.global.TYPE_CATERING ){
            reTopView.setBackgroundColor( getResources().getColor( R.color.colorOrange ));
            imgBtmBg.setImageResource( R.drawable.btn_orange );
            imgTop1.setImageResource( R.drawable.check_orange );
            imgTop2.setImageResource( R.drawable.check_no );
            imgTop3.setImageResource( R.drawable.check_no );
            imgMedium1.setImageResource( R.drawable.check_orange );
            imgMedium2.setImageResource( R.drawable.check_no );
            imgBottom1.setImageResource( R.drawable.check_orange );
            imgBottom2.setImageResource( R.drawable.check_no );
            imgBottom3.setImageResource( R.drawable.check_no );

//            lvTempClr.setBackgroundColor( getResources().getColor( R.color.colorOrange ) );
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.checkout_back:{
                finish();
                break;
            }
            case R.id.top_ch1:
            {
                if ( type == MainActivity.global.TYPE_DELIVERY ){
                    imgTop1.setImageResource( R.drawable.check_green );
                }
                else if ( type == MainActivity.global.TYPE_PICKUP ){
                    imgTop1.setImageResource( R.drawable.check_blue );
                }
                else if ( type == MainActivity.global.TYPE_CATERING ){
                    imgTop1.setImageResource( R.drawable.check_orange );
                }


                imgTop2.setImageResource( R.drawable.check_no );
                imgTop3.setImageResource( R.drawable.check_no );
                break;
            }
            case R.id.top_ch2:
            {
                if ( type == MainActivity.global.TYPE_DELIVERY )
                    imgTop2.setImageResource( R.drawable.check_green );
                else if ( type == MainActivity.global.TYPE_PICKUP )
                    imgTop2.setImageResource( R.drawable.check_blue );
                else if ( type == MainActivity.global.TYPE_CATERING )
                    imgTop2.setImageResource( R.drawable.check_orange );

                imgTop1.setImageResource( R.drawable.check_no );
                imgTop3.setImageResource( R.drawable.check_no );
                break;
            }
            case R.id.top_ch3:
            {
                imgTop1.setImageResource( R.drawable.check_no );
                imgTop2.setImageResource( R.drawable.check_no );
                if ( type == MainActivity.global.TYPE_DELIVERY )
                    imgTop3.setImageResource( R.drawable.check_green );
                else if ( type == MainActivity.global.TYPE_PICKUP )
                    imgTop3.setImageResource( R.drawable.check_blue );
                else if ( type == MainActivity.global.TYPE_CATERING )
                    imgTop3.setImageResource( R.drawable.check_orange );
                break;
            }

            case R.id.medium_ch1:{
                if ( type == MainActivity.global.TYPE_DELIVERY )
                    imgMedium1.setImageResource( R.drawable.check_green );
                else if ( type == MainActivity.global.TYPE_PICKUP )
                    imgMedium1.setImageResource( R.drawable.check_blue );
                else if ( type == MainActivity.global.TYPE_CATERING )
                    imgMedium1.setImageResource( R.drawable.check_orange );

                imgMedium2.setImageResource( R.drawable.check_no );
                break;
            }
            case R.id.medium_ch2:{
                imgMedium1.setImageResource( R.drawable.check_no );

                if ( type == MainActivity.global.TYPE_DELIVERY )
                    imgMedium2.setImageResource( R.drawable.check_green );
                else if ( type == MainActivity.global.TYPE_PICKUP )
                    imgMedium2.setImageResource( R.drawable.check_blue );
                else if ( type == MainActivity.global.TYPE_CATERING )
                    imgMedium2.setImageResource( R.drawable.check_orange );
                break;
            }

            case R.id.bottom_ch1:{
                if ( type == MainActivity.global.TYPE_DELIVERY )
                    imgBottom1.setImageResource( R.drawable.check_green );
                else if ( type == MainActivity.global.TYPE_PICKUP )
                    imgBottom1.setImageResource( R.drawable.check_blue );
                else if ( type == MainActivity.global.TYPE_CATERING )
                    imgBottom1.setImageResource( R.drawable.check_orange );

                imgBottom2.setImageResource( R.drawable.check_no );
                imgBottom3.setImageResource( R.drawable.check_no);
                break;
            }
            case R.id.bottom_ch2:{
                if ( type == MainActivity.global.TYPE_DELIVERY )
                    imgBottom2.setImageResource( R.drawable.check_green );
                else if ( type == MainActivity.global.TYPE_PICKUP )
                    imgBottom2.setImageResource( R.drawable.check_blue );
                else if ( type == MainActivity.global.TYPE_CATERING )
                    imgBottom2.setImageResource( R.drawable.check_orange );

                imgBottom1.setImageResource( R.drawable.check_no );
                imgBottom3.setImageResource( R.drawable.check_no);
                break;
            }
            case R.id.bottom_ch3:{
                if ( type == MainActivity.global.TYPE_DELIVERY )
                    imgBottom3.setImageResource( R.drawable.check_green );
                else if ( type == MainActivity.global.TYPE_PICKUP )
                    imgBottom3.setImageResource( R.drawable.check_blue );
                else if ( type == MainActivity.global.TYPE_CATERING )
                    imgBottom3.setImageResource( R.drawable.check_orange );

                imgBottom1.setImageResource( R.drawable.check_no );
                imgBottom2.setImageResource( R.drawable.check_no);
                break;
            }

            case R.id.checkout_place_order: {
                Intent intent  = new Intent( CheckoutActivity.this, DeliveryPaymentActivity.class );
                startActivity( intent );
                break;
            }
            default:
                break;
        }
    }
}
