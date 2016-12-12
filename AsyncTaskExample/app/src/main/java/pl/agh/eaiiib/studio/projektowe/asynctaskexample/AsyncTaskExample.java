package pl.agh.eaiiib.studio.projektowe.asynctaskexample;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by Przemek on 2016-12-12.
 */

public class AsyncTaskExample extends AsyncTask<Void, Void, Void> {

    Activity activity;

    public AsyncTaskExample(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        activity.showDialog(MainActivity.PLEASE_WAIT_DIALOG);
    }

    @Override
    protected Void doInBackground(Void... arg0) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        activity.removeDialog(MainActivity.PLEASE_WAIT_DIALOG);
        Toast.makeText(activity, "Done!", Toast.LENGTH_SHORT).show();
    }
}
