package com.example.vikalpvashisth.rbsmtc;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";

    private TextView tvProName;
    private TextView tvProClass;
    private TextView tvProAdmn;
    private TextView tvProRollNo;
    private TextView tvProFather;
    private TextView tvProMother;
    private TextView tvProHouse;
    private TextView tvProDob;
    private TextView tvProFatherMobile;
    private TextView tvProMotherMobile;
    private TextView tvProBldGrp;

    private ProgressDialog dialog;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference user = db.document("RBSMTC/MCA/MCA(DD)8/admin@admin.com");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        dialog = new ProgressDialog(ProfileActivity.this);
        dialog.setMessage("Please Wait!!");
        dialog.show();

        tvProName = (TextView) findViewById(R.id.tvProName);
        tvProClass = (TextView) findViewById(R.id.tvProClass);
        tvProAdmn = (TextView) findViewById(R.id.tvProAdmn);
        tvProRollNo = (TextView) findViewById(R.id.tvProRollNo);
        tvProFather = (TextView) findViewById(R.id.tvProFather);
        tvProMother = (TextView) findViewById(R.id.tvProMother);
        tvProHouse = (TextView) findViewById(R.id.tvProHouse);
        tvProDob = (TextView) findViewById(R.id.tvProDob);
        tvProFatherMobile = (TextView) findViewById(R.id.tvProFatherMobile);
        tvProMotherMobile = (TextView) findViewById(R.id.tvProMotherMobile);
        tvProBldGrp = (TextView) findViewById(R.id.tvProBldGrp);

        loadData();
    }

    private void loadData() {

        user.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {

                            String Name = documentSnapshot.getString("name");
                            String Class = documentSnapshot.getString("class");
                            String Admn = documentSnapshot.getString("enrollment no");
                            String RollNo = documentSnapshot.getString("roll no");
                            String Father = documentSnapshot.getString("father");
                            String Mother = documentSnapshot.getString("mother");
                            String House = documentSnapshot.getString("address");
                            String Dob = documentSnapshot.getString("dob");
                            String FatherMobile = documentSnapshot.getString("father's no");
                            String MotherMobile = documentSnapshot.getString("mother's no");
                            String BldGrp = documentSnapshot.getString("blood group");

                            tvProName.setText(Name);
                            tvProClass.setText(Class);
                            tvProAdmn.setText(Admn);
                            tvProRollNo.setText(RollNo);
                            tvProFather.setText(Father);
                            tvProMother.setText(Mother);
                            tvProHouse.setText(House);
                            tvProDob.setText(Dob);
                            tvProFatherMobile.setText(FatherMobile);
                            tvProMotherMobile.setText(MotherMobile);
                            tvProBldGrp.setText(BldGrp);

                            dialog.dismiss();

                        } else {
                            Toast.makeText(ProfileActivity.this, "Document does not exists!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ProfileActivity.this, "Error!!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());
                    }
                });

    }
}
