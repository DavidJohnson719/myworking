package mataam.com.mataam;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class PlaceActivity extends Activity {

    LinearLayout lvBack;
    ListView     list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        lvBack = (LinearLayout) findViewById( R.id.place_back );
        lvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        list   = (ListView) findViewById( R.id.list );

        reviewAdapter adapter=new reviewAdapter( this, null, getResources() );
        list.setAdapter(adapter);
    }

    public class reviewAdapter extends BaseAdapter implements View.OnClickListener {

        /*********** Declare Used Variables *********/
        private Activity activity;
        private LayoutInflater inflater=null;
        public Resources res;
        int i=0;

        /*************  CustomAdapter Constructor *****************/
        public reviewAdapter(Activity a, ArrayList d, Resources resLocal) {

            /********** Take passed values **********/
            activity = a;
            res = resLocal;

            /***********  Layout inflator to call external xml layout () ***********/
            inflater = ( LayoutInflater )activity.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        /******** What is the size of Passed Arraylist Size ************/
        public int getCount() {
            return 10 ;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        /********* Create a holder Class to contain inflated xml file elements *********/
        public  class ViewHolder{

            public TextView txtName;
            public TextView txtDate;
            public TextView txtDescription;

        }

        /****** Depends upon data size called for each row , Create each ListView row *****/
        public View getView(int position, View convertView, ViewGroup parent) {
            View vi = convertView;
            ViewHolder holder;
            if(convertView==null){
                /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
                vi = inflater.inflate(R.layout.cell_place, parent, false);
                /****** View Holder Object to contain tabitem.xml file elements ******/
                holder = new ViewHolder();

                /************  Set holder with LayoutInflater ************/
                vi.setTag( holder );
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

//                CustomListViewAndroidExample sct = (CustomListViewAndroidExample)activity;
//
//                /****  Call  onItemClick Method inside CustomListViewAndroidExample Class ( See Below )****/
//
//                sct.onItemClick(mPosition);
            }
        }
    }
}
