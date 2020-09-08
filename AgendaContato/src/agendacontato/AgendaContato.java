/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendacontato;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Davi Araújo
 */
public class AgendaContato {

    static File arq = new File("agenda.obj");
    static ArrayList<Contato> contatos = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (!arq.exists()) {
            try {
                arq.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                FileInputStream fin = new FileInputStream(arq);
                ObjectInputStream ois = new ObjectInputStream(fin);
                contatos = (ArrayList) ois.readObject();
                ois.close();
                fin.close();
            } catch (IOException ex) {
                Logger.getLogger(AgendaContato.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AgendaContato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        int op;

        do {
            System.out.println("0 - Encerrar");
            System.out.println("1 - Criar Contato");
            System.out.println("2 - Lista Agenda");
            System.out.println("3 - Buscar Contato");
            System.out.println("4 - Alterar Contato");
            System.out.print("Digite opcao: ");
            op = in.nextInt();
            switch (op) {
                case 0:
                    salvarAgenda();
                    break;
                case 1:
                    criarContato();
                    break;
                case 2:
                    listarAgenda();
                    break;
                case 3:
                    System.out.println("Digite o nome do contato: ");
                    String nome = in.next();
                    System.out.println("Digite o nome do país: ");
                    String pais = in.next();
                    Contato busca = buscarContato(nome, pais);
                    if (busca != null) {
                        System.out.println("O contato existe!");
                    } else {
                        System.out.println("Não existe");
                    }
                    break;
                case 4:

                    break;
                default:
                    System.out.println("Opcao invalida!!");
            }

        } while (op != 0);
    }

    //rua, número, complemento, bairro, cidade, estado, país, cep
    static void criarContato() {
        System.out.print("Digite nome: ");
        String nome = in.next();
        System.out.print("Telefone: ");
        String fone = in.next();
        Address end = new Address();
        System.out.println("Digite rua: ");
        end.setStreet(in.next());
        System.out.println("Digite o número: ");
        end.setNumber(in.nextInt());
        System.out.println("Digite o complemento: ");
        end.setComplement(in.next());
        System.out.println("Digite o bairro: ");
        end.setNeighborhood(in.next());
        System.out.println("Digite a cidade: ");
        end.setCity(in.next());
        System.out.println("Digite o estado: ");
        end.setState(in.next());
        System.out.println("Digite Pais: ");
        end.setCountry(in.next());
        System.out.println("Digite o CEP: ");
        end.setCep(in.next());
        Contato user = new Contato(nome, fone, end);
        contatos.add(user);
    }

    static void salvarAgenda() {
        try {
            FileOutputStream fout = new FileOutputStream(arq);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(contatos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AgendaContato.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AgendaContato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void listarAgenda() {
        for (int i = 0; i < contatos.size(); i++) {
            System.out.println(contatos.get(i).toString());
        }
    }

    static Contato buscarContato(String nome, String pais) {
        for (Contato contato : contatos) {
            if (contato.getNome().compareTo(nome) == 0 && contato.end.getCountry().compareTo(pais) == 0) {
                return contato;
            }
        }
        return null;
    }

    static void alterarContato() {
           /*Não consegui por a ideia em prática, mas a ideia era usar o buscarContato(), dizer se existe ou não e se existe dar opções para o usuário como se fosse um
            novo menu, perguntando o que ele quer mudar, por exemplo case 1: seria de mudar o nome, aí daria um setNome(), etc. Porém buguei e não consegui implementar.
           */
    }
}
