package com.sunny.androidlasttestgreendao;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.sunny.androidlasttestgreendao.adapter.MainPageAdapter;
import com.sunny.androidlasttestgreendao.bean.GreenDaoMess;
import com.sunny.androidlasttestgreendao.bean.NewsMess;
import com.sunny.androidlasttestgreendao.greendao.DaoMaster;
import com.sunny.androidlasttestgreendao.greendao.DaoSession;
import com.sunny.androidlasttestgreendao.greendao.GreenDaoMessDao;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainPageActivity extends AppCompatActivity {

    private RecyclerView page_recy_view;
    private String path = "{\"message\":\"请求成功\",\"code\":200,\"result\":[\n" +
            "{\"pic\":\"http://img2.imgtn.bdimg.com/it/u=1099905226,1865989804&fm=11&gp=0.jpg\"},\n" +
            "{\"pic\":\"http://img0.imgtn.bdimg.com/it/u=2000421042,3877694770&fm=11&gp=0.jpg\"},\n" +
            "{\"pic\":\"http://img0.imgtn.bdimg.com/it/u=2060095744,4097622156&fm=11&gp=0.jpg\"},\n" +
            "{\"pic\":\"http://img2.imgtn.bdimg.com/it/u=1354849427,261341415&fm=27&gp=0.jpg\"},\n" +
            "{\"pic\":\"http://img4.imgtn.bdimg.com/it/u=1420958888,769383764&fm=27&gp=0.jpg\"},\n" +
            "{\"pic\":\"http://img4.imgtn.bdimg.com/it/u=1404785160,1779522610&fm=27&gp=0.jpg\"},\n" +
            "{\"pic\":\"http://img0.imgtn.bdimg.com/it/u=1770117331,4173731409&fm=27&gp=0.jpg\"},\n" +
            "{\"pic\":\"http://img0.imgtn.bdimg.com/it/u=3111863248,4006579962&fm=27&gp=0.jpg\"},\n" +
            "{\"pic\":\"http://img5.imgtn.bdimg.com/it/u=463274617,209809588&fm=27&gp=0.jpg\"},\n" +
            "{\"pic\":\"http://img3.imgtn.bdimg.com/it/u=3842309048,726988343&fm=27&gp=0.jpg\"},\n" +
            "{\"pic\":\"http://img5.imgtn.bdimg.com/it/u=240658530,263639831&fm=27&gp=0.jpg\"},\n" +
            "{\"pic\":\"http://img5.imgtn.bdimg.com/it/u=2443193327,2070503668&fm=27&gp=0.jpg\"},\n" +
            "{\"pic\":\"http://img4.imgtn.bdimg.com/it/u=132141105,64538077&fm=27&gp=0.jpg\"},\n" +
            "{\"pic\":\"http://img2.imgtn.bdimg.com/it/u=4238562307,260872103&fm=27&gp=0.jpg\"},\n" +
            "{\"pic\":\"http://img4.imgtn.bdimg.com/it/u=1165470528,3392233394&fm=27&gp=0.jpg\"}\n" +
            "]}\n";
    private List<NewsMess.ResultBean> resultBeanList;
    private MainPageAdapter mainPageAdapter;
    private GreenDaoMessDao greenDaoMessDao;
    private List<GreenDaoMess> greenDaoMesses;
    //    private ImageMessDao imageMessDao;
    private int index;
    private List<GreenDaoMess> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        initView();
        init();
        initData();

    }

    private void init() {
        DaoMaster.DevOpenHelper image = new DaoMaster.DevOpenHelper(this, "img");
        DaoMaster daoMaster = new DaoMaster(image.getReadableDb());
        DaoSession daoSession = daoMaster.newSession();
        greenDaoMessDao = daoSession.getGreenDaoMessDao();


    }

    private void initData() {
        Gson gson = new Gson();
        NewsMess newsMess = gson.fromJson(path, NewsMess.class);
        resultBeanList = newsMess.getResult();
        for (int i = 0; i < resultBeanList.size(); i++) {
            greenDaoMessDao.insert(new GreenDaoMess(resultBeanList.get(i).getPic(), "张玗", "小实训"));
        }
        greenDaoMesses = greenDaoMessDao.loadAll();
        mList.addAll(greenDaoMesses);
        mainPageAdapter.notifyDataSetChanged();


    }

    private void initView() {
        mList = new ArrayList<>();
        page_recy_view = (RecyclerView) findViewById(R.id.page_recy_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        page_recy_view.setLayoutManager(gridLayoutManager);
        mainPageAdapter = new MainPageAdapter(mList, this);
        page_recy_view.setAdapter(mainPageAdapter);
        mainPageAdapter.OnShortListener(new MainPageAdapter.OnShortListener() {
            @Override
            public void setOnShortListener(View view, final int position) {
                index = position;
                new AlertDialog.Builder(MainPageActivity.this)
                        .setTitle("提示")
                        .setMessage("对数据进行操作")
                        .setPositiveButton("修改", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(MainPageActivity.this, AlertActivity.class);
                                intent.putExtra("mess", mList.get(index));
                                startActivityForResult(intent, 7);

                            }
                        })
                        .setNegativeButton("删除", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                greenDaoMessDao.delete(greenDaoMesses.get(index));
                                greenDaoMesses = greenDaoMessDao.loadAll();
                                mainPageAdapter.setData(greenDaoMesses);
                                mainPageAdapter.notifyDataSetChanged();
                            }
                        })
                        .create()
                        .show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 7 && resultCode == 8) {
            GreenDaoMess mess = (GreenDaoMess) data.getSerializableExtra("messTwo");
            GreenDaoMess greenDaoMess = greenDaoMesses.get(index);
            greenDaoMess.setName(mess.getName());
            greenDaoMess.setStage(mess.getStage());
//            greenDaoMesses.clear();
//            greenDaoMesses.set(index,mess);
            greenDaoMessDao.update(greenDaoMess);
            mList.clear();
            List<GreenDaoMess> greenDaoMesses = greenDaoMessDao.loadAll();
            mList.addAll(greenDaoMesses);
            // mainPageAdapter.setData(greenDaoMesses);
            mainPageAdapter.notifyDataSetChanged();
        }
    }
}
