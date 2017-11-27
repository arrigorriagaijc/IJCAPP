import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.widget.Button;

public class Botones extends AppCompatButton
{
    public int x = 0 ;
    public int y = 0;

    public int index = 0; //dice cual es el fondo yen este cado el dibujito

    public Botones (Context context, int x, int y, int index, int background){
        super(context);
        this.x=x;
        this.y=y;
        this.index=index;
        this.setBackgroundResource(background);
    }
    public int getNewIndex(){
        index++;
        if (index==/*3*/2) index=0;/////////////////////////////////////////////////////////////////////
        return index;
    }
}
