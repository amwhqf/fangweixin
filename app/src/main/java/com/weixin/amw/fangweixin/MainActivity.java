package com.weixin.amw.fangweixin;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.weixin.amw.fangweixin.main.addrbook.AddrBookFragment;
import com.weixin.amw.fangweixin.main.conversation.ConversationFragment;
import com.weixin.amw.fangweixin.main.find.FindFragment;
import com.weixin.amw.fangweixin.main.meprofile.MeProfileFragment;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private String[] mBottom_Title ;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private FragmentPagerAdapter mPagerAdapter;
    private Fragment[] mFragments;
    private TabLayout.Tab[] tabs;

    private Toolbar mToolBar;
    private TextView mToolBarText;
    private Menu menu;

    private int[] mBottomIcon = new int[]{R.drawable.message_bng,
        R.drawable.addrbook_bng,
        R.drawable.find_bng,
        R.drawable.me_bng};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    /**
     * @param view
     * @param menu
     * @hide
     */
    @SuppressLint("RestrictedApi")
    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (menu != null) {
            if (menu.getClass() == MenuBuilder.class) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                    //   Out.print(getClass().getSimpleName() + "onMenuOpened...unable to set icons for overflow menu" + e);
                    e.printStackTrace();
                }
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    }

    private void initView() {
        mBottom_Title = new String[]{getString(R.string.bottom_bar_title_message),
                getString(R.string.bottom_bar_title_addrbook),
                getString(R.string.bottom_bar_title_find),
                getString(R.string.bottom_bar_title_me)};
        mToolBar = (Toolbar)findViewById(R.id.main_toolbar);
        mTabLayout = findViewById(R.id.main_tablayout);
        mViewPager = findViewById(R.id.main_viewpager);
        mToolBarText = findViewById(R.id.main_toolbar_text);
        mFragments = new Fragment[]{new ConversationFragment(), new AddrBookFragment(), new FindFragment(), new MeProfileFragment()};
        //mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.tablayout_SelectedTabIndicatorColor));

        //final String toobBarTitle = new String(getResources().getString(R.string.app_name));
        //mToolBar.setTitle(toobBarTitle);
        setSupportActionBar(mToolBar);

        mToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments[position];
            }

            @Override
            public int getCount() {
                return mFragments.length;
            }

        };

        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        tabs = new TabLayout.Tab[mBottom_Title.length];

        for (int i = 0; i< mFragments.length;i++){
            tabs[i] = mTabLayout.getTabAt(i);
            tabs[i].setIcon(mBottomIcon[i]);
            tabs[i].setText(mBottom_Title[i]);
        }
        /*
        mTabLayout.addTab(mTabLayout.newTab().setText(mBottom_Title[0].toString()).setIcon(mBottomIcon[0]));
        mTabLayout.addTab(mTabLayout.newTab().setText(mBottom_Title[1].toString()).setIcon(mBottomIcon[1]));
        mTabLayout.addTab(mTabLayout.newTab().setText(mBottom_Title[2].toString()).setIcon(mBottomIcon[2]));
        mTabLayout.addTab(mTabLayout.newTab().setText(mBottom_Title[3].toString()).setIcon(mBottomIcon[3]));
        */
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mToolBarText.setText(tab.getText().toString());
                /*if (tab.getPosition()==1)
                    mToolBar.setOverflowIcon(getResources().getDrawable(R.mipmap.icon_add_friend));*/

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
}
