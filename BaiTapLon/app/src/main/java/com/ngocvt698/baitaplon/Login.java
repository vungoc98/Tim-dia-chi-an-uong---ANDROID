package com.ngocvt698.baitaplon;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_main, menu);
        MenuItem listItem = menu.findItem(R.id.list);
        Drawable newIcon = (Drawable)listItem.getIcon();
        newIcon.mutate().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        listItem.setIcon(newIcon);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.list) {
            return true;
        }
        else if (item.getItemId() == R.id.home) {
            Intent i = new Intent(Login.this, MainActivity.class);
            // set the new task and clear flags
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
            return true;
        }
        else if (item.getItemId() == R.id.search) {
            startActivity(new Intent(Login.this, MainActivity.class));
            return true;
        }
        else if (item.getItemId() == R.id.notification) {
            startActivity(new Intent(Login.this, MainActivity.class));
            return true;
        }
        else if (item.getItemId() == R.id.location) {
            startActivity(new Intent(Login.this, MainActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
