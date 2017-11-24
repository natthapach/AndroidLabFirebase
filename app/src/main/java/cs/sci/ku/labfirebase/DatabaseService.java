package cs.sci.ku.labfirebase;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by MegapiesPT on 23/11/2560.
 */

public class DatabaseService extends Service {

    FirebaseDatabase database;
    public static DatabaseReference ref;
    private int id;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("onCreate", "database service");
        NotificationCompat.Builder b = new NotificationCompat.Builder(getApplicationContext());
        b.setSmallIcon(android.R.drawable.arrow_up_float)
                .setContentTitle("Start Service")
                .setContentText("Database Service")
                .setAutoCancel(true);
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(id++, b.build());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("onStartCommand", flags + " " + startId);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("user");
        ListenerForRequestDone();
        return START_STICKY;
    }

    private void ListenerForRequestDone() {
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String name = dataSnapshot.getValue().toString();
                NotificationCompat.Builder b = new NotificationCompat.Builder(getApplicationContext());
                b.setSmallIcon(android.R.drawable.arrow_up_float)
                        .setContentTitle("New User")
                        .setContentText("name " + name)
                        .setAutoCancel(true);
                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                nm.notify(id++, b.build());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent("RESTART_SERVICE");
        sendBroadcast(intent);
    }
}
