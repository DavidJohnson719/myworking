package mataam.com.mataam;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
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

public class MyReservationActivity extends Activity {

    LinearLayout lvBack;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reservation);

        lvBack = (LinearLayout) findViewById( R.id.reservation_back );
        lvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        list = (ListView) findViewById( R.id.reservation_list );

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
        public CustomAdapter(Activity a, ArrayList d, Resources resLocal ) {

            /********** Take passed values **********/
            activity = a;
            res = resLocal;


            /***********  Layout inflator to call external xml layout () ***********/
            inflater = ( LayoutInflater )activity.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        /******** What is the size of Passed Arraylist Size ************/
        public int getCount() {
            return 10;
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

            if (convertView == null) {
                /****** Inflate tabitem.xml file for each row ( Defined below ) *******/

                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                final int width = displayMetrics.widthPixels;
                int height = (int) convertDpToPixel(210, activity);
                int delta = (int) convertDpToPixel(111, activity);


                holder = new ViewHolder();
                if ( position == 2 ) {
                    vi = inflater.inflate(R.layout.cell_order1, parent, false);
                    /****** View Holder Object to contain tabitem.xml file elements ******/
                    LinearLayout lvMain = (LinearLayout) vi.findViewById(R.id.cell_order_main);
                    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                            width, height
                    );
                    lp.setMargins( -delta, 0,0,0);
                    lvMain.setLayoutParams(lp);
                }
                else if ( position == 3 ){
                    vi = inflater.inflate(R.layout.cell_order2, parent, false);
                    /****** View Holder Object to contain tabitem.xml file elements ******/
                    LinearLayout lvMain = (LinearLayout) vi.findViewById(R.id.cell_order_main);
                    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                            width, height
                    );
                    lp.setMargins( -delta*2, 0,0,0);
                    lvMain.setLayoutParams(lp);
                }
                else if ( position == 4 ){
                    vi = inflater.inflate(R.layout.cell_order3, parent, false);
                    /****** View Holder Object to contain tabitem.xml file elements ******/
                    LinearLayout lvMain = (LinearLayout) vi.findViewById(R.id.cell_order_main);

                    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                            width, height
                    );
                    lp.setMargins( -delta*3, 0,0,0);
                    lvMain.setLayoutParams(lp);

                    LinearLayout lvBtn = (LinearLayout) vi.findViewById( R.id.lv_btn );
                    RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams(
                            delta*3, height
                    );
                    lp1.setMargins( width - delta*3, 0,0,0);
                    lvBtn.setLayoutParams(lp1);

                }
                else {
                    vi = inflater.inflate(R.layout.cell_order, parent, false);
                    /****** View Holder Object to contain tabitem.xml file elements ******/
                    LinearLayout lvMain = (LinearLayout) vi.findViewById(R.id.cell_order_main);
                    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                            width, height
                    );
                    lvMain.setLayoutParams(lp);
                }

                /************  Set holder with LayoutInflater ************/
                vi.setTag(holder);
            } else
                holder = (ViewHolder) vi.getTag();

            vi.setOnClickListener(new CustomAdapter.OnItemClickListener(position));


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

    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }
}
