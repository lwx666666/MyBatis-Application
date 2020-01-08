package com.taotao.test;

import java.io.IOException;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastDFSClientUtil {
	private TrackerClient trackerClient;
	private TrackerServer trackerServer;
	private StorageClient storageClient;
	public FastDFSClientUtil(String conf) throws IOException, MyException {
		if(conf.contains("classpath:")){
			conf = conf.replaceAll("classpath:", this.getClass().getResource("/").getPath()).substring(1);
		}
		ClientGlobal.init(conf);
		trackerClient = new TrackerClient();
		trackerServer = trackerClient.getConnection();
		StorageServer storageServer = null;
		storageClient = new StorageClient(trackerServer,storageServer);
	}
	/**
	 * 文件上传
	 * @param localFileName
	 * @param fileExeName
	 * @param metaList
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	public String uploadFile(String localFileName,String fileExeName,NameValuePair[] metaList) throws IOException, MyException{
		String [] upload_files = storageClient.upload_file(localFileName, fileExeName, metaList);
		StringBuilder file = new StringBuilder();
		for(String f : upload_files){
			file.append(f).append("/");
		}
		return file.substring(0, file.length()-1);
	}
	public String uploadFile(String localFileName) throws IOException, MyException{
		String file = this.uploadFile(localFileName,null,null);
		return file;
	}
	public String uploadFile(String localFileName,String fileExeName) throws IOException, MyException{
		String file = this.uploadFile(localFileName,fileExeName,null);
		return file;
	}
}
