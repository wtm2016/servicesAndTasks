package pl.agh.eaiiib.studio.projektowe.intentserviceexample;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

public class ExampleIntentService extends IntentService {

    /**
     * A constructor is required, and must call the super IntentService(String)
     * constructor with a name for the worker thread.
     */
    public ExampleIntentService() {
        super("ExampleIntentService");
    }

    /**
     * The IntentService calls this method from the default worker thread with
     * the intent that started the service. When this method returns, IntentService
     * stops the service, as appropriate.
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        // Normally we would do some work here, like download a file.
        // For our sample, we just sleep for 5 seconds.
        try {
            /**
             * !!! This message won't be displayed because IntentService is not running on the main application thread.
             */
            //Toast.makeText(this, "Intent service - Start!", Toast.LENGTH_SHORT).show();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Restore interrupt status.
            Thread.currentThread().interrupt();
        }
    }
}
