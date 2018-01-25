package com.example.ik_2dm3.ijcapp;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Pista6 extends AppCompatActivity {

    //Creamos los imageviews tanto de las piezas como de los fondos donde van colocadas
    private ImageView ivFondo61;
    private ImageView ivPieza61;
    private ImageView ivFondo62;
    private ImageView ivPieza62;
    private ImageView ivFondo63;
    private ImageView ivPieza63;
    private ImageView ivFondo64;
    private ImageView ivPieza64;
    private ImageView ivFondo65;
    private ImageView ivPieza65;
    private ImageView ivFondo66;
    private ImageView ivPieza66;
    private ImageView ivFondo67;
    private ImageView ivPieza67;
    private ImageView ivFondo68;
    private ImageView ivPieza68;
    private ImageView ivFondo69;
    private ImageView ivPieza69;

    //Creamos una etiqueta para cada pieza
    private static final String IMAGEVIEW_TAG1 = "im1";
    private static final String IMAGEVIEW_TAG2 = "im2";
    private static final String IMAGEVIEW_TAG3 = "im3";
    private static final String IMAGEVIEW_TAG4 = "im4";
    private static final String IMAGEVIEW_TAG5 = "im5";
    private static final String IMAGEVIEW_TAG6 = "im6";
    private static final String IMAGEVIEW_TAG7 = "im7";
    private static final String IMAGEVIEW_TAG8 = "im8";
    private static final String IMAGEVIEW_TAG9 = "im9";

    //Creamos una etiqueta para busqueda de errores
    private static final String TAG = "TAG";

    //Creamos variables que comprueben que cada pieza esta bien o mal colocada
    private boolean acertado1=false;
    private boolean acertado2=false;
    private boolean acertado3=false;
    private boolean acertado4=false;
    private boolean acertado5=false;
    private boolean acertado6=false;
    private boolean acertado7=false;
    private boolean acertado8=false;
    private boolean acertado9=false;

    //Creamos la variable que nos diga si el puzzle esta resuelto
    private boolean solucionado=false;

    //Creamos un arraylist con las piezas
    private ArrayList<ImageView> arrayListPiezas;
    //Creamos un arraylist con los fondos de las piezas (Azules)
    private ArrayList<ImageView> arrayListFondos;
    //Creamos un arraylist con las etiquetas de las piezas
    private ArrayList<String> arrayListEtiquetas;
    //Creamos un arraylist con el recurso (integer) drawable de cada pieza
    private ArrayList<Integer> arrayListDrawablesPiezas;
    //Creamos un arraylist con el recurso (integer) drawable de cada fondo de cada pieza
    private ArrayList<Integer> arrayListDrawablesFondos;
    //Creamos un arraylist con los booleanos que comprueban si cada pieza esta colocada
    private ArrayList<Boolean> arrayListAcertado;

    //Creamos uan variable vista que será donde guardemos la que estemos arrastrando
    private View vista;

    //Creamos los contraintlayout correspondientes a cada cometido que se ve en el XML
    private ConstraintLayout clSolucion6;
    private ConstraintLayout clPiezas6;
    private ConstraintLayout clEnunciadoPista6;
    private ConstraintLayout clPuzzlePista6;

    //Creamos una variable toast que de final al ejercicio
    private Toast toast;

    //Creamos el boton para salir del activity
    private Button btnFin6;

    //Creamos el boton para pasar del enunciado al puzzle
    private Button btnSiguiente6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pista6);

        //Traemos todas las variables desde los recursos al codigo

        btnFin6=(Button) findViewById(R.id.btnFin6);
        btnSiguiente6=(Button) findViewById(R.id.btnSiguiente6);

        arrayListPiezas=new ArrayList<>();
        arrayListFondos=new ArrayList<>();
        arrayListEtiquetas=new ArrayList<>();
        arrayListDrawablesPiezas=new ArrayList<>();
        arrayListDrawablesFondos=new ArrayList<>();
        arrayListAcertado=new ArrayList<>();

        clSolucion6=(ConstraintLayout) findViewById(R.id.clSolucion6);
        clPiezas6=(ConstraintLayout) findViewById(R.id.clPiezas6);
        clEnunciadoPista6=(ConstraintLayout) findViewById(R.id.clEnunciadoPista6);
        clPuzzlePista6=(ConstraintLayout) findViewById(R.id.clPuzzlePista6);

        arrayListDrawablesPiezas.add(R.drawable.p16);
        arrayListDrawablesPiezas.add(R.drawable.p26);
        arrayListDrawablesPiezas.add(R.drawable.p36);
        arrayListDrawablesPiezas.add(R.drawable.p46);
        arrayListDrawablesPiezas.add(R.drawable.p56);
        arrayListDrawablesPiezas.add(R.drawable.p66);
        arrayListDrawablesPiezas.add(R.drawable.p76);
        arrayListDrawablesPiezas.add(R.drawable.p86);
        arrayListDrawablesPiezas.add(R.drawable.p96);

        arrayListDrawablesFondos.add(R.drawable.pfondo);
        arrayListDrawablesFondos.add(R.drawable.pfondo);
        arrayListDrawablesFondos.add(R.drawable.pfondo);
        arrayListDrawablesFondos.add(R.drawable.pfondo);
        arrayListDrawablesFondos.add(R.drawable.pfondo);
        arrayListDrawablesFondos.add(R.drawable.pfondo);
        arrayListDrawablesFondos.add(R.drawable.pfondo);
        arrayListDrawablesFondos.add(R.drawable.pfondo);
        arrayListDrawablesFondos.add(R.drawable.pfondo);

        arrayListAcertado.add(acertado1);
        arrayListAcertado.add(acertado2);
        arrayListAcertado.add(acertado3);
        arrayListAcertado.add(acertado4);
        arrayListAcertado.add(acertado5);
        arrayListAcertado.add(acertado6);
        arrayListAcertado.add(acertado7);
        arrayListAcertado.add(acertado8);
        arrayListAcertado.add(acertado9);

        arrayListEtiquetas.add(IMAGEVIEW_TAG1);
        arrayListEtiquetas.add(IMAGEVIEW_TAG2);
        arrayListEtiquetas.add(IMAGEVIEW_TAG3);
        arrayListEtiquetas.add(IMAGEVIEW_TAG4);
        arrayListEtiquetas.add(IMAGEVIEW_TAG5);
        arrayListEtiquetas.add(IMAGEVIEW_TAG6);
        arrayListEtiquetas.add(IMAGEVIEW_TAG7);
        arrayListEtiquetas.add(IMAGEVIEW_TAG8);
        arrayListEtiquetas.add(IMAGEVIEW_TAG9);

        ivFondo61=(ImageView) findViewById(R.id.ivFondo61);
        ivPieza61=(ImageView) findViewById(R.id.ivPieza16);
        ivFondo62=(ImageView) findViewById(R.id.ivFondo62);
        ivPieza62=(ImageView) findViewById(R.id.ivPieza26);
        ivFondo63=(ImageView) findViewById(R.id.ivFondo63);
        ivPieza63=(ImageView) findViewById(R.id.ivPieza36);
        ivFondo64=(ImageView) findViewById(R.id.ivFondo64);
        ivPieza64=(ImageView) findViewById(R.id.ivPieza46);
        ivFondo65=(ImageView) findViewById(R.id.ivFondo65);
        ivPieza65=(ImageView) findViewById(R.id.ivPieza56);
        ivFondo66=(ImageView) findViewById(R.id.ivFondo66);
        ivPieza66=(ImageView) findViewById(R.id.ivPieza66);
        ivFondo67=(ImageView) findViewById(R.id.ivFondo67);
        ivPieza67=(ImageView) findViewById(R.id.ivPieza76);
        ivFondo68=(ImageView) findViewById(R.id.ivFondo68);
        ivPieza68=(ImageView) findViewById(R.id.ivPieza86);
        ivFondo69=(ImageView) findViewById(R.id.ivFondo69);
        ivPieza69=(ImageView) findViewById(R.id.ivPieza96);

        arrayListFondos.add(ivFondo61);
        arrayListPiezas.add(ivPieza61);
        arrayListFondos.add(ivFondo62);
        arrayListPiezas.add(ivPieza62);
        arrayListFondos.add(ivFondo63);
        arrayListPiezas.add(ivPieza63);
        arrayListFondos.add(ivFondo64);
        arrayListPiezas.add(ivPieza64);
        arrayListFondos.add(ivFondo65);
        arrayListPiezas.add(ivPieza65);
        arrayListFondos.add(ivFondo66);
        arrayListPiezas.add(ivPieza66);
        arrayListFondos.add(ivFondo67);
        arrayListPiezas.add(ivPieza67);
        arrayListFondos.add(ivFondo68);
        arrayListPiezas.add(ivPieza68);
        arrayListFondos.add(ivFondo69);
        arrayListPiezas.add(ivPieza69);

        //Ponemos el listener a btnfin para acabar el activity
        btnFin6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tick();
                finish();
            }
        });

        //Ponemos un listener al boton para pasar del enunciado al puzzle
        btnSiguiente6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clEnunciadoPista6.setVisibility(View.GONE);
                clPuzzlePista6.setVisibility(View.VISIBLE);
            }
        });

        //POnemos un ontouchlistener en cada pieza para que al ser tocada le indiquemos que comience el
        //startdraganddrop o el startdrag dependiendo de la version de API, esto creara una sombra
        //y mandara al draglistener una señal que recibirá
        for(int i=0;i<arrayListPiezas.size();i++){
            //A cada pieza le añadimos su etiqueta ya que para crear la sombra se necesita
            arrayListPiezas.get(i).setTag(arrayListEtiquetas.get(i));
            //Añadimos a cada pieza su touchlistener
            arrayListPiezas.get(i).setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View vOT, MotionEvent motionEvent) {
                    //Asignamos a vista la pieza que se esta tocando para trabajar con ella
                    // en el draglistener y que éste no compruebe todas las piezas
                    vista = vOT;
                    switch(motionEvent.getAction()) {
                        //Si tocamos la pieza
                        case MotionEvent.ACTION_DOWN:
                            // Creamos un ClipData.Item con la etiqueta de la pieza que estamos tocando
                            ClipData.Item item = new ClipData.Item((String) vOT.getTag());
                            // Creamos un ClipData usando la etiqueta, el texto plano de tipo MIME, y
                            // el item creado. Estos son datos que necesita la sombra para crearse
                            ClipData dragData = new ClipData((CharSequence) vOT.getTag(), new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN}, item);
                            // Instanciamos el constructor de la sombra de la pieza
                            View.DragShadowBuilder myShadow = new View.DragShadowBuilder(vOT);
                            // Empezamos el arrastre
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                vOT.startDragAndDrop(dragData,  // los datos a ser arrastrados
                                        myShadow,  // el constructor de la sombra arrastrada
                                        null,      // no es necesario usar datos locales
                                        0          // no se usa, poner a 0
                                );
                            } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N){
                                vOT.startDrag(dragData,  // los datos a ser arrastrados
                                        myShadow,  // el constructor de la sombra arrastrada
                                        null,      // no es necesario usar datos locales
                                        0          // no se usa, poner a 0
                                );
                            }
                            //Hacemos invisible la vista ya que ya tenemos la sombra
                            vOT.setVisibility(View.INVISIBLE);
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });
        }

        //Asigno a cada fondo de las piezas un draglistener para que si reciben la pieza que les
        //Corresponde cambien su imagen. En lugar de recuperar el dragdata recupero los datos de la
        //pieza arrastrada con "vista". Es similar
        for(int j=0;j<arrayListFondos.size();j++){
            //Hay que crear una variable final con el valor de j porque tenemos que acceder a el
            // desde clases que estan dentro de el mismo for
            final int finalJ = j;
            //Asigno los draglisteners
            arrayListFondos.get(finalJ).setOnDragListener(new View.OnDragListener() {
                @Override
                public boolean onDrag(View vOD, DragEvent dragEvent) {
                    //Esto funciona para cualquier sombra, es decir, con cualquier sombra que entre
                    //A cualquier fondo de pieza que tenga un draglistener asignado se activara
                    //por eso se comprueba despues que es el que me interesa para que cambie
                    //De imagen
                    switch(dragEvent.getAction()){
                        //Si estamos dentro del fondo con una sombra
                        case DragEvent.ACTION_DRAG_ENTERED:
                            //Comprobamos si la etiqueta de la sombra coincide con la de la pieza
                            //en la que esté
                            if(vista.getTag().equals(arrayListEtiquetas.get(finalJ))){
                                //Cambio su imagen a la de la pieza
                                ((ImageView)vOD).setImageResource(arrayListDrawablesPiezas.get(finalJ));
                                //Cambio el estado de acertado de esa pieza a true
                                arrayListAcertado.set(finalJ,true);
                            }
                            break;
                        //Si salgo del fondo con la sombra
                        case DragEvent.ACTION_DRAG_EXITED:
                            //Compruebo de nuevo que coinciden fondo y sombra
                            if(vista.getTag().equals(arrayListEtiquetas.get(finalJ))) {
                                //Cambio su imagen al fondo
                                ((ImageView)vOD).setImageResource(arrayListDrawablesFondos.get(finalJ));
                                //Cambio el estado de acertado de esa pieza a false
                                arrayListAcertado.set(finalJ,false);
                            }
                            break;
                        //Si termina el arrastre, es decir, si levanto la mano
                        case DragEvent.ACTION_DRAG_ENDED:
                            //Si coincide la etiqueta y si no está acertado
                            if(vista.getTag().equals(arrayListEtiquetas.get(finalJ)) && arrayListAcertado.get(finalJ)==false){
                                //En las api anteriores a la 24 se dan problemas de concurrencia, ya que la vista a la que se está intentando
                                //modificar la visibilidad, está siendo arrastrada a la vez y por tanto está siendo excluida de la collecion interna
                                //de vistas de android. Para modificarlo se hace en un hilo a parte.
                                vista.post(new Runnable(){
                                    @Override public void run() {
                                        vista.setVisibility(View.VISIBLE);
                                    }
                                });
                            }
                            //Comprobamos si esta terminado el puzzle y si es asi borramos tod
                            //lo que esta en pantalla, mostramos el puzzle resuelto y la pregunta
                            if(acabado()==true){
                                btnFin6.setVisibility(View.VISIBLE);
                            }
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });
        }
    }
    //La funcion acabado comprueba que todas las piezas estan acertadas
    public Boolean acabado(){
        int contador=0;
        for(int z=0;z<arrayListAcertado.size();z++){
            if(arrayListAcertado.get(z)==true){
                contador++;
            }
        }
        if(contador==arrayListAcertado.size()){
            solucionado=true;
        }else{
            solucionado=false;
        }
        return solucionado;
    }

    public void tick(){
        //CCCargamos el layout del tick
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.acierto,
                (ViewGroup) findViewById(R.id.clAcierto));
        //Creamos el toast
        toast = new Toast(getApplicationContext());
        //Lo centramos
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        //Le ponemos duración corta
        toast.setDuration(Toast.LENGTH_SHORT);
        //Le asignamos el layout
        toast.setView(layout);
        //Lo mostramos
        toast.show();
    }
}
