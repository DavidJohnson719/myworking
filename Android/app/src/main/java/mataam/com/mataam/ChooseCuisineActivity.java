package mataam.com.mataam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ChooseCuisineActivity extends Activity implements View.OnClickListener{

    EditText txtSearch;
    ListView list;
    LinearLayout lvApply;
    LinearLayout lvCancel;

    ArrayList< Map<String, Object>> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_cuisine);

        txtSearch = (EditText) findViewById( R.id.choose_cuisine_txt_search );
        list = (ListView) findViewById( R.id.choose_cuisine_list );
        lvApply = (LinearLayout) findViewById( R.id.chooses_cuisine_lv_apply );
        lvApply.setOnClickListener( this );
        lvCancel = (LinearLayout) findViewById( R.id.choose_cuisine_lv_cancel );
        lvCancel.setOnClickListener( this );
        setTempData();

        CustomAdapter adapter=new CustomAdapter( this, data, getResources() );
        list.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chooses_cuisine_lv_apply:
            {
               finish();
            }
            break;
            case R.id.choose_cuisine_lv_cancel: {
                finish();
            }
            break;
            default:
                break;
        }
    }

    private void  refresh(){
        CustomAdapter adapter = (CustomAdapter )list.getAdapter();
        adapter.notifyDataSetChanged();
    }
    private void setTempData()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("string", "All (94)" );
        map.put("check", true );
        data.add( map );
        Map<String, Object> map1 = new HashMap<>();
        map1.put("string", "American (10)" );
        map1.put("check", false );
        data.add( map1 );
        Map<String, Object> map2 = new HashMap<>();
        map2.put("string", "Arabic (16)"  );
        map2.put("check", false );
        data.add( map2 );

        Map<String, Object> map3 = new HashMap<>();
        map3.put("string", "Asian (12)"  );
        map3.put("check", false );
        data.add( map3 );

        Map<String, Object> map4 = new HashMap<>();
        map4.put("string", "Beverages (4)" );
        map4.put("check", false );
        data.add( map4 );

        Map<String, Object> map5 = new HashMap<>();
        map5.put("string", "Breakfast (14)" );
        map5.put("check", false );
        data.add( map5 );

        Map<String, Object> map6 = new HashMap<>();
        map6.put("string", "Cafe (5)" );
        map6.put("check", false );
        data.add( map6 );

        Map<String, Object> map7 = new HashMap<>();
        map7.put("string", "Chinese (11)"  );
        map7.put("check", false );
        data.add( map7 );

        Map<String, Object> map8 = new HashMap<>();
        map8.put("string", "Desserts (34)"  );
        map8.put("check", false );
        data.add( map8 );

        Map<String, Object> map9 = new HashMap<>();
        map9.put("string", "All (94)"  );
        map9.put("check", false );
        data.add( map9 );

        Map<String, Object> map10 = new HashMap<>();
        map10.put("string", "American (10)" );
        map10.put("check", false );
        data.add( map10 );

        Map<String, Object> map11 = new HashMap<>();
        map11.put("string", "Arabic (16)" );
        map11.put("check", false );
        data.add( map11 );

        Map<String, Object> map12 = new HashMap<>();
        map12.put("string", "Asian (12)" );
        map12.put("check", false );
        data.add( map12 );

        Map<String, Object> map13 = new HashMap<>();
        map13.put("string", "Beverages (4)" );
        map13.put("check", false );
        data.add( map13 );

        Map<String, Object> map14 = new HashMap<>();
        map14.put("string", "Breakfast (14)" );
        map14.put("check", false );
        data.add( map14);

        Map<String, Object> map15 = new HashMap<>();
        map15.put("string", "Burgers (8)" );
        map15.put("check", false );
        data.add( map15);

        Map<String, Object> map16 = new HashMap<>();
        map16.put("string", "Cafe (5)" );
        map16.put("check", false );
        data.add( map16 );

        Map<String, Object> map17 = new HashMap<>();
        map17.put("string", "Chinese (11)"  );
        map17.put("check", false );
        data.add( map17 );

        Map<String, Object> map18 = new HashMap<>();
        map18.put("string", "Desserts (34)"  );
        map18.put("check", false );
        data.add( map18 );
    }

    /********* Adapter class extends with BaseAdapter and implements with OnClickListener ************/
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

            public TextView txt1;
            public TextView txt2;
            public ImageView img1;
            public ImageView img2;
            public LinearLayout lv1;
            public LinearLayout lv2;
        }

        /****** Depends upon data size called for each row , Create each ListView row *****/
        public View getView(int position, View convertView, ViewGroup parent) {
            View vi = convertView;
            ViewHolder holder;
            if(convertView==null){
                /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
                vi = inflater.inflate(R.layout.cell_choose_cuisine, parent, false);
                /****** View Holder Object to contain tabitem.xml file elements ******/
                holder = new ViewHolder();
                holder.txt1 = (TextView) vi.findViewById(R.id.cell_cusine_txt1);
                holder.txt2 =(TextView)vi.findViewById(R.id.cell_cusine_txt2);
                holder.img1 =(ImageView) vi.findViewById(R.id.cell_cusine_img1);
                holder.img2 = (ImageView)vi.findViewById(R.id.cell_cusine_img2);
                holder.lv1 = (LinearLayout) vi.findViewById( R.id.cell_cusine_lv1 );
                holder.lv2 = (LinearLayout) vi.findViewById( R.id.cell_cusine_lv2 );
                /************  Set holder with LayoutInflater ************/
                vi.setTag( holder );
            }
            else
                holder=(ViewHolder)vi.getTag();

            Map<String, Object> map1  = (Map<String, Object>) data.get( position * 2 );
            Map<String, Object> map2  = (Map<String, Object>) data.get( position * 2 + 1 );

            holder.txt1.setText( (String)map1.get("string") );
            holder.lv1.setTag( position * 2); holder.lv1.setClickable( true );
            holder.lv2.setTag( position * 2 + 1); holder.lv2.setClickable( true );

            boolean flag  = (boolean)map1.get("check" );
            if ( flag )
                holder.img1.setImageResource( R.drawable.check_green );
            else
                holder.img1.setImageResource( R.drawable.check_no);

            holder.txt2.setText( (String)map2.get("string") );
            flag  = (boolean)map2.get("check" );
            if ( flag )
                holder.img2.setImageResource( R.drawable.check_green );
            else
                holder.img2.setImageResource( R.drawable.check_no );



            holder.lv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = (int)v.getTag();
                    Map<String, Object> map = (Map<String, Object>)data.get( pos );
                    boolean flag = (boolean) map.get("check");
                    flag = !flag;
                    map.put("check", flag );
                    ChooseCuisineActivity mainActivity  = (ChooseCuisineActivity) activity;
                    mainActivity.refresh();
                }
            });

            holder.lv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = (int)v.getTag();
                    Map<String, Object> map = (Map<String, Object>)data.get( pos );
                    boolean flag = (boolean) map.get("check");
                    flag = !flag;
                    map.put("check", flag );
                    ChooseCuisineActivity mainActivity  = (ChooseCuisineActivity) activity;
                    mainActivity.refresh();
                }
            });

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

//                CustomListViewAndroidExample sct = (CustomListViewAndroidExample)activity;
//
//                /****  Call  onItemClick Method inside CustomListViewAndroidExample Class ( See Below )****/
//
//                sct.onItemClick(mPosition);
            }
        }
    }


}
