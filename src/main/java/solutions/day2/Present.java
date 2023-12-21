package solutions.day2;

import java.util.List;

public class Present {
    private Integer l, w, h, area1, area2, area3, slack;

    public Present(List<Integer> list) {
        this.l = list.get(0);
        this.w = list.get(1);
        this.h = list.get(2);
        this.area1 = 2 * l * w;
        this.area2 = 2 * w * h;
        this.area3 = 2 * h * l;
        this.slack = Math.min(Math.min(this.area1, this.area2), this.area3) / 2;
    }
    public Integer getTotalArea() {
        return area1 + area2 + area3 + slack;
    }
}
