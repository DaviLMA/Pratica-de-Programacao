/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendacontato;

import java.io.Serializable;

/**
 *
 * @author Davi Araújo
 */
public class Contato implements Serializable{
    String nome;
    String fone;
    Address end;

    public Contato(String nome, String fone) {
        this.nome = nome;
        this.fone = fone;
    }

    public Contato(String nome, String fone, Address end) {
        this.nome = nome;
        this.fone = fone;
        this.end = end;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    @Override
    public String toString() {
        return "Contato{" + "nome=" + nome + ", fone=" + fone + ", end=" + end + '}';
    }
    
    
}
