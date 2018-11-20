import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрюха on 16.11.2018.
 */
public class Table {

    List<Litera> tableList = new ArrayList<>();
    private char [] literaArr;
    private double [] chanceArr;

    public Table(String text, Alph alph)
    {
        char [] textArr = text.toCharArray();
        int length = 0;
/*
        for (int i = 0; i < textArr.length; i++)
        {

            for (int j = 0; j < alph.getAlphLength(); j++)
            {

                if (textArr[i] == alph.getAlphArrayElement(j))
                {
                    length++;
                }
            }
        }*/

        for (int i = 0; i < alph.getAlphLength(); i++) //Таблица частот
        {
            int count = 1;
            for (int j = 0; j < textArr.length; j++)
            {
                if (alph.getAlphArrayElement(i) == textArr[j])
                {
                    count++;
                }
            }
            double chance = 1.0 * count / text.length() * 100;
            tableList.add(new Litera(alph.getAlphArrayElement(i), chance));
        }

        sort();
    }

    private void sort()
    {
        literaArr = new char[tableList.size()];
        chanceArr = new double[tableList.size()];

        for (int i = 0; i < literaArr.length; i++)
        {
            literaArr[i] = tableList.get(i).getLitera();
            chanceArr[i] = tableList.get(i).getChance();
        }

        for (int i = 0; i < chanceArr.length - 1; i++)
        {

            for (int j = i + 1; j < chanceArr.length; j++)
            {
                if (chanceArr[i] < chanceArr[j])
                {
                    double tempD = chanceArr[i];
                    char tempC = literaArr[i];

                    chanceArr[i] = chanceArr[j];
                    literaArr[i] = literaArr[j];

                    chanceArr[j] = tempD;
                    literaArr[j] = tempC;
                }
            }

        }

    }

    public void showTable()
    {
        for (int i = 0; i < literaArr.length; i++)
        {
            System.out.println("[" + literaArr[i] + ", " + chanceArr[i] + " %]");
        }
    }

    public List<Litera> getTableList()
    {
        return tableList;
    }

    public int getLengthTable()
    {
        return literaArr.length;
    }

    public char getLitera(int i)
    {
        return literaArr[i];
    }

}
