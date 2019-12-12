package interpreter.bytecode;

import java.util.ArrayList;

public abstract class LoadStoreInterface implements ByteCode{
    private Integer value;
    private String id;

    public void init(ArrayList<String> args) {
        if(args.size()>=1){
            value = Integer.parseInt(args.get(0));
        }
        if(args.size()>=2){
            value = Integer.parseInt(args.get(0));
            id = args.get(1);
        }
    }

    public String getVar() {
        return this.id;
    }

    public int getValue() {
        if(value == null)
            value =0;
        return this.value;
    }


}
