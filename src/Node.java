import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
		
	private String filePath;
	private NodeType nodeType;
	private int level;
	private List<Node> children;
		
	public Node(String path, NodeType type) {
		this.filePath = path;
		this.nodeType = type;
		this.children = new ArrayList<Node>();
	}
	
	public void addChildren(Node... children) {
		this.children.addAll(Arrays.asList(children));
	}
	
	public List<Node> getChildren() {
		return this.children;
	}
	
	public String getFilePath() {
		return this.filePath;
	}
	
	public NodeType getType() {
		return this.nodeType;
	}
	
	@Override
	public String toString() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void setNodeType(NodeType nodeType) {
		this.nodeType = nodeType;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return this.level;
	}

}
