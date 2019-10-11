package com.ads13.bdabstract;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;

public class Usuario {
    private String nome;
    private String teste;

    public Usuario(){

    }

    public Usuario(JSONObject json){
        Field[] fields = this.getClass().getDeclaredFields();
        for (int j = 0; j < fields.length; j++) {
            fields[j].setAccessible(true);
            try {
                fields[j].set(this, json.get(fields[j].getName()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
