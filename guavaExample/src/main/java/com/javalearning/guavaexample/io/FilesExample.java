package com.javalearning.guavaexample.io;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

/**
 * Created by renqun.yuan on 2015/10/21.
 */
public class FilesExample {
    public static String generateFileMd5(File file) throws IOException {
        HashCode hash = Files.hash(file, Hashing.md5());
        return hash.toString();
    }
}
