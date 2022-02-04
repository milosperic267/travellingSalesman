package ch.bbw.travllingSalesman;

import lombok.Data;

@Data
public class Output {
    private Outcome fastest;
    private Outcome faster;
    private Outcome fast;

    public Output(Outcome fastest, Outcome faster, Outcome fast) {
        this.fastest = fastest;
        this.faster = faster;
        this.fast = fast;
    }

}
