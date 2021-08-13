package Executor;

import Data.Commit;
import Data.Partition;
import Data.PartitionItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Untangler {

    Commit c;
    ConfVoters confVoters;
    List<Partition> pList;
    int stopCondition;

    public Untangler(Commit c, int stopCondition){
        this.c=c;
        confVoters= new ConfVoters();
        this.stopCondition=stopCondition;
        pList=new ArrayList<>();
    }

    public List<Partition> buildPartitionMatrix(){

        for(int i=0; i<c.getChanges().size(); i++){
            Partition p=new Partition();
            p.setId(i);
            for(int j=0; j<c.getChanges().size(); j++){
                if(i>=j) continue;
                PartitionItem item=new PartitionItem();
                item.setI(i);
                item.setJ(j);
                item.setPathA(c.getChanges().get(i).getPath());
                item.setPathB(c.getChanges().get(j).getPath());
                item.setConfidenceValue(confVoters.packageDistanceCalculator(c.getChanges().get(i).getPath(), c.getChanges().get(j).getPath()));
                p.getList().add(item);

            }
            pList.add(p);
        }


        return pList;
    }

    public PartitionItem findMax(){

        PartitionItem max=pList.get(0).findMax();

        for(int i=0; i<pList.size(); i++){
            if(max==null || pList.get(i).findMax()==null) continue;
            if(pList.get(i).findMax().getConfidenceValue() > max.getConfidenceValue()){
                max=pList.get(i).findMax();
            }
        }

        return max;
    }

    public int compositeConfVoter(Partition a, Partition b){

        PriorityQueue<Integer> list= new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<a.getList().size(); i++){
            for(int j=0; j<b.getList().size(); j++){
                if(pList.get(i).findOne(i,j) == null) continue;
                list.add(pList.get(i).findOne(i,j).getConfidenceValue());
            }
        }
        return list.poll();
    }

    public List<Partition> theUntanglingAlgorithm(){

        buildPartitionMatrix();
        List<Partition> resultPartition=new ArrayList<>();
        for(int i=0; i<stopCondition; i++){
            //troviamo il massimo tra tutte le celle della matrice
            PartitionItem max=findMax();
            int indexI=max.getI();
            int indexJ=max.getJ();
            //disattiviamo le righe corrispondenti agli indici della cella max
            pList.get(indexI).setActive(false);
            pList.get(indexJ).setActive(false);
            //disattivamo tutte le celle che hanno per indice j gli indici della max
            for(Partition p: pList) {
                p.deactiveIndex(indexI);
                p.deactiveIndex(indexJ);
            }
            //creiamo una nuova partizione pList.size + 1 che unisce le due precendenti
            Partition compositePartition= new Partition();
            compositePartition.setId(pList.size());
            //aggiungiamo alla partizione creata le partizione che la compongono

        }
        return  resultPartition;
    }

}
