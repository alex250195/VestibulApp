package com.example.alexalves.vestibulapp.Entidades;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;
import java.util.List;

/**
 * Created by Desenvolvedor on 29/10/2016.
 */

public class Curso implements KvmSerializable {

    private int id;
    private int idInstituicao;
    private String nome;
    private String descricao;

    public Curso(){

    }

    private static List<Curso> cursos;
    private static Curso curso;

    public static List<Curso> getCursos() {
        return cursos;
    }

    public static void setCursos(List<Curso> _cursos) {
        cursos = _cursos;
    }

    public static Curso getCurso() {
        return curso;
    }

    public static void setCurso(Curso curso) {
        curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(int idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public Object getProperty(int i) {

        switch (i) {
            case 0:
                return this.id;

            case 1:
                return this.idInstituicao;

            case 2:
                return this.nome;

            case 3:
                return this.descricao;

            default:
                break;

        }

        return null;
    }

    @Override
    public int getPropertyCount() {
        return 4;
    }

    @Override
    public void setProperty(int i, Object value) {

        switch (i) {
            case 0:
                this.id = Integer.parseInt(value.toString());
                break;
            case 1:
                this.idInstituicao = Integer.parseInt(value.toString());
                break;
            case 2:
                this.nome = value.toString();
                break;
            case 3:
                this.descricao = value.toString();
                break;

        }
    }

    @Override
    public void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo info) {

        switch (i) {
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "id";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "id_instituicao";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "nome";
                break;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "descricao";
                break;

        }
    }
}
