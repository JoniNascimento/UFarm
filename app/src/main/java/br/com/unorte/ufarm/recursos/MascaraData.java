package br.com.unorte.ufarm.recursos;

import android.text.Selection;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Joni on 08/02/16.
 */
public class MascaraData implements View.OnKeyListener {

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            Log.i("DATE", "keyCode:" + keyCode);
            EditText ed = (EditText) v;
            if (event.getAction() == KeyEvent.ACTION_UP
                    && keyCode != KeyEvent.KEYCODE_DEL) {
                int length = ed.getText().toString().length();
                switch (length) {
                    case 2: {
                        ed.setTextKeepState(ed.getText() + "/");
                        break;
                    }
                    case 5: {
                        ed.setTextKeepState(ed.getText() + "/");
                        break;
                    }
                    case 10:{
                        ed.setTextKeepState(ed.getText() + " ");
                        break;
                    }
                    default:
                        break;
                }
            }
            //Posiciona o cursor no fim
            Selection.setSelection(ed.getText(), ed.getText().toString()
                    .length());
            return false;
        }


}
