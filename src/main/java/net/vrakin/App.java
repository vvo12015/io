package net.vrakin;

import java.io.File;
import java.io.IOException;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        FileCopier fileCopier = new FileCopierImpl();

        File dir = new File("src/main/resources/files");
        File outDir = new File("src/main/resources/forCopy");

        String filePattern = ".txt";

        fileCopier.copyFilesOfDirectory(filePattern, dir, outDir);

        File file = new File(dir, "file1.txt");
        File fileCheck = new File(outDir, "file1.txt");

        FileIdentityChecker fileIdentityChecker = new FileIdentityCheckerImpl();

        System.out.println("Checking the identity of equal files");
        System.out.println(fileIdentityChecker.checkFileIdentity(file, fileCheck));

        System.out.println("Checking the identity of not equal files");
        File file1Bad = new File(outDir, "file1_bad.txt");

        System.out.println(fileIdentityChecker.checkFileIdentity(file, file1Bad));


        for (String arg : args) {
            System.out.println(arg);
        }
        if (args.length > 1) {

            File fileFromCmd = new File(args[0]);
            File fileFromCmdCheck = new File(args[1]);

            System.out.printf("Checking files:%n%s%n%s%n", fileFromCmd, fileFromCmdCheck);
            System.out.println(
            fileIdentityChecker.checkFileIdentity(fileFromCmd, fileFromCmdCheck));
        }
    }
}
