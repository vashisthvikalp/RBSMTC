package com.example.vikalpvashisth.rbsmtc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    private TextView textViewUserEmail;
    private CardView assignent;
    private CardView attendance;
    private CardView contactUs;
    private CardView ctMarks;
    private CardView ctSchedule;
    private CardView faculty;
    private CardView feeSummary;
    private CardView library;
    private CardView newsEvents;
    private CardView noticeBoard;
    private CardView profile;
    private CardView universityResult;
    private Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        textViewUserEmail = (TextView)findViewById(R.id.textViewUserEmail);
        textViewUserEmail.setText("Welcome "+ user.getEmail());

        buttonLogout = (Button)findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(this);

        assignent = (CardView) findViewById(R.id.cardViewAssignment);
        attendance = (CardView) findViewById(R.id.cardViewAttendance);
        contactUs = (CardView) findViewById(R.id.cardViewContactUS);
        ctMarks = (CardView) findViewById(R.id.cardViewCTMarks);
        ctSchedule = (CardView) findViewById(R.id.cardViewCTSchedule);
        faculty = (CardView) findViewById(R.id.cardViewFaculty);
        feeSummary = (CardView) findViewById(R.id.cardViewFeeSummary);
        library = (CardView) findViewById(R.id.cardViewLibrary);
        newsEvents = (CardView) findViewById(R.id.cardViewNewsEvents);
        noticeBoard = (CardView) findViewById(R.id.cardViewNoticeBoard);
        profile = (CardView) findViewById(R.id.cardViewProfile);
        universityResult = (CardView) findViewById(R.id.cardViewUniversityResult);

        assignent.setOnClickListener(this);
        attendance.setOnClickListener(this);
        contactUs.setOnClickListener(this);
        ctMarks.setOnClickListener(this);
        ctSchedule.setOnClickListener(this);
        faculty.setOnClickListener(this);
        feeSummary.setOnClickListener(this);
        library.setOnClickListener(this);
        newsEvents.setOnClickListener(this);
        noticeBoard.setOnClickListener(this);
        profile.setOnClickListener(this);
        universityResult.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view == buttonLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }



        switch (view.getId()){

            case R.id.cardViewAssignment:
                Toast.makeText(getApplicationContext(), "Assignment Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Assignment.class));
                break;

            case R.id.cardViewAttendance:
                Toast.makeText(getApplicationContext(), "Attendance Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Assignment.class));
                break;

            case R.id.cardViewContactUS:
                Toast.makeText(getApplicationContext(), "Contact US Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Assignment.class));
                break;

            case R.id.cardViewCTMarks:
                Toast.makeText(getApplicationContext(), "CT Marks Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Assignment.class));
                break;

            case R.id.cardViewCTSchedule:
                Toast.makeText(getApplicationContext(), "CT Schedule Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Assignment.class));
                break;

            case R.id.cardViewFaculty:
                Toast.makeText(getApplicationContext(), "Faculty Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Assignment.class));
                break;

            case R.id.cardViewFeeSummary:
                Toast.makeText(getApplicationContext(), "Fee Summary Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Assignment.class));
                break;

            case R.id.cardViewLibrary:
                Toast.makeText(getApplicationContext(), "Library Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Assignment.class));
                break;

            case R.id.cardViewNewsEvents:
                Toast.makeText(getApplicationContext(), "News & Events Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Assignment.class));
                break;

            case R.id.cardViewNoticeBoard:
                Toast.makeText(getApplicationContext(), "Notice Board Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Assignment.class));
                break;

            case R.id.cardViewProfile:
                Toast.makeText(getApplicationContext(), "Profile Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Assignment.class));
                break;

            case R.id.cardViewUniversityResult:
                Toast.makeText(getApplicationContext(), "University Result Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Assignment.class));
                break;

            case R.id.buttonLogout:
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(this,MainActivity.class));
                break;
        }

    }
}