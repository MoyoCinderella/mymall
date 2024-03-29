package com.zhenlong.mymall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MymallManageWebApplicationTests {

    @Test
    public void contextLoads() throws IOException, MyException {
      String tracker =  MymallManageWebApplicationTests.class.getResource("/tracker.conf").getPath();
        ClientGlobal.init(tracker);

        TrackerClient trackerClient = new TrackerClient();
        String url = "http://192.168.179.128";
     TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        String[] jpgs = storageClient.upload_file("F:/9.jpg", "jpg", null);
        for (String jpg : jpgs) {
           url += "/"+jpg;
        }
        System.out.println(url);
    }

}
