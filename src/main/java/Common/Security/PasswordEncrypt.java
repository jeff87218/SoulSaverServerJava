package Common.Security;


import Common.JOOU.Unsigned;
import Common.JOOU.UInteger;

import java.util.Arrays;

public class PasswordEncrypt {
    private int Length;
    private char[] Result = new char[0];
    public static char[] Data2;
    private int Position = 0;
    private int ResultPosition = 0;
    private int encryptKey;

    public PasswordEncrypt(int ps) {
        this.encryptKey = ps;
    }

    public final String encrypt(String Password) {
        char[] EncryptPassword = new char[256];
        int EncryptResult = 0;
        Length = Password.length();
        char[] PasswordChar = Password.toCharArray();
        Data2 = new char[256];
        for (int i = 0; i < PasswordChar.length; i++) {
            Data2[i] = PasswordChar[i];
        }

        if (Length > 0) {
            do {
                int data = (int) Data2[Position] | (int) Data2[Position + 1] << 8 | (int) Data2[Position + 2] << 16 | (int) Data2[Position + 3] << 24;
                EncryptResult = this.encrypt(Unsigned.uint((this.encryptKey + data)), 1);
                this.encrypt2(Unsigned.uint(EncryptResult));
                Position += 4;
                ResultPosition += 7;
            } while (Position < Length);
            if (EncryptPassword != null) {
                for (int i = 1; i < 256 - Length; i++) {
                    Data2[Length + i] = EncryptPassword[Length + i];
                }
            }
        }
        return new String(Result);
    }


    private int encrypt(UInteger data, int mode) {
        byte[] key = {0x1A, 0x00, 0x00, 0x00, 0x1F, 0x00, 0x00, 0x00, 0x11, 0x00, 0x00, 0x00, 0x0A, 0x00, 0x00, 0x00, 0x1E, 0x00, 0x00, 0x00, 0x10, 0x00, 0x00, 0x00, 0x18, 0x00, 0x00, 0x00, 0x02, 0x00, 0x00, 0x00, 0x1D, 0x00, 0x00, 0x00, 0x08, 0x00, 0x00, 0x00, 0x14, 0x00, 0x00, 0x00, 0x0F, 0x00, 0x00, 0x00, 0x1C, 0x00, 0x00, 0x00, 0x0B, 0x00, 0x00, 0x00, 0x0D, 0x00, 0x00, 0x00, 0x04, 0x00, 0x00, 0x00, 0x13, 0x00, 0x00, 0x00, 0x17, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x0C, 0x00, 0x00, 0x00, 0x0E, 0x00, 0x00, 0x00, 0x1B, 0x00, 0x00, 0x00, 0x06, 0x00, 0x00, 0x00, 0x12, 0x00, 0x00, 0x00, 0x15, 0x00, 0x00, 0x00, 0x03, 0x00, 0x00, 0x00, 0x09, 0x00, 0x00, 0x00, 0x07, 0x00, 0x00, 0x00, 0x16, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x19, 0x00, 0x00, 0x00, 0x05, 0x00, 0x00, 0x00, 0x12, 0x00, 0x00, 0x00, 0x1D, 0x00, 0x00, 0x00, 0x07, 0x00, 0x00, 0x00, 0x19, 0x00, 0x00, 0x00, 0x0F, 0x00, 0x00, 0x00, 0x1F, 0x00, 0x00, 0x00, 0x16, 0x00, 0x00, 0x00, 0x1B, 0x00, 0x00, 0x00, 0x09, 0x00, 0x00, 0x00, 0x1A, 0x00, 0x00, 0x00, 0x03, 0x00, 0x00, 0x00, 0x0D, 0x00, 0x00, 0x00, 0x13, 0x00, 0x00, 0x00, 0x0E, 0x00, 0x00, 0x00, 0x14, 0x00, 0x00, 0x00, 0x0B, 0x00, 0x00, 0x00, 0x05, 0x00, 0x00, 0x00, 0x02, 0x00, 0x00, 0x00, 0x17, 0x00, 0x00, 0x00, 0x10, 0x00, 0x00, 0x00, 0x0A, 0x00, 0x00, 0x00, 0x18, 0x00, 0x00, 0x00, 0x1C, 0x00, 0x00, 0x00, 0x11, 0x00, 0x00, 0x00, 0x06, 0x00, 0x00, 0x00, 0x1E, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x15, 0x00, 0x00, 0x00, 0x0C, 0x00, 0x00, 0x00, 0x08, 0x00, 0x00, 0x00, 0x04, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00};
        int result = 0;

        UInteger v2 = data;
        int v6 = 0;
        if (data.compareTo(Unsigned.uint(0)) > 0) {
            int position = 0;
            do {
                UInteger v5 = v2.subtract(v2.and(Unsigned.uint(0xFFFFFFFE)));
                v2 = v2.rightShift(1);
                if (v5.intValue() > 0) {
                    v6 = key[position];
                    result = v5.leftShift(v6).add(Unsigned.uint(result)).intValue();
                }
                position += 4;
            } while (v2.compareTo(Unsigned.uint(0)) > 0);
        }
        return result;
    }

    private void encrypt2(UInteger a1) {
        UInteger v2, temp, temp2, temp3;
        char[] table = new char[36];
        "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".getChars(0, 36, table, 0);
        char[] tempchar = Arrays.copyOf(Result, Result.length);
        Result = Arrays.copyOf(tempchar, Result.length + 7);

        Result[0 + ResultPosition] = table[a1.mod(Unsigned.uint(0x24)).intValue()];
        v2 = a1.divide(Unsigned.uint(0x24)).divide(Unsigned.uint(0x24));
        Result[1 + ResultPosition] = table[a1.divide(Unsigned.uint(0x24)).mod(Unsigned.uint(0x24)).intValue()];
        temp = v2;
        v2 = v2.divide(Unsigned.uint(0x24));
        Result[2 + ResultPosition] = table[temp.subtract(Unsigned.uint(36).multiply(v2)).intValue()];
        temp2 = v2;
        v2 = v2.divide(Unsigned.uint(0x24));
        Result[3 + ResultPosition] = table[temp2.subtract(Unsigned.uint(36).multiply(v2)).intValue()];
        temp3 = v2;
        v2 = v2.divide(Unsigned.uint(0x24));
        Result[4 + ResultPosition] = table[temp3.subtract(Unsigned.uint(36).multiply(v2)).intValue()];
        Result[5 + ResultPosition] = table[v2.mod(Unsigned.uint(0x24)).intValue()];
        Result[6 + ResultPosition] = table[v2.divide(Unsigned.uint(0x24)).mod(Unsigned.uint(0x24)).intValue()];
    }
}