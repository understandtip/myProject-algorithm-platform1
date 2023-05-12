package org.project.controller.Myutill;
import java.io.*;
public class MyClassLoader extends ClassLoader{//类加载器  --> 最终实现将字节码转换成类
    private final String classpath;
    public MyClassLoader(){//无参构造器
        this.classpath = System.getProperty("user.dir") + "\\src";
    }
    public MyClassLoader(String classpath){//有参构造器，对classpath进行初始化。
        this.classpath = classpath;
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            //返回类的字节码
            byte[] classDate = getDate(name);
            //defineClass方法将字节码转化为类
            if (classDate != null) return defineClass(name, classDate, 0, classDate.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);//此时classDate == null，所以调用父类findClass方法抛出异常
    }
    //返回类的字节码
    private byte[] getDate(String className) throws IOException {
        String path = classpath + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
        try (InputStream in = new FileInputStream(path); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[2048];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);//写入
            }
            return out.toByteArray();//转为字节数组
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

