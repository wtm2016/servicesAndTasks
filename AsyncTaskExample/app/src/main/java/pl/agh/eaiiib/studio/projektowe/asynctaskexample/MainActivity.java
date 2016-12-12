package pl.agh.eaiiib.studio.projektowe.asynctaskexample;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final int PLEASE_WAIT_DIALOG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startAsyncTask(view);
            }
        });
    }

    private void startAsyncTask(View view) {

        new AsyncTaskExample(this).execute();
    }

    @Override
    public Dialog onCreateDialog(int dialogId) {

        switch (dialogId) {
            case PLEASE_WAIT_DIALOG:
                ProgressDialog dialog = new ProgressDialog(this);
                dialog.setTitle("Calculating");
                dialog.setMessage("Please wait....");
                dialog.setCancelable(true);
                return dialog;
            default:
                break;
        }
        return null;
    }
}
