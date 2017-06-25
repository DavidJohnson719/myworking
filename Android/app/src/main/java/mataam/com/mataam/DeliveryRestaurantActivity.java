package mataam.com.mataam;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

import mataam.com.mataam.Model.ItemDelivery;

public class DeliveryRestaurantActivity extends Activity implements View.OnClickListener{

    RelativeLayout lvDetailView;
    LinearLayout   lvInfoView;

    ListView  list1;
    ListView  list2;

    LinearLayout    lvMenu;
    LinearLayout    lvRate;
    RelativeLayout    btnDate;
    RelativeLayout    btnTime;

    ImageView    btnBigShow;
    ImageView    btnDetailShow;
    ImageView    btnSearch;
    LinearLayout    btnSort;

    RelativeLayout lvSearchEdit;

    boolean  bOpen = true;
    ArrayList<ItemDelivery> data  = new ArrayList<>();

    ImageView imgWhiteTringle;
    boolean bSortOpen = false;

    LinearLayout lvSortView;
    LinearLayout lvSortView1;

    LinearLayout lvTop1, lvTop2, lvTop3, lvTop4, lvTop5, lvTop6;
    LinearLayout lvbtm1, lvbtm2, lvbtm3, lvbtm4, lvbtm5, lvbtm6;

    ImageView imgTop1, imgTop2, imgTop3, imgTop4, imgTop5, imgTop6;
    ImageView imgBtm1, imgBtm2, imgBtm3, imgBtm4, imgBtm5, imgBtm6;

    RelativeLayout lvSearchBar;
    LinearLayout   lvBtnCloseSearch;
    TextView       txtSearchBtn;
    ImageView       imgSearchBg;

    TextView txtDelivery, txtReservation, txtPickup, txtCatering;
    ImageView imgDelivery, imgReservation, imgPickup, imgCatering;

    RelativeLayout reTopView;

    final  static  int TYPE_DELIVERY = 1;
    final  static  int TYPE_RESERVATION = 2;
    final  static  int TYPE_PICKUP = 3;
    final  static  int TYPE_CATERING = 4;

    final  static  int SHOW_BIG = 1;
    final  static  int SHOW_DETAIL = 2;

    int nType = 1;
    int nShowType = 1;

    LinearLayout lvDateView, lvDateView1, lvArea, lvCuisine;
    RelativeLayout reDate, reTime, rePersonal, reDate1, reTime1 ;
    TextView        txtDate, txtTime , txtPersonal, txtDate1, txtTime1, txtArea, txtCusine;

    LinearLayout lvMask1, lvMask2;

    MenuView slideMenu;
    boolean bShow = false;

    private void initSortView()
    {
        lvSortView = (LinearLayout) findViewById( R.id.lv_sortView );
        lvSortView1 = (LinearLayout) findViewById( R.id.lv_sortView1 );

        lvTop1 = (LinearLayout) findViewById( R.id.lv_top1 ); lvTop1.setOnClickListener( this );
        lvTop2 = (LinearLayout) findViewById( R.id.lv_top2 ); lvTop2.setOnClickListener( this );
        lvTop3 = (LinearLayout) findViewById( R.id.lv_top3 ); lvTop3.setOnClickListener( this );
        lvTop4 = (LinearLayout) findViewById( R.id.lv_top4 ); lvTop4.setOnClickListener( this );
        lvTop5 = (LinearLayout) findViewById( R.id.lv_top5 ); lvTop5.setOnClickListener( this );
        lvTop6 = (LinearLayout) findViewById( R.id.lv_top6 ); lvTop6.setOnClickListener( this );

        lvbtm1 = (LinearLayout) findViewById( R.id.lv_btm1 ); lvbtm1.setOnClickListener( this );
        lvbtm2 = (LinearLayout) findViewById( R.id.lv_btm2 ); lvbtm2.setOnClickListener( this );
        lvbtm3 = (LinearLayout) findViewById( R.id.lv_btm3 ); lvbtm3.setOnClickListener( this );
        lvbtm4 = (LinearLayout) findViewById( R.id.lv_btm4 ); lvbtm4.setOnClickListener( this );
        lvbtm5 = (LinearLayout) findViewById( R.id.lv_btm5 ); lvbtm5.setOnClickListener( this );
        lvbtm6 = (LinearLayout) findViewById( R.id.lv_btm6 ); lvbtm6.setOnClickListener( this );

        imgTop1 = (ImageView) findViewById( R.id.img_top_chk1 ); imgTop1.setOnClickListener( this );
        imgTop2 = (ImageView) findViewById( R.id.img_top_ch2 ); imgTop2.setOnClickListener( this );
        imgTop3 = (ImageView) findViewById( R.id.img_top_ch3 ); imgTop3.setOnClickListener( this );
        imgTop4 = (ImageView) findViewById( R.id.img_top_ch4); imgTop4.setOnClickListener( this );
        imgTop5 = (ImageView) findViewById( R.id.img_top_ch5 ); imgTop5.setOnClickListener( this );
        imgTop6 = (ImageView) findViewById( R.id.img_top_ch6 ); imgTop6.setOnClickListener( this );

        imgBtm1 = (ImageView) findViewById( R.id.img_btm_ch1 ); imgBtm1.setOnClickListener( this );
        imgBtm2 = (ImageView) findViewById( R.id.img_btm_ch2 ); imgBtm2.setOnClickListener( this );
        imgBtm3 = (ImageView) findViewById( R.id.img_btm_ch3 ); imgBtm3.setOnClickListener( this );
        imgBtm4 = (ImageView) findViewById( R.id.img_btm_ch4 ); imgBtm4.setOnClickListener( this );
        imgBtm5 = (ImageView) findViewById( R.id.img_btm_ch5 ); imgBtm5.setOnClickListener( this );
        imgBtm6 = (ImageView) findViewById( R.id.img_btm_ch6 ); imgBtm6.setOnClickListener( this );

    }

