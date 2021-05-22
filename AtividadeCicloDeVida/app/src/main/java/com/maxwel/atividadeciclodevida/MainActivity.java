package com.maxwel.atividadeciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView create, start, restart, resume, pause, stop;
    private int createCounter = 0, startCounter = 0, restartCounter = 0,
            resumeCounter=0, pauseCounter=0, stopCounter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createCounter += 1;

        create = findViewById(R.id.onCreateCounter);
        create.setText(Integer.toString(createCounter));
    }

    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de vida", "Método on Start() chamado.");

        startCounter += 1;

        start = findViewById(R.id.onStartCounter);
        start.setText(Integer.toString(startCounter));
    }

    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de vida", "Método on Restart() chamado.");

        restartCounter += 1;

        restart = findViewById(R.id.onRestartCounter);
        restart.setText(Integer.toString(restartCounter));
    }
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de vida", "Método on Resume() chamado.");

        resumeCounter += 1;

        resume = findViewById(R.id.onResumeCounter);
        resume.setText(Integer.toString(resumeCounter));
    }
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de vida", "Método on Pause() chamado.");

        pauseCounter += 1;

        pause = findViewById(R.id.onPauseCounter);
        pause.setText(Integer.toString(pauseCounter));
    }
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de vida", "Método on Stop() chamado.");

        stopCounter += 1;

        stop = findViewById(R.id.onStopCounter);
        stop.setText(Integer.toString(stopCounter));
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de vida", "Método on Destroy() chamado.");
    }
}