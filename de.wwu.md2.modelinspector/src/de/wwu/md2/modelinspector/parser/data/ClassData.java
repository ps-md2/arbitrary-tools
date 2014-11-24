package de.wwu.md2.modelinspector.parser.data;

import java.util.ArrayList;
import java.util.List;

public class ClassData {

	private String name;
	private List<Feature> features;
	private List<ClassData> subTypes;
	
	public ClassData(String name) {
		this.name = name;
		this.features = new ArrayList<>();
		this.subTypes = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public List<Feature> getFeatures() {
		return this.features;
	}
	
	public List<ClassData> getSubTypes() {
		return this.subTypes;
	}
	
	public void addFeature(String feature, String type) {
		this.features.add(new Feature(feature, type));
	}
	
	public void addSubType(ClassData subType) {
		this.subTypes.add(subType);
	}
}
