class Main4
{
    public static void main(String[] args)
    {
        int[] arr={10,-10,11};
        Main4 q=new Main4();
        q.QuickSort(arr,0,arr.length-1);
        for(int i=0;i<=arr.length-1;i++)
        {
            System.out.println(" "+arr[i]+" ");
        }
    }
    void QuickSort(int[] arr,int i,int j)
    {
        int pi =partision(arr,i,j);
        if(i < pi-1){
            QuickSort(arr,i,pi-1);
        }
        if(pi<j){
            QuickSort(arr,pi,j);
        }
    }
    int partision(int[] arr,int k , int l) {
        int pivot = arr[(k + l) / 2];
        int i=k;
        int j=l;
        while (i<=j) {
            while(arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }
        return i;
    }
}
class Test{
    public static void main(String[] args){
            int[] arr={10,-10,11};
            Main4 q=new Main4();
            q.QuickSort(arr,0,arr.length-1);
            for(int i=0;i<arr.length-1;i++)
            {
               System.out.println(" "+arr[i]+" ");
            }
    }
}
