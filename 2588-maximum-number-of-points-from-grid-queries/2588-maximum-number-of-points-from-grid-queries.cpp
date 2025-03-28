
class Solution {
public:
    vector<int> maxPoints(vector<vector<int>>& grid, vector<int>& queries) {
        int m = grid.size(), n = grid[0].size(), count = 0;
        vector<int> ans(queries.size());
        vector<pair<int,int>> qs;
        for(int i = 0; i < queries.size(); i++)
            qs.emplace_back(queries[i], i);
        sort(qs.begin(), qs.end());

        vector<vector<bool>> seen(m, vector<bool>(n));
        priority_queue<pair<int,pair<int,int>>, vector<pair<int,pair<int,int>>>, greater<>> pq;
        pq.push({grid[0][0], {0, 0}});
        seen[0][0] = true;

        int dirs[4][2] = {{0,1},{1,0},{0,-1},{-1,0}};
        for(auto& [q, idx] : qs) {
            while(!pq.empty() && pq.top().first < q) {
                auto [val, pos] = pq.top(); pq.pop();
                count++;
                int r = pos.first, c = pos.second;
                for(auto& d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && !seen[nr][nc]) {
                        pq.push({grid[nr][nc], {nr, nc}});
                        seen[nr][nc] = true;
                    }
                }
            }
            ans[idx] = count;
        }
        return ans;
    }
};