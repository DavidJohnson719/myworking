package mataam.com.mataam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class OrderSummaryActivity extends Activity implements View.OnClickListener{

    RelativeLayout reTopView;

    ImageView      imgLoc;
    ImageView      imgStar1, imgStar2, imgStar3, imgStar4, imgStar5;
    ImageView       imgBottomBtn;
    TextView        txtEdit;
    LinearLayout    lvBack;

    ListView list;
    RelativeLayout reBottom;
    boolean bEdit = false;
    int num  = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        lvBack = (LinearLayout) findViewById( R.id.order_back );
        lvBack.setOnClickListener( this );
        list = (ListView) findViewById( R.id.order_list) ;
        reBottom = (RelativeLayout) findViewById( R.id.order_bottom_view );
        reBottom.setOnClickListener(this);

        reTopView = (RelativeLayout) findViewById( R.id.order_topView );
        imgLoc = (ImageView) findViewById( R.id.img_loc );
        imgLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        imgStar1 = (ImageView) findViewById( R.id.img_star1 );
        imgStar2 = (ImageView) findViewById( R.id.img_star2 );
        imgStar3 = (ImageView) findViewById( R.id.img_star3 );
        imgStar4 = (ImageView) findViewById( R.id.img_star4 );
        imgStar5 = (ImageView) findViewById( R.id.img_star5 );
        imgBottomBtn = (ImageView) findViewById( R.id.bottom_img );

        txtEdit = (TextView) findViewById( R.id.order_edit );
        txtEdit.setOnClickListener(this);

        setUI();

        CustomAdapter adapter=new CustomAdapter( this, null, getResources() );
        list.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.order_back:{
                finish();
                break;
            }
            case R.id.order_bottom_view: {
                Intent  intent = new Intent( OrderSummaryActivity.this, CheckoutActivity.class );
                startActivity( intent );
                break;
            }
            case R.id.order_edit:{
                bEdit = !bEdit;

                if ( bEdit )
                    txtEdit.setText("Done");
                else
                    txtEdit.setText("Edit");
                CustomAdapter adapter = (CustomAdapter)list.getAdapter();
               list.setAdapter( adapter );
                break;
            }

        }
    }

    private  void setUI()
    {
        int type = MainActivity.global.nSelectType;
        if( type == MainActivity.global.TYPE_DELIVERY ){
            reTopView.setBackgroundColor( getResources().getColor( R.color.colorGreen ));
            imgLoc.setImageResource( R.drawable.loc_green );
            imgStar1.setImageResource( R.drawable.star_green );
            imgStar2.setImageResource( R.drawable.star_green );
            imgStar3.setImageResource( R.drawable.star_green );
            imgStar4.setImageResource( R.drawable.star_green );
            imgStar5.setImageResource( R.drawable.star_green );
            imgBottomBtn.setImageResource( R.drawable.btn_green );
        }
        else if ( type == MainActivity.global.TYPE_RESERVATION ){
            reTopView.setBackgroundColor( getResources().getColor( R.color.colorRed ));
            imgLoc.setImageResource( R.drawable.loc_red );
            imgStar1.setImageResource( R.drawable.star_red );
            imgStar2.setImageResource( R.drawable.star_red );
            imgStar3.setImageResource( R.drawable.star_red );
            imgStar4.setImageResource( R.drawable.star_red );
            imgStar5.setImageResource( R.drawable.star_red );
            imgBottomBtn.setImageResource( R.drawable.btn_red );
        }
        else if ( type == MainActivity.global.TYPE_PICKUP ){
            reTopView.setBackgroundColor( getResources().getColor( R.color.colorBlue ));
            imgLoc.setImageResource( R.drawable.loc_blue );
            imgStar1.setImageResource( R.drawable.star_blue );
            imgStar2.setImageResource( R.drawable.star_blue );
            imgStar3.setImageResource( R.drawable.star_blue );
            imgStar4.setImageResource( R.drawable.star_blue );
            imgStar5.setImageResource( R.drawable.star_blue );
            imgBottomBtn.setImageResource( R.drawable.btn_blue );
        }
        else if ( type == MainActivity.global.TYPE_CATERING ){
            reTopView.setBackgroundColor( getResources().getColor( R.color.colorOrange ));
            imgLoc.setImageResource( R.drawable.loc_orange );
            imgStar1.setImageResource( R.drawable.star_orange );
            imgStar2.setImageResource( R.drawable.star_orange );
            imgStar3.setImageResource( R.drawable.star_orange );
            imgStar4.setImageResource( R.drawable.star_orange );
            imgStar5.setImageResource( R.drawable.star_orange );
            imgBottomBtn.setImageResource( R.drawable.btn_orange );
        }
    }


    private void setTempData(){

    }

    private void refresh(){
        CustomAdapter adapter=new CustomAdapter( this, null, getResources() );
        list.setAdapter(adapter);
    }

    public class CustomAdapter extends BaseAdapter implements View.OnClickListener {

        /*********** Declare Used Variables *********/
        private Activity activity;
        private LayoutInflater inflater=null;
        public Resources res;
        int i=0;

        /*************  CustomAdapter Constructor *****************/
        public CustomAdapter(Activity a, ArrayList d, Resources resLocal) {

            /********** Take passed values **********/
            activity = a;
            res = resLocal;

            /***********  Layout inflator to call external xml layout () ***********/
            inflater = ( LayoutInflater )activity.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        /******** What is the size of Passed Arraylist Size ************/
        public int getCount() {
            return  num;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        /********* Create a holder Class to contain inflated xml file elements *********/
        public  class ViewHolder{

            public LinearLayout lvMinus;
            public LinearLayout lvAdd;
            public ImageView imgRemove;
            public TextView  txtQuantityNum;
        }

        /****** Depends upon data size called for each row , Create each ListView row *****/
        public View getView(int position, View convertView, ViewGroup parent) {
            View vi = convertView;
            ViewHolder holder;
            if(convertView==null){
                /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
                vi = inflater.inflate(R.layout.cell_order_summary_item1, parent, false);
                holder = new ViewHolder();

                holder.imgRemove = (ImageView) vi.findViewById( R.id.img_remove );
                holder.lvMinus = (LinearLayout) vi.findViewById( R.id.lv_minus );
                holder.lvAdd = (LinearLayout) vi.findViewById( R.id.lv_add );
                holder.txtQuantityNum = (TextView) vi.findViewById( R.id.txt_quantity_num );

                if ( !bEdit )
                    holder.imgRemove.setVisibility( View.GONE );
                else
                    holder.imgRemove.setVisibility( View.VISIBLE );

                holder.imgRemove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        num --;
                        if ( num < 0 )  num = 0;
                        OrderSummaryActivity main  = (OrderSummaryActivity) activity;
                        main.refresh();
                    }
                });
            }
            else
                holder=(ViewHolder)vi.getTag();

            vi.setOnClickListener(new OnItemClickListener(position));
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

            }
        }
    }
}
