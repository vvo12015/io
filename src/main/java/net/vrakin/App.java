package net.vrakin;

import java.io.File;

/**
 *
 *
 */
public class App 
{
    //src/main/resources/files/file1.txt
    public static void main( String[] args )
    {
        FileCopier fileCopier = new FileCopierImpl();

        File dir = new File("src/main/resources/files");
        File outDir = new File("src/main/resources/forCopy");

        String filePattern = ".txt";

        fileCopier.copyFilesOfDirectory(filePattern, dir, outDir);
    }
}
