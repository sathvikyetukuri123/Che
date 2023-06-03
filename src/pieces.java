public class pieces
{
    private int xCor;
    private int yCor;
    private boolean king;
    private char color;

    public pieces()
    {
        xCor = 0;
        yCor = 0;
        king = false;
    }

    public pieces( int x, int y, boolean b, char c)
    {
        xCor = x;
        yCor = y;
        king = b;
        color = c;
    }

    public int getX()
    {
        return xCor;
    }

    public int getY()
    {
        return yCor;
    }

    public boolean kingStatus()
    {
        return king;
    }

    public void setX(int x)
    {
        xCor = x;
    }

    public void setY(int y)
    {
        yCor = y;
    }

    public void makeKing(boolean k)
    {
        king = k;
    }

    public char getColor(){
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }
}