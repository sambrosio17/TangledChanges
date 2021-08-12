package Executor;

import Data.Commit;
import Data.Partition;
import Data.PartitionItem;

import java.util.ArrayList;
import java.util.List;

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
}
