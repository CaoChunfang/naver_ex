package com.naver.ex;

import java.util.concurrent.ConcurrentHashMap;

public class CachedData {

    ConcurrentHashMap<String,CachedOValue> caches = new ConcurrentHashMap<>(256);

    public CachedOValue processCachedData(String key){


        return null;

    }

    class CachedOValue{

        private String key;
        private Object value;
        private long expire;

        public CachedOValue(String key,Object value,long expire){
            this.key = key;
            this.value = value;
            this.expire = expire;
        }
    }

}
