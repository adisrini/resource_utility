import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResourceNode {
		
	private String filePath;
	private ResourceNodeType nodeType;
	private int level;
	private List<ResourceNode> children;
		
	public ResourceNode(String path, ResourceNodeType type) {
		this.filePath = path;
		this.nodeType = type;
		this.children = new ArrayList<ResourceNode>();
	}
	
	public void addChildren(ResourceNode... children) {
		this.children.addAll(Arrays.asList(children));
	}
	
	public List<ResourceNode> getChildren() {
		return this.children;
	}
	
	public String getFilePath() {
		return this.filePath;
	}
	
	public ResourceNodeType getType() {
		return this.nodeType;
	}
	
	@Override
	public String toString() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void setNodeType(ResourceNodeType nodeType) {
		this.nodeType = nodeType;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return this.level;
	}

}
