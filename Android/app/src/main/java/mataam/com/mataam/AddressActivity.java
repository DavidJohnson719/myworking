package mataam.com.mataam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class AddressActivity extends Activity {

    LinearLayout lvBack;
    RelativeLayout reHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        lvBack = (LinearLayout) findViewById( R.id.address_back );
        lvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        reHome = (RelativeLayout) findViewById( R.id.address_re_home );
        reHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( AddressActivity.this, HomeActivity.class );
                startActivity( intent );
            }
        });
    }
}
