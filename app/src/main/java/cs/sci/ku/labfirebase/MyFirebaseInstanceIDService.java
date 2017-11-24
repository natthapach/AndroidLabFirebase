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
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by MegapiesPT on 23/11/2560.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    int id;

    public MyFirebaseInstanceIDService() {
    }

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        Log.d("onTokenRefresh", FirebaseInstanceId.getInstance().getToken());
    }
}
