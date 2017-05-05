package vn.edu.hust.set.dungdao.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton enterAlbum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterAlbum = (ImageButton)findViewById(R.id.imageBTN);
    }

    public void enterAlbum(View v){
        Toast.makeText(this, "Albums", Toast.LENGTH_SHORT).show();
                Intent album = new Intent(MainActivity.this, Albums.class);
                startActivity(album);
    }




//    //============Hien thi MENU ALBUMS ==============================
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //return super.onCreateOptionsMenu(menu);
//        getMenuInflater().inflate(R.menu.option_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.enter_albums:
//                Toast.makeText(this, "Albums", Toast.LENGTH_SHORT).show();
//                Intent album = new Intent(MainActivity.this, Albums.class);
//                startActivity(album);
//                break;
//
//        }
//        return true;
//    }
//====================Ket thuc MENU========================================================
}
