package agent;/*
    user ji
    data 2019/2/24
    time 5:36 PM
*/

import java.lang.instrument.Instrumentation;

public class MyAgent {
    public static void premain(String agentOps, Instrumentation inst) {
        System.out.println("=========premain方法执行========");
        System.out.println(agentOps);
    }

    /**
     * 如果不存在 premain(String agentOps, Instrumentation inst)
     * 则会执行 premain(String agentOps)
     */
    public static void premain(String agentOps) {
        System.out.println("=========premain方法执行2========");
        System.out.println(agentOps);
    }
    public static void main(String[] args) {

    }
}
