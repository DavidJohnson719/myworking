package mataam.com.mataam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    public static Global global;
    LinearLayout lvKeepView;
    ImageView imgCheck;
    TextView txtLogin;
    TextView     txtRegister;
    boolean    bKeep = false;

    LinearLayout lvLaunch;
    LinearLayout lvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        global = new Global();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                lvLaunch.setVisibility(View.GONE);
                lvMain.setVisibility( View.VISIBLE );
            }
        }, 2000);

        lvKeepView = (LinearLayout) findViewById( R.id.login_keep_view );
        lvKeepView.setClickable( true ); lvKeepView.setOnClickListener( this );
        imgCheck = (ImageView) findViewById( R.id.login_check_img );
        txtLogin = (TextView) findViewById( R.id.login_txt );
        txtLogin.setClickable( true ); txtLogin.setOnClickListener( this );
        txtRegister = (TextView) findViewById( R.id.login_register );
        txtRegister.setClickable( true ); txtRegister.setOnClickListener( this );

        imgCheck.setImageResource( R.drawable.check_no );

        lvLaunch  = (LinearLayout) findViewById( R.id.lv_lunch );
        lvMain = (LinearLayout) findViewById( R.id.lv_main );

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_keep_view:
            {
                bKeep = !bKeep;
                if ( bKeep )
                    imgCheck.setImageResource( R.drawable.check_green );
                else
                    imgCheck.setImageResource( R.drawable.check_no );
            }
            break;
            case R.id.login_txt: {
                Intent intent = new Intent(MainActivity.this, SelectCategoryActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.login_register: {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
            break;

            default:
                break;
        }

    }

}
