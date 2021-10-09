package com.vti.frontend;

import utils.FileManager;

import java.io.File;

public class Program3 {


    public static void main(String[] args) {
        if (!FileManager.isFileExists("C:\\Users\\GiangLe\\Desktop\\Test.txt"))
            System.out.println("Không có file trên hệ thống");
        else {
                System.out.println("Có file trên hệ thống");
    }
    }

}
