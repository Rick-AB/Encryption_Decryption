import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UnicodeMode extends Default{

    @Override
    String encrypt(String text, int shift) {
        StringBuilder builder = new StringBuilder();
        char[] arr = text.toCharArray();
        for (char c : arr){
            int shifted = (int) c + shift;
            char character = (char) shifted;
            builder.append(character);
        }
        return builder.toString();
    }

    @Override
    String decrypt(String text, int shift) {
        StringBuilder builder = new StringBuilder();
        char[] arr = text.toCharArray();
        for (char c : arr){
            int shifted = (int) c - shift;
            if ((int) c >= 97 && (int) c <= 123){
                if (shifted < 97){
                    shifted = 123 - (97 -shifted );
                    char character = (char) shifted;
                    builder.append(character);
                }else {
                    char character = (char) shifted;
                    builder.append(character);
                }
            }else {
                char character = (char) shifted;
                builder.append(character);
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

