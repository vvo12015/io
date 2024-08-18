package net.vrakin;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

@Slf4j
public class FileCopierImpl implements FileCopier {
    @Override
    public void copyFilesOfDirectory(String filePattern, File directory, File outputDirectory) {

        File[] files = directory.listFiles((d, s)-> s.endsWith(filePattern));

        assert files != null;

        for (File file : files) {
            File outputFile = new File(outputDirectory, file.getName());
            copyFilesOfFile(file, outputFile);
        }
    }

    @Override
    public void copyFilesOfFile(File in, File out) {
        try(InputStream inStream = Files.newInputStream(in.toPath());
            OutputStream outStream = Files.newOutputStream(out.toPath())) {
            long copyBytes = inStream.transferTo(outStream);
            System.out.printf("File with name %s copied: %d bytes in %d bytes.%n", in.getName() , copyBytes, copyBytes);
        }catch (IOException e) {
            for (StackTraceElement stackTraceElement: e.getStackTrace()){
                log.error(stackTraceElement.toString());
            }
        }
    }
}
