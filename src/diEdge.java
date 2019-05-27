import org.jetbrains.annotations.NotNull;

public class diEdge implements Comparable<diEdge>{
    int start,end, weight;

    public diEdge(int start, int end, int weight) {
        this.start=start;
        this.end=end;
        this.weight =weight;
    }

    public int from(){return start;}

    public int to(){return end;}

    public int weight(){return weight;}

    @Override
    public String toString() {
        return start+"->"+end+","+"权值为："+weight;
    }



    @Override
    public int compareTo(@NotNull diEdge o) {
        return this.weight -o.weight;
    }
}
