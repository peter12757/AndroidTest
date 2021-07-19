package com.eathemeat.data

import com.eathemeat.audiolib.AudioFragment

/**
 * 所有的上下文
 */
class TestContext {

    val navItems:MutableList<NavItem> = mutableListOf()   //底部的选项

    companion object {
        val sIntance = TestContext.instance
    }

    private object TestContext {
        val instance = TestContext()
    }


    constructor() {
        intiNavItems()
    }

    private fun intiNavItems() {
        var bot = NavItem.NavBottomItem(R.id.nav_audio_menu,0,"audio")
        var frag = NavItem.NavFragmentItem(R.id.nav_audio_fragment,AudioFragment::class.qualifiedName.toString(),"","audio",R.layout.fragment_audio)
        navItems.add(NavItem(bot,frag))

    }
}