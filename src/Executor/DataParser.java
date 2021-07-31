package Executor;

import Data.Commit;
import Data.CommitChange;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataParser {

    public DataParser(){

    }

    public ArrayList<Commit> doParse(String filePath) throws FileNotFoundException {
        ArrayList<Commit> lista = new ArrayList<Commit>();
        File file= new File(filePath);
        Scanner fileScanner= new Scanner(file);

        int i=-1;


        while(fileScanner.hasNext()){
            String singleLine= fileScanner.nextLine();
            String[] strings=singleLine.split(",");

            if(!(isPresentId(lista, strings[0]))) {
                if(strings[3].contains(".java")){
                Commit currentCommit= new Commit();
                currentCommit.setId(strings[0]);
                currentCommit.setAuthor(strings[1]);
                CommitChange currentChange = new CommitChange(strings[3], strings[4]);
                currentCommit.getChanges().add(currentChange);
                lista.add(currentCommit);
                i++;
                }

            }else if(isPresentId(lista, strings[0])) {
                if(strings[3].contains(".java")) {
                    CommitChange currentChange = new CommitChange(strings[3], strings[4]);
                    lista.get(i).getChanges().add(currentChange);
                }

            }
        }
        return lista;
    }

    public boolean isPresentId(ArrayList<Commit> list, String id){
        for(Commit c:list){
            if((c.getId()).equals(id)) return true;
        }
        return false;
    }
}
