import java.util.ArrayList;
import java.util.Scanner;

/**
 * 简易学生成绩管理系统
 * ScoreManager_71
 */
public class StudentScore {
    static class Student {
        String id;
        String name;
        double score;
        public Student(String id, String name, double score) {
            this.id = id;
            this.name = name;
            this.score = score;
        }
    }

    private static ArrayList<Student> list = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            System.out.println("=====学生成绩管理系统=====");
            System.out.println("1 添加学生  2 查询成绩  3 删除学生  4 统计平均分  0 退出");
            System.out.print("请输入选择：");
            String op = sc.nextLine();
            switch (op){
                case "1": addStudent();break;
                case "2": query();break;
                case "3": delete();break;
                case "4": calcAvg();break;
                case "0":
                    System.out.println("程序退出");
                    return;
                default:
                    System.out.println("输入错误，请重新选择");
            }
        }
    }

    static void addStudent(){
        System.out.print("学号：");
        String id = sc.nextLine();
        System.out.print("姓名：");
        String name = sc.nextLine();
        System.out.print("成绩：");
        double score = Double.parseDouble(sc.nextLine());
        list.add(new Student(id,name,score));
        System.out.println("添加成功");
    }

    static void query(){
        System.out.print("输入查询学号：");
        String id = sc.nextLine();
        for(Student s : list){
            if(s.id.equals(id)){
                System.out.printf("姓名：%s，成绩：%.2f\n",s.name,s.score);
                return;
            }
        }
        System.out.println("未找到该学生");
    }

    static void delete(){
        System.out.print("输入要删除学号：");
        String id = sc.nextLine();
        for(int i=0;i<list.size();i++){
            if(list.get(i).id.equals(id)){
                list.remove(i);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("未找到该学生");
    }

    static void calcAvg(){
        if(list.isEmpty()){
            System.out.println("暂无学生数据");
            return;
        }
        double sum = 0;
        for(Student s : list) sum += s.score;
        double avg = sum / list.size();
        System.out.printf("全班平均分：%.2f\n",avg);
    }
}
