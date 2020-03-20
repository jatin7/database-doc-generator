package cn.enilu.tool.database.doc.generator.doc;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;

/**
 * Html2DocConverter
 *
 * @author zt
 * @author jatin
 * @version 2019/1/12 0012
 */
public class Html2DocConverter {

    private String inputPath;    // Input file path，End in .html
    private String outputPath;    //Output file path, ending with .doc


    public Html2DocConverter(String inputPath, String outputPath) {
        super();
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    /**
     * Read html file to word
     *
     * @param filepath
     *            html file path
     * @return
     * @throws Exception
     */
    public boolean writeWordFile() throws Exception {

        InputStream is = null;
        FileOutputStream fos = null;

        // 1 Cannot find source file, return false
        File inputFile = new File(this.inputPath);
        if (!inputFile.exists()) {
            return false;
        }

        File outputFile = new File(this.outputPath);
        // 2 If the target path does not exist, create a new path
        if (!outputFile.getParentFile().exists()) {
            outputFile.getParentFile().mkdirs();
        }

        try {

            // 3 Write html file content to doc file
            is = new FileInputStream(inputFile);
            POIFSFileSystem poifs = new POIFSFileSystem();
            DirectoryEntry directory = poifs.getRoot();
            directory.createDocument(
                    "WordDocument", is);

            fos = new FileOutputStream(this.outputPath);
            poifs.writeFilesystem(fos);

            System.out.println("Conversion of word files is complete!");

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                fos.close();
            }
            if (is != null) {
                is.close();
            }
        }

        return false;
    }
    public static void main(String[] args) throws Exception {

        new Html2DocConverter("G:/123.html" , "G:/temp5.doc").writeWordFile();
    }
}
