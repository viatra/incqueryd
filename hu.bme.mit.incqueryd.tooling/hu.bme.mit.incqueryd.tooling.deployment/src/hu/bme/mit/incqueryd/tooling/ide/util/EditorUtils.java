package hu.bme.mit.incqueryd.tooling.ide.util;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.part.FileEditorInput;

public class EditorUtils {

	private EditorUtils() {
	}

	/**
	 * Returns the topmost visible editor part, if there is any.
	 */
	public static IEditorPart getActiveEditor() {
		IWorkbenchPage page = UiUtils.getWorkbenchPage();
		if (page == null) {
			return null;
		} else {
			return page.getActiveEditor();
		}
	}

	/**
	 * Returns the file being edited in the active editor. Returns
	 * <code>null</code> if there is no open editor, or if it is not a file
	 * resource that is being edited.
	 */
	public static IFile getCurrentlyOpenFile() {
		IEditorPart activeEditor = getActiveEditor();
		if (activeEditor == null) {
			return null;
		}
		IFile result = ResourceUtil.getFile(activeEditor.getEditorInput());
		return result;
	}

	/**
	 * Returns all open editors.
	 */
	public static IEditorReference[] getOpenEditors() {
		IWorkbenchPage page = UiUtils.getWorkbenchPage();
		return page.getEditorReferences();
	}

	/**
	 * Returns all open files.
	 */
	public static IFile[] getAllOpenFiles() {
		IEditorReference[] editors = EditorUtils.getOpenEditors();
		List<IFile> files = new ArrayList<IFile>();
		for (IEditorReference editor : editors) {
			IEditorInput editorInput;
			try {
				editorInput = editor.getEditorInput();
			} catch (PartInitException e) {
				continue;
			}
			IFile file = ResourceUtil.getFile(editorInput);
			if (file != null) {
				files.add(file);
			}
		}
		return files.toArray(new IFile[0]);
	}

	/**
	 * Returns the editor in which the given file is open, if there is any.
	 */
	public static IEditorPart getEditorWithFile(IFile file) {
		IEditorReference[] editorReferences = EditorUtils.getOpenEditors();
		for (IEditorReference editorReference : editorReferences) {
			IEditorInput editorInput;
			try {
				editorInput = editorReference.getEditorInput();
			} catch (PartInitException e) {
				continue;
			}
			if (editorInput instanceof FileEditorInput) {
				FileEditorInput fileEditorInput = (FileEditorInput)editorInput;
				if (fileEditorInput.getFile().equals(file)) {
					return editorReference.getEditor(false);
				}
			}
		}
		return null;
	}

}
