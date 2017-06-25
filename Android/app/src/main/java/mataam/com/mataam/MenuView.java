package mataam.com.mataam;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Jo on 6/21/2017.
 */

public class MenuView  extends LinearLayout implements View.OnClickListener{

    Context ctx;
    int mType = 0;
    LinearLayout imgClose;

    ImageView imgMain;
    TextView  txtUserName;
    RelativeLayout reHome, reOrders, reReservations,rePlaces,rePoints,reSettings,rePromotion;

    ImageView imgHome, imgHomeDir, imgOrder, imgOrderDir, imgReservation, imgReservationDir, imgPlace, imgPlaceDir, imgPoint, imgPointDir,
    imgSetting, imgSettingDir, imgPromotion, imgPromotionDir;

    LinearLayout lvProceed;

    SelectCategoryActivity mainActivity;

    public MenuView(Context context, AttributeSet attrs){
        super(context, attrs);
        ctx = context;

        mainActivity = (SelectCategoryActivity) context;

        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.menu_view, this);

        imgClose = (LinearLayout) findViewById( R.id.menu_lv_close );
        imgClose.setOnClickListener( this );

        imgMain = (ImageView) findViewById( R.id.img_main );
        txtUserName = (TextView) findViewById( R.id.txt_user_name );

        reHome = (RelativeLayout) findViewById( R.id.re_home ); reHome.setOnClickListener( this );
        reOrders = (RelativeLayout) findViewById( R.id.re_orders ); reOrders.setOnClickListener( this );
        reReservations = (RelativeLayout) findViewById( R.id.re_reservations ); reReservations.setOnClickListener( this );
        rePlaces = (RelativeLayout) findViewById( R.id.re_places ); rePlaces.setOnClickListener( this );
        rePoints = (RelativeLayout) findViewById( R.id.re_points ); rePoints.setOnClickListener( this );
        reSettings = (RelativeLayout) findViewById( R.id.re_settings ); reSettings.setOnClickListener( this );

        imgHome = (ImageView) findViewById( R.id.menu_img_home );
        imgHomeDir = (ImageView) findViewById( R.id.menu_img_home_dir );
        imgOrder = (ImageView) findViewById( R.id.menu_img_order );
        imgOrderDir = (ImageView) findViewById( R.id.menu_img_order_dir );
        imgReservation = (ImageView) findViewById( R.id.menu_img_reservation );
        imgReservationDir = (ImageView) findViewById( R.id.menu_img_reservation_dir );
        imgPlace = (ImageView) findViewById( R.id.menu_img_place );
        imgPlaceDir = (ImageView) findViewById( R.id.menu_img_place_dir );
        imgPoint = (ImageView) findViewById( R.id.menu_img_point );
        imgPointDir = (ImageView) findViewById( R.id.menu_img_point_dir );
        imgSetting = (ImageView) findViewById( R.id.menu_img_setting );
        imgSettingDir = (ImageView) findViewById( R.id.menu_img_setting_dir );
        imgPromotion = (ImageView) findViewById( R.id.menu_img_promotion );
        imgPromotionDir = (ImageView) findViewById( R.id.menu_img_promotion_dir );

        lvProceed = (LinearLayout) findViewById( R.id.lv_procced ); lvProceed.setOnClickListener( this );
    }

    public void setParentActivty( int type ){
        mType = type;
    }

    private void closeMenu(){
        if ( mType == 1 ){
            mainActivity.onShowSlideMenu( false );
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_lv_close: {
                closeMenu();
                break;
            }
            case R.id.re_home:{
                break;
            }
            case R.id.re_orders:{
                mainActivity.onOrder();
                closeMenu();
                break;
            }
            case R.id.re_reservations:{
                mainActivity.onReservations();
                closeMenu();
                break;
            }
            case R.id.re_places:{
                mainActivity.onPlaces();
                closeMenu();
                break;
            }
            case R.id.re_points:{
                mainActivity.onPoints();
                closeMenu();
                break;
            }
            case R.id.re_settings:{
                mainActivity.onSettings();
                closeMenu();
                break;
            }
            case R.id.re_promotion:{
                break;
            }
            case R.id.lv_procced:{
                break;
            }
            default:
                break;
        }
    }
}
