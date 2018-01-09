package com.example.ik_2dm3.ijcapp;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Pista5 extends AppCompatActivity {

    private ImageView ivFondo1;
    private ImageView ivPieza1;
    private ImageView ivFondo2;
    private ImageView ivPieza2;
    private ImageView ivFondo3;
    private ImageView ivPieza3;
    private static final String IMAGEVIEW_TAG1 = "im1";
    private static final String IMAGEVIEW_TAG2 = "im2";
    private static final String IMAGEVIEW_TAG3 = "im3";
    private static final String TAG = "TAG";
    private boolean acertado1=false;
    private boolean acertado2=false;
    private boolean acertado3=false;
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
    private ConstraintLayout clPreguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pista5);

        arrayListPiezas=new ArrayList<>();
        arrayListFondos=new ArrayList<>();
        arrayListEtiquetas=new ArrayList<>();
        arrayListDrawablesPiezas=new ArrayList<>();
        arrayListDrawablesFondos=new ArrayList<>();
        arrayListAcertado=new ArrayList<>();

        clSolucion=(ConstraintLayout) findViewById(R.id.clSolucion);
        clPiezas=(ConstraintLayout) findViewById(R.id.clPiezas);
        clPreguntas=(ConstraintLayout) findViewById(R.id.clPreguntas);

        arrayListDrawablesPiezas.add(R.drawable.p1);
        arrayListDrawablesPiezas.add(R.drawable.p2);
        arrayListDrawablesPiezas.add(R.drawable.p3);

        arrayListDrawablesFondos.add(R.drawable.p1fondo);
        arrayListDrawablesFondos.add(R.drawable.p2fondo);
        arrayListDrawablesFondos.add(R.drawable.p3fondo);

        arrayListAcertado.add(acertado1);
        arrayListAcertado.add(acertado2);
        arrayListAcertado.add(acertado3);

        arrayListEtiquetas.add(IMAGEVIEW_TAG1);
        arrayListEtiquetas.add(IMAGEVIEW_TAG2);
        arrayListEtiquetas.add(IMAGEVIEW_TAG3);
        ivFondo1=(ImageView) findViewById(R.id.ivFondo1);
        ivPieza1=(ImageView) findViewById(R.id.ivPieza1);
        ivFondo2=(ImageView) findViewById(R.id.ivFondo2);
        ivPieza2=(ImageView) findViewById(R.id.ivPieza2);
        ivFondo3=(ImageView) findViewById(R.id.ivFondo3);
        ivPieza3=(ImageView) findViewById(R.id.ivPieza3);
        arrayListFondos.add(ivFondo1);
        arrayListPiezas.add(ivPieza1);
        arrayListFondos.add(ivFondo2);
        arrayListPiezas.add(ivPieza2);
        arrayListFondos.add(ivFondo3);
        arrayListPiezas.add(ivPieza3);

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
                                clPiezas.setVisibility(View.GONE);
                                clPreguntas.setVisibility(View.VISIBLE);
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
