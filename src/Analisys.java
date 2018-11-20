import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Андрюха on 16.11.2018.
 */
public class Analisys {

    private char [] arrPart;
    private char [] newArrPart;
    private String text;
    private String bigrText;
    List<Character> trueLitera = new ArrayList<>();
    List<Character> trueLitera1 = new ArrayList<>();
    List<String> topBigramsBook = new ArrayList<>();
    List<String> topBigramsPart = new ArrayList<>();
    Map<String, Integer> firstBigramsMap = new HashMap<>();
    double res;
    double res1;
    Alph alph;

    public Analisys(String part, Table tablePart, Table tableBook, Alph alph)
    {
        this.alph = alph;
        arrPart = part.toCharArray();
        newArrPart = new char[arrPart.length];

        for (int i = 0; i < arrPart.length; i++)
        {
            boolean has = false;
            for (int j = 0; j < tablePart.getLengthTable(); j++)
            {
                if (arrPart[i] == tablePart.getLitera(j))
                {
                    has = true;
                    newArrPart[i] = tableBook.getLitera(j);
                    break;
                }
            }
            if (!has)
            {
                newArrPart[i] = arrPart[i];
            }
        }

        text = new String(newArrPart);
    }

    private Map<String, Integer> getMap(char [] charArr)
    {
        Map <String, Integer> tmpMap = new HashMap<>();
        for (int i = 0; i < charArr.length - 1; i++)
        {
            if (alph.getAlphList().contains(charArr[i]) && alph.getAlphList().contains(charArr[i+1]))
            {
                String tmp = "" + charArr[i] + charArr[i + 1];
                if (tmpMap.containsKey(tmp))
                {
                    tmpMap.put(tmp, tmpMap.get(tmp) + 1);
                }
                else
                {
                    tmpMap.put(tmp, 1);
                }
            }
        }
        return tmpMap;
    }

    private List<String> getTopBigramsMap(Map<String, Integer> map)
    {
        List<String> top = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            String maxStr = "";
            Integer max = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet())
            {
                if (max < entry.getValue())
                {
                    maxStr = entry.getKey();
                    max = entry.getValue();
                }
            }
            top.add(maxStr);
            map.remove(maxStr);
        }
        return top;
    }

    public void bigramAnalysis(String part, String book)
    {

        char [] partArr = part.toCharArray();
        char [] bookArr = book.toCharArray();

        topBigramsBook = getTopBigramsMap(getMap(bookArr));
        topBigramsPart = getTopBigramsMap(getMap(partArr));

        System.out.println(topBigramsBook);
        System.out.println(topBigramsPart);

        char [] newTextArr = new char[partArr.length];

        for (int i = 0; i < newArrPart.length - 1; i++)
        {
            String temp = "" + partArr[i] + partArr[i + 1];
            if (topBigramsPart.contains(temp))
            {
                char [] tempBigr = topBigramsBook.get(topBigramsPart.indexOf(temp)).toCharArray();
                newTextArr[i] = tempBigr[0];
                newTextArr[i + 1] = tempBigr[1];
                i++;
            }
            else
            {
                newTextArr[i] = partArr[i];
            }
        }
        bigrText = new String(newTextArr);
     //   bigrText = part;


    }

    public void statistics(String original, String decr)
    {
        trueLitera = new ArrayList<>();

        char [] originalArr = original.toCharArray();
        char [] decrArr = decr.toCharArray();


        for (int i = 0; i < originalArr.length; i++)
        {
            if (originalArr[i] == decrArr[i] && !trueLitera.contains(decrArr[i]) && alph.getAlphList().contains(decrArr[i]))
            {
                trueLitera.add(decrArr[i]);
            }
        }

        res = 1.0 * trueLitera.size() / 33 * 100;
    }

    public void statistics1(String original, String decr)
    {
        char [] originalArr = original.toCharArray();
        char [] decrArr = decr.toCharArray();


        for (int i = 0; i < originalArr.length; i++)
        {
            if (originalArr[i] == decrArr[i] && !trueLitera1.contains(decrArr[i]) && alph.getAlphList().contains(decrArr[i]))
            {
                trueLitera1.add(decrArr[i]);
            }
        }

        res1 = 1.0 * trueLitera1.size() / 33 * 100;
    }

    public String getText()
    {
        return text;
    }
    public String getBigrText() { return bigrText; }

}
