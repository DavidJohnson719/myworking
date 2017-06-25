package mataam.com.mataam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class smsActivity extends Activity  implements View.OnClickListener{

    LinearLayout lvBack;
    TextView txtCode;
    TextView txtApply;
    TextView txtResend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        lvBack = (LinearLayout) findViewById( R.id.sms_back );  lvBack.setClickable( true); lvBack.setOnClickListener( this );
        txtCode = (TextView) findViewById( R.id.sms_txt_code );
        txtApply = (TextView) findViewById( R.id.sms_txt_apply ); txtApply.setClickable( true ); txtApply.setOnClickListener( this );
        txtResend = (TextView) findViewById( R.id.sms_txt_resend ); txtResend.setClickable( true ); txtResend.setOnClickListener( this );

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sms_back:
            {
               finish();
            }
            break;
            case R.id.sms_txt_apply:
                Intent intent = new Intent( smsActivity.this, ADActivity.class );
                startActivity(intent);
                break;
            case R.id.sms_txt_resend:

                break;
            default:
                break;
        }

    }
}
