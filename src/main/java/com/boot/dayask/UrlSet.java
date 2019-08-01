package com.boot.dayask;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhang.wenhan
 * @description UrlSet
 * @date 2019/8/1 13:20
 */
public class UrlSet {

    private static final String[] URL_NAMES = {
            "http://javapuzzlers.com",
            "http://apache2-snort.skybar.dreamhost.com",
            "http://www.google.com",
            "http://javapuzzlers.com",
            "http://findbugs.sourceforge.net",
            "http://www.cs.umd.edu"
    };

    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        Set<URL> urls = new HashSet<>();
        for(String name : URL_NAMES){
            urls.add(new URL(name));
        }
        // uniform resource locator URL  统一资源定位符
        System.out.println(urls.size()); // 5 重写了hashcode和equals

        Set<URI> uris = new HashSet<>();
        for(String name : URL_NAMES){
            uris.add(new URI(name));
        }
        // uniform resource identifier URI  统一资源标识符
        System.out.println(uris.size()); // 5 重写了hashcode和equals
    }
}
