package com.zhenlong.mymall.manage.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Administrator
 * @date 2019-08-25 10:44
 */
public class PmsUploadUtil {


    public static String upLoadImage(MultipartFile multipartFile) {
        String imgUrl = "http://192.168.179.128";
        String tracker = PmsUploadUtil.class.getResource("/tracker.conf").getPath();
        String[] jpgs = new String[0];
        String filename = multipartFile.getOriginalFilename();
        String sufix = filename.substring(filename.lastIndexOf(".") + 1);
        try {
            ClientGlobal.init(tracker);
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageClient storageClient = new StorageClient(trackerServer, null);
            jpgs = storageClient.upload_file(multipartFile.getBytes(), sufix, null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        for (String jpg : jpgs) {
            imgUrl += "/"+jpg;
        }

        return imgUrl;
    }
}

