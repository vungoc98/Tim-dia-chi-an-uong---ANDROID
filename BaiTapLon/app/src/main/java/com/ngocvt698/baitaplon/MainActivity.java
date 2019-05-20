package com.ngocvt698.baitaplon;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Food> model = new ArrayList<Food>();
    FoodAdapter adapter = null;
    ListView list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 10 ; i++) {
            model.add(new Food());
        }
        list = (ListView)findViewById(R.id.foods);
        adapter = new FoodAdapter();
        list.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_main, menu);
        MenuItem homeItem = menu.findItem(R.id.home);
        Drawable newIcon = (Drawable)homeItem.getIcon();
        newIcon.mutate().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        homeItem.setIcon(newIcon);
        return super.onCreateOptionsMenu(menu);
    }

    // thay doi mau sac cua menu
    public void changeColorIcon(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (item.getItemId() == R.id.home) {
            drawable.mutate();
            drawable.clearColorFilter();
            drawable.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.list) {
            startActivity(new Intent(MainActivity.this, Login.class));
            return true;
        }
        else if (item.getItemId() == R.id.home) {
            return true;
        }
        else if (item.getItemId() == R.id.search) {
            startActivity(new Intent(MainActivity.this, MainActivity.class));
            return true;
        }
        else if (item.getItemId() == R.id.notification) {
            startActivity(new Intent(MainActivity.this, MainActivity.class));
            return true;
        }
        else if (item.getItemId() == R.id.location) {
            startActivity(new Intent(MainActivity.this, MainActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    class FoodAdapter extends ArrayAdapter<Food> {
        FoodAdapter() {
            super(MainActivity.this, R.layout.row, model);
        }

        public View getView(int position, View convertView,
                            ViewGroup parent) {
            View row=convertView;
            FoodHolder holder=null;

            if (row==null) {
                LayoutInflater inflater=getLayoutInflater();

                row=inflater.inflate(R.layout.row, parent, false);
                holder=new FoodHolder(row);
                row.setTag(holder);
            }
            else {
                holder=(FoodHolder) row.getTag();
            }

            holder.populateFrom(model.get(position));

            return(row);
        }
    }
    static class FoodHolder {
        TextView name = null;
        TextView km = null;
        TextView address = null;
        TextView price = null;
        ImageView image = null;
        public FoodHolder(View row) {
            name = (TextView)row.findViewById(R.id.name);
            km = (TextView)row.findViewById(R.id.km);
            address = (TextView)row.findViewById(R.id.address);
            price = (TextView)row.findViewById(R.id.price);
            image = (ImageView)row.findViewById(R.id.image);
        }

        public void populateFrom(Food f) {
            name.setText(f.getName());
            km.setText(f.getKm() + "km");
            address.setText(f.getAddress());
            price.setText(f.getPrice() + "VND");
            image.setImageResource(R.drawable.fb);
        }
    }
}
