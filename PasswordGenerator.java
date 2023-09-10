import java.util.Random;
import java.util.Scanner;

//class containing character set
class Characters {
    static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String DIGITS = "0123456789";
    static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?";
    String charset = LOWERCASE_CHARS + UPPERCASE_CHARS + DIGITS + SPECIAL_CHARS;
}
// class for create a password and and convert it into string

class Password extends Characters {
    String function(int length, String charset) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charset.length());
            char randomChar = charset.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the length of the password : ");
        int length = sc.nextInt();
        Password obj= new Password();
        String password = obj.function(length, obj.charset);
        System.out.println("Generated Password: " + password);
        
    }

}
