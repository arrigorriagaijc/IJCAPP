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

    private RadioGroup rgPregunta;
    private RadioButton rbRespuesta1;
    private RadioButton rbRespuesta2;
    private RadioButton rbRespuesta3;
    private ImageView ivFondo;
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
    private static final String IMAGEVIEW_TAG1 = "im1";
    private static final String IMAGEVIEW_TAG2 = "im2";
    private static final String IMAGEVIEW_TAG3 = "im3";
    private static final String IMAGEVIEW_TAG4 = "im4";
    private static final String IMAGEVIEW_TAG5 = "im5";
    private static final String IMAGEVIEW_TAG6 = "im6";
    private static final String IMAGEVIEW_TAG7 = "im7";
    private static final String IMAGEVIEW_TAG8 = "im8";
    private static final String IMAGEVIEW_TAG9 = "im9";
    private static final String TAG = "TAG";
    private boolean acertado1=false;
    private boolean acertado2=false;
    private boolean acertado3=false;
    private boolean acertado4=false;
    private boolean acertado5=false;
    private boolean acertado6=false;
    private boolean acertado7=false;
    private boolean acertado8=false;
    private boolean acertado9=false;
    private boolean solucionado=false;
    private ArrayList<ImageView> arrayListPiezas;
    private ArrayList<ImageView> arrayListFondos;
    private ArrayList<String> arrayListEtiquetas;
    private ArrayList<Integer> arrayListDrawablesPiezas;
    private ArrayList<Integer> arrayListDrawablesFondos;
    private ArrayList<Boolean> arrayListAcertado;
    private View vista;
    private ConstraintLayout clSolucion;
    private ConstraintLayout clPiezas;
    private ConstraintLayout clEnunciadoPista5;
    private ConstraintLayout clPregunta;
    private ConstraintLayout clPuzzlePista5;
    private Toast toast;
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pista5);

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

        ivFondo=(ImageView) findViewById(R.id.imageView16);
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

        rgPregunta.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rbRespuesta2.isChecked()){
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
                    finish();
                }
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clEnunciadoPista5.setVisibility(View.GONE);
                clPuzzlePista5.setVisibility(View.VISIBLE);
            }
        });

        //Usando el onTouch tenemos el problema de que con dos toques muy seguidos el startdrag hace colapsar
        //el ondraglistener y no reaparece la imagen. Pasa a veces. Queda de comprobar en el móvil.
        for(int i=0;i<arrayListPiezas.size();i++){
            arrayListPiezas.get(i).setTag(arrayListEtiquetas.get(i));
            arrayListPiezas.get(i).setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View vOT, MotionEvent motionEvent) {
                    vista = vOT;
                    switch(motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            // Create a new ClipData.
                            // This is done in two steps to provide clarity. The convenience method
                            // ClipData.newPlainText() can create a plain text ClipData in one step.
                            // Create a new ClipData.Item from the ImageView object's tag
                            ClipData.Item item = new ClipData.Item((String) vOT.getTag());
                            // Create a new ClipData using the tag as a label, the plain text MIME type, and
                            // the already-created item. This will create a new ClipDescription object within the
                            // ClipData, and set its MIME type entry to "text/plain"
                            ClipData dragData = new ClipData((CharSequence) vOT.getTag(), new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN}, item);
                            Log.d(TAG, (String) vOT.getTag());
                            // Instantiates the drag shadow builder.
                            View.DragShadowBuilder myShadow = new View.DragShadowBuilder(vOT);
                            vOT.setVisibility(View.INVISIBLE);
                            Log.d(TAG, "Ocultado");
                            // Starts the drag
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                vOT.startDragAndDrop(dragData,  // the data to be dragged
                                        myShadow,  // the drag shadow builder
                                        null,      // no need to use local data
                                        0          // flags (not currently used, set to 0)
                                );
                            } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N){
                                vOT.startDrag(dragData,  // the data to be dragged
                                        myShadow,  // the drag shadow builder
                                        null,      // no need to use local data
                                        0          // flags (not currently used, set to 0)
                                );
                            }
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });
        }

        for(int j=0;j<arrayListFondos.size();j++){
            final int finalJ = j;
            arrayListFondos.get(finalJ).setOnDragListener(new View.OnDragListener() {
                @Override
                public boolean onDrag(View vOD, DragEvent dragEvent) {
                    switch(dragEvent.getAction()){
                        case DragEvent.ACTION_DRAG_ENTERED:
                            if(vista.getTag().equals(arrayListEtiquetas.get(finalJ))){
                                ((ImageView)vOD).setImageResource(arrayListDrawablesPiezas.get(finalJ));
                                arrayListAcertado.set(finalJ,true);
                            }
                            break;
                        case DragEvent.ACTION_DRAG_EXITED:
                            if(vista.getTag().equals(arrayListEtiquetas.get(finalJ))) {
                                Log.d(TAG,"deberia poner el fondo");
                                ((ImageView)vOD).setImageResource(arrayListDrawablesFondos.get(finalJ));
                                arrayListAcertado.set(finalJ,false);
                            }
                            break;
                        case DragEvent.ACTION_DRAG_ENDED:
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
                            if(acabado()==true){
                                for(int i=0; i<arrayListFondos.size();i++){
                                    arrayListFondos.get(i).setVisibility(View.GONE);
                                }
                                ivFondo.setVisibility(View.VISIBLE);
                                clPiezas.setVisibility(View.GONE);
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
