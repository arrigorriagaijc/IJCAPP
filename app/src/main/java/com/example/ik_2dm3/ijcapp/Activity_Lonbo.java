package com.example.ik_2dm3.ijcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;

public class Activity_Lonbo extends AppCompatActivity  {
    private Button btnDrag1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__lonbo);
      /*  btnDrag1 = findViewById(R.id.btnDrag1);

        btnDrag1.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                if(android.os.Build.VERSION.SDK_INT >= 24) {
                 // boolean b = btnDrag1.startDragAndDrop();
                }
                return false;
            }
        });

*/



    }
}
