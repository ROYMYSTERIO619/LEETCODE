class Solution {
public:
    int minimizeXor(int num1, int num2) {
     bitset<32>b1=num1;
     bitset<32>b2=num2;
     bitset<32>b3=0;
     int count=bitset<32>(num2).count();  
     for(int i=31;i>=0 && count>0;i--){
        if(b1[i]==1){
            b3[i]=1;
            count--;
        }
     }
     for (int i = 0; i < 32 && count > 0; i++) {
            if (b3[i] == 0) {
                b3[i] = 1;
                count--;
            }
        }
     return b3.to_ulong();
    }
};