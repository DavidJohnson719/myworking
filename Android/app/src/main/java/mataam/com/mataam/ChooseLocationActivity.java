package mataam.com.mataam;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChooseLocationActivity extends Activity implements View.OnClickListener{

    EditText txtSearch;
    ListView list;
    LinearLayout lvApply;
    LinearLayout lvCancel;

    SimpleAdapter adapter;

    ArrayList<Map<String, Object>> data  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_location2);

        txtSearch = (EditText) findViewById( R.id.cell_loc_txt_search );
        list = (ListView) findViewById( R.id.cell_loc_list );
        lvApply = (LinearLayout) findViewById( R.id.cell_loc_lv_apply );
        lvApply.setOnClickListener( this );
        lvCancel = (LinearLayout) findViewById( R.id.cell_loc_lv_cancel );
        lvCancel.setOnClickListener( this );

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = (Item)list.getAdapter().getItem(position);
                int section = item.sectionPosition;
                int row  = item.row;

                if (item.type == Item.SECTION )
                    return;
                Map<String, Object> map = (Map<String, Object>) data.get( section );
                ArrayList<Map<String, Object>> arr = ( ArrayList<Map<String,Object>> ) map.get("data");
                for ( int i = 0; i < arr.size(); i++ ) {
                    Map<String, Object> subMap = (Map<String, Object>) arr.get(i);
                    subMap.put("check", false);
                }
                Map<String, Object> subMap = (Map<String, Object>) arr.get(row);
                subMap.put("check", true);

                map.put("Loc", (String)subMap.get("city") );
                refresh();
            }
        });


        setTempData();
        initializeAdapter();
    }

    private void setTempData()
    {

// section 1
        ArrayList<Map<String, Object>> arr = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("city", "Ahmadi" );
        map1.put("check", false );
        arr.add( map1 );

        Map<String, Object> map2 = new HashMap<>();
        map2.put("city", "Abu Halifa" );
        map2.put("check", false );
        arr.add( map2 );

        Map<String, Object> map3 = new HashMap<>();
        map3.put("city", "Al Julayah - Az Zour Sulah" );
        map3.put("check", false );
        arr.add( map3 );

        Map<String, Object> map4 = new HashMap<>();
        map4.put("city", "Al Ahamad" );
        map4.put("check", false );
        arr.add( map4 );

        Map<String, Object> map5 = new HashMap<>();
        map5.put("city", "Ali Sabah Al-Salem - Umm Al Hayman" );
        map5.put("check", false );
        arr.add( map5 );

        Map<String, Object> map6 = new HashMap<>();
        map6.put("city", "East Al Ahmadi" );
        map6.put("check", false );
        arr.add( map6 );

        Map<String, Object> tempArr  = new HashMap<>();
        tempArr.put("Loc", "Kuwait City");
        tempArr.put("data", arr );
        tempArr.put("extend", false );

        data.add( tempArr );

// section 2
        ArrayList<Map<String, Object>> arr1 = new ArrayList<>();
        Map<String, Object> map11 = new HashMap<>();
        map11.put("city", "Ahmadi" );
        map11.put("check", false );
        arr1.add( map11 );

        Map<String, Object> map12 = new HashMap<>();
        map12.put("city", "Abu Halifa" );
        map12.put("check", false );
        arr1.add( map12 );

        Map<String, Object> map13 = new HashMap<>();
        map13.put("city", "Al Julayah - Az Zour Sulah" );
        map13.put("check", false );
        arr1.add( map13 );

        Map<String, Object> map14 = new HashMap<>();
        map14.put("city", "Al Ahamad" );
        map14.put("check", false );
        arr1.add( map14 );

        Map<String, Object> map15 = new HashMap<>();
        map15.put("city", "Ali Sabah Al-Salem - Umm Al Hayman" );
        map15.put("check", false );
        arr1.add( map15 );

        Map<String, Object> map16 = new HashMap<>();
        map16.put("city", "East Al Ahmadi" );
        map16.put("check", false );
        arr1.add( map16 );

        Map<String, Object> tempArr1  = new HashMap<>();
        tempArr1.put("Loc", "Hawally");
        tempArr1.put("data", arr1 );
        tempArr1.put("extend", false );

        data.add( tempArr1 );


// section 3
        ArrayList<Map<String, Object>> arr2 = new ArrayList<>();
        Map<String, Object> map21 = new HashMap<>();
        map21.put("city", "Ahmadi" );
        map21.put("check", false );
        arr2.add( map21 );

        Map<String, Object> map22 = new HashMap<>();
        map22.put("city", "Abu Halifa" );
        map22.put("check", false );
        arr2.add( map22 );

        Map<String, Object> map23 = new HashMap<>();
        map23.put("city", "Al Julayah - Az Zour Sulah" );
        map23.put("check", false );
        arr1.add( map23 );

        Map<String, Object> map24 = new HashMap<>();
        map24.put("city", "Al Ahamad" );
        map24.put("check", false );
        arr1.add( map24 );

        Map<String, Object> map25 = new HashMap<>();
        map25.put("city", "Ali Sabah Al-Salem - Umm Al Hayman" );
        map25.put("check", false );
        arr1.add( map25 );

        Map<String, Object> map26 = new HashMap<>();
        map26.put("city", "East Al Ahmadi" );
        map26.put("check", false );
        arr2.add( map26 );

        Map<String, Object> tempArr2  = new HashMap<>();
        tempArr2.put("Loc", "Kuwait City");
        tempArr2.put("data", arr1 );
        tempArr2.put("extend", true );

        data.add( tempArr2 );
    }

    private void  refresh()
    {
        adapter.notifyDataSetChanged();
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cell_loc_lv_apply:{
               finish();
            }
            break;
            case R.id.cell_loc_lv_cancel: {
              finish();
            }
            break;
            default:
                break;
        }
    }

    static class SimpleAdapter extends ArrayAdapter<Item> implements PinnedSectionListView.PinnedSectionListAdapter
    {
        List<Object> mItems;
        ArrayList<Map<String, Object>> mData = null;
        public boolean bType = false;
        Context mCtx;

        public SimpleAdapter(Context context, int resource, int textViewResourceId, ArrayList<Map<String, Object>> aryStores, int sectionNum, boolean flag ) {
            super(context, resource, textViewResourceId);
            bType = flag;
            mCtx = context;
            mData = aryStores;
            mItems = new ArrayList<Object>();
            generateDataset( sectionNum );
        }

        public void generateDataset(int sectionNum) {

            final int sectionsNumber = sectionNum;
            prepareSections(sectionsNumber);

            int sectionPosition = 0, listPosition = 0;
            for (int i=0; i<sectionsNumber; i++) {
                int row = 0;
                Item section = new Item(Item.SECTION, "", "" , "");
                section.sectionPosition = sectionPosition;
                section.listPosition = listPosition++;
                onSectionAdded(section, sectionPosition);
                add(section);

                int itemsNumber = numberOfRowsInSection(i);

                for (int j=0;j<itemsNumber;j++) {
                    Item item = new Item(Item.ITEM, "", "", ""  );
                    item.sectionPosition = sectionPosition;
                    item.listPosition = listPosition++;
                    item.row = row; row ++;
                    add(item);
                }
                sectionPosition++;
            }
        }

        protected void prepareSections(int sectionsNumber) { }
        protected void onSectionAdded(Item section, int sectionPosition) { }

        @Override public View getView(int position, View convertView, ViewGroup parent) {
            View retval = null;
            Item item = getItem(position);
            int section = item.sectionPosition;
            int row  = item.row;

            if (item.type == Item.SECTION) {
                retval = LayoutInflater.from( parent.getContext()).inflate(R.layout.cell_section, null);
                TextView title = (TextView)retval.findViewById(R.id.cell_section_txt);
                LinearLayout btn = (LinearLayout)retval.findViewById(R.id.cell_section_lv_btn);
                ImageView img  = (ImageView) retval.findViewById( R.id.cell_section_img );
                ImageView lvMain  = (ImageView) retval.findViewById( R.id.cell_lv_section );
                btn.setTag( section );

                btn.setClickable( true );
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int tag  = (int)v.getTag();
                        Map<String, Object> map = (Map<String, Object>) mData.get( tag );
                        boolean flag  = (boolean) map.get("extend");
                        flag = !flag;
                        map.put("extend", flag );
                        ChooseLocationActivity main  = (ChooseLocationActivity) mCtx;
                        main.initializeAdapter();
                    }
                });

                Map<String, Object> map = (Map<String, Object>) mData.get( section );
                String cityName  = (String) map.get("Loc");
                title.setText( cityName  );
                boolean bCheck  = (boolean) map.get("extend");
                if ( bCheck ) {
                    img.setImageResource(R.drawable.directtop_white);
                    lvMain.setImageResource( R.drawable.section_bg_sel_green );
                    title.setTextColor( mCtx.getResources().getColor( R.color.background_color) );
                }
                else {
                    img.setImageResource(R.drawable.directbottomb3x);
                    lvMain.setImageResource( R.drawable.section_bg );
                    title.setTextColor( mCtx.getResources().getColor( R.color.text_color)  );
                }
            }
            else {
                retval = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_choose_location, null);
                ImageView img  = (ImageView) retval.findViewById( R.id.cell_loc_img );
                TextView txt = (TextView) retval.findViewById( R.id.cell_loc_txt );

                Map<String, Object> map = (Map<String, Object>) mData.get( section );
                ArrayList<Map<String, Object>> arr = ( ArrayList<Map<String,Object>> ) map.get("data");
                Map<String, Object> subMap = ( Map<String, Object> ) arr.get( row );

                txt.setText( (String) subMap.get("city") );
                boolean  flag  = (boolean) subMap.get("check" );
                if ( flag )
                    img.setImageResource( R.drawable.check_green);
                else
                    img.setImageResource( R.drawable.check_no);
            }
            return retval;
        }

        @Override public int getViewTypeCount() {
            return 2;
        }

        @Override public int getItemViewType(int position) {
            return getItem(position).type;
        }

        @Override
        public boolean isItemViewTypePinned(int viewType) {
            return viewType == Item.SECTION;
        }


        public int numberOfRowsInSection(int section){

            Map<String, Object> map = mData.get( section );
            ArrayList<String> arr = (ArrayList<String>) map.get("data");
            boolean bExtend  = (boolean) map.get("extend");
            int ret  = 0;
            if ( bExtend )
                ret = arr.size();
            return ret;
        }

        public void addAll() {
            for ( int i = 0; i < mItems.size(); i++ ) {
                Item item = (Item)mItems.get( i );
                remove(item);
            }
            mItems.clear();
            super.notifyDataSetChanged();
        }

    }

    static class Item {

        public static final int ITEM = 0;
        public static final int SECTION = 1;

        public final int type;
        public final String text;
        public final String textHolder;
        public final String text1;

        public int sectionPosition;
        public int listPosition;
        public int row;

        public Item(int type, String text, String textHolder, String text1) {
            this.type = type;
            this.text = text;
            this.textHolder = textHolder;
            this.text1 = text1;
        }

        @Override public String toString() {
            return text;
        }

    }

    public int numberOfSectionsInTableView(){
        return 1;
    }
    @SuppressLint("NewApi")
    private void initializeAdapter() {
        int nSectionNum = data.size(); boolean flag = false;

        adapter = new SimpleAdapter(this, R.layout.cell_choose_location, R.id.cell_loc_txt, data, nSectionNum, flag );
        list.setAdapter( adapter );
    }
}
