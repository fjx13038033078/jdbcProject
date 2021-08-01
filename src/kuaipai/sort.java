package kuaipai;

import java.util.*;

public class sort {
    public static class kuaiPai {

        public static void main(String[] args) {
//            int[] arr = {7, 2, 3, 65, 6, 8, 66, 22, 1234};
//            kuaipai2(arr, 0, arr.length - 1);
//            System.out.println(Arrays.toString(arr));
//
//            String str =  "fanjiaxing";
//            System.out.println(str);
//            String string = new String("fanjiaxing");
//            System.out.println(string);
//
//            int nums[] = mpsort(arr);
//            System.out.println(Arrays.toString(nums));
//
//            //测试单例模式
//            Singleton object = Singleton.getInstance();
//            object.showMessage();

//            String str1 = "qqeeyygfttgkkj";
//            find(str);

//            ListNode node1 = new ListNode(1);
//            ListNode node2 = new ListNode(2);
//            ListNode node3 = new ListNode(3);
//            ListNode node4 = new ListNode(4);
//            node1.next = node2;
//            node2.next = node3;
//            node3.next = node4;

//            ListNode head = reverseList(node1);
//            System.out.println(head.getVal()+" "+head.next.getVal()+" "+head.next.next.getVal()+" "+head.next.next.next.getVal());

//            ListNode head1 = reverseListByStack(node1);
//            System.out.println(head1.getVal()+" "+head1.next.getVal()+" "+head1.next.next.getVal()+" "+head1.next.next.next.getVal());

//            ListNode head2 = reverseListByDiedai(node1);
//            System.out.println(head2.getVal()+" "+head2.next.getVal()+" "+head2.next.next.getVal()+" "+head2.next.next.next.getVal());

            int[] arrays = {1,2,2,3,4};
            int num1 = search(arrays,2);
            System.out.println(num1);
        }


        public static void quickSort(int[] arr, int start, int end) {

            //当开始位置小于结束位置时（数组有数据）  进行排序  也就是递归入口
            if (start < end) {
                //首先找到基准数  作为比较的标准数  取数组开始位置   从哪里开始  用哪个数当标准数 这个就是标准数
                int stard = arr[start];
                //记录需要进行排序的下标
                int low = start;
                int high = end;

                //循环比对比标准数大和小的数字
                while (low < high) {
                    //如果标准数小于右边的数字  把右边的游标卡尺向左移动
                    while (low < high && stard <= arr[high]) {
                        high--;
                    }
                    //如果标准数大于右边的数字
                    //用高位数字替换左边数字
                    arr[low] = arr[high];
                    //如果左边的数字比标准数小
                    while (low < high && arr[low] <= stard) {
                        low++;
                    }
                    //如果左边的数字比标准数大
                    //用左边数字替换右边数字
                    arr[high] = arr[low];
                }
                //把标准数赋给高或者低所在的元素
                arr[low] = stard;
                //处理所有比标准数小的数字
                quickSort(arr, start, low);
                //处理所有比标准数大的数字
                quickSort(arr, low + 1, end);
            }
        }

        public static void kuaipai1(int[] arr,int start,int end){
            if (start<end){
                int stard = arr[start];
                int low = start;
                int high = end;
                while (low<high){
                    while (low < high && stard<=arr[high]){
                        high--;
                    }
                    arr[low] = arr[high];
                    while (low < high && arr[low]<=stard){
                        low++;
                    }
                    arr[high] = arr[low];
                }
                arr[low] = stard;
                kuaipai1(arr,start,low);
                quickSort(arr,low+1,end);
            }
        }

        public static int[] mpsort(int[] arr){
            int temp = 0;
            for(int i = 0;i<arr.length;i++){
                for (int j = 0;j<arr.length-i-1;j++){
                    if (arr[j]>arr[j+1]){
                        temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
            return arr;
        }

        public  static  void kuaipai2(int[] nums ,int start , int end){
            if(start<end ){
                int stard = nums[start];
                int low = start;
                int high = end;
                while (low<high){
                    while (low<high&&stard<=nums[high]){
                        high--;
                    }
                    nums[low] = nums[high];
                    while (low<high&&stard>=nums[low]){
                        low++;
                    }
                    nums[high] = nums[low];
                }
                nums[low] = stard;
                kuaipai2(nums,start,low);
                kuaipai2(nums,low+1,end);
            }
        }

        public static void find(String str){
            Map<Character,Integer> map = new HashMap<>();
            for (int i = 0;i<str.length();i++){
                char c = str.charAt(i);
                map.put(c,map.getOrDefault(c,0)+1);
            }
            for (int i = 0;i<str.length();i++){
                char c = str.charAt(i);
                int t = map.get(c);
                System.out.println("字符："+c+"出现的次数："+t);
            }
        }

        //头插法反转链表
        public static ListNode reverseList(ListNode head){
             ListNode newHead = null;

             while (head != null) {
                 // 保存下一个
                 ListNode tmp = head.next;

                 // 采用头插法将 head 放入到 newHead 的头部
                 head.next = newHead;
                 newHead = head;

                 // 继续遍历原链表的下一个
                 head = tmp;
             }

             return newHead;
        }

        //用栈反转链表
        public static ListNode reverseListByStack(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            Stack<ListNode> rev = new Stack();//new后面注意
            while (head != null) {
                rev.push(new ListNode(head.val));//new ListNode()
                head = head.next;
            }
            ListNode current = rev.pop();
            ListNode result = current;
            while (!rev.isEmpty()) {
                current.next = rev.pop();
                current = current.next;
            }
            return result;
        }

        public static ListNode reverseListByDiedai(ListNode head){
            ListNode pre = null;
            ListNode cur = head;
            while(cur != null){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

        //二分法查找
        public static int search(int[] nums,int target) {
            int start = 0;
            int end = (nums.length) - 1;
            int mid = (start + end) / 2;
            int index = -1;
            while (true) {
                if (nums[mid] == target) {
                    index = mid;
                    break;
                } else {
                    if (target > nums[mid]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                    mid = (start + end) / 2;
                }
            }
            return index;
        }



    }

      static class ListNode{
        int val;
        ListNode next ;
        ListNode(int x){
            val = x;
        }
        public int getVal(){
            return this.val;
        }
        public ListNode getNext(){
            return this.next;
        }
    }




}
