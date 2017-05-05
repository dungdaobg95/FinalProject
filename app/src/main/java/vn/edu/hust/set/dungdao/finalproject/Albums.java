package vn.edu.hust.set.dungdao.finalproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by DungDao on 5/5/2017.
 */

public class Albums extends AppCompatActivity {
    String[] dataModel = {"lorem" , "ipsum", "dolor", "sit", "amet", "Contectetuer"};
    ListView list_album;
    ArrayAdapter adapter = null;
    //Buoc 1 : khai bao Arraylist co ten la words
    private ArrayList<String> words = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_albums);
        list_album = (ListView)findViewById(R.id.list_album);
        initData();

        list_album.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Albums.this, words.get(position), Toast.LENGTH_SHORT).show();
                Intent photo = new Intent(Albums.this, Photos.class);
                startActivity(photo);
                //Phan nay là khi bam vao album bat ky hien thi ra TOAN BO anh nam trong album do
            }
        });

        registerForContextMenu(list_album);       // dang ki hien thi Listview cho Context_album

    }

    //===========Khoi tao du lieu dau vao de TEST ====================
    public void initData(){
        words = new ArrayList<String>();
        for(String s : dataModel){
            words.add(s);
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,words);

        list_album.setAdapter(adapter);
    }
    //============Hien thi MENU ALBUMS ==============================
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.options_albums, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_album: {
                Toast.makeText(this, "Albums", Toast.LENGTH_SHORT).show();
                processMenuAdd();
                break;
            }

        }
        return true;
    }
//====================Ket thuc MENU========================================================

//======================Ham Add_album =====================

    public void processMenuAdd(){
        final View addView = getLayoutInflater().inflate(R.layout.add_album, null); // Giao dien hien thi cho Dialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        //dialog.setTitle("Thêm một từ mới");
        dialog.setView(addView); // setView la de hien thi giao dien cua minh
        //dialog.setMessage("Bạn sẽ nhập từ mới ở đây");

        //-------------Xu ly su kien khi bam nut OK -----------------------
        DialogInterface.OnClickListener okProcess = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                EditText editText = (EditText)addView.findViewById(R.id.dialog_edit);  //Tim kiem dua vao id
                String newWord = editText.getText().toString();
                adapter.add(newWord);       // Them vao Adapter va mac dinh them vao ca Words
            }
        };
        dialog.setPositiveButton("Ok", okProcess);
        dialog.setNegativeButton("Cancel", null);
        dialog.show(); // hien thi dialog

    }
//==========Ham su dung CONTEXT de GIU VA XOA ALBUM ===============================
@Override
public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    super.onCreateContextMenu(menu, v, menuInfo);
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.context_album, menu);
}
    //============================Ham xu ly su kien cho Context : Cap va Remove===========================================
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =  (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){


            case R.id.delete_album: {
                words.remove(info.position);
                adapter.notifyDataSetChanged();
                break;
            }
        }

        return super.onContextItemSelected(item);
    }
}