    private void initSearchBar()
    {
        lvSearchBar = (RelativeLayout) findViewById( R.id.delivery_lv_searchBar_edit  );
        lvBtnCloseSearch = (LinearLayout) findViewById( R.id.lv_close_search );
        lvBtnCloseSearch.setOnClickListener( this );
        txtSearchBtn = (TextView) findViewById( R.id.cate_txt_search );
        imgSearchBg = (ImageView) findViewById( R.id.img_search_bg );
    }

    private void  initSelectView()
    {
        txtDelivery = (TextView) findViewById( R.id.txt_delivery );
        txtReservation = (TextView) findViewById( R.id.txt_reservation );
        txtPickup = (TextView) findViewById( R.id.txt_pickup );
        txtCatering = (TextView) findViewById( R.id.txt_catering );

        imgDelivery = (ImageView )findViewById( R.id.img_delivery );
        imgReservation = (ImageView) findViewById( R.id.img_reservation );
        imgPickup = (ImageView )findViewById( R.id.img_pickup );
        imgCatering = (ImageView )findViewById( R.id.img_catering );

        imgDelivery.setClickable( true);         imgDelivery.setOnClickListener( this );
        imgReservation.setClickable( true );    imgReservation.setOnClickListener( this );
        imgPickup.setClickable( true );          imgPickup.setOnClickListener( this );
        imgCatering.setClickable( true );          imgCatering.setOnClickListener( this );
    }

    private void  initButtonView()
    {
        lvDateView = (LinearLayout) findViewById( R.id.delivery_lv_dateView  );
        lvDateView1 = (LinearLayout) findViewById( R.id.delivery_lv_dateView1 );
        lvArea = (LinearLayout) findViewById( R.id.delivery_lv_areaView ); lvArea.setOnClickListener( this );
        lvCuisine = (LinearLayout) findViewById( R.id.delivery_lv_cuisineView ); lvCuisine.setOnClickListener( this );

        reDate = (RelativeLayout) findViewById( R.id.delivery_lv_date ); reDate.setOnClickListener( this );
        reTime = (RelativeLayout) findViewById( R.id.delivery_lv_time ); reTime.setOnClickListener( this );
        rePersonal = (RelativeLayout) findViewById( R.id.delivery_lv_personal ); rePersonal.setOnClickListener( this );
        reDate1 = (RelativeLayout) findViewById( R.id.delivery_lv_date1 ); reDate1.setOnClickListener( this );
        reTime1 = (RelativeLayout) findViewById( R.id.delivery_lv_time1 ); reTime1.setOnClickListener( this );

        txtDate = (TextView) findViewById( R.id.delivery_txt_date );
        txtTime = (TextView) findViewById( R.id.delivery_txt_time );
        txtPersonal = (TextView) findViewById( R.id.delivery_txt_personal );
        txtDate1 = (TextView) findViewById( R.id.delivery_txt_date1  );
        txtTime1 = (TextView) findViewById( R.id.delivery_txt_time1  );
        txtArea = (TextView) findViewById( R.id.delivery_txt_area );
        txtCusine = (TextView) findViewById( R.id.delivery_txt_cuisine );

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_restaurant);

        lvDetailView = (RelativeLayout) findViewById( R.id.delivery_lv_detail );
        lvInfoView = (LinearLayout) findViewById( R.id.delivery_info_view );

        list1 = (ListView) findViewById( R.id.delivery_list1 );
        list2 = (ListView) findViewById( R.id.delivery_list2 );

        lvSearchBar = (RelativeLayout) findViewById( R.id.delivery_search_bar );
        lvSearchBar.setClickable(true) ;
        lvSearchBar.setOnClickListener( this );

        lvRate = (LinearLayout) findViewById( R.id.delivery_rate );
        lvRate.setOnClickListener( this );
        lvMenu = (LinearLayout) findViewById( R.id.delivery_menu  );
        lvMenu.setOnClickListener( this );
        btnDate = (RelativeLayout) findViewById( R.id.delivery_lv_date1 );
        btnDate.setOnClickListener( this );
        btnTime = (RelativeLayout) findViewById( R.id.delivery_lv_time1 );
        btnTime.setOnClickListener( this );
        btnBigShow = (ImageView) findViewById( R.id.delivery_img_big );
        btnBigShow.setOnClickListener( this );
        btnDetailShow = (ImageView) findViewById( R.id.delivery_img_detail );
        btnDetailShow.setOnClickListener( this );
        btnSearch = (ImageView) findViewById( R.id.delivery_img_search );
        btnSearch.setOnClickListener( this );
        btnSort = (LinearLayout) findViewById( R.id.delivery_lv_sort );
        btnSort.setOnClickListener( this );

