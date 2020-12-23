package com.example.demo;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;


public class DemoApplicationTests {
    String json = "[" +
            " 'title':'Links'," +
            " 'id':'links'," +
            "    'children':[" +
            " {" +
            "'title':'Oracle'," +
            "'id':'oracle'," +
            "   'children':[" +
            "{" +
            "    'title':'USA'," +
            "    'id':'usa'," +
            "  'children':[" +
            "    {" +
            "   'title':'Northeast'," +
            "   'id':'northeast'" +
            "    }," +
            "    {" +
            "   'title':'Midwest'," +
            "   'id':'midwest'" +
            "    }," +
            "    {" +
            "   'title':'South'," +
            "   'id':'south'" +
            "    }," +
            "    {" +
            "   'title':'West'," +
            "   'id':'west'" +
            "    }" +
            "  ]" +
            "}," +
            "{" +
            "    'title':'Asia'," +
            "    'id':'asia'" +
            "  'children':[" +
            "    {" +
            "   'title':'Japan'," +
            "   'id':'japan'" +
            "    }," +
            "    {" +
            "   'title':'China'," +
            "   'id':'china'" +
            "    }," +
            "    {" +
            "   'title':'India'," +
            "   'id':'india'" +
            "    }" +
            "  ]" +
            "}" +
            "   ]" +
            " }" +
            "    ]" +
            "  }" +
            "]";

    public void contextLoads() {
        System.out.println("11111111111111");
        ConcurrentLinkedQueue q = null;

        Queue<String> queue = new LinkedBlockingQueue<String>();

        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.add("5");
        queue.add("6");

    }


    public void testClear() {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list.size());
        list.add("a");
        list.add("a");
        list.add("a");
        System.out.println(list.size());
        list.clear();
        System.out.println(list.size());
    }


    @Test
    public void buildJSON() {
//        Gson gson = new Gson();
//        System.out.println(gson.fromJson(json, String.class));

         
         String zh = "这是中文！";
         System.out.println(Charset.defaultCharset());
         System.out.println(zh);
         String str_GBK = new String(zh.getBytes(Charset.forName("GBK")));
         System.out.println("GBK:" + str_GBK);
         String str_ISO = new String(zh.getBytes(Charset.forName("ISO-8859-1"))); 
         System.out.println("ISO:" + str_ISO);
         String str_GBK_UTF = new String(str_GBK.getBytes(Charset.forName("UTF-8")));
         System.out.println("GBK->UTF:" + str_GBK_UTF);
         String str_GBK_UTF_GBK = new String(str_GBK_UTF.getBytes(Charset.forName("GBK")));
         System.out.println(str_GBK_UTF_GBK);
         
         String str_ISO_UTF = new String(str_ISO.getBytes(Charset.forName("UTF-8")));
         System.out.println("ISO->UTF:" + str_ISO_UTF);
         
    	
    }


}
