import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ResourceUtility extends VBox {
	
	private ResourceTree rt;
	private VBox structure;
	private Map<String, NodeType> formatMap;

	public ResourceUtility() {
		rt = new ResourceTree();

		Button addFolder = new Button("Add Folder");
		addFolder.setOnAction(e -> {
			addFolder();
		});
		
		Button addItem = new Button("Add Item");
		addItem.setOnAction(e -> {
			addItem();
		});
		
		this.getChildren().add(addFolder);
		this.getChildren().add(addItem);
		
		Scene scene = new Scene(this, 200, 800);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		
		formatMap = new HashMap<String, NodeType>();
		formatMap.put("jpg", NodeType.IMAGE);
		
		structure = new VBox();
		this.getChildren().add(structure);
		
		showFolders();

	}
	
	private void addFolder() {
		VBox v = new VBox();		
		rt.clearAndPopulateFolders();
		
		ComboBox<Node> directories = new ComboBox<Node>();
		directories.getItems().addAll(rt.getFolders());
		TextField folderName = new TextField();
		Button add = new Button("Add");
		
		v.getChildren().addAll(directories, folderName, add);
		
		Scene scene = new Scene(v);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		
		Node node = new Node("", NodeType.FOLDER);
		
		directories.setOnAction(e -> {
			Node folder = (Node) directories.getValue();
			node.setFilePath(folderName.getText());
			folder.getChildren().add(node);
		});
		
		folderName.textProperty().addListener(e -> {
			node.setFilePath(folderName.getText());
		});

		add.setOnAction(e -> {
			showFolders();
			stage.close();
		});
		
	}
	
	private void addItem() {		
		FileChooser chooser = new FileChooser();
		File importedFile = chooser.showOpenDialog(new Stage());
		String extension = "";

		int i = importedFile.toString().lastIndexOf('.');
		if (i > 0) {
		    extension = importedFile.toString().substring(i+1);
		}
		
		Node node = new Node(importedFile.toString(), formatMap.get(extension));
		
		VBox v = new VBox();		
		rt.clearAndPopulateFolders();
		
		ComboBox<Node> directories = new ComboBox<Node>();
		directories.getItems().addAll(rt.getFolders());
		Button add = new Button("Add");
		
		v.getChildren().addAll(directories, add);
		
		Scene scene = new Scene(v);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		
		directories.setOnAction(e -> {
			Node folder = (Node) directories.getValue();
			folder.getChildren().add(node);
		});
		
		add.setOnAction(e -> {
			showFolders();
			stage.close();
		});
		
	}

	private void showFolders() {
		rt.clearAndPopulateFolders();
		structure.getChildren().clear();
		for(Node folder : rt.getFolders()) {
			String prefix = "";
			for(int i = 0; i < folder.getLevel(); i++) {
				prefix += "--";
			}
			Label l = new Label(prefix + folder.getFilePath());
			structure.getChildren().add(l);
		}
	}
	
}
