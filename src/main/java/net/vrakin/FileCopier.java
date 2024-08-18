package net.vrakin;

import java.io.File;

public interface FileCopier {

    void copyFilesOfDirectory(String filePattern, File directory, File outputDirectory);
    void copyFilesOfFile(File in, File out);
}
