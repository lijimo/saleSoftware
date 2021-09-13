public class photo {
    String pathToFile;
    String photoName;

    public void photo() {
        this.pathToFile = "";
        this.photoName = "";
    }

    public void photo(String photoName) {
        this.photoName = photoName;
        this.pathToFile = "";
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }
}
