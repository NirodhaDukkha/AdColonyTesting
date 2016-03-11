package com.example.dylan.adcolonytesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.async.callback.BackendlessCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.local.UserIdStorageFactory;
import com.example.dylan.adcolonytesting.data.BackendlessAd;
import com.jirbo.adcolony.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


public class MainActivity extends AppCompatActivity {


    AdColonyV4VCAd ad;
    int tempRewardCounter;
    String rewardValue;
    TextView localTextView;
    static String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdColony.configure(this, "version:1.0,store:google", "app185a7e71e1714831a49ec7", "vz1fd5a8b2bf6841a0a4b826");
        String appVersion = "v1";

        Backendless.initApp(this, "E23D224F-8760-2477-FF49-58DFA4E52200", "F644C5F3-AD0E-528D-FF0F-3C1E858AC000", appVersion);

        Backendless.UserService.login("nirodhadukkha@gmail.com", "pw", callback);


//        tempRewardCounter = 0;
//        rewardValue = Integer.toString(tempRewardCounter);
//        localTextView = (TextView) findViewById(R.id.textView);
//        localTextView.setText(rewardValue);


//        AdColonyV4VCListener listener = new AdColonyV4VCListener() {
//            @Override
//            public void onAdColonyV4VCReward(AdColonyV4VCReward reward) {
//
//                if (reward.success()){
//
//                    tempRewardCounter++;
//
//
//                }
//            }
//        };
//
//        AdColony.addV4VCListener(listener);
//
        Button btnVideo = (Button) findViewById(R.id.video_button);
//
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //createAd();

                ArrayList<BackendlessAd> adList = new ArrayList<BackendlessAd>();
                Object adsObj = Backendless.UserService.CurrentUser().getProperty("ads");

                if ((adsObj != null) && (adsObj instanceof BackendlessAd[]))
                {
                    BackendlessAd[] adsArray = (BackendlessAd[])adsObj;
                    adList = new ArrayList<BackendlessAd>(Arrays.asList(adsArray));
                }



                Backendless.Data.of(BackendlessUser.class).save(Backendless.UserService.CurrentUser(), new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser backendlessUser) {

                    }

                    @Override
                    public void handleFault(BackendlessFault backendlessFault) {

                    }
                });

//
//                Backendless.Persistence.save(consultation, new AsyncCallback<BackendlessAd>() {
//
//
//
//                    public void handleResponse(BackendlessAd response) {
//                        // new Contact instance has been saved
//                    }
//
//                    public void handleFault(BackendlessFault fault) {
//                        // an error has occurred, the error code can be retrieved with fault.getCode()
//                    }
//                });



//                ad = new AdColonyV4VCAd("vz1fd5a8b2bf6841a0a4b826");
//                ad.show();
            }
        });

    }



    private void createAd() {

        BackendlessAd backendlessAd = new BackendlessAd();
        backendlessAd.setAdName("test Ad 1");
        backendlessAd.setAdRating(7);
        ArrayList<BackendlessAd> adList = new ArrayList<BackendlessAd>();
        Object adsObj = Backendless.UserService.CurrentUser().getProperty("ads");
        if ((adsObj != null) && (adsObj instanceof BackendlessAd[]))
        {

            BackendlessAd[] consultations = (BackendlessAd[])adsObj;
            adList = new ArrayList<BackendlessAd>(Arrays.asList(consultations));
        }

        adList.add(backendlessAd);
        Backendless.UserService.CurrentUser().setProperty("ads", adList);
        Backendless.Data.of( BackendlessUser.class ).save(Backendless.UserService.CurrentUser(), new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser backendlessUser) {

            }

            @Override
            public void handleFault(BackendlessFault backendlessFault) {

            }
        });
    }

    @Override
    public void onPause()
    {
        super.onPause();
        AdColony.pause();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        AdColony.resume(this);
    }

    AsyncCallback<BackendlessUser> callback = new AsyncCallback<BackendlessUser>()
    {
        @Override
        public void handleResponse( BackendlessUser loggedInUser )
        {
            Log.d("debugg", "User has been logged in - " + loggedInUser.getObjectId());
            userID = loggedInUser.getObjectId();
        }
        @Override
        public void handleFault( BackendlessFault backendlessFault )
        {
            Log.d("debugg", "didn't work");
        }
    };
}
