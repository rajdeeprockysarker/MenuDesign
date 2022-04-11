package com.rajdeep.menu.adminnavigationdrawerView.adminModel;

import java.util.ArrayList;


public class Admin_Model_menu_name {
    String str_DrawerLayoutRoot;
    ArrayList<Admin_Model_Menu_Child> al_state;
    public Admin_Model_menu_name() {
    }

    public Admin_Model_menu_name(String str_country, ArrayList<Admin_Model_Menu_Child> al_state) {
        this.str_DrawerLayoutRoot = str_country;
        this.al_state = al_state;
    }


    public String getStr_DrawerLayoutRoot() {
        return str_DrawerLayoutRoot;
    }

    public void setStr_DrawerLayoutRoot(String str_DrawerLayoutRoot) {
        this.str_DrawerLayoutRoot = str_DrawerLayoutRoot;
    }

    public ArrayList<Admin_Model_Menu_Child> getAl_state() {
        return al_state;
    }

    public void setAl_state(ArrayList<Admin_Model_Menu_Child> al_state) {
        this.al_state = al_state;
    }
}
