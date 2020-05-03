package org.goebish.arizer_remote;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private IRController _irController;
    private LinearLayout [] _button = new LinearLayout[18];
    private IRMessageRequest [] _buttonRequest = new IRMessageRequest[18];
    private LinearLayout [] _rows = new LinearLayout[6];
    private Vibrator _vibrator = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IRMessages.initialize();

        setContentView(R.layout.main_activity);

        getSupportActionBar().hide();

        _vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);

        _irController = new IRController(getApplicationContext());
        _irController.startWork();

        getRowReferences();

        _button[0] = createIRButton("AUDIO", R.drawable.audio, _rows[0], new IRMessageRequest(IRMessages.ARIZER_EXTREME_Q_AUDIO));
        _button[1] = createIRButton("LIGHT", R.drawable.light, _rows[0], new IRMessageRequest(IRMessages.ARIZER_EXTREME_Q_LIGHT));
        _button[2] = createIRButton("POWER", R.drawable.power, _rows[0], new IRMessageRequest(IRMessages.ARIZER_EXTREME_Q_POWER));

        _button[3] = createIRButton("STOP TIMER", R.drawable.timer, _rows[1], new IRMessageRequest(IRMessages.ARIZER_EXTREME_Q_TIMER_0H));
        _button[4] = createIRButton("2 HOUR TIMER", R.drawable.timer, _rows[1], new IRMessageRequest(IRMessages.ARIZER_EXTREME_Q_TIMER_2H));
        _button[5] = createIRButton("4 HOUR TIMER", R.drawable.timer, _rows[1], new IRMessageRequest(IRMessages.ARIZER_EXTREME_Q_TIMER_4H));

        _button[6] = createIRButton("FAN 1", R.drawable.fan, _rows[2], new IRMessageRequest(IRMessages.ARIZER_EXTREME_Q_FAN_1));
        _button[7] = createIRButton("FAN 2", R.drawable.fan, _rows[2], new IRMessageRequest(IRMessages.ARIZER_EXTREME_Q_FAN_2));
        _button[8] = createIRButton("FAN 3", R.drawable.fan, _rows[2], new IRMessageRequest(IRMessages.ARIZER_EXTREME_Q_FAN_3));

        _button[9] = createIRButton("50°C TEMP", R.drawable.t50, _rows[3], new IRMessageRequest(IRMessages.ARIZER_EXTREME_Q_50_DEG));
        _button[10] = createIRButton("FAN 0", R.drawable.fan, _rows[3], new IRMessageRequest(IRMessages.ARIZER_EXTREME_Q_FAN0));
        _button[11] = createIRButton("100°C TEMP", R.drawable.t100, _rows[3], new IRMessageRequest(IRMessages.ARIZER_EXTREME_Q_100_DEG));

        _button[12] = createIRButton("200°C TEMP", R.drawable.t200, _rows[4], new IRMessageRequest(IRMessages.ARIZER_EXTREME_Q_200_DEG));
        _button[13] = createIRButton("TEMP PLUS", R.drawable.plus, _rows[4], new IRMessageRequest(IRMessages.ARIZER_EXTREME_Q_PLUS));
        _button[14] = createIRButton("210°C TEMP", R.drawable.t210, _rows[4], new IRMessageRequest(IRMessages.ARIZER_EXTREME_Q_210_DEG));

        _button[15] = createIRButton("220°C TEMP", R.drawable.t220, _rows[5], new IRMessageRequest(IRMessages.ARIZER_EXTREME_Q_220_DEG));
        _button[16] = createIRButton("TEMP MINUS", R.drawable.minus, _rows[5], new IRMessageRequest(IRMessages.ARIZER_EXTREME_Q_MINUS));
        _button[17] = createIRButton("230°C TEMP", R.drawable.t230, _rows[5], new IRMessageRequest(IRMessages.ARIZER_EXTREME_Q_230_DEG));

        for (int a = 0; a < 18; a++) {
            _button[a].setOnClickListener(this);
        }
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
    }

    @Override
    protected void onDestroy()
    {
        _irController.stopWork();
        super.onDestroy();
    }

    private void getRowReferences()
    {
        _rows[0] = (LinearLayout)findViewById(R.id.id_Layout_Row_01);
        _rows[1] = (LinearLayout)findViewById(R.id.id_Layout_Row_02);
        _rows[2] = (LinearLayout)findViewById(R.id.id_Layout_Row_03);
        _rows[3] = (LinearLayout)findViewById(R.id.id_Layout_Row_04);
        _rows[4] = (LinearLayout)findViewById(R.id.id_Layout_Row_05);
        _rows[5] = (LinearLayout)findViewById(R.id.id_Layout_Row_06);
    }

    private LinearLayout createIRButton(String title, int imageResource, LinearLayout row,IRMessageRequest request)
    {
        View child = getLayoutInflater().inflate(R.layout.widget_button, null);

        RelativeLayout mainLayout = (RelativeLayout)child.findViewById(R.id.layout_main);
        LinearLayout buttonLayout = (LinearLayout)child.findViewById(R.id.layout_button);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
        lp.weight = 1;
        mainLayout.setLayoutParams(lp);

        ImageView imageView = (ImageView)child.findViewById(R.id.image_main);
        TextView titleView  = (TextView)child.findViewById(R.id.text_title);

        imageView.setImageResource(imageResource);
        titleView.setText(title);

        row.addView(child);

        buttonLayout.setTag(request);

        return buttonLayout;
    }

    public long sendIRMessage(IRMessageRequest request)
    {
        _vibrator.vibrate(60);
        return _irController.sendMessage(request);
    }
    
    @Override
    public void onClick(View view) {
        if(!_irController.hasIrEmitter()) {
            Toast.makeText(getApplicationContext(), "This device has no infrared emitter!", Toast.LENGTH_LONG).show();
        }
        else {
            sendIRMessage(((IRMessageRequest) view.getTag()));
        }
    }
}
