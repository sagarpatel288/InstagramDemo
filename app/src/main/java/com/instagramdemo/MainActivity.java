package com.instagramdemo;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.instagramdemo.adapter.InstaAdapter;
import com.instagramdemo.inteface.EditFocus;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements EditFocus {

    private RecyclerView rv_comment;
    private ArrayList<String> nameList = new ArrayList<>();
    private EditText edit_comment;
    private LinearLayoutManager linearLayoutManager;
    private InstaAdapter instaAdapter;
    private int deviceHeight = 1920;
    private RelativeLayout rl_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_comment = findViewById(R.id.rv_comment);
        edit_comment = findViewById(R.id.edit_comment);
        rl_root = findViewById(R.id.rl_root);

        nameList=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.nameList)));

        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rv_comment.setLayoutManager(linearLayoutManager);

        instaAdapter = new InstaAdapter(MainActivity.this, nameList, this);
        rv_comment.setAdapter(instaAdapter);


//        getViewTreeObserver better way for find keyboard height
//        rl_root.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(){
//            public void onGlobalLayout(){
//                int heightDiff = rl_root.getRootView().getHeight()- rl_root.getHeight();
//                // IF height diff is more then 150, consider keyboard as visible.
//                Log.d("heightDif",""+heightDiff);
//                //1677+243 keyboard height
//                rv_comment.getHeight();//height 1526
//
//            }
//        });

//        getDeviceHeightAndWidth();

    }

    public void getDeviceHeightAndWidth() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        Log.e("Width", "" + width);
        Log.e("height", "" + height);
        //width 1080
        //height 1920
    }

    @Override
    public void OpenKeyboard(int position) {
        edit_comment.requestFocus();
        InputMethodManager inputMethodManager =
                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

            inputMethodManager.toggleSoftInputFromWindow(edit_comment.getApplicationWindowToken(),
                    InputMethodManager.SHOW_FORCED, 0);this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


//        rv_comment.getLayoutManager().scrollToPosition(position);
//        rv_comment.setBottom(position);
//        rv_comment.getLayoutManager().findViewByPosition(position).scrollTo(0,1920);
//        linearLayoutManager.findViewByPosition(position).scrollTo(0, 0);
//        rv_comment.getLayoutManager().scrollToPosition(position);
//        rv_comment.getHeight();
//        rv_comment.getLayoutManager().findViewByPosition(position).scrollTo(0,0);
//        rv_comment.smoothScrollToPosition(position);
//        linearLayoutManager.scrollToPositionWithOffset(position, 0);
//        rv_comment.getLayoutManager().scrollToPosition(position);

        linearLayoutManager.scrollToPositionWithOffset(position, 1300);

    }
}
