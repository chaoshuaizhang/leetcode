package com.testmodule.testKotlin.enums

enum class ShopEnums(val shopSid: Int, val shopName: String) {
    上品Plus城市奥莱(1002, "上品+城市奥莱"),
    五棵松(1004, "五棵松"),
    来广营(1008, "来广营"),
    草桥(1010, "草桥"),
    回龙观(1011, "回龙观");

    companion object {
        fun getShopName(shopSid: Int): String? {
            values().forEach {
                if (shopSid == it.shopSid)
                    return it.shopName
            }
            return null
        }
    }

}

