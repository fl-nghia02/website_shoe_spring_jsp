package com.example.demo.constVarible;

import java.util.HashMap;
import java.util.Map;

public class constVariable {
    public static final String headHref = "/WEB-INF/views";
    public static final Map<Integer, String> trangThaiMap = new HashMap<>();
    static {
        trangThaiMap.put(0,"Chờ xác nhận");
        trangThaiMap.put(1,"Đã xác nhận");
        trangThaiMap.put(2,"Đang giao");
        trangThaiMap.put(3,"Thành công");
        trangThaiMap.put(4,"Hủy");
    }
}
