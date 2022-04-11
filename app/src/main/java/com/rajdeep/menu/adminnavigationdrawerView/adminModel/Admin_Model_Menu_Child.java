package com.rajdeep.menu.adminnavigationdrawerView.adminModel;


public class Admin_Model_Menu_Child {
    String str_child_name;
    String str_description;
    String str_image;

    public Admin_Model_Menu_Child(String str_name, String str_description, String str_image) {
        this.str_child_name = str_name;
        this.str_description = str_description;
        this.str_image = str_image;
    }

    public String getStr_image() {
        return str_image;
    }

    public void setStr_image(String str_image) {
        this.str_image = str_image;
    }

    public Admin_Model_Menu_Child() {

    }



    public String getStr_child_name() {
        return str_child_name;
    }

    public void setStr_child_name(String str_child_name) {
        this.str_child_name = str_child_name;
    }

    public String getStr_description() {
        return str_description;
    }

    public void setStr_description(String str_description) {
        this.str_description = str_description;
    }
}
