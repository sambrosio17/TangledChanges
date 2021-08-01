package Executor;

import Data.Commit;
import Data.CommitChange;

import java.util.ArrayList;
import java.util.List;

public class ConfVoters {

    public ConfVoters(){

    }


    /* public void packageDistanceCalculator(Commit c){

        List<CommitChange> changes=c.getChanges();
        for(int i=0; i<changes.size(); i++){
            for(int j=1; j<changes.size()-1; j++){

                int counter=0;

                String first=c.getChanges().get(i).getPath();
                String second=c.getChanges().get(j).getPath();

                String[] firstPath=first.split("/");
                String[] secondPath=second.split("/");

                int minor= firstPath.length < secondPath.length ? firstPath.length : secondPath.length;

                for(int k=0; k<minor-1; k++) {
                    if (firstPath[k].equals(secondPath[k])) {
                        continue;
                    }
                    if (!firstPath[k].equals(secondPath[k])) {

                        counter++;
                    }
                }

                System.out.println("path1: "+first +"\npath2: "+ second+"\ncounter: "+counter);


            }
        }


    }*/

    public int packageDistanceCalculator(String path1,String path2){

        String[] firstPath=path1.split("/");
        String[] secondPath=path2.split("/");

        int counter=0;

        System.out.println(path1+"\n"+path2);

        int bigger= firstPath.length > secondPath.length ? firstPath.length : secondPath.length;
        int minor= firstPath.length < secondPath.length ? firstPath.length : secondPath.length;

        for(int k=0; k<bigger-1; k++) {

            if(k>=minor){
                break;
            }
            if (firstPath[k].equals(secondPath[k])) {
                continue;
            }
            if (!firstPath[k].equals(secondPath[k])) {

                counter++;
            }
        }
        System.out.println(counter);
        return counter;
    }

    // aggiunta robe di  marco

    public int changeCoupling(Commit commit, String file1, String file2){
        int tot=0;
        for(CommitChange c: commit.getChanges()){
            if(c.getPath().equals(file1)) tot++;
            if(c.getPath().equals(file2)) tot++;
        }
        if(tot==2)
            return 1;
        else return 0;
    }

    public int totChange(ArrayList<Commit> c, String file1, String file2){
        int tot=0;
        for(Commit commit : c){
            tot=tot+(changeCoupling(commit,file1,file2));
        }
        return tot;
    }

}
