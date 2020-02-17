import java.io.*;

public class Update implements Serializable {
  Update(String message) {
    this.message = message;
  }
  String message;
  public String toString() {
    return message;
  }
}

