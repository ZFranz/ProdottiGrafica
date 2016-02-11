package prodotti;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ApriFile {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ApriFile window = new ApriFile();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");

		Button btnApriFile = new Button(shell, SWT.NONE);
		btnApriFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDialog = new FileDialog(shell);
				fileDialog.setFilterExtensions(new String[]{"*.txt", "*.csv", "*.*"}); //opzionale
				String fileScelto = fileDialog.open();

				if(fileScelto != null) {
					MessageDialog.openInformation(shell, "File ", fileScelto);
					MessageDialog.openInformation(shell, "File (solo nome)", fileDialog.getFileName());
				}
			}
		});
		btnApriFile.setBounds(22, 21, 75, 25);
		btnApriFile.setText("Apri file");

	}

}
