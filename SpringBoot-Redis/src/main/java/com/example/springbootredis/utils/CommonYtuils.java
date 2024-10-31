package com.example.springbootredis.utils;

import java.util.concurrent.ThreadLocalRandom;

public class CommonYtuils {
    public static int generateCode(){
        return ThreadLocalRandom.current().nextInt(1000,9999);
    }
}
