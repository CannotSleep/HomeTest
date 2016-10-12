package com.feicui.administrator.hometest;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ListView;

import com.feicui.administrator.hometest.adapter.DiseaseAdapter;
import com.feicui.administrator.hometest.db.ThickEntry;
import com.feicui.administrator.hometest.entity.MyIness;
import com.feicui.administrator.hometest.fragment.EightFragment;
import com.feicui.administrator.hometest.fragment.FiveFragment;
import com.feicui.administrator.hometest.fragment.FourFragment;
import com.feicui.administrator.hometest.fragment.NineFragment;
import com.feicui.administrator.hometest.fragment.OneFragment;
import com.feicui.administrator.hometest.fragment.SevenFragment;
import com.feicui.administrator.hometest.fragment.SixFragment;
import com.feicui.administrator.hometest.fragment.TenFragment;
import com.feicui.administrator.hometest.fragment.ThreeFragment;
import com.feicui.administrator.hometest.fragment.TwoFragment;
import com.feicui.administrator.hometest.login.Goin;
import com.feicui.administrator.hometest.login.Login;
import com.feicui.administrator.hometest.view.SlidingMenu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private SlidingMenu mMenu;
    ListView mListView;
    DiseaseAdapter ptAdapter;
    ViewPager mViewPager;
    List<Fragment> mFragmentList;
    OneFragment mOneFragment;
    TwoFragment mTwoFragment;
    ThreeFragment mThreeFragment;
    FourFragment mFourFragment;
    FiveFragment mFiveFragment;
    SixFragment mSixFragment;
    SevenFragment mSevenFragment;
    EightFragment mEightFragment;
    NineFragment mNineFragment;
    TenFragment mTenFragment;
    //屏幕宽度
    int screenWidth;
    //当前选中的项
    int currenttab=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mMenu= (SlidingMenu) findViewById(R.id.menu_id);
        mListView= (ListView) findViewById(R.id.menu_list);
        mViewPager= (ViewPager) findViewById(R.id.viewpager);
        mFragmentList=new ArrayList<Fragment>();
        mOneFragment=new OneFragment();
        mTwoFragment=new TwoFragment();
        mThreeFragment=new ThreeFragment();
        mFourFragment=new FourFragment();
        mFiveFragment=new FiveFragment();
        mSixFragment=new SixFragment();
        mSevenFragment=new SevenFragment();
        mEightFragment=new EightFragment();
        mNineFragment=new NineFragment();
        mTenFragment=new TenFragment();

        mFragmentList.add(mOneFragment);
        mFragmentList.add(mTwoFragment);
        mFragmentList.add(mThreeFragment);
        mFragmentList.add(mFourFragment);
        mFragmentList.add(mFiveFragment);
        mFragmentList.add(mSixFragment);
        mFragmentList.add(mSevenFragment);
        mFragmentList.add(mEightFragment);
        mFragmentList.add(mNineFragment);
        mFragmentList.add(mTenFragment);


        screenWidth=getResources().getDisplayMetrics().widthPixels;
        mViewPager.setAdapter(new MyFrageStatePagerAdapter(getSupportFragmentManager()));
        new initTask().execute();


    }



    class MyFrageStatePagerAdapter extends FragmentStatePagerAdapter
    {

        public MyFrageStatePagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        /**
         * 每次更新完成ViewPager的内容后，调用该接口，此处复写主要是为了让导航按钮上层的覆盖层能够动态的移动
         */
        @Override
        public void finishUpdate(ViewGroup container)
        {
            super.finishUpdate(container);//这句话要放在最前面，否则会报错
            //获取当前的视图是位于ViewGroup的第几个位置，用来更新对应的覆盖层所在的位置
            int currentItem=mViewPager.getCurrentItem();
            if (currentItem==currenttab)
            {
                return ;
            }
            imageMove(mViewPager.getCurrentItem());
            currenttab=mViewPager.getCurrentItem();
        }

    }
    /**
     * 移动覆盖层
     * @param moveToTab 目标Tab，也就是要移动到的导航选项按钮的位置
     * 第一个导航按钮对应0，第二个对应1，以此类推
     */
    private void imageMove(int moveToTab)
    {
        int startPosition=0;
        int movetoPosition=0;

        startPosition=currenttab*(screenWidth/4);
        movetoPosition=moveToTab*(screenWidth/4);
        //平移动画
        TranslateAnimation translateAnimation=new TranslateAnimation(startPosition,movetoPosition, 0, 0);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(200);
    }

    //手动设置ViewPager要显示的视图
    private void changeView(int desTab)
    {
        mViewPager.setCurrentItem(desTab, true);
    }

    public void toggleMenu(View view)
    {
        mMenu.toggle();
    }

    /**
     * 从raw文件中导入岁apk发布的数据库
     */
    private void importDatabase() {
        try {
            //根据固定路径创建数据库目录，若数据库目录不存在，创建单层目录
            File dirFile = new File(ThickEntry.DATABASE_PATH);
            if (!dirFile.exists()) {
                dirFile.mkdir();
            }
            //创建被导入的数据库File对象
            File file = new File(ThickEntry.DATABASE_PATH, "thick.db");
            //判断文件是否存在，如不存在则创建该文件，存在就直接返回
            if (!file.exists()) {
                file.createNewFile();
            } else {
                return;
            }
            //获得加载数据库文件的输入流
            InputStream in = getResources().openRawResource(R.raw.thick);
            //创建将被导入的数据库输出流
            FileOutputStream out = new FileOutputStream(file);
            //创建缓冲区
            byte[] buffer = new byte[1024];
            //将数据读入缓冲区，并写入输出流
            while (in.read(buffer) != -1) {
                //将缓冲区中的数据写入输出流
                out.write(buffer);
                //更新缓冲区
                buffer = new byte[1024];
            }
            //关闭输入输出流
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 初始化电话类型列表
     */
    private void initList() {
        //通过打开固定路径的方式 获取可读的database的对象
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(
                ThickEntry.DATABASE_PATH + "/thick.db", null
        );
        //查询数据库,返回一个游标
        Cursor cursor = db.query(ThickEntry.TABALE_NAME, //表名
                new String[]{ThickEntry.COLUMNS_TYPE_NAME, //父表第二列内容
                        ThickEntry.COLUMNS_PHONE_TYPE_SUBTABLE},  // 父表第三列内容
                null, //相当于where 语句
                null, //Where args 下标
                null, //GROUP BY
                null, //HAVING
                null //ORDER BY
        );
        //将游标移动到第一行
        cursor.moveToFirst();
        //建立实体对象集合
        final ArrayList<MyIness> datalist = new ArrayList<MyIness>();
        do {
            //将游标中父表第二列的数据遍历取出
            String typeName = cursor.getString(
                    cursor.getColumnIndexOrThrow(ThickEntry.COLUMNS_TYPE_NAME)
            );
            //将游标中父表第三列的数据遍历取出
            String subTableName = cursor.getString(
                    cursor.getColumnIndexOrThrow(ThickEntry.COLUMNS_PHONE_TYPE_SUBTABLE)
            );
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //装载进实体类中
            MyIness phoneType = new MyIness();
            //设置实体类的属性
            phoneType.setName(typeName);
            phoneType.setSubname(subTableName);
            //装载进实体类到集合中
            datalist.add(phoneType);
        } while (cursor.moveToNext());
        //初始化适配器
        ptAdapter = new DiseaseAdapter(this, datalist);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> view, View view1, int i, long l) {
                switch (datalist.get(i).getSubname()){
                    case ThickEntry.SUB_ARM:
                        changeView(0);
                    break;
                    case ThickEntry.SUB_BLOOD :
                        changeView(1);
                    break;
                    case ThickEntry.SUB_DOWM:
                        changeView(2);
                    break;
                    case ThickEntry.SUB_FORGET:
                        changeView(3);
                    break;
                    case ThickEntry.SUB_EAR:
                        changeView(4);
                    break;
                    case ThickEntry.SUB_HIGH:
                        changeView(5);
                        break;
                    case ThickEntry.SUB_FAT:
                        changeView(6);
                        break;
                    case ThickEntry.SUB_BREATH:
                        changeView(7);
                        break;
                    case ThickEntry.SUB_HEART:
                        changeView(8);
                        break;
                    case ThickEntry.SUB_SUGAR:
                        changeView(9);
                        break;
                }
            }
        });
    }

    /**
     * 开启异步线程的操作类
     */

    class initTask extends AsyncTask<Void, Void, Void> {

        //任务启动后在异步线程中执行的代码 ，不可操作UI
        @Override
        protected Void doInBackground(Void... voids) {
            //装载数据库文件
            importDatabase();
            //设置listview
            initList();
            return null;
        }

        //任务启动之前的操作，可操作UI
        @Override
        protected void onPreExecute() {
            //让loading 界面显示
          //  linea_loading.setVisibility(View.VISIBLE);
        }

        //任务完成之后的操作，可操作UI
        @Override
        protected void onPostExecute(Void aVoid) {
//            //隐藏loading界面
//            linea_loading.setVisibility(View.GONE);
//            //给listview配置适配器
            mListView.setAdapter(ptAdapter);
        }
    }

    public void design(View view) {
        Intent intent4 = getIntent();
        String name = intent4.getStringExtra("username");
//            if (ok.equals("1")) {
//                String username1 = intent4.getStringExtra("username");
//                Intent intent6 = new Intent(this, Goin.class);
//                intent6.putExtra("username", username1);
//                startActivity(intent6);
//            } else {
                Intent intent = new Intent(MainActivity.this, Goin.class);
                intent.putExtra("username",name);
                startActivity(intent);
                finish();
//            }
    }


}
