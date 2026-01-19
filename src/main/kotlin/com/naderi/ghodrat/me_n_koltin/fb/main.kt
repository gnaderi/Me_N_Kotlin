/**
Rotational Cipher
One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount. Rotating a character means replacing it with another character that is a certain number of steps away in normal alphabetic or numerical order.
For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?". Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A), and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric characters remain unchanged.
Given a string and a rotation factor, return an encrypted string.
Signature
string rotationalCipher(string input, int rotationFactor)
Input
1 <= |input| <= 1,000,000
0 <= rotationFactor <= 1,000,000
Output
Return the result of rotating input a number of times equal to rotationFactor.
Example 1
input = Zebra-493?
rotationFactor = 3
output = Cheud-726?
Example 2
input = abcdefghijklmNOPQRSTUVWXYZ0123456789
rotationFactor = 39
output = nopqrstuvwxyzABCDEFGHIJKLM9012345678

 */
fun main(args: Array<String>) {
    println("cipherVal=" + rotationalCipher("Zebra-493?", 3))
    println("cipherVal=" + rotationalCipher("abcdefghijklmNOPQRSTUVWXYZ0123456789", 39))
    println("cipherVal=" + rotationalCipher("abcdefghijklmNOPQRSTUVWXYZ0123456789", 0))
}

fun rotationalCipher(input: String, rotationFactor: Int): String {
    val cipherMap = HashMap<Char, Char>()

    addDigits(rotationFactor, cipherMap)
    addLetters(rotationFactor, cipherMap)

    val sb = StringBuffer()

    for (ch: Char in input) {
        val cipherVal = cipherMap.get(ch)
        sb.append(cipherVal ?: ch)
    }
    return sb.toString()
}


private fun addDigits(rotationFactor: Int, cipherMap: HashMap<Char, Char>) {
    for (i in 0..9) {
        val key = '0'.plus(i)
        val value = '0'.plus((i + rotationFactor) % 10)
        cipherMap.put(key, value)
    }
}

private fun addLetters(rotationFactor: Int, cipherMap: HashMap<Char, Char>) {
    for (i in 0..25) {
        val key = 'a'.plus(i)
        val value = 'a'.plus((i + rotationFactor) % 26)
        cipherMap.put(key, value)
        cipherMap.put(key.uppercaseChar(), value.uppercaseChar())
    }
}