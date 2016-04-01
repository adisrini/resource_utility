
public enum NodeType {
	FOLDER, IMAGE, AUDIO, CONTROLLABLE, AI;
	
	private String name;
	
	private NodeType() {
		this.name = this.name().toLowerCase();
	}
	
	public String sayName() {
		return this.name;
	}

}