package com.testmodule.dailypractice;

public class TestJC {
    public static void main(String[] args) {
//        S s = new S("sss");
//        System.out.println(s.p);
//        int[][] i = new int[10][5];
//        System.out.println(i.length);
//        System.out.println(i[0].length);

        S s = new S("--");
        System.out.println(S.pTag);
        System.out.println(S.pFinalTag);
        System.out.println(P.pTag);
        s.tt("sssss");
        S.tts();


    }
}

class P{
    protected String p;

    public static String pTag = "00000";
    public static final String pFinalTag = "00000";

    public P(String p) {
        this.p = p;
    }

    public P(){}

    public final void tt(String t){
        System.out.println("tttttttt");
    }
    public static void tts(){
        System.out.println("ppppppppppp");
    }
    public void putongtts(){
        System.out.println("ppppppppppp");
    }
}

class S extends P{
    private String s;

    public S(String s) {
        this.s = s;
        pTag = "11111";
    }

    public static void tpts(){
        System.out.println("sssssssssss");
    }

}
