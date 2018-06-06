package com.bwtc.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 21:03 2018/6/4
 **/
public class ClassUtils {

    public static void main(String[] args){
        System.out.println(System.currentTimeMillis());
        System.out.println(UUID.randomUUID().toString());
    }

    //给一个接口,返回这个接口的所有实现类
    public static List<Class> getAllClassByInterface(Class c){
        List<Class> returnClassList = new ArrayList<Class>();//返回结果
        //如果不是一个接口,则不做处理
        if(c.isInterface()){
            String packageName=c.getPackage().getName();//获取当前的包名
            try{
                List<Class> allClass=getClasses(packageName);//获取当前包下以及子包下的所有类
                //判断是否时同一个接口
                for(int i=0;i<allClass.size();i++){
                    if(c.isAssignableFrom(allClass.get(i))){//判断是不是同一个接口
                        if(!c.equals(allClass.get(i))){//本身不加进去
                            returnClassList.add(allClass.get(i));
                        }
                    }
                }
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return returnClassList;
    }

    //从一个包中查找出所有的类,在jar包中不能查找
    private static List<Class> getClasses(String packageName) throws ClassNotFoundException,IOException{
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
        String path=packageName.replace('.','/');
        Enumeration<URL> resources=classLoader.getResources(path);
        List<File> dirs=new ArrayList<File>();
        while(resources.hasMoreElements()){
            URL resource=resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes=new ArrayList<Class>();
        for(File directory:dirs){
            classes.addAll(fileClasses(directory,packageName));
        }
        return classes;
    }

    private static List<Class> fileClasses(File directory,String packageName) throws  ClassNotFoundException{
        List<Class> classes=new ArrayList<Class>();
        if(!directory.exists()){
            return classes;
        }
        File[] files=directory.listFiles();
        for(File file:files){
            if(file.isDirectory()){
                assert !file.getName().contains(".");
                classes.addAll(fileClasses(file,packageName+"."+file.getName()));
            }else if(file.getName().endsWith(".class")){
                classes.add(Class.forName(packageName+"."+file.getName().substring(0,file.getName().length()-6)));
            }
        }
        return classes;
    }
}
