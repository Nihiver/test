package com.zy.project.stu;
import com.zy.domain.Student;
import java.util.Scanner;
import java.util.ArrayList;


public class StudentManger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //创建集合容器对象
        ArrayList<Student> list = new ArrayList<>();
        lo:while(true){
            //1.搭建主界面菜单
            System.out.println("-------欢迎来到学生管理系统-------");
            System.out.println("1添加学生");
            System.out.println("2删除学生");
            System.out.println("3修改学生" );
            System.out.println("4查看学生");
            System.out.println("5退出");
            System.out.println("请输入您的选择:");
            String choice = sc.next();
            switch(choice){
                case "1":
                    addStudent(list);
                    break;
                case "2":
                    deleteStudent(list);
                    break;
                case "3":
                    updateStudent(list);
                    break;
                case "4":
                    queryStudent(list);
                    break;
                case "5":
                    System.out.println("感谢您的使用");
                    break lo;
                default:
                    System.out.println("您的输入有误");
            }
        }

    }

    public static void updateStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        // 1.给出提示信息
        System.out.println("请输入您要修改的学号");
        // 2.键盘接收要修改的学号
        String id = sc.next();
        // 3.调用getIndex方法，查找该学号在集合中出现的索引位置
        int index = getIndex(list,id);
        // 4.根据索引判断，学号在集合中是否存在
        // 存在:修改
        // 不存在:给出提示
        if(index == -1){
            System.out.println("不存在该学号的学生");
        }else{
            System.out.println("请输入新的姓名：");
            String name = sc.next();
            System.out.println("请输入新的年龄：");
            int age = sc.nextInt();
            System.out.println("请输入新的生日：");
            String birthday = sc.next();
            Student stu = new Student(name,id,age,birthday);
            list.set(index,stu);
            System.out.println("已成功修改");
        }
    }

    public static void deleteStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        // 1.给出提示信息(请输入您要删除的学号)
        System.out.println("请输入您要删除的学号");
        // 2.键盘接收要删除的学号
        String id = sc.next();
        // 3.调用getIndex方法， 查找该学号在集合中出现的索引位置
        int index = getIndex(list,id);
        // 4.根据索引判断，学号在集合中是否存在
        // 存在:删除
        // 不存在:给出提示
        if(index == -1){
            System.out.println("不存在该学号的学生");
        }else{
            list.remove(index);
            System.out.println("已成功删除");
        }
    }

    public static int getIndex(ArrayList<Student> list, String sid){
        //1.假设传入的学号不存在
        int index = -1;
        //2.遍历集合
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            //3,获取每一个学生的学号
            String id = stu.getSid();
            //4.比对
            if(id.equals(sid)){
                index = i;

            }
        }
        return index;
    }

    public static void queryStudent(ArrayList<Student> list) {
        //1.判断集合中是否存在数据
        if(list.size() == 0){
            System.out.println("无信息，请添加后查询");
            return;
        }
        //2.存在，展示表头数据
        System.out.println("学号\t名字\t年龄\t生日");
        //3.遍历集合
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getSid() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getBirthday());

        }
    }

    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        //1.给出录入的提示信息
        String sid;
        while(true){
            System.out.println("请输入学号：");
            sid = sc.next();
            int index = getIndex(list,sid);
            if(index == -1){
                break;
            }else{
                System.out.println("该学号已存在，请重新输入");
            }

        }
        System.out.println("请输入姓名：");
        String name = sc.next();
        System.out.println("请输入年龄：");
        int age = sc.nextInt();
        System.out.println("请输入生日：");
        String birthday = sc.next();
        //2.将录入信息封装为对象
        Student stu = new Student(name,sid,age,birthday);
        //3.将封装好的对象加入集合
        list.add(stu);
        //4，给出成功提示
        System.out.println("添加成功");
    }
}
