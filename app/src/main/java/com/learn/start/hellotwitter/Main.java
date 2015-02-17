package com.learn.start.hellotwitter;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.text.TextUtils;
import android.widget.Toast;

public class Main extends Activity {

    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences prefs = getSharedPreferences("codelearn_twitter", MODE_PRIVATE);

        String savedUsername = prefs.getString("username", null);

        String savedPassword = prefs.getString("password", null);

        if (!savedUsername.isEmpty() && !savedPassword.isEmpty()) {
            //we can skip login screen

            Intent intent = new Intent(this, TweetListActivity.class);

            startActivity(intent);

            finish();
        }

        setContentView(R.layout.activity_main);

        super.onCreate(savedInstanceState);

        loginButton = (Button) findViewById(R.id.btn_login);

        final EditText username = (EditText)findViewById(R.id.fld_username);

        final EditText password = (EditText)findViewById(R.id.fld_password);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String userNameValue = username.getText().toString();

                    String passwordValue = password.getText().toString();

                    if(TextUtils.isEmpty(userNameValue)) {
                        username.setError("Your message");
                        return;
                    }

                    SharedPreferences prefs = getSharedPreferences("codelearn_twitter", MODE_PRIVATE);

                    SharedPreferences.Editor editor = prefs.edit();

                    editor.putString("username", userNameValue);

                    editor.putString("password", passwordValue);

                    editor.commit();

                    Toast.makeText(Main.this, userNameValue, Toast.LENGTH_SHORT).show();

                    Log.d("Manu", "username caught -" + userNameValue);
                }catch (NullPointerException e) {
                    Log.d("Manu Exception", "username caught");
                }

                Intent intent = new Intent (Main.this, TweetListActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
