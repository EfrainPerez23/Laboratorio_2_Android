package com.example.efrain.lab2;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openBrowser(View v) {
        this.intentAction(Intent.ACTION_VIEW,"http://www.google.com");
    }

    public void newFacebookIntent(View v2) {
        this.intentAction(Intent.ACTION_VIEW, "https://www.facebook.com/n/?");
    }

    public void sendEmail(View v3) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"efrain.abperez23@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
        i.putExtra(Intent.EXTRA_TEXT   , "body of email");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    public void openWifiConfig(View v4) {
        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
    }

    public void phoneCall(View v5) {
        this.intentAction(Intent.ACTION_DIAL, "tel:" + "+50763034461");
    }

    public void openContacts(View v6) {
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent, 1);
    }

    private void intentAction(String intentAction, String url) {
        Intent browserIntent = new Intent(intentAction, Uri.parse(url));
        startActivity(browserIntent);
    }
}
