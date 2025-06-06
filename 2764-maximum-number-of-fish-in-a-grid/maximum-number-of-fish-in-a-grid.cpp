class Solution {
    vector<int> dir= {-1,0,1,0,-1};
    bool isValid(int& x, int& y,int& m,int& n){
        return (x>=0 and x<m and y>=0 and y<n);
    }
    int dfs(vector<vector<int>>& grid,vector<vector<bool>>& visited,int& m,int& n,int x,int y){
        int fish_count=grid[x][y];
        for(int i=0;i<4;++i){
            int newX= x + dir[i];
            int newY= y + dir[i+1];
            if(isValid(newX,newY,m,n)and !visited[newX][newY] and grid[newX][newY]>0){
                visited[newX][newY]=true;
                fish_count += dfs(grid,visited,m,n,newX,newY);
            }

            }
            return fish_count;

    }
public:
    int findMaxFish(vector<vector<int>>& grid) {
        int m=grid.size();
        int n =grid[0].size();
        int max_fish=0;
        vector<vector<bool>> visited(m,vector<bool>(n,false));
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(!visited[i][j] and grid[i][j]>0){
                    visited[i][j]=true;
                    max_fish =max(max_fish,dfs(grid,visited,m,n,i,j));

                }
            }
        }
    return max_fish;

    }
};