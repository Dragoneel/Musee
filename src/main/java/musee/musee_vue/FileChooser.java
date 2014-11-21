package musee.musee_vue;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Drickflow
 */
public class FileChooser extends JFileChooser {

public FileChooser(FileNameExtensionFilter filter){

    this.setFileFilter(filter);
    
}
public String getResultString() {
       // String resultString;
      //  String filter = this.getFileFilter().getDescription();
        String path = null;
      //  boolean isDirMode = (this.getFileSelectionMode() == DIRECTORIES_ONLY);
        boolean isMulti = this.isMultiSelectionEnabled();

        if (isMulti) {
            File [] files = this.getSelectedFiles();
            if (files != null && files.length > 0) {
                path = "";
                for (File file : files) {
                    path = path /*+ "<br>"*/ + file.getPath();
                }
            }
        } else {
            File file = this.getSelectedFile();
            if (file != null) {
                path = /* "<br>" +*/ file.getPath();
            }
        }
        if (path != null) {
  /*          path = path.replace(" ", "&nbsp;");
            filter = filter.replace(" ", "&nbsp;");
            resultString =
                "<html>You chose " + (isMulti ? "these" : "this") + " " +
                (isDirMode ? (isMulti ? "directories" : "directory")
                           : (isMulti ? "files" : "file")) +
                ": <code>" + path +
                "</code><br><br>with filter: <br><code>" + filter;
       */ } else {
            path = "Nothing was chosen";
        }
        return path;
    }
}
