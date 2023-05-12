package org.project.controller.Myutill;

import javax.tools.JavaCompiler;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyCompiler{
    static String outDir = System.getProperty("user.dir") + "\\src";
    public static Boolean compile(String name, String content) {//对类（源文件）进行编译和运行
        //导入InputStream相关包  并修改content内容  使他从data.txt文件中提取输入的测试用例
        content = "import java.io.*;\n"+content;
        int Number_two  =  content.indexOf("{",content.indexOf("{")+1);
        String a="InputStream is = new FileInputStream(\"D:\\\\BaiduNetdiskDownload\\\\workSpace\\\\myProject\\\\data.txt\");";
        String content1 = content;
        //将 a 字符串拼接到content中
        content = content.substring(0,Number_two+1) + "\n"+a+"\n"+ content1.substring(Number_two+1);
        //转换系统输入流 为 目标输入流
        content=content.replace("System.in","is");
        //编译运行
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        StrSrcJavaObject srcObject = new StrSrcJavaObject(name, content);//作为 简化java文件类
        List<StrSrcJavaObject> fileObjects = Collections.singletonList(srcObject);//设置为单例
        String flag = "-d";
        //System.out.println("输出目录为" + outDir);
        Iterable<String> options = Arrays.asList(flag, outDir);//类似于 进入outDir的控制台
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, options, null, fileObjects);
        boolean result = task.call();//真正的执行，并返回结果
        //if (result) System.out.println("Compile it successfully.");
        return result;
    }

    private static class StrSrcJavaObject extends SimpleJavaFileObject {
        private final String content;
        public StrSrcJavaObject(String name, String content) {
            super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
            this.content = content;
        }
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return content;
        }
    }
}

