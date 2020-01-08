package com.fastdfs.test;

import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.taotao.test.FastDFSClientUtil;

public class FastdfsUploadTest {

	@Test
	public void uploadTest() throws IOException, MyException {
		// 初始化全局配置，加载一个配置文件
		ClientGlobal.init("F:\\EclipseX86_Workbench\\Spring\\taotao-manager\\taotao-manager-web\\src\\main\\resources\\properties\\client.conf");
		// 创建TrackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		// 获取一个trackerServer连接
		TrackerServer connection = trackerClient.getConnection();
		// 声明一个storageServer对象
		StorageServer storageServer = null;
		// 获取StorageClient对象
		StorageClient storageClient = new StorageClient(connection,storageServer);
		// 直接调用storageClient对象的方法上传即可
		String[] upload_files = storageClient.upload_file("D:\\img\\f.jpg", "jpg", null);
		for(String file : upload_files){
			System.out.println(file);
		}
	}
	
	@Test
	public void testFastDFSClient() throws IOException, MyException{
		FastDFSClientUtil fastDFSClientUtil = new FastDFSClientUtil("F:\\EclipseX86_Workbench\\Spring\\taotao-manager\\taotao-manager-web\\src\\main\\resources\\properties\\client.conf");
		String url = fastDFSClientUtil.uploadFile("D:\\img\\water.jpg", "jpg");
		System.out.println(url);
	}
}
