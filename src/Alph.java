import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрюха on 04.10.2018.
 */
public class Alph {

    public char [] alphArr = new char[]{'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т',
            'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь',
            'э', 'ю', 'я'};

    private List<Character> alphList = new ArrayList<Character>();

    Alph()
    {
        for (int i = 0; i < alphArr.length; i++)
        {
            alphList.add(alphArr[i]);
        }
    }

    public List<Character> getAlphList()
    {
        return alphList;
    }

    public char getAlphElement(int elementIndex)
    {
        return (char)alphList.get(elementIndex);
    }

    public int getIndexOfElement(char element)
    {
        return alphList.indexOf(element);
    }

    public int getAlphLength()
    {
        return alphArr.length;
    }

    public char getAlphArrayElement(int index) { return alphArr[index]; }
}
