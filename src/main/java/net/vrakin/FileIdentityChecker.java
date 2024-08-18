package net.vrakin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileIdentityChecker {

    boolean checkFileIdentity(File file, File fileCheck) throws IOException;
}
