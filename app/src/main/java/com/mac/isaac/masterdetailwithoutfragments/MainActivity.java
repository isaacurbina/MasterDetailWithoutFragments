package com.mac.isaac.masterdetailwithoutfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btnx;
    FrameLayout container;
    LayoutInflater inflater;
    private ProgressBar bar;
    String message = "Threat just woke up";
    int milis = 3*1000;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.put
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        container = (FrameLayout) findViewById(R.id.container_b);
        bar = (ProgressBar) findViewById(R.id.progressBar1);
        inflater = LayoutInflater.from(this);
    }

    public void goToThree(View view) {
        View inflatedLayout= inflater.inflate(R.layout.fragment_three, null, false);
        container.removeAllViews();
        container.addView(inflatedLayout);
        startProgress(view);
    }

    public void goToTwo(View view) {
        View inflatedLayout= inflater.inflate(R.layout.fragment_two, null, false);
        container.removeAllViews();
        container.addView(inflatedLayout);
        startProgress(view);
    }

    public void goToOne(View view) {
        View inflatedLayout= inflater.inflate(R.layout.fragment_one, null, false);
        container.removeAllViews();
        container.addView(inflatedLayout);
        startProgress(view);
    }


    public void startProgress(View view) {
        bar.setProgress(0);
        bar.setMax(100);
        btnx = (Button) view;
        new Thread(new Task()).start();
    }

    class Task implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <= 100; i+=1) {
                final int value = i;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bar.setProgress(value);
            }
            try {
                Thread.sleep(milis);
            } catch (InterruptedException e) {}
            //Toast.makeText(MainActivity.this, "Thread finished its work", Toast.LENGTH_SHORT).show();
        }

    }
}
