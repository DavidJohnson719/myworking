package mataam.com.mataam;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mataam.com.mataam.Model.ItemDeliveryMenu;

public class PickDetailActivity extends Activity implements View.OnClickListener {

    RelativeLayout reTopView;
    LinearLayout    lvMediumView;

    ImageView       imgMain;
    TextView        txtLoc, txtTitle,txtSubTitle;
    ImageView       imgStar1, imgStar2, imgStar3, imgStar4, imgStar5;
    ImageView       imgPayment1, imgPayment2, imgPayment3;

    RelativeLayout  reMenuBar;

    TextView        txtMenu1, txtMenu2, txtMenu3;
    ListView        list, infoList, reviewList;
    LinearLayout    lvReview;

    LinearLayout    lvRate;

    ArrayList<Map<String, Object>> data  = new ArrayList<>();
    ArrayList<Map<String, Object>> dataReview  = new ArrayList<>();
    ArrayList<Map<String, Object>> dataInfo  = new ArrayList<>();

    SimpleAdapter adapter;
    LinearLayout lvBack;
    RelativeLayout lvTotal;
    LinearLayout   lvAdditional;
    TextView       txtCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_detail);

        lvBack = (LinearLayout) findViewById( R.id.pick_menu ); lvBack.setOnClickListener( this );
        reTopView = (RelativeLayout) findViewById( R.id.pick_detail_topView  );
        lvMediumView = (LinearLayout) findViewById( R.id.pick_detail_medium  );

        lvTotal = (RelativeLayout) findViewById( R.id.lv_total );
        lvAdditional = (LinearLayout) findViewById( R.id.lv_additional );
        txtCart = (TextView) findViewById( R.id.txt_cart );
        txtCart.setOnClickListener( this );

        imgMain = (ImageView) findViewById( R.id.pick_detail_img  );
        txtLoc  = (TextView) findViewById( R.id.pick_detail_loc  );
        txtTitle = (TextView) findViewById( R.id.pick_detail_title );
        txtSubTitle = (TextView) findViewById( R.id.pick_detail_subTitle );
        imgStar1 = (ImageView) findViewById( R.id.img_star1 );
        imgStar2 = (ImageView) findViewById( R.id.img_star2 );
        imgStar3 = (ImageView) findViewById( R.id.img_star3 );
        imgStar4 = (ImageView) findViewById( R.id.img_star4 );
        imgStar5 = (ImageView) findViewById( R.id.img_star5 );

        imgPayment1 = (ImageView) findViewById( R.id.img_payment1 );
        imgPayment2 = (ImageView) findViewById( R.id.img_payment2 );
        imgPayment3 = (ImageView) findViewById( R.id.img_payment3 );

        reMenuBar = (RelativeLayout) findViewById( R.id.pick_detail_menu_bar );
        txtMenu1 = (TextView) findViewById( R.id.menu_txt1 ); txtMenu1.setOnClickListener( this );
        txtMenu2 = (TextView) findViewById( R.id.menu_txt2 ); txtMenu2.setOnClickListener( this );
        txtMenu3 = (TextView) findViewById( R.id.menu_txt3 ); txtMenu3.setOnClickListener( this );

        list = (ListView) findViewById( R.id.pick_detail_list  );
        lvReview = (LinearLayout) findViewById( R.id.pick_detail_lv_review );
        infoList = (ListView) findViewById( R.id.pick_detail_info_list );
        reviewList = (ListView) findViewById( R.id.list_review );

        lvRate = (LinearLayout) findViewById( R.id.pick_rate ); lvRate.setOnClickListener( this );
        setMenuBg( 0 );
        setTempData();
        setTempReviewData();
        setTempInfoData();

        initializeAdapter();

        reviewAdapter adapter=new reviewAdapter( this, data, getResources() );
        reviewList.setAdapter(adapter);

        InfoAdapter infoAdapter=new InfoAdapter( this, data, getResources() );
        infoList.setAdapter(infoAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if ( MainActivity.global.nPickNum > 3 )
        {
            lvTotal.setVisibility( View.VISIBLE );
            lvAdditional.setVisibility( View.GONE );
        }

    }

    public void gotoPayment()
    {
        Intent intent  = new Intent( PickDetailActivity.this, DeliveryPaymentActivity.class );
        startActivity( intent );
        MainActivity.global.nPickNum ++;
        if ( MainActivity.global.nPickNum > 3 )
        {
            lvTotal.setVisibility( View.VISIBLE );
            lvAdditional.setVisibility( View.GONE );
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.txt_cart:{
                Intent intent  = new Intent( PickDetailActivity.this, DeliveryPaymentActivity.class );
                startActivity( intent );
                break;
            }
            case R.id.pick_menu:{
                finish();
                break;
            }
            case R.id.menu_txt1: {
                setMenuBg ( 0 );
                break;
            }
            case R.id.menu_txt2: {
                setMenuBg( 1 );
                break;
            }
            case R.id.menu_txt3: {
                setMenuBg( 2 );
                break;
            }
            case R.id.pick_rate: {
                Intent intent = new Intent( PickDetailActivity.this, OrderSummaryActivity.class );
                startActivity( intent );
                break;
            }
            default:
                break;
        }
    }

    private  void  setMenuBg( int type )
    {
        switch ( type ){
            case 0:{
                reMenuBar.setBackgroundResource(R.drawable.menu_left ) ;
                txtMenu1.setTextColor( getResources().getColor( android.R.color.black ) );
                txtMenu2.setTextColor( getResources().getColor( android.R.color.white ) );
                txtMenu3.setTextColor( getResources().getColor( android.R.color.white ) );

                list.setVisibility( View.VISIBLE ); lvReview.setVisibility( View.GONE ); infoList.setVisibility( View.GONE );
                break;
            }
            case 1:{
                reMenuBar.setBackgroundResource(R.drawable.menu_center ) ;
                txtMenu1.setTextColor( getResources().getColor( android.R.color.white ) );
                txtMenu2.setTextColor( getResources().getColor( android.R.color.black ) );
                txtMenu3.setTextColor( getResources().getColor( android.R.color.white ) );

                list.setVisibility( View.GONE ); lvReview.setVisibility( View.VISIBLE ); infoList.setVisibility( View.GONE );
                break;
            }
            case 2:{
                reMenuBar.setBackgroundResource(R.drawable.menu_right ) ;
                txtMenu1.setTextColor( getResources().getColor( android.R.color.white ) );
                txtMenu2.setTextColor( getResources().getColor( android.R.color.white ) );
                txtMenu3.setTextColor( getResources().getColor( android.R.color.black ) );

                list.setVisibility( View.GONE ); lvReview.setVisibility( View.GONE ); infoList.setVisibility( View.VISIBLE );
                break;
            }

        }
    }

    private void setTempData()
    {
// section 1
        ArrayList< ItemDeliveryMenu> arr = new ArrayList<>();
        ItemDeliveryMenu item  = new ItemDeliveryMenu();
        item.title = "Chicken Wings";
        item.subTitle = "Big Juicy Wings in Barbecue, Hot or Regular flavor";
        item.price = "KD\n4.500";
        arr.add( item );

        ItemDeliveryMenu item1  = new ItemDeliveryMenu();
        item1.title = "Chicken Kickers";
        item1.subTitle = "All white chciken Beast With a hint of Buffalo\nFlavor Baked Right in Served With Ranch And Hot Sause For Dipping.";
        item1.price = "Price upon\nSelection";
        arr.add( item1 );


        Map<String, Object> tempArr  = new HashMap<>();
        tempArr.put("name", "Most Selling");
        tempArr.put("data", arr );
        tempArr.put("extend", true );

        data.add( tempArr );

// section 2
        ArrayList< ItemDeliveryMenu> arr1 = new ArrayList<>();
        ItemDeliveryMenu item3  = new ItemDeliveryMenu();
        item3.title = "Chicken Wings";
        item3.subTitle = "Big Juicy Wings in Barbecue, Hot or Regular flavor";
        item3.price = "KD\n4.500";
        arr1.add( item3 );

        ItemDeliveryMenu item4  = new ItemDeliveryMenu();
        item4.title = "Chicken Kickers";
        item4.subTitle = "All white chciken Beast With a hint of Buffalo\nFlavor Baked Right in Served With Ranch And Hot Sause For Dipping.";
        item4.price = "Price upon\nSelection";
        arr1.add( item4 );


        Map<String, Object> tempArr2  = new HashMap<>();
        tempArr2.put("name", "Special Offer");
        tempArr2.put("data", arr1 );
        tempArr2.put("extend", false );

        data.add( tempArr2 );

    }

    private void setTempReviewData()
    {
        for ( int i = 0; i < 10; i++ ) {
            Map<String, Object> map1 = new HashMap<>();
            map1.put("name", "Name LastName");
            map1.put("date", "14 Feb 2017");
            map1.put("des", "Big juicy Wings in Barbecue, Hot or Regular flavor.\n Great choice! Try it");

            dataReview.add(map1);
        }
    }

    private void setTempInfoData()
    {

        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "Minimum Order Amount");
        map1.put("sub", "KD 0.00");
        map1.put("type", 0);

        dataInfo.add(map1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "Working Hours (Today)");
        map2.put("sub", "10:00 AM - 12:45 PM");
        map2.put("type", 1);

        dataInfo.add( map2 );

        Map<String, Object> map3 = new HashMap<>();
        map3.put("name", "Newly opened");
        map3.put("sub", "Yes");
        map3.put("type", 0);

        dataInfo.add( map3 );

        Map<String, Object> map4 = new HashMap<>();
        map4.put("name", "Delivery Fee");
        map4.put("sub", "KD 0.500");
        map4.put("type", 0);

        dataInfo.add( map4 );

        Map<String, Object> map5 = new HashMap<>();
        map5.put("name", "Payment");
        map5.put("sub", "");
        map5.put("type", 2);

        dataInfo.add( map5 );

        Map<String, Object> map6 = new HashMap<>();
        map6.put("name", "Rating");
        map6.put("sub", "4793");
        map6.put("type", 0);

        dataInfo.add( map6 );

        Map<String, Object> map7 = new HashMap<>();
        map7.put("name", "Cuisine");
        map7.put("sub", "Pizza, American, International");
        map7.put("type", 0);

        dataInfo.add( map7 );
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
                retval = LayoutInflater.from( parent.getContext()).inflate(R.layout.cell_section_blue, null);
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
                        PickDetailActivity main  = (PickDetailActivity) mCtx;
                        main.initializeAdapter();
                    }
                });

                Map<String, Object> map = (Map<String, Object>) mData.get( section );
                String cityName  = (String) map.get("name");
                title.setText( cityName  );
                boolean bCheck  = (boolean) map.get("extend");
                if ( bCheck ) {
                    img.setImageResource(R.drawable.directtopb3x);
                    lvMain.setImageResource( R.drawable.section_bg_sel_blue );
                    title.setTextColor( mCtx.getResources().getColor( R.color.background_color)  );
                }
                else {
                    img.setImageResource(R.drawable.directbottomb3x);
                    lvMain.setImageResource( R.drawable.section_bg );
                    title.setTextColor( mCtx.getResources().getColor(  R.color.text_color) );
                }
            }
            else {
                retval = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_pick_custome, null);
                ImageView img  = (ImageView) retval.findViewById( R.id.cell_menu_img );
                TextView txtTitle = (TextView) retval.findViewById( R.id.cell_menu_txt_title );
                TextView txtSubTitle = (TextView) retval.findViewById( R.id.cell_menu_subTitle );
                TextView txtPrice = (TextView) retval.findViewById( R.id.cell_menu_price );

                LinearLayout lvAdd = (LinearLayout) retval.findViewById( R.id.delivery_custom_add_view );
                lvAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PickDetailActivity main  = (PickDetailActivity) mCtx;
                        main.gotoPayment();
                    }
                });

                Map<String, Object> map = (Map<String, Object>) mData.get( section );
                ArrayList<Map<String, Object>> arr = ( ArrayList<Map<String,Object>> ) map.get("data");
                ItemDeliveryMenu subItem = ( ItemDeliveryMenu ) arr.get( row );

                txtTitle.setText( subItem.title );
                txtSubTitle.setText( subItem.subTitle );
                txtPrice.setText( subItem.price );
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

    @SuppressLint("NewApi")
    private void initializeAdapter() {
        int nSectionNum = data.size(); boolean flag = false;
        adapter = new SimpleAdapter(this, R.layout.cell_choose_location, R.id.cell_loc_txt, data, nSectionNum, flag );
        list.setAdapter( adapter );
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
            return dataReview.size() ;
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
                vi = inflater.inflate(R.layout.cell_delivery_review, parent, false);
                /****** View Holder Object to contain tabitem.xml file elements ******/
                holder = new ViewHolder();
                holder.txtName = (TextView) vi.findViewById(R.id.cell_delivery_review_txt_name);
                holder.txtDate =(TextView)vi.findViewById(R.id.cell_delivery_review_txt_date);
                holder.txtDescription =(TextView)vi.findViewById(R.id.cell_delivery_review_txt_description);
                /************  Set holder with LayoutInflater ************/
                vi.setTag( holder );
            }
            else
                holder=(ViewHolder)vi.getTag();

            Map<String, Object> map1  = (Map<String, Object>) dataReview.get( position  );

            holder.txtName.setText( (String)map1.get("name") );
            holder.txtDate.setText( (String)map1.get("date") );
            holder.txtDescription.setText( (String)map1.get("des") );

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

    public class InfoAdapter extends BaseAdapter implements View.OnClickListener {

        /*********** Declare Used Variables *********/
        private Activity activity;
        private LayoutInflater inflater=null;
        public Resources res;
        int i=0;

        /*************  CustomAdapter Constructor *****************/
        public InfoAdapter(Activity a, ArrayList d, Resources resLocal) {

            /********** Take passed values **********/
            activity = a;
            res = resLocal;

            /***********  Layout inflator to call external xml layout () ***********/
            inflater = ( LayoutInflater )activity.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        /******** What is the size of Passed Arraylist Size ************/
        public int getCount() {
            return dataInfo.size() ;
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
            public TextView txtSub;
            public ImageView img1;
            public ImageView img2;
            public ImageView img3;
            public LinearLayout lvImg;

        }

        /****** Depends upon data size called for each row , Create each ListView row *****/
        public View getView(int position, View convertView, ViewGroup parent) {
            View vi = convertView;
            ViewHolder holder;
            if(convertView==null){
                /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
                vi = inflater.inflate(R.layout.cell_delivery_normal, parent, false);
                /****** View Holder Object to contain tabitem.xml file elements ******/
                holder = new ViewHolder();
                holder.txtName = (TextView) vi.findViewById(R.id.cell_info_txt_main);
                holder.txtSub =(TextView)vi.findViewById(R.id.cell_info_txt_sub);

                holder.img1 =(ImageView) vi.findViewById(R.id.cell_info_img1);
                holder.img2 =(ImageView) vi.findViewById(R.id.cell_info_img2);
                holder.img3 =(ImageView) vi.findViewById(R.id.cell_info_img3);
                holder.lvImg = (LinearLayout) vi.findViewById( R.id.cell_normal_lv_img );

                /************  Set holder with LayoutInflater ************/
                vi.setTag( holder );
            }
            else
                holder=(ViewHolder)vi.getTag();

            Map<String, Object> map1  = (Map<String, Object>) dataInfo.get( position  );

            holder.txtName.setText( (String)map1.get("name") );
            holder.txtSub.setText( (String)map1.get("sub") );
            int type  = (int)map1.get("type");
            if ( type == 0 ) {
                holder.img1.setVisibility(View.GONE);
                holder.img2.setVisibility(View.GONE);
                holder.img3.setVisibility(View.GONE);
                holder.lvImg.setVisibility(View.GONE);
            }
            else if (type == 1 ){
                holder.img1.setVisibility(View.VISIBLE);
                holder.img2.setVisibility(View.GONE);
                holder.img3.setVisibility(View.GONE);
                holder.lvImg.setVisibility(View.VISIBLE);
                holder.img1.setImageResource( R.drawable.directbottomb3x );
            }
            else if ( type == 2 ){
                holder.img1.setVisibility(View.VISIBLE);
                holder.img2.setVisibility(View.VISIBLE);
                holder.img3.setVisibility(View.VISIBLE);
                holder.lvImg.setVisibility(View.VISIBLE);
                holder.img1.setImageResource( R.drawable.icon_payment1);
                holder.img2.setImageResource( R.drawable.icon_payment2);
                holder.img3.setImageResource( R.drawable.icon_payment3);
            }

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
