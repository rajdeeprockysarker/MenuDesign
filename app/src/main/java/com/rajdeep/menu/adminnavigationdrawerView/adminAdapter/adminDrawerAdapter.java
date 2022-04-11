package com.rajdeep.menu.adminnavigationdrawerView.adminAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.rajdeep.menu.R;
import com.rajdeep.menu.adminnavigationdrawerView.NavigationControlActivity;
import com.rajdeep.menu.adminnavigationdrawerView.adminModel.Admin_Model_menu_name;

import java.util.ArrayList;


public class adminDrawerAdapter extends BaseExpandableListAdapter {
    Context context;
    ArrayList<Admin_Model_menu_name> al_menu_name;

    public adminDrawerAdapter(Context context, ArrayList<Admin_Model_menu_name> al_menu_name) {
        this.context = context;
        this.al_menu_name = al_menu_name;
    }

    @Override
    public int getGroupCount() {
        return al_menu_name.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return al_menu_name.get(i).getAl_state().size();
    }

    @Override
    public Object getGroup(int i) {
        return al_menu_name.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return al_menu_name.get(i).getAl_state().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int i, boolean b, View view, ViewGroup viewGroup) {
        TextView tv_state = null;
        ImageView img_nav_icon = null;

     //   if (view==null){

            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          //  view = layoutInflater.inflate(R.layout.navigation_drawer_adapter_retailer_header, null);
        view = layoutInflater.inflate(R.layout.navigation_drawer_adapter_admin_header, null);


      //  }
        tv_state = (TextView)view.findViewById(R.id.tv_name);
        img_nav_icon=(ImageView) view.findViewById(R.id.img_nav_icon);


        if(al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Home")||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("होम")||
        al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("होम")){
            img_nav_icon.setBackgroundResource(R.drawable.ic_launcher_background);
        }
        if(al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Import/Export Product")||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("प्रोफ़ाइल")||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("प्रोफाइल")){
            img_nav_icon.setBackgroundResource(R.drawable.ic_launcher_background);
        }
        if(al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Sales Rep")){
            img_nav_icon.setBackgroundResource(R.drawable.ic_launcher_background);
        }

        if(al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Retailer Report")){
            img_nav_icon.setBackgroundResource(R.drawable.ic_launcher_background);
        }
        if(al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Contact Us")){
            img_nav_icon.setBackgroundResource(R.drawable.ic_launcher_background);
        }
        if(al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Broadcast Coupon")){
            img_nav_icon.setBackgroundResource(R.drawable.ic_launcher_background);
        }

        if(al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Log Out")){
            img_nav_icon.setBackgroundResource(R.drawable.ic_launcher_background);
        }
        if(al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Choose Language")||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("भाषा निवडा")||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("भाषा चुनें")){
            img_nav_icon.setBackgroundResource(R.drawable.ic_launcher_background);
        }
        if(al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Log Out")||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("लॉग आउट")||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("लॉग आउट")){
            img_nav_icon.setBackgroundResource(R.drawable.ic_launcher_background);
        }

        if(al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Information")||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("माहिती")||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("जानकारी")){
            img_nav_icon.setBackgroundResource(R.drawable.ic_launcher_background);
        }

        if(al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Land and Crop Details")||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("भूमि और फसल विवरण")||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("जमीन व पिकाचा तपशील")){
            img_nav_icon.setBackgroundResource(R.drawable.ic_launcher_background);
        }
        if(al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Log Out")){
           // tv_state.setTextColor( ((AdminNavigationControlActivity)context).getResources().getColor(R.color.colorRedOrange));
        }
        else{
       //     tv_state.setTextColor( ((AdminNavigationControlActivity)context).getResources().getColor(R.color.colorBlack));
        }


        tv_state.setText(al_menu_name.get(i).getStr_DrawerLayoutRoot());

        if(al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Home") ||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("होम") ||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("होम") ||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Profile") ||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Log Out")||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Broadcast Coupon")||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Sales Rep")||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Import/Export Product")||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Retailer Report")||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Contact Us")||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("Privacy Policy")||
                al_menu_name.get(i).getStr_DrawerLayoutRoot().equals("About Us"))
        {
            tv_state.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ((NavigationControlActivity)context).fn_selectedPosition(i);
                    return;
                }
            });
        }
        return view;
    }

    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {
        TextView tv_state=null;
      //  if (view==null){

            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           // view = layoutInflater.inflate(R.layout.navigation_drawer_adapter_retailer_childview, null);
              view = layoutInflater.inflate(R.layout.navigation_drawer_adapter_admin_childview, null);

     //   }
        tv_state = (TextView)view.findViewById(R.id.tv_name);



        tv_state.setText(al_menu_name.get(i).getAl_state().get(i1).getStr_child_name());
        tv_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((NavigationControlActivity)context).fn_selectedPosition(i,i1);
            }
        });

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }


}
