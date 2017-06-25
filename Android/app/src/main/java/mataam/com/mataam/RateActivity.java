package mataam.com.mataam;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class RateActivity extends Activity implements View.OnClickListener{

    ImageView img1, img2, img3, img4, img5;
    LinearLayout lvApply, lvCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        img1 = (ImageView) findViewById( R.id.img_star1 ); img1.setOnClickListener( this );
        img2 = (ImageView) findViewById( R.id.img_star2 ); img2.setOnClickListener( this );
        img3 = (ImageView) findViewById( R.id.img_star3 ); img3.setOnClickListener( this );
        img4 = (ImageView) findViewById( R.id.img_star4 ); img4.setOnClickListener( this );
        img5 = (ImageView) findViewById( R.id.img_star5 ); img5.setOnClickListener( this );

        lvApply = (LinearLayout) findViewById( R.id.lv_apply ); lvApply.setOnClickListener( this );
        lvCancel = (LinearLayout) findViewById( R.id.lv_cancel ); lvCancel.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_star1: {
                img1.setImageResource( R.drawable.star_red );
                img2.setImageResource( R.drawable.no_red_star );
                img3.setImageResource( R.drawable.no_red_star );
                img4.setImageResource( R.drawable.no_red_star );
                img5.setImageResource( R.drawable.no_red_star );

                break;
            }
            case R.id.img_star2:{
                img1.setImageResource( R.drawable.star_red );
                img2.setImageResource( R.drawable.star_red );
                img3.setImageResource( R.drawable.no_red_star );
                img4.setImageResource( R.drawable.no_red_star );
                img5.setImageResource( R.drawable.no_red_star );

                break;
            }
            case R.id.img_star3:{
                img1.setImageResource( R.drawable.star_red );
                img2.setImageResource( R.drawable.star_red );
                img3.setImageResource( R.drawable.star_red );
                img4.setImageResource( R.drawable.no_red_star );
                img5.setImageResource( R.drawable.no_red_star );

                break;
            }
            case R.id.img_star4:{
                img1.setImageResource( R.drawable.star_red );
                img2.setImageResource( R.drawable.star_red );
                img3.setImageResource( R.drawable.star_red );
                img4.setImageResource( R.drawable.star_red );
                img5.setImageResource( R.drawable.no_red_star );

                break;
            }
            case R.id.img_star5:{
                img1.setImageResource( R.drawable.star_red );
                img2.setImageResource( R.drawable.star_red );
                img3.setImageResource( R.drawable.star_red );
                img4.setImageResource( R.drawable.star_red );
                img5.setImageResource( R.drawable.star_red );

                break;
            }
            case R.id.lv_apply:{
                finish();
                break;
            }
            case R.id.lv_cancel:{
                finish();
                break;
            }
        }
    }

}
