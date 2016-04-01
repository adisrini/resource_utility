import java.util.ArrayList;
import java.util.List;


public class ResourceTree {

    private ResourceNode root;
    private List<ResourceNode> folders;

    public ResourceTree () {
        root = new ResourceNode("Explorer", ResourceNodeType.FOLDER);
        folders = new ArrayList<ResourceNode>();
    }

    public List<ResourceNode> getFolders () {
        return this.folders;
    }

    public void clearAndPopulateFolders () {
        folders.clear();
        populateFolders(root, 0);
    }

    public void populateFolders (ResourceNode node, int level) {
        if (node == null) {
            return;
        }
        
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        
        node.setLevel(level);
        System.out.println(node.getFilePath());
        if (node.getType() == ResourceNodeType.FOLDER) {
            folders.add(node);
        }
        for (ResourceNode child : node.getChildren()) {
            populateFolders(child, level + 1);
        }
    }

}
