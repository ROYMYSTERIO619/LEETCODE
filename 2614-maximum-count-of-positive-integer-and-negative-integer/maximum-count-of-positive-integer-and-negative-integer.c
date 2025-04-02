int maximumCount(int* nums, int numsSize) {
 int pos= 0, neg=0;
 int left =0, right =numsSize -1;
 while(left<=right){
    if(nums[left]<0){
        neg++;
        left++;
    }
    else if(nums[right]>0){
        pos++;
        right--;
    }
    else{
        left++;
        right--;
    }
 }
 if(pos>neg)return pos;
 return neg;
}