class Solution:
    def reverse(self,mat:list):
        l = 0
        r = len(mat)-1
        while(l<r):
            t = mat[l]
            mat[l]=mat[r]
            mat[r]=t
            l+=1
            r-=1
    def rotate(self, matrix: List[List[int]]) -> None:
        n=len(matrix)
        for i in range(n):
            for j in range(i+1,n):
                t = matrix[i][j]
                matrix[i][j]=matrix[j][i]
                matrix[j][i]=t
        for j in range(n):
            Solution.reverse(self,matrix[j])
        

        