package com.weishubin.test.encache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import java.util.Iterator;

/**
 * @author weishubin
 */
public class EncacheTest {
    public static void main(String[] args) {
        CacheManager  cacheManager = CacheManagerBuilder.newCacheManagerBuilder().withCache("preConfigured",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10)))
                .build();
        cacheManager.init();

        Cache<Long, String> preConfigured =
                cacheManager.getCache("preConfigured", Long.class, String.class);

        Cache<Long, String> myCache = cacheManager.createCache("myCache",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10)).build());

        myCache.put(1L, "da one!");
        String value = myCache.get(1L);
        System.out.println(value);

        Iterator iterator = myCache.iterator();
        if (iterator.hasNext()) {
            System.out.println("has next");
        } else {
            System.out.println("no next");
        }

        myCache.clear();
        iterator = myCache.iterator();
        if (iterator.hasNext()) {
            System.out.println("has next");
        } else {
            System.out.println("no next");
        }

        cacheManager.removeCache("preConfigured");

        cacheManager.close();
    }
}
