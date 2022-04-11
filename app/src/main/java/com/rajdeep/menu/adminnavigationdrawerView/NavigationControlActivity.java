package com.rajdeep.menu.adminnavigationdrawerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;


import com.rajdeep.menu.DashboardFragment;
import com.rajdeep.menu.R;
import com.rajdeep.menu.adminnavigationdrawerView.adminAdapter.adminDrawerAdapter;
import com.rajdeep.menu.adminnavigationdrawerView.adminModel.Admin_Model_Menu_Child;
import com.rajdeep.menu.adminnavigationdrawerView.adminModel.Admin_Model_menu_name;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class NavigationControlActivity extends AppCompatActivity {

    ArrayList<Admin_Model_menu_name> al_main = new ArrayList<>();
    ExpandableListView ev_list;
    adminDrawerAdapter obj_adapter;
    String TAG = "MainActivity";
    private DrawerLayout mDrawerLayout;

    TextView tv_name;
    RelativeLayout rl_menu, rl_menu_back_arrow, rel_nav_admin_header, rel_nav_admin_header_back_arrow;
    ImageView iv_image;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // setContentView(R.layout.navigation_drawer_activity_retailer_main);
        setContentView(R.layout.navigation_drawer_activity_admin_main);
        fn_data();
        init();
        LoadDashboardragment();
    }

    private void init() {

//        getSupportActionBar().hide();
        ev_list = (ExpandableListView) findViewById(R.id.ev_menu);


        ImageView notification_bell = (ImageView) findViewById(R.id.notification_bell);
        notification_bell.setVisibility(View.GONE);

        tv_name = (TextView) findViewById(R.id.tv_name);
        rl_menu = (RelativeLayout) findViewById(R.id.rl_menu);
        rl_menu_back_arrow = (RelativeLayout) findViewById(R.id.rl_menu_back_arrow);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        iv_image = (ImageView) findViewById(R.id.iv_image);
        obj_adapter = new adminDrawerAdapter(NavigationControlActivity.this, al_main);
        ev_list.setAdapter(obj_adapter);
        ev_list.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                setListViewHeight(parent, groupPosition);
                return false;
            }
        });



        setExpandableListViewHeightBasedOnChildren(ev_list);

        rel_nav_admin_header = (RelativeLayout) findViewById(R.id.rel_nav_admin_header);
        rel_nav_admin_header_back_arrow = (RelativeLayout) findViewById(R.id.rel_nav_admin_header_back_arrow);

        tv_name.setText("Dashboard ");


        rl_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Keyboard.hideKeyboardwithoutPopulate(DashboardActivity.this);
                mDrawerLayout.openDrawer(Gravity.LEFT);
