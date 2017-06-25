package mataam.com.mataam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RegisterActivity extends Activity implements View.OnClickListener{

    LinearLayout lvBack;
    TextView  txtPhone;
    TextView  txtName;
    TextView  txtPwd;
    TextView  txtConfirm;
    TextView  txtEmail;
    ImageView imgCheck;
    TextView  txtKeep;
    TextView  txtSubmit;

    boolean bKeep = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        lvBack = (LinearLayout) findViewById( R.id.register_back ); lvBack.setClickable( true ); lvBack.setOnClickListener( this );
        txtPhone = (TextView) findViewById( R.id.register_txt_phone );
        txtName = (TextView) findViewById( R.id.register_txt_name );
        txtPwd = (TextView) findViewById( R.id.register_txt_pwd );
        txtConfirm = (TextView) findViewById( R.id.register_txt_confirm);
        txtEmail = (TextView) findViewById( R.id.register_txt_email );
        imgCheck = (ImageView) findViewById( R.id.register_img_check );
        txtKeep = (TextView) findViewById( R.id.register_txt_keep ); txtKeep.setClickable( true ); txtKeep.setOnClickListener( this );
        txtSubmit = (TextView) findViewById( R.id.register_submit); txtSubmit.setClickable( true ); txtSubmit.setOnClickListener( this );

        imgCheck.setImageResource( R.drawable.check_no );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_txt_keep:
            {
                bKeep = !bKeep;
                if ( bKeep )
                    imgCheck.setImageResource( R.drawable.check_green );
                else
                    imgCheck.setImageResource( R.drawable.check_no );
            }
            break;
            case R.id.register_back:
                finish();
                break;
            case R.id.register_submit:
               Intent intent = new Intent( RegisterActivity.this, smsActivity.class );
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}
