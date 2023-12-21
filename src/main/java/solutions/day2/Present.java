package solutions.day2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Present {
    private Integer l, w, h;

    public Present(List<Integer> list) {
        this.l = list.get(0);
        this.w = list.get(1);
        this.h = list.get(2);
    }
    public Integer getTotalArea() {
        Integer area1 = 2 * l * w;
        Integer area2 = 2 * w * h;
        Integer area3 = 2 * h * l;
        Integer slack = Math.min(Math.min(area1, area2), area3) / 2;
        return area1 + area2 + area3 + slack;
    }

    public Integer getTotalLength(){
        List<Integer> list = Arrays.asList(l, w, h);
        list.sort(Comparator.naturalOrder());
        Integer length = (2 * list.get(0)) + (2 * list.get(1));
        Integer bow = l * w * h;
        return length + bow;
    }
}