        lvSearchEdit = (RelativeLayout) findViewById( R.id.delivery_lv_searchBar_edit  );
        imgWhiteTringle = (ImageView) findViewById( R.id.white_tringle );

        lvMask1 = (LinearLayout) findViewById( R.id.lv_mask1 );
        lvMask2 = (LinearLayout) findViewById( R.id.lv_mask2 );


        CustomAdapter adapter=new CustomAdapter( this, data, getResources(), nType );
        list1.setAdapter(adapter);
        list2.setAdapter(adapter);

        LinearLayout lv = (LinearLayout) findViewById( R.id.lv1 );
        lv.setOnClickListener( this );

        reTopView = (RelativeLayout) findViewById( R.id.delivery_topView );
        slideMenu = (MenuView) findViewById( R.id.slideMenu );

        initSortView();
        initSearchBar();
        initSelectView();
        initButtonView();

        selectSort( 0 );

        nType = getIntent().getIntExtra("TYPE", 1 );
        setSelectView( nType );

        setTempData();
    }

    public void onShowSlideMenu(boolean flag){
        int delta  = (int)convertDpToPixel( 248, this) ;
        if ( flag == false ){
            slideMenu.animate().translationXBy(-delta).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    lvMenu.setEnabled( true );
                }
            });
        }
        else
        {
            slideMenu.animate().translationXBy(delta).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    lvMenu.setEnabled( false );
                }
            });
        }
    }

    private void selectSort( int nSort )
    {
        imgTop1.setImageResource( R.drawable.check_no );
        imgTop2.setImageResource( R.drawable.check_no);
        imgTop3.setImageResource( R.drawable.check_no);
        imgTop4.setImageResource( R.drawable.check_no);
        imgTop5.setImageResource( R.drawable.check_no);
        imgTop6.setImageResource( R.drawable.check_no);

        imgBtm1.setImageResource( R.drawable.check_no);
        imgBtm2.setImageResource( R.drawable.check_no);
        imgBtm3.setImageResource( R.drawable.check_no);
        imgBtm4.setImageResource( R.drawable.check_no);
        imgBtm5.setImageResource( R.drawable.check_no);
        imgBtm6.setImageResource( R.drawable.check_no);

        switch ( nSort ){
            case 0: {
                imgTop1.setImageResource( R.drawable.check_green );
                imgBtm1.setImageResource( R.drawable.check_green );
                break;
            }
            case 1:{
                imgTop2.setImageResource( R.drawable.check_green);
                imgBtm2.setImageResource( R.drawable.check_green);
                break;
            }

            case 2:{
                imgTop3.setImageResource( R.drawable.check_green);
                imgBtm3.setImageResource( R.drawable.check_green);
                break;
            }

            case 3:{
                imgTop4.setImageResource( R.drawable.check_green);
                imgBtm4.setImageResource( R.drawable.check_green);
                break;
            }

            case 4:{
                imgTop5.setImageResource( R.drawable.check_green);
                imgBtm5.setImageResource( R.drawable.check_green);
                break;
            }

            case 5:{
                imgTop6.setImageResource( R.drawable.check_green);
                imgBtm6.setImageResource( R.drawable.check_green);
                break;
            }

            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.delivery_lv_areaView:{
                Intent intent  = new Intent( DeliveryRestaurantActivity.this, ChooseLocationActivity.class );
                startActivity( intent );
                break;
            }
            case R.id.delivery_lv_cuisineView:{
                Intent intent  = new Intent( DeliveryRestaurantActivity.this, ChooseCuisineActivity.class );
                startActivity( intent );
                break;
            }

            case R.id.delivery_img_search:{
                lvSearchBar.setVisibility( View.VISIBLE );
            }
            break;
            case R.id.lv_close_search:{
                lvSearchBar.setVisibility( View.GONE );
            }
            break;
            case R.id.delivery_search_bar: {
                showMenu( bOpen );
                imgWhiteTringle.setVisibility(View.INVISIBLE);
                lvSortView.setVisibility(View.GONE);
                lvSortView1.setVisibility(View.GONE);
                bSortOpen = false;
            }
            break;
            case R.id.delivery_menu: {
                finish();
            }
            break;
            case R.id.delivery_lv_date1: {
            }
            break;
            case R.id.delivery_lv_time1: {
            }
            break;
            case R.id.delivery_img_big: {
                nShowType = SHOW_BIG;
                CustomAdapter adapter=new CustomAdapter( this, data, getResources(), nType );
                list1.setAdapter(adapter);
                list2.setAdapter(adapter);

                btnBigShow.setImageResource( R.drawable.viewthumb_sel );
                btnDetailShow.setImageResource( R.drawable.viewlistlarge );
            }
            break;
            case R.id.delivery_img_detail: {
                nShowType = SHOW_DETAIL;
                CustomAdapter1 adapter=new CustomAdapter1( this, data, getResources(), nType );
                list1.setAdapter(adapter);
                list2.setAdapter(adapter);
                btnBigShow.setImageResource( R.drawable.viewthumb );
                btnDetailShow.setImageResource( R.drawable.viewlistlarge_sel );
            }
            break;

            case R.id.delivery_lv_sort: {
                if ( !bSortOpen ){
                    imgWhiteTringle.setVisibility(View.VISIBLE);
                    if ( bOpen ) {
                        lvSortView.setVisibility(View.VISIBLE);
                        lvSortView1.setVisibility(View.GONE);
                    }
                    else {
                        lvSortView.setVisibility(View.GONE);
                        lvSortView1.setVisibility(View.VISIBLE);
                    }
                    bSortOpen = !bSortOpen;
                }
                else{
                    imgWhiteTringle.setVisibility(View.INVISIBLE);
                    lvSortView.setVisibility(View.GONE);
                    lvSortView1.setVisibility(View.GONE);
                    bSortOpen = !bSortOpen;
                }
            }
            break;

            case R.id.lv_top1:
            case R.id.lv_btm1 :{
                selectSort( 0 );
                break;
            }

            case R.id.lv_top2:
            case R.id.lv_btm2: {
                selectSort( 1 );
                break;
            }

            case R.id.lv_top3:
            case R.id.lv_btm3: {
                selectSort( 2 );
                break;
            }

            case R.id.lv_top4:
            case R.id.lv_btm4:{
                selectSort( 3 );
                break;
            }

            case R.id.lv_top5:
            case R.id.lv_btm5:{
                selectSort( 4 );
                break;
            }
            case R.id.lv_top6:
            case R.id.lv_btm6:{
                selectSort( 5 );
                break;
            }

            case R.id.lv1:
            case R.id.img_delivery:{
                nType = TYPE_DELIVERY;
                setSelectView(nType);
                break;
            }
            case R.id.img_reservation:{
                nType = TYPE_RESERVATION;
                setSelectView(nType);
                break;
            }
            case R.id.img_pickup:{
                nType = TYPE_PICKUP;
                setSelectView(nType);
                break;
            }
            case R.id.img_catering:{
                nType = TYPE_CATERING;
                setSelectView(nType);
                break;
            }

            default:
                break;
        }
    }

    private void setSelectView( int type ){
        switch ( type ){
            case TYPE_DELIVERY:{

                MainActivity.global.nSelectType = MainActivity.global.TYPE_DELIVERY;
                txtDelivery.setTextColor( getResources().getColor( android.R.color.white ));
                txtReservation.setTextColor( getResources().getColor( android.R.color.secondary_text_dark ));
                txtPickup.setTextColor( getResources().getColor( android.R.color.secondary_text_dark ) );
                txtCatering.setTextColor( getResources().getColor( android.R.color.secondary_text_dark ));

                imgDelivery.setImageResource( R.drawable.md_delivery_sel );
                imgReservation.setImageResource( R.drawable.md_reservation );
                imgPickup.setImageResource( R.drawable.md_pickup );
                imgCatering.setImageResource( R.drawable.md_catering );

                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)imgDelivery.getLayoutParams();
                params.setMargins(0, 5, 0, 5); //substitute parameters for left, top, right, bottom
                imgDelivery.setLayoutParams(params);

                LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams)imgReservation.getLayoutParams();
                params1.setMargins(0, 5, 0, 15); //substitute parameters for left, top, right, bottom
                imgReservation.setLayoutParams(params1);

                LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams)imgPickup.getLayoutParams();
                params2.setMargins(0, 5, 0, 15); //substitute parameters for left, top, right, bottom
                imgPickup.setLayoutParams(params2);

                LinearLayout.LayoutParams params3 = (LinearLayout.LayoutParams)imgCatering.getLayoutParams();
                params3.setMargins(0, 5, 0, 15); //substitute parameters for left, top, right, bottom
                imgCatering.setLayoutParams(params3);

                reTopView.setBackgroundColor( getResources().getColor( R.color.colorGreen ));
                imgSearchBg.setImageResource( R.drawable.btn_green );
                txtSearchBtn.setText(" SEARCH FOR DELIVERY");

                lvDateView.setVisibility( View.GONE );
                lvDateView1.setVisibility( View.GONE );

                if ( nShowType == SHOW_BIG ){
                    CustomAdapter adapter=new CustomAdapter( this, data, getResources(), nType );
                    list1.setAdapter(adapter);
                    list2.setAdapter(adapter);
                }
                else {
                    CustomAdapter1 adapter=new CustomAdapter1( this, data, getResources(), nType );
                    list1.setAdapter(adapter);
                    list2.setAdapter(adapter);
                }

                lvMask1.setVisibility( View.VISIBLE );
                lvMask2.setVisibility( View.GONE );
                break;
            }
            case TYPE_RESERVATION:{

                MainActivity.global.nSelectType = MainActivity.global.TYPE_RESERVATION;

                txtDelivery.setTextColor( getResources().getColor( android.R.color.secondary_text_dark ));
                txtReservation.setTextColor( getResources().getColor( android.R.color.white ));
                txtPickup.setTextColor( getResources().getColor( android.R.color.secondary_text_dark ) );
                txtCatering.setTextColor( getResources().getColor( android.R.color.secondary_text_dark ));

                imgDelivery.setImageResource( R.drawable.md_delivery );
                imgReservation.setImageResource( R.drawable.md_reservation_sel );
                imgPickup.setImageResource( R.drawable.md_pickup );
                imgCatering.setImageResource( R.drawable.md_catering );

                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)imgDelivery.getLayoutParams();
                params.setMargins(0, 5, 0, 15); //substitute parameters for left, top, right, bottom
                imgDelivery.setLayoutParams(params);

                LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams)imgReservation.getLayoutParams();
                params1.setMargins(0, 5, 0, 5); //substitute parameters for left, top, right, bottom
                imgReservation.setLayoutParams(params1);

                LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams)imgPickup.getLayoutParams();
                params2.setMargins(0, 5, 0, 15); //substitute parameters for left, top, right, bottom
                imgPickup.setLayoutParams(params2);

                LinearLayout.LayoutParams params3 = (LinearLayout.LayoutParams)imgCatering.getLayoutParams();
                params3.setMargins(0, 5, 0, 15); //substitute parameters for left, top, right, bottom
                imgCatering.setLayoutParams(params3);

                reTopView.setBackgroundColor( getResources().getColor( R.color.colorRed ));
                imgSearchBg.setImageResource( R.drawable.btn_red );

                txtSearchBtn.setText(" SEARCH FOR RESERVATION");

                lvDateView.setVisibility( View.VISIBLE );
                lvDateView1.setVisibility( View.GONE );

                if ( nShowType == SHOW_BIG ){
                    CustomAdapter adapter=new CustomAdapter( this, data, getResources(), nType );
                    list1.setAdapter(adapter);
                    list2.setAdapter(adapter);
                }
                else {
                    CustomAdapter1 adapter=new CustomAdapter1( this, data, getResources(), nType );
                    list1.setAdapter(adapter);
                    list2.setAdapter(adapter);
                }

                lvMask2.setVisibility( View.VISIBLE );
                lvMask1.setVisibility( View.GONE );

                break;
            }
            case TYPE_PICKUP:{

                MainActivity.global.nSelectType = MainActivity.global.TYPE_PICKUP;

                txtDelivery.setTextColor( getResources().getColor( android.R.color.secondary_text_dark ));
                txtReservation.setTextColor( getResources().getColor( android.R.color.secondary_text_dark ));
                txtPickup.setTextColor( getResources().getColor( android.R.color.white ) );
                txtCatering.setTextColor( getResources().getColor( android.R.color.secondary_text_dark ));

                imgDelivery.setImageResource( R.drawable.md_delivery );
                imgReservation.setImageResource( R.drawable.md_reservation );
                imgPickup.setImageResource( R.drawable.md_pickup_sel );
                imgCatering.setImageResource( R.drawable.md_catering );

                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)imgDelivery.getLayoutParams();
                params.setMargins(0, 5, 0, 15); //substitute parameters for left, top, right, bottom
                imgDelivery.setLayoutParams(params);

                LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams)imgReservation.getLayoutParams();
                params1.setMargins(0, 5, 0, 15); //substitute parameters for left, top, right, bottom
                imgReservation.setLayoutParams(params1);

                LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams)imgPickup.getLayoutParams();
                params2.setMargins(0, 5, 0, 5); //substitute parameters for left, top, right, bottom
                imgPickup.setLayoutParams(params2);

                LinearLayout.LayoutParams params3 = (LinearLayout.LayoutParams)imgCatering.getLayoutParams();
                params3.setMargins(0, 5, 0, 15); //substitute parameters for left, top, right, bottom
                imgCatering.setLayoutParams(params3);

                reTopView.setBackgroundColor( getResources().getColor( R.color.colorBlue ));
                imgSearchBg.setImageResource( R.drawable.btn_blue );

                txtSearchBtn.setText(" SEARCH FOR PICKUP");

                lvDateView1.setVisibility( View.GONE );
                lvDateView.setVisibility( View.GONE );

                if ( nShowType == SHOW_BIG ){
                    CustomAdapter adapter=new CustomAdapter( this, data, getResources(), nType );
                    list1.setAdapter(adapter);
                    list2.setAdapter(adapter);
                }
                else {
                    CustomAdapter1 adapter=new CustomAdapter1( this, data, getResources(), nType );
                    list1.setAdapter(adapter);
                    list2.setAdapter(adapter);
                }

                lvMask1.setVisibility( View.VISIBLE );
                lvMask2.setVisibility( View.GONE );

                break;
            }
            case TYPE_CATERING:{

                MainActivity.global.nSelectType = MainActivity.global.TYPE_CATERING;

                txtDelivery.setTextColor( getResources().getColor( android.R.color.secondary_text_dark ));
                txtReservation.setTextColor( getResources().getColor( android.R.color.secondary_text_dark ));
                txtPickup.setTextColor( getResources().getColor( android.R.color.secondary_text_dark ) );
                txtCatering.setTextColor( getResources().getColor( android.R.color.white ));

                imgDelivery.setImageResource( R.drawable.md_delivery );
                imgReservation.setImageResource( R.drawable.md_reservation );
                imgPickup.setImageResource( R.drawable.md_pickup );
                imgCatering.setImageResource( R.drawable.md_catering_sel );

                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)imgDelivery.getLayoutParams();
                params.setMargins(0, 5, 0, 15); //substitute parameters for left, top, right, bottom
                imgDelivery.setLayoutParams(params);

                LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams)imgReservation.getLayoutParams();
                params1.setMargins(0, 5, 0, 15); //substitute parameters for left, top, right, bottom
                imgReservation.setLayoutParams(params1);

                LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams)imgPickup.getLayoutParams();
                params2.setMargins(0, 5, 0, 15); //substitute parameters for left, top, right, bottom
                imgPickup.setLayoutParams(params2);

                LinearLayout.LayoutParams params3 = (LinearLayout.LayoutParams)imgCatering.getLayoutParams();
                params3.setMargins(0, 5, 0, 5); //substitute parameters for left, top, right, bottom
                imgCatering.setLayoutParams(params3);

                reTopView.setBackgroundColor( getResources().getColor( R.color.colorOrange ));
                imgSearchBg.setImageResource( R.drawable.btn_orange );
                txtSearchBtn.setText(" SEARCH FOR CATERING");

                lvDateView.setVisibility( View.GONE );
                lvDateView1.setVisibility( View.VISIBLE );

                if ( nShowType == SHOW_BIG ){
                    CustomAdapter adapter=new CustomAdapter( this, data, getResources(), nType );
                    list1.setAdapter(adapter);
                    list2.setAdapter(adapter);
                }
                else {
                    CustomAdapter1 adapter=new CustomAdapter1( this, data, getResources(), nType );
                    list1.setAdapter(adapter);
                    list2.setAdapter(adapter);
                }

                lvMask2.setVisibility( View.VISIBLE );
                lvMask1.setVisibility( View.GONE );

                break;
            }
            default:
                break;
        }
    }

    private void setTempData()
    {

        for ( int i = 0; i < 10; i++ ) {
            ItemDelivery item = new ItemDelivery();
            item.title = "Pizza Hut" + i;
            item.description = "Pizza, American,\nInternational";
            item.location = "Abdulah Al-Salem";
            item.rate = 4;
            item.num = "(89234)";
            item.min = 0;
            item.duration = 60;
            item.fee = 0.5f;
            item.bOffer = true;
            item.status = 1;
            item.workingTime = "6:00AM - 5:00PM";

            data.add(item);
        }

    }

    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    public void showMenu(boolean fShow) {

        int height = 0;

        if ( nType == MainActivity.global.TYPE_DELIVERY )
            height = 260;
        else if ( nType == MainActivity.global.TYPE_PICKUP )
            height = 260;
        else if ( nType == MainActivity.global.TYPE_CATERING )
            height = 310;
        else if ( nType == MainActivity.global.TYPE_RESERVATION )
            height = 310;

        int delta  = (int)convertDpToPixel( height, this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        if (fShow) {
            lvDetailView.animate().translationYBy(-delta).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    bOpen = false;
                    list1.setVisibility( View.GONE );
                    list2.setVisibility( View.VISIBLE );
                }
            });
        } else {

            lvDetailView.animate().translationYBy(delta).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    bOpen = true;
                    list2.setVisibility( View.GONE );
                    list1.setVisibility( View.VISIBLE );
                }
            });
        }
    }

    public class CustomAdapter extends BaseAdapter implements View.OnClickListener {

        /*********** Declare Used Variables *********/
        private Activity activity;
        private LayoutInflater inflater=null;
        public Resources res;
        int i=0;
        int type = 0;

        /*************  CustomAdapter Constructor *****************/
        public CustomAdapter(Activity a, ArrayList d, Resources resLocal, int nType) {

            /********** Take passed values **********/
            activity = a;
            res = resLocal;
            type = nType;

            /***********  Layout inflator to call external xml layout () ***********/
            inflater = ( LayoutInflater )activity.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        /******** What is the size of Passed Arraylist Size ************/
        public int getCount() {
            return data.size() / 2;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        /********* Create a holder Class to contain inflated xml file elements *********/
        public  class ViewHolder{

            public TextView txtTitle1;
            public TextView txtDes1;
            public ImageView img1;
            public TextView txtLoc1;
            public TextView txtNum1;
            public TextView txtMin1;
            public TextView txtDur1;
            public TextView txtFee1;
            public TextView txtWorkingTime1;


            public TextView txtTitle2;
            public TextView txtDes2;
            public ImageView img2;
            public TextView txtLoc2;
            public TextView txtNum2;
            public TextView txtMin2;
            public TextView txtDur2;
            public TextView txtFee2;
            public TextView txtWorkingTime2;

        }

        /****** Depends upon data size called for each row , Create each ListView row *****/
        public View getView(int position, View convertView, ViewGroup parent) {
            View vi = convertView;
            ViewHolder holder;

            if ( type == TYPE_DELIVERY ) {
                if (convertView == null) {
                    /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
                    vi = inflater.inflate(R.layout.cell_delivery_detail, parent, false);
                    /****** View Holder Object to contain tabitem.xml file elements ******/
                    holder = new ViewHolder();

                    holder.txtTitle1 = (TextView) vi.findViewById(R.id.cell_delivery_txt_title1);
                    holder.txtDes1 = (TextView) vi.findViewById(R.id.cell_delivery_description1);
                    holder.img1 = (ImageView) vi.findViewById(R.id.cell_delivery_img1);
                    holder.txtLoc1 = (TextView) vi.findViewById(R.id.cell_delivery_loc1);
                    holder.txtNum1 = (TextView) vi.findViewById(R.id.cell_delivery_num1);
                    holder.txtMin1 = (TextView) vi.findViewById(R.id.cell_delivery_min1);
                    holder.txtDur1 = (TextView) vi.findViewById(R.id.cell_delivery_dur1);
                    holder.txtFee1 = (TextView) vi.findViewById(R.id.celll_delivery_fee1);
                    holder.txtWorkingTime1 = (TextView) vi.findViewById(R.id.cell_delivery_working_time1);

                    holder.txtTitle2 = (TextView) vi.findViewById(R.id.cell_delivery_txt_title2);
                    holder.txtDes2 = (TextView) vi.findViewById(R.id.cell_delivery_txt_description2);
                    holder.img2 = (ImageView) vi.findViewById(R.id.cell_delivery_img2);
                    holder.txtLoc2 = (TextView) vi.findViewById(R.id.cell_delivery_loc2);
                    holder.txtNum2 = (TextView) vi.findViewById(R.id.cell_delivery_num2);
                    holder.txtMin2 = (TextView) vi.findViewById(R.id.cell_delivery_min2);
                    holder.txtDur2 = (TextView) vi.findViewById(R.id.cell_delivery_dur2);
                    holder.txtFee2 = (TextView) vi.findViewById(R.id.cell_delivery_fee2);
                    holder.txtWorkingTime2 = (TextView) vi.findViewById(R.id.cell_delivery_working_time2);

                    /************  Set holder with LayoutInflater ************/
                    vi.setTag(holder);
                } else
                    holder = (ViewHolder) vi.getTag();

                ItemDelivery item1 = (ItemDelivery) data.get(position * 2);
                holder.txtTitle1.setText(item1.title);
                holder.txtDes1.setText(item1.description);
//            holder.img1;
                holder.txtLoc1.setText(item1.location);
                holder.txtNum1.setText(item1.num);
                holder.txtMin1.setText(String.format("KD %.4f", item1.min));
                holder.txtDur1.setText("" + (int) item1.duration + "mins");
                holder.txtFee1.setText(String.format("KD %.4f", item1.fee));
                holder.txtWorkingTime1.setText(item1.workingTime);


                ItemDelivery item2 = (ItemDelivery) data.get(position * 2 + 1);
                holder.txtTitle2.setText(item2.title);
                holder.txtDes2.setText(item2.description);
//            holder.img1;
                holder.txtLoc2.setText(item2.location);
                holder.txtNum2.setText(item2.num);
                holder.txtMin2.setText(String.format("KD %.4f", item2.min));
                holder.txtDur2.setText("" + (int) item2.duration + "mins");
                holder.txtFee2.setText(String.format("KD %.4f", item2.fee));
                holder.txtWorkingTime2.setText(item2.workingTime);

                vi.setOnClickListener(new CustomAdapter.OnItemClickListener(position));
            }
            else if ( type == TYPE_RESERVATION ){
                if (convertView == null) {
                    /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
                    vi = inflater.inflate(R.layout.cell_reservation_detail, parent, false);
                    /****** View Holder Object to contain tabitem.xml file elements ******/
                    holder = new ViewHolder();
                    /************  Set holder with LayoutInflater ************/
                    vi.setTag(holder);
                } else
                    holder = (ViewHolder) vi.getTag();


                vi.setOnClickListener(new CustomAdapter.OnItemClickListener(position));
            }
            else if ( type == TYPE_PICKUP ){
                if (convertView == null) {
                    /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
                    vi = inflater.inflate(R.layout.cell_pick_detail, parent, false);
                    /****** View Holder Object to contain tabitem.xml file elements ******/
                    holder = new ViewHolder();
                    /************  Set holder with LayoutInflater ************/
                    vi.setTag(holder);
                } else
                    holder = (ViewHolder) vi.getTag();


                vi.setOnClickListener(new CustomAdapter.OnItemClickListener(position));
            }
            else if( type  == TYPE_CATERING ){
                if (convertView == null) {
                    /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
                    vi = inflater.inflate(R.layout.cell_catering_detail, parent, false);
                    /****** View Holder Object to contain tabitem.xml file elements ******/
                    holder = new ViewHolder();
                    /************  Set holder with LayoutInflater ************/
                    vi.setTag(holder);
                } else
                    holder = (ViewHolder) vi.getTag();


                vi.setOnClickListener(new CustomAdapter.OnItemClickListener(position));
            }
            return vi;
        }

        @Override
        public void onClick(View v) {

        }
        /********* Called when Item click in ListView ************/
        private class OnItemClickListener  implements View.OnClickListener {
            private int mPosition;

            OnItemClickListener(int position){
                mPosition = position;

            }

            @Override
            public void onClick(View arg0) {

                if ( type == TYPE_DELIVERY ) {
                    Intent intent = new Intent(DeliveryRestaurantActivity.this, DeliveryDetailActivity.class);
                    startActivity(intent);
                }
                else if ( type == TYPE_RESERVATION ){
                    Intent intent = new Intent(DeliveryRestaurantActivity.this, ReservationDetailActivity.class);
                    startActivity(intent);
                }
                else if ( type == TYPE_PICKUP ){
                    Intent intent  = new Intent( DeliveryRestaurantActivity.this, PickDetailActivity.class );
                    startActivity( intent );
                }
                else if ( type == TYPE_CATERING ){
                    Intent intent  = new Intent( DeliveryRestaurantActivity.this, CateringDetailActivity.class );
                    startActivity( intent );
                }
            }
        }
    }

    public class CustomAdapter1 extends BaseAdapter implements View.OnClickListener {

        /*********** Declare Used Variables *********/
        private Activity activity;
        private LayoutInflater inflater=null;
        public Resources res;
        int i=0;
        int type = 1;

        /*************  CustomAdapter Constructor *****************/
        public CustomAdapter1(Activity a, ArrayList d, Resources resLocal, int nType) {

            /********** Take passed values **********/
            activity = a;
            res = resLocal;
            type = nType;

            /***********  Layout inflator to call external xml layout () ***********/
            inflater = ( LayoutInflater )activity.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        /******** What is the size of Passed Arraylist Size ************/
        public int getCount() {
            return data.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        /********* Create a holder Class to contain inflated xml file elements *********/
        public  class ViewHolder{

            public TextView txtTitle1;
            public TextView txtDes1;
            public ImageView img1;
            public TextView txtLoc1;
            public TextView txtNum1;
            public TextView txtMin1;
            public TextView txtDur1;
            public TextView txtFee1;
            public TextView txtWorkingTime1;

        }

        /****** Depends upon data size called for each row , Create each ListView row *****/
        public View getView(int position, View convertView, ViewGroup parent) {
            View vi = convertView;
            ViewHolder holder;
            if ( type == TYPE_DELIVERY ) {
                if (convertView == null) {
                    /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
                    vi = inflater.inflate(R.layout.cell_delivery, parent, false);
                    /****** View Holder Object to contain tabitem.xml file elements ******/
                    holder = new ViewHolder();

                    holder.txtTitle1 = (TextView) vi.findViewById(R.id.title);
                    holder.txtDes1 = (TextView) vi.findViewById(R.id.subTitle);
                    holder.img1 = (ImageView) vi.findViewById(R.id.img);
                    holder.txtLoc1 = (TextView) vi.findViewById(R.id.location);
                    holder.txtNum1 = (TextView) vi.findViewById(R.id.num);
                    holder.txtMin1 = (TextView) vi.findViewById(R.id.min);
                    holder.txtDur1 = (TextView) vi.findViewById(R.id.time);
                    holder.txtFee1 = (TextView) vi.findViewById(R.id.fee);
                    holder.txtWorkingTime1 = (TextView) vi.findViewById(R.id.workingTime);

                    /************  Set holder with LayoutInflater ************/
                    vi.setTag(holder);
                } else
                    holder = (ViewHolder) vi.getTag();

                ItemDelivery item1 = (ItemDelivery) data.get(position);
                holder.txtTitle1.setText(item1.title);
                holder.txtDes1.setText(item1.description);
                holder.txtLoc1.setText(item1.location);
                holder.txtNum1.setText(item1.num);
                holder.txtMin1.setText(String.format("KD %.4f", item1.min));
                holder.txtDur1.setText("" + (int) item1.duration + "mins");
                holder.txtFee1.setText(String.format("KD %.4f", item1.fee));
                holder.txtWorkingTime1.setText(item1.workingTime);

                vi.setOnClickListener(new CustomAdapter1.OnItemClickListener(position));
            }
            else if ( type == TYPE_RESERVATION ){
                if (convertView == null) {
                    /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
                    vi = inflater.inflate(R.layout.cell_reservation_custom, parent, false);
                    /****** View Holder Object to contain tabitem.xml file elements ******/
                    holder = new ViewHolder();

                    /************  Set holder with LayoutInflater ************/
                    vi.setTag(holder);
                } else
                    holder = (ViewHolder) vi.getTag();

                vi.setOnClickListener(new CustomAdapter1.OnItemClickListener(position));
            }
            else if ( type == TYPE_PICKUP ){
                if (convertView == null) {
                    /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
                    vi = inflater.inflate(R.layout.cell_pick_custom, parent, false);
                    /****** View Holder Object to contain tabitem.xml file elements ******/
                    holder = new ViewHolder();

                    /************  Set holder with LayoutInflater ************/
                    vi.setTag(holder);
                } else
                    holder = (ViewHolder) vi.getTag();

                vi.setOnClickListener(new CustomAdapter1.OnItemClickListener(position));
            }
            else if ( type == TYPE_CATERING ){
                if (convertView == null) {
                    /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
                    vi = inflater.inflate(R.layout.cell_catering_custom, parent, false);
                    /****** View Holder Object to contain tabitem.xml file elements ******/
                    holder = new ViewHolder();

                    /************  Set holder with LayoutInflater ************/
                    vi.setTag(holder);
                } else
                    holder = (ViewHolder) vi.getTag();

                vi.setOnClickListener(new CustomAdapter1.OnItemClickListener(position));
            }
            return vi;
        }

        @Override
        public void onClick(View v) {

        }
        /********* Called when Item click in ListView ************/
        private class OnItemClickListener  implements View.OnClickListener {
            private int mPosition;

            OnItemClickListener(int position){
                mPosition = position;
            }

            @Override
            public void onClick(View arg0) {

                if ( type == TYPE_DELIVERY ) {
                    Intent intent = new Intent(DeliveryRestaurantActivity.this, DeliveryDetailActivity.class);
                    startActivity(intent);
                }
                else if ( type == TYPE_RESERVATION ){
                    Intent intent = new Intent(DeliveryRestaurantActivity.this, ReservationDetailActivity.class);
                    startActivity(intent);
                }
                else if ( type == TYPE_PICKUP ){
                    Intent intent  = new Intent( DeliveryRestaurantActivity.this, PickDetailActivity.class );
                    startActivity( intent );
                }
                else if ( type == TYPE_CATERING ){
                    Intent intent  = new Intent( DeliveryRestaurantActivity.this, CateringDetailActivity.class );
                    startActivity( intent );
                }

            }
        }
    }

}
