package designPattern.structure.composite;

/**
 * 组合模式Composite，用于处理树形结构
 * 包含三要素
 *   1.Component接口
 *   2.Leaf子接口
 *   3.Composite容器子接口
 * @author libo
 *
 */
public interface Component {
	
	void operate();
}

interface Leaf extends Component{
	public void operate();
}

interface Composite extends Component{
	public void operate();
	public void add(Component c);
	public Component getChild(int index);
	public void remove(Component c);
}
