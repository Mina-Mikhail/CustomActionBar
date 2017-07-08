package com.example.minasgerges.custom_action_bar;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // to setup Action Bar
        setUpActionBar();
    }

    private void setUpActionBar() {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        // the custom action bar layout file
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        // the color of the action bar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
        // make action bar support options menu
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        // to access any view in the action bar
        View view = getSupportActionBar().getCustomView();

        ImageView menu_BTN= (ImageView)view.findViewById(R.id.menuBTN);
        menu_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Navigation btn", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // layout file of options menu
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        // handle menu items
        if ( item.getItemId() == R.id.menu_item_search )
        {
            Toast.makeText(MainActivity.this, "search", Toast.LENGTH_SHORT).show();
        }
        else if ( item.getItemId() == R.id.menu_item_accsettings )
        {
            Toast.makeText(MainActivity.this, "settings", Toast.LENGTH_SHORT).show();
        }
        else if ( item.getItemId() == R.id.menu_item_allusers )
        {
            Toast.makeText(MainActivity.this, "users", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
