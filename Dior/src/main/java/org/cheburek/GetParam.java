package org.cheburek;

public class GetParam {

    private  int afterColisionanswer;
    private int sideA;
 private int sideB;
 private int sideC;

 public GetParam(int sideA, int sideB, int sideC) {
     this.sideA=sideA;
     this.sideB=sideB;
     this.sideC=sideC;
 }
    public GetParam(int sideA, int sideB, int sideC,int afterColisionanswer) {
        this.sideA=sideA;
        this.sideB=sideB;
        this.sideC=sideC;
        this.afterColisionanswer = afterColisionanswer;
    }

}
