
public enum ResourceNodeType {
	FOLDER, IMAGE, AUDIO, CONTROLLABLE, AI;
	
	private String name;
	
	private ResourceNodeType() {
		this.name = this.name().toLowerCase();
	}
	
	public String sayName() {
		return this.name;
	}

}