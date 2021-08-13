package Data;

import com.sun.xml.internal.ws.wsdl.writer.document.Part;

import java.util.ArrayList;
import java.util.List;

public class Partition {

    int id;
    List<PartitionItem> list;
    boolean isActive;

    public Partition() {
        id=-1;
        list=new ArrayList<>();
        isActive=true;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
        deactiveItem();
    }

    void deactiveItem(){
        for(PartitionItem p : list)
            p.setActive(isActive);
    }

    public void deactiveIndex(int j){
        for(PartitionItem p: list){
            if(p.getJ()==j) p.setActive(false);
        }
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

    public PartitionItem findOne(int i, int j){

        for(PartitionItem pI : list){
            if(pI.getJ()==i && pI.getJ()==j) return pI;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Partition{" +
                "id=" + id +
                ", list=" + list +
                ", isActive=" + isActive +
                '}'+'\n';
    }
}
