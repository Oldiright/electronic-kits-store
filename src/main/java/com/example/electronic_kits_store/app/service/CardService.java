package com.example.electronic_kits_store.app.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;
import java.util.StringJoiner;

@Service
public class CardService {

    public void addCardItem(HttpServletRequest request, HttpServletResponse response, Long id) {
        Cookie cookie = WebUtils.getCookie(request, "card");
        if (cookie != null) {
            StringJoiner stringJoiner = new StringJoiner("c");
            String[] orderItem = cookie.getValue().split("c");
            boolean isCardHasNewItem = false;
            for (int i = 0; i < orderItem.length; i++) {
                String[] itemDetails = orderItem[i].split("x");
                if (itemDetails[0].equals(id.toString())) {
                    itemDetails[1] = String.valueOf(Integer.parseInt(itemDetails[1]) + 1);
                    orderItem[i] = id.toString() + "x" + itemDetails[1];
                    isCardHasNewItem = true;
                    break;
                }
            }
            if (!isCardHasNewItem) {
                stringJoiner.add(cookie.getValue()).add(id.toString() + "x1");
            } else {
                for (String item : orderItem) {stringJoiner.add(item);}
            }
            cookie.setValue(stringJoiner.toString());
            cookie.setPath("/");
            response.addCookie(cookie);
        } else {
            cookie = new Cookie("card", id.toString() + "x1");
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }

    public void deleteCardItem(HttpServletRequest request, HttpServletResponse response, Long id) {
        Cookie cookie = WebUtils.getCookie(request, "card");
        if (cookie != null) {
            StringJoiner stringJoiner = new StringJoiner("c");
            String[] orderItem = cookie.getValue().split("c");

            for (String item : orderItem) {
                String[] itemDetails = item.split("x");
                if (!itemDetails[0].equals(id.toString())) {
                    stringJoiner.add(item);
                } else {
                    if (Integer.parseInt(itemDetails[1]) > 1) {
                        itemDetails[1] = String.valueOf(Integer.parseInt(itemDetails[1]) - 1);
                        item = id.toString() + "x" + itemDetails[1];
                        stringJoiner.add(item);
                    }
                }
            }
            cookie.setValue(stringJoiner.toString());
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }
}
