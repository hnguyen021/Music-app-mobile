package com.example.myapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.Adapter.MainViewPagerAdapter;
import com.example.myapplication.Fragment.Fragment_Trang_Chu;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    Toolbar toolbar;
    public static boolean  temp = false;
    String txtUserName;
    //public static String keyword ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();
        setSupportActionBar(toolbar);
        //GettingStartToolBar();


        Intent intent2 = getIntent();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            temp = true;
            txtUserName =intent2.getStringExtra("Name");
            Toast.makeText(MainActivity.this, intent2.getStringExtra("Name"), Toast.LENGTH_LONG).show();
        }

    }
    private void GettingStartToolBar() {
        // setSupportActionBar(toolbar);//tao tool bar de back ve trang chu
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_login:
                Intent intent = new Intent(MainActivity.this,LogInActivity.class);
                // intent.putExtra("Email","");
                // startActivityForResult();
                startActivity(intent);
                break;
            case R.id.action_Register:
                Intent intent1 = new Intent(MainActivity.this,RegisterActivity.class);

                startActivity(intent1);
                break;
            case R.id.action_Setting:
                Toast.makeText(MainActivity.this,"Setting", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_Logout:
                //Toast.makeText(MainActivity.this,"Logout", Toast.LENGTH_LONG).show();
                temp = false;
                invalidateOptionsMenu();
                this.recreate();
                //startActivity(getIntent());


                break;
            case R.id.txtusername:
                item.setTitle(txtUserName);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if(temp == true){
            getMenuInflater().inflate(R.menu.menu_user_login,menu);
            menu.findItem(R.id.txtusername).setTitle("Xin Chào "+txtUserName);


            MenuItem item = menu.findItem(R.id.action_Search);
            androidx.appcompat.widget.SearchView searchView1 = (androidx.appcompat.widget.SearchView) item.getActionView();
            searchView1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    /*
                    Fragment_TimKiem fragment_timKiem = new Fragment_TimKiem();
                    Bundle bundle= new Bundle();
                    bundle.putString("keyword",query);
                    fragment_timKiem.setArguments(bundle);
                    FragmentManager fm = getSupportFragmentManager();
                    Fragment_TimKiem fragment_timKiem = new Fragment_TimKiem();
                    fm.beginTransaction().add(R.id.containerMainActivity,fragment_timKiem).commit();*/
                    Intent intent1 = new Intent(MainActivity.this,SearchSongActivity.class);
                    intent1.putExtra("keyword",  query);
                    startActivity(intent1);


                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
        }
        if(temp == false) {
            getMenuInflater().inflate(R.menu.menu, menu);
            MenuItem item = menu.findItem(R.id.action_Search);
            androidx.appcompat.widget.SearchView searchView1 = (androidx.appcompat.widget.SearchView) item.getActionView();
            searchView1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Intent intent1 = new Intent(MainActivity.this,SearchSongActivity.class);
                    intent1.putExtra("keyword",  query);
                    startActivity(intent1);

                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });

        }

        return super.onCreateOptionsMenu(menu);
    }


    private void init() {
        MainViewPagerAdapter mainViewPagerAdapter =new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_Trang_Chu());
        viewPager.setAdapter(mainViewPagerAdapter);


    }

    private void anhxa() {
        viewPager = findViewById(R.id.myViewPager);
        toolbar = findViewById(R.id.toolbarsearch);
    }

}
