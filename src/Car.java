public class Car {
    int start;
    int end;
    String[] path;

//    Car(int start, int end, String[] paths){
//
//    }

    public Car(int start, int end, String[] path) {
        this.start = start;
        this.end = end;
        this.path = path;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String[] getPath() {
        return path;
    }

    public void setPath(String[] path) {
        this.path = path;
    }


}
