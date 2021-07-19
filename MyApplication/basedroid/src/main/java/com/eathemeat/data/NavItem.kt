package com.eathemeat.data

class NavItem(val bottomItem: NavBottomItem, val fragmentItem: NavFragmentItem) {



    class NavBottomItem(val id:Int, val icon:Int, val title:String) {
    }

    class NavFragmentItem(val id:Int, val className:String, val pageUrl:String, val label:String, val layout:Int){

    }

}