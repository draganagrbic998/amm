package main;

import com.github.drapostolos.rdp4j.spi.FileElement;
import com.hierynomus.msfscc.fileinformation.FileIdBothDirectoryInformation;
import com.hierynomus.msfscc.FileAttributes;
import com.hierynomus.protocol.commons.EnumWithValue;

public class FtpFile implements FileElement {

    private final FileIdBothDirectoryInformation file;
    private final String name;
    private final boolean isDirectory;

    public FtpFile(FileIdBothDirectoryInformation file) {
        this.file = file;
        this.name = file.getFileName();
        this.isDirectory = EnumWithValue.EnumUtils.isSet(file.getFileAttributes(), FileAttributes.FILE_ATTRIBUTE_DIRECTORY);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isDirectory() {
        return isDirectory;
    }

    @Override
    public long lastModified() {
        return file.getLastWriteTime().getWindowsTimeStamp();
    }

    @Override
    public String toString() {
        return name;
    }

}