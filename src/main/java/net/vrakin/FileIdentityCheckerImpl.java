package net.vrakin;

import java.io.*;
import java.nio.file.Files;

public class FileIdentityCheckerImpl implements FileIdentityChecker {
    @Override
    public boolean checkFileIdentity(File file, File fileCheck) throws IOException {
        if (file.exists() && fileCheck.exists()) {
            if (file.length() != fileCheck.length()) {
                return false;
            }

            try (InputStream f = Files.newInputStream(file.toPath());
                 InputStream fc = Files.newInputStream(fileCheck.toPath())) {

                while (f.available() > 0) {
                    if (f.read() != fc.read()) {
                        return false;
                    }
                }
            } catch (IOException e) {
                throw e;
            }

            return true;
        }else {
            throw new FileNotFoundException();
        }
    }
}
