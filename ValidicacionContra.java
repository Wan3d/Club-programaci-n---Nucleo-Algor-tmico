
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidicacionContra {

    public static void main(String[] args) {
        String password = "BancoSeguro!2024";
        if (password.length() < 12 || password.length() > 22) {
            System.out.println("La contraseña debe tener entre 12 y 22 caracteres");
        }
        Pattern pattern = Pattern.compile("((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-_+=]))++");
        Matcher matcher = pattern.matcher(password);
        boolean matchFound = matcher.find();
        if (matchFound) {
            System.out.print("Contraseña válida");
        } else {
            System.out.println("Constraseña inválida");
        }
    }
}
