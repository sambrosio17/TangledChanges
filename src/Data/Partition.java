package Data;

import java.util.ArrayList;
import java.util.List;

public class Partition {

    int id;
    List<PartitionItem> list;

    public Partition() {
        id=-1;
        list=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<PartitionItem> getList() {
        return list;
    }

    public void setList(List<PartitionItem> list) {
        this.list = list;
    }

    public PartitionItem findMax(){

        if(list.isEmpty()) return null;
        PartitionItem max= list.get(0);

        for(int i=0; i<list.size();i++){
            for(int j=1; j<list.size()-1; j++){
                if(list.get(j).getConfidenceValue() > max.getConfidenceValue()){
                    max= list.get(j);
                }
            }

        }

        return max;
    }

    @Override
    public String toString() {
        return "Partition{" +
                "id=" + id +
                ", list=" + list +
                "}\n";
    }
}
