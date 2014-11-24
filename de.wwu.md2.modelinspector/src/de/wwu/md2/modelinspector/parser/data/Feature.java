package de.wwu.md2.modelinspector.parser.data;

public class Feature {

	private String name;
	private String type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Feature(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "[" + this.name + ":" + this.type + "]";
	}
}
