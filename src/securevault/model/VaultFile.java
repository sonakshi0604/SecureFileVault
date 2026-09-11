package securevault.model;

public class VaultFile {

    private String fileName;
    private String filePath;
    private long fileSize;

    public VaultFile(String fileName, String filePath, long fileSize) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void displayFileInfo() {
        System.out.println("File Name : " + fileName);
        System.out.println("File Path : " + filePath);
        System.out.println("File Size : " + fileSize + " bytes");
    }
}