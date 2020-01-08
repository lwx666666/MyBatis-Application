package designPattern.structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件接口
 * @author libo
 *
 */
public interface AbstractFile {
	void killVirus();
}

/**
 * 容器接口
 * @author libo
 *
 */
class Folder implements AbstractFile{
	private String name;
	private List<AbstractFile> files = new ArrayList<AbstractFile>();
	public Folder(String name) {
		this.name = name;
	}
	public List<AbstractFile> getFiles() {
		return files;
	}
	@Override
	public void killVirus() {
		System.out.println("--文件夹：" + name + "查杀");
		// 递归查杀
		for (AbstractFile f : files) {
			f.killVirus();
		}
	}
	public void addFile(AbstractFile file) {
		files.add(file);
	}
	public void removeFile(AbstractFile file) {
		files.remove(file);
	}
	public AbstractFile getChildFile(int index){
		return files.get(index);
	}
}

class ImageFile implements AbstractFile{
	private String name;
	
	public ImageFile(String name) {
		this.name = name;
	}
	
	@Override
	public void killVirus() {
		System.out.println("--图像文件：" + name + "查杀");
	}
}

class TextFile implements AbstractFile{
	private String name;
	
	public TextFile(String name) {
		this.name = name;
	}
	
	@Override
	public void killVirus() {
		System.out.println("--文本文件：" + name + "查杀");
	}
}

class VideoFile implements AbstractFile{
	private String name;
	
	public VideoFile(String name) {
		this.name = name;
	}
	
	@Override
	public void killVirus() {
		System.out.println("--视频文件：" + name + "查杀");
	}
}

