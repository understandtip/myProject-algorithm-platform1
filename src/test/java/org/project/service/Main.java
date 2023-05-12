package org.project.service;

import org.junit.Test;
import org.project.controller.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

public class Main {
    @Test
    public void qwe() {
        String opt = "1";
        String content = "import java.io.*;\n" +
                "import java.util.*;\n" +
                "\n" +
                "public class Main {\n" +
                "    public static void main(String args[]) throws Exception {\n" +
                "        Scanner cin=new Scanner(System.in);\n" +
                "        var a = cin.nextInt();\n" +
                "        var b = cin.nextInt();\n" +
                "        System.out.println(a + b);\n" +
                "    }\n" +
                "}";
        if(opt.equals("0")){
            //String content = "package play; public class Test{ public static void main(String[] args){System.out.println(\"compile test.\");} }";
            Boolean aBoolean = MyCompiler.compile("play.Test", content);
        }else{
            MyClassLoader myClassLoader = new MyClassLoader();
            try {
                Class c = myClassLoader.loadClass("play.Test");
                Method method = c.getMethod("main", String[].class);
                method.invoke(null, new Object[]{new String[]{}});
                System.out.println("成功运行真棒");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
