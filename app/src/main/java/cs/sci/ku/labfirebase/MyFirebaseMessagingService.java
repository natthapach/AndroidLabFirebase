package cs.sci.ku.labfirebase;

import android.app.NotificationManager;
import android.content.Context;
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

    public MyFirebaseMessagingService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        for (String k : remoteMessage.getData().keySet()){
            String s = remoteMessage.getData().get(k);
            Log.d("message receive", s);
        }

        if (remoteMessage.getNotification() != null){
            String s = remoteMessage.getNotification().getBody();
            Log.d("message noti", s);

            NotificationCompat.Builder b = new NotificationCompat.Builder(this);
            b.setSmallIcon(android.R.drawable.arrow_up_float)
                    .setContentText("noti from firebase")
                    .setContentText(s)
                    .setAutoCancel(true);
            NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            nm.notify(id++, b.build());
        }
    }


}
