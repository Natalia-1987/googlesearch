package common.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HotlineItem implements Comparable<HotlineItem>{

    private String title;
    private Integer price;

    @Override
    public int compareTo(HotlineItem other){
        return price - other.getPrice();
    }
}
