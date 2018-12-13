import java.util.Arrays;

public class Solution {
    /**
     * 删除有序数组中的重复值
     */
    public int removeDuplicates(int[] nums) {
        int[] temp=new int[nums.length];
        int N=0;
        for(int i=0;i<nums.length;i++) {
            if (i != nums.length - 1) {
                if (nums[i] != nums[i + 1])
                    temp[N++] = nums[i];
            } else temp[N++] = nums[i];
        }
        /*for(int i=0;i<N;i++) {
            nums[i]=temp[i];
        }*/
        return N;
    }

    /**
     *
     * @param prices 当天股票价格
     * @return
     */
    public int maxprofit(int[] prices) {
        int difference=0;
        int sum=0;
        for(int i=prices.length-1;i>0;i--) {
            difference=prices[i]-prices[i-1];
            if(difference>0)
                sum+=difference;
        }
        return sum;
    }

    //快速排序
    public int[] quickSort(int[] a) {
        if(a.length==0) throw new ArrayIndexOutOfBoundsException("无意义数组");
        if(a.length==1) return a;
        sort(a,0,a.length-1);
        return a;
    }
    private void exch(int[] a,int i,int j) {
        int temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    private void sort(int[] items,int left,int right) {
        if(left>=right) {insertSort(items,left,right);return;}
        int i=left;
        int j=right;
        int privot=items[(left+right)/2];
        do{
            while(items[i]<privot&&i<right)
                i++;
            while(items[j]>privot&&j>left)
                j--;
            if(i<=j) {
                exch(items, i, j);
                i++;
                j--;
            }
        }while(i<=j);
        if(i<right)
            sort(items,i,right);
        if(j>left)
            sort(items,left,j);
    }
    //插入排序
    private void insertSort(int[] nums) {
    insertSort(nums,0,nums.length-1);
    }

    private void insertSort(int[] nums,int left,int right) {
        int N=right-left+1;
        for(int i=0;i<N;i++) {
            for(int j=i;j>0&&nums[j]<nums[j-1];j--){
                exch(nums, j, j - 1);
            }
        }

    }
    //判断数组中是否存在重复的数据，需要用到上面的快速排序
    public boolean containsDuplicate(int[] nums){
        if(nums.length==0) return false;
        int temp=nums.length;
        quickSort(nums);
        int N=removeDuplicates(nums);
        return temp != N;
    }
    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        quickSort(nums);
        int t=0;
        if(nums[0] !=nums[1]) return nums[0];
        if(nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length-1];
        for(int i=1;i<nums.length-2;i++) {
        if(nums[i] != nums[i+1])
            if(nums[i+1] != nums[i+2] )
                t=nums[i+1];

        }
    return t;
    }
    //求两个数组的交集
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] error={};
        if(nums1.length==0||nums2.length==0) return error;
        int[] temp;
        /*nums1=quickSort(nums1);
        nums2=quickSort(nums2);*/

        if(nums1.length>nums2.length)
            temp=getRepitionPart(nums2,nums1);
        else
            temp=getRepitionPart(nums1,nums2);



        return temp;
    }
    private int[] getRepitionPart(int[] nums1,int[] nums2) {
        int count=0;
        int N=0;
        int t=-1;
        if(nums1.length>nums2.length)
                count=nums2.length;
        else    count=nums1.length;

        int[] temp = new int[count];
        for(int i=0;i<nums1.length;i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (N == count)
                    break;
                if ((nums1[i] ^ nums2[j]) == 0) {
                    if(t!=j) {
                        t = j;
                        temp[N++] = nums1[i];
                        break;
                    }
                    else continue;
                }
            }
        }
        temp=removeZero(temp,N);
        return temp;
    }
    private int[] removeZero(int[] nums,int N) {
        int[] temp;
        temp=new int[N];
        for(int i=0;i<N;i++) {
            if(nums[i]!=0)
                temp[i]=nums[i];
        }
        return temp;
    }
    //判断n是否为3的幂次方
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467%n == 0;

    }
    //把非负整数按位加入数组并在末位加一
    public int[] plusOne(int[] digits) {
        if(digits.length != 1&&digits[0]==0) return digits;

        if(digits[digits.length-1]==9){

            if(digits[0]==9) {
                int[] temp=new int[digits.length+1];
                temp[0]=1;
                for(int i=1;i<temp.length;i++) {
                    temp[i]=0;
                }
                return temp;
            }
            else {
                for (int i = digits.length-1; i >=0; i--) {
                    if (digits[i] != 9) {
                        digits[i] += 1;
                        for (int j = i+1; j <digits.length; j++) {
                            digits[j] = 0;
                        }
                        break;
                    }
                }
                return digits;
            }
        }
        else {
            digits[digits.length - 1] += 1;
            return digits;
        }


    }
    //移动0到数组末尾并保留原有的非零元素顺序且不适用额外内存
    public void moveZeroes(int[] nums) {
    int N=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0) {
                nums[N++]=nums[i];
            }
        }
        while(N<nums.length) {
        nums[N++]=0;
        }

    }
        /*给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。*/
    public int[] twoSum(int[] nums, int target) {
        int[] id=new int[nums.length];
        int[] returnId=new int[2];
        int N=0;
        boolean isNegative=false;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]<0) isNegative=true;
        }
        for(int i=0;i<nums.length;i++) {
            if(!isNegative) {
                if (nums[i] <= target) {
                    nums[N] = nums[i];
                    id[N++] = i;
                }
            }
            else {
                id[N++]=i;
            }
        }
        for(int i=0;i<N;i++) {
            for(int j=i+1;j<N;j++) {
                if(nums[i]>0) {
                    if (nums[i] <= target / 2) {
                        if (nums[j] >= target / 2) {
                            if (nums[i] + nums[j] == target) {
                                returnId[0] = id[i];
                                returnId[1] = id[j];
                                break;
                            }
                        }
                        continue;
                    }
                    if (nums[i] >= target / 2) {
                        if (nums[j] <= target / 2) {
                            if (nums[i] + nums[j] == target) {
                                returnId[0] = id[i];
                                returnId[1] = id[j];
                                break;
                            }
                        }
                        continue;
                    }
                }
                else {
                    if(nums[j]>=target) {
                        if(nums[i]+nums[j]==target) {
                            returnId[0] = id[i];
                            returnId[1] = id[j];
                            break;
                        }
                    }
                }
            }

        }
        return  returnId;
    }
    //判断9X9矩阵是否为一个有效数独
    public boolean isValidSudoku(char[][] board) {
        if(board.length!=9) return false;
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j]=='.') continue;
                for(int k=8;k>=0;k--) {
                    if(board[i][j]==board[i][k])
                        return false;
                }
                for(int k=8;k>=0;k--) {
                    if(board[i][j] == board[k][j])
                        return false;
                }
                for(int k=i+1;k%3!=0;k++) {
                    for(int h=j/3*3;h<j/3*3+3;h++) {
                        if(board[i][j]==board[k][h])
                            return false;
                    }
                }
            }
        }

        return true;
    }
    //在char数组中查找重复
    public boolean isCharArrayHasRepeatition(char[] c) {
        boolean isCharArrayHasRepeatition = false;
        if (c.length == 0) return isCharArrayHasRepeatition;
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 47 && c[i] <= 58) {
                for (int j = 0; j < c.length; j++) {
                    if (c[i] == c[j])
                        isCharArrayHasRepeatition = true;
                }
            }
        }
        return isCharArrayHasRepeatition;
    }
    //交换等长数组
    public void exchaArray(int[] a,int[] b){
        if(a.length!=b.length) return;
        int[] temp;
        temp=a.clone();
        for(int i=0;i<a.length;i++) {
            a[i]=b[i];
            b[i]=temp[i];
        }
    }
    //交换二维数组数据
    public void exchDoubleArray(int[][] a,int i1,int j1,int i2,int j2) {
        int temp=0;
        temp=a[i1][j1];
        a[i1][j1]=a[i2][j2];
        a[i2][j2]=temp;
    }
    //不适用额外空间沿顺时针方向90°旋转一个正方矩阵
    public void rotate(int[][] matrix) {
        if(!isSquare(matrix))
            return;
        int len=matrix.length;
        if(len==1) return;
        int col=len-1;
        int row=0;
            //降序排行，确定对角线位置
            while (row<(len/2)) {
                exchaArray(matrix[row], matrix[col]);
                row++;
                col--;
            }
            for (col = 0; col < len-1; col++) {
                for (row = col+1; row < len; row++) {
                    exchDoubleArray(matrix, col, row, row, col);
                }
            }
    }
    public boolean isSquare(int[][] matrix) {
        int sum=0;
        for(int i=0;i<matrix.length;i++) {
            if (matrix[i].length != matrix.length)
                return false;
            sum^=matrix[i].length;
        }
        if(sum!=0&&sum!=matrix[0].length)
            return false;
        return true;
    }
    public String reverseString(String s) {
        if(s==null) return s;
        char[] c=s.toCharArray();
        int len=c.length;
        for(int i=0;i<len/2;i++) {
            char temp=c[i];
            c[i]=c[len-1-i];
            c[len-1-i]=temp;
        }
        return String.valueOf(c);
    }
    //反转一个32位有符号整数，
    public int reverse(int x) {
        StringBuffer sb=new StringBuffer();
        String s=String.valueOf(x);
        int result =0;

        if(x<0) sb.append(s.charAt(0));
            for (int i = s.length()-1; i > 0; i--) {
                sb.append(s.charAt(i));
            }
            if(x>0) sb.append(s.charAt(0));
            s=sb.toString();
            try {
                result = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return 0;
            }


        return result;
    }
    //计算一个有符号整数的某一位
    /**
     *
     * @param x 有符号整数
     * @param unit 要计算的位数，如十位就填2
     * @return
     */
    public int calculateUnitOfSignedInt(int x,int unit) {
        int n=0;
        int count=1;
        int temp=unit;
        if(x<0) x=0-x;
        while(unit > 0) {
                x-=n;
                 count*=10;
                n=x%count;
                unit--;
        }
        return n/(count/10);
    }
    public static void main(String[] args) {
        int[] n={1,3,-3,0};
        int target=1463847412;
        char[] c1=Character.toChars(49);
        int[][] board={{1,2},{3,4}};
        int len=Integer.toString(target).length();
        char[] c=Integer.toString(target).toCharArray();
       // int N2=board[9].length;
        //char c='9';
        Solution so=new Solution();

       // int N=so.calculateUnitOfSignedInt(target,3);
        //int [] temp=so.intersect(n,n2);
        //so.quickSort(n2);
        //int[] temp=so.twoSum(n,target);
        //s=so.reverseString(s);
        /*for(int i=0;i<c1.length;i++) {
            System.out.println(c1[i]);
            System.out.println();
        }*/
        //System.out.println(Arrays.toString(s));
       System.out.println(so.reverse(target));
    }

}

