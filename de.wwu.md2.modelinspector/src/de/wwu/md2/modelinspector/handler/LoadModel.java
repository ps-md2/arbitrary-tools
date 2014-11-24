package de.wwu.md2.modelinspector.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;

public class LoadModel extends AbstractHandler {

	  @Override
	  public Object execute(ExecutionEvent event) throws ExecutionException {
	    System.out.println("hello");
	    FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.OPEN);
	    dialog.setFilterExtensions(new String [] {"*.html"});
	    dialog.setFilterPath("c:\\temp");
	    String result = dialog.open();
	    return null;
	  }

}