//                CallWorkManagerForWeatherService.createServiceForWeather(DashboardActivity.this);

            }
        });
        //    setImageProfileName();


        ev_list.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                for (int g = 0; g < 5; g++) {
                    if (g != groupPosition) {
                        ev_list.collapseGroup(g);
                    }
                }
            }
        });


        mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View view, float v) {

            }

            @Override
            public void onDrawerOpened(View view) {

            }

            @Override
            public void onDrawerClosed(View view) {
                // your refresh code can be called from here

                for (int g = 0; g < 5; g++) {

                    ev_list.collapseGroup(g);

                }


            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });

        rl_menu_back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();

            }
        });

    }



    private void setListViewHeight(ExpandableListView listView, int group) {
        ExpandableListAdapter listAdapter = (ExpandableListAdapter) listView.getExpandableListAdapter();
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.EXACTLY);
        for (int i = 0; i < listAdapter.getGroupCount(); i++) {
            View groupItem = listAdapter.getGroupView(i, false, null, listView);
            groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

            totalHeight += groupItem.getMeasuredHeight();

            if (((listView.isGroupExpanded(i)) && (i != group))
                    || ((!listView.isGroupExpanded(i)) && (i == group))) {
                for (int j = 0; j < listAdapter.getChildrenCount(i); j++) {
                    View listItem = listAdapter.getChildView(i, j, false, null,
                            listView);
                    listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

                    totalHeight += listItem.getMeasuredHeight();

                }
            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        int height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getGroupCount() - 1));
       /* if (height < 10)
            height = 200;*/
        params.height = height;
        listView.setLayoutParams(params);
        listView.requestLayout();

    }

    private void fn_data() {

        String str_data = loadJSONFromAsset();

        try {
            JSONObject jsonObject_country = new JSONObject(str_data);
            JSONArray jsonArray_country = jsonObject_country.getJSONArray("DrawerLayout");
            al_main = new ArrayList<>();
            for (int i = 0; i < jsonArray_country.length(); i++) {
                Admin_Model_menu_name obj_country = new Admin_Model_menu_name();
                JSONObject jsonObject = jsonArray_country.getJSONObject(i);
                JSONArray jsonArray_menu_childe = jsonObject.getJSONArray("menu_childe");
                ArrayList<Admin_Model_Menu_Child> al_dishes = new ArrayList<>();
                for (int j = 0; j < jsonArray_menu_childe.length(); j++) {

                    JSONObject jsonObject_dishes = jsonArray_menu_childe.getJSONObject(j);
                    Admin_Model_Menu_Child obj_dish = new Admin_Model_Menu_Child();
                    obj_dish.setStr_child_name(jsonObject_dishes.getString("child_name"));
                    obj_dish.setStr_description(jsonObject_dishes.getString("description"));
                    obj_dish.setStr_image(jsonObject_dishes.getString("image"));
                    al_dishes.add(obj_dish);
                }

                obj_country.setAl_state(al_dishes);
                obj_country.setStr_DrawerLayoutRoot(jsonObject.getString("menu_name"));

                al_main.add(obj_country);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public static void setExpandableListViewHeightBasedOnChildren(ExpandableListView expandableListView) {
        adminDrawerAdapter adapter = (adminDrawerAdapter) expandableListView.getExpandableListAdapter();
        if (adapter == null) {
            return;
        }
        int totalHeight = expandableListView.getPaddingTop() + expandableListView.getPaddingBottom();
        for (int i = 0; i < adapter.getGroupCount(); i++) {
            View groupItem = adapter.getGroupView(i, false, null, expandableListView);
            groupItem.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
            totalHeight += groupItem.getMeasuredHeight();

            if (expandableListView.isGroupExpanded(i)) {
                for (int j = 0; j < adapter.getChildrenCount(i); j++) {
                    View listItem = adapter.getChildView(i, j, false, null, expandableListView);
                    listItem.setLayoutParams(new ViewGroup.LayoutParams(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED));
                    listItem.measure(View.MeasureSpec.makeMeasureSpec(0,
                            View.MeasureSpec.UNSPECIFIED), View.MeasureSpec
                            .makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                    totalHeight += listItem.getMeasuredHeight();

                }
            }
        }

        ViewGroup.LayoutParams params = expandableListView.getLayoutParams();
        int height = totalHeight + expandableListView.getDividerHeight() * (adapter.getGroupCount() - 1);

        if (height < 10)
            height = 100;
        params.height = height;
        expandableListView.setLayoutParams(params);
        expandableListView.requestLayout();
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = getAssets().open("admin_menu.json");


            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        Log.e(TAG, "Json response " + json);
        return json;

    }

    public void fn_selectedPosition(int group, int child) {


    }


    public void fn_selectedPosition(int group) {


        new LoadListOFDrawerNavigation().execute();




    }


    @Override
    protected void onResume() {
        super.onResume();
    }



    public void LoadDashboardragment(){

        DashboardFragment newFragment = new DashboardFragment();
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, newFragment);
        transaction.commit();
        tv_name.setText("Dashboard");
//        header_farmpal.setVisibility(View.VISIBLE);
//        header_kisan.setVisibility(View.VISIBLE);
//        tv_name.setText(getResources().getString(R.string.profile));
    }

    public class LoadListOFDrawerNavigation extends AsyncTask<Void, Void, Void> {


        public LoadListOFDrawerNavigation() {

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mDrawerLayout.closeDrawer(Gravity.LEFT);

        }
    }

}
