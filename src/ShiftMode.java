import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ShiftMode extends Default{
    @Override
    String encrypt(String text, int shift) {
        StringBuilder builder = new StringBuilder();
        char[] arr = text.toCharArray();
        for (char c : arr){
            if (((int) c >= 97 && (int) c < 123)){
                int shifted = (int) c + shift;
                if (shifted >= 123){
                    shifted = 97 + (shifted - 123);
                    char character = (char) shifted;
                    builder.append(character);
                }else {
                    char character = (char) shifted;
                    builder.append(character);
                }
            }else if ((int) c >= 65 && (int) c < 91){
                int shifted = (int) c + shift;
                if (shifted >= 91){
                    shifted = 65 + (shifted - 91);
                    char character  = (char) shifted;
                    builder.append(character);
                }else {
                    char character = (char) shifted;
                    builder.append(character);
                }
            }else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    @Override
    String decrypt(String text, int shift) {
        StringBuilder builder = new StringBuilder();
        char[] arr = text.toCharArray();
        for (char c : arr){
            if (((int) c >= 97 && (int) c < 123)){
                int shifted = (int) c - shift;
                if (shifted < 97){
                    shifted = 123 - (97 - shifted);
                    char character = (char) shifted;
                    builder.append(character);
                }else {
                    char character = (char) shifted;
                    builder.append(character);
                }
            }else if((int) c >= 65 && (int) c < 91){
                int shifted = (int) c - shift;
                if (shifted < 65){
                    shifted = 91 - (65 - shifted);
                    char character = (char) shifted;
                    builder.append(character);
                }else {
                    char character = (char) shifted;
                    builder.append(character);
                }
            }else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    @Override
    void performAction(String data, String mode, int key, String out) {
        if (mode.equals("enc")){
            String encryptedData = encrypt(data, key);
            if (!out.isEmpty()){
                File file = new File(out);
                try(FileWriter writer = new FileWriter(file)){
                    writer.write(encryptedData);
                }catch (IOException e){
                    System.out.println("Error");
                }
            }else {
                System.out.println(encrypt(data, key));
            }
        }else {
            String decryptedData = decrypt(data, key);
            if (!out.isEmpty()){
                File file = new File(out);
                try(FileWriter writer = new FileWriter(file)){
                    writer.write(decryptedData);
                }catch (IOException e){
                    System.out.println("Error");
                }
            }else {
                System.out.println(decrypt(data, key));
            }
        }
    }
}