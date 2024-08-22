package com.aula.ciclovidaactivity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val TAG = "Ciclo de vida Activity "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        //Basta abrir o aplicativo. O onCreate() será chamado automaticamente quando a Activity for criada.
        Log.d(TAG, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        // Depois que a Activity é criada, o onStart() é chamado automaticamente. Simplesmente abrir o aplicativo ou voltar a ele após minimizá-lo dispara o onStart().
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
        //Esse método é chamado automaticamente após onStart(). Ele também será chamado novamente se o aplicativo for retomado após ter sido pausado (por exemplo, após retornar de outra Activity ou de um diálogo).

    }

    override fun onPause() {
        super.onPause()
        //É chamado quando a Activity está parcialmente oculta e não está mais no primeiro plano, por exemplo pressione home
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        //Minimize o aplicativo (pressione o botão "Home") ou abra outra aplicação, o que coloca a Activity atual completamente em segundo plano.
        Log.d(TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        //Volte para a Activity depois que ela foi parada (por exemplo, depois de minimizar o aplicativo e, em seguida, abri-lo novamente).
        Log.d(TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        //Feche a Activity completamente. Isso pode ser feito pressionando o botão "Back" para sair do aplicativo ou chamando finish() dentro da Activity.
        Log.d(TAG, "onDestroy")
    }
}