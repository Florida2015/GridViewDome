
package cn.edu.nuc.gridviewdome;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    private GridView mGridView;
    private ImageView mImageView;
    private GridViewAdpter mAdpter;

    private boolean isSingle = false;
    private List<String> mList1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        setContentView(R.layout.activity_main);
        //横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        mGridView = (GridView) findViewById(R.id.gv);
        mImageView = (ImageView) findViewById(R.id.image);
        mGridView.setOnItemClickListener(this);
        mImageView.setOnClickListener(this);

       mList =  new ArrayList<>();
        for (int i = 1; i < 15; i++) {
            mList.add("小米"+i);
        }

        mList1 = mList.subList(0,6);

        mAdpter = new GridViewAdpter(this,mList1);
        isSingle = false;
        mGridView.setAdapter(mAdpter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, mList.get(position), Toast.LENGTH_SHORT).show();
        

    }

    private  List<String> mList;
    @Override
    public void onClick(View v) {
        if (isSingle){
            mAdpter.addAll(mList1);
            isSingle=false;
        }else {
            mAdpter.addAll(mList);
            isSingle=true;
        }
    }
}
