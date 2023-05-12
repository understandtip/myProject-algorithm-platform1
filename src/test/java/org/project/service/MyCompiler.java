package org.project.service;

import javax.tools.JavaCompiler;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyCompiler {
    static String outDir = System.getProperty("user.dir") + "\\src";
    public static Boolean compile(String name, String content) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        StrSrcJavaObject srcObject = new StrSrcJavaObject(name, content);
        List<StrSrcJavaObject> fileObjects = Collections.singletonList(srcObject);
        String flag = "-d";
        System.out.println("输出目录为" + outDir);
        Iterable<String> options = Arrays.asList(flag, outDir);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, options, null, fileObjects);
        boolean result = task.call();
        if (result) System.out.println("Compile it successfully.");
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

