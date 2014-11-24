package de.wwu.md2.modelinspector;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.part.ViewPart;

import de.wwu.md2.modelinspector.parser.EcoreModelParser;
import de.wwu.md2.modelinspector.parser.data.ClassData;

public class View extends ViewPart {
	public static final String ID = "de.wwu.md2.modelinspector.view";

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		
		Tree tree = new Tree(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
	    tree.setHeaderVisible(true);
	    
	    TreeColumn column1 = new TreeColumn(tree, SWT.LEFT);
	    column1.setText("Name");
	    column1.setWidth(200);
	    TreeColumn column2 = new TreeColumn(tree, SWT.CENTER);
	    column2.setText("Features");
	    column2.setWidth(200);
	    
	    EcoreModelParser.parse("C:/Development/GIT/md2-framework/de.wwu.md2.framework/src-gen/de/wwu/md2/framework/MD2.ecore");
	    Map<String, ClassData> data = EcoreModelParser.getDate();
	    
	    Set<String> keySet = data.keySet();
	    String[] keys = keySet.toArray(new String[keySet.size()]);
	    Arrays.sort(keys);
	    
	    
	    for (String key : keys) {
	    	ClassData classData = data.get(key);
	    	TreeItem item = new TreeItem(tree, SWT.NONE);
	    	item.setText(new String[] { classData.getName(), classData.getFeatures().toString() } );
	    	
	    	addChilds(classData, item);
//	    	for(ClassData subType : classData.getSubTypes()) {
//	    		TreeItem subItem = new TreeItem(item, SWT.NONE);
//	    		subItem.setText(new String[] { subType.getName(), subType.getFeatures().toString() });
//	    	}
	    	
	    }
		
		
		
//		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
//				| SWT.V_SCROLL);
//		viewer.setContentProvider(new ViewContentProvider());
//		viewer.setLabelProvider(new ViewLabelProvider());
//		// Provide the input to the ContentProvider
//		viewer.setInput(new String[] {"One", "Two", "Three"});
	}
	
	private static void addChilds(ClassData classData, TreeItem parentItem) {
		if(classData.getSubTypes().size() > 0 ) {
			for(ClassData subType : classData.getSubTypes()) {
	    		TreeItem subItem = new TreeItem(parentItem, SWT.NONE);
	    		subItem.setText(new String[] { subType.getName(), subType.getFeatures().toString() });
	    		addChilds(subType, subItem);
	    	}
		}
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

}