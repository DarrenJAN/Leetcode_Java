# Leetcode_Java
## 1. char[]  -> String:
char[] tmp = s.toCharArray();

String str = tmp.toString(); 

String str =  String.valueOf(tmp);

没有多大的区别，但是建议用第二个（题目：49）

## 2. List -> int[]
List<int[] > result = new ArrayList<>();

return result.toArray(new int[result.size()][]);

## 3. sort
### Array sort
int[][] intervals= [[1,3],[8,10],[15,18], [0,9]]

Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

###Linkedlist sort
LinkedList<int[] > tmp = new LinkedList<>();

Collections.sort(res, new Comparator<int[]>(){
public int compare(int[] a , int[] b){
return a[0]-b[0];
}
});