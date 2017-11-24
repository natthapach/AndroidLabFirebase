package cs.sci.ku.labfirebase;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MainActivity extends AppCompatActivity {
    int id;
    public void clk(View view){
        NotificationCompat.Builder b = new NotificationCompat.Builder(this);
        b.setSmallIcon(android.R.drawable.arrow_up_float)
                .setContentText("my title")
                .setContentText("my content text")
                .setAutoCancel(true);
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(id++, b.build());


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FirebaseManager.getInstance().start();
//        FirebaseInstanceId.getInstance();
//        FirebaseMessaging.getInstance();

        startService(new Intent(this, DatabaseService.class));
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("user");
//        ref.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                NotificationCompat.Builder b = new NotificationCompat.Builder(getApplicationContext());
//                b.setSmallIcon(android.R.drawable.arrow_up_float)
//                        .setContentText("noti from firebase")
//                        .setContentText(dataSnapshot.getValue().toString())
//                        .setAutoCancel(true);
//                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//                nm.notify(0, b.build());
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
    }
}
