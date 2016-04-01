import java.util.ArrayList;
import java.util.List;

public class ResourceTree {
	
	private Node root;
	private List<Node> folders;

	public ResourceTree() {
		root = new Node("Explorer", NodeType.FOLDER);
		folders = new ArrayList<Node>();
	}
	
	public List<Node> getFolders() {
		return this.folders;
	}
	
	public void clearAndPopulateFolders() {
		folders.clear();
		populateFolders(root, 0);
	}
	
	public void populateFolders(Node node, int level) {
		if(node != null) {
			for(int i = 0 ; i < level; i++) {
				System.out.print("-");
			}
			node.setLevel(level);
			System.out.println(node.getFilePath());
			if(node.getType() == NodeType.FOLDER) {
				folders.add(node);
			}
			for(Node child : node.getChildren()) {
				populateFolders(child, level+1);
			}
		}
	}
	
}
