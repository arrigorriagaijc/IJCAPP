package com.example.ik_2dm3.ijcapp;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Pista5 extends AppCompatActivity {

    //Creamos el radiogroup que nos dejara seleccionar la respuesta correcta
    private RadioGroup rgPregunta;
    private RadioButton rbRespuesta1;
    private RadioButton rbRespuesta2;
    private RadioButton rbRespuesta3;

    //Creamos los imageviews tanto de las piezas como de los fondos donde van colocadas
    private ImageView ivFondo1;
    private ImageView ivPieza1;
    private ImageView ivFondo2;
    private ImageView ivPieza2;
    private ImageView ivFondo3;
    private ImageView ivPieza3;
    private ImageView ivFondo4;
    private ImageView ivPieza4;
    private ImageView ivFondo5;
    private ImageView ivPieza5;
    private ImageView ivFondo6;
    private ImageView ivPieza6;
    private ImageView ivFondo7;
    private ImageView ivPieza7;
    private ImageView ivFondo8;
    private ImageView ivPieza8;
    private ImageView ivFondo9;
    private ImageView ivPieza9;

    //Creamos el imageview del puzzle ya montado
    private ImageView ivFondo;

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
    private ConstraintLayout clSolucion;
    private ConstraintLayout clPiezas;
    private ConstraintLayout clEnunciadoPista5;
    private ConstraintLayout clPregunta;
    private ConstraintLayout clPuzzlePista5;
    private ConstraintLayout clFondo;

    //Creamos una variable toast que de final al ejercicio
    private Toast toast;

    //Creamos el boton siguiente que pasa del enunciado al puzzle
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pista5);

        //Traemos todas las variables desde los recursos al codigo

        btnSiguiente=(Button) findViewById(R.id.btnSiguiente);

        rgPregunta=(RadioGroup) findViewById(R.id.rgPregunta);
        rbRespuesta1=(RadioButton) findViewById(R.id.rbRespuesta1);
        rbRespuesta2=(RadioButton) findViewById(R.id.rbRespuesta2);
        rbRespuesta3=(RadioButton) findViewById(R.id.rbRespuesta3);

        arrayListPiezas=new ArrayList<>();
        arrayListFondos=new ArrayList<>();
        arrayListEtiquetas=new ArrayList<>();
        arrayListDrawablesPiezas=new ArrayList<>();
        arrayListDrawablesFondos=new ArrayList<>();
        arrayListAcertado=new ArrayList<>();

        clSolucion=(ConstraintLayout) findViewById(R.id.clSolucion);
        clPregunta=(ConstraintLayout) findViewById(R.id.clPregunta);
        clPiezas=(ConstraintLayout) findViewById(R.id.clPiezas);
        clEnunciadoPista5=(ConstraintLayout) findViewById(R.id.clEnunciadoPista5);
        clPuzzlePista5=(ConstraintLayout) findViewById(R.id.clPuzzlePista5);
        clFondo=(ConstraintLayout) findViewById(R.id.clFondo);

        arrayListDrawablesPiezas.add(R.drawable.p1);
        arrayListDrawablesPiezas.add(R.drawable.p2);
        arrayListDrawablesPiezas.add(R.drawable.p3);
        arrayListDrawablesPiezas.add(R.drawable.p4);
        arrayListDrawablesPiezas.add(R.drawable.p5);
        arrayListDrawablesPiezas.add(R.drawable.p6);
        arrayListDrawablesPiezas.add(R.drawable.p7);
        arrayListDrawablesPiezas.add(R.drawable.p8);
        arrayListDrawablesPiezas.add(R.drawable.p9);

        arrayListDrawablesFondos.add(R.drawable.p1fondo);
        arrayListDrawablesFondos.add(R.drawable.p2fondo);
        arrayListDrawablesFondos.add(R.drawable.p3fondo);
        arrayListDrawablesFondos.add(R.drawable.p4fondo);
        arrayListDrawablesFondos.add(R.drawable.p5fondo);
        arrayListDrawablesFondos.add(R.drawable.p6fondo);
        arrayListDrawablesFondos.add(R.drawable.p7fondo);
        arrayListDrawablesFondos.add(R.drawable.p8fondo);
        arrayListDrawablesFondos.add(R.drawable.p9fondo);

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

        ivFondo=(ImageView) findViewById(R.id.ivFondo);
        ivFondo1=(ImageView) findViewById(R.id.ivFondo1);
        ivPieza1=(ImageView) findViewById(R.id.ivPieza1);
        ivFondo2=(ImageView) findViewById(R.id.ivFondo2);
        ivPieza2=(ImageView) findViewById(R.id.ivPieza2);
        ivFondo3=(ImageView) findViewById(R.id.ivFondo3);
        ivPieza3=(ImageView) findViewById(R.id.ivPieza3);
        ivFondo4=(ImageView) findViewById(R.id.ivFondo4);
        ivPieza4=(ImageView) findViewById(R.id.ivPieza4);
        ivFondo5=(ImageView) findViewById(R.id.ivFondo5);
        ivPieza5=(ImageView) findViewById(R.id.ivPieza5);
        ivFondo6=(ImageView) findViewById(R.id.ivFondo6);
        ivPieza6=(ImageView) findViewById(R.id.ivPieza6);
        ivFondo7=(ImageView) findViewById(R.id.ivFondo7);
        ivPieza7=(ImageView) findViewById(R.id.ivPieza7);
        ivFondo8=(ImageView) findViewById(R.id.ivFondo8);
        ivPieza8=(ImageView) findViewById(R.id.ivPieza8);
        ivFondo9=(ImageView) findViewById(R.id.ivFondo9);
        ivPieza9=(ImageView) findViewById(R.id.ivPieza9);

        arrayListFondos.add(ivFondo1);
        arrayListPiezas.add(ivPieza1);
        arrayListFondos.add(ivFondo2);
        arrayListPiezas.add(ivPieza2);
        arrayListFondos.add(ivFondo3);
        arrayListPiezas.add(ivPieza3);
        arrayListFondos.add(ivFondo4);
        arrayListPiezas.add(ivPieza4);
        arrayListFondos.add(ivFondo5);
        arrayListPiezas.add(ivPieza5);
        arrayListFondos.add(ivFondo6);
        arrayListPiezas.add(ivPieza6);
        arrayListFondos.add(ivFondo7);
        arrayListPiezas.add(ivPieza7);
        arrayListFondos.add(ivFondo8);
        arrayListPiezas.add(ivPieza8);
        arrayListFondos.add(ivFondo9);
        arrayListPiezas.add(ivPieza9);


        //Pongo un listener al radiogroup para que cuando se seleccione la opcion correcta salte un toast con
        // un tick de correcto
        rgPregunta.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //Solo compruebo el caso dos que es el correcto, con los otros dos no hago nada
                if(rbRespuesta2.isChecked()){
                    //Cargamos el layout del tick
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
                    //Acabamos el activity
                    finish();
                }
            }
        });

        //Ponemos un listener al boton siguiente para que oculte el enunciado y muestre las piezas
        //y los fondos de éstas
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clEnunciadoPista5.setVisibility(View.GONE);
                clPuzzlePista5.setVisibility(View.VISIBLE);
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
                                clSolucion.setVisibility(View.GONE);
                                clPiezas.setVisibility(View.GONE);
                                clFondo.setVisibility(View.VISIBLE);
                                clPregunta.setVisibility(View.VISIBLE);
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
}
