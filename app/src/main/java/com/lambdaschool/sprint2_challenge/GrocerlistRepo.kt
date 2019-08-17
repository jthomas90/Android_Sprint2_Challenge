package com.lambdaschool.sprint2_challenge

import com.lambdaschool.sprint2_challenge.ShoppingItemConstants.ICON_IDS
import com.lambdaschool.sprint2_challenge.ShoppingItemConstants.ITEM_NAMES_RAW

class GrocerlistRepo {
    companion object{
        val grocerylist = mutableListOf<ShoppingListModel>()
        fun createGroceryList () {
            for (i in 0 until ICON_IDS.size ){
                grocerylist.add(ShoppingListModel(ITEM_NAMES_RAW[i], ICON_IDS[i],false ))

            }
        }

    }
}

