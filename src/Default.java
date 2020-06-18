abstract class Default {

    abstract String encrypt(String text, int shift);
    abstract String decrypt(String text, int shift);
    abstract void performAction(String data, String mode, int key, String out);
}

