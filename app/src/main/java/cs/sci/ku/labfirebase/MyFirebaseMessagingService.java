package cs.sci.ku.labfirebase;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by MegapiesPT on 23/11/2560.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    int id;
    private final String CH1 = "CH1";
    public MyFirebaseMessagingService() {
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Chanel Test 1";
            String description = "Chenel for test 1";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CH1, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        for (String k : remoteMessage.getData().keySet()){
            String s = remoteMessage.getData().get(k);
            Log.d("message receive", s);
        }

        if (remoteMessage.getNotification() != null){
            createNotificationChannel();
            String s = remoteMessage.getNotification().getBody();
            Log.d("message noti", s);

            NotificationCompat.Builder b = new NotificationCompat.Builder(this, CH1);
            b.setSmallIcon(android.R.drawable.arrow_up_float)
                    .setContentText("noti from firebase")
                    .setContentText(s)
                    .setAutoCancel(true);
            NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            nm.notify(id++, b.build());
        }
    }


}
