package mataam.com.mataam;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SelectCategoryActivity extends Activity implements View.OnClickListener{

    RelativeLayout lvMain;
    LinearLayout   lvBack;

    ImageView      imgDelivery;
    ImageView      imgReservation;
    ImageView      imgCatering;
    ImageView      imgPick;

    RelativeLayout lvDateView;
    TextView        txtDate;
    RelativeLayout lvTimeView;
    TextView        txtTime;
    RelativeLayout lvPersonalView;
    TextView        txtPersonal;

    LinearLayout   lvDateViewParent;
    LinearLayout   lvAreaView;
    LinearLayout   lvCuisineView;

    TextView        txtArea;
    TextView        txtCuisine;

    RelativeLayout lvSearchView;

    RelativeLayout lvTopView;
    TextView        txtSearch;

    LinearLayout  lvDateViewParent1;
    RelativeLayout lvDateView1;
    TextView        txtDate1;
    RelativeLayout lvTimeView1;
    TextView        txtTime1;

    final  static int TYPE_DELIVERY = 0;
    final  static int TYPE_CATERING = 1;
    final  static int TYPE_RESERVATION = 2;
    final  static int TYPE_PICKUP = 3;

    int nType; // 0: delivery 1: catering 2: reservation 3: pickup
    MenuView slideMenu;

    LinearLayout lvMask1;
    LinearLayout lvMask2;

    LinearLayout firstView;
    FrameLayout  frameView;
    LinearLayout rowView;
    LinearLayout colView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);

        lvTopView = (RelativeLayout) findViewById( R.id.category_topView );
        txtSearch = (TextView) findViewById( R.id.cate_txt_search );

        lvMain = (RelativeLayout) findViewById( R.id.category_main);
        lvBack = (LinearLayout) findViewById( R.id.category_back );
        lvBack.setClickable( true ); lvBack.setOnClickListener( this );

        imgDelivery = (ImageView) findViewById( R.id.cate_img_delivery );
        imgDelivery.setClickable( true ); imgDelivery.setOnClickListener( this );
        imgReservation = (ImageView) findViewById( R.id.cate_img_reservation );
        imgReservation.setClickable( true ); imgReservation.setOnClickListener( this );
        imgCatering = (ImageView) findViewById( R.id.cate_img_catering );
        imgCatering.setClickable( true ); imgCatering.setOnClickListener( this );
        imgPick = (ImageView) findViewById( R.id.cate_img_pick );
        imgPick.setClickable( true ); imgPick.setOnClickListener( this );

        lvDateView = (RelativeLayout) findViewById( R.id.cate_lv_date  );
        lvDateView.setClickable( true ); lvDateView.setOnClickListener( this );
        txtDate = (TextView) findViewById( R.id.cate_txt_date );

        lvTimeView = (RelativeLayout) findViewById( R.id.cate_lv_time  );
        lvTimeView.setClickable( true ); lvTimeView.setOnClickListener( this );
        txtTime = (TextView) findViewById( R.id.cate_txt_time );

        lvPersonalView = (RelativeLayout) findViewById( R.id.cate_lv_personal  );
        lvPersonalView.setClickable( true ); lvPersonalView.setOnClickListener( this );
        txtPersonal = (TextView) findViewById( R.id.cate_txt_personal );

        lvDateViewParent = (LinearLayout) findViewById( R.id.cate_lv_dateView  );

        lvAreaView = (LinearLayout) findViewById( R.id.cate_lv_areaView  );
        lvAreaView.setClickable( true ); lvAreaView.setOnClickListener( this );
        lvCuisineView = (LinearLayout) findViewById( R.id.cate_lv_cuisineView );
        lvCuisineView.setClickable( true ); lvCuisineView.setOnClickListener( this );

        txtArea = (TextView) findViewById( R.id.cate_txt_area );
        txtCuisine = (TextView) findViewById( R.id.cate_txt_cuisine );

        lvSearchView = (RelativeLayout) findViewById(R.id.cate_lv_search );
        lvSearchView.setClickable( true ); lvSearchView.setOnClickListener( this );

        lvDateViewParent1 = (LinearLayout) findViewById( R.id.cate_lv_dateView1 );
        lvDateView1 = (RelativeLayout) findViewById( R.id.cate_lv_date1 );
        lvDateView1.setClickable( true ); lvDateView1.setOnClickListener( this );
        txtDate1 = (TextView) findViewById( R.id.cate_txt_date1 );
        lvTimeView1 = (RelativeLayout) findViewById( R.id.cate_lv_time1 );
        lvTimeView1.setClickable( true ); lvTimeView1.setOnClickListener( this );
        txtTime1 = (TextView) findViewById( R.id.cate_txt_time1 );
        slideMenu = (MenuView) findViewById( R.id.slideMenu );

        lvMask1 = (LinearLayout) findViewById( R.id.lv_mask1 );
        lvMask2 = (LinearLayout) findViewById( R.id.lv_mask2 );
        lvMask1.setVisibility( View.VISIBLE );
        lvMask2.setVisibility( View.GONE );

        setDelivery();

        firstView = (LinearLayout) findViewById( R.id.firstView );
        frameView  = (FrameLayout) findViewById( R.id.frameView );
        rowView     = (LinearLayout) findViewById( R.id.rowView );
        colView     = (LinearLayout) findViewById( R.id.colView );

        setUI();
    }

    private void setUI()
    {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        int bottomHeight = (int) convertDpToPixel( 200, this );
        height = height - bottomHeight;
        int realSize   = 0;
        if ( height > width )
            realSize = width;
        else
            realSize = height;

        realSize = realSize - (int) convertDpToPixel( 30, this );

        firstView.setLayoutParams( new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, realSize));
        frameView.setLayoutParams( new LinearLayout.LayoutParams(realSize, realSize) );
        rowView.setLayoutParams( new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int)(realSize/3) ) );
        colView.setLayoutParams( new LinearLayout.LayoutParams( (int)(realSize/3), LinearLayout.LayoutParams.MATCH_PARENT ) );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.category_back:{
                slideMenu.setParentActivty( 1 );
                onShowSlideMenu( true );
            }
            break;
            case R.id.cate_img_delivery: {
               setDelivery(); nType = TYPE_DELIVERY;
                lvMask1.setVisibility( View.VISIBLE );
                lvMask2.setVisibility( View.GONE );

            }
            break;
            case R.id.cate_img_reservation: {
                setReservation(); nType = TYPE_RESERVATION;
                lvMask2.setVisibility( View.VISIBLE );
                lvMask1.setVisibility( View.GONE );

            }
            break;
            case R.id.cate_img_catering: {
                setCatering(); nType = TYPE_CATERING;
                lvMask2.setVisibility( View.VISIBLE );
                lvMask1.setVisibility( View.GONE );

            }
            break;
            case R.id.cate_img_pick: {
                setPickUp(); nType = TYPE_PICKUP;
                lvMask1.setVisibility( View.VISIBLE );
                lvMask2.setVisibility( View.GONE );

            }
            break;
            case R.id.cate_lv_date: {

            }
            break;
            case R.id.cate_lv_date1: {

            }
            break;
            case R.id.cate_lv_time: {

            }
            break;
            case R.id.cate_lv_time1: {

            }
            break;
            case R.id.cate_lv_personal: {

            }
            break;
            case R.id.cate_lv_areaView: {
                Intent intent = new Intent( SelectCategoryActivity.this, ChooseLocationActivity.class );
                startActivity( intent );
            }
            break;
            case R.id.cate_lv_cuisineView: {
                Intent intent  = new Intent( SelectCategoryActivity.this, ChooseCuisineActivity.class );
                startActivity( intent );
            }
            break;
            case R.id.cate_lv_search: {
                if ( nType == TYPE_DELIVERY ){
                    Intent intent = new Intent( SelectCategoryActivity.this, DeliveryRestaurantActivity.class );
                    intent.putExtra("TYPE", 1 );
                    startActivity( intent );
                }
                else if ( nType == TYPE_RESERVATION ){
                    Intent intent = new Intent( SelectCategoryActivity.this, DeliveryRestaurantActivity.class );
                    intent.putExtra("TYPE", 2 );
                    startActivity( intent );
                }
                else if ( nType == TYPE_PICKUP ){
                    Intent intent = new Intent( SelectCategoryActivity.this, DeliveryRestaurantActivity.class );
                    intent.putExtra("TYPE", 3 );
                    startActivity( intent );
                }
                else if ( nType == TYPE_CATERING ){
                    Intent intent = new Intent( SelectCategoryActivity.this, DeliveryRestaurantActivity.class );
                    intent.putExtra("TYPE", 4 );
                    startActivity( intent );
                }
            }
            break;

            default:
                break;
        }
    }

    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    public void onShowSlideMenu(boolean flag){
        int delta  = (int)convertDpToPixel( 248, this) ;
        if ( flag == false ){
            slideMenu.animate().translationXBy(-delta).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);

                }
            });
        }
        else
        {
            slideMenu.animate().translationXBy(delta).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);

                }
            });
        }
    }

    private  void  setDelivery()
    {
        lvMain.setBackgroundResource( R.drawable.bg_2 );
        lvTopView.setBackgroundColor( getResources().getColor( R.color.colorGreen ) );

        imgDelivery.setImageResource( R.drawable.delivery_sel);
        imgCatering.setImageResource( R.drawable.catering );
        imgReservation.setImageResource( R.drawable.reservation);
        imgPick.setImageResource( R.drawable.pickup );

        lvDateViewParent.setVisibility( View.GONE );
        lvDateViewParent1.setVisibility( View.GONE );

        lvSearchView.setBackgroundDrawable( getResources().getDrawable( R.drawable.btn_green ) );
        txtSearch.setText("SEARCH FOR DELIVERY");

    }

    private  void  setReservation()
    {
        lvMain.setBackgroundResource( R.drawable.bg_1 );
        lvTopView.setBackgroundColor( getResources().getColor( R.color.colorRed));

        imgDelivery.setImageResource( R.drawable.delivery);
        imgCatering.setImageResource( R.drawable.catering );
        imgReservation.setImageResource( R.drawable.reservation_sel);
        imgPick.setImageResource( R.drawable.pickup );

        lvDateViewParent.setVisibility( View.VISIBLE );
        lvDateViewParent1.setVisibility( View.GONE );
        lvSearchView.setBackgroundDrawable( getResources().getDrawable( R.drawable.btn_red ) );
        txtSearch.setText("SEARCH FOR RESERVATION");
    }

    private  void  setCatering()
    {
        lvMain.setBackgroundResource( R.drawable.bg_3 );
        lvTopView.setBackgroundColor( getResources().getColor( R.color.colorOrange));

        imgDelivery.setImageResource( R.drawable.delivery);
        imgCatering.setImageResource( R.drawable.catering_sel );
        imgReservation.setImageResource( R.drawable.reservation);
        imgPick.setImageResource( R.drawable.pickup );

        lvDateViewParent.setVisibility( View.GONE );
        lvDateViewParent1.setVisibility( View.VISIBLE );

        lvSearchView.setBackgroundDrawable( getResources().getDrawable( R.drawable.btn_orange ) );
        txtSearch.setText("SEARCH FOR CATERING");
    }

    private  void  setPickUp()
    {
        lvMain.setBackgroundResource( R.drawable.bg_4 );
        lvTopView.setBackgroundColor( getResources().getColor( R.color.colorBlue) );

        imgDelivery.setImageResource( R.drawable.delivery);
        imgCatering.setImageResource( R.drawable.catering );
        imgReservation.setImageResource( R.drawable.reservation);
        imgPick.setImageResource( R.drawable.pickup_sel );

        lvDateViewParent.setVisibility( View.GONE );
        lvDateViewParent1.setVisibility( View.GONE );

        lvSearchView.setBackgroundDrawable( getResources().getDrawable( R.drawable.btn_blue ) );
        txtSearch.setText("SEARCH FOR PICKUP");
    }


    public void onOrder(){
        Intent intent  = new Intent ( SelectCategoryActivity.this, OrdersActivity.class );
        startActivity( intent );
    }

    public void onReservations(){
        Intent intent  = new Intent ( SelectCategoryActivity.this, MyReservationActivity.class );
        startActivity( intent );
    }

    public void onPlaces(){
        Intent intent  = new Intent ( SelectCategoryActivity.this, PlaceActivity.class );
        startActivity( intent );
    }

    public void onPoints(){
        Intent intent = new Intent( SelectCategoryActivity.this, PointsActivity.class );
        startActivity( intent );
    }

    public void onSettings(){
        Intent intent = new Intent( SelectCategoryActivity.this , SettingActivity.class );
        startActivity( intent );
    }

    public void onPromotion(){

    }
}
