package Tester;

import Data.Commit;
import Executor.DataParser;
import Executor.Untangler;

import java.io.IOException;
import java.util.ArrayList;

public class Tester {

    public static void main(String[] args) throws IOException {

        DataParser parser = new DataParser("D:\\UNISA\\Tirocinio\\progettini\\testAlgo.csv");

        ArrayList<Commit> list=parser.doParse();

        Untangler u=new Untangler(list.get(0),3);

        System.out.println(u.buildPartitionMatrix());
        System.out.println(u.findMax());

        /*ArrayList<Commit> c= parser.doParse();
        for(Commit commit : c) System.out.println(commit.toString());

            ConfVoters cf=new ConfVoters();


        System.out.println("stampo il packageDistance del commit "+c.get(0).getId()+" tra il change 0 e il change 9");
        cf.packageDistanceCalculator(c.get(0).getChanges().get(0).getPath(),c.get(0).getChanges().get(9).getPath());

        System.out.println("stampo 1 se VisualizzaCodicePrenotato e Registrazione sono entrmabe nel commit 19, 0 altrimenti");
        int valcc=0;
        valcc=cf.changeCoupling(c.get(19),"RistoManager/src/it/RistoManager/Control/Utente/VisualizzaCodicePrenotato.java","RistoManager/src/it/RistoManager/Control/Utente/Registrazione.java");
        System.out.println(c.get(19).getId()+" valore: "+valcc);

            int tot=0;
        System.out.println("stampo numero di volte che VisualizzaCodicePrenotato e Registrazione sono nello stesso commit nella storia ");
        for(Commit commit : c){
            tot=tot+(cf.changeCoupling(commit,"RistoManager/src/it/RistoManager/Control/Utente/VisualizzaCodicePrenotato.java","RistoManager/src/it/RistoManager/Control/Utente/Registrazione.java"));
      }
        System.out.println(tot);


    }*/

    }
}
