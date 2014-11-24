package de.wwu.md2.modelinspector.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.PlatformUI;

import de.wwu.md2.modelinspector.View;

public class LoadModel extends AbstractHandler {

	  @Override
	  public Object execute(ExecutionEvent event) throws ExecutionException {
		  FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.OPEN);
		  dialog.setFilterExtensions(new String [] {"*.ecore"});
		  dialog.setFilterPath("c:\\temp");
		  String result = dialog.open();
		    
		  for(IViewReference viewRef : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViewReferences()) {
			  IViewPart view = viewRef.getView(true);
			  if(view instanceof View) {
				  ((View)view).loadModel(result);
			  }
		  }

	    return null;
	  }

}
