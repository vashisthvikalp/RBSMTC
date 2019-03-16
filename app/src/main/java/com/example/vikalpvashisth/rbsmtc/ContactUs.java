package com.example.vikalpvashisth.rbsmtc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        Element adsElement = new Element();
        adsElement.setTitle("Advertise with us");

        String desc = "Raja Balwant Singh College, Agra (formerly Balwant Rajput College, Agra), was established way back in 1885 by Raja Balwant Singh Ji of Awagarh state.The college is having a number of faculties including Arts, Science, Education, Library Science and Agriculture and teaching at postgraduate level is done in as many as 31 subjects.In the year 2017, the college has added one more feather to its cap by getting accredited as A+ by NAAC. \n Faculty of Management & Computer Application ( FMCA ) was established in 1999 as one of the faculties of Raja Balwant Singh College, Agra under the aegis of Balwant Educational Society for imparting quality professional education to all the sections of the society. In 2012, FMCA got upgraded as \"Raja Balwant Singh Management Technacal Campus, Agra\" (RBSMTC, Agra).";

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription(desc)
                .setImage(R.drawable.ballu)
                .addItem(new Element().setTitle("Version 1.0"))
                .addItem(adsElement)
                .addGroup("Connect with us")
                .addEmail("director.rbsmtc@gmail.com")
                .addWebsite("http://www.rbsmtc.in/index.php/")
                .addFacebook("RBSMTC")
                .addTwitter("medyo80")
                .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
                .addInstagram("medyo80")
                .create();

        setContentView(aboutPage);
    }
}
