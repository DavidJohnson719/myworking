package mataam.com.mataam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.Set;

public class SettingActivity extends Activity  implements View.OnClickListener{

    RelativeLayout reAddress;
    RelativeLayout reInformation;
    RelativeLayout rePassword;
    RelativeLayout rePhone;
    RelativeLayout reLanguage;
    RelativeLayout reAbout;
    RelativeLayout reTerms;
    RelativeLayout reLogout;

    LinearLayout lvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        lvBack = (LinearLayout) findViewById( R.id.setting_back );
        lvBack.setOnClickListener( this );

        reAddress = ( RelativeLayout ) findViewById( R.id.setting_re_address );
        reAddress.setOnClickListener( this );

        reInformation = (RelativeLayout) findViewById( R.id.setting_re_information );
        reInformation.setOnClickListener( this );

        rePassword = (RelativeLayout) findViewById( R.id.setting_re_password );
        rePassword.setOnClickListener( this );

        rePhone = (RelativeLayout) findViewById( R.id.setting_re_phone );
        rePhone.setOnClickListener( this );

        reLanguage = (RelativeLayout) findViewById( R.id.setting_re_language );
        reLanguage.setOnClickListener( this );

        reAbout = (RelativeLayout) findViewById( R.id.setting_re_about );
        reAbout.setOnClickListener( this );

        reTerms = (RelativeLayout) findViewById( R.id.setting_re_terms );
        reTerms.setOnClickListener( this );

        reLogout = (RelativeLayout) findViewById( R.id.setting_re_logout );
        reLogout.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setting_back:{
                finish();
                break;
            }
            case R.id.setting_re_address:
            {
                Intent intent = new Intent( SettingActivity.this, AddressActivity.class );
                startActivity( intent );
                break;
            }
            case R.id.setting_re_information:{
                Intent intent  = new Intent(SettingActivity.this, EditInformationActivity.class );
                startActivity( intent );
                break;
            }
            case R.id.setting_re_password:{
                Intent intent  = new Intent( SettingActivity.this, ChangePwdActivity.class );
                startActivity( intent );
                break;
            }
            case R.id.setting_re_phone:{
                Intent intent  = new Intent( SettingActivity.this, ChangePhoneNumActivity.class );
                startActivity( intent );
                break;
            }
            case R.id.setting_re_language:{
                break;
            }
            case R.id.setting_re_about:{
                break;
            }
            case R.id.setting_re_terms:{
                break;
            }
            case R.id.setting_re_logout:{
                break;
            }
            default:
                break;
        }
    }
}
