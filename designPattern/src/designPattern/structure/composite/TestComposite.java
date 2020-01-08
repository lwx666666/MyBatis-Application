package designPattern.structure.composite;

import java.io.File;

public class TestComposite {
	static AbstractFile f1;
	static Folder f4 = new Folder("f盘文件");
	public static void main(String[] args) {
//		AbstractFile f1,f2,f3,f6;
//		f1 = new ImageFile("美丽风景");
//		f2 = new TextFile("java学习");
//		f3 = new VideoFile("海绵宝宝");
//		Folder f4 = new Folder("我的收藏");
//		f4.addFile(f1);
//		f4.addFile(f2);
//		f4.addFile(f3);
////		f4.removeFile(f2);
//		Folder f5 = new Folder("岁月的沉淀");
//		f6 = new VideoFile("红海行动");
//		f5.addFile(f6);
//		f5.addFile(f4);
//		f5.killVirus();
		File file = new File("f:" + File.separator);
		printFile(file);
	}
	
	public static void printFile(File file) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			if(files != null) {
				for (File f : files) {
					printFile(f);
				}
			}
		}
		f1 = new TextFile(file.getPath());
		f4.addFile(f1);
		System.out.println(f4.getFiles().size());
	}
}
