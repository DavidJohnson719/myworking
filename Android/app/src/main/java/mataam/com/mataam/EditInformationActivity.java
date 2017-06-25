package mataam.com.mataam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class EditInformationActivity extends Activity implements View.OnClickListener{

    LinearLayout lvMale, lvFemale;
    ImageView    imgMale, imgFemale;
    LinearLayout lvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_information);

        lvMale = (LinearLayout) findViewById( R.id.lv_male ); lvMale.setOnClickListener( this );
        lvFemale = (LinearLayout) findViewById( R.id.lv_female ); lvFemale.setOnClickListener( this );
        imgMale = (ImageView) findViewById( R.id.img_male );
        imgFemale = (ImageView) findViewById( R.id.img_female );

        imgMale.setImageResource( R.drawable.check_green );
        imgFemale.setImageResource( R.drawable.check_no );

        lvBack = (LinearLayout) findViewById( R.id.info_back );
        lvBack.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lv_male: {
                imgMale.setImageResource( R.drawable.check_green );
                imgFemale.setImageResource( R.drawable.check_no );
                break;
            }
            case R.id.lv_female:{
                imgMale.setImageResource( R.drawable.check_no );
                imgFemale.setImageResource( R.drawable.check_green );
                break;
            }
            case R.id.info_back:{
                finish();
                break;
            }
            default:
                break;
        }
    }

}
