package com.example.conuhacks2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import com.google.android.gms.tasks.OnCompleteListener;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.Source;
import com.google.firestore.v1beta1.StructuredQuery;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.sql.DriverManager.println;


public class SwipingActivity extends AppCompatActivity {

    private ArrayList<String> al;
    private ArrayAdapter<String> arrayAdapter;
    private static final String TAG = "MainActivity";
    private int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        al = new ArrayList<>();

        arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.helloText, al );

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("project").document(
                "zo5GLB81bhp5xZ5ZPwz3 ");

        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(SwipingActivity.this, "it exist",Toast.LENGTH_SHORT).show();
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {

                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());

                           al.add(document.getString("name").toString());
                            println(document.getString("name").toString());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }

        });
        al.add("Hello");
        al.add("World");
        al.add("WHY");
        al.add("DONT");
        al.add("YOU");
        al.add("WORKKKKKK");

        setContentView(R.layout.activity_swiping);
        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);

        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                al.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                Toast.makeText(SwipingActivity.this,"Rejected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                Toast.makeText(SwipingActivity.this,"Accepted",Toast.LENGTH_SHORT).show();
                // this is where you should create an intent with an "extra" (extra info about the event that will be passed on to the next Activity)
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                al.add("XML ".concat(String.valueOf(i)));
                arrayAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                // View view = flingContainer.getSelectedView();
                //view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                //view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });

        super.onCreate(savedInstanceState);





    }
}
