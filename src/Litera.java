/**
 * Created by Андрюха on 16.11.2018.
 */
public class Litera {

    private char litera;
    private double chance;

    public Litera(char litera, double chance)
    {
        this.litera = litera;
        this.chance = chance;
    }

    public char getLitera()
    {
        return litera;
    }

    public double getChance()
    {
        return chance;
    }

    @Override
    public String toString()
    {
        return "[" + litera + ", " + chance + "%]";
    }

}
