public class Factory {
    public static Default newInstance(String type){
        if (type.equals("unicode")){
            return new UnicodeMode();
        }else {
            return new ShiftMode();
        }
    }
}
