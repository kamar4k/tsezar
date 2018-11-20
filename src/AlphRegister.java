import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрюха on 16.11.2018.
 */
public class AlphRegister extends Alph{
    public char [] alphArr = new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н',
            'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
    private List<Character> alphList = new ArrayList<Character>();

    AlphRegister()
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
