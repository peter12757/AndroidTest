package com.eathemeat.module

object ModuleManager {

    private val modules = mutableListOf<ModuleItem>()


    fun register(item: ModuleItem): Unit {
        if (!modules.contains(item))
            modules.add(item)
    }

    fun unRegister(item: ModuleItem): Unit {
        modules.remove(item)
    }

    fun get(pos:Int):ModuleItem {
        return modules[pos]
    }

    fun size(): Int {
        return modules.size
    }

}