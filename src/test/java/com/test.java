package com;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.EventData;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class test {

    public static void main(String[] args) {

        String str="啊哈哈多少发第三方打算发多少范德萨发多少范德萨范德萨";
        try {
            System.out.println(new String(str.getBytes("utf-8"),"gbk"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        final BinaryLogClient client = new BinaryLogClient("192.168.1.248",3306, "root", "24jdTest_mysql_24jdroot");
        //client.setBinlogFilename("mysql-binlog.000003");
        //client.setBinlogPosition(0);

        client.registerEventListener(new BinaryLogClient.EventListener() {
            public void onEvent(Event event) {

                EventData date = event.getData();
                System.out.println("打印" + date.toString());
            }
        });
        try {
            client.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
