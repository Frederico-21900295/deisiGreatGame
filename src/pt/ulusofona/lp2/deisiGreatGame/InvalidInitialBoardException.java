package pt.ulusofona.lp2.deisiGreatGame;

public class InvalidInitialBoardException extends java.lang.Exception{
    String message;
    int id;

    InvalidInitialBoardException() { }
    public InvalidInitialBoardException(String message) {
        this.message = message;
    }

    public InvalidInitialBoardException(String message,int id){
        this.message = message;
        this.id=id;
    }

    public String getMessage() {
        return message;
    }

    public Boolean isInvalidAbyss() {
        return message.contains("ABISMO");
    }

    public Boolean isInvalidTool() {
        return message.contains("FERRAMENTA");
    }

    public String getTypeId() {
        return String.valueOf(id);
    }
}
