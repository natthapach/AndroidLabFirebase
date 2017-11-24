package cs.sci.ku.labfirebase;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by MegapiesPT on 23/11/2560.
 */

class FirebaseManager {
    private static FirebaseManager ourInstance;

    static FirebaseManager getInstance() {
        if (ourInstance == null)
            ourInstance = new FirebaseManager();
        return ourInstance;
    }

    private FirebaseManager() {

    }

    public void start(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("user");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d("user added", dataSnapshot.getValue().toString());

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.d("user change", dataSnapshot.getValue().toString());
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.d("user remove", dataSnapshot.getValue().toString());
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
