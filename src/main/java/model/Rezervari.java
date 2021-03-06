package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Rezervari {

    private String numeClient;
    private String prenumeClient;
    private String marcaMasina;
    private String numeServiciu;
    private SimpleDateFormat form = new SimpleDateFormat("dd/MM/yy HH:mm");


    private Date data;

    public Rezervari(String numeClient, String prenumeClient, String marcaMasina, String numeServiciu, String date) {
        this.numeClient = numeClient;
        this.prenumeClient = prenumeClient;
        this.marcaMasina = marcaMasina;
        this.numeServiciu = numeServiciu;
        data = new Date();
        try {
            data = form.parse(date);
        } catch (Exception e) {
            System.out.println();
        }
    }


    public String getData() {
        String dataStr = form.format(data);
        return dataStr;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNumeClient() {
        return numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    public String getPrenumeClient() {
        return prenumeClient;
    }

    public void setPrenumeClient(String prenumeClient) {
        this.prenumeClient = prenumeClient;
    }

    public String getMarcaMasina() {
        return marcaMasina;
    }

    public void setMarcaMasina(String marcaMasina) {
        this.marcaMasina = marcaMasina;
    }

    public String getNumeServiciu() {
        return numeServiciu;
    }

    public void setNumeServiciu(String numeServiciu) {
        this.numeServiciu = numeServiciu;
    }

    /*Metoda prin care se adauga/sterge un element dintr-un array de tip Rezervari */

    public static Rezervari[] addRezervare(Rezervari[] rezervari, Rezervari rezervare) {
        if (rezervari == null) {
            rezervari = new Rezervari[]{rezervare};
            return rezervari;
        }
        ArrayList<Rezervari> temp = new ArrayList<Rezervari>();
        for (int i = 0; i < rezervari.length; i++) {
            temp.add(rezervari[i]);
        }
        temp.add(rezervare);
        rezervari = temp.toArray(new Rezervari[temp.size()]);
        return rezervari;
    }

    public static Rezervari[] removeRezervare(Rezervari[] rezervari, int index) {
        ArrayList<Rezervari> temp = new ArrayList<Rezervari>();
        for (int i = 0; i < rezervari.length; i++) {
            if (i != index)
                temp.add(rezervari[i]);
        }
        rezervari = temp.toArray(new Rezervari[temp.size()]);
        return rezervari;
    }

    @Override
    public String toString() {
        return "Avem o rezervare pe numele " +
                numeClient + ' ' + prenumeClient + " pentru autoturismul " +
                marcaMasina + ' ' + "pentru " + numeServiciu + ' ' + "in data de: " + data;
    }
}
