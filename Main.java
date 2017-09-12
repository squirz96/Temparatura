package testas.pratimas4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class Main {

    /*
    Temparaturos prognoze savaitei pagal pasirinkta metu laika, kur:
     1 : Ziema,
     2: Pavasaris,
     3: Vasara
     4: Ruduo
     */

    public static void main(String[] args) {
        String[] savaites_sarasas = {"Pirmadienis", "Antradienis", "Treciadienis", "Ketvirtadienis", "Penktadienis", "Sestadienis", "Sekmadienis"};
        int metu_laikas;
        Scanner reader = new Scanner(System.in);
        System.out.print("Metu laiko skaicius: ");
        metu_laikas = reader.nextInt();

        Temparaturos temp = new Temparaturos(0, savaites_sarasas[0]);
        temp.setMetu_laikas(metu_laikas);
        temp.galima_minimali_temparatura(metu_laikas);
        temp.sugeneruoti_Temparaturas();


    }
}

class Temparaturos {
    private float Temparatura;
    private int metu_laikas;
    private String Savaites_Diena;

    @Override
    public String toString() {
        return "Temparaturos{" +
                "Temparatura = " + Temparatura +
                " , Savaites_Diena = '" + Savaites_Diena + '\'' +
                '}' + System.lineSeparator();
    }


    public Temparaturos(float Temparatura, String Savaites_Diena) {
        this.Temparatura = Temparatura;
        this.Savaites_Diena = Savaites_Diena;
    }


    public float getTemparatura() {
        return Temparatura;
    }

    public void setTemparatura(float temparatura) {
        Temparatura = temparatura;
    }

    public String getSavaites_Diena() {
        return Savaites_Diena;
    }

    public int getMetu_laikas() {
        return metu_laikas;
    }

    public void setMetu_laikas(int metu_laikas) {
        this.metu_laikas = metu_laikas;
    }

    public int galima_minimali_temparatura(int metu_laikas) {
        if (metu_laikas == 1) {
            int min = -30;
            int max = -10;
            int rand_min_temp = ThreadLocalRandom.current().nextInt(min, max + 1);
            return rand_min_temp;
        } else if (metu_laikas == 2) {
            int min = -5;
            int max = 20;
            int rand_min_temp = ThreadLocalRandom.current().nextInt(min, max + 1);
            return rand_min_temp;
        } else if (metu_laikas == 3) {
            int min = 15;
            int max = 35;

            int rand_min_temp = ThreadLocalRandom.current().nextInt(min, max + 1);
            return rand_min_temp;
        } else {
            int min = -5;
            int max = 15;
            int rand_min_temp = ThreadLocalRandom.current().nextInt(min, max + 1);
            return rand_min_temp;
        }


    }


    public void sugeneruoti_Temparaturas() {


        int minimali_temparatura = galima_minimali_temparatura(getMetu_laikas());
        int maksimali_temparatura = minimali_temparatura + 7;
        int progruozojamu_dienu_skaicius = 7;
        int temparatura[] = new int[progruozojamu_dienu_skaicius];

        for (int i = 0; i < progruozojamu_dienu_skaicius; i++) {
            temparatura[i] = ThreadLocalRandom.current().nextInt(minimali_temparatura, maksimali_temparatura + 1);

        }
        String[] savaites_sarasas = {"Pirmadienis", "Antradienis", "Treciadienis", "Ketvirtadienis", "Penktadienis", "Sestadienis", "Sekmadienis"};
        String[] savaites_dienos = new String[progruozojamu_dienu_skaicius];
        for (int i = 0; i < savaites_dienos.length; i++) {
            savaites_dienos[i] = savaites_sarasas[i];
        }
        Temparaturos[] temparaturos = new Temparaturos[savaites_dienos.length];

        for (int i = 0; i < temparaturos.length; i++) {
            temparaturos[i] = new Temparaturos(temparatura[i], savaites_dienos[i]);

        }


        System.out.println(Arrays.toString(temparaturos));
    }

}
