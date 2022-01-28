package main;

import com.github.drapostolos.rdp4j.spi.FileElement;
import com.github.drapostolos.rdp4j.spi.PolledDirectory;
import com.hierynomus.msfscc.fileinformation.FileIdBothDirectoryInformation;
import com.hierynomus.smbj.SMBClient;
import com.hierynomus.smbj.auth.AuthenticationContext;
import com.hierynomus.smbj.share.DiskShare;
import com.hierynomus.smbj.share.File;
import com.hierynomus.msdtyp.AccessMask;
import com.hierynomus.mssmb2.SMB2CreateDisposition;
import com.hierynomus.mssmb2.SMB2ShareAccess;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;
import java.util.LinkedHashSet;

public class FtpDirectory implements PolledDirectory {

    private final String host;
    private final String share;
    private final String dirPath;
    private final String archivePath;
    private final AuthenticationContext auth;

    public FtpDirectory(String host, String share, String dirPath, String archivePath, String username, String password, String domain) {
        this.host = host;
        this.share = share;
        this.dirPath = dirPath;
        this.archivePath = archivePath;
        this.auth = new AuthenticationContext(username, password.toCharArray(), domain);
    }

    @Override
    public Set<FileElement> listFiles() {
        Set<FileElement> result = new LinkedHashSet<>();

        try {
            for (FileIdBothDirectoryInformation file : getDiskShare().list(dirPath)) {
                if (".".equals(file.getFileName()) || "..".equals(file.getFileName())) {
                    //it gets some files named "." and "..", lets skip them
                    continue;
                }
                result.add(new FtpFile(file));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

    public File openFile(String fileName) throws IOException {
        // I need delete mask for moving to archive file
        return getDiskShare().openFile(dirPath + "/" + fileName,
                EnumSet.of(AccessMask.GENERIC_READ, AccessMask.DELETE),
                null,
                SMB2ShareAccess.ALL,
                SMB2CreateDisposition.FILE_OPEN,
                null);
    }

    public File openArchiveFile(String fileName) throws IOException {
        return getDiskShare().openFile(archivePath + "/" + fileName,
                EnumSet.of(AccessMask.GENERIC_WRITE),
                null,
                SMB2ShareAccess.ALL,
                SMB2CreateDisposition.FILE_OVERWRITE_IF,
                null);
    }

    private DiskShare getDiskShare() throws IOException {
        return (DiskShare) new SMBClient().connect(host).authenticate(auth).connectShare(share);
    }

    public String getDirPath() {
        return dirPath;
    }

}