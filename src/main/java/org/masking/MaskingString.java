package org.masking;

public class MaskingString {
    public static void main(String[] args) {
        String maskstr=maskString("4921062579966159");
        System.out.println("Masked Num : "+maskstr);

    }
    public static String maskString(String parameter){
        if (parameter == null || parameter.length() < 4) {
            return parameter;
        }
        StringBuilder masked = new StringBuilder();
        for (int i = 0; i < parameter.length() - 4; i++) {
            masked.append('*');
        }
        masked.append(parameter.substring(parameter.length() - 4));

        return masked.toString();
    }
}
