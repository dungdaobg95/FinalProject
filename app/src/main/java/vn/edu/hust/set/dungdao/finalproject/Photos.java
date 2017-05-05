package vn.edu.hust.set.dungdao.finalproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by DungDao on 5/5/2017.
 */

public class Photos extends AppCompatActivity{
    GridView gridPhoto;
    String[] dataModel = {"lorem" , "ipsum", "dolor", "sit", "amet", "Contectetuer"};
    ArrayAdapter adapter = null;
    //Buoc 1 : khai bao Arraylist co ten la words
    private ArrayList<String> words = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_photo);
        gridPhoto = (GridView) findViewById(R.id.gridview_photo);
        initData();

        gridPhoto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Photos.this, words.get(position), Toast.LENGTH_SHORT).show();
                //Phan nay là khi bam vao album bat ky hien thi ra TOAN BO anh nam trong album do
            }
        });

        registerForContextMenu(gridPhoto);       // dang ki hien thi Listview cho Context_album

    }

    //===========Khoi tao du lieu dau vao de TEST ====================
    public void initData(){
        words = new ArrayList<String>();
        for(String s : dataModel){
            words.add(s);
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,words);

        gridPhoto.setAdapter(adapter);
    }
    //============Hien thi MENU ALBUMS ==============================
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.options_photo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_photo: {
                Toast.makeText(this, "Add Photo", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.add_music: {
                Toast.makeText(this, "Music", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.slide_show: {
                Toast.makeText(this, "Slide Show", Toast.LENGTH_SHORT).show();
                break;
            }

        }
        return true;
    }
//====================Ket thuc MENU========================================================

//======================Ham Add_Photo =====================

    // THEM ANH VAO DAY



    //==========Ham su dung CONTEXT de GIU VA XOA ALBUM ===============================
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_photo, menu);
    }
    //============================Ham xu ly su kien cho Context : Cap va Remove===========================================
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =  (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){


            case R.id.delete_photo: {
                words.remove(info.position);
                adapter.notifyDataSetChanged();
                break;
            }
        }

        return super.onContextItemSelected(item);
    }
}
