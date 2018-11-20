import java.io.*;

/**
 * Created by Андрюха on 16.11.2018.
 */
public class Main {
    static Alph alph = new Alph();
    static Alph alphR = new AlphRegister();
    static int key = 4;
    static String testText = "Российский Технологический Университет - МИРЭА";
    static String encryptText;
    static String decryptText;

    static void write(String text, String filename)
    {
        try(FileWriter writer = new FileWriter(filename , false))
        {
            // запись всей строки
            writer.write(text);
            // запись по символам
            //writer.append('\n');
            //writer.append('E');

            //writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    static String read(String name)
    {
        String text = "";
        try{
            FileInputStream fstream = new FileInputStream(name);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;

            while ((strLine = br.readLine()) != null){
                text += strLine + "\n";
            }
        }catch (IOException e){
            System.out.println("Ошибка");
        }

        return text;
    }

    public static void task12()
    {
        Cezar cezar = new Cezar();
        System.out.println("Исходный текст: " + testText);
        encryptText = cezar.encrypt(testText, alph, key);
        System.out.println("Зашифрованный текст с ключом \'" + key + "\' : " + encryptText);
        decryptText = cezar.decrypt(encryptText, alph, key);
        System.out.println("Дешифрованный текст: " + decryptText);
    }

    public static void task3()
    {
        String book = read("bigText.txt");
        String part = read("text.txt");

        Cezar cezar = new Cezar();
        String encrPart = cezar.encrypt(part, alph, key);
        write(encrPart, "tomEncr.txt");

        Table tablePart = new Table(encrPart, alphR);
        tablePart.showTable();

        System.out.println("\n");

        Table tableBook = new Table(book, alphR);
        tableBook.showTable();

        Analisys analisys = new Analisys(encrPart, tablePart, tableBook, alphR);
        write(analisys.getText(), "decrypt.txt");
        analisys.statistics(part, analisys.getText());
        System.out.println("Частотный анализ. Расшифрованные буквы: " + analisys.trueLitera + "\nРасшифровано " + analisys.res +
                "% текста");
        analisys.bigramAnalysis(encrPart, book);
        write(analisys.getBigrText(), "bigrAnalisys.txt");
        analisys.statistics(part, analisys.getBigrText());
        System.out.println("Анализ биграмм. Расшифрованные буквы: " + analisys.trueLitera + "\nРасшифровано " + analisys.res +
                "% текста");
        analisys.bigramAnalysis(analisys.getText(), book);
        write(analisys.getBigrText(), "decrypt+bigrAnalisys.txt");
        analisys.statistics(part, analisys.getBigrText());
        System.out.println("Анализ биграмм. Расшифрованные буквы: " + analisys.trueLitera + "\nРасшифровано " + analisys.res +
                "% текста");
    }

    public static void main(String [] args)
    {
        task12();
        task3();
    }

}
