package Executor;

import Data.Commit;
import Data.CommitChange;
import Data.Couple;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class DataParser {

    String filePath;

    public DataParser(String filePath){
        this.filePath=filePath;

    }

    public ArrayList<Commit> doParse() throws FileNotFoundException {
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


    public LinkedList<Couple> builMatrix() throws IOException {
        File file=new File(this.filePath);
        Scanner scn=new Scanner(file);

        LinkedList<String> artifacts=new LinkedList<>();

        while(scn.hasNext()){

            String fullLine= scn.nextLine();
            String path= fullLine
                        .split(",")[3].contains(".java") ? fullLine.split(",")[3] : null;

            if(path==null) continue;

            if(!artifacts.contains(path)) artifacts.add(path);
        }



        PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");

        LinkedList<Couple> coupleList=new LinkedList<>();
        ConfVoters conf=new ConfVoters();
        for(int i=0; i<artifacts.size(); i++){
            for(int j=0; j<artifacts.size(); j++){
                Couple c=new Couple();
                c.setPathA(artifacts.get(i));
                c.setPathB(artifacts.get(j));
                c.setCounter(conf.totChange(doParse(),artifacts.get(i),artifacts.get(j)));
                coupleList.add(c);

                writer.println(c.toString());


            }
        }
        writer.close();
        return coupleList;

    }



    public boolean isPresentId(ArrayList<Commit> list, String id){
        for(Commit c:list){
            if((c.getId()).equals(id)) return true;
        }
        return false;
    }
}
