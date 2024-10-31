package com.example.electronic_kits_store.app.util;

import com.example.electronic_kits_store.app.model.Product;

public class Utils {

    public static Class<? extends Product> getProductClassName (String category) throws ClassNotFoundException {
        char[] categoryCharArray = category.toCharArray();
        categoryCharArray[0] = Character.toUpperCase(categoryCharArray[0]);
        return Class.forName("com.example.electronic_kits_store.app.model." + String.valueOf(categoryCharArray))
                .asSubclass(Product.class);
    }
    public static String getProductClassNameString (String category) {
        char[] categoryCharArray = category.toCharArray();
        categoryCharArray[0] = Character.toUpperCase(categoryCharArray[0]);
        return String.valueOf(categoryCharArray);
    }
}
