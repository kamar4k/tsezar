public class Cezar {


    private char [] originalTextArray;
    private char [] encryptTextArray;
    private String encryptText = "";
    private String decryptText = "";

    public Cezar()
    {
    }

    private void stringToArray_E(String text)
    {
        originalTextArray = text.toCharArray();
    }

    private void stringToArray_D(String text)
    {
        encryptTextArray = text.toCharArray();
    }

    public String encrypt(String text, Alph alph, int key)
    {
        char [] newArray = new char[text.length()];
        stringToArray_E(text);


        for (int i = 0; i < originalTextArray.length; i++)
        {
            for (Character c : alph.getAlphList())
            {
                if (c == originalTextArray[i] && alph.getIndexOfElement(c) + key < alph.getAlphLength())
                {
                    newArray[i] = alph.getAlphElement(alph.getIndexOfElement(c) + key);
                    break;
                }
                if (c == originalTextArray[i] && alph.getIndexOfElement(c) + key >= alph.getAlphLength())
                {
                    newArray[i] = alph.getAlphElement(alph.getIndexOfElement(c) - alph.getAlphLength() + key);
                    break;
                }
                newArray[i] = originalTextArray[i];
            }
        }

        encryptText = new String(newArray);

        return encryptText;
    }

    public String decrypt(String text, Alph alph, int key)
    {
        char [] newArray = new char[text.length()];
        stringToArray_D(text);

        for (int i = 0; i < encryptTextArray.length; i++)
        {
            for (Character c : alph.getAlphList())
            {
                if (c == encryptTextArray[i] && alph.getIndexOfElement(c) - key >= 0)
                {
                    newArray[i] = alph.getAlphElement(alph.getIndexOfElement(c) - key);
                    break;
                }
                if (c == encryptTextArray[i] && alph.getIndexOfElement(c) - key < 0)
                {
                    newArray[i] = alph.getAlphElement(alph.getIndexOfElement(c) + alph.getAlphLength() - key);
                    break;
                }
                newArray[i] = encryptTextArray[i];
            }
        }
        decryptText = new String(newArray);
        return decryptText;
    }

}