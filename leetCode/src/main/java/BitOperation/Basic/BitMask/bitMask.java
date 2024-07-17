package BitOperation.Basic.BitMask;

class bitMask {
    public static void main(String[] args) {
        System.out.println("int number: " + (1 << 0) + "    eight Bits Binary: " + to8BitBinaryString(1 << 0));// 1
        System.out.println("int number: " + (1 << 1) + "    eight Bits Binary: " + to8BitBinaryString(1 << 1));// 2
        System.out.println("int number: " + (1 << 2) + "    eight Bits Binary: " + to8BitBinaryString(1 << 2));// 4
        System.out.println("int number: " + (1 << 3) + "    eight Bits Binary: " + to8BitBinaryString(1 << 3));// 8
    }

    public static String to8BitBinaryString(int number) {
        // Mask the number to fit within 8 bits and get its binary string representation
        String binaryString = Integer.toBinaryString(number & 0xFF);
        // Format the string to 8 bits with leading zeros
        return String.format("%8s", binaryString).replace(' ', '0');
    }
}

/*
    1 << 1

    1 in binary: 00000001
    1 << 1: Shift all bits to the left by one position, resulting in 00000010
    00000010 in decimal: 2

*/