package interpreter.bytecode;

public abstract class BranchInterface implements ByteCode {
     private String branchName;
     private Integer pcAddress;


     public String getBranchName() {
          return branchName;
     }

     public void setPCAddress(int location){
          this.pcAddress = location;
     }

     public void setBranchName(String branchName) {
          this.branchName = branchName;
     }

     public int getPCAddress() {
          return pcAddress;
     }



}
