package de.wwu.md2.modelinspector.parser;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.wwu.md2.modelinspector.parser.data.ClassData;

public class EcoreModelParser {

	private static Map<String, ClassData> data = new HashMap<String, ClassData>();

	/**
	 * Parse an ECore model. After calling this method, the parsed data is available via {@link #getDate()}
	 * @param fileToEcoreModel
	 */
	public static void parse(String fileToEcoreModel) {
		try {
			File file = new File(fileToEcoreModel);
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			Node rootNode = doc.getDocumentElement();
			
			for (int count = 0; count < rootNode.getChildNodes().getLength(); count++) {
				Node node = rootNode.getChildNodes().item(count);
				if(node.getNodeName().equals("eClassifiers")) {
					// we have a new Class Node...
					String name = node.getAttributes().getNamedItem("name").getNodeValue();					
					ClassData classData = data.get(name.trim());
					if(classData == null) {
						classData = new ClassData(name);
						data.put(name.trim(), classData);
					}
					classData = data.get(name.trim());
					
					
					// super types
					if(node.getAttributes().getNamedItem("eSuperTypes") != null) {
						String superTypes = node.getAttributes().getNamedItem("eSuperTypes").getNodeValue();
						String[] superTypesSplitted = superTypes.split("#//");
						for(String superType : superTypesSplitted) {
							if(superType.startsWith("#//")) {
								superType = superType.substring("#//".length(), superType.length());
							}
							ClassData superDataClass = data.get(superType.trim());
							if(superDataClass == null) {
								superDataClass = new ClassData(superType);
								data.put(superType.trim(), superDataClass);
							}
							superDataClass = data.get(superType.trim());
							superDataClass.addSubType(classData);
						}
					}
					
					
					// features / attributes
					if(node.hasChildNodes()) {
						NodeList childNodeList = node.getChildNodes();
						for (int childCount = 0; childCount < childNodeList.getLength(); childCount++) {
							Node childNode = childNodeList.item(childCount);
							if(childNode.getNodeName().equals("eStructuralFeatures")) {
								NamedNodeMap childAttributes = childNode.getAttributes();
								if(childAttributes != null) {
									Node childNameNode = childAttributes.getNamedItem("name");
									Node childTypeNode = childAttributes.getNamedItem("eType");
									if(childNameNode != null) {
										String childName = childNameNode.getNodeValue();
										String childType = childTypeNode.getNodeValue();
										int index = childType.indexOf("#//");
										if(index >= 0) {
											childType = childType.substring(index+3, childType.length());
										}
										classData.addFeature(childName, childType); // feature type is in property 'eType'
									}								
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Map<String, ClassData> getDate() {
		return data;
	}
}
