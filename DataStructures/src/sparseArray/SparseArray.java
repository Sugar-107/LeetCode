package sparseArray;

import org.junit.Test;

import java.io.*;

/**
 * 二维数组和稀疏数组
 * @author 程文辉
 */
public class SparseArray {

    /**
     * 0为空
     * 1为黑子
     * 2为蓝子
     */
    @Test
    public void twoDimensionalArrayTo(){
        int[][] array = new int[11][11];
        array[1][2] = 1;
        array[2][3] = 2;
        int sum = 0;
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
                if (anInt!=0){
                    sum++;
                }
            }
            System.out.println();
        }
        //根据总数创建稀疏数组
        //稀疏矩阵的特点总是3列
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (0!=array[i][j]){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array[i][j];
                }
            }
        }
        File file = new File("D:\\尚硅谷课程课件\\javase\\my.txt");
//        int[][] sparseArray1 = sparseArray;




        try  {
            FileOutputStream fileOutputStream = new FileOutputStream(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("稀疏矩阵");
        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
        //根据稀疏矩阵转换为二维数组
        //分行遍历，第一行为二维数组的大小
        int row = 0;
        int column = 0;

        row =  sparseArray[0][0];
        column = sparseArray[0][1];


        int[][] generateArray = new int[row][column];

        int value = 0;
        //从第二行开始是数据的具体位置
        for (int i = 1; i < sparseArray.length; i++) {
//            for (int j = 0; j < sparseArray[i].length; j++) {
                row = sparseArray[i][0];
                column = sparseArray[i][1];
                value = sparseArray[i][2];
//            }
            generateArray[row][column] = value;
        }
        System.out.println("根据稀疏矩阵生成的二维数组");
        for (int[] ints : generateArray) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }

    }

    @Test
    public void saveArray(){
        int[][] array = new int[11][11];

        File file = new File("D:\\尚硅谷课程课件\\javase\\my.txt");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    bufferedWriter.write(array[i][j]+",");
                }
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
//        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
//
//            for (int i = 0; i < array.length; i++) {
//                for (int j = 0; j < array[i].length; j++) {
//                    fileOutputStream.write(array[i][j]);
//                }
////                fileOutputStream.write("/r/n");
//
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void readText() throws FileNotFoundException {
        File file = new File("D:\\尚硅谷课程课件\\javase\\my.txt");

//        FileReader fileReader = new FileReader(file);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String oneLine = bufferedReader.readLine();

            String[] strings = oneLine.split(",");
            int column = Integer.parseInt(strings[0]);
            int row = Integer.parseInt(strings[1]);
            int sum = Integer.parseInt(strings[2]);

            int[][] array = new int[row][column];

            for (int i = 0; i < sum; i++) {
                String value = bufferedReader.readLine();
                String[] values = value.split(",");
                array[Integer.parseInt(values[0])][Integer.parseInt(values[1])] = Integer.parseInt(values[2]);
            }

            System.out.println("数据展示");
            for (int[] ints : array) {
                for (int anInt : ints) {
                    System.out.print(anInt+"\t");
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
