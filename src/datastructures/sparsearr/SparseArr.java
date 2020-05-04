package datastructures.sparsearr;

/**
 * @author GoffyGUO
 */
public class SparseArr {
    public static void main(String[] args) {
        //1、定义一个二维数组
        int [][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //2、输出
        System.out.println("原始的二维数组~~~~");
        for(int [] row : chessArr1){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //3、转稀疏数组
        //1、先遍历二维数组，得到非0个数的值
        int sum = 0;
        for(int i = 0; i< chessArr1.length;i++){
            for (int j = 0; j < chessArr1.length; j++){
                if(chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println("sum="+sum);
        //2、创建稀疏数组
        int [][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //3、遍历二维数组，将非0的数组放到稀疏数组中
        // count用于记录是第几个非0数据
        int count  = 0 ;
        for(int i = 0; i< chessArr1.length;i++){
            for (int j = 0; j < chessArr1.length; j++){
                if(chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //4、输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组为~~");
        for(int [] row : sparseArr){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        /**
         * 将稀疏数组恢复为原先的二维数组
         * 先读取稀疏数组的第一行，根据这个数据创建原始的二维数组
         * 然后读取稀疏数组后几行的数据，赋值给原始的二维数据即可
         */
        //1、
        int [][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        //2、在读取稀疏数组后几行的数据（从第2行开始）,并赋给原始的二维数组即可
        for (int i = 1;i<sparseArr.length;i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("恢复后的数组~~");
        for (int [] row : chessArr2){
            for (int item : row){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }

    }
}
