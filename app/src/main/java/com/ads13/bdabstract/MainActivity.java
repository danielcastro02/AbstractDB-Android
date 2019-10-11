package com.ads13.bdabstract;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AbstractBD pdo = new AbstractBD(this)
        {
            public void success(JSONArray response){
                Usuario us = null;
                try {
                    us = new Usuario((JSONObject) response.get(0));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d("avanco", us.getNome());
            }
            public void responseError(VolleyError error){

                Log.v("avanco", error.getMessage());
            }
        };
        pdo.setApiURL("http://200.132.17.121/remoteDB.php");
        pdo.setRemoteDb("markey");
        pdo.setRemoteAdress("200.132.17.121");
        pdo.setRemoteUser("root");
        pdo.setRemotePass("");
        pdo.prepare("select * from usuarioasd where id_usuario = :id_usuario");
        pdo.bindValue(":id_usuario" , 1658);

        pdo.selectRemote();
//        Log.d("avanco", "passou");
//        try {
//            JSONObject jsonobj = json.getJSONObject(0);
//            Log.d("avanco", jsonobj.getString("nome"));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
    }
}
