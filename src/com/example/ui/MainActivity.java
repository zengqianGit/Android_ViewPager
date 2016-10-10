package com.example.ui;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.Window;
import android.widget.ImageView;

public class MainActivity extends FragmentActivity {
	private ViewPager mViewPager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> mFragments;
	
	private ImageView ivweixin;
	private ImageView ivfriend;
	private ImageView ivaddress;
	private ImageView ivsetting;
	private Fragment Weixin;
	private Fragment Friend;
	private Fragment Address;
	private Fragment Setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);// ��������    
        setContentView(R.layout.activity_main);
        
        ivweixin = (ImageView)findViewById(R.id.ivWeixin);
        ivfriend = (ImageView)findViewById(R.id.ivFriend);
        ivaddress = (ImageView)findViewById(R.id.ivAddress);
        ivsetting = (ImageView)findViewById(R.id.ivSetting);
        ivweixin.setImageResource(R.drawable.tab_weixin_pressed);
        
        //�ڳ�ʼ��ʱ����ViewPager���󣬲��������������󣨸�д����������������getItem(int)��getCount()��
        mFragments = new ArrayList<Fragment>();
        Weixin = new WeiXinFragment();
        Friend = new FriendFragment();
        Address = new AddressFragment();
        Setting = new SettingFragment();
        
        mFragments.add(Weixin);
        mFragments.add(Friend);
        mFragments.add(Address);
        mFragments.add(Setting);
        
        mViewPager = (ViewPager)findViewById(R.id.vpContent);
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()){
			public Fragment getItem(int arg0) {
				// TODO Auto-generated method stub
				return mFragments.get(arg0);
			}
			public int getCount() {
				// TODO Auto-generated method stub
				return mFragments.size();
			}
        };
        
        //����ViewPager��������������Լ�ViewPager����Ļ�����������ı��¼����������룬��ʵ�ַ���
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new OnPageChangeListener(){
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			public void onPageSelected(int arg0) {
				int i = mViewPager.getCurrentItem();
				setTab(i);
			}
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }    
    
    private void resetImgs(){
    	ivweixin.setImageResource(R.drawable.tab_weixin_normal);
		ivfriend.setImageResource(R.drawable.tab_find_frd_normal);
		ivaddress.setImageResource(R.drawable.tab_address_normal);
		ivsetting.setImageResource(R.drawable.tab_settings_normal);
    }
    
    private void setTab(int i) {
		resetImgs();
		// ����ͼƬΪ��ɫ
		// �л���������
		switch (i) {
		case 0:
			ivweixin.setImageResource(R.drawable.tab_weixin_pressed);
			break;
		case 1:
			ivfriend.setImageResource(R.drawable.tab_find_frd_pressed);
			break;
		case 2:
			ivaddress.setImageResource(R.drawable.tab_address_pressed);
			break;
		case 3:
			ivsetting.setImageResource(R.drawable.tab_settings_pressed);
			break;
		}
    }
}
